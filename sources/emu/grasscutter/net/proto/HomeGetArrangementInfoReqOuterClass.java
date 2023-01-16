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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeGetArrangementInfoReqOuterClass.class */
public final class HomeGetArrangementInfoReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fHomeGetArrangementInfoReq.proto\"2\n\u0019HomeGetArrangementInfoReq\u0012\u0015\n\rscene_id_list\u0018\u0006 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_HomeGetArrangementInfoReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeGetArrangementInfoReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeGetArrangementInfoReq_descriptor, new String[]{"SceneIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeGetArrangementInfoReqOuterClass$HomeGetArrangementInfoReqOrBuilder.class */
    public interface HomeGetArrangementInfoReqOrBuilder extends MessageOrBuilder {
        List<Integer> getSceneIdListList();

        int getSceneIdListCount();

        int getSceneIdList(int i);
    }

    private HomeGetArrangementInfoReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeGetArrangementInfoReqOuterClass$HomeGetArrangementInfoReq.class */
    public static final class HomeGetArrangementInfoReq extends GeneratedMessageV3 implements HomeGetArrangementInfoReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCENE_ID_LIST_FIELD_NUMBER = 6;
        private Internal.IntList sceneIdList_;
        private int sceneIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final HomeGetArrangementInfoReq DEFAULT_INSTANCE = new HomeGetArrangementInfoReq();
        private static final Parser<HomeGetArrangementInfoReq> PARSER = new AbstractParser<HomeGetArrangementInfoReq>() { // from class: emu.grasscutter.net.proto.HomeGetArrangementInfoReqOuterClass.HomeGetArrangementInfoReq.1
            @Override // com.google.protobuf.Parser
            public HomeGetArrangementInfoReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeGetArrangementInfoReq(input, extensionRegistry);
            }
        };

        private HomeGetArrangementInfoReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.sceneIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private HomeGetArrangementInfoReq() {
            this.sceneIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.sceneIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeGetArrangementInfoReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeGetArrangementInfoReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.sceneIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.sceneIdList_.addInt(input.readUInt32());
                                    break;
                                case 50:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.sceneIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.sceneIdList_.addInt(input.readUInt32());
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
                    this.sceneIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeGetArrangementInfoReqOuterClass.internal_static_HomeGetArrangementInfoReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeGetArrangementInfoReqOuterClass.internal_static_HomeGetArrangementInfoReq_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeGetArrangementInfoReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoReqOuterClass.HomeGetArrangementInfoReqOrBuilder
        public List<Integer> getSceneIdListList() {
            return this.sceneIdList_;
        }

        @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoReqOuterClass.HomeGetArrangementInfoReqOrBuilder
        public int getSceneIdListCount() {
            return this.sceneIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoReqOuterClass.HomeGetArrangementInfoReqOrBuilder
        public int getSceneIdList(int index) {
            return this.sceneIdList_.getInt(index);
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
            if (getSceneIdListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.sceneIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.sceneIdList_.size(); i++) {
                output.writeUInt32NoTag(this.sceneIdList_.getInt(i));
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
            for (int i = 0; i < this.sceneIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.sceneIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getSceneIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.sceneIdListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HomeGetArrangementInfoReq)) {
                return equals(obj);
            }
            HomeGetArrangementInfoReq other = (HomeGetArrangementInfoReq) obj;
            return getSceneIdListList().equals(other.getSceneIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getSceneIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getSceneIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeGetArrangementInfoReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeGetArrangementInfoReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeGetArrangementInfoReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeGetArrangementInfoReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeGetArrangementInfoReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeGetArrangementInfoReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeGetArrangementInfoReq parseFrom(InputStream input) throws IOException {
            return (HomeGetArrangementInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeGetArrangementInfoReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeGetArrangementInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeGetArrangementInfoReq parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeGetArrangementInfoReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeGetArrangementInfoReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeGetArrangementInfoReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeGetArrangementInfoReq parseFrom(CodedInputStream input) throws IOException {
            return (HomeGetArrangementInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeGetArrangementInfoReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeGetArrangementInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeGetArrangementInfoReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeGetArrangementInfoReqOuterClass$HomeGetArrangementInfoReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeGetArrangementInfoReqOrBuilder {
            private int bitField0_;
            private Internal.IntList sceneIdList_ = HomeGetArrangementInfoReq.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeGetArrangementInfoReqOuterClass.internal_static_HomeGetArrangementInfoReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeGetArrangementInfoReqOuterClass.internal_static_HomeGetArrangementInfoReq_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeGetArrangementInfoReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeGetArrangementInfoReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.sceneIdList_ = HomeGetArrangementInfoReq.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeGetArrangementInfoReqOuterClass.internal_static_HomeGetArrangementInfoReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeGetArrangementInfoReq getDefaultInstanceForType() {
                return HomeGetArrangementInfoReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeGetArrangementInfoReq build() {
                HomeGetArrangementInfoReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeGetArrangementInfoReq buildPartial() {
                HomeGetArrangementInfoReq result = new HomeGetArrangementInfoReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.sceneIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.sceneIdList_ = this.sceneIdList_;
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
                if (other instanceof HomeGetArrangementInfoReq) {
                    return mergeFrom((HomeGetArrangementInfoReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeGetArrangementInfoReq other) {
                if (other == HomeGetArrangementInfoReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.sceneIdList_.isEmpty()) {
                    if (this.sceneIdList_.isEmpty()) {
                        this.sceneIdList_ = other.sceneIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureSceneIdListIsMutable();
                        this.sceneIdList_.addAll(other.sceneIdList_);
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
                HomeGetArrangementInfoReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeGetArrangementInfoReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeGetArrangementInfoReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureSceneIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.sceneIdList_ = HomeGetArrangementInfoReq.mutableCopy(this.sceneIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoReqOuterClass.HomeGetArrangementInfoReqOrBuilder
            public List<Integer> getSceneIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.sceneIdList_) : this.sceneIdList_;
            }

            @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoReqOuterClass.HomeGetArrangementInfoReqOrBuilder
            public int getSceneIdListCount() {
                return this.sceneIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoReqOuterClass.HomeGetArrangementInfoReqOrBuilder
            public int getSceneIdList(int index) {
                return this.sceneIdList_.getInt(index);
            }

            public Builder setSceneIdList(int index, int value) {
                ensureSceneIdListIsMutable();
                this.sceneIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addSceneIdList(int value) {
                ensureSceneIdListIsMutable();
                this.sceneIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllSceneIdList(Iterable<? extends Integer> values) {
                ensureSceneIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.sceneIdList_);
                onChanged();
                return this;
            }

            public Builder clearSceneIdList() {
                this.sceneIdList_ = HomeGetArrangementInfoReq.emptyIntList();
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

        public static HomeGetArrangementInfoReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeGetArrangementInfoReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeGetArrangementInfoReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeGetArrangementInfoReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
