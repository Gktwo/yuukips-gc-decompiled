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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeModuleSeenReqOuterClass.class */
public final class HomeModuleSeenReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017HomeModuleSeenReq.proto\"-\n\u0011HomeModuleSeenReq\u0012\u0018\n\u0010seenModuleIdList\u0018\u0004 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_HomeModuleSeenReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeModuleSeenReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeModuleSeenReq_descriptor, new String[]{"SeenModuleIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeModuleSeenReqOuterClass$HomeModuleSeenReqOrBuilder.class */
    public interface HomeModuleSeenReqOrBuilder extends MessageOrBuilder {
        List<Integer> getSeenModuleIdListList();

        int getSeenModuleIdListCount();

        int getSeenModuleIdList(int i);
    }

    private HomeModuleSeenReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeModuleSeenReqOuterClass$HomeModuleSeenReq.class */
    public static final class HomeModuleSeenReq extends GeneratedMessageV3 implements HomeModuleSeenReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SEENMODULEIDLIST_FIELD_NUMBER = 4;
        private Internal.IntList seenModuleIdList_;
        private int seenModuleIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final HomeModuleSeenReq DEFAULT_INSTANCE = new HomeModuleSeenReq();
        private static final Parser<HomeModuleSeenReq> PARSER = new AbstractParser<HomeModuleSeenReq>() { // from class: emu.grasscutter.net.proto.HomeModuleSeenReqOuterClass.HomeModuleSeenReq.1
            @Override // com.google.protobuf.Parser
            public HomeModuleSeenReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeModuleSeenReq(input, extensionRegistry);
            }
        };

        private HomeModuleSeenReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.seenModuleIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private HomeModuleSeenReq() {
            this.seenModuleIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.seenModuleIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeModuleSeenReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeModuleSeenReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.seenModuleIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.seenModuleIdList_.addInt(input.readUInt32());
                                    break;
                                case 34:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.seenModuleIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.seenModuleIdList_.addInt(input.readUInt32());
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
                    this.seenModuleIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeModuleSeenReqOuterClass.internal_static_HomeModuleSeenReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeModuleSeenReqOuterClass.internal_static_HomeModuleSeenReq_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeModuleSeenReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeModuleSeenReqOuterClass.HomeModuleSeenReqOrBuilder
        public List<Integer> getSeenModuleIdListList() {
            return this.seenModuleIdList_;
        }

        @Override // emu.grasscutter.net.proto.HomeModuleSeenReqOuterClass.HomeModuleSeenReqOrBuilder
        public int getSeenModuleIdListCount() {
            return this.seenModuleIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeModuleSeenReqOuterClass.HomeModuleSeenReqOrBuilder
        public int getSeenModuleIdList(int index) {
            return this.seenModuleIdList_.getInt(index);
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
            if (getSeenModuleIdListList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.seenModuleIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.seenModuleIdList_.size(); i++) {
                output.writeUInt32NoTag(this.seenModuleIdList_.getInt(i));
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
            for (int i = 0; i < this.seenModuleIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.seenModuleIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getSeenModuleIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.seenModuleIdListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HomeModuleSeenReq)) {
                return equals(obj);
            }
            HomeModuleSeenReq other = (HomeModuleSeenReq) obj;
            return getSeenModuleIdListList().equals(other.getSeenModuleIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getSeenModuleIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getSeenModuleIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeModuleSeenReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeModuleSeenReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeModuleSeenReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeModuleSeenReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeModuleSeenReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeModuleSeenReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeModuleSeenReq parseFrom(InputStream input) throws IOException {
            return (HomeModuleSeenReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeModuleSeenReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeModuleSeenReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeModuleSeenReq parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeModuleSeenReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeModuleSeenReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeModuleSeenReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeModuleSeenReq parseFrom(CodedInputStream input) throws IOException {
            return (HomeModuleSeenReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeModuleSeenReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeModuleSeenReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeModuleSeenReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeModuleSeenReqOuterClass$HomeModuleSeenReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeModuleSeenReqOrBuilder {
            private int bitField0_;
            private Internal.IntList seenModuleIdList_ = HomeModuleSeenReq.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeModuleSeenReqOuterClass.internal_static_HomeModuleSeenReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeModuleSeenReqOuterClass.internal_static_HomeModuleSeenReq_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeModuleSeenReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeModuleSeenReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.seenModuleIdList_ = HomeModuleSeenReq.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeModuleSeenReqOuterClass.internal_static_HomeModuleSeenReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeModuleSeenReq getDefaultInstanceForType() {
                return HomeModuleSeenReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeModuleSeenReq build() {
                HomeModuleSeenReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeModuleSeenReq buildPartial() {
                HomeModuleSeenReq result = new HomeModuleSeenReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.seenModuleIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.seenModuleIdList_ = this.seenModuleIdList_;
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
                if (other instanceof HomeModuleSeenReq) {
                    return mergeFrom((HomeModuleSeenReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeModuleSeenReq other) {
                if (other == HomeModuleSeenReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.seenModuleIdList_.isEmpty()) {
                    if (this.seenModuleIdList_.isEmpty()) {
                        this.seenModuleIdList_ = other.seenModuleIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureSeenModuleIdListIsMutable();
                        this.seenModuleIdList_.addAll(other.seenModuleIdList_);
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
                HomeModuleSeenReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeModuleSeenReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeModuleSeenReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureSeenModuleIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.seenModuleIdList_ = HomeModuleSeenReq.mutableCopy(this.seenModuleIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeModuleSeenReqOuterClass.HomeModuleSeenReqOrBuilder
            public List<Integer> getSeenModuleIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.seenModuleIdList_) : this.seenModuleIdList_;
            }

            @Override // emu.grasscutter.net.proto.HomeModuleSeenReqOuterClass.HomeModuleSeenReqOrBuilder
            public int getSeenModuleIdListCount() {
                return this.seenModuleIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.HomeModuleSeenReqOuterClass.HomeModuleSeenReqOrBuilder
            public int getSeenModuleIdList(int index) {
                return this.seenModuleIdList_.getInt(index);
            }

            public Builder setSeenModuleIdList(int index, int value) {
                ensureSeenModuleIdListIsMutable();
                this.seenModuleIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addSeenModuleIdList(int value) {
                ensureSeenModuleIdListIsMutable();
                this.seenModuleIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllSeenModuleIdList(Iterable<? extends Integer> values) {
                ensureSeenModuleIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.seenModuleIdList_);
                onChanged();
                return this;
            }

            public Builder clearSeenModuleIdList() {
                this.seenModuleIdList_ = HomeModuleSeenReq.emptyIntList();
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

        public static HomeModuleSeenReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeModuleSeenReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeModuleSeenReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeModuleSeenReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
