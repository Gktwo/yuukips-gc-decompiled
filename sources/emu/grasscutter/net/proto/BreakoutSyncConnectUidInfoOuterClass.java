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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutSyncConnectUidInfoOuterClass.class */
public final class BreakoutSyncConnectUidInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n BreakoutSyncConnectUidInfo.proto\"Z\n\u001aBreakoutSyncConnectUidInfo\u0012\u000b\n\u0003uid\u0018\u0001 \u0001(\r\u0012\u0015\n\rskill_id_list\u0018\u0002 \u0003(\r\u0012\u0018\n\u0010skill_level_list\u0018\u0003 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BreakoutSyncConnectUidInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BreakoutSyncConnectUidInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BreakoutSyncConnectUidInfo_descriptor, new String[]{"Uid", "SkillIdList", "SkillLevelList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutSyncConnectUidInfoOuterClass$BreakoutSyncConnectUidInfoOrBuilder.class */
    public interface BreakoutSyncConnectUidInfoOrBuilder extends MessageOrBuilder {
        int getUid();

        List<Integer> getSkillIdListList();

        int getSkillIdListCount();

        int getSkillIdList(int i);

        List<Integer> getSkillLevelListList();

        int getSkillLevelListCount();

        int getSkillLevelList(int i);
    }

    private BreakoutSyncConnectUidInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutSyncConnectUidInfoOuterClass$BreakoutSyncConnectUidInfo.class */
    public static final class BreakoutSyncConnectUidInfo extends GeneratedMessageV3 implements BreakoutSyncConnectUidInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UID_FIELD_NUMBER = 1;
        private int uid_;
        public static final int SKILL_ID_LIST_FIELD_NUMBER = 2;
        private Internal.IntList skillIdList_;
        private int skillIdListMemoizedSerializedSize;
        public static final int SKILL_LEVEL_LIST_FIELD_NUMBER = 3;
        private Internal.IntList skillLevelList_;
        private int skillLevelListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final BreakoutSyncConnectUidInfo DEFAULT_INSTANCE = new BreakoutSyncConnectUidInfo();
        private static final Parser<BreakoutSyncConnectUidInfo> PARSER = new AbstractParser<BreakoutSyncConnectUidInfo>() { // from class: emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo.1
            @Override // com.google.protobuf.Parser
            public BreakoutSyncConnectUidInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BreakoutSyncConnectUidInfo(input, extensionRegistry);
            }
        };

        private BreakoutSyncConnectUidInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.skillIdListMemoizedSerializedSize = -1;
            this.skillLevelListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private BreakoutSyncConnectUidInfo() {
            this.skillIdListMemoizedSerializedSize = -1;
            this.skillLevelListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.skillIdList_ = emptyIntList();
            this.skillLevelList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BreakoutSyncConnectUidInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x014f */
        private BreakoutSyncConnectUidInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.uid_ = input.readUInt32();
                                break;
                            case 16:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.skillIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.skillIdList_.addInt(input.readUInt32());
                                break;
                            case 18:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.skillIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.skillIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 24:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.skillLevelList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.skillLevelList_.addInt(input.readUInt32());
                                break;
                            case 26:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.skillLevelList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.skillLevelList_.addInt(input.readUInt32());
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.skillIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.skillLevelList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BreakoutSyncConnectUidInfoOuterClass.internal_static_BreakoutSyncConnectUidInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BreakoutSyncConnectUidInfoOuterClass.internal_static_BreakoutSyncConnectUidInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BreakoutSyncConnectUidInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder
        public List<Integer> getSkillIdListList() {
            return this.skillIdList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder
        public int getSkillIdListCount() {
            return this.skillIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder
        public int getSkillIdList(int index) {
            return this.skillIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder
        public List<Integer> getSkillLevelListList() {
            return this.skillLevelList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder
        public int getSkillLevelListCount() {
            return this.skillLevelList_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder
        public int getSkillLevelList(int index) {
            return this.skillLevelList_.getInt(index);
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
            if (this.uid_ != 0) {
                output.writeUInt32(1, this.uid_);
            }
            if (getSkillIdListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.skillIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.skillIdList_.size(); i++) {
                output.writeUInt32NoTag(this.skillIdList_.getInt(i));
            }
            if (getSkillLevelListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.skillLevelListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.skillLevelList_.size(); i2++) {
                output.writeUInt32NoTag(this.skillLevelList_.getInt(i2));
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
            if (this.uid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.uid_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.skillIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.skillIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getSkillIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.skillIdListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.skillLevelList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.skillLevelList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getSkillLevelListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.skillLevelListMemoizedSerializedSize = dataSize2;
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BreakoutSyncConnectUidInfo)) {
                return equals(obj);
            }
            BreakoutSyncConnectUidInfo other = (BreakoutSyncConnectUidInfo) obj;
            return getUid() == other.getUid() && getSkillIdListList().equals(other.getSkillIdListList()) && getSkillLevelListList().equals(other.getSkillLevelListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getUid();
            if (getSkillIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getSkillIdListList().hashCode();
            }
            if (getSkillLevelListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getSkillLevelListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BreakoutSyncConnectUidInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutSyncConnectUidInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutSyncConnectUidInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutSyncConnectUidInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutSyncConnectUidInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutSyncConnectUidInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutSyncConnectUidInfo parseFrom(InputStream input) throws IOException {
            return (BreakoutSyncConnectUidInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutSyncConnectUidInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutSyncConnectUidInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutSyncConnectUidInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BreakoutSyncConnectUidInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BreakoutSyncConnectUidInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutSyncConnectUidInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutSyncConnectUidInfo parseFrom(CodedInputStream input) throws IOException {
            return (BreakoutSyncConnectUidInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutSyncConnectUidInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutSyncConnectUidInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BreakoutSyncConnectUidInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutSyncConnectUidInfoOuterClass$BreakoutSyncConnectUidInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BreakoutSyncConnectUidInfoOrBuilder {
            private int bitField0_;
            private int uid_;
            private Internal.IntList skillIdList_ = BreakoutSyncConnectUidInfo.emptyIntList();
            private Internal.IntList skillLevelList_ = BreakoutSyncConnectUidInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return BreakoutSyncConnectUidInfoOuterClass.internal_static_BreakoutSyncConnectUidInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BreakoutSyncConnectUidInfoOuterClass.internal_static_BreakoutSyncConnectUidInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BreakoutSyncConnectUidInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BreakoutSyncConnectUidInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.uid_ = 0;
                this.skillIdList_ = BreakoutSyncConnectUidInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.skillLevelList_ = BreakoutSyncConnectUidInfo.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BreakoutSyncConnectUidInfoOuterClass.internal_static_BreakoutSyncConnectUidInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BreakoutSyncConnectUidInfo getDefaultInstanceForType() {
                return BreakoutSyncConnectUidInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutSyncConnectUidInfo build() {
                BreakoutSyncConnectUidInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutSyncConnectUidInfo buildPartial() {
                BreakoutSyncConnectUidInfo result = new BreakoutSyncConnectUidInfo(this);
                int i = this.bitField0_;
                result.uid_ = this.uid_;
                if ((this.bitField0_ & 1) != 0) {
                    this.skillIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.skillIdList_ = this.skillIdList_;
                if ((this.bitField0_ & 2) != 0) {
                    this.skillLevelList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.skillLevelList_ = this.skillLevelList_;
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
                if (other instanceof BreakoutSyncConnectUidInfo) {
                    return mergeFrom((BreakoutSyncConnectUidInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BreakoutSyncConnectUidInfo other) {
                if (other == BreakoutSyncConnectUidInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (!other.skillIdList_.isEmpty()) {
                    if (this.skillIdList_.isEmpty()) {
                        this.skillIdList_ = other.skillIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureSkillIdListIsMutable();
                        this.skillIdList_.addAll(other.skillIdList_);
                    }
                    onChanged();
                }
                if (!other.skillLevelList_.isEmpty()) {
                    if (this.skillLevelList_.isEmpty()) {
                        this.skillLevelList_ = other.skillLevelList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureSkillLevelListIsMutable();
                        this.skillLevelList_.addAll(other.skillLevelList_);
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
                BreakoutSyncConnectUidInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BreakoutSyncConnectUidInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BreakoutSyncConnectUidInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public Builder setUid(int value) {
                this.uid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            private void ensureSkillIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.skillIdList_ = BreakoutSyncConnectUidInfo.mutableCopy(this.skillIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder
            public List<Integer> getSkillIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.skillIdList_) : this.skillIdList_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder
            public int getSkillIdListCount() {
                return this.skillIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder
            public int getSkillIdList(int index) {
                return this.skillIdList_.getInt(index);
            }

            public Builder setSkillIdList(int index, int value) {
                ensureSkillIdListIsMutable();
                this.skillIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addSkillIdList(int value) {
                ensureSkillIdListIsMutable();
                this.skillIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllSkillIdList(Iterable<? extends Integer> values) {
                ensureSkillIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.skillIdList_);
                onChanged();
                return this;
            }

            public Builder clearSkillIdList() {
                this.skillIdList_ = BreakoutSyncConnectUidInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureSkillLevelListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.skillLevelList_ = BreakoutSyncConnectUidInfo.mutableCopy(this.skillLevelList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder
            public List<Integer> getSkillLevelListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.skillLevelList_) : this.skillLevelList_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder
            public int getSkillLevelListCount() {
                return this.skillLevelList_.size();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder
            public int getSkillLevelList(int index) {
                return this.skillLevelList_.getInt(index);
            }

            public Builder setSkillLevelList(int index, int value) {
                ensureSkillLevelListIsMutable();
                this.skillLevelList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addSkillLevelList(int value) {
                ensureSkillLevelListIsMutable();
                this.skillLevelList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllSkillLevelList(Iterable<? extends Integer> values) {
                ensureSkillLevelListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.skillLevelList_);
                onChanged();
                return this;
            }

            public Builder clearSkillLevelList() {
                this.skillLevelList_ = BreakoutSyncConnectUidInfo.emptyIntList();
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

        public static BreakoutSyncConnectUidInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BreakoutSyncConnectUidInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BreakoutSyncConnectUidInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BreakoutSyncConnectUidInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
