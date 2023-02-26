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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeMpTeamAvatarRspOuterClass.class */
public final class ChangeMpTeamAvatarRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bChangeMpTeamAvatarRsp.proto\"W\n\u0015ChangeMpTeamAvatarRsp\u0012\u0015\n\rcurAvatarGuid\u0018\f \u0001(\u0004\u0012\u0016\n\u000eavatarGuidList\u0018\n \u0003(\u0004\u0012\u000f\n\u0007retcode\u0018\u0001 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChangeMpTeamAvatarRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChangeMpTeamAvatarRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChangeMpTeamAvatarRsp_descriptor, new String[]{"CurAvatarGuid", "AvatarGuidList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeMpTeamAvatarRspOuterClass$ChangeMpTeamAvatarRspOrBuilder.class */
    public interface ChangeMpTeamAvatarRspOrBuilder extends MessageOrBuilder {
        long getCurAvatarGuid();

        List<Long> getAvatarGuidListList();

        int getAvatarGuidListCount();

        long getAvatarGuidList(int i);

        int getRetcode();
    }

    private ChangeMpTeamAvatarRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeMpTeamAvatarRspOuterClass$ChangeMpTeamAvatarRsp.class */
    public static final class ChangeMpTeamAvatarRsp extends GeneratedMessageV3 implements ChangeMpTeamAvatarRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CURAVATARGUID_FIELD_NUMBER = 12;
        private long curAvatarGuid_;
        public static final int AVATARGUIDLIST_FIELD_NUMBER = 10;
        private Internal.LongList avatarGuidList_;
        private int avatarGuidListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 1;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final ChangeMpTeamAvatarRsp DEFAULT_INSTANCE = new ChangeMpTeamAvatarRsp();
        private static final Parser<ChangeMpTeamAvatarRsp> PARSER = new AbstractParser<ChangeMpTeamAvatarRsp>() { // from class: emu.grasscutter.net.proto.ChangeMpTeamAvatarRspOuterClass.ChangeMpTeamAvatarRsp.1
            @Override // com.google.protobuf.Parser
            public ChangeMpTeamAvatarRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChangeMpTeamAvatarRsp(input, extensionRegistry);
            }
        };

        private ChangeMpTeamAvatarRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.avatarGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ChangeMpTeamAvatarRsp() {
            this.avatarGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.avatarGuidList_ = emptyLongList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChangeMpTeamAvatarRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChangeMpTeamAvatarRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.retcode_ = input.readInt32();
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.avatarGuidList_ = newLongList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.avatarGuidList_.addLong(input.readUInt64());
                                break;
                            case 82:
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
                            case 96:
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
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
            return ChangeMpTeamAvatarRspOuterClass.internal_static_ChangeMpTeamAvatarRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChangeMpTeamAvatarRspOuterClass.internal_static_ChangeMpTeamAvatarRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeMpTeamAvatarRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarRspOuterClass.ChangeMpTeamAvatarRspOrBuilder
        public long getCurAvatarGuid() {
            return this.curAvatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarRspOuterClass.ChangeMpTeamAvatarRspOrBuilder
        public List<Long> getAvatarGuidListList() {
            return this.avatarGuidList_;
        }

        @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarRspOuterClass.ChangeMpTeamAvatarRspOrBuilder
        public int getAvatarGuidListCount() {
            return this.avatarGuidList_.size();
        }

        @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarRspOuterClass.ChangeMpTeamAvatarRspOrBuilder
        public long getAvatarGuidList(int index) {
            return this.avatarGuidList_.getLong(index);
        }

        @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarRspOuterClass.ChangeMpTeamAvatarRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
                output.writeInt32(1, this.retcode_);
            }
            if (getAvatarGuidListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.avatarGuidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.avatarGuidList_.size(); i++) {
                output.writeUInt64NoTag(this.avatarGuidList_.getLong(i));
            }
            if (this.curAvatarGuid_ != 0) {
                output.writeUInt64(12, this.curAvatarGuid_);
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
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.retcode_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.avatarGuidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt64SizeNoTag(this.avatarGuidList_.getLong(i));
            }
            int size3 = size2 + dataSize;
            if (!getAvatarGuidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.avatarGuidListMemoizedSerializedSize = dataSize;
            if (this.curAvatarGuid_ != 0) {
                size3 += CodedOutputStream.computeUInt64Size(12, this.curAvatarGuid_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ChangeMpTeamAvatarRsp)) {
                return equals(obj);
            }
            ChangeMpTeamAvatarRsp other = (ChangeMpTeamAvatarRsp) obj;
            return getCurAvatarGuid() == other.getCurAvatarGuid() && getAvatarGuidListList().equals(other.getAvatarGuidListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + Internal.hashLong(getCurAvatarGuid());
            if (getAvatarGuidListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getAvatarGuidListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 1)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ChangeMpTeamAvatarRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeMpTeamAvatarRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeMpTeamAvatarRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeMpTeamAvatarRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeMpTeamAvatarRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeMpTeamAvatarRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeMpTeamAvatarRsp parseFrom(InputStream input) throws IOException {
            return (ChangeMpTeamAvatarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChangeMpTeamAvatarRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeMpTeamAvatarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChangeMpTeamAvatarRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (ChangeMpTeamAvatarRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChangeMpTeamAvatarRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeMpTeamAvatarRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChangeMpTeamAvatarRsp parseFrom(CodedInputStream input) throws IOException {
            return (ChangeMpTeamAvatarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChangeMpTeamAvatarRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeMpTeamAvatarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChangeMpTeamAvatarRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeMpTeamAvatarRspOuterClass$ChangeMpTeamAvatarRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChangeMpTeamAvatarRspOrBuilder {
            private int bitField0_;
            private long curAvatarGuid_;
            private Internal.LongList avatarGuidList_ = ChangeMpTeamAvatarRsp.emptyLongList();
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChangeMpTeamAvatarRspOuterClass.internal_static_ChangeMpTeamAvatarRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChangeMpTeamAvatarRspOuterClass.internal_static_ChangeMpTeamAvatarRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeMpTeamAvatarRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChangeMpTeamAvatarRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.curAvatarGuid_ = 0;
                this.avatarGuidList_ = ChangeMpTeamAvatarRsp.emptyLongList();
                this.bitField0_ &= -2;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChangeMpTeamAvatarRspOuterClass.internal_static_ChangeMpTeamAvatarRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChangeMpTeamAvatarRsp getDefaultInstanceForType() {
                return ChangeMpTeamAvatarRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChangeMpTeamAvatarRsp build() {
                ChangeMpTeamAvatarRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChangeMpTeamAvatarRsp buildPartial() {
                ChangeMpTeamAvatarRsp result = new ChangeMpTeamAvatarRsp(this);
                int i = this.bitField0_;
                result.curAvatarGuid_ = this.curAvatarGuid_;
                if ((this.bitField0_ & 1) != 0) {
                    this.avatarGuidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.avatarGuidList_ = this.avatarGuidList_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof ChangeMpTeamAvatarRsp) {
                    return mergeFrom((ChangeMpTeamAvatarRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChangeMpTeamAvatarRsp other) {
                if (other == ChangeMpTeamAvatarRsp.getDefaultInstance()) {
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
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                ChangeMpTeamAvatarRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChangeMpTeamAvatarRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChangeMpTeamAvatarRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarRspOuterClass.ChangeMpTeamAvatarRspOrBuilder
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
                    this.avatarGuidList_ = ChangeMpTeamAvatarRsp.mutableCopy(this.avatarGuidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarRspOuterClass.ChangeMpTeamAvatarRspOrBuilder
            public List<Long> getAvatarGuidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.avatarGuidList_) : this.avatarGuidList_;
            }

            @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarRspOuterClass.ChangeMpTeamAvatarRspOrBuilder
            public int getAvatarGuidListCount() {
                return this.avatarGuidList_.size();
            }

            @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarRspOuterClass.ChangeMpTeamAvatarRspOrBuilder
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
                this.avatarGuidList_ = ChangeMpTeamAvatarRsp.emptyLongList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChangeMpTeamAvatarRspOuterClass.ChangeMpTeamAvatarRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static ChangeMpTeamAvatarRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChangeMpTeamAvatarRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChangeMpTeamAvatarRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChangeMpTeamAvatarRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
