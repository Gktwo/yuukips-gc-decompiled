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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetUpAvatarTeamRspOuterClass.class */
public final class SetUpAvatarTeamRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018SetUpAvatarTeamRsp.proto\"n\n\u0012SetUpAvatarTeamRsp\u0012\u000f\n\u0007team_id\u0018\n \u0001(\r\u0012\u001d\n\u0015avatar_team_guid_list\u0018\t \u0003(\u0004\u0012\u000f\n\u0007retcode\u0018\u0005 \u0001(\u0005\u0012\u0017\n\u000fcur_avatar_guid\u0018\u000b \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SetUpAvatarTeamRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SetUpAvatarTeamRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SetUpAvatarTeamRsp_descriptor, new String[]{"TeamId", "AvatarTeamGuidList", "Retcode", "CurAvatarGuid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetUpAvatarTeamRspOuterClass$SetUpAvatarTeamRspOrBuilder.class */
    public interface SetUpAvatarTeamRspOrBuilder extends MessageOrBuilder {
        int getTeamId();

        List<Long> getAvatarTeamGuidListList();

        int getAvatarTeamGuidListCount();

        long getAvatarTeamGuidList(int i);

        int getRetcode();

        long getCurAvatarGuid();
    }

    private SetUpAvatarTeamRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetUpAvatarTeamRspOuterClass$SetUpAvatarTeamRsp.class */
    public static final class SetUpAvatarTeamRsp extends GeneratedMessageV3 implements SetUpAvatarTeamRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TEAM_ID_FIELD_NUMBER = 10;
        private int teamId_;
        public static final int AVATAR_TEAM_GUID_LIST_FIELD_NUMBER = 9;
        private Internal.LongList avatarTeamGuidList_;
        private int avatarTeamGuidListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 5;
        private int retcode_;
        public static final int CUR_AVATAR_GUID_FIELD_NUMBER = 11;
        private long curAvatarGuid_;
        private byte memoizedIsInitialized;
        private static final SetUpAvatarTeamRsp DEFAULT_INSTANCE = new SetUpAvatarTeamRsp();
        private static final Parser<SetUpAvatarTeamRsp> PARSER = new AbstractParser<SetUpAvatarTeamRsp>() { // from class: emu.grasscutter.net.proto.SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRsp.1
            @Override // com.google.protobuf.Parser
            public SetUpAvatarTeamRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SetUpAvatarTeamRsp(input, extensionRegistry);
            }
        };

        private SetUpAvatarTeamRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.avatarTeamGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private SetUpAvatarTeamRsp() {
            this.avatarTeamGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.avatarTeamGuidList_ = emptyLongList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SetUpAvatarTeamRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SetUpAvatarTeamRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                this.retcode_ = input.readInt32();
                                break;
                            case 72:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.avatarTeamGuidList_ = newLongList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.avatarTeamGuidList_.addLong(input.readUInt64());
                                break;
                            case 74:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.avatarTeamGuidList_ = newLongList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.avatarTeamGuidList_.addLong(input.readUInt64());
                                }
                                input.popLimit(limit);
                                break;
                            case 80:
                                this.teamId_ = input.readUInt32();
                                break;
                            case 88:
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
                    this.avatarTeamGuidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SetUpAvatarTeamRspOuterClass.internal_static_SetUpAvatarTeamRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SetUpAvatarTeamRspOuterClass.internal_static_SetUpAvatarTeamRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SetUpAvatarTeamRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRspOrBuilder
        public int getTeamId() {
            return this.teamId_;
        }

        @Override // emu.grasscutter.net.proto.SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRspOrBuilder
        public List<Long> getAvatarTeamGuidListList() {
            return this.avatarTeamGuidList_;
        }

        @Override // emu.grasscutter.net.proto.SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRspOrBuilder
        public int getAvatarTeamGuidListCount() {
            return this.avatarTeamGuidList_.size();
        }

        @Override // emu.grasscutter.net.proto.SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRspOrBuilder
        public long getAvatarTeamGuidList(int index) {
            return this.avatarTeamGuidList_.getLong(index);
        }

        @Override // emu.grasscutter.net.proto.SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRspOrBuilder
        public long getCurAvatarGuid() {
            return this.curAvatarGuid_;
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
                output.writeInt32(5, this.retcode_);
            }
            if (getAvatarTeamGuidListList().size() > 0) {
                output.writeUInt32NoTag(74);
                output.writeUInt32NoTag(this.avatarTeamGuidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.avatarTeamGuidList_.size(); i++) {
                output.writeUInt64NoTag(this.avatarTeamGuidList_.getLong(i));
            }
            if (this.teamId_ != 0) {
                output.writeUInt32(10, this.teamId_);
            }
            if (this.curAvatarGuid_ != 0) {
                output.writeUInt64(11, this.curAvatarGuid_);
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
                size2 = 0 + CodedOutputStream.computeInt32Size(5, this.retcode_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.avatarTeamGuidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt64SizeNoTag(this.avatarTeamGuidList_.getLong(i));
            }
            int size3 = size2 + dataSize;
            if (!getAvatarTeamGuidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.avatarTeamGuidListMemoizedSerializedSize = dataSize;
            if (this.teamId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(10, this.teamId_);
            }
            if (this.curAvatarGuid_ != 0) {
                size3 += CodedOutputStream.computeUInt64Size(11, this.curAvatarGuid_);
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
            if (!(obj instanceof SetUpAvatarTeamRsp)) {
                return equals(obj);
            }
            SetUpAvatarTeamRsp other = (SetUpAvatarTeamRsp) obj;
            return getTeamId() == other.getTeamId() && getAvatarTeamGuidListList().equals(other.getAvatarTeamGuidListList()) && getRetcode() == other.getRetcode() && getCurAvatarGuid() == other.getCurAvatarGuid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getTeamId();
            if (getAvatarTeamGuidListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getAvatarTeamGuidListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 5)) + getRetcode())) + 11)) + Internal.hashLong(getCurAvatarGuid()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SetUpAvatarTeamRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetUpAvatarTeamRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetUpAvatarTeamRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetUpAvatarTeamRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetUpAvatarTeamRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetUpAvatarTeamRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetUpAvatarTeamRsp parseFrom(InputStream input) throws IOException {
            return (SetUpAvatarTeamRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetUpAvatarTeamRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetUpAvatarTeamRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetUpAvatarTeamRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (SetUpAvatarTeamRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SetUpAvatarTeamRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetUpAvatarTeamRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetUpAvatarTeamRsp parseFrom(CodedInputStream input) throws IOException {
            return (SetUpAvatarTeamRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetUpAvatarTeamRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetUpAvatarTeamRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SetUpAvatarTeamRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetUpAvatarTeamRspOuterClass$SetUpAvatarTeamRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SetUpAvatarTeamRspOrBuilder {
            private int bitField0_;
            private int teamId_;
            private Internal.LongList avatarTeamGuidList_ = SetUpAvatarTeamRsp.emptyLongList();
            private int retcode_;
            private long curAvatarGuid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SetUpAvatarTeamRspOuterClass.internal_static_SetUpAvatarTeamRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SetUpAvatarTeamRspOuterClass.internal_static_SetUpAvatarTeamRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SetUpAvatarTeamRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SetUpAvatarTeamRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.teamId_ = 0;
                this.avatarTeamGuidList_ = SetUpAvatarTeamRsp.emptyLongList();
                this.bitField0_ &= -2;
                this.retcode_ = 0;
                this.curAvatarGuid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SetUpAvatarTeamRspOuterClass.internal_static_SetUpAvatarTeamRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SetUpAvatarTeamRsp getDefaultInstanceForType() {
                return SetUpAvatarTeamRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetUpAvatarTeamRsp build() {
                SetUpAvatarTeamRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetUpAvatarTeamRsp buildPartial() {
                SetUpAvatarTeamRsp result = new SetUpAvatarTeamRsp(this);
                int i = this.bitField0_;
                result.teamId_ = this.teamId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.avatarTeamGuidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.avatarTeamGuidList_ = this.avatarTeamGuidList_;
                result.retcode_ = this.retcode_;
                result.curAvatarGuid_ = this.curAvatarGuid_;
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
                if (other instanceof SetUpAvatarTeamRsp) {
                    return mergeFrom((SetUpAvatarTeamRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SetUpAvatarTeamRsp other) {
                if (other == SetUpAvatarTeamRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getTeamId() != 0) {
                    setTeamId(other.getTeamId());
                }
                if (!other.avatarTeamGuidList_.isEmpty()) {
                    if (this.avatarTeamGuidList_.isEmpty()) {
                        this.avatarTeamGuidList_ = other.avatarTeamGuidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAvatarTeamGuidListIsMutable();
                        this.avatarTeamGuidList_.addAll(other.avatarTeamGuidList_);
                    }
                    onChanged();
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getCurAvatarGuid() != 0) {
                    setCurAvatarGuid(other.getCurAvatarGuid());
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
                SetUpAvatarTeamRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = SetUpAvatarTeamRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SetUpAvatarTeamRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRspOrBuilder
            public int getTeamId() {
                return this.teamId_;
            }

            public Builder setTeamId(int value) {
                this.teamId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTeamId() {
                this.teamId_ = 0;
                onChanged();
                return this;
            }

            private void ensureAvatarTeamGuidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.avatarTeamGuidList_ = SetUpAvatarTeamRsp.mutableCopy(this.avatarTeamGuidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRspOrBuilder
            public List<Long> getAvatarTeamGuidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.avatarTeamGuidList_) : this.avatarTeamGuidList_;
            }

            @Override // emu.grasscutter.net.proto.SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRspOrBuilder
            public int getAvatarTeamGuidListCount() {
                return this.avatarTeamGuidList_.size();
            }

            @Override // emu.grasscutter.net.proto.SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRspOrBuilder
            public long getAvatarTeamGuidList(int index) {
                return this.avatarTeamGuidList_.getLong(index);
            }

            public Builder setAvatarTeamGuidList(int index, long value) {
                ensureAvatarTeamGuidListIsMutable();
                this.avatarTeamGuidList_.setLong(index, value);
                onChanged();
                return this;
            }

            public Builder addAvatarTeamGuidList(long value) {
                ensureAvatarTeamGuidListIsMutable();
                this.avatarTeamGuidList_.addLong(value);
                onChanged();
                return this;
            }

            public Builder addAllAvatarTeamGuidList(Iterable<? extends Long> values) {
                ensureAvatarTeamGuidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarTeamGuidList_);
                onChanged();
                return this;
            }

            public Builder clearAvatarTeamGuidList() {
                this.avatarTeamGuidList_ = SetUpAvatarTeamRsp.emptyLongList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static SetUpAvatarTeamRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetUpAvatarTeamRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SetUpAvatarTeamRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SetUpAvatarTeamRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
