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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeModuleSeenRspOuterClass.class */
public final class HomeModuleSeenRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017HomeModuleSeenRsp.proto\">\n\u0011HomeModuleSeenRsp\u0012\u000f\n\u0007retcode\u0018\t \u0001(\u0005\u0012\u0018\n\u0010seenModuleIdList\u0018\f \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_HomeModuleSeenRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeModuleSeenRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeModuleSeenRsp_descriptor, new String[]{"Retcode", "SeenModuleIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeModuleSeenRspOuterClass$HomeModuleSeenRspOrBuilder.class */
    public interface HomeModuleSeenRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        List<Integer> getSeenModuleIdListList();

        int getSeenModuleIdListCount();

        int getSeenModuleIdList(int i);
    }

    private HomeModuleSeenRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeModuleSeenRspOuterClass$HomeModuleSeenRsp.class */
    public static final class HomeModuleSeenRsp extends GeneratedMessageV3 implements HomeModuleSeenRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 9;
        private int retcode_;
        public static final int SEENMODULEIDLIST_FIELD_NUMBER = 12;
        private Internal.IntList seenModuleIdList_;
        private int seenModuleIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final HomeModuleSeenRsp DEFAULT_INSTANCE = new HomeModuleSeenRsp();
        private static final Parser<HomeModuleSeenRsp> PARSER = new AbstractParser<HomeModuleSeenRsp>() { // from class: emu.grasscutter.net.proto.HomeModuleSeenRspOuterClass.HomeModuleSeenRsp.1
            @Override // com.google.protobuf.Parser
            public HomeModuleSeenRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeModuleSeenRsp(input, extensionRegistry);
            }
        };

        private HomeModuleSeenRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.seenModuleIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private HomeModuleSeenRsp() {
            this.seenModuleIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.seenModuleIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeModuleSeenRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeModuleSeenRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 96:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.seenModuleIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.seenModuleIdList_.addInt(input.readUInt32());
                                    break;
                                case 98:
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
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
            return HomeModuleSeenRspOuterClass.internal_static_HomeModuleSeenRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeModuleSeenRspOuterClass.internal_static_HomeModuleSeenRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeModuleSeenRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeModuleSeenRspOuterClass.HomeModuleSeenRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.HomeModuleSeenRspOuterClass.HomeModuleSeenRspOrBuilder
        public List<Integer> getSeenModuleIdListList() {
            return this.seenModuleIdList_;
        }

        @Override // emu.grasscutter.net.proto.HomeModuleSeenRspOuterClass.HomeModuleSeenRspOrBuilder
        public int getSeenModuleIdListCount() {
            return this.seenModuleIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeModuleSeenRspOuterClass.HomeModuleSeenRspOrBuilder
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
            if (this.retcode_ != 0) {
                output.writeInt32(9, this.retcode_);
            }
            if (getSeenModuleIdListList().size() > 0) {
                output.writeUInt32NoTag(98);
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
            int size2 = 0;
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(9, this.retcode_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.seenModuleIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.seenModuleIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getSeenModuleIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.seenModuleIdListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HomeModuleSeenRsp)) {
                return equals(obj);
            }
            HomeModuleSeenRsp other = (HomeModuleSeenRsp) obj;
            return getRetcode() == other.getRetcode() && getSeenModuleIdListList().equals(other.getSeenModuleIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getRetcode();
            if (getSeenModuleIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getSeenModuleIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeModuleSeenRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeModuleSeenRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeModuleSeenRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeModuleSeenRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeModuleSeenRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeModuleSeenRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeModuleSeenRsp parseFrom(InputStream input) throws IOException {
            return (HomeModuleSeenRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeModuleSeenRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeModuleSeenRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeModuleSeenRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeModuleSeenRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeModuleSeenRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeModuleSeenRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeModuleSeenRsp parseFrom(CodedInputStream input) throws IOException {
            return (HomeModuleSeenRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeModuleSeenRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeModuleSeenRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeModuleSeenRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeModuleSeenRspOuterClass$HomeModuleSeenRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeModuleSeenRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private Internal.IntList seenModuleIdList_ = HomeModuleSeenRsp.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeModuleSeenRspOuterClass.internal_static_HomeModuleSeenRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeModuleSeenRspOuterClass.internal_static_HomeModuleSeenRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeModuleSeenRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeModuleSeenRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.seenModuleIdList_ = HomeModuleSeenRsp.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeModuleSeenRspOuterClass.internal_static_HomeModuleSeenRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeModuleSeenRsp getDefaultInstanceForType() {
                return HomeModuleSeenRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeModuleSeenRsp build() {
                HomeModuleSeenRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeModuleSeenRsp buildPartial() {
                HomeModuleSeenRsp result = new HomeModuleSeenRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof HomeModuleSeenRsp) {
                    return mergeFrom((HomeModuleSeenRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeModuleSeenRsp other) {
                if (other == HomeModuleSeenRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                HomeModuleSeenRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeModuleSeenRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeModuleSeenRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeModuleSeenRspOuterClass.HomeModuleSeenRspOrBuilder
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

            private void ensureSeenModuleIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.seenModuleIdList_ = HomeModuleSeenRsp.mutableCopy(this.seenModuleIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeModuleSeenRspOuterClass.HomeModuleSeenRspOrBuilder
            public List<Integer> getSeenModuleIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.seenModuleIdList_) : this.seenModuleIdList_;
            }

            @Override // emu.grasscutter.net.proto.HomeModuleSeenRspOuterClass.HomeModuleSeenRspOrBuilder
            public int getSeenModuleIdListCount() {
                return this.seenModuleIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.HomeModuleSeenRspOuterClass.HomeModuleSeenRspOrBuilder
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
                this.seenModuleIdList_ = HomeModuleSeenRsp.emptyIntList();
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

        public static HomeModuleSeenRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeModuleSeenRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeModuleSeenRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeModuleSeenRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
