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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeNewUnlockedBgmIdListNotifyOuterClass.class */
public final class HomeNewUnlockedBgmIdListNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$HomeNewUnlockedBgmIdListNotify.proto\"B\n\u001eHomeNewUnlockedBgmIdListNotify\u0012 \n\u0018new_unlocked_bgm_id_list\u0018\u0001 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_HomeNewUnlockedBgmIdListNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_HomeNewUnlockedBgmIdListNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f762xef9fac57 = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeNewUnlockedBgmIdListNotify_descriptor, new String[]{"NewUnlockedBgmIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeNewUnlockedBgmIdListNotifyOuterClass$HomeNewUnlockedBgmIdListNotifyOrBuilder.class */
    public interface HomeNewUnlockedBgmIdListNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getNewUnlockedBgmIdListList();

        int getNewUnlockedBgmIdListCount();

        int getNewUnlockedBgmIdList(int i);
    }

    private HomeNewUnlockedBgmIdListNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeNewUnlockedBgmIdListNotifyOuterClass$HomeNewUnlockedBgmIdListNotify.class */
    public static final class HomeNewUnlockedBgmIdListNotify extends GeneratedMessageV3 implements HomeNewUnlockedBgmIdListNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int NEW_UNLOCKED_BGM_ID_LIST_FIELD_NUMBER = 1;
        private Internal.IntList newUnlockedBgmIdList_;
        private int newUnlockedBgmIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final HomeNewUnlockedBgmIdListNotify DEFAULT_INSTANCE = new HomeNewUnlockedBgmIdListNotify();
        private static final Parser<HomeNewUnlockedBgmIdListNotify> PARSER = new AbstractParser<HomeNewUnlockedBgmIdListNotify>() { // from class: emu.grasscutter.net.proto.HomeNewUnlockedBgmIdListNotifyOuterClass.HomeNewUnlockedBgmIdListNotify.1
            @Override // com.google.protobuf.Parser
            public HomeNewUnlockedBgmIdListNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeNewUnlockedBgmIdListNotify(input, extensionRegistry);
            }
        };

        private HomeNewUnlockedBgmIdListNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.newUnlockedBgmIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private HomeNewUnlockedBgmIdListNotify() {
            this.newUnlockedBgmIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.newUnlockedBgmIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeNewUnlockedBgmIdListNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeNewUnlockedBgmIdListNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.newUnlockedBgmIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.newUnlockedBgmIdList_.addInt(input.readUInt32());
                                    break;
                                case 10:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.newUnlockedBgmIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.newUnlockedBgmIdList_.addInt(input.readUInt32());
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
                    this.newUnlockedBgmIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeNewUnlockedBgmIdListNotifyOuterClass.internal_static_HomeNewUnlockedBgmIdListNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeNewUnlockedBgmIdListNotifyOuterClass.f762xef9fac57.ensureFieldAccessorsInitialized(HomeNewUnlockedBgmIdListNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeNewUnlockedBgmIdListNotifyOuterClass.HomeNewUnlockedBgmIdListNotifyOrBuilder
        public List<Integer> getNewUnlockedBgmIdListList() {
            return this.newUnlockedBgmIdList_;
        }

        @Override // emu.grasscutter.net.proto.HomeNewUnlockedBgmIdListNotifyOuterClass.HomeNewUnlockedBgmIdListNotifyOrBuilder
        public int getNewUnlockedBgmIdListCount() {
            return this.newUnlockedBgmIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeNewUnlockedBgmIdListNotifyOuterClass.HomeNewUnlockedBgmIdListNotifyOrBuilder
        public int getNewUnlockedBgmIdList(int index) {
            return this.newUnlockedBgmIdList_.getInt(index);
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
            if (getNewUnlockedBgmIdListList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.newUnlockedBgmIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.newUnlockedBgmIdList_.size(); i++) {
                output.writeUInt32NoTag(this.newUnlockedBgmIdList_.getInt(i));
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
            for (int i = 0; i < this.newUnlockedBgmIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.newUnlockedBgmIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getNewUnlockedBgmIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.newUnlockedBgmIdListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HomeNewUnlockedBgmIdListNotify)) {
                return equals(obj);
            }
            HomeNewUnlockedBgmIdListNotify other = (HomeNewUnlockedBgmIdListNotify) obj;
            return getNewUnlockedBgmIdListList().equals(other.getNewUnlockedBgmIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getNewUnlockedBgmIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getNewUnlockedBgmIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeNewUnlockedBgmIdListNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeNewUnlockedBgmIdListNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeNewUnlockedBgmIdListNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeNewUnlockedBgmIdListNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeNewUnlockedBgmIdListNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeNewUnlockedBgmIdListNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeNewUnlockedBgmIdListNotify parseFrom(InputStream input) throws IOException {
            return (HomeNewUnlockedBgmIdListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeNewUnlockedBgmIdListNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeNewUnlockedBgmIdListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeNewUnlockedBgmIdListNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeNewUnlockedBgmIdListNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeNewUnlockedBgmIdListNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeNewUnlockedBgmIdListNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeNewUnlockedBgmIdListNotify parseFrom(CodedInputStream input) throws IOException {
            return (HomeNewUnlockedBgmIdListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeNewUnlockedBgmIdListNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeNewUnlockedBgmIdListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeNewUnlockedBgmIdListNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeNewUnlockedBgmIdListNotifyOuterClass$HomeNewUnlockedBgmIdListNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeNewUnlockedBgmIdListNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList newUnlockedBgmIdList_ = HomeNewUnlockedBgmIdListNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeNewUnlockedBgmIdListNotifyOuterClass.internal_static_HomeNewUnlockedBgmIdListNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeNewUnlockedBgmIdListNotifyOuterClass.f762xef9fac57.ensureFieldAccessorsInitialized(HomeNewUnlockedBgmIdListNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeNewUnlockedBgmIdListNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.newUnlockedBgmIdList_ = HomeNewUnlockedBgmIdListNotify.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeNewUnlockedBgmIdListNotifyOuterClass.internal_static_HomeNewUnlockedBgmIdListNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeNewUnlockedBgmIdListNotify getDefaultInstanceForType() {
                return HomeNewUnlockedBgmIdListNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeNewUnlockedBgmIdListNotify build() {
                HomeNewUnlockedBgmIdListNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeNewUnlockedBgmIdListNotify buildPartial() {
                HomeNewUnlockedBgmIdListNotify result = new HomeNewUnlockedBgmIdListNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.newUnlockedBgmIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.newUnlockedBgmIdList_ = this.newUnlockedBgmIdList_;
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
                if (other instanceof HomeNewUnlockedBgmIdListNotify) {
                    return mergeFrom((HomeNewUnlockedBgmIdListNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeNewUnlockedBgmIdListNotify other) {
                if (other == HomeNewUnlockedBgmIdListNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.newUnlockedBgmIdList_.isEmpty()) {
                    if (this.newUnlockedBgmIdList_.isEmpty()) {
                        this.newUnlockedBgmIdList_ = other.newUnlockedBgmIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureNewUnlockedBgmIdListIsMutable();
                        this.newUnlockedBgmIdList_.addAll(other.newUnlockedBgmIdList_);
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
                HomeNewUnlockedBgmIdListNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeNewUnlockedBgmIdListNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeNewUnlockedBgmIdListNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureNewUnlockedBgmIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.newUnlockedBgmIdList_ = HomeNewUnlockedBgmIdListNotify.mutableCopy(this.newUnlockedBgmIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeNewUnlockedBgmIdListNotifyOuterClass.HomeNewUnlockedBgmIdListNotifyOrBuilder
            public List<Integer> getNewUnlockedBgmIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.newUnlockedBgmIdList_) : this.newUnlockedBgmIdList_;
            }

            @Override // emu.grasscutter.net.proto.HomeNewUnlockedBgmIdListNotifyOuterClass.HomeNewUnlockedBgmIdListNotifyOrBuilder
            public int getNewUnlockedBgmIdListCount() {
                return this.newUnlockedBgmIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.HomeNewUnlockedBgmIdListNotifyOuterClass.HomeNewUnlockedBgmIdListNotifyOrBuilder
            public int getNewUnlockedBgmIdList(int index) {
                return this.newUnlockedBgmIdList_.getInt(index);
            }

            public Builder setNewUnlockedBgmIdList(int index, int value) {
                ensureNewUnlockedBgmIdListIsMutable();
                this.newUnlockedBgmIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addNewUnlockedBgmIdList(int value) {
                ensureNewUnlockedBgmIdListIsMutable();
                this.newUnlockedBgmIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllNewUnlockedBgmIdList(Iterable<? extends Integer> values) {
                ensureNewUnlockedBgmIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.newUnlockedBgmIdList_);
                onChanged();
                return this;
            }

            public Builder clearNewUnlockedBgmIdList() {
                this.newUnlockedBgmIdList_ = HomeNewUnlockedBgmIdListNotify.emptyIntList();
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

        public static HomeNewUnlockedBgmIdListNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeNewUnlockedBgmIdListNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeNewUnlockedBgmIdListNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeNewUnlockedBgmIdListNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
