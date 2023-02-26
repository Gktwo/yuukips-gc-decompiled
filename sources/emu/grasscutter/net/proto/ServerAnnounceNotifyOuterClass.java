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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AnnounceDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerAnnounceNotifyOuterClass.class */
public final class ServerAnnounceNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aServerAnnounceNotify.proto\u001a\u0012AnnounceData.proto\"?\n\u0014ServerAnnounceNotify\u0012'\n\u0010announceDataList\u0018\u0001 \u0003(\u000b2\r.AnnounceDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AnnounceDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ServerAnnounceNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ServerAnnounceNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ServerAnnounceNotify_descriptor, new String[]{"AnnounceDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerAnnounceNotifyOuterClass$ServerAnnounceNotifyOrBuilder.class */
    public interface ServerAnnounceNotifyOrBuilder extends MessageOrBuilder {
        List<AnnounceDataOuterClass.AnnounceData> getAnnounceDataListList();

        AnnounceDataOuterClass.AnnounceData getAnnounceDataList(int i);

        int getAnnounceDataListCount();

        List<? extends AnnounceDataOuterClass.AnnounceDataOrBuilder> getAnnounceDataListOrBuilderList();

        AnnounceDataOuterClass.AnnounceDataOrBuilder getAnnounceDataListOrBuilder(int i);
    }

    private ServerAnnounceNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerAnnounceNotifyOuterClass$ServerAnnounceNotify.class */
    public static final class ServerAnnounceNotify extends GeneratedMessageV3 implements ServerAnnounceNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ANNOUNCEDATALIST_FIELD_NUMBER = 1;
        private List<AnnounceDataOuterClass.AnnounceData> announceDataList_;
        private byte memoizedIsInitialized;
        private static final ServerAnnounceNotify DEFAULT_INSTANCE = new ServerAnnounceNotify();
        private static final Parser<ServerAnnounceNotify> PARSER = new AbstractParser<ServerAnnounceNotify>() { // from class: emu.grasscutter.net.proto.ServerAnnounceNotifyOuterClass.ServerAnnounceNotify.1
            @Override // com.google.protobuf.Parser
            public ServerAnnounceNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ServerAnnounceNotify(input, extensionRegistry);
            }
        };

        private ServerAnnounceNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ServerAnnounceNotify() {
            this.memoizedIsInitialized = -1;
            this.announceDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ServerAnnounceNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ServerAnnounceNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 10:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.announceDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.announceDataList_.add((AnnounceDataOuterClass.AnnounceData) input.readMessage(AnnounceDataOuterClass.AnnounceData.parser(), extensionRegistry));
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
                    this.announceDataList_ = Collections.unmodifiableList(this.announceDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ServerAnnounceNotifyOuterClass.internal_static_ServerAnnounceNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ServerAnnounceNotifyOuterClass.internal_static_ServerAnnounceNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ServerAnnounceNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ServerAnnounceNotifyOuterClass.ServerAnnounceNotifyOrBuilder
        public List<AnnounceDataOuterClass.AnnounceData> getAnnounceDataListList() {
            return this.announceDataList_;
        }

        @Override // emu.grasscutter.net.proto.ServerAnnounceNotifyOuterClass.ServerAnnounceNotifyOrBuilder
        public List<? extends AnnounceDataOuterClass.AnnounceDataOrBuilder> getAnnounceDataListOrBuilderList() {
            return this.announceDataList_;
        }

        @Override // emu.grasscutter.net.proto.ServerAnnounceNotifyOuterClass.ServerAnnounceNotifyOrBuilder
        public int getAnnounceDataListCount() {
            return this.announceDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.ServerAnnounceNotifyOuterClass.ServerAnnounceNotifyOrBuilder
        public AnnounceDataOuterClass.AnnounceData getAnnounceDataList(int index) {
            return this.announceDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ServerAnnounceNotifyOuterClass.ServerAnnounceNotifyOrBuilder
        public AnnounceDataOuterClass.AnnounceDataOrBuilder getAnnounceDataListOrBuilder(int index) {
            return this.announceDataList_.get(index);
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
            for (int i = 0; i < this.announceDataList_.size(); i++) {
                output.writeMessage(1, this.announceDataList_.get(i));
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
            for (int i = 0; i < this.announceDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.announceDataList_.get(i));
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
            if (!(obj instanceof ServerAnnounceNotify)) {
                return equals(obj);
            }
            ServerAnnounceNotify other = (ServerAnnounceNotify) obj;
            return getAnnounceDataListList().equals(other.getAnnounceDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAnnounceDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getAnnounceDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ServerAnnounceNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerAnnounceNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerAnnounceNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerAnnounceNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerAnnounceNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerAnnounceNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerAnnounceNotify parseFrom(InputStream input) throws IOException {
            return (ServerAnnounceNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ServerAnnounceNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerAnnounceNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ServerAnnounceNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ServerAnnounceNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ServerAnnounceNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerAnnounceNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ServerAnnounceNotify parseFrom(CodedInputStream input) throws IOException {
            return (ServerAnnounceNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ServerAnnounceNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerAnnounceNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ServerAnnounceNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerAnnounceNotifyOuterClass$ServerAnnounceNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ServerAnnounceNotifyOrBuilder {
            private int bitField0_;
            private List<AnnounceDataOuterClass.AnnounceData> announceDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<AnnounceDataOuterClass.AnnounceData, AnnounceDataOuterClass.AnnounceData.Builder, AnnounceDataOuterClass.AnnounceDataOrBuilder> announceDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ServerAnnounceNotifyOuterClass.internal_static_ServerAnnounceNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ServerAnnounceNotifyOuterClass.internal_static_ServerAnnounceNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ServerAnnounceNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ServerAnnounceNotify.alwaysUseFieldBuilders) {
                    getAnnounceDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.announceDataListBuilder_ == null) {
                    this.announceDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.announceDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ServerAnnounceNotifyOuterClass.internal_static_ServerAnnounceNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ServerAnnounceNotify getDefaultInstanceForType() {
                return ServerAnnounceNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServerAnnounceNotify build() {
                ServerAnnounceNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServerAnnounceNotify buildPartial() {
                ServerAnnounceNotify result = new ServerAnnounceNotify(this);
                int i = this.bitField0_;
                if (this.announceDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.announceDataList_ = Collections.unmodifiableList(this.announceDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.announceDataList_ = this.announceDataList_;
                } else {
                    result.announceDataList_ = this.announceDataListBuilder_.build();
                }
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
                if (other instanceof ServerAnnounceNotify) {
                    return mergeFrom((ServerAnnounceNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ServerAnnounceNotify other) {
                if (other == ServerAnnounceNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.announceDataListBuilder_ == null) {
                    if (!other.announceDataList_.isEmpty()) {
                        if (this.announceDataList_.isEmpty()) {
                            this.announceDataList_ = other.announceDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAnnounceDataListIsMutable();
                            this.announceDataList_.addAll(other.announceDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.announceDataList_.isEmpty()) {
                    if (this.announceDataListBuilder_.isEmpty()) {
                        this.announceDataListBuilder_.dispose();
                        this.announceDataListBuilder_ = null;
                        this.announceDataList_ = other.announceDataList_;
                        this.bitField0_ &= -2;
                        this.announceDataListBuilder_ = ServerAnnounceNotify.alwaysUseFieldBuilders ? getAnnounceDataListFieldBuilder() : null;
                    } else {
                        this.announceDataListBuilder_.addAllMessages(other.announceDataList_);
                    }
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
                ServerAnnounceNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ServerAnnounceNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ServerAnnounceNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAnnounceDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.announceDataList_ = new ArrayList(this.announceDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ServerAnnounceNotifyOuterClass.ServerAnnounceNotifyOrBuilder
            public List<AnnounceDataOuterClass.AnnounceData> getAnnounceDataListList() {
                if (this.announceDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.announceDataList_);
                }
                return this.announceDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ServerAnnounceNotifyOuterClass.ServerAnnounceNotifyOrBuilder
            public int getAnnounceDataListCount() {
                if (this.announceDataListBuilder_ == null) {
                    return this.announceDataList_.size();
                }
                return this.announceDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ServerAnnounceNotifyOuterClass.ServerAnnounceNotifyOrBuilder
            public AnnounceDataOuterClass.AnnounceData getAnnounceDataList(int index) {
                if (this.announceDataListBuilder_ == null) {
                    return this.announceDataList_.get(index);
                }
                return this.announceDataListBuilder_.getMessage(index);
            }

            public Builder setAnnounceDataList(int index, AnnounceDataOuterClass.AnnounceData value) {
                if (this.announceDataListBuilder_ != null) {
                    this.announceDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAnnounceDataListIsMutable();
                    this.announceDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAnnounceDataList(int index, AnnounceDataOuterClass.AnnounceData.Builder builderForValue) {
                if (this.announceDataListBuilder_ == null) {
                    ensureAnnounceDataListIsMutable();
                    this.announceDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.announceDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAnnounceDataList(AnnounceDataOuterClass.AnnounceData value) {
                if (this.announceDataListBuilder_ != null) {
                    this.announceDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAnnounceDataListIsMutable();
                    this.announceDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAnnounceDataList(int index, AnnounceDataOuterClass.AnnounceData value) {
                if (this.announceDataListBuilder_ != null) {
                    this.announceDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAnnounceDataListIsMutable();
                    this.announceDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAnnounceDataList(AnnounceDataOuterClass.AnnounceData.Builder builderForValue) {
                if (this.announceDataListBuilder_ == null) {
                    ensureAnnounceDataListIsMutable();
                    this.announceDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.announceDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAnnounceDataList(int index, AnnounceDataOuterClass.AnnounceData.Builder builderForValue) {
                if (this.announceDataListBuilder_ == null) {
                    ensureAnnounceDataListIsMutable();
                    this.announceDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.announceDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAnnounceDataList(Iterable<? extends AnnounceDataOuterClass.AnnounceData> values) {
                if (this.announceDataListBuilder_ == null) {
                    ensureAnnounceDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.announceDataList_);
                    onChanged();
                } else {
                    this.announceDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAnnounceDataList() {
                if (this.announceDataListBuilder_ == null) {
                    this.announceDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.announceDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAnnounceDataList(int index) {
                if (this.announceDataListBuilder_ == null) {
                    ensureAnnounceDataListIsMutable();
                    this.announceDataList_.remove(index);
                    onChanged();
                } else {
                    this.announceDataListBuilder_.remove(index);
                }
                return this;
            }

            public AnnounceDataOuterClass.AnnounceData.Builder getAnnounceDataListBuilder(int index) {
                return getAnnounceDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ServerAnnounceNotifyOuterClass.ServerAnnounceNotifyOrBuilder
            public AnnounceDataOuterClass.AnnounceDataOrBuilder getAnnounceDataListOrBuilder(int index) {
                if (this.announceDataListBuilder_ == null) {
                    return this.announceDataList_.get(index);
                }
                return this.announceDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ServerAnnounceNotifyOuterClass.ServerAnnounceNotifyOrBuilder
            public List<? extends AnnounceDataOuterClass.AnnounceDataOrBuilder> getAnnounceDataListOrBuilderList() {
                if (this.announceDataListBuilder_ != null) {
                    return this.announceDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.announceDataList_);
            }

            public AnnounceDataOuterClass.AnnounceData.Builder addAnnounceDataListBuilder() {
                return getAnnounceDataListFieldBuilder().addBuilder(AnnounceDataOuterClass.AnnounceData.getDefaultInstance());
            }

            public AnnounceDataOuterClass.AnnounceData.Builder addAnnounceDataListBuilder(int index) {
                return getAnnounceDataListFieldBuilder().addBuilder(index, AnnounceDataOuterClass.AnnounceData.getDefaultInstance());
            }

            public List<AnnounceDataOuterClass.AnnounceData.Builder> getAnnounceDataListBuilderList() {
                return getAnnounceDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AnnounceDataOuterClass.AnnounceData, AnnounceDataOuterClass.AnnounceData.Builder, AnnounceDataOuterClass.AnnounceDataOrBuilder> getAnnounceDataListFieldBuilder() {
                if (this.announceDataListBuilder_ == null) {
                    this.announceDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.announceDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.announceDataList_ = null;
                }
                return this.announceDataListBuilder_;
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

        public static ServerAnnounceNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ServerAnnounceNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ServerAnnounceNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ServerAnnounceNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AnnounceDataOuterClass.getDescriptor();
    }
}
