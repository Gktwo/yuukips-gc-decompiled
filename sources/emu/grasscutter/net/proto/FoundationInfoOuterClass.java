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
import emu.grasscutter.net.proto.FoundationStatusOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FoundationInfoOuterClass.class */
public final class FoundationInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014FoundationInfo.proto\u001a\u0016FoundationStatus.proto\"y\n\u000eFoundationInfo\u0012!\n\u0006status\u0018\u0001 \u0001(\u000e2\u0011.FoundationStatus\u0012\u0010\n\buid_list\u0018\u0002 \u0003(\r\u0012\u001b\n\u0013current_building_id\u0018\u0003 \u0001(\r\u0012\u0015\n\rlocked_by_uid\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FoundationStatusOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FoundationInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FoundationInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FoundationInfo_descriptor, new String[]{"Status", "UidList", "CurrentBuildingId", "LockedByUid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FoundationInfoOuterClass$FoundationInfoOrBuilder.class */
    public interface FoundationInfoOrBuilder extends MessageOrBuilder {
        int getStatusValue();

        FoundationStatusOuterClass.FoundationStatus getStatus();

        List<Integer> getUidListList();

        int getUidListCount();

        int getUidList(int i);

        int getCurrentBuildingId();

        int getLockedByUid();
    }

    private FoundationInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FoundationInfoOuterClass$FoundationInfo.class */
    public static final class FoundationInfo extends GeneratedMessageV3 implements FoundationInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STATUS_FIELD_NUMBER = 1;
        private int status_;
        public static final int UID_LIST_FIELD_NUMBER = 2;
        private Internal.IntList uidList_;
        private int uidListMemoizedSerializedSize;
        public static final int CURRENT_BUILDING_ID_FIELD_NUMBER = 3;
        private int currentBuildingId_;
        public static final int LOCKED_BY_UID_FIELD_NUMBER = 4;
        private int lockedByUid_;
        private byte memoizedIsInitialized;
        private static final FoundationInfo DEFAULT_INSTANCE = new FoundationInfo();
        private static final Parser<FoundationInfo> PARSER = new AbstractParser<FoundationInfo>() { // from class: emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfo.1
            @Override // com.google.protobuf.Parser
            public FoundationInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FoundationInfo(input, extensionRegistry);
            }
        };

        private FoundationInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.uidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private FoundationInfo() {
            this.uidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.status_ = 0;
            this.uidList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FoundationInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FoundationInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.status_ = input.readEnum();
                                break;
                            case 16:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.uidList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.uidList_.addInt(input.readUInt32());
                                break;
                            case 18:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.uidList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.uidList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 24:
                                this.currentBuildingId_ = input.readUInt32();
                                break;
                            case 32:
                                this.lockedByUid_ = input.readUInt32();
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
                    this.uidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FoundationInfoOuterClass.internal_static_FoundationInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FoundationInfoOuterClass.internal_static_FoundationInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FoundationInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfoOrBuilder
        public int getStatusValue() {
            return this.status_;
        }

        @Override // emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfoOrBuilder
        public FoundationStatusOuterClass.FoundationStatus getStatus() {
            FoundationStatusOuterClass.FoundationStatus result = FoundationStatusOuterClass.FoundationStatus.valueOf(this.status_);
            return result == null ? FoundationStatusOuterClass.FoundationStatus.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfoOrBuilder
        public List<Integer> getUidListList() {
            return this.uidList_;
        }

        @Override // emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfoOrBuilder
        public int getUidListCount() {
            return this.uidList_.size();
        }

        @Override // emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfoOrBuilder
        public int getUidList(int index) {
            return this.uidList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfoOrBuilder
        public int getCurrentBuildingId() {
            return this.currentBuildingId_;
        }

        @Override // emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfoOrBuilder
        public int getLockedByUid() {
            return this.lockedByUid_;
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
            if (this.status_ != FoundationStatusOuterClass.FoundationStatus.FOUNDATION_STATUS_NONE.getNumber()) {
                output.writeEnum(1, this.status_);
            }
            if (getUidListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.uidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.uidList_.size(); i++) {
                output.writeUInt32NoTag(this.uidList_.getInt(i));
            }
            if (this.currentBuildingId_ != 0) {
                output.writeUInt32(3, this.currentBuildingId_);
            }
            if (this.lockedByUid_ != 0) {
                output.writeUInt32(4, this.lockedByUid_);
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
            if (this.status_ != FoundationStatusOuterClass.FoundationStatus.FOUNDATION_STATUS_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.status_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.uidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.uidList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getUidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.uidListMemoizedSerializedSize = dataSize;
            if (this.currentBuildingId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(3, this.currentBuildingId_);
            }
            if (this.lockedByUid_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(4, this.lockedByUid_);
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
            if (!(obj instanceof FoundationInfo)) {
                return equals(obj);
            }
            FoundationInfo other = (FoundationInfo) obj;
            return this.status_ == other.status_ && getUidListList().equals(other.getUidListList()) && getCurrentBuildingId() == other.getCurrentBuildingId() && getLockedByUid() == other.getLockedByUid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + this.status_;
            if (getUidListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getUidListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 3)) + getCurrentBuildingId())) + 4)) + getLockedByUid())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FoundationInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FoundationInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FoundationInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FoundationInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FoundationInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FoundationInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FoundationInfo parseFrom(InputStream input) throws IOException {
            return (FoundationInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FoundationInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FoundationInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FoundationInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FoundationInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FoundationInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FoundationInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FoundationInfo parseFrom(CodedInputStream input) throws IOException {
            return (FoundationInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FoundationInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FoundationInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FoundationInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FoundationInfoOuterClass$FoundationInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FoundationInfoOrBuilder {
            private int bitField0_;
            private int status_ = 0;
            private Internal.IntList uidList_ = FoundationInfo.emptyIntList();
            private int currentBuildingId_;
            private int lockedByUid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FoundationInfoOuterClass.internal_static_FoundationInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FoundationInfoOuterClass.internal_static_FoundationInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FoundationInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FoundationInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.status_ = 0;
                this.uidList_ = FoundationInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.currentBuildingId_ = 0;
                this.lockedByUid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FoundationInfoOuterClass.internal_static_FoundationInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FoundationInfo getDefaultInstanceForType() {
                return FoundationInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FoundationInfo build() {
                FoundationInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FoundationInfo buildPartial() {
                FoundationInfo result = new FoundationInfo(this);
                int i = this.bitField0_;
                result.status_ = this.status_;
                if ((this.bitField0_ & 1) != 0) {
                    this.uidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.uidList_ = this.uidList_;
                result.currentBuildingId_ = this.currentBuildingId_;
                result.lockedByUid_ = this.lockedByUid_;
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
                if (other instanceof FoundationInfo) {
                    return mergeFrom((FoundationInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FoundationInfo other) {
                if (other == FoundationInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.status_ != 0) {
                    setStatusValue(other.getStatusValue());
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
                if (other.getCurrentBuildingId() != 0) {
                    setCurrentBuildingId(other.getCurrentBuildingId());
                }
                if (other.getLockedByUid() != 0) {
                    setLockedByUid(other.getLockedByUid());
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
                FoundationInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = FoundationInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FoundationInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfoOrBuilder
            public int getStatusValue() {
                return this.status_;
            }

            public Builder setStatusValue(int value) {
                this.status_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfoOrBuilder
            public FoundationStatusOuterClass.FoundationStatus getStatus() {
                FoundationStatusOuterClass.FoundationStatus result = FoundationStatusOuterClass.FoundationStatus.valueOf(this.status_);
                return result == null ? FoundationStatusOuterClass.FoundationStatus.UNRECOGNIZED : result;
            }

            public Builder setStatus(FoundationStatusOuterClass.FoundationStatus value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.status_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.status_ = 0;
                onChanged();
                return this;
            }

            private void ensureUidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.uidList_ = FoundationInfo.mutableCopy(this.uidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfoOrBuilder
            public List<Integer> getUidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.uidList_) : this.uidList_;
            }

            @Override // emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfoOrBuilder
            public int getUidListCount() {
                return this.uidList_.size();
            }

            @Override // emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfoOrBuilder
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
                this.uidList_ = FoundationInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfoOrBuilder
            public int getCurrentBuildingId() {
                return this.currentBuildingId_;
            }

            public Builder setCurrentBuildingId(int value) {
                this.currentBuildingId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrentBuildingId() {
                this.currentBuildingId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FoundationInfoOuterClass.FoundationInfoOrBuilder
            public int getLockedByUid() {
                return this.lockedByUid_;
            }

            public Builder setLockedByUid(int value) {
                this.lockedByUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearLockedByUid() {
                this.lockedByUid_ = 0;
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

        public static FoundationInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FoundationInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FoundationInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FoundationInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FoundationStatusOuterClass.getDescriptor();
    }
}
