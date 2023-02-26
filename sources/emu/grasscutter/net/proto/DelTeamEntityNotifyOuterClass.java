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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DelTeamEntityNotifyOuterClass.class */
public final class DelTeamEntityNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019DelTeamEntityNotify.proto\"?\n\u0013DelTeamEntityNotify\u0012\u000f\n\u0007sceneId\u0018\u000f \u0001(\r\u0012\u0017\n\u000fdelEntityIdList\u0018\u0001 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DelTeamEntityNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DelTeamEntityNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DelTeamEntityNotify_descriptor, new String[]{"SceneId", "DelEntityIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DelTeamEntityNotifyOuterClass$DelTeamEntityNotifyOrBuilder.class */
    public interface DelTeamEntityNotifyOrBuilder extends MessageOrBuilder {
        int getSceneId();

        List<Integer> getDelEntityIdListList();

        int getDelEntityIdListCount();

        int getDelEntityIdList(int i);
    }

    private DelTeamEntityNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DelTeamEntityNotifyOuterClass$DelTeamEntityNotify.class */
    public static final class DelTeamEntityNotify extends GeneratedMessageV3 implements DelTeamEntityNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCENEID_FIELD_NUMBER = 15;
        private int sceneId_;
        public static final int DELENTITYIDLIST_FIELD_NUMBER = 1;
        private Internal.IntList delEntityIdList_;
        private int delEntityIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final DelTeamEntityNotify DEFAULT_INSTANCE = new DelTeamEntityNotify();
        private static final Parser<DelTeamEntityNotify> PARSER = new AbstractParser<DelTeamEntityNotify>() { // from class: emu.grasscutter.net.proto.DelTeamEntityNotifyOuterClass.DelTeamEntityNotify.1
            @Override // com.google.protobuf.Parser
            public DelTeamEntityNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DelTeamEntityNotify(input, extensionRegistry);
            }
        };

        private DelTeamEntityNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.delEntityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private DelTeamEntityNotify() {
            this.delEntityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.delEntityIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DelTeamEntityNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DelTeamEntityNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.delEntityIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.delEntityIdList_.addInt(input.readUInt32());
                                    break;
                                case 10:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.delEntityIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.delEntityIdList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 120:
                                    this.sceneId_ = input.readUInt32();
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
                    this.delEntityIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DelTeamEntityNotifyOuterClass.internal_static_DelTeamEntityNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DelTeamEntityNotifyOuterClass.internal_static_DelTeamEntityNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DelTeamEntityNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DelTeamEntityNotifyOuterClass.DelTeamEntityNotifyOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.DelTeamEntityNotifyOuterClass.DelTeamEntityNotifyOrBuilder
        public List<Integer> getDelEntityIdListList() {
            return this.delEntityIdList_;
        }

        @Override // emu.grasscutter.net.proto.DelTeamEntityNotifyOuterClass.DelTeamEntityNotifyOrBuilder
        public int getDelEntityIdListCount() {
            return this.delEntityIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.DelTeamEntityNotifyOuterClass.DelTeamEntityNotifyOrBuilder
        public int getDelEntityIdList(int index) {
            return this.delEntityIdList_.getInt(index);
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
            if (getDelEntityIdListList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.delEntityIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.delEntityIdList_.size(); i++) {
                output.writeUInt32NoTag(this.delEntityIdList_.getInt(i));
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(15, this.sceneId_);
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
            for (int i = 0; i < this.delEntityIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.delEntityIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getDelEntityIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.delEntityIdListMemoizedSerializedSize = dataSize;
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.sceneId_);
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
            if (!(obj instanceof DelTeamEntityNotify)) {
                return equals(obj);
            }
            DelTeamEntityNotify other = (DelTeamEntityNotify) obj;
            return getSceneId() == other.getSceneId() && getDelEntityIdListList().equals(other.getDelEntityIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getSceneId();
            if (getDelEntityIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getDelEntityIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DelTeamEntityNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DelTeamEntityNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DelTeamEntityNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DelTeamEntityNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DelTeamEntityNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DelTeamEntityNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DelTeamEntityNotify parseFrom(InputStream input) throws IOException {
            return (DelTeamEntityNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DelTeamEntityNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DelTeamEntityNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DelTeamEntityNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (DelTeamEntityNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DelTeamEntityNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DelTeamEntityNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DelTeamEntityNotify parseFrom(CodedInputStream input) throws IOException {
            return (DelTeamEntityNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DelTeamEntityNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DelTeamEntityNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DelTeamEntityNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DelTeamEntityNotifyOuterClass$DelTeamEntityNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DelTeamEntityNotifyOrBuilder {
            private int bitField0_;
            private int sceneId_;
            private Internal.IntList delEntityIdList_ = DelTeamEntityNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return DelTeamEntityNotifyOuterClass.internal_static_DelTeamEntityNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DelTeamEntityNotifyOuterClass.internal_static_DelTeamEntityNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DelTeamEntityNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DelTeamEntityNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.sceneId_ = 0;
                this.delEntityIdList_ = DelTeamEntityNotify.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DelTeamEntityNotifyOuterClass.internal_static_DelTeamEntityNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DelTeamEntityNotify getDefaultInstanceForType() {
                return DelTeamEntityNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DelTeamEntityNotify build() {
                DelTeamEntityNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DelTeamEntityNotify buildPartial() {
                DelTeamEntityNotify result = new DelTeamEntityNotify(this);
                int i = this.bitField0_;
                result.sceneId_ = this.sceneId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.delEntityIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.delEntityIdList_ = this.delEntityIdList_;
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
                if (other instanceof DelTeamEntityNotify) {
                    return mergeFrom((DelTeamEntityNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DelTeamEntityNotify other) {
                if (other == DelTeamEntityNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (!other.delEntityIdList_.isEmpty()) {
                    if (this.delEntityIdList_.isEmpty()) {
                        this.delEntityIdList_ = other.delEntityIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureDelEntityIdListIsMutable();
                        this.delEntityIdList_.addAll(other.delEntityIdList_);
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
                DelTeamEntityNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = DelTeamEntityNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DelTeamEntityNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DelTeamEntityNotifyOuterClass.DelTeamEntityNotifyOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
                onChanged();
                return this;
            }

            private void ensureDelEntityIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.delEntityIdList_ = DelTeamEntityNotify.mutableCopy(this.delEntityIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DelTeamEntityNotifyOuterClass.DelTeamEntityNotifyOrBuilder
            public List<Integer> getDelEntityIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.delEntityIdList_) : this.delEntityIdList_;
            }

            @Override // emu.grasscutter.net.proto.DelTeamEntityNotifyOuterClass.DelTeamEntityNotifyOrBuilder
            public int getDelEntityIdListCount() {
                return this.delEntityIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.DelTeamEntityNotifyOuterClass.DelTeamEntityNotifyOrBuilder
            public int getDelEntityIdList(int index) {
                return this.delEntityIdList_.getInt(index);
            }

            public Builder setDelEntityIdList(int index, int value) {
                ensureDelEntityIdListIsMutable();
                this.delEntityIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addDelEntityIdList(int value) {
                ensureDelEntityIdListIsMutable();
                this.delEntityIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllDelEntityIdList(Iterable<? extends Integer> values) {
                ensureDelEntityIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.delEntityIdList_);
                onChanged();
                return this;
            }

            public Builder clearDelEntityIdList() {
                this.delEntityIdList_ = DelTeamEntityNotify.emptyIntList();
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

        public static DelTeamEntityNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DelTeamEntityNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DelTeamEntityNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DelTeamEntityNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
