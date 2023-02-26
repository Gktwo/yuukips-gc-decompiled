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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockedFurnitureSuiteDataNotifyOuterClass.class */
public final class UnlockedFurnitureSuiteDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n&UnlockedFurnitureSuiteDataNotify.proto\"O\n UnlockedFurnitureSuiteDataNotify\u0012\u001c\n\u0014furnitureSuiteIdList\u0018\f \u0003(\r\u0012\r\n\u0005isAll\u0018\t \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_UnlockedFurnitureSuiteDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_UnlockedFurnitureSuiteDataNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f871x7999ef01 = new GeneratedMessageV3.FieldAccessorTable(internal_static_UnlockedFurnitureSuiteDataNotify_descriptor, new String[]{"FurnitureSuiteIdList", "IsAll"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockedFurnitureSuiteDataNotifyOuterClass$UnlockedFurnitureSuiteDataNotifyOrBuilder.class */
    public interface UnlockedFurnitureSuiteDataNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getFurnitureSuiteIdListList();

        int getFurnitureSuiteIdListCount();

        int getFurnitureSuiteIdList(int i);

        boolean getIsAll();
    }

    private UnlockedFurnitureSuiteDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockedFurnitureSuiteDataNotifyOuterClass$UnlockedFurnitureSuiteDataNotify.class */
    public static final class UnlockedFurnitureSuiteDataNotify extends GeneratedMessageV3 implements UnlockedFurnitureSuiteDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FURNITURESUITEIDLIST_FIELD_NUMBER = 12;
        private Internal.IntList furnitureSuiteIdList_;
        private int furnitureSuiteIdListMemoizedSerializedSize;
        public static final int ISALL_FIELD_NUMBER = 9;
        private boolean isAll_;
        private byte memoizedIsInitialized;
        private static final UnlockedFurnitureSuiteDataNotify DEFAULT_INSTANCE = new UnlockedFurnitureSuiteDataNotify();
        private static final Parser<UnlockedFurnitureSuiteDataNotify> PARSER = new AbstractParser<UnlockedFurnitureSuiteDataNotify>() { // from class: emu.grasscutter.net.proto.UnlockedFurnitureSuiteDataNotifyOuterClass.UnlockedFurnitureSuiteDataNotify.1
            @Override // com.google.protobuf.Parser
            public UnlockedFurnitureSuiteDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UnlockedFurnitureSuiteDataNotify(input, extensionRegistry);
            }
        };

        private UnlockedFurnitureSuiteDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.furnitureSuiteIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private UnlockedFurnitureSuiteDataNotify() {
            this.furnitureSuiteIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.furnitureSuiteIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UnlockedFurnitureSuiteDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UnlockedFurnitureSuiteDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.isAll_ = input.readBool();
                                    break;
                                case 96:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.furnitureSuiteIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.furnitureSuiteIdList_.addInt(input.readUInt32());
                                    break;
                                case 98:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.furnitureSuiteIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.furnitureSuiteIdList_.addInt(input.readUInt32());
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.furnitureSuiteIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return UnlockedFurnitureSuiteDataNotifyOuterClass.internal_static_UnlockedFurnitureSuiteDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UnlockedFurnitureSuiteDataNotifyOuterClass.f871x7999ef01.ensureFieldAccessorsInitialized(UnlockedFurnitureSuiteDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.UnlockedFurnitureSuiteDataNotifyOuterClass.UnlockedFurnitureSuiteDataNotifyOrBuilder
        public List<Integer> getFurnitureSuiteIdListList() {
            return this.furnitureSuiteIdList_;
        }

        @Override // emu.grasscutter.net.proto.UnlockedFurnitureSuiteDataNotifyOuterClass.UnlockedFurnitureSuiteDataNotifyOrBuilder
        public int getFurnitureSuiteIdListCount() {
            return this.furnitureSuiteIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.UnlockedFurnitureSuiteDataNotifyOuterClass.UnlockedFurnitureSuiteDataNotifyOrBuilder
        public int getFurnitureSuiteIdList(int index) {
            return this.furnitureSuiteIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.UnlockedFurnitureSuiteDataNotifyOuterClass.UnlockedFurnitureSuiteDataNotifyOrBuilder
        public boolean getIsAll() {
            return this.isAll_;
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
            if (this.isAll_) {
                output.writeBool(9, this.isAll_);
            }
            if (getFurnitureSuiteIdListList().size() > 0) {
                output.writeUInt32NoTag(98);
                output.writeUInt32NoTag(this.furnitureSuiteIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.furnitureSuiteIdList_.size(); i++) {
                output.writeUInt32NoTag(this.furnitureSuiteIdList_.getInt(i));
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
            if (this.isAll_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(9, this.isAll_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.furnitureSuiteIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.furnitureSuiteIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getFurnitureSuiteIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.furnitureSuiteIdListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UnlockedFurnitureSuiteDataNotify)) {
                return equals(obj);
            }
            UnlockedFurnitureSuiteDataNotify other = (UnlockedFurnitureSuiteDataNotify) obj;
            return getFurnitureSuiteIdListList().equals(other.getFurnitureSuiteIdListList()) && getIsAll() == other.getIsAll() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getFurnitureSuiteIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getFurnitureSuiteIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + Internal.hashBoolean(getIsAll()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static UnlockedFurnitureSuiteDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnlockedFurnitureSuiteDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnlockedFurnitureSuiteDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnlockedFurnitureSuiteDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnlockedFurnitureSuiteDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnlockedFurnitureSuiteDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnlockedFurnitureSuiteDataNotify parseFrom(InputStream input) throws IOException {
            return (UnlockedFurnitureSuiteDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UnlockedFurnitureSuiteDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnlockedFurnitureSuiteDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UnlockedFurnitureSuiteDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (UnlockedFurnitureSuiteDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UnlockedFurnitureSuiteDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnlockedFurnitureSuiteDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UnlockedFurnitureSuiteDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (UnlockedFurnitureSuiteDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UnlockedFurnitureSuiteDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnlockedFurnitureSuiteDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UnlockedFurnitureSuiteDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockedFurnitureSuiteDataNotifyOuterClass$UnlockedFurnitureSuiteDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UnlockedFurnitureSuiteDataNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList furnitureSuiteIdList_ = UnlockedFurnitureSuiteDataNotify.emptyIntList();
            private boolean isAll_;

            public static final Descriptors.Descriptor getDescriptor() {
                return UnlockedFurnitureSuiteDataNotifyOuterClass.internal_static_UnlockedFurnitureSuiteDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UnlockedFurnitureSuiteDataNotifyOuterClass.f871x7999ef01.ensureFieldAccessorsInitialized(UnlockedFurnitureSuiteDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UnlockedFurnitureSuiteDataNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.furnitureSuiteIdList_ = UnlockedFurnitureSuiteDataNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.isAll_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UnlockedFurnitureSuiteDataNotifyOuterClass.internal_static_UnlockedFurnitureSuiteDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UnlockedFurnitureSuiteDataNotify getDefaultInstanceForType() {
                return UnlockedFurnitureSuiteDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UnlockedFurnitureSuiteDataNotify build() {
                UnlockedFurnitureSuiteDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UnlockedFurnitureSuiteDataNotify buildPartial() {
                UnlockedFurnitureSuiteDataNotify result = new UnlockedFurnitureSuiteDataNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.furnitureSuiteIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.furnitureSuiteIdList_ = this.furnitureSuiteIdList_;
                result.isAll_ = this.isAll_;
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
                if (other instanceof UnlockedFurnitureSuiteDataNotify) {
                    return mergeFrom((UnlockedFurnitureSuiteDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UnlockedFurnitureSuiteDataNotify other) {
                if (other == UnlockedFurnitureSuiteDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.furnitureSuiteIdList_.isEmpty()) {
                    if (this.furnitureSuiteIdList_.isEmpty()) {
                        this.furnitureSuiteIdList_ = other.furnitureSuiteIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFurnitureSuiteIdListIsMutable();
                        this.furnitureSuiteIdList_.addAll(other.furnitureSuiteIdList_);
                    }
                    onChanged();
                }
                if (other.getIsAll()) {
                    setIsAll(other.getIsAll());
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
                UnlockedFurnitureSuiteDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = UnlockedFurnitureSuiteDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UnlockedFurnitureSuiteDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureFurnitureSuiteIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.furnitureSuiteIdList_ = UnlockedFurnitureSuiteDataNotify.mutableCopy(this.furnitureSuiteIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.UnlockedFurnitureSuiteDataNotifyOuterClass.UnlockedFurnitureSuiteDataNotifyOrBuilder
            public List<Integer> getFurnitureSuiteIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.furnitureSuiteIdList_) : this.furnitureSuiteIdList_;
            }

            @Override // emu.grasscutter.net.proto.UnlockedFurnitureSuiteDataNotifyOuterClass.UnlockedFurnitureSuiteDataNotifyOrBuilder
            public int getFurnitureSuiteIdListCount() {
                return this.furnitureSuiteIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.UnlockedFurnitureSuiteDataNotifyOuterClass.UnlockedFurnitureSuiteDataNotifyOrBuilder
            public int getFurnitureSuiteIdList(int index) {
                return this.furnitureSuiteIdList_.getInt(index);
            }

            public Builder setFurnitureSuiteIdList(int index, int value) {
                ensureFurnitureSuiteIdListIsMutable();
                this.furnitureSuiteIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFurnitureSuiteIdList(int value) {
                ensureFurnitureSuiteIdListIsMutable();
                this.furnitureSuiteIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFurnitureSuiteIdList(Iterable<? extends Integer> values) {
                ensureFurnitureSuiteIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.furnitureSuiteIdList_);
                onChanged();
                return this;
            }

            public Builder clearFurnitureSuiteIdList() {
                this.furnitureSuiteIdList_ = UnlockedFurnitureSuiteDataNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UnlockedFurnitureSuiteDataNotifyOuterClass.UnlockedFurnitureSuiteDataNotifyOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static UnlockedFurnitureSuiteDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UnlockedFurnitureSuiteDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UnlockedFurnitureSuiteDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UnlockedFurnitureSuiteDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
