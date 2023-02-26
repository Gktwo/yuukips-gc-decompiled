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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTeamResonanceInfoOuterClass.class */
public final class AvatarTeamResonanceInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dAvatarTeamResonanceInfo.proto\"\n\u0017AvatarTeamResonanceInfo\u0012\u0012\n\navatarGuid\u0018\n \u0001(\u0004\u0012\u001e\n\u0016delTeamResonanceIdList\u0018\b \u0003(\r\u0012\u0010\n\bentityId\u0018\u000f \u0001(\r\u0012\u001e\n\u0016addTeamResonanceIdList\u0018\u0002 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarTeamResonanceInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarTeamResonanceInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarTeamResonanceInfo_descriptor, new String[]{"AvatarGuid", "DelTeamResonanceIdList", "EntityId", "AddTeamResonanceIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTeamResonanceInfoOuterClass$AvatarTeamResonanceInfoOrBuilder.class */
    public interface AvatarTeamResonanceInfoOrBuilder extends MessageOrBuilder {
        long getAvatarGuid();

        List<Integer> getDelTeamResonanceIdListList();

        int getDelTeamResonanceIdListCount();

        int getDelTeamResonanceIdList(int i);

        int getEntityId();

        List<Integer> getAddTeamResonanceIdListList();

        int getAddTeamResonanceIdListCount();

        int getAddTeamResonanceIdList(int i);
    }

    private AvatarTeamResonanceInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTeamResonanceInfoOuterClass$AvatarTeamResonanceInfo.class */
    public static final class AvatarTeamResonanceInfo extends GeneratedMessageV3 implements AvatarTeamResonanceInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATARGUID_FIELD_NUMBER = 10;
        private long avatarGuid_;
        public static final int DELTEAMRESONANCEIDLIST_FIELD_NUMBER = 8;
        private Internal.IntList delTeamResonanceIdList_;
        private int delTeamResonanceIdListMemoizedSerializedSize;
        public static final int ENTITYID_FIELD_NUMBER = 15;
        private int entityId_;
        public static final int ADDTEAMRESONANCEIDLIST_FIELD_NUMBER = 2;
        private Internal.IntList addTeamResonanceIdList_;
        private int addTeamResonanceIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final AvatarTeamResonanceInfo DEFAULT_INSTANCE = new AvatarTeamResonanceInfo();
        private static final Parser<AvatarTeamResonanceInfo> PARSER = new AbstractParser<AvatarTeamResonanceInfo>() { // from class: emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfo.1
            @Override // com.google.protobuf.Parser
            public AvatarTeamResonanceInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarTeamResonanceInfo(input, extensionRegistry);
            }
        };

        private AvatarTeamResonanceInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.delTeamResonanceIdListMemoizedSerializedSize = -1;
            this.addTeamResonanceIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AvatarTeamResonanceInfo() {
            this.delTeamResonanceIdListMemoizedSerializedSize = -1;
            this.addTeamResonanceIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.delTeamResonanceIdList_ = emptyIntList();
            this.addTeamResonanceIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarTeamResonanceInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x0162 */
        private AvatarTeamResonanceInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.addTeamResonanceIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.addTeamResonanceIdList_.addInt(input.readUInt32());
                                break;
                            case 18:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.addTeamResonanceIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.addTeamResonanceIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 64:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.delTeamResonanceIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.delTeamResonanceIdList_.addInt(input.readUInt32());
                                break;
                            case 66:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.delTeamResonanceIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.delTeamResonanceIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 80:
                                this.avatarGuid_ = input.readUInt64();
                                break;
                            case 120:
                                this.entityId_ = input.readUInt32();
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
                    this.addTeamResonanceIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.delTeamResonanceIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarTeamResonanceInfoOuterClass.internal_static_AvatarTeamResonanceInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarTeamResonanceInfoOuterClass.internal_static_AvatarTeamResonanceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarTeamResonanceInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
        public List<Integer> getDelTeamResonanceIdListList() {
            return this.delTeamResonanceIdList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
        public int getDelTeamResonanceIdListCount() {
            return this.delTeamResonanceIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
        public int getDelTeamResonanceIdList(int index) {
            return this.delTeamResonanceIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
        public List<Integer> getAddTeamResonanceIdListList() {
            return this.addTeamResonanceIdList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
        public int getAddTeamResonanceIdListCount() {
            return this.addTeamResonanceIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
        public int getAddTeamResonanceIdList(int index) {
            return this.addTeamResonanceIdList_.getInt(index);
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
            if (getAddTeamResonanceIdListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.addTeamResonanceIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.addTeamResonanceIdList_.size(); i++) {
                output.writeUInt32NoTag(this.addTeamResonanceIdList_.getInt(i));
            }
            if (getDelTeamResonanceIdListList().size() > 0) {
                output.writeUInt32NoTag(66);
                output.writeUInt32NoTag(this.delTeamResonanceIdListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.delTeamResonanceIdList_.size(); i2++) {
                output.writeUInt32NoTag(this.delTeamResonanceIdList_.getInt(i2));
            }
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(10, this.avatarGuid_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(15, this.entityId_);
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
            for (int i = 0; i < this.addTeamResonanceIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.addTeamResonanceIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getAddTeamResonanceIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.addTeamResonanceIdListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.delTeamResonanceIdList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.delTeamResonanceIdList_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getDelTeamResonanceIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.delTeamResonanceIdListMemoizedSerializedSize = dataSize2;
            if (this.avatarGuid_ != 0) {
                size3 += CodedOutputStream.computeUInt64Size(10, this.avatarGuid_);
            }
            if (this.entityId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(15, this.entityId_);
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
            if (!(obj instanceof AvatarTeamResonanceInfo)) {
                return equals(obj);
            }
            AvatarTeamResonanceInfo other = (AvatarTeamResonanceInfo) obj;
            return getAvatarGuid() == other.getAvatarGuid() && getDelTeamResonanceIdListList().equals(other.getDelTeamResonanceIdListList()) && getEntityId() == other.getEntityId() && getAddTeamResonanceIdListList().equals(other.getAddTeamResonanceIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + Internal.hashLong(getAvatarGuid());
            if (getDelTeamResonanceIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getDelTeamResonanceIdListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 15)) + getEntityId();
            if (getAddTeamResonanceIdListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 2)) + getAddTeamResonanceIdListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static AvatarTeamResonanceInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarTeamResonanceInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarTeamResonanceInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarTeamResonanceInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarTeamResonanceInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarTeamResonanceInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarTeamResonanceInfo parseFrom(InputStream input) throws IOException {
            return (AvatarTeamResonanceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarTeamResonanceInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarTeamResonanceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarTeamResonanceInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarTeamResonanceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarTeamResonanceInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarTeamResonanceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarTeamResonanceInfo parseFrom(CodedInputStream input) throws IOException {
            return (AvatarTeamResonanceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarTeamResonanceInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarTeamResonanceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarTeamResonanceInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTeamResonanceInfoOuterClass$AvatarTeamResonanceInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarTeamResonanceInfoOrBuilder {
            private int bitField0_;
            private long avatarGuid_;
            private int entityId_;
            private Internal.IntList delTeamResonanceIdList_ = AvatarTeamResonanceInfo.emptyIntList();
            private Internal.IntList addTeamResonanceIdList_ = AvatarTeamResonanceInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarTeamResonanceInfoOuterClass.internal_static_AvatarTeamResonanceInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarTeamResonanceInfoOuterClass.internal_static_AvatarTeamResonanceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarTeamResonanceInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarTeamResonanceInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.avatarGuid_ = 0;
                this.delTeamResonanceIdList_ = AvatarTeamResonanceInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.entityId_ = 0;
                this.addTeamResonanceIdList_ = AvatarTeamResonanceInfo.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarTeamResonanceInfoOuterClass.internal_static_AvatarTeamResonanceInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarTeamResonanceInfo getDefaultInstanceForType() {
                return AvatarTeamResonanceInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarTeamResonanceInfo build() {
                AvatarTeamResonanceInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarTeamResonanceInfo buildPartial() {
                AvatarTeamResonanceInfo result = new AvatarTeamResonanceInfo(this);
                int i = this.bitField0_;
                result.avatarGuid_ = this.avatarGuid_;
                if ((this.bitField0_ & 1) != 0) {
                    this.delTeamResonanceIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.delTeamResonanceIdList_ = this.delTeamResonanceIdList_;
                result.entityId_ = this.entityId_;
                if ((this.bitField0_ & 2) != 0) {
                    this.addTeamResonanceIdList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.addTeamResonanceIdList_ = this.addTeamResonanceIdList_;
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
                if (other instanceof AvatarTeamResonanceInfo) {
                    return mergeFrom((AvatarTeamResonanceInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarTeamResonanceInfo other) {
                if (other == AvatarTeamResonanceInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (!other.delTeamResonanceIdList_.isEmpty()) {
                    if (this.delTeamResonanceIdList_.isEmpty()) {
                        this.delTeamResonanceIdList_ = other.delTeamResonanceIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureDelTeamResonanceIdListIsMutable();
                        this.delTeamResonanceIdList_.addAll(other.delTeamResonanceIdList_);
                    }
                    onChanged();
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (!other.addTeamResonanceIdList_.isEmpty()) {
                    if (this.addTeamResonanceIdList_.isEmpty()) {
                        this.addTeamResonanceIdList_ = other.addTeamResonanceIdList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureAddTeamResonanceIdListIsMutable();
                        this.addTeamResonanceIdList_.addAll(other.addTeamResonanceIdList_);
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
                AvatarTeamResonanceInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarTeamResonanceInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarTeamResonanceInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
            public long getAvatarGuid() {
                return this.avatarGuid_;
            }

            public Builder setAvatarGuid(long value) {
                this.avatarGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarGuid() {
                this.avatarGuid_ = 0;
                onChanged();
                return this;
            }

            private void ensureDelTeamResonanceIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.delTeamResonanceIdList_ = AvatarTeamResonanceInfo.mutableCopy(this.delTeamResonanceIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
            public List<Integer> getDelTeamResonanceIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.delTeamResonanceIdList_) : this.delTeamResonanceIdList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
            public int getDelTeamResonanceIdListCount() {
                return this.delTeamResonanceIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
            public int getDelTeamResonanceIdList(int index) {
                return this.delTeamResonanceIdList_.getInt(index);
            }

            public Builder setDelTeamResonanceIdList(int index, int value) {
                ensureDelTeamResonanceIdListIsMutable();
                this.delTeamResonanceIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addDelTeamResonanceIdList(int value) {
                ensureDelTeamResonanceIdListIsMutable();
                this.delTeamResonanceIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllDelTeamResonanceIdList(Iterable<? extends Integer> values) {
                ensureDelTeamResonanceIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.delTeamResonanceIdList_);
                onChanged();
                return this;
            }

            public Builder clearDelTeamResonanceIdList() {
                this.delTeamResonanceIdList_ = AvatarTeamResonanceInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
                onChanged();
                return this;
            }

            private void ensureAddTeamResonanceIdListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.addTeamResonanceIdList_ = AvatarTeamResonanceInfo.mutableCopy(this.addTeamResonanceIdList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
            public List<Integer> getAddTeamResonanceIdListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.addTeamResonanceIdList_) : this.addTeamResonanceIdList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
            public int getAddTeamResonanceIdListCount() {
                return this.addTeamResonanceIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamResonanceInfoOuterClass.AvatarTeamResonanceInfoOrBuilder
            public int getAddTeamResonanceIdList(int index) {
                return this.addTeamResonanceIdList_.getInt(index);
            }

            public Builder setAddTeamResonanceIdList(int index, int value) {
                ensureAddTeamResonanceIdListIsMutable();
                this.addTeamResonanceIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addAddTeamResonanceIdList(int value) {
                ensureAddTeamResonanceIdListIsMutable();
                this.addTeamResonanceIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllAddTeamResonanceIdList(Iterable<? extends Integer> values) {
                ensureAddTeamResonanceIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.addTeamResonanceIdList_);
                onChanged();
                return this;
            }

            public Builder clearAddTeamResonanceIdList() {
                this.addTeamResonanceIdList_ = AvatarTeamResonanceInfo.emptyIntList();
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

        public static AvatarTeamResonanceInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarTeamResonanceInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarTeamResonanceInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarTeamResonanceInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
