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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonCandidateTeamChangeAvatarReqOuterClass.class */
public final class DungeonCandidateTeamChangeAvatarReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n)DungeonCandidateTeamChangeAvatarReq.proto\"=\n#DungeonCandidateTeamChangeAvatarReq\u0012\u0016\n\u000eavatarGuidList\u0018\u0005 \u0003(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DungeonCandidateTeamChangeAvatarReq_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_DungeonCandidateTeamChangeAvatarReq_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f681xe398884c = new GeneratedMessageV3.FieldAccessorTable(internal_static_DungeonCandidateTeamChangeAvatarReq_descriptor, new String[]{"AvatarGuidList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonCandidateTeamChangeAvatarReqOuterClass$DungeonCandidateTeamChangeAvatarReqOrBuilder.class */
    public interface DungeonCandidateTeamChangeAvatarReqOrBuilder extends MessageOrBuilder {
        List<Long> getAvatarGuidListList();

        int getAvatarGuidListCount();

        long getAvatarGuidList(int i);
    }

    private DungeonCandidateTeamChangeAvatarReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonCandidateTeamChangeAvatarReqOuterClass$DungeonCandidateTeamChangeAvatarReq.class */
    public static final class DungeonCandidateTeamChangeAvatarReq extends GeneratedMessageV3 implements DungeonCandidateTeamChangeAvatarReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATARGUIDLIST_FIELD_NUMBER = 5;
        private Internal.LongList avatarGuidList_;
        private int avatarGuidListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final DungeonCandidateTeamChangeAvatarReq DEFAULT_INSTANCE = new DungeonCandidateTeamChangeAvatarReq();
        private static final Parser<DungeonCandidateTeamChangeAvatarReq> PARSER = new AbstractParser<DungeonCandidateTeamChangeAvatarReq>() { // from class: emu.grasscutter.net.proto.DungeonCandidateTeamChangeAvatarReqOuterClass.DungeonCandidateTeamChangeAvatarReq.1
            @Override // com.google.protobuf.Parser
            public DungeonCandidateTeamChangeAvatarReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DungeonCandidateTeamChangeAvatarReq(input, extensionRegistry);
            }
        };

        private DungeonCandidateTeamChangeAvatarReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.avatarGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private DungeonCandidateTeamChangeAvatarReq() {
            this.avatarGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.avatarGuidList_ = emptyLongList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DungeonCandidateTeamChangeAvatarReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DungeonCandidateTeamChangeAvatarReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.avatarGuidList_ = newLongList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.avatarGuidList_.addLong(input.readUInt64());
                                    break;
                                case 42:
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
                    this.avatarGuidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DungeonCandidateTeamChangeAvatarReqOuterClass.internal_static_DungeonCandidateTeamChangeAvatarReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DungeonCandidateTeamChangeAvatarReqOuterClass.f681xe398884c.ensureFieldAccessorsInitialized(DungeonCandidateTeamChangeAvatarReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DungeonCandidateTeamChangeAvatarReqOuterClass.DungeonCandidateTeamChangeAvatarReqOrBuilder
        public List<Long> getAvatarGuidListList() {
            return this.avatarGuidList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonCandidateTeamChangeAvatarReqOuterClass.DungeonCandidateTeamChangeAvatarReqOrBuilder
        public int getAvatarGuidListCount() {
            return this.avatarGuidList_.size();
        }

        @Override // emu.grasscutter.net.proto.DungeonCandidateTeamChangeAvatarReqOuterClass.DungeonCandidateTeamChangeAvatarReqOrBuilder
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
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.avatarGuidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.avatarGuidList_.size(); i++) {
                output.writeUInt64NoTag(this.avatarGuidList_.getLong(i));
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
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DungeonCandidateTeamChangeAvatarReq)) {
                return equals(obj);
            }
            DungeonCandidateTeamChangeAvatarReq other = (DungeonCandidateTeamChangeAvatarReq) obj;
            return getAvatarGuidListList().equals(other.getAvatarGuidListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAvatarGuidListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getAvatarGuidListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DungeonCandidateTeamChangeAvatarReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonCandidateTeamChangeAvatarReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonCandidateTeamChangeAvatarReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonCandidateTeamChangeAvatarReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonCandidateTeamChangeAvatarReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonCandidateTeamChangeAvatarReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonCandidateTeamChangeAvatarReq parseFrom(InputStream input) throws IOException {
            return (DungeonCandidateTeamChangeAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonCandidateTeamChangeAvatarReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonCandidateTeamChangeAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonCandidateTeamChangeAvatarReq parseDelimitedFrom(InputStream input) throws IOException {
            return (DungeonCandidateTeamChangeAvatarReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DungeonCandidateTeamChangeAvatarReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonCandidateTeamChangeAvatarReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonCandidateTeamChangeAvatarReq parseFrom(CodedInputStream input) throws IOException {
            return (DungeonCandidateTeamChangeAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonCandidateTeamChangeAvatarReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonCandidateTeamChangeAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DungeonCandidateTeamChangeAvatarReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonCandidateTeamChangeAvatarReqOuterClass$DungeonCandidateTeamChangeAvatarReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DungeonCandidateTeamChangeAvatarReqOrBuilder {
            private int bitField0_;
            private Internal.LongList avatarGuidList_ = DungeonCandidateTeamChangeAvatarReq.emptyLongList();

            public static final Descriptors.Descriptor getDescriptor() {
                return DungeonCandidateTeamChangeAvatarReqOuterClass.internal_static_DungeonCandidateTeamChangeAvatarReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DungeonCandidateTeamChangeAvatarReqOuterClass.f681xe398884c.ensureFieldAccessorsInitialized(DungeonCandidateTeamChangeAvatarReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DungeonCandidateTeamChangeAvatarReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.avatarGuidList_ = DungeonCandidateTeamChangeAvatarReq.emptyLongList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DungeonCandidateTeamChangeAvatarReqOuterClass.internal_static_DungeonCandidateTeamChangeAvatarReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DungeonCandidateTeamChangeAvatarReq getDefaultInstanceForType() {
                return DungeonCandidateTeamChangeAvatarReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonCandidateTeamChangeAvatarReq build() {
                DungeonCandidateTeamChangeAvatarReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonCandidateTeamChangeAvatarReq buildPartial() {
                DungeonCandidateTeamChangeAvatarReq result = new DungeonCandidateTeamChangeAvatarReq(this);
                int i = this.bitField0_;
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
                if (other instanceof DungeonCandidateTeamChangeAvatarReq) {
                    return mergeFrom((DungeonCandidateTeamChangeAvatarReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DungeonCandidateTeamChangeAvatarReq other) {
                if (other == DungeonCandidateTeamChangeAvatarReq.getDefaultInstance()) {
                    return this;
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
                DungeonCandidateTeamChangeAvatarReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = DungeonCandidateTeamChangeAvatarReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DungeonCandidateTeamChangeAvatarReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAvatarGuidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.avatarGuidList_ = DungeonCandidateTeamChangeAvatarReq.mutableCopy(this.avatarGuidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonCandidateTeamChangeAvatarReqOuterClass.DungeonCandidateTeamChangeAvatarReqOrBuilder
            public List<Long> getAvatarGuidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.avatarGuidList_) : this.avatarGuidList_;
            }

            @Override // emu.grasscutter.net.proto.DungeonCandidateTeamChangeAvatarReqOuterClass.DungeonCandidateTeamChangeAvatarReqOrBuilder
            public int getAvatarGuidListCount() {
                return this.avatarGuidList_.size();
            }

            @Override // emu.grasscutter.net.proto.DungeonCandidateTeamChangeAvatarReqOuterClass.DungeonCandidateTeamChangeAvatarReqOrBuilder
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
                this.avatarGuidList_ = DungeonCandidateTeamChangeAvatarReq.emptyLongList();
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

        public static DungeonCandidateTeamChangeAvatarReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DungeonCandidateTeamChangeAvatarReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DungeonCandidateTeamChangeAvatarReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DungeonCandidateTeamChangeAvatarReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
