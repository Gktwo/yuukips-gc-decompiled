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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AiSyncInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityAiSyncNotifyOuterClass.class */
public final class EntityAiSyncNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018EntityAiSyncNotify.proto\u001a\u0010AiSyncInfo.proto\"_\n\u0012EntityAiSyncNotify\u0012\u001e\n\tinfo_list\u0018\u000e \u0003(\u000b2\u000b.AiSyncInfo\u0012)\n!local_avatar_alerted_monster_list\u0018\r \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AiSyncInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EntityAiSyncNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EntityAiSyncNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EntityAiSyncNotify_descriptor, new String[]{"InfoList", "LocalAvatarAlertedMonsterList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityAiSyncNotifyOuterClass$EntityAiSyncNotifyOrBuilder.class */
    public interface EntityAiSyncNotifyOrBuilder extends MessageOrBuilder {
        List<AiSyncInfoOuterClass.AiSyncInfo> getInfoListList();

        AiSyncInfoOuterClass.AiSyncInfo getInfoList(int i);

        int getInfoListCount();

        List<? extends AiSyncInfoOuterClass.AiSyncInfoOrBuilder> getInfoListOrBuilderList();

        AiSyncInfoOuterClass.AiSyncInfoOrBuilder getInfoListOrBuilder(int i);

        List<Integer> getLocalAvatarAlertedMonsterListList();

        int getLocalAvatarAlertedMonsterListCount();

        int getLocalAvatarAlertedMonsterList(int i);
    }

    private EntityAiSyncNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityAiSyncNotifyOuterClass$EntityAiSyncNotify.class */
    public static final class EntityAiSyncNotify extends GeneratedMessageV3 implements EntityAiSyncNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INFO_LIST_FIELD_NUMBER = 14;
        private List<AiSyncInfoOuterClass.AiSyncInfo> infoList_;
        public static final int LOCAL_AVATAR_ALERTED_MONSTER_LIST_FIELD_NUMBER = 13;
        private Internal.IntList localAvatarAlertedMonsterList_;
        private int localAvatarAlertedMonsterListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final EntityAiSyncNotify DEFAULT_INSTANCE = new EntityAiSyncNotify();
        private static final Parser<EntityAiSyncNotify> PARSER = new AbstractParser<EntityAiSyncNotify>() { // from class: emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotify.1
            @Override // com.google.protobuf.Parser
            public EntityAiSyncNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntityAiSyncNotify(input, extensionRegistry);
            }
        };

        private EntityAiSyncNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.localAvatarAlertedMonsterListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private EntityAiSyncNotify() {
            this.localAvatarAlertedMonsterListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.infoList_ = Collections.emptyList();
            this.localAvatarAlertedMonsterList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EntityAiSyncNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:68:0x00fa */
        private EntityAiSyncNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 104:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.localAvatarAlertedMonsterList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.localAvatarAlertedMonsterList_.addInt(input.readUInt32());
                                break;
                            case 106:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.localAvatarAlertedMonsterList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.localAvatarAlertedMonsterList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.infoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.infoList_.add((AiSyncInfoOuterClass.AiSyncInfo) input.readMessage(AiSyncInfoOuterClass.AiSyncInfo.parser(), extensionRegistry));
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
                    this.localAvatarAlertedMonsterList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.infoList_ = Collections.unmodifiableList(this.infoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EntityAiSyncNotifyOuterClass.internal_static_EntityAiSyncNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntityAiSyncNotifyOuterClass.internal_static_EntityAiSyncNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityAiSyncNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
        public List<AiSyncInfoOuterClass.AiSyncInfo> getInfoListList() {
            return this.infoList_;
        }

        @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
        public List<? extends AiSyncInfoOuterClass.AiSyncInfoOrBuilder> getInfoListOrBuilderList() {
            return this.infoList_;
        }

        @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
        public int getInfoListCount() {
            return this.infoList_.size();
        }

        @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
        public AiSyncInfoOuterClass.AiSyncInfo getInfoList(int index) {
            return this.infoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
        public AiSyncInfoOuterClass.AiSyncInfoOrBuilder getInfoListOrBuilder(int index) {
            return this.infoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
        public List<Integer> getLocalAvatarAlertedMonsterListList() {
            return this.localAvatarAlertedMonsterList_;
        }

        @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
        public int getLocalAvatarAlertedMonsterListCount() {
            return this.localAvatarAlertedMonsterList_.size();
        }

        @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
        public int getLocalAvatarAlertedMonsterList(int index) {
            return this.localAvatarAlertedMonsterList_.getInt(index);
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
            if (getLocalAvatarAlertedMonsterListList().size() > 0) {
                output.writeUInt32NoTag(106);
                output.writeUInt32NoTag(this.localAvatarAlertedMonsterListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.localAvatarAlertedMonsterList_.size(); i++) {
                output.writeUInt32NoTag(this.localAvatarAlertedMonsterList_.getInt(i));
            }
            for (int i2 = 0; i2 < this.infoList_.size(); i2++) {
                output.writeMessage(14, this.infoList_.get(i2));
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
            for (int i = 0; i < this.localAvatarAlertedMonsterList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.localAvatarAlertedMonsterList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getLocalAvatarAlertedMonsterListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.localAvatarAlertedMonsterListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.infoList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.infoList_.get(i2));
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
            if (!(obj instanceof EntityAiSyncNotify)) {
                return equals(obj);
            }
            EntityAiSyncNotify other = (EntityAiSyncNotify) obj;
            return getInfoListList().equals(other.getInfoListList()) && getLocalAvatarAlertedMonsterListList().equals(other.getLocalAvatarAlertedMonsterListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getInfoListList().hashCode();
            }
            if (getLocalAvatarAlertedMonsterListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getLocalAvatarAlertedMonsterListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EntityAiSyncNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityAiSyncNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityAiSyncNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityAiSyncNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityAiSyncNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityAiSyncNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityAiSyncNotify parseFrom(InputStream input) throws IOException {
            return (EntityAiSyncNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityAiSyncNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityAiSyncNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityAiSyncNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (EntityAiSyncNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EntityAiSyncNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityAiSyncNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityAiSyncNotify parseFrom(CodedInputStream input) throws IOException {
            return (EntityAiSyncNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityAiSyncNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityAiSyncNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EntityAiSyncNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityAiSyncNotifyOuterClass$EntityAiSyncNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EntityAiSyncNotifyOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<AiSyncInfoOuterClass.AiSyncInfo, AiSyncInfoOuterClass.AiSyncInfo.Builder, AiSyncInfoOuterClass.AiSyncInfoOrBuilder> infoListBuilder_;
            private List<AiSyncInfoOuterClass.AiSyncInfo> infoList_ = Collections.emptyList();
            private Internal.IntList localAvatarAlertedMonsterList_ = EntityAiSyncNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return EntityAiSyncNotifyOuterClass.internal_static_EntityAiSyncNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntityAiSyncNotifyOuterClass.internal_static_EntityAiSyncNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityAiSyncNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EntityAiSyncNotify.alwaysUseFieldBuilders) {
                    getInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.infoListBuilder_ == null) {
                    this.infoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.infoListBuilder_.clear();
                }
                this.localAvatarAlertedMonsterList_ = EntityAiSyncNotify.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EntityAiSyncNotifyOuterClass.internal_static_EntityAiSyncNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EntityAiSyncNotify getDefaultInstanceForType() {
                return EntityAiSyncNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityAiSyncNotify build() {
                EntityAiSyncNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityAiSyncNotify buildPartial() {
                EntityAiSyncNotify result = new EntityAiSyncNotify(this);
                int i = this.bitField0_;
                if (this.infoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.infoList_ = Collections.unmodifiableList(this.infoList_);
                        this.bitField0_ &= -2;
                    }
                    result.infoList_ = this.infoList_;
                } else {
                    result.infoList_ = this.infoListBuilder_.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.localAvatarAlertedMonsterList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.localAvatarAlertedMonsterList_ = this.localAvatarAlertedMonsterList_;
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
                if (other instanceof EntityAiSyncNotify) {
                    return mergeFrom((EntityAiSyncNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EntityAiSyncNotify other) {
                if (other == EntityAiSyncNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.infoListBuilder_ == null) {
                    if (!other.infoList_.isEmpty()) {
                        if (this.infoList_.isEmpty()) {
                            this.infoList_ = other.infoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureInfoListIsMutable();
                            this.infoList_.addAll(other.infoList_);
                        }
                        onChanged();
                    }
                } else if (!other.infoList_.isEmpty()) {
                    if (this.infoListBuilder_.isEmpty()) {
                        this.infoListBuilder_.dispose();
                        this.infoListBuilder_ = null;
                        this.infoList_ = other.infoList_;
                        this.bitField0_ &= -2;
                        this.infoListBuilder_ = EntityAiSyncNotify.alwaysUseFieldBuilders ? getInfoListFieldBuilder() : null;
                    } else {
                        this.infoListBuilder_.addAllMessages(other.infoList_);
                    }
                }
                if (!other.localAvatarAlertedMonsterList_.isEmpty()) {
                    if (this.localAvatarAlertedMonsterList_.isEmpty()) {
                        this.localAvatarAlertedMonsterList_ = other.localAvatarAlertedMonsterList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureLocalAvatarAlertedMonsterListIsMutable();
                        this.localAvatarAlertedMonsterList_.addAll(other.localAvatarAlertedMonsterList_);
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
                EntityAiSyncNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = EntityAiSyncNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EntityAiSyncNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.infoList_ = new ArrayList(this.infoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
            public List<AiSyncInfoOuterClass.AiSyncInfo> getInfoListList() {
                if (this.infoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.infoList_);
                }
                return this.infoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
            public int getInfoListCount() {
                if (this.infoListBuilder_ == null) {
                    return this.infoList_.size();
                }
                return this.infoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
            public AiSyncInfoOuterClass.AiSyncInfo getInfoList(int index) {
                if (this.infoListBuilder_ == null) {
                    return this.infoList_.get(index);
                }
                return this.infoListBuilder_.getMessage(index);
            }

            public Builder setInfoList(int index, AiSyncInfoOuterClass.AiSyncInfo value) {
                if (this.infoListBuilder_ != null) {
                    this.infoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInfoListIsMutable();
                    this.infoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setInfoList(int index, AiSyncInfoOuterClass.AiSyncInfo.Builder builderForValue) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.infoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addInfoList(AiSyncInfoOuterClass.AiSyncInfo value) {
                if (this.infoListBuilder_ != null) {
                    this.infoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInfoListIsMutable();
                    this.infoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addInfoList(int index, AiSyncInfoOuterClass.AiSyncInfo value) {
                if (this.infoListBuilder_ != null) {
                    this.infoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInfoListIsMutable();
                    this.infoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addInfoList(AiSyncInfoOuterClass.AiSyncInfo.Builder builderForValue) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.infoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addInfoList(int index, AiSyncInfoOuterClass.AiSyncInfo.Builder builderForValue) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.infoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllInfoList(Iterable<? extends AiSyncInfoOuterClass.AiSyncInfo> values) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.infoList_);
                    onChanged();
                } else {
                    this.infoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearInfoList() {
                if (this.infoListBuilder_ == null) {
                    this.infoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.infoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeInfoList(int index) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.remove(index);
                    onChanged();
                } else {
                    this.infoListBuilder_.remove(index);
                }
                return this;
            }

            public AiSyncInfoOuterClass.AiSyncInfo.Builder getInfoListBuilder(int index) {
                return getInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
            public AiSyncInfoOuterClass.AiSyncInfoOrBuilder getInfoListOrBuilder(int index) {
                if (this.infoListBuilder_ == null) {
                    return this.infoList_.get(index);
                }
                return this.infoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
            public List<? extends AiSyncInfoOuterClass.AiSyncInfoOrBuilder> getInfoListOrBuilderList() {
                if (this.infoListBuilder_ != null) {
                    return this.infoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.infoList_);
            }

            public AiSyncInfoOuterClass.AiSyncInfo.Builder addInfoListBuilder() {
                return getInfoListFieldBuilder().addBuilder(AiSyncInfoOuterClass.AiSyncInfo.getDefaultInstance());
            }

            public AiSyncInfoOuterClass.AiSyncInfo.Builder addInfoListBuilder(int index) {
                return getInfoListFieldBuilder().addBuilder(index, AiSyncInfoOuterClass.AiSyncInfo.getDefaultInstance());
            }

            public List<AiSyncInfoOuterClass.AiSyncInfo.Builder> getInfoListBuilderList() {
                return getInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AiSyncInfoOuterClass.AiSyncInfo, AiSyncInfoOuterClass.AiSyncInfo.Builder, AiSyncInfoOuterClass.AiSyncInfoOrBuilder> getInfoListFieldBuilder() {
                if (this.infoListBuilder_ == null) {
                    this.infoListBuilder_ = new RepeatedFieldBuilderV3<>(this.infoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.infoList_ = null;
                }
                return this.infoListBuilder_;
            }

            private void ensureLocalAvatarAlertedMonsterListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.localAvatarAlertedMonsterList_ = EntityAiSyncNotify.mutableCopy(this.localAvatarAlertedMonsterList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
            public List<Integer> getLocalAvatarAlertedMonsterListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.localAvatarAlertedMonsterList_) : this.localAvatarAlertedMonsterList_;
            }

            @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
            public int getLocalAvatarAlertedMonsterListCount() {
                return this.localAvatarAlertedMonsterList_.size();
            }

            @Override // emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass.EntityAiSyncNotifyOrBuilder
            public int getLocalAvatarAlertedMonsterList(int index) {
                return this.localAvatarAlertedMonsterList_.getInt(index);
            }

            public Builder setLocalAvatarAlertedMonsterList(int index, int value) {
                ensureLocalAvatarAlertedMonsterListIsMutable();
                this.localAvatarAlertedMonsterList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addLocalAvatarAlertedMonsterList(int value) {
                ensureLocalAvatarAlertedMonsterListIsMutable();
                this.localAvatarAlertedMonsterList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllLocalAvatarAlertedMonsterList(Iterable<? extends Integer> values) {
                ensureLocalAvatarAlertedMonsterListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.localAvatarAlertedMonsterList_);
                onChanged();
                return this;
            }

            public Builder clearLocalAvatarAlertedMonsterList() {
                this.localAvatarAlertedMonsterList_ = EntityAiSyncNotify.emptyIntList();
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

        public static EntityAiSyncNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EntityAiSyncNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EntityAiSyncNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EntityAiSyncNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AiSyncInfoOuterClass.getDescriptor();
    }
}
