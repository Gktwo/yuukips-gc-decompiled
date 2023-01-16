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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonChallengeBeginNotifyOuterClass.class */
public final class DungeonChallengeBeginNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!DungeonChallengeBeginNotify.proto\"\u0001\n\u001bDungeonChallengeBeginNotify\u0012\u0017\n\u000fchallenge_index\u0018\u0003 \u0001(\r\u0012\u0014\n\ffather_index\u0018\r \u0001(\r\u0012\u0010\n\bgroup_id\u0018\u000f \u0001(\r\u0012\u0010\n\buid_list\u0018\b \u0003(\r\u0012\u0014\n\fchallenge_id\u0018\u0007 \u0001(\r\u0012\u0012\n\nparam_list\u0018\u0002 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DungeonChallengeBeginNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DungeonChallengeBeginNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DungeonChallengeBeginNotify_descriptor, new String[]{"ChallengeIndex", "FatherIndex", "GroupId", "UidList", "ChallengeId", "ParamList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonChallengeBeginNotifyOuterClass$DungeonChallengeBeginNotifyOrBuilder.class */
    public interface DungeonChallengeBeginNotifyOrBuilder extends MessageOrBuilder {
        int getChallengeIndex();

        int getFatherIndex();

        int getGroupId();

        List<Integer> getUidListList();

        int getUidListCount();

        int getUidList(int i);

        int getChallengeId();

        List<Integer> getParamListList();

        int getParamListCount();

        int getParamList(int i);
    }

    private DungeonChallengeBeginNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonChallengeBeginNotifyOuterClass$DungeonChallengeBeginNotify.class */
    public static final class DungeonChallengeBeginNotify extends GeneratedMessageV3 implements DungeonChallengeBeginNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHALLENGE_INDEX_FIELD_NUMBER = 3;
        private int challengeIndex_;
        public static final int FATHER_INDEX_FIELD_NUMBER = 13;
        private int fatherIndex_;
        public static final int GROUP_ID_FIELD_NUMBER = 15;
        private int groupId_;
        public static final int UID_LIST_FIELD_NUMBER = 8;
        private Internal.IntList uidList_;
        private int uidListMemoizedSerializedSize;
        public static final int CHALLENGE_ID_FIELD_NUMBER = 7;
        private int challengeId_;
        public static final int PARAM_LIST_FIELD_NUMBER = 2;
        private Internal.IntList paramList_;
        private int paramListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final DungeonChallengeBeginNotify DEFAULT_INSTANCE = new DungeonChallengeBeginNotify();
        private static final Parser<DungeonChallengeBeginNotify> PARSER = new AbstractParser<DungeonChallengeBeginNotify>() { // from class: emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotify.1
            @Override // com.google.protobuf.Parser
            public DungeonChallengeBeginNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DungeonChallengeBeginNotify(input, extensionRegistry);
            }
        };

        private DungeonChallengeBeginNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.uidListMemoizedSerializedSize = -1;
            this.paramListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private DungeonChallengeBeginNotify() {
            this.uidListMemoizedSerializedSize = -1;
            this.paramListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.uidList_ = emptyIntList();
            this.paramList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DungeonChallengeBeginNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x0188 */
        private DungeonChallengeBeginNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.paramList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.paramList_.addInt(input.readUInt32());
                                    break;
                                case 18:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.paramList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.paramList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 24:
                                    this.challengeIndex_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.challengeId_ = input.readUInt32();
                                    break;
                                case 64:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.uidList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.uidList_.addInt(input.readUInt32());
                                    break;
                                case 66:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.uidList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.uidList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                case 104:
                                    this.fatherIndex_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.groupId_ = input.readUInt32();
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.paramList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.uidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DungeonChallengeBeginNotifyOuterClass.internal_static_DungeonChallengeBeginNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DungeonChallengeBeginNotifyOuterClass.internal_static_DungeonChallengeBeginNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonChallengeBeginNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
        public int getChallengeIndex() {
            return this.challengeIndex_;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
        public int getFatherIndex() {
            return this.fatherIndex_;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
        public List<Integer> getUidListList() {
            return this.uidList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
        public int getUidListCount() {
            return this.uidList_.size();
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
        public int getUidList(int index) {
            return this.uidList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
        public int getChallengeId() {
            return this.challengeId_;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
        public List<Integer> getParamListList() {
            return this.paramList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
        public int getParamListCount() {
            return this.paramList_.size();
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
        public int getParamList(int index) {
            return this.paramList_.getInt(index);
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
            if (getParamListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.paramListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.paramList_.size(); i++) {
                output.writeUInt32NoTag(this.paramList_.getInt(i));
            }
            if (this.challengeIndex_ != 0) {
                output.writeUInt32(3, this.challengeIndex_);
            }
            if (this.challengeId_ != 0) {
                output.writeUInt32(7, this.challengeId_);
            }
            if (getUidListList().size() > 0) {
                output.writeUInt32NoTag(66);
                output.writeUInt32NoTag(this.uidListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.uidList_.size(); i2++) {
                output.writeUInt32NoTag(this.uidList_.getInt(i2));
            }
            if (this.fatherIndex_ != 0) {
                output.writeUInt32(13, this.fatherIndex_);
            }
            if (this.groupId_ != 0) {
                output.writeUInt32(15, this.groupId_);
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
            for (int i = 0; i < this.paramList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.paramList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getParamListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.paramListMemoizedSerializedSize = dataSize;
            if (this.challengeIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.challengeIndex_);
            }
            if (this.challengeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.challengeId_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.uidList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.uidList_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getUidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.uidListMemoizedSerializedSize = dataSize2;
            if (this.fatherIndex_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(13, this.fatherIndex_);
            }
            if (this.groupId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(15, this.groupId_);
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
            if (!(obj instanceof DungeonChallengeBeginNotify)) {
                return equals(obj);
            }
            DungeonChallengeBeginNotify other = (DungeonChallengeBeginNotify) obj;
            return getChallengeIndex() == other.getChallengeIndex() && getFatherIndex() == other.getFatherIndex() && getGroupId() == other.getGroupId() && getUidListList().equals(other.getUidListList()) && getChallengeId() == other.getChallengeId() && getParamListList().equals(other.getParamListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getChallengeIndex())) + 13)) + getFatherIndex())) + 15)) + getGroupId();
            if (getUidListCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getUidListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 7)) + getChallengeId();
            if (getParamListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 2)) + getParamListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static DungeonChallengeBeginNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonChallengeBeginNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonChallengeBeginNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonChallengeBeginNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonChallengeBeginNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonChallengeBeginNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonChallengeBeginNotify parseFrom(InputStream input) throws IOException {
            return (DungeonChallengeBeginNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonChallengeBeginNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonChallengeBeginNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonChallengeBeginNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (DungeonChallengeBeginNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DungeonChallengeBeginNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonChallengeBeginNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonChallengeBeginNotify parseFrom(CodedInputStream input) throws IOException {
            return (DungeonChallengeBeginNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonChallengeBeginNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonChallengeBeginNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DungeonChallengeBeginNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonChallengeBeginNotifyOuterClass$DungeonChallengeBeginNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DungeonChallengeBeginNotifyOrBuilder {
            private int bitField0_;
            private int challengeIndex_;
            private int fatherIndex_;
            private int groupId_;
            private int challengeId_;
            private Internal.IntList uidList_ = DungeonChallengeBeginNotify.emptyIntList();
            private Internal.IntList paramList_ = DungeonChallengeBeginNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return DungeonChallengeBeginNotifyOuterClass.internal_static_DungeonChallengeBeginNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DungeonChallengeBeginNotifyOuterClass.internal_static_DungeonChallengeBeginNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonChallengeBeginNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DungeonChallengeBeginNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.challengeIndex_ = 0;
                this.fatherIndex_ = 0;
                this.groupId_ = 0;
                this.uidList_ = DungeonChallengeBeginNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.challengeId_ = 0;
                this.paramList_ = DungeonChallengeBeginNotify.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DungeonChallengeBeginNotifyOuterClass.internal_static_DungeonChallengeBeginNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DungeonChallengeBeginNotify getDefaultInstanceForType() {
                return DungeonChallengeBeginNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonChallengeBeginNotify build() {
                DungeonChallengeBeginNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonChallengeBeginNotify buildPartial() {
                DungeonChallengeBeginNotify result = new DungeonChallengeBeginNotify(this);
                int i = this.bitField0_;
                result.challengeIndex_ = this.challengeIndex_;
                result.fatherIndex_ = this.fatherIndex_;
                result.groupId_ = this.groupId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.uidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.uidList_ = this.uidList_;
                result.challengeId_ = this.challengeId_;
                if ((this.bitField0_ & 2) != 0) {
                    this.paramList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.paramList_ = this.paramList_;
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
                if (other instanceof DungeonChallengeBeginNotify) {
                    return mergeFrom((DungeonChallengeBeginNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DungeonChallengeBeginNotify other) {
                if (other == DungeonChallengeBeginNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getChallengeIndex() != 0) {
                    setChallengeIndex(other.getChallengeIndex());
                }
                if (other.getFatherIndex() != 0) {
                    setFatherIndex(other.getFatherIndex());
                }
                if (other.getGroupId() != 0) {
                    setGroupId(other.getGroupId());
                }
                if (!other.uidList_.isEmpty()) {
                    if (this.uidList_.isEmpty()) {
                        this.uidList_ = other.uidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUidListIsMutable();
                        this.uidList_.addAll(other.uidList_);
                    }
                    onChanged();
                }
                if (other.getChallengeId() != 0) {
                    setChallengeId(other.getChallengeId());
                }
                if (!other.paramList_.isEmpty()) {
                    if (this.paramList_.isEmpty()) {
                        this.paramList_ = other.paramList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureParamListIsMutable();
                        this.paramList_.addAll(other.paramList_);
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
                DungeonChallengeBeginNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = DungeonChallengeBeginNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DungeonChallengeBeginNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
            public int getChallengeIndex() {
                return this.challengeIndex_;
            }

            public Builder setChallengeIndex(int value) {
                this.challengeIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeIndex() {
                this.challengeIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
            public int getFatherIndex() {
                return this.fatherIndex_;
            }

            public Builder setFatherIndex(int value) {
                this.fatherIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearFatherIndex() {
                this.fatherIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
            public int getGroupId() {
                return this.groupId_;
            }

            public Builder setGroupId(int value) {
                this.groupId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGroupId() {
                this.groupId_ = 0;
                onChanged();
                return this;
            }

            private void ensureUidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.uidList_ = DungeonChallengeBeginNotify.mutableCopy(this.uidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
            public List<Integer> getUidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.uidList_) : this.uidList_;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
            public int getUidListCount() {
                return this.uidList_.size();
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
            public int getUidList(int index) {
                return this.uidList_.getInt(index);
            }

            public Builder setUidList(int index, int value) {
                ensureUidListIsMutable();
                this.uidList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUidList(int value) {
                ensureUidListIsMutable();
                this.uidList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUidList(Iterable<? extends Integer> values) {
                ensureUidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.uidList_);
                onChanged();
                return this;
            }

            public Builder clearUidList() {
                this.uidList_ = DungeonChallengeBeginNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
            public int getChallengeId() {
                return this.challengeId_;
            }

            public Builder setChallengeId(int value) {
                this.challengeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeId() {
                this.challengeId_ = 0;
                onChanged();
                return this;
            }

            private void ensureParamListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.paramList_ = DungeonChallengeBeginNotify.mutableCopy(this.paramList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
            public List<Integer> getParamListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.paramList_) : this.paramList_;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
            public int getParamListCount() {
                return this.paramList_.size();
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotifyOrBuilder
            public int getParamList(int index) {
                return this.paramList_.getInt(index);
            }

            public Builder setParamList(int index, int value) {
                ensureParamListIsMutable();
                this.paramList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addParamList(int value) {
                ensureParamListIsMutable();
                this.paramList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllParamList(Iterable<? extends Integer> values) {
                ensureParamListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.paramList_);
                onChanged();
                return this;
            }

            public Builder clearParamList() {
                this.paramList_ = DungeonChallengeBeginNotify.emptyIntList();
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

        public static DungeonChallengeBeginNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DungeonChallengeBeginNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DungeonChallengeBeginNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DungeonChallengeBeginNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
