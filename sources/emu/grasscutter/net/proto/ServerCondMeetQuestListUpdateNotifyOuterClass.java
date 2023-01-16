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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerCondMeetQuestListUpdateNotifyOuterClass.class */
public final class ServerCondMeetQuestListUpdateNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n)ServerCondMeetQuestListUpdateNotify.proto\"[\n#ServerCondMeetQuestListUpdateNotify\u0012\u0019\n\u0011add_quest_id_list\u0018\n \u0003(\r\u0012\u0019\n\u0011del_quest_id_list\u0018\u0004 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ServerCondMeetQuestListUpdateNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_ServerCondMeetQuestListUpdateNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f871x424b9035 = new GeneratedMessageV3.FieldAccessorTable(internal_static_ServerCondMeetQuestListUpdateNotify_descriptor, new String[]{"AddQuestIdList", "DelQuestIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerCondMeetQuestListUpdateNotifyOuterClass$ServerCondMeetQuestListUpdateNotifyOrBuilder.class */
    public interface ServerCondMeetQuestListUpdateNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getAddQuestIdListList();

        int getAddQuestIdListCount();

        int getAddQuestIdList(int i);

        List<Integer> getDelQuestIdListList();

        int getDelQuestIdListCount();

        int getDelQuestIdList(int i);
    }

    private ServerCondMeetQuestListUpdateNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerCondMeetQuestListUpdateNotifyOuterClass$ServerCondMeetQuestListUpdateNotify.class */
    public static final class ServerCondMeetQuestListUpdateNotify extends GeneratedMessageV3 implements ServerCondMeetQuestListUpdateNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ADD_QUEST_ID_LIST_FIELD_NUMBER = 10;
        private Internal.IntList addQuestIdList_;
        private int addQuestIdListMemoizedSerializedSize;
        public static final int DEL_QUEST_ID_LIST_FIELD_NUMBER = 4;
        private Internal.IntList delQuestIdList_;
        private int delQuestIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final ServerCondMeetQuestListUpdateNotify DEFAULT_INSTANCE = new ServerCondMeetQuestListUpdateNotify();
        private static final Parser<ServerCondMeetQuestListUpdateNotify> PARSER = new AbstractParser<ServerCondMeetQuestListUpdateNotify>() { // from class: emu.grasscutter.net.proto.ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotify.1
            @Override // com.google.protobuf.Parser
            public ServerCondMeetQuestListUpdateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ServerCondMeetQuestListUpdateNotify(input, extensionRegistry);
            }
        };

        private ServerCondMeetQuestListUpdateNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.addQuestIdListMemoizedSerializedSize = -1;
            this.delQuestIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ServerCondMeetQuestListUpdateNotify() {
            this.addQuestIdListMemoizedSerializedSize = -1;
            this.delQuestIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.addQuestIdList_ = emptyIntList();
            this.delQuestIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ServerCondMeetQuestListUpdateNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x013c */
        private ServerCondMeetQuestListUpdateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.delQuestIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.delQuestIdList_.addInt(input.readUInt32());
                                break;
                            case 34:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.delQuestIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.delQuestIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.addQuestIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.addQuestIdList_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.addQuestIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.addQuestIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.delQuestIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.addQuestIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ServerCondMeetQuestListUpdateNotifyOuterClass.internal_static_ServerCondMeetQuestListUpdateNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ServerCondMeetQuestListUpdateNotifyOuterClass.f871x424b9035.ensureFieldAccessorsInitialized(ServerCondMeetQuestListUpdateNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotifyOrBuilder
        public List<Integer> getAddQuestIdListList() {
            return this.addQuestIdList_;
        }

        @Override // emu.grasscutter.net.proto.ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotifyOrBuilder
        public int getAddQuestIdListCount() {
            return this.addQuestIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotifyOrBuilder
        public int getAddQuestIdList(int index) {
            return this.addQuestIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotifyOrBuilder
        public List<Integer> getDelQuestIdListList() {
            return this.delQuestIdList_;
        }

        @Override // emu.grasscutter.net.proto.ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotifyOrBuilder
        public int getDelQuestIdListCount() {
            return this.delQuestIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotifyOrBuilder
        public int getDelQuestIdList(int index) {
            return this.delQuestIdList_.getInt(index);
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
            if (getDelQuestIdListList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.delQuestIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.delQuestIdList_.size(); i++) {
                output.writeUInt32NoTag(this.delQuestIdList_.getInt(i));
            }
            if (getAddQuestIdListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.addQuestIdListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.addQuestIdList_.size(); i2++) {
                output.writeUInt32NoTag(this.addQuestIdList_.getInt(i2));
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
            for (int i = 0; i < this.delQuestIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.delQuestIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getDelQuestIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.delQuestIdListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.addQuestIdList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.addQuestIdList_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getAddQuestIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.addQuestIdListMemoizedSerializedSize = dataSize2;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ServerCondMeetQuestListUpdateNotify)) {
                return equals(obj);
            }
            ServerCondMeetQuestListUpdateNotify other = (ServerCondMeetQuestListUpdateNotify) obj;
            return getAddQuestIdListList().equals(other.getAddQuestIdListList()) && getDelQuestIdListList().equals(other.getDelQuestIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAddQuestIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getAddQuestIdListList().hashCode();
            }
            if (getDelQuestIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getDelQuestIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ServerCondMeetQuestListUpdateNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerCondMeetQuestListUpdateNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerCondMeetQuestListUpdateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerCondMeetQuestListUpdateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerCondMeetQuestListUpdateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerCondMeetQuestListUpdateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerCondMeetQuestListUpdateNotify parseFrom(InputStream input) throws IOException {
            return (ServerCondMeetQuestListUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ServerCondMeetQuestListUpdateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerCondMeetQuestListUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ServerCondMeetQuestListUpdateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ServerCondMeetQuestListUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ServerCondMeetQuestListUpdateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerCondMeetQuestListUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ServerCondMeetQuestListUpdateNotify parseFrom(CodedInputStream input) throws IOException {
            return (ServerCondMeetQuestListUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ServerCondMeetQuestListUpdateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerCondMeetQuestListUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ServerCondMeetQuestListUpdateNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerCondMeetQuestListUpdateNotifyOuterClass$ServerCondMeetQuestListUpdateNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ServerCondMeetQuestListUpdateNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList addQuestIdList_ = ServerCondMeetQuestListUpdateNotify.emptyIntList();
            private Internal.IntList delQuestIdList_ = ServerCondMeetQuestListUpdateNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ServerCondMeetQuestListUpdateNotifyOuterClass.internal_static_ServerCondMeetQuestListUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ServerCondMeetQuestListUpdateNotifyOuterClass.f871x424b9035.ensureFieldAccessorsInitialized(ServerCondMeetQuestListUpdateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ServerCondMeetQuestListUpdateNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.addQuestIdList_ = ServerCondMeetQuestListUpdateNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.delQuestIdList_ = ServerCondMeetQuestListUpdateNotify.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ServerCondMeetQuestListUpdateNotifyOuterClass.internal_static_ServerCondMeetQuestListUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ServerCondMeetQuestListUpdateNotify getDefaultInstanceForType() {
                return ServerCondMeetQuestListUpdateNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServerCondMeetQuestListUpdateNotify build() {
                ServerCondMeetQuestListUpdateNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServerCondMeetQuestListUpdateNotify buildPartial() {
                ServerCondMeetQuestListUpdateNotify result = new ServerCondMeetQuestListUpdateNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.addQuestIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.addQuestIdList_ = this.addQuestIdList_;
                if ((this.bitField0_ & 2) != 0) {
                    this.delQuestIdList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.delQuestIdList_ = this.delQuestIdList_;
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
                if (other instanceof ServerCondMeetQuestListUpdateNotify) {
                    return mergeFrom((ServerCondMeetQuestListUpdateNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ServerCondMeetQuestListUpdateNotify other) {
                if (other == ServerCondMeetQuestListUpdateNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.addQuestIdList_.isEmpty()) {
                    if (this.addQuestIdList_.isEmpty()) {
                        this.addQuestIdList_ = other.addQuestIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAddQuestIdListIsMutable();
                        this.addQuestIdList_.addAll(other.addQuestIdList_);
                    }
                    onChanged();
                }
                if (!other.delQuestIdList_.isEmpty()) {
                    if (this.delQuestIdList_.isEmpty()) {
                        this.delQuestIdList_ = other.delQuestIdList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureDelQuestIdListIsMutable();
                        this.delQuestIdList_.addAll(other.delQuestIdList_);
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
                ServerCondMeetQuestListUpdateNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ServerCondMeetQuestListUpdateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ServerCondMeetQuestListUpdateNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAddQuestIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.addQuestIdList_ = ServerCondMeetQuestListUpdateNotify.mutableCopy(this.addQuestIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotifyOrBuilder
            public List<Integer> getAddQuestIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.addQuestIdList_) : this.addQuestIdList_;
            }

            @Override // emu.grasscutter.net.proto.ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotifyOrBuilder
            public int getAddQuestIdListCount() {
                return this.addQuestIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotifyOrBuilder
            public int getAddQuestIdList(int index) {
                return this.addQuestIdList_.getInt(index);
            }

            public Builder setAddQuestIdList(int index, int value) {
                ensureAddQuestIdListIsMutable();
                this.addQuestIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addAddQuestIdList(int value) {
                ensureAddQuestIdListIsMutable();
                this.addQuestIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllAddQuestIdList(Iterable<? extends Integer> values) {
                ensureAddQuestIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.addQuestIdList_);
                onChanged();
                return this;
            }

            public Builder clearAddQuestIdList() {
                this.addQuestIdList_ = ServerCondMeetQuestListUpdateNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureDelQuestIdListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.delQuestIdList_ = ServerCondMeetQuestListUpdateNotify.mutableCopy(this.delQuestIdList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotifyOrBuilder
            public List<Integer> getDelQuestIdListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.delQuestIdList_) : this.delQuestIdList_;
            }

            @Override // emu.grasscutter.net.proto.ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotifyOrBuilder
            public int getDelQuestIdListCount() {
                return this.delQuestIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotifyOrBuilder
            public int getDelQuestIdList(int index) {
                return this.delQuestIdList_.getInt(index);
            }

            public Builder setDelQuestIdList(int index, int value) {
                ensureDelQuestIdListIsMutable();
                this.delQuestIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addDelQuestIdList(int value) {
                ensureDelQuestIdListIsMutable();
                this.delQuestIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllDelQuestIdList(Iterable<? extends Integer> values) {
                ensureDelQuestIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.delQuestIdList_);
                onChanged();
                return this;
            }

            public Builder clearDelQuestIdList() {
                this.delQuestIdList_ = ServerCondMeetQuestListUpdateNotify.emptyIntList();
                this.bitField0_ &= -3;
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

        public static ServerCondMeetQuestListUpdateNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ServerCondMeetQuestListUpdateNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ServerCondMeetQuestListUpdateNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ServerCondMeetQuestListUpdateNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
