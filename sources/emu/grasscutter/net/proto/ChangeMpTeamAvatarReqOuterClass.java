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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeMpTeamAvatarReqOuterClass.class */
public final class ChangeMpTeamAvatarReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bChangeMpTeamAvatarReq.proto\"F\n\u0015ChangeMpTeamAvatarReq\u0012\u0015\n\rcurAvatarGuid\u0018\b \u0001(\u0004\u0012\u0016\n\u000eavatarGuidList\u0018\u0002 \u0003(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChangeMpTeamAvatarReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChangeMpTeamAvatarReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChangeMpTeamAvatarReq_descriptor, new String[]{"CurAvatarGuid", "AvatarGuidList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeMpTeamAvatarReqOuterClass$ChangeMpTeamAvatarReqOrBuilder.class */
    public interface ChangeMpTeamAvatarReqOrBuilder extends MessageOrBuilder {
        long getCurAvatarGuid();

        List<Long> getAvatarGuidListList();

        int getAvatarGuidListCount();

        long getAvatarGuidList(int i);
    }

    private ChangeMpTeamAvatarReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeMpTeamAvatarReqOuterClass$ChangeMpTeamAvatarReq.class */
    public static final class ChangeMpTeamAvatarReq extends GeneratedMessageV3 implements ChangeMpTeamAvatarReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CURAVATARGUID_FIELD_NUMBER = 8;
        private long curAvatarGuid_;
        public static final int AVATARGUIDLIST_FIELD_NUMBER = 2;
        private Internal.LongList avatarGuidList_;
        private int avatarGuidListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final ChangeMpTeamAvatarReq DEFAULT_INSTANCE = new ChangeMpTeamAvatarReq();
        private static final Parser<ChangeMpTeamAvatarReq> PARSER = new AbstractParser<ChangeMpTeamAvatarReq>() { // from class: emu.grasscutter.net.proto.ChangeMpTeamAvatarReqOuterClass.ChangeMpTeamAvatarReq.1
            @Override // com.google.protobuf.Parser
            public ChangeMpTeamAvatarReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChangeMpTeamAvatarReq(input, extensionRegistry);
            }
        };

        private ChangeMpTeamAvatarReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.avatarGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ChangeMpTeamAvatarReq() {
            this.avatarGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.avatarGuidList_ = emptyLongList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChangeMpTeamAvatarReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChangeMpTeamAvatarReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.avatarGuidList_ = newLongList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.avatarGuidList_.addLong(input.readUInt64());
                                    break;
                                case 18:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.avatarGuidList_ = newLongList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.avatarGuidList_.addLong(input.readUInt64());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 64:
                                    this.curAvatarGuid_ = input.readUInt64();
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
                    this.avatarGuidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ChangeMpTeamAvatarReqOuterClass.internal_static_ChangeMpTeamAvatarReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChangeMpTeamAvatarReqOuterClass.internal_static_ChangeMpTeamAvatarReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeMpTeamAvatarReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarReqOuterClass.ChangeMpTeamAvatarReqOrBuilder
        public long getCurAvatarGuid() {
            return this.curAvatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarReqOuterClass.ChangeMpTeamAvatarReqOrBuilder
        public List<Long> getAvatarGuidListList() {
            return this.avatarGuidList_;
        }

        @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarReqOuterClass.ChangeMpTeamAvatarReqOrBuilder
        public int getAvatarGuidListCount() {
            return this.avatarGuidList_.size();
        }

        @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarReqOuterClass.ChangeMpTeamAvatarReqOrBuilder
        public long getAvatarGuidList(int index) {
            return this.avatarGuidList_.getLong(index);
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
            if (getAvatarGuidListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.avatarGuidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.avatarGuidList_.size(); i++) {
                output.writeUInt64NoTag(this.avatarGuidList_.getLong(i));
            }
            if (this.curAvatarGuid_ != 0) {
                output.writeUInt64(8, this.curAvatarGuid_);
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
            for (int i = 0; i < this.avatarGuidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt64SizeNoTag(this.avatarGuidList_.getLong(i));
            }
            int size2 = 0 + dataSize;
            if (!getAvatarGuidListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.avatarGuidListMemoizedSerializedSize = dataSize;
            if (this.curAvatarGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(8, this.curAvatarGuid_);
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
            if (!(obj instanceof ChangeMpTeamAvatarReq)) {
                return equals(obj);
            }
            ChangeMpTeamAvatarReq other = (ChangeMpTeamAvatarReq) obj;
            return getCurAvatarGuid() == other.getCurAvatarGuid() && getAvatarGuidListList().equals(other.getAvatarGuidListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + Internal.hashLong(getCurAvatarGuid());
            if (getAvatarGuidListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getAvatarGuidListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ChangeMpTeamAvatarReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeMpTeamAvatarReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeMpTeamAvatarReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeMpTeamAvatarReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeMpTeamAvatarReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeMpTeamAvatarReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeMpTeamAvatarReq parseFrom(InputStream input) throws IOException {
            return (ChangeMpTeamAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChangeMpTeamAvatarReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeMpTeamAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChangeMpTeamAvatarReq parseDelimitedFrom(InputStream input) throws IOException {
            return (ChangeMpTeamAvatarReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChangeMpTeamAvatarReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeMpTeamAvatarReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChangeMpTeamAvatarReq parseFrom(CodedInputStream input) throws IOException {
            return (ChangeMpTeamAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChangeMpTeamAvatarReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeMpTeamAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChangeMpTeamAvatarReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeMpTeamAvatarReqOuterClass$ChangeMpTeamAvatarReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChangeMpTeamAvatarReqOrBuilder {
            private int bitField0_;
            private long curAvatarGuid_;
            private Internal.LongList avatarGuidList_ = ChangeMpTeamAvatarReq.emptyLongList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ChangeMpTeamAvatarReqOuterClass.internal_static_ChangeMpTeamAvatarReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChangeMpTeamAvatarReqOuterClass.internal_static_ChangeMpTeamAvatarReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeMpTeamAvatarReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChangeMpTeamAvatarReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.curAvatarGuid_ = 0;
                this.avatarGuidList_ = ChangeMpTeamAvatarReq.emptyLongList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChangeMpTeamAvatarReqOuterClass.internal_static_ChangeMpTeamAvatarReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChangeMpTeamAvatarReq getDefaultInstanceForType() {
                return ChangeMpTeamAvatarReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChangeMpTeamAvatarReq build() {
                ChangeMpTeamAvatarReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChangeMpTeamAvatarReq buildPartial() {
                ChangeMpTeamAvatarReq result = new ChangeMpTeamAvatarReq(this);
                int i = this.bitField0_;
                result.curAvatarGuid_ = this.curAvatarGuid_;
                if ((this.bitField0_ & 1) != 0) {
                    this.avatarGuidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.avatarGuidList_ = this.avatarGuidList_;
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
                if (other instanceof ChangeMpTeamAvatarReq) {
                    return mergeFrom((ChangeMpTeamAvatarReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChangeMpTeamAvatarReq other) {
                if (other == ChangeMpTeamAvatarReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getCurAvatarGuid() != 0) {
                    setCurAvatarGuid(other.getCurAvatarGuid());
                }
                if (!other.avatarGuidList_.isEmpty()) {
                    if (this.avatarGuidList_.isEmpty()) {
                        this.avatarGuidList_ = other.avatarGuidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAvatarGuidListIsMutable();
                        this.avatarGuidList_.addAll(other.avatarGuidList_);
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
                ChangeMpTeamAvatarReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChangeMpTeamAvatarReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChangeMpTeamAvatarReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarReqOuterClass.ChangeMpTeamAvatarReqOrBuilder
            public long getCurAvatarGuid() {
                return this.curAvatarGuid_;
            }

            public Builder setCurAvatarGuid(long value) {
                this.curAvatarGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurAvatarGuid() {
                this.curAvatarGuid_ = 0;
                onChanged();
                return this;
            }

            private void ensureAvatarGuidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.avatarGuidList_ = ChangeMpTeamAvatarReq.mutableCopy(this.avatarGuidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarReqOuterClass.ChangeMpTeamAvatarReqOrBuilder
            public List<Long> getAvatarGuidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.avatarGuidList_) : this.avatarGuidList_;
            }

            @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarReqOuterClass.ChangeMpTeamAvatarReqOrBuilder
            public int getAvatarGuidListCount() {
                return this.avatarGuidList_.size();
            }

            @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarReqOuterClass.ChangeMpTeamAvatarReqOrBuilder
            public long getAvatarGuidList(int index) {
                return this.avatarGuidList_.getLong(index);
            }

            public Builder setAvatarGuidList(int index, long value) {
                ensureAvatarGuidListIsMutable();
                this.avatarGuidList_.setLong(index, value);
                onChanged();
                return this;
            }

            public Builder addAvatarGuidList(long value) {
                ensureAvatarGuidListIsMutable();
                this.avatarGuidList_.addLong(value);
                onChanged();
                return this;
            }

            public Builder addAllAvatarGuidList(Iterable<? extends Long> values) {
                ensureAvatarGuidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarGuidList_);
                onChanged();
                return this;
            }

            public Builder clearAvatarGuidList() {
                this.avatarGuidList_ = ChangeMpTeamAvatarReq.emptyLongList();
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

        public static ChangeMpTeamAvatarReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChangeMpTeamAvatarReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChangeMpTeamAvatarReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChangeMpTeamAvatarReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
