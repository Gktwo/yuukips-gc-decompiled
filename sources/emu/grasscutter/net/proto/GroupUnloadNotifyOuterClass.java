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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GroupUnloadNotifyOuterClass.class */
public final class GroupUnloadNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017GroupUnloadNotify.proto\"'\n\u0011GroupUnloadNotify\u0012\u0012\n\ngroup_list\u0018\u0006 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GroupUnloadNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GroupUnloadNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GroupUnloadNotify_descriptor, new String[]{"GroupList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GroupUnloadNotifyOuterClass$GroupUnloadNotifyOrBuilder.class */
    public interface GroupUnloadNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getGroupListList();

        int getGroupListCount();

        int getGroupList(int i);
    }

    private GroupUnloadNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GroupUnloadNotifyOuterClass$GroupUnloadNotify.class */
    public static final class GroupUnloadNotify extends GeneratedMessageV3 implements GroupUnloadNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GROUP_LIST_FIELD_NUMBER = 6;
        private Internal.IntList groupList_;
        private int groupListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final GroupUnloadNotify DEFAULT_INSTANCE = new GroupUnloadNotify();
        private static final Parser<GroupUnloadNotify> PARSER = new AbstractParser<GroupUnloadNotify>() { // from class: emu.grasscutter.net.proto.GroupUnloadNotifyOuterClass.GroupUnloadNotify.1
            @Override // com.google.protobuf.Parser
            public GroupUnloadNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GroupUnloadNotify(input, extensionRegistry);
            }
        };

        private GroupUnloadNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.groupListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GroupUnloadNotify() {
            this.groupListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.groupList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GroupUnloadNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GroupUnloadNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.groupList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.groupList_.addInt(input.readUInt32());
                                    break;
                                case 50:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.groupList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.groupList_.addInt(input.readUInt32());
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
                    this.groupList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GroupUnloadNotifyOuterClass.internal_static_GroupUnloadNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GroupUnloadNotifyOuterClass.internal_static_GroupUnloadNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(GroupUnloadNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GroupUnloadNotifyOuterClass.GroupUnloadNotifyOrBuilder
        public List<Integer> getGroupListList() {
            return this.groupList_;
        }

        @Override // emu.grasscutter.net.proto.GroupUnloadNotifyOuterClass.GroupUnloadNotifyOrBuilder
        public int getGroupListCount() {
            return this.groupList_.size();
        }

        @Override // emu.grasscutter.net.proto.GroupUnloadNotifyOuterClass.GroupUnloadNotifyOrBuilder
        public int getGroupList(int index) {
            return this.groupList_.getInt(index);
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
            if (getGroupListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.groupListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.groupList_.size(); i++) {
                output.writeUInt32NoTag(this.groupList_.getInt(i));
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
            for (int i = 0; i < this.groupList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.groupList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getGroupListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.groupListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GroupUnloadNotify)) {
                return equals(obj);
            }
            GroupUnloadNotify other = (GroupUnloadNotify) obj;
            return getGroupListList().equals(other.getGroupListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getGroupListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getGroupListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GroupUnloadNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GroupUnloadNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GroupUnloadNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GroupUnloadNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GroupUnloadNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GroupUnloadNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GroupUnloadNotify parseFrom(InputStream input) throws IOException {
            return (GroupUnloadNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GroupUnloadNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GroupUnloadNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GroupUnloadNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (GroupUnloadNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GroupUnloadNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GroupUnloadNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GroupUnloadNotify parseFrom(CodedInputStream input) throws IOException {
            return (GroupUnloadNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GroupUnloadNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GroupUnloadNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GroupUnloadNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GroupUnloadNotifyOuterClass$GroupUnloadNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GroupUnloadNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList groupList_ = GroupUnloadNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GroupUnloadNotifyOuterClass.internal_static_GroupUnloadNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GroupUnloadNotifyOuterClass.internal_static_GroupUnloadNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(GroupUnloadNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GroupUnloadNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.groupList_ = GroupUnloadNotify.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GroupUnloadNotifyOuterClass.internal_static_GroupUnloadNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GroupUnloadNotify getDefaultInstanceForType() {
                return GroupUnloadNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GroupUnloadNotify build() {
                GroupUnloadNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GroupUnloadNotify buildPartial() {
                GroupUnloadNotify result = new GroupUnloadNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.groupList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.groupList_ = this.groupList_;
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
                if (other instanceof GroupUnloadNotify) {
                    return mergeFrom((GroupUnloadNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GroupUnloadNotify other) {
                if (other == GroupUnloadNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.groupList_.isEmpty()) {
                    if (this.groupList_.isEmpty()) {
                        this.groupList_ = other.groupList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureGroupListIsMutable();
                        this.groupList_.addAll(other.groupList_);
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
                GroupUnloadNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = GroupUnloadNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GroupUnloadNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureGroupListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.groupList_ = GroupUnloadNotify.mutableCopy(this.groupList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GroupUnloadNotifyOuterClass.GroupUnloadNotifyOrBuilder
            public List<Integer> getGroupListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.groupList_) : this.groupList_;
            }

            @Override // emu.grasscutter.net.proto.GroupUnloadNotifyOuterClass.GroupUnloadNotifyOrBuilder
            public int getGroupListCount() {
                return this.groupList_.size();
            }

            @Override // emu.grasscutter.net.proto.GroupUnloadNotifyOuterClass.GroupUnloadNotifyOrBuilder
            public int getGroupList(int index) {
                return this.groupList_.getInt(index);
            }

            public Builder setGroupList(int index, int value) {
                ensureGroupListIsMutable();
                this.groupList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addGroupList(int value) {
                ensureGroupListIsMutable();
                this.groupList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllGroupList(Iterable<? extends Integer> values) {
                ensureGroupListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.groupList_);
                onChanged();
                return this;
            }

            public Builder clearGroupList() {
                this.groupList_ = GroupUnloadNotify.emptyIntList();
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

        public static GroupUnloadNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GroupUnloadNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GroupUnloadNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GroupUnloadNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
