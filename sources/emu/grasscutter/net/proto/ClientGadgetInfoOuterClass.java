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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientGadgetInfoOuterClass.class */
public final class ClientGadgetInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016ClientGadgetInfo.proto\"Ê\u0001\n\u0010ClientGadgetInfo\u0012\u000f\n\u0007camp_id\u0018\u0001 \u0001(\r\u0012\u0011\n\tcamp_type\u0018\u0002 \u0001(\r\u0012\f\n\u0004guid\u0018\u0003 \u0001(\u0004\u0012\u0017\n\u000fowner_entity_id\u0018\u0004 \u0001(\r\u0012\u0018\n\u0010target_entity_id\u0018\u0005 \u0001(\r\u0012\u0012\n\nasync_load\u0018\u0006 \u0001(\b\u0012\u001e\n\u0016is_peer_id_from_player\u0018\u0007 \u0001(\b\u0012\u001d\n\u0015target_entity_id_list\u0018\b \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ClientGadgetInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ClientGadgetInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ClientGadgetInfo_descriptor, new String[]{"CampId", "CampType", "Guid", "OwnerEntityId", "TargetEntityId", "AsyncLoad", "IsPeerIdFromPlayer", "TargetEntityIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientGadgetInfoOuterClass$ClientGadgetInfoOrBuilder.class */
    public interface ClientGadgetInfoOrBuilder extends MessageOrBuilder {
        int getCampId();

        int getCampType();

        long getGuid();

        int getOwnerEntityId();

        int getTargetEntityId();

        boolean getAsyncLoad();

        boolean getIsPeerIdFromPlayer();

        List<Integer> getTargetEntityIdListList();

        int getTargetEntityIdListCount();

        int getTargetEntityIdList(int i);
    }

    private ClientGadgetInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientGadgetInfoOuterClass$ClientGadgetInfo.class */
    public static final class ClientGadgetInfo extends GeneratedMessageV3 implements ClientGadgetInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CAMP_ID_FIELD_NUMBER = 1;
        private int campId_;
        public static final int CAMP_TYPE_FIELD_NUMBER = 2;
        private int campType_;
        public static final int GUID_FIELD_NUMBER = 3;
        private long guid_;
        public static final int OWNER_ENTITY_ID_FIELD_NUMBER = 4;
        private int ownerEntityId_;
        public static final int TARGET_ENTITY_ID_FIELD_NUMBER = 5;
        private int targetEntityId_;
        public static final int ASYNC_LOAD_FIELD_NUMBER = 6;
        private boolean asyncLoad_;
        public static final int IS_PEER_ID_FROM_PLAYER_FIELD_NUMBER = 7;
        private boolean isPeerIdFromPlayer_;
        public static final int TARGET_ENTITY_ID_LIST_FIELD_NUMBER = 8;
        private Internal.IntList targetEntityIdList_;
        private int targetEntityIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final ClientGadgetInfo DEFAULT_INSTANCE = new ClientGadgetInfo();
        private static final Parser<ClientGadgetInfo> PARSER = new AbstractParser<ClientGadgetInfo>() { // from class: emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfo.1
            @Override // com.google.protobuf.Parser
            public ClientGadgetInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ClientGadgetInfo(input, extensionRegistry);
            }
        };

        private ClientGadgetInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.targetEntityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ClientGadgetInfo() {
            this.targetEntityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.targetEntityIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ClientGadgetInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ClientGadgetInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.campId_ = input.readUInt32();
                                break;
                            case 16:
                                this.campType_ = input.readUInt32();
                                break;
                            case 24:
                                this.guid_ = input.readUInt64();
                                break;
                            case 32:
                                this.ownerEntityId_ = input.readUInt32();
                                break;
                            case 40:
                                this.targetEntityId_ = input.readUInt32();
                                break;
                            case 48:
                                this.asyncLoad_ = input.readBool();
                                break;
                            case 56:
                                this.isPeerIdFromPlayer_ = input.readBool();
                                break;
                            case 64:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.targetEntityIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.targetEntityIdList_.addInt(input.readUInt32());
                                break;
                            case 66:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.targetEntityIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.targetEntityIdList_.addInt(input.readUInt32());
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.targetEntityIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ClientGadgetInfoOuterClass.internal_static_ClientGadgetInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ClientGadgetInfoOuterClass.internal_static_ClientGadgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientGadgetInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
        public int getCampId() {
            return this.campId_;
        }

        @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
        public int getCampType() {
            return this.campType_;
        }

        @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
        public long getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
        public int getOwnerEntityId() {
            return this.ownerEntityId_;
        }

        @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
        public int getTargetEntityId() {
            return this.targetEntityId_;
        }

        @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
        public boolean getAsyncLoad() {
            return this.asyncLoad_;
        }

        @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
        public boolean getIsPeerIdFromPlayer() {
            return this.isPeerIdFromPlayer_;
        }

        @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
        public List<Integer> getTargetEntityIdListList() {
            return this.targetEntityIdList_;
        }

        @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
        public int getTargetEntityIdListCount() {
            return this.targetEntityIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
        public int getTargetEntityIdList(int index) {
            return this.targetEntityIdList_.getInt(index);
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
            if (this.campId_ != 0) {
                output.writeUInt32(1, this.campId_);
            }
            if (this.campType_ != 0) {
                output.writeUInt32(2, this.campType_);
            }
            if (this.guid_ != 0) {
                output.writeUInt64(3, this.guid_);
            }
            if (this.ownerEntityId_ != 0) {
                output.writeUInt32(4, this.ownerEntityId_);
            }
            if (this.targetEntityId_ != 0) {
                output.writeUInt32(5, this.targetEntityId_);
            }
            if (this.asyncLoad_) {
                output.writeBool(6, this.asyncLoad_);
            }
            if (this.isPeerIdFromPlayer_) {
                output.writeBool(7, this.isPeerIdFromPlayer_);
            }
            if (getTargetEntityIdListList().size() > 0) {
                output.writeUInt32NoTag(66);
                output.writeUInt32NoTag(this.targetEntityIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.targetEntityIdList_.size(); i++) {
                output.writeUInt32NoTag(this.targetEntityIdList_.getInt(i));
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
            if (this.campId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.campId_);
            }
            if (this.campType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.campType_);
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(3, this.guid_);
            }
            if (this.ownerEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.ownerEntityId_);
            }
            if (this.targetEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.targetEntityId_);
            }
            if (this.asyncLoad_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.asyncLoad_);
            }
            if (this.isPeerIdFromPlayer_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isPeerIdFromPlayer_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.targetEntityIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.targetEntityIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getTargetEntityIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.targetEntityIdListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ClientGadgetInfo)) {
                return equals(obj);
            }
            ClientGadgetInfo other = (ClientGadgetInfo) obj;
            return getCampId() == other.getCampId() && getCampType() == other.getCampType() && getGuid() == other.getGuid() && getOwnerEntityId() == other.getOwnerEntityId() && getTargetEntityId() == other.getTargetEntityId() && getAsyncLoad() == other.getAsyncLoad() && getIsPeerIdFromPlayer() == other.getIsPeerIdFromPlayer() && getTargetEntityIdListList().equals(other.getTargetEntityIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getCampId())) + 2)) + getCampType())) + 3)) + Internal.hashLong(getGuid()))) + 4)) + getOwnerEntityId())) + 5)) + getTargetEntityId())) + 6)) + Internal.hashBoolean(getAsyncLoad()))) + 7)) + Internal.hashBoolean(getIsPeerIdFromPlayer());
            if (getTargetEntityIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getTargetEntityIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ClientGadgetInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientGadgetInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientGadgetInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientGadgetInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientGadgetInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientGadgetInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientGadgetInfo parseFrom(InputStream input) throws IOException {
            return (ClientGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ClientGadgetInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ClientGadgetInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ClientGadgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ClientGadgetInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientGadgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ClientGadgetInfo parseFrom(CodedInputStream input) throws IOException {
            return (ClientGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ClientGadgetInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ClientGadgetInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientGadgetInfoOuterClass$ClientGadgetInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ClientGadgetInfoOrBuilder {
            private int bitField0_;
            private int campId_;
            private int campType_;
            private long guid_;
            private int ownerEntityId_;
            private int targetEntityId_;
            private boolean asyncLoad_;
            private boolean isPeerIdFromPlayer_;
            private Internal.IntList targetEntityIdList_ = ClientGadgetInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ClientGadgetInfoOuterClass.internal_static_ClientGadgetInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ClientGadgetInfoOuterClass.internal_static_ClientGadgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientGadgetInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ClientGadgetInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.campId_ = 0;
                this.campType_ = 0;
                this.guid_ = 0;
                this.ownerEntityId_ = 0;
                this.targetEntityId_ = 0;
                this.asyncLoad_ = false;
                this.isPeerIdFromPlayer_ = false;
                this.targetEntityIdList_ = ClientGadgetInfo.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ClientGadgetInfoOuterClass.internal_static_ClientGadgetInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ClientGadgetInfo getDefaultInstanceForType() {
                return ClientGadgetInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ClientGadgetInfo build() {
                ClientGadgetInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ClientGadgetInfo buildPartial() {
                ClientGadgetInfo result = new ClientGadgetInfo(this);
                int i = this.bitField0_;
                result.campId_ = this.campId_;
                result.campType_ = this.campType_;
                result.guid_ = this.guid_;
                result.ownerEntityId_ = this.ownerEntityId_;
                result.targetEntityId_ = this.targetEntityId_;
                result.asyncLoad_ = this.asyncLoad_;
                result.isPeerIdFromPlayer_ = this.isPeerIdFromPlayer_;
                if ((this.bitField0_ & 1) != 0) {
                    this.targetEntityIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.targetEntityIdList_ = this.targetEntityIdList_;
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
                if (other instanceof ClientGadgetInfo) {
                    return mergeFrom((ClientGadgetInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ClientGadgetInfo other) {
                if (other == ClientGadgetInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getCampId() != 0) {
                    setCampId(other.getCampId());
                }
                if (other.getCampType() != 0) {
                    setCampType(other.getCampType());
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                if (other.getOwnerEntityId() != 0) {
                    setOwnerEntityId(other.getOwnerEntityId());
                }
                if (other.getTargetEntityId() != 0) {
                    setTargetEntityId(other.getTargetEntityId());
                }
                if (other.getAsyncLoad()) {
                    setAsyncLoad(other.getAsyncLoad());
                }
                if (other.getIsPeerIdFromPlayer()) {
                    setIsPeerIdFromPlayer(other.getIsPeerIdFromPlayer());
                }
                if (!other.targetEntityIdList_.isEmpty()) {
                    if (this.targetEntityIdList_.isEmpty()) {
                        this.targetEntityIdList_ = other.targetEntityIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureTargetEntityIdListIsMutable();
                        this.targetEntityIdList_.addAll(other.targetEntityIdList_);
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
                ClientGadgetInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ClientGadgetInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ClientGadgetInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
            public int getCampId() {
                return this.campId_;
            }

            public Builder setCampId(int value) {
                this.campId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCampId() {
                this.campId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
            public int getCampType() {
                return this.campType_;
            }

            public Builder setCampType(int value) {
                this.campType_ = value;
                onChanged();
                return this;
            }

            public Builder clearCampType() {
                this.campType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
            public long getGuid() {
                return this.guid_;
            }

            public Builder setGuid(long value) {
                this.guid_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuid() {
                this.guid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
            public int getOwnerEntityId() {
                return this.ownerEntityId_;
            }

            public Builder setOwnerEntityId(int value) {
                this.ownerEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearOwnerEntityId() {
                this.ownerEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
            public int getTargetEntityId() {
                return this.targetEntityId_;
            }

            public Builder setTargetEntityId(int value) {
                this.targetEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetEntityId() {
                this.targetEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
            public boolean getAsyncLoad() {
                return this.asyncLoad_;
            }

            public Builder setAsyncLoad(boolean value) {
                this.asyncLoad_ = value;
                onChanged();
                return this;
            }

            public Builder clearAsyncLoad() {
                this.asyncLoad_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
            public boolean getIsPeerIdFromPlayer() {
                return this.isPeerIdFromPlayer_;
            }

            public Builder setIsPeerIdFromPlayer(boolean value) {
                this.isPeerIdFromPlayer_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsPeerIdFromPlayer() {
                this.isPeerIdFromPlayer_ = false;
                onChanged();
                return this;
            }

            private void ensureTargetEntityIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.targetEntityIdList_ = ClientGadgetInfo.mutableCopy(this.targetEntityIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
            public List<Integer> getTargetEntityIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.targetEntityIdList_) : this.targetEntityIdList_;
            }

            @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
            public int getTargetEntityIdListCount() {
                return this.targetEntityIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder
            public int getTargetEntityIdList(int index) {
                return this.targetEntityIdList_.getInt(index);
            }

            public Builder setTargetEntityIdList(int index, int value) {
                ensureTargetEntityIdListIsMutable();
                this.targetEntityIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addTargetEntityIdList(int value) {
                ensureTargetEntityIdListIsMutable();
                this.targetEntityIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllTargetEntityIdList(Iterable<? extends Integer> values) {
                ensureTargetEntityIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.targetEntityIdList_);
                onChanged();
                return this;
            }

            public Builder clearTargetEntityIdList() {
                this.targetEntityIdList_ = ClientGadgetInfo.emptyIntList();
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

        public static ClientGadgetInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ClientGadgetInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ClientGadgetInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ClientGadgetInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
