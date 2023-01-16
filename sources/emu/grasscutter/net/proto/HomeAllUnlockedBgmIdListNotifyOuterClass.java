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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeAllUnlockedBgmIdListNotifyOuterClass.class */
public final class HomeAllUnlockedBgmIdListNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$HomeAllUnlockedBgmIdListNotify.proto\"B\n\u001eHomeAllUnlockedBgmIdListNotify\u0012 \n\u0018all_unlocked_bgm_id_list\u0018\u000e \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_HomeAllUnlockedBgmIdListNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_HomeAllUnlockedBgmIdListNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f756x901ceb18 = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeAllUnlockedBgmIdListNotify_descriptor, new String[]{"AllUnlockedBgmIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeAllUnlockedBgmIdListNotifyOuterClass$HomeAllUnlockedBgmIdListNotifyOrBuilder.class */
    public interface HomeAllUnlockedBgmIdListNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getAllUnlockedBgmIdListList();

        int getAllUnlockedBgmIdListCount();

        int getAllUnlockedBgmIdList(int i);
    }

    private HomeAllUnlockedBgmIdListNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeAllUnlockedBgmIdListNotifyOuterClass$HomeAllUnlockedBgmIdListNotify.class */
    public static final class HomeAllUnlockedBgmIdListNotify extends GeneratedMessageV3 implements HomeAllUnlockedBgmIdListNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ALL_UNLOCKED_BGM_ID_LIST_FIELD_NUMBER = 14;
        private Internal.IntList allUnlockedBgmIdList_;
        private int allUnlockedBgmIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final HomeAllUnlockedBgmIdListNotify DEFAULT_INSTANCE = new HomeAllUnlockedBgmIdListNotify();
        private static final Parser<HomeAllUnlockedBgmIdListNotify> PARSER = new AbstractParser<HomeAllUnlockedBgmIdListNotify>() { // from class: emu.grasscutter.net.proto.HomeAllUnlockedBgmIdListNotifyOuterClass.HomeAllUnlockedBgmIdListNotify.1
            @Override // com.google.protobuf.Parser
            public HomeAllUnlockedBgmIdListNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeAllUnlockedBgmIdListNotify(input, extensionRegistry);
            }
        };

        private HomeAllUnlockedBgmIdListNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.allUnlockedBgmIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private HomeAllUnlockedBgmIdListNotify() {
            this.allUnlockedBgmIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.allUnlockedBgmIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeAllUnlockedBgmIdListNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeAllUnlockedBgmIdListNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 112:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.allUnlockedBgmIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.allUnlockedBgmIdList_.addInt(input.readUInt32());
                                    break;
                                case 114:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.allUnlockedBgmIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.allUnlockedBgmIdList_.addInt(input.readUInt32());
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
                    this.allUnlockedBgmIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeAllUnlockedBgmIdListNotifyOuterClass.internal_static_HomeAllUnlockedBgmIdListNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeAllUnlockedBgmIdListNotifyOuterClass.f756x901ceb18.ensureFieldAccessorsInitialized(HomeAllUnlockedBgmIdListNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeAllUnlockedBgmIdListNotifyOuterClass.HomeAllUnlockedBgmIdListNotifyOrBuilder
        public List<Integer> getAllUnlockedBgmIdListList() {
            return this.allUnlockedBgmIdList_;
        }

        @Override // emu.grasscutter.net.proto.HomeAllUnlockedBgmIdListNotifyOuterClass.HomeAllUnlockedBgmIdListNotifyOrBuilder
        public int getAllUnlockedBgmIdListCount() {
            return this.allUnlockedBgmIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeAllUnlockedBgmIdListNotifyOuterClass.HomeAllUnlockedBgmIdListNotifyOrBuilder
        public int getAllUnlockedBgmIdList(int index) {
            return this.allUnlockedBgmIdList_.getInt(index);
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
            if (getAllUnlockedBgmIdListList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.allUnlockedBgmIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.allUnlockedBgmIdList_.size(); i++) {
                output.writeUInt32NoTag(this.allUnlockedBgmIdList_.getInt(i));
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
            for (int i = 0; i < this.allUnlockedBgmIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.allUnlockedBgmIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getAllUnlockedBgmIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.allUnlockedBgmIdListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HomeAllUnlockedBgmIdListNotify)) {
                return equals(obj);
            }
            HomeAllUnlockedBgmIdListNotify other = (HomeAllUnlockedBgmIdListNotify) obj;
            return getAllUnlockedBgmIdListList().equals(other.getAllUnlockedBgmIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAllUnlockedBgmIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getAllUnlockedBgmIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeAllUnlockedBgmIdListNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeAllUnlockedBgmIdListNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeAllUnlockedBgmIdListNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeAllUnlockedBgmIdListNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeAllUnlockedBgmIdListNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeAllUnlockedBgmIdListNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeAllUnlockedBgmIdListNotify parseFrom(InputStream input) throws IOException {
            return (HomeAllUnlockedBgmIdListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeAllUnlockedBgmIdListNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeAllUnlockedBgmIdListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeAllUnlockedBgmIdListNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeAllUnlockedBgmIdListNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeAllUnlockedBgmIdListNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeAllUnlockedBgmIdListNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeAllUnlockedBgmIdListNotify parseFrom(CodedInputStream input) throws IOException {
            return (HomeAllUnlockedBgmIdListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeAllUnlockedBgmIdListNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeAllUnlockedBgmIdListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeAllUnlockedBgmIdListNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeAllUnlockedBgmIdListNotifyOuterClass$HomeAllUnlockedBgmIdListNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeAllUnlockedBgmIdListNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList allUnlockedBgmIdList_ = HomeAllUnlockedBgmIdListNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeAllUnlockedBgmIdListNotifyOuterClass.internal_static_HomeAllUnlockedBgmIdListNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeAllUnlockedBgmIdListNotifyOuterClass.f756x901ceb18.ensureFieldAccessorsInitialized(HomeAllUnlockedBgmIdListNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeAllUnlockedBgmIdListNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.allUnlockedBgmIdList_ = HomeAllUnlockedBgmIdListNotify.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeAllUnlockedBgmIdListNotifyOuterClass.internal_static_HomeAllUnlockedBgmIdListNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeAllUnlockedBgmIdListNotify getDefaultInstanceForType() {
                return HomeAllUnlockedBgmIdListNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeAllUnlockedBgmIdListNotify build() {
                HomeAllUnlockedBgmIdListNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeAllUnlockedBgmIdListNotify buildPartial() {
                HomeAllUnlockedBgmIdListNotify result = new HomeAllUnlockedBgmIdListNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.allUnlockedBgmIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.allUnlockedBgmIdList_ = this.allUnlockedBgmIdList_;
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
                if (other instanceof HomeAllUnlockedBgmIdListNotify) {
                    return mergeFrom((HomeAllUnlockedBgmIdListNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeAllUnlockedBgmIdListNotify other) {
                if (other == HomeAllUnlockedBgmIdListNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.allUnlockedBgmIdList_.isEmpty()) {
                    if (this.allUnlockedBgmIdList_.isEmpty()) {
                        this.allUnlockedBgmIdList_ = other.allUnlockedBgmIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAllUnlockedBgmIdListIsMutable();
                        this.allUnlockedBgmIdList_.addAll(other.allUnlockedBgmIdList_);
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
                HomeAllUnlockedBgmIdListNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeAllUnlockedBgmIdListNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeAllUnlockedBgmIdListNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAllUnlockedBgmIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.allUnlockedBgmIdList_ = HomeAllUnlockedBgmIdListNotify.mutableCopy(this.allUnlockedBgmIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeAllUnlockedBgmIdListNotifyOuterClass.HomeAllUnlockedBgmIdListNotifyOrBuilder
            public List<Integer> getAllUnlockedBgmIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.allUnlockedBgmIdList_) : this.allUnlockedBgmIdList_;
            }

            @Override // emu.grasscutter.net.proto.HomeAllUnlockedBgmIdListNotifyOuterClass.HomeAllUnlockedBgmIdListNotifyOrBuilder
            public int getAllUnlockedBgmIdListCount() {
                return this.allUnlockedBgmIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.HomeAllUnlockedBgmIdListNotifyOuterClass.HomeAllUnlockedBgmIdListNotifyOrBuilder
            public int getAllUnlockedBgmIdList(int index) {
                return this.allUnlockedBgmIdList_.getInt(index);
            }

            public Builder setAllUnlockedBgmIdList(int index, int value) {
                ensureAllUnlockedBgmIdListIsMutable();
                this.allUnlockedBgmIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addAllUnlockedBgmIdList(int value) {
                ensureAllUnlockedBgmIdListIsMutable();
                this.allUnlockedBgmIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllAllUnlockedBgmIdList(Iterable<? extends Integer> values) {
                ensureAllUnlockedBgmIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.allUnlockedBgmIdList_);
                onChanged();
                return this;
            }

            public Builder clearAllUnlockedBgmIdList() {
                this.allUnlockedBgmIdList_ = HomeAllUnlockedBgmIdListNotify.emptyIntList();
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

        public static HomeAllUnlockedBgmIdListNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeAllUnlockedBgmIdListNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeAllUnlockedBgmIdListNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeAllUnlockedBgmIdListNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
