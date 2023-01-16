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
import emu.grasscutter.net.proto.SumoAvatarInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoTeamDataOuterClass.class */
public final class SumoTeamDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012SumoTeamData.proto\u001a\u0014SumoAvatarInfo.proto\"P\n\fSumoTeamData\u0012\u0015\n\rskill_id_list\u0018\f \u0003(\r\u0012)\n\u0010avatar_info_list\u0018\u0004 \u0003(\u000b2\u000f.SumoAvatarInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SumoAvatarInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SumoTeamData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SumoTeamData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SumoTeamData_descriptor, new String[]{"SkillIdList", "AvatarInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoTeamDataOuterClass$SumoTeamDataOrBuilder.class */
    public interface SumoTeamDataOrBuilder extends MessageOrBuilder {
        List<Integer> getSkillIdListList();

        int getSkillIdListCount();

        int getSkillIdList(int i);

        List<SumoAvatarInfoOuterClass.SumoAvatarInfo> getAvatarInfoListList();

        SumoAvatarInfoOuterClass.SumoAvatarInfo getAvatarInfoList(int i);

        int getAvatarInfoListCount();

        List<? extends SumoAvatarInfoOuterClass.SumoAvatarInfoOrBuilder> getAvatarInfoListOrBuilderList();

        SumoAvatarInfoOuterClass.SumoAvatarInfoOrBuilder getAvatarInfoListOrBuilder(int i);
    }

    private SumoTeamDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoTeamDataOuterClass$SumoTeamData.class */
    public static final class SumoTeamData extends GeneratedMessageV3 implements SumoTeamDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SKILL_ID_LIST_FIELD_NUMBER = 12;
        private Internal.IntList skillIdList_;
        private int skillIdListMemoizedSerializedSize;
        public static final int AVATAR_INFO_LIST_FIELD_NUMBER = 4;
        private List<SumoAvatarInfoOuterClass.SumoAvatarInfo> avatarInfoList_;
        private byte memoizedIsInitialized;
        private static final SumoTeamData DEFAULT_INSTANCE = new SumoTeamData();
        private static final Parser<SumoTeamData> PARSER = new AbstractParser<SumoTeamData>() { // from class: emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamData.1
            @Override // com.google.protobuf.Parser
            public SumoTeamData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SumoTeamData(input, extensionRegistry);
            }
        };

        private SumoTeamData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.skillIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private SumoTeamData() {
            this.skillIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.skillIdList_ = emptyIntList();
            this.avatarInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SumoTeamData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:68:0x00fa */
        private SumoTeamData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 34:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.avatarInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.avatarInfoList_.add((SumoAvatarInfoOuterClass.SumoAvatarInfo) input.readMessage(SumoAvatarInfoOuterClass.SumoAvatarInfo.parser(), extensionRegistry));
                                break;
                            case 96:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.skillIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.skillIdList_.addInt(input.readUInt32());
                                break;
                            case 98:
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
                    this.avatarInfoList_ = Collections.unmodifiableList(this.avatarInfoList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.skillIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SumoTeamDataOuterClass.internal_static_SumoTeamData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SumoTeamDataOuterClass.internal_static_SumoTeamData_fieldAccessorTable.ensureFieldAccessorsInitialized(SumoTeamData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
        public List<Integer> getSkillIdListList() {
            return this.skillIdList_;
        }

        @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
        public int getSkillIdListCount() {
            return this.skillIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
        public int getSkillIdList(int index) {
            return this.skillIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
        public List<SumoAvatarInfoOuterClass.SumoAvatarInfo> getAvatarInfoListList() {
            return this.avatarInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
        public List<? extends SumoAvatarInfoOuterClass.SumoAvatarInfoOrBuilder> getAvatarInfoListOrBuilderList() {
            return this.avatarInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
        public int getAvatarInfoListCount() {
            return this.avatarInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
        public SumoAvatarInfoOuterClass.SumoAvatarInfo getAvatarInfoList(int index) {
            return this.avatarInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
        public SumoAvatarInfoOuterClass.SumoAvatarInfoOrBuilder getAvatarInfoListOrBuilder(int index) {
            return this.avatarInfoList_.get(index);
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
            for (int i = 0; i < this.avatarInfoList_.size(); i++) {
                output.writeMessage(4, this.avatarInfoList_.get(i));
            }
            if (getSkillIdListList().size() > 0) {
                output.writeUInt32NoTag(98);
                output.writeUInt32NoTag(this.skillIdListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.skillIdList_.size(); i2++) {
                output.writeUInt32NoTag(this.skillIdList_.getInt(i2));
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
            for (int i = 0; i < this.avatarInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.avatarInfoList_.get(i));
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.skillIdList_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.skillIdList_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getSkillIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.skillIdListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SumoTeamData)) {
                return equals(obj);
            }
            SumoTeamData other = (SumoTeamData) obj;
            return getSkillIdListList().equals(other.getSkillIdListList()) && getAvatarInfoListList().equals(other.getAvatarInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getSkillIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getSkillIdListList().hashCode();
            }
            if (getAvatarInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getAvatarInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SumoTeamData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoTeamData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoTeamData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoTeamData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoTeamData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoTeamData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoTeamData parseFrom(InputStream input) throws IOException {
            return (SumoTeamData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SumoTeamData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoTeamData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SumoTeamData parseDelimitedFrom(InputStream input) throws IOException {
            return (SumoTeamData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SumoTeamData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoTeamData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SumoTeamData parseFrom(CodedInputStream input) throws IOException {
            return (SumoTeamData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SumoTeamData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoTeamData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SumoTeamData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoTeamDataOuterClass$SumoTeamData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SumoTeamDataOrBuilder {
            private int bitField0_;
            private Internal.IntList skillIdList_ = SumoTeamData.emptyIntList();
            private List<SumoAvatarInfoOuterClass.SumoAvatarInfo> avatarInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<SumoAvatarInfoOuterClass.SumoAvatarInfo, SumoAvatarInfoOuterClass.SumoAvatarInfo.Builder, SumoAvatarInfoOuterClass.SumoAvatarInfoOrBuilder> avatarInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SumoTeamDataOuterClass.internal_static_SumoTeamData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SumoTeamDataOuterClass.internal_static_SumoTeamData_fieldAccessorTable.ensureFieldAccessorsInitialized(SumoTeamData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SumoTeamData.alwaysUseFieldBuilders) {
                    getAvatarInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.skillIdList_ = SumoTeamData.emptyIntList();
                this.bitField0_ &= -2;
                if (this.avatarInfoListBuilder_ == null) {
                    this.avatarInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.avatarInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SumoTeamDataOuterClass.internal_static_SumoTeamData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SumoTeamData getDefaultInstanceForType() {
                return SumoTeamData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SumoTeamData build() {
                SumoTeamData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SumoTeamData buildPartial() {
                SumoTeamData result = new SumoTeamData(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.skillIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.skillIdList_ = this.skillIdList_;
                if (this.avatarInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.avatarInfoList_ = Collections.unmodifiableList(this.avatarInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.avatarInfoList_ = this.avatarInfoList_;
                } else {
                    result.avatarInfoList_ = this.avatarInfoListBuilder_.build();
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
                if (other instanceof SumoTeamData) {
                    return mergeFrom((SumoTeamData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SumoTeamData other) {
                if (other == SumoTeamData.getDefaultInstance()) {
                    return this;
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
                if (this.avatarInfoListBuilder_ == null) {
                    if (!other.avatarInfoList_.isEmpty()) {
                        if (this.avatarInfoList_.isEmpty()) {
                            this.avatarInfoList_ = other.avatarInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureAvatarInfoListIsMutable();
                            this.avatarInfoList_.addAll(other.avatarInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.avatarInfoList_.isEmpty()) {
                    if (this.avatarInfoListBuilder_.isEmpty()) {
                        this.avatarInfoListBuilder_.dispose();
                        this.avatarInfoListBuilder_ = null;
                        this.avatarInfoList_ = other.avatarInfoList_;
                        this.bitField0_ &= -3;
                        this.avatarInfoListBuilder_ = SumoTeamData.alwaysUseFieldBuilders ? getAvatarInfoListFieldBuilder() : null;
                    } else {
                        this.avatarInfoListBuilder_.addAllMessages(other.avatarInfoList_);
                    }
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
                SumoTeamData parsedMessage = null;
                try {
                    try {
                        parsedMessage = SumoTeamData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SumoTeamData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureSkillIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.skillIdList_ = SumoTeamData.mutableCopy(this.skillIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
            public List<Integer> getSkillIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.skillIdList_) : this.skillIdList_;
            }

            @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
            public int getSkillIdListCount() {
                return this.skillIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
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
                this.skillIdList_ = SumoTeamData.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureAvatarInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.avatarInfoList_ = new ArrayList(this.avatarInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
            public List<SumoAvatarInfoOuterClass.SumoAvatarInfo> getAvatarInfoListList() {
                if (this.avatarInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.avatarInfoList_);
                }
                return this.avatarInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
            public int getAvatarInfoListCount() {
                if (this.avatarInfoListBuilder_ == null) {
                    return this.avatarInfoList_.size();
                }
                return this.avatarInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
            public SumoAvatarInfoOuterClass.SumoAvatarInfo getAvatarInfoList(int index) {
                if (this.avatarInfoListBuilder_ == null) {
                    return this.avatarInfoList_.get(index);
                }
                return this.avatarInfoListBuilder_.getMessage(index);
            }

            public Builder setAvatarInfoList(int index, SumoAvatarInfoOuterClass.SumoAvatarInfo value) {
                if (this.avatarInfoListBuilder_ != null) {
                    this.avatarInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAvatarInfoList(int index, SumoAvatarInfoOuterClass.SumoAvatarInfo.Builder builderForValue) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarInfoList(SumoAvatarInfoOuterClass.SumoAvatarInfo value) {
                if (this.avatarInfoListBuilder_ != null) {
                    this.avatarInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarInfoList(int index, SumoAvatarInfoOuterClass.SumoAvatarInfo value) {
                if (this.avatarInfoListBuilder_ != null) {
                    this.avatarInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarInfoList(SumoAvatarInfoOuterClass.SumoAvatarInfo.Builder builderForValue) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarInfoList(int index, SumoAvatarInfoOuterClass.SumoAvatarInfo.Builder builderForValue) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAvatarInfoList(Iterable<? extends SumoAvatarInfoOuterClass.SumoAvatarInfo> values) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarInfoList_);
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAvatarInfoList() {
                if (this.avatarInfoListBuilder_ == null) {
                    this.avatarInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAvatarInfoList(int index) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.remove(index);
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.remove(index);
                }
                return this;
            }

            public SumoAvatarInfoOuterClass.SumoAvatarInfo.Builder getAvatarInfoListBuilder(int index) {
                return getAvatarInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
            public SumoAvatarInfoOuterClass.SumoAvatarInfoOrBuilder getAvatarInfoListOrBuilder(int index) {
                if (this.avatarInfoListBuilder_ == null) {
                    return this.avatarInfoList_.get(index);
                }
                return this.avatarInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SumoTeamDataOuterClass.SumoTeamDataOrBuilder
            public List<? extends SumoAvatarInfoOuterClass.SumoAvatarInfoOrBuilder> getAvatarInfoListOrBuilderList() {
                if (this.avatarInfoListBuilder_ != null) {
                    return this.avatarInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.avatarInfoList_);
            }

            public SumoAvatarInfoOuterClass.SumoAvatarInfo.Builder addAvatarInfoListBuilder() {
                return getAvatarInfoListFieldBuilder().addBuilder(SumoAvatarInfoOuterClass.SumoAvatarInfo.getDefaultInstance());
            }

            public SumoAvatarInfoOuterClass.SumoAvatarInfo.Builder addAvatarInfoListBuilder(int index) {
                return getAvatarInfoListFieldBuilder().addBuilder(index, SumoAvatarInfoOuterClass.SumoAvatarInfo.getDefaultInstance());
            }

            public List<SumoAvatarInfoOuterClass.SumoAvatarInfo.Builder> getAvatarInfoListBuilderList() {
                return getAvatarInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SumoAvatarInfoOuterClass.SumoAvatarInfo, SumoAvatarInfoOuterClass.SumoAvatarInfo.Builder, SumoAvatarInfoOuterClass.SumoAvatarInfoOrBuilder> getAvatarInfoListFieldBuilder() {
                if (this.avatarInfoListBuilder_ == null) {
                    this.avatarInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.avatarInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.avatarInfoList_ = null;
                }
                return this.avatarInfoListBuilder_;
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

        public static SumoTeamData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SumoTeamData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SumoTeamData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SumoTeamData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SumoAvatarInfoOuterClass.getDescriptor();
    }
}
