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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerAnnounceRevokeNotifyOuterClass.class */
public final class ServerAnnounceRevokeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n ServerAnnounceRevokeNotify.proto\"2\n\u001aServerAnnounceRevokeNotify\u0012\u0014\n\fconfigIdList\u0018\f \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ServerAnnounceRevokeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ServerAnnounceRevokeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ServerAnnounceRevokeNotify_descriptor, new String[]{"ConfigIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerAnnounceRevokeNotifyOuterClass$ServerAnnounceRevokeNotifyOrBuilder.class */
    public interface ServerAnnounceRevokeNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getConfigIdListList();

        int getConfigIdListCount();

        int getConfigIdList(int i);
    }

    private ServerAnnounceRevokeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerAnnounceRevokeNotifyOuterClass$ServerAnnounceRevokeNotify.class */
    public static final class ServerAnnounceRevokeNotify extends GeneratedMessageV3 implements ServerAnnounceRevokeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CONFIGIDLIST_FIELD_NUMBER = 12;
        private Internal.IntList configIdList_;
        private int configIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final ServerAnnounceRevokeNotify DEFAULT_INSTANCE = new ServerAnnounceRevokeNotify();
        private static final Parser<ServerAnnounceRevokeNotify> PARSER = new AbstractParser<ServerAnnounceRevokeNotify>() { // from class: emu.grasscutter.net.proto.ServerAnnounceRevokeNotifyOuterClass.ServerAnnounceRevokeNotify.1
            @Override // com.google.protobuf.Parser
            public ServerAnnounceRevokeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ServerAnnounceRevokeNotify(input, extensionRegistry);
            }
        };

        private ServerAnnounceRevokeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.configIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ServerAnnounceRevokeNotify() {
            this.configIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.configIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ServerAnnounceRevokeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ServerAnnounceRevokeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 96:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.configIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.configIdList_.addInt(input.readUInt32());
                                    break;
                                case 98:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.configIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.configIdList_.addInt(input.readUInt32());
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
                    this.configIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ServerAnnounceRevokeNotifyOuterClass.internal_static_ServerAnnounceRevokeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ServerAnnounceRevokeNotifyOuterClass.internal_static_ServerAnnounceRevokeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ServerAnnounceRevokeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ServerAnnounceRevokeNotifyOuterClass.ServerAnnounceRevokeNotifyOrBuilder
        public List<Integer> getConfigIdListList() {
            return this.configIdList_;
        }

        @Override // emu.grasscutter.net.proto.ServerAnnounceRevokeNotifyOuterClass.ServerAnnounceRevokeNotifyOrBuilder
        public int getConfigIdListCount() {
            return this.configIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.ServerAnnounceRevokeNotifyOuterClass.ServerAnnounceRevokeNotifyOrBuilder
        public int getConfigIdList(int index) {
            return this.configIdList_.getInt(index);
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
            if (getConfigIdListList().size() > 0) {
                output.writeUInt32NoTag(98);
                output.writeUInt32NoTag(this.configIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.configIdList_.size(); i++) {
                output.writeUInt32NoTag(this.configIdList_.getInt(i));
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
            for (int i = 0; i < this.configIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.configIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getConfigIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.configIdListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ServerAnnounceRevokeNotify)) {
                return equals(obj);
            }
            ServerAnnounceRevokeNotify other = (ServerAnnounceRevokeNotify) obj;
            return getConfigIdListList().equals(other.getConfigIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getConfigIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getConfigIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ServerAnnounceRevokeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerAnnounceRevokeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerAnnounceRevokeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerAnnounceRevokeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerAnnounceRevokeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerAnnounceRevokeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerAnnounceRevokeNotify parseFrom(InputStream input) throws IOException {
            return (ServerAnnounceRevokeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ServerAnnounceRevokeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerAnnounceRevokeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ServerAnnounceRevokeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ServerAnnounceRevokeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ServerAnnounceRevokeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerAnnounceRevokeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ServerAnnounceRevokeNotify parseFrom(CodedInputStream input) throws IOException {
            return (ServerAnnounceRevokeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ServerAnnounceRevokeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerAnnounceRevokeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ServerAnnounceRevokeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerAnnounceRevokeNotifyOuterClass$ServerAnnounceRevokeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ServerAnnounceRevokeNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList configIdList_ = ServerAnnounceRevokeNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ServerAnnounceRevokeNotifyOuterClass.internal_static_ServerAnnounceRevokeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ServerAnnounceRevokeNotifyOuterClass.internal_static_ServerAnnounceRevokeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ServerAnnounceRevokeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ServerAnnounceRevokeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.configIdList_ = ServerAnnounceRevokeNotify.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ServerAnnounceRevokeNotifyOuterClass.internal_static_ServerAnnounceRevokeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ServerAnnounceRevokeNotify getDefaultInstanceForType() {
                return ServerAnnounceRevokeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServerAnnounceRevokeNotify build() {
                ServerAnnounceRevokeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServerAnnounceRevokeNotify buildPartial() {
                ServerAnnounceRevokeNotify result = new ServerAnnounceRevokeNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.configIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.configIdList_ = this.configIdList_;
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
                if (other instanceof ServerAnnounceRevokeNotify) {
                    return mergeFrom((ServerAnnounceRevokeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ServerAnnounceRevokeNotify other) {
                if (other == ServerAnnounceRevokeNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.configIdList_.isEmpty()) {
                    if (this.configIdList_.isEmpty()) {
                        this.configIdList_ = other.configIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureConfigIdListIsMutable();
                        this.configIdList_.addAll(other.configIdList_);
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
                ServerAnnounceRevokeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ServerAnnounceRevokeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ServerAnnounceRevokeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureConfigIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.configIdList_ = ServerAnnounceRevokeNotify.mutableCopy(this.configIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ServerAnnounceRevokeNotifyOuterClass.ServerAnnounceRevokeNotifyOrBuilder
            public List<Integer> getConfigIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.configIdList_) : this.configIdList_;
            }

            @Override // emu.grasscutter.net.proto.ServerAnnounceRevokeNotifyOuterClass.ServerAnnounceRevokeNotifyOrBuilder
            public int getConfigIdListCount() {
                return this.configIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.ServerAnnounceRevokeNotifyOuterClass.ServerAnnounceRevokeNotifyOrBuilder
            public int getConfigIdList(int index) {
                return this.configIdList_.getInt(index);
            }

            public Builder setConfigIdList(int index, int value) {
                ensureConfigIdListIsMutable();
                this.configIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addConfigIdList(int value) {
                ensureConfigIdListIsMutable();
                this.configIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllConfigIdList(Iterable<? extends Integer> values) {
                ensureConfigIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.configIdList_);
                onChanged();
                return this;
            }

            public Builder clearConfigIdList() {
                this.configIdList_ = ServerAnnounceRevokeNotify.emptyIntList();
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

        public static ServerAnnounceRevokeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ServerAnnounceRevokeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ServerAnnounceRevokeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ServerAnnounceRevokeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
