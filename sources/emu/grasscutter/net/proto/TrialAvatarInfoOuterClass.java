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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ItemOuterClass;
import emu.grasscutter.net.proto.TrialAvatarGrantRecordOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarInfoOuterClass.class */
public final class TrialAvatarInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015TrialAvatarInfo.proto\u001a\nItem.proto\u001a\u001cTrialAvatarGrantRecord.proto\"z\n\u000fTrialAvatarInfo\u0012\u0017\n\u000ftrial_avatar_id\u0018\u0001 \u0001(\r\u0012\u001f\n\u0010trial_equip_list\u0018\u0002 \u0003(\u000b2\u0005.Item\u0012-\n\fgrant_record\u0018\u0003 \u0001(\u000b2\u0017.TrialAvatarGrantRecordB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemOuterClass.getDescriptor(), TrialAvatarGrantRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TrialAvatarInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TrialAvatarInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TrialAvatarInfo_descriptor, new String[]{"TrialAvatarId", "TrialEquipList", "GrantRecord"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarInfoOuterClass$TrialAvatarInfoOrBuilder.class */
    public interface TrialAvatarInfoOrBuilder extends MessageOrBuilder {
        int getTrialAvatarId();

        List<ItemOuterClass.Item> getTrialEquipListList();

        ItemOuterClass.Item getTrialEquipList(int i);

        int getTrialEquipListCount();

        List<? extends ItemOuterClass.ItemOrBuilder> getTrialEquipListOrBuilderList();

        ItemOuterClass.ItemOrBuilder getTrialEquipListOrBuilder(int i);

        boolean hasGrantRecord();

        TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord getGrantRecord();

        TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecordOrBuilder getGrantRecordOrBuilder();
    }

    private TrialAvatarInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarInfoOuterClass$TrialAvatarInfo.class */
    public static final class TrialAvatarInfo extends GeneratedMessageV3 implements TrialAvatarInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TRIAL_AVATAR_ID_FIELD_NUMBER = 1;
        private int trialAvatarId_;
        public static final int TRIAL_EQUIP_LIST_FIELD_NUMBER = 2;
        private List<ItemOuterClass.Item> trialEquipList_;
        public static final int GRANT_RECORD_FIELD_NUMBER = 3;
        private TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord grantRecord_;
        private byte memoizedIsInitialized;
        private static final TrialAvatarInfo DEFAULT_INSTANCE = new TrialAvatarInfo();
        private static final Parser<TrialAvatarInfo> PARSER = new AbstractParser<TrialAvatarInfo>() { // from class: emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfo.1
            @Override // com.google.protobuf.Parser
            public TrialAvatarInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TrialAvatarInfo(input, extensionRegistry);
            }
        };

        private TrialAvatarInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TrialAvatarInfo() {
            this.memoizedIsInitialized = -1;
            this.trialEquipList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TrialAvatarInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TrialAvatarInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.trialAvatarId_ = input.readUInt32();
                                break;
                            case 18:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.trialEquipList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.trialEquipList_.add((ItemOuterClass.Item) input.readMessage(ItemOuterClass.Item.parser(), extensionRegistry));
                                break;
                            case 26:
                                TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord.Builder subBuilder = this.grantRecord_ != null ? this.grantRecord_.toBuilder() : null;
                                this.grantRecord_ = (TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord) input.readMessage(TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.grantRecord_);
                                    this.grantRecord_ = subBuilder.buildPartial();
                                    break;
                                }
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
                    this.trialEquipList_ = Collections.unmodifiableList(this.trialEquipList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TrialAvatarInfoOuterClass.internal_static_TrialAvatarInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TrialAvatarInfoOuterClass.internal_static_TrialAvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TrialAvatarInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
        public int getTrialAvatarId() {
            return this.trialAvatarId_;
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
        public List<ItemOuterClass.Item> getTrialEquipListList() {
            return this.trialEquipList_;
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
        public List<? extends ItemOuterClass.ItemOrBuilder> getTrialEquipListOrBuilderList() {
            return this.trialEquipList_;
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
        public int getTrialEquipListCount() {
            return this.trialEquipList_.size();
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
        public ItemOuterClass.Item getTrialEquipList(int index) {
            return this.trialEquipList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
        public ItemOuterClass.ItemOrBuilder getTrialEquipListOrBuilder(int index) {
            return this.trialEquipList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
        public boolean hasGrantRecord() {
            return this.grantRecord_ != null;
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
        public TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord getGrantRecord() {
            return this.grantRecord_ == null ? TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord.getDefaultInstance() : this.grantRecord_;
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
        public TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecordOrBuilder getGrantRecordOrBuilder() {
            return getGrantRecord();
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
            if (this.trialAvatarId_ != 0) {
                output.writeUInt32(1, this.trialAvatarId_);
            }
            for (int i = 0; i < this.trialEquipList_.size(); i++) {
                output.writeMessage(2, this.trialEquipList_.get(i));
            }
            if (this.grantRecord_ != null) {
                output.writeMessage(3, getGrantRecord());
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
            if (this.trialAvatarId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.trialAvatarId_);
            }
            for (int i = 0; i < this.trialEquipList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.trialEquipList_.get(i));
            }
            if (this.grantRecord_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getGrantRecord());
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
            if (!(obj instanceof TrialAvatarInfo)) {
                return equals(obj);
            }
            TrialAvatarInfo other = (TrialAvatarInfo) obj;
            if (getTrialAvatarId() == other.getTrialAvatarId() && getTrialEquipListList().equals(other.getTrialEquipListList()) && hasGrantRecord() == other.hasGrantRecord()) {
                return (!hasGrantRecord() || getGrantRecord().equals(other.getGrantRecord())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getTrialAvatarId();
            if (getTrialEquipListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getTrialEquipListList().hashCode();
            }
            if (hasGrantRecord()) {
                hash = (53 * ((37 * hash) + 3)) + getGrantRecord().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TrialAvatarInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarInfo parseFrom(InputStream input) throws IOException {
            return (TrialAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TrialAvatarInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TrialAvatarInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TrialAvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TrialAvatarInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TrialAvatarInfo parseFrom(CodedInputStream input) throws IOException {
            return (TrialAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TrialAvatarInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TrialAvatarInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarInfoOuterClass$TrialAvatarInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TrialAvatarInfoOrBuilder {
            private int bitField0_;
            private int trialAvatarId_;
            private List<ItemOuterClass.Item> trialEquipList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ItemOuterClass.Item, ItemOuterClass.Item.Builder, ItemOuterClass.ItemOrBuilder> trialEquipListBuilder_;
            private TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord grantRecord_;
            private SingleFieldBuilderV3<TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord, TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord.Builder, TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecordOrBuilder> grantRecordBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TrialAvatarInfoOuterClass.internal_static_TrialAvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TrialAvatarInfoOuterClass.internal_static_TrialAvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TrialAvatarInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TrialAvatarInfo.alwaysUseFieldBuilders) {
                    getTrialEquipListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.trialAvatarId_ = 0;
                if (this.trialEquipListBuilder_ == null) {
                    this.trialEquipList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.trialEquipListBuilder_.clear();
                }
                if (this.grantRecordBuilder_ == null) {
                    this.grantRecord_ = null;
                } else {
                    this.grantRecord_ = null;
                    this.grantRecordBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TrialAvatarInfoOuterClass.internal_static_TrialAvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TrialAvatarInfo getDefaultInstanceForType() {
                return TrialAvatarInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TrialAvatarInfo build() {
                TrialAvatarInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TrialAvatarInfo buildPartial() {
                TrialAvatarInfo result = new TrialAvatarInfo(this);
                int i = this.bitField0_;
                result.trialAvatarId_ = this.trialAvatarId_;
                if (this.trialEquipListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.trialEquipList_ = Collections.unmodifiableList(this.trialEquipList_);
                        this.bitField0_ &= -2;
                    }
                    result.trialEquipList_ = this.trialEquipList_;
                } else {
                    result.trialEquipList_ = this.trialEquipListBuilder_.build();
                }
                if (this.grantRecordBuilder_ == null) {
                    result.grantRecord_ = this.grantRecord_;
                } else {
                    result.grantRecord_ = this.grantRecordBuilder_.build();
                }
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
                if (other instanceof TrialAvatarInfo) {
                    return mergeFrom((TrialAvatarInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TrialAvatarInfo other) {
                if (other == TrialAvatarInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getTrialAvatarId() != 0) {
                    setTrialAvatarId(other.getTrialAvatarId());
                }
                if (this.trialEquipListBuilder_ == null) {
                    if (!other.trialEquipList_.isEmpty()) {
                        if (this.trialEquipList_.isEmpty()) {
                            this.trialEquipList_ = other.trialEquipList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTrialEquipListIsMutable();
                            this.trialEquipList_.addAll(other.trialEquipList_);
                        }
                        onChanged();
                    }
                } else if (!other.trialEquipList_.isEmpty()) {
                    if (this.trialEquipListBuilder_.isEmpty()) {
                        this.trialEquipListBuilder_.dispose();
                        this.trialEquipListBuilder_ = null;
                        this.trialEquipList_ = other.trialEquipList_;
                        this.bitField0_ &= -2;
                        this.trialEquipListBuilder_ = TrialAvatarInfo.alwaysUseFieldBuilders ? getTrialEquipListFieldBuilder() : null;
                    } else {
                        this.trialEquipListBuilder_.addAllMessages(other.trialEquipList_);
                    }
                }
                if (other.hasGrantRecord()) {
                    mergeGrantRecord(other.getGrantRecord());
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
                TrialAvatarInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TrialAvatarInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TrialAvatarInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
            public int getTrialAvatarId() {
                return this.trialAvatarId_;
            }

            public Builder setTrialAvatarId(int value) {
                this.trialAvatarId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTrialAvatarId() {
                this.trialAvatarId_ = 0;
                onChanged();
                return this;
            }

            private void ensureTrialEquipListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.trialEquipList_ = new ArrayList(this.trialEquipList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
            public List<ItemOuterClass.Item> getTrialEquipListList() {
                if (this.trialEquipListBuilder_ == null) {
                    return Collections.unmodifiableList(this.trialEquipList_);
                }
                return this.trialEquipListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
            public int getTrialEquipListCount() {
                if (this.trialEquipListBuilder_ == null) {
                    return this.trialEquipList_.size();
                }
                return this.trialEquipListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
            public ItemOuterClass.Item getTrialEquipList(int index) {
                if (this.trialEquipListBuilder_ == null) {
                    return this.trialEquipList_.get(index);
                }
                return this.trialEquipListBuilder_.getMessage(index);
            }

            public Builder setTrialEquipList(int index, ItemOuterClass.Item value) {
                if (this.trialEquipListBuilder_ != null) {
                    this.trialEquipListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrialEquipListIsMutable();
                    this.trialEquipList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTrialEquipList(int index, ItemOuterClass.Item.Builder builderForValue) {
                if (this.trialEquipListBuilder_ == null) {
                    ensureTrialEquipListIsMutable();
                    this.trialEquipList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.trialEquipListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTrialEquipList(ItemOuterClass.Item value) {
                if (this.trialEquipListBuilder_ != null) {
                    this.trialEquipListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrialEquipListIsMutable();
                    this.trialEquipList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTrialEquipList(int index, ItemOuterClass.Item value) {
                if (this.trialEquipListBuilder_ != null) {
                    this.trialEquipListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrialEquipListIsMutable();
                    this.trialEquipList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTrialEquipList(ItemOuterClass.Item.Builder builderForValue) {
                if (this.trialEquipListBuilder_ == null) {
                    ensureTrialEquipListIsMutable();
                    this.trialEquipList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.trialEquipListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTrialEquipList(int index, ItemOuterClass.Item.Builder builderForValue) {
                if (this.trialEquipListBuilder_ == null) {
                    ensureTrialEquipListIsMutable();
                    this.trialEquipList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.trialEquipListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTrialEquipList(Iterable<? extends ItemOuterClass.Item> values) {
                if (this.trialEquipListBuilder_ == null) {
                    ensureTrialEquipListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.trialEquipList_);
                    onChanged();
                } else {
                    this.trialEquipListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTrialEquipList() {
                if (this.trialEquipListBuilder_ == null) {
                    this.trialEquipList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.trialEquipListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTrialEquipList(int index) {
                if (this.trialEquipListBuilder_ == null) {
                    ensureTrialEquipListIsMutable();
                    this.trialEquipList_.remove(index);
                    onChanged();
                } else {
                    this.trialEquipListBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.Item.Builder getTrialEquipListBuilder(int index) {
                return getTrialEquipListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
            public ItemOuterClass.ItemOrBuilder getTrialEquipListOrBuilder(int index) {
                if (this.trialEquipListBuilder_ == null) {
                    return this.trialEquipList_.get(index);
                }
                return this.trialEquipListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
            public List<? extends ItemOuterClass.ItemOrBuilder> getTrialEquipListOrBuilderList() {
                if (this.trialEquipListBuilder_ != null) {
                    return this.trialEquipListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.trialEquipList_);
            }

            public ItemOuterClass.Item.Builder addTrialEquipListBuilder() {
                return getTrialEquipListFieldBuilder().addBuilder(ItemOuterClass.Item.getDefaultInstance());
            }

            public ItemOuterClass.Item.Builder addTrialEquipListBuilder(int index) {
                return getTrialEquipListFieldBuilder().addBuilder(index, ItemOuterClass.Item.getDefaultInstance());
            }

            public List<ItemOuterClass.Item.Builder> getTrialEquipListBuilderList() {
                return getTrialEquipListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemOuterClass.Item, ItemOuterClass.Item.Builder, ItemOuterClass.ItemOrBuilder> getTrialEquipListFieldBuilder() {
                if (this.trialEquipListBuilder_ == null) {
                    this.trialEquipListBuilder_ = new RepeatedFieldBuilderV3<>(this.trialEquipList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.trialEquipList_ = null;
                }
                return this.trialEquipListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
            public boolean hasGrantRecord() {
                return (this.grantRecordBuilder_ == null && this.grantRecord_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
            public TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord getGrantRecord() {
                if (this.grantRecordBuilder_ == null) {
                    return this.grantRecord_ == null ? TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord.getDefaultInstance() : this.grantRecord_;
                }
                return this.grantRecordBuilder_.getMessage();
            }

            public Builder setGrantRecord(TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord value) {
                if (this.grantRecordBuilder_ != null) {
                    this.grantRecordBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.grantRecord_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setGrantRecord(TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord.Builder builderForValue) {
                if (this.grantRecordBuilder_ == null) {
                    this.grantRecord_ = builderForValue.build();
                    onChanged();
                } else {
                    this.grantRecordBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeGrantRecord(TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord value) {
                if (this.grantRecordBuilder_ == null) {
                    if (this.grantRecord_ != null) {
                        this.grantRecord_ = TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord.newBuilder(this.grantRecord_).mergeFrom(value).buildPartial();
                    } else {
                        this.grantRecord_ = value;
                    }
                    onChanged();
                } else {
                    this.grantRecordBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearGrantRecord() {
                if (this.grantRecordBuilder_ == null) {
                    this.grantRecord_ = null;
                    onChanged();
                } else {
                    this.grantRecord_ = null;
                    this.grantRecordBuilder_ = null;
                }
                return this;
            }

            public TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord.Builder getGrantRecordBuilder() {
                onChanged();
                return getGrantRecordFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder
            public TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecordOrBuilder getGrantRecordOrBuilder() {
                if (this.grantRecordBuilder_ != null) {
                    return this.grantRecordBuilder_.getMessageOrBuilder();
                }
                return this.grantRecord_ == null ? TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord.getDefaultInstance() : this.grantRecord_;
            }

            private SingleFieldBuilderV3<TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord, TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord.Builder, TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecordOrBuilder> getGrantRecordFieldBuilder() {
                if (this.grantRecordBuilder_ == null) {
                    this.grantRecordBuilder_ = new SingleFieldBuilderV3<>(getGrantRecord(), getParentForChildren(), isClean());
                    this.grantRecord_ = null;
                }
                return this.grantRecordBuilder_;
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

        public static TrialAvatarInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TrialAvatarInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TrialAvatarInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TrialAvatarInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ItemOuterClass.getDescriptor();
        TrialAvatarGrantRecordOuterClass.getDescriptor();
    }
}
