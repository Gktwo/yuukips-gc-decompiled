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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ProudSkillChangeNotifyOuterClass.class */
public final class ProudSkillChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cProudSkillChangeNotify.proto\"r\n\u0016ProudSkillChangeNotify\u0012\u0013\n\u000bavatar_guid\u0018\r \u0001(\u0004\u0012\u0018\n\u0010proud_skill_list\u0018\u0005 \u0003(\r\u0012\u0016\n\u000eskill_depot_id\u0018\f \u0001(\r\u0012\u0011\n\tentity_id\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ProudSkillChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ProudSkillChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ProudSkillChangeNotify_descriptor, new String[]{"AvatarGuid", "ProudSkillList", "SkillDepotId", "EntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ProudSkillChangeNotifyOuterClass$ProudSkillChangeNotifyOrBuilder.class */
    public interface ProudSkillChangeNotifyOrBuilder extends MessageOrBuilder {
        long getAvatarGuid();

        List<Integer> getProudSkillListList();

        int getProudSkillListCount();

        int getProudSkillList(int i);

        int getSkillDepotId();

        int getEntityId();
    }

    private ProudSkillChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ProudSkillChangeNotifyOuterClass$ProudSkillChangeNotify.class */
    public static final class ProudSkillChangeNotify extends GeneratedMessageV3 implements ProudSkillChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATAR_GUID_FIELD_NUMBER = 13;
        private long avatarGuid_;
        public static final int PROUD_SKILL_LIST_FIELD_NUMBER = 5;
        private Internal.IntList proudSkillList_;
        private int proudSkillListMemoizedSerializedSize;
        public static final int SKILL_DEPOT_ID_FIELD_NUMBER = 12;
        private int skillDepotId_;
        public static final int ENTITY_ID_FIELD_NUMBER = 3;
        private int entityId_;
        private byte memoizedIsInitialized;
        private static final ProudSkillChangeNotify DEFAULT_INSTANCE = new ProudSkillChangeNotify();
        private static final Parser<ProudSkillChangeNotify> PARSER = new AbstractParser<ProudSkillChangeNotify>() { // from class: emu.grasscutter.net.proto.ProudSkillChangeNotifyOuterClass.ProudSkillChangeNotify.1
            @Override // com.google.protobuf.Parser
            public ProudSkillChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ProudSkillChangeNotify(input, extensionRegistry);
            }
        };

        private ProudSkillChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.proudSkillListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ProudSkillChangeNotify() {
            this.proudSkillListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.proudSkillList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ProudSkillChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ProudSkillChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.proudSkillList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.proudSkillList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.proudSkillList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.proudSkillList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 96:
                                this.skillDepotId_ = input.readUInt32();
                                break;
                            case 104:
                                this.avatarGuid_ = input.readUInt64();
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
                    this.proudSkillList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ProudSkillChangeNotifyOuterClass.internal_static_ProudSkillChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ProudSkillChangeNotifyOuterClass.internal_static_ProudSkillChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ProudSkillChangeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ProudSkillChangeNotifyOuterClass.ProudSkillChangeNotifyOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.ProudSkillChangeNotifyOuterClass.ProudSkillChangeNotifyOrBuilder
        public List<Integer> getProudSkillListList() {
            return this.proudSkillList_;
        }

        @Override // emu.grasscutter.net.proto.ProudSkillChangeNotifyOuterClass.ProudSkillChangeNotifyOrBuilder
        public int getProudSkillListCount() {
            return this.proudSkillList_.size();
        }

        @Override // emu.grasscutter.net.proto.ProudSkillChangeNotifyOuterClass.ProudSkillChangeNotifyOrBuilder
        public int getProudSkillList(int index) {
            return this.proudSkillList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ProudSkillChangeNotifyOuterClass.ProudSkillChangeNotifyOrBuilder
        public int getSkillDepotId() {
            return this.skillDepotId_;
        }

        @Override // emu.grasscutter.net.proto.ProudSkillChangeNotifyOuterClass.ProudSkillChangeNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
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
            if (this.entityId_ != 0) {
                output.writeUInt32(3, this.entityId_);
            }
            if (getProudSkillListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.proudSkillListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.proudSkillList_.size(); i++) {
                output.writeUInt32NoTag(this.proudSkillList_.getInt(i));
            }
            if (this.skillDepotId_ != 0) {
                output.writeUInt32(12, this.skillDepotId_);
            }
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(13, this.avatarGuid_);
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
            if (this.entityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.entityId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.proudSkillList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.proudSkillList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getProudSkillListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.proudSkillListMemoizedSerializedSize = dataSize;
            if (this.skillDepotId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(12, this.skillDepotId_);
            }
            if (this.avatarGuid_ != 0) {
                size3 += CodedOutputStream.computeUInt64Size(13, this.avatarGuid_);
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
            if (!(obj instanceof ProudSkillChangeNotify)) {
                return equals(obj);
            }
            ProudSkillChangeNotify other = (ProudSkillChangeNotify) obj;
            return getAvatarGuid() == other.getAvatarGuid() && getProudSkillListList().equals(other.getProudSkillListList()) && getSkillDepotId() == other.getSkillDepotId() && getEntityId() == other.getEntityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + Internal.hashLong(getAvatarGuid());
            if (getProudSkillListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getProudSkillListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 12)) + getSkillDepotId())) + 3)) + getEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ProudSkillChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ProudSkillChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ProudSkillChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ProudSkillChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ProudSkillChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ProudSkillChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ProudSkillChangeNotify parseFrom(InputStream input) throws IOException {
            return (ProudSkillChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ProudSkillChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ProudSkillChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ProudSkillChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ProudSkillChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ProudSkillChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ProudSkillChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ProudSkillChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (ProudSkillChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ProudSkillChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ProudSkillChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ProudSkillChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ProudSkillChangeNotifyOuterClass$ProudSkillChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ProudSkillChangeNotifyOrBuilder {
            private int bitField0_;
            private long avatarGuid_;
            private Internal.IntList proudSkillList_ = ProudSkillChangeNotify.emptyIntList();
            private int skillDepotId_;
            private int entityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ProudSkillChangeNotifyOuterClass.internal_static_ProudSkillChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ProudSkillChangeNotifyOuterClass.internal_static_ProudSkillChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ProudSkillChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ProudSkillChangeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.avatarGuid_ = 0;
                this.proudSkillList_ = ProudSkillChangeNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.skillDepotId_ = 0;
                this.entityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ProudSkillChangeNotifyOuterClass.internal_static_ProudSkillChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ProudSkillChangeNotify getDefaultInstanceForType() {
                return ProudSkillChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ProudSkillChangeNotify build() {
                ProudSkillChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ProudSkillChangeNotify buildPartial() {
                ProudSkillChangeNotify result = new ProudSkillChangeNotify(this);
                int i = this.bitField0_;
                result.avatarGuid_ = this.avatarGuid_;
                if ((this.bitField0_ & 1) != 0) {
                    this.proudSkillList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.proudSkillList_ = this.proudSkillList_;
                result.skillDepotId_ = this.skillDepotId_;
                result.entityId_ = this.entityId_;
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
                if (other instanceof ProudSkillChangeNotify) {
                    return mergeFrom((ProudSkillChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ProudSkillChangeNotify other) {
                if (other == ProudSkillChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (!other.proudSkillList_.isEmpty()) {
                    if (this.proudSkillList_.isEmpty()) {
                        this.proudSkillList_ = other.proudSkillList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureProudSkillListIsMutable();
                        this.proudSkillList_.addAll(other.proudSkillList_);
                    }
                    onChanged();
                }
                if (other.getSkillDepotId() != 0) {
                    setSkillDepotId(other.getSkillDepotId());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
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
                ProudSkillChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ProudSkillChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ProudSkillChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ProudSkillChangeNotifyOuterClass.ProudSkillChangeNotifyOrBuilder
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

            private void ensureProudSkillListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.proudSkillList_ = ProudSkillChangeNotify.mutableCopy(this.proudSkillList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ProudSkillChangeNotifyOuterClass.ProudSkillChangeNotifyOrBuilder
            public List<Integer> getProudSkillListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.proudSkillList_) : this.proudSkillList_;
            }

            @Override // emu.grasscutter.net.proto.ProudSkillChangeNotifyOuterClass.ProudSkillChangeNotifyOrBuilder
            public int getProudSkillListCount() {
                return this.proudSkillList_.size();
            }

            @Override // emu.grasscutter.net.proto.ProudSkillChangeNotifyOuterClass.ProudSkillChangeNotifyOrBuilder
            public int getProudSkillList(int index) {
                return this.proudSkillList_.getInt(index);
            }

            public Builder setProudSkillList(int index, int value) {
                ensureProudSkillListIsMutable();
                this.proudSkillList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addProudSkillList(int value) {
                ensureProudSkillListIsMutable();
                this.proudSkillList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllProudSkillList(Iterable<? extends Integer> values) {
                ensureProudSkillListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.proudSkillList_);
                onChanged();
                return this;
            }

            public Builder clearProudSkillList() {
                this.proudSkillList_ = ProudSkillChangeNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ProudSkillChangeNotifyOuterClass.ProudSkillChangeNotifyOrBuilder
            public int getSkillDepotId() {
                return this.skillDepotId_;
            }

            public Builder setSkillDepotId(int value) {
                this.skillDepotId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSkillDepotId() {
                this.skillDepotId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ProudSkillChangeNotifyOuterClass.ProudSkillChangeNotifyOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static ProudSkillChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ProudSkillChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ProudSkillChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ProudSkillChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
