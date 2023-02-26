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
import emu.grasscutter.net.proto.EffigyDailyInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyInfoOuterClass.class */
public final class EffigyInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010EffigyInfo.proto\u001a\u0015EffigyDailyInfo.proto\"\n\nEffigyInfo\u0012\u001c\n\u0014takenRewardIndexList\u0018\u0007 \u0003(\r\u0012'\n\rdailyInfoList\u0018\t \u0003(\u000b2\u0010.EffigyDailyInfo\u0012\u0010\n\bcurScore\u0018\u0005 \u0001(\r\u0012\u0018\n\u0010lastDifficultyId\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{EffigyDailyInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EffigyInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EffigyInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EffigyInfo_descriptor, new String[]{"TakenRewardIndexList", "DailyInfoList", "CurScore", "LastDifficultyId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyInfoOuterClass$EffigyInfoOrBuilder.class */
    public interface EffigyInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getTakenRewardIndexListList();

        int getTakenRewardIndexListCount();

        int getTakenRewardIndexList(int i);

        List<EffigyDailyInfoOuterClass.EffigyDailyInfo> getDailyInfoListList();

        EffigyDailyInfoOuterClass.EffigyDailyInfo getDailyInfoList(int i);

        int getDailyInfoListCount();

        List<? extends EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder> getDailyInfoListOrBuilderList();

        EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder getDailyInfoListOrBuilder(int i);

        int getCurScore();

        int getLastDifficultyId();
    }

    private EffigyInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyInfoOuterClass$EffigyInfo.class */
    public static final class EffigyInfo extends GeneratedMessageV3 implements EffigyInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TAKENREWARDINDEXLIST_FIELD_NUMBER = 7;
        private Internal.IntList takenRewardIndexList_;
        private int takenRewardIndexListMemoizedSerializedSize;
        public static final int DAILYINFOLIST_FIELD_NUMBER = 9;
        private List<EffigyDailyInfoOuterClass.EffigyDailyInfo> dailyInfoList_;
        public static final int CURSCORE_FIELD_NUMBER = 5;
        private int curScore_;
        public static final int LASTDIFFICULTYID_FIELD_NUMBER = 10;
        private int lastDifficultyId_;
        private byte memoizedIsInitialized;
        private static final EffigyInfo DEFAULT_INSTANCE = new EffigyInfo();
        private static final Parser<EffigyInfo> PARSER = new AbstractParser<EffigyInfo>() { // from class: emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfo.1
            @Override // com.google.protobuf.Parser
            public EffigyInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EffigyInfo(input, extensionRegistry);
            }
        };

        private EffigyInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.takenRewardIndexListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private EffigyInfo() {
            this.takenRewardIndexListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.takenRewardIndexList_ = emptyIntList();
            this.dailyInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EffigyInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x0120 */
        private EffigyInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.curScore_ = input.readUInt32();
                                break;
                            case 56:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.takenRewardIndexList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.takenRewardIndexList_.addInt(input.readUInt32());
                                break;
                            case 58:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.takenRewardIndexList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.takenRewardIndexList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.dailyInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.dailyInfoList_.add((EffigyDailyInfoOuterClass.EffigyDailyInfo) input.readMessage(EffigyDailyInfoOuterClass.EffigyDailyInfo.parser(), extensionRegistry));
                                break;
                            case 80:
                                this.lastDifficultyId_ = input.readUInt32();
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
                    this.takenRewardIndexList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.dailyInfoList_ = Collections.unmodifiableList(this.dailyInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EffigyInfoOuterClass.internal_static_EffigyInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EffigyInfoOuterClass.internal_static_EffigyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EffigyInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
        public List<Integer> getTakenRewardIndexListList() {
            return this.takenRewardIndexList_;
        }

        @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
        public int getTakenRewardIndexListCount() {
            return this.takenRewardIndexList_.size();
        }

        @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
        public int getTakenRewardIndexList(int index) {
            return this.takenRewardIndexList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
        public List<EffigyDailyInfoOuterClass.EffigyDailyInfo> getDailyInfoListList() {
            return this.dailyInfoList_;
        }

        @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
        public List<? extends EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder> getDailyInfoListOrBuilderList() {
            return this.dailyInfoList_;
        }

        @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
        public int getDailyInfoListCount() {
            return this.dailyInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
        public EffigyDailyInfoOuterClass.EffigyDailyInfo getDailyInfoList(int index) {
            return this.dailyInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
        public EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder getDailyInfoListOrBuilder(int index) {
            return this.dailyInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
        public int getCurScore() {
            return this.curScore_;
        }

        @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
        public int getLastDifficultyId() {
            return this.lastDifficultyId_;
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
            if (this.curScore_ != 0) {
                output.writeUInt32(5, this.curScore_);
            }
            if (getTakenRewardIndexListList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.takenRewardIndexListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.takenRewardIndexList_.size(); i++) {
                output.writeUInt32NoTag(this.takenRewardIndexList_.getInt(i));
            }
            for (int i2 = 0; i2 < this.dailyInfoList_.size(); i2++) {
                output.writeMessage(9, this.dailyInfoList_.get(i2));
            }
            if (this.lastDifficultyId_ != 0) {
                output.writeUInt32(10, this.lastDifficultyId_);
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
            if (this.curScore_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.curScore_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.takenRewardIndexList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.takenRewardIndexList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getTakenRewardIndexListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.takenRewardIndexListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.dailyInfoList_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(9, this.dailyInfoList_.get(i2));
            }
            if (this.lastDifficultyId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(10, this.lastDifficultyId_);
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
            if (!(obj instanceof EffigyInfo)) {
                return equals(obj);
            }
            EffigyInfo other = (EffigyInfo) obj;
            return getTakenRewardIndexListList().equals(other.getTakenRewardIndexListList()) && getDailyInfoListList().equals(other.getDailyInfoListList()) && getCurScore() == other.getCurScore() && getLastDifficultyId() == other.getLastDifficultyId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getTakenRewardIndexListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getTakenRewardIndexListList().hashCode();
            }
            if (getDailyInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getDailyInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 5)) + getCurScore())) + 10)) + getLastDifficultyId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EffigyInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyInfo parseFrom(InputStream input) throws IOException {
            return (EffigyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EffigyInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EffigyInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EffigyInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EffigyInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EffigyInfo parseFrom(CodedInputStream input) throws IOException {
            return (EffigyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EffigyInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EffigyInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyInfoOuterClass$EffigyInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EffigyInfoOrBuilder {
            private int bitField0_;
            private Internal.IntList takenRewardIndexList_ = EffigyInfo.emptyIntList();
            private List<EffigyDailyInfoOuterClass.EffigyDailyInfo> dailyInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<EffigyDailyInfoOuterClass.EffigyDailyInfo, EffigyDailyInfoOuterClass.EffigyDailyInfo.Builder, EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder> dailyInfoListBuilder_;
            private int curScore_;
            private int lastDifficultyId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EffigyInfoOuterClass.internal_static_EffigyInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EffigyInfoOuterClass.internal_static_EffigyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EffigyInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EffigyInfo.alwaysUseFieldBuilders) {
                    getDailyInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.takenRewardIndexList_ = EffigyInfo.emptyIntList();
                this.bitField0_ &= -2;
                if (this.dailyInfoListBuilder_ == null) {
                    this.dailyInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.dailyInfoListBuilder_.clear();
                }
                this.curScore_ = 0;
                this.lastDifficultyId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EffigyInfoOuterClass.internal_static_EffigyInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EffigyInfo getDefaultInstanceForType() {
                return EffigyInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EffigyInfo build() {
                EffigyInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EffigyInfo buildPartial() {
                EffigyInfo result = new EffigyInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.takenRewardIndexList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.takenRewardIndexList_ = this.takenRewardIndexList_;
                if (this.dailyInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.dailyInfoList_ = Collections.unmodifiableList(this.dailyInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.dailyInfoList_ = this.dailyInfoList_;
                } else {
                    result.dailyInfoList_ = this.dailyInfoListBuilder_.build();
                }
                result.curScore_ = this.curScore_;
                result.lastDifficultyId_ = this.lastDifficultyId_;
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
                if (other instanceof EffigyInfo) {
                    return mergeFrom((EffigyInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EffigyInfo other) {
                if (other == EffigyInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.takenRewardIndexList_.isEmpty()) {
                    if (this.takenRewardIndexList_.isEmpty()) {
                        this.takenRewardIndexList_ = other.takenRewardIndexList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureTakenRewardIndexListIsMutable();
                        this.takenRewardIndexList_.addAll(other.takenRewardIndexList_);
                    }
                    onChanged();
                }
                if (this.dailyInfoListBuilder_ == null) {
                    if (!other.dailyInfoList_.isEmpty()) {
                        if (this.dailyInfoList_.isEmpty()) {
                            this.dailyInfoList_ = other.dailyInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureDailyInfoListIsMutable();
                            this.dailyInfoList_.addAll(other.dailyInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.dailyInfoList_.isEmpty()) {
                    if (this.dailyInfoListBuilder_.isEmpty()) {
                        this.dailyInfoListBuilder_.dispose();
                        this.dailyInfoListBuilder_ = null;
                        this.dailyInfoList_ = other.dailyInfoList_;
                        this.bitField0_ &= -3;
                        this.dailyInfoListBuilder_ = EffigyInfo.alwaysUseFieldBuilders ? getDailyInfoListFieldBuilder() : null;
                    } else {
                        this.dailyInfoListBuilder_.addAllMessages(other.dailyInfoList_);
                    }
                }
                if (other.getCurScore() != 0) {
                    setCurScore(other.getCurScore());
                }
                if (other.getLastDifficultyId() != 0) {
                    setLastDifficultyId(other.getLastDifficultyId());
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
                EffigyInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = EffigyInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EffigyInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureTakenRewardIndexListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.takenRewardIndexList_ = EffigyInfo.mutableCopy(this.takenRewardIndexList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
            public List<Integer> getTakenRewardIndexListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.takenRewardIndexList_) : this.takenRewardIndexList_;
            }

            @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
            public int getTakenRewardIndexListCount() {
                return this.takenRewardIndexList_.size();
            }

            @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
            public int getTakenRewardIndexList(int index) {
                return this.takenRewardIndexList_.getInt(index);
            }

            public Builder setTakenRewardIndexList(int index, int value) {
                ensureTakenRewardIndexListIsMutable();
                this.takenRewardIndexList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addTakenRewardIndexList(int value) {
                ensureTakenRewardIndexListIsMutable();
                this.takenRewardIndexList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllTakenRewardIndexList(Iterable<? extends Integer> values) {
                ensureTakenRewardIndexListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.takenRewardIndexList_);
                onChanged();
                return this;
            }

            public Builder clearTakenRewardIndexList() {
                this.takenRewardIndexList_ = EffigyInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureDailyInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.dailyInfoList_ = new ArrayList(this.dailyInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
            public List<EffigyDailyInfoOuterClass.EffigyDailyInfo> getDailyInfoListList() {
                if (this.dailyInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dailyInfoList_);
                }
                return this.dailyInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
            public int getDailyInfoListCount() {
                if (this.dailyInfoListBuilder_ == null) {
                    return this.dailyInfoList_.size();
                }
                return this.dailyInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
            public EffigyDailyInfoOuterClass.EffigyDailyInfo getDailyInfoList(int index) {
                if (this.dailyInfoListBuilder_ == null) {
                    return this.dailyInfoList_.get(index);
                }
                return this.dailyInfoListBuilder_.getMessage(index);
            }

            public Builder setDailyInfoList(int index, EffigyDailyInfoOuterClass.EffigyDailyInfo value) {
                if (this.dailyInfoListBuilder_ != null) {
                    this.dailyInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDailyInfoListIsMutable();
                    this.dailyInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDailyInfoList(int index, EffigyDailyInfoOuterClass.EffigyDailyInfo.Builder builderForValue) {
                if (this.dailyInfoListBuilder_ == null) {
                    ensureDailyInfoListIsMutable();
                    this.dailyInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dailyInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDailyInfoList(EffigyDailyInfoOuterClass.EffigyDailyInfo value) {
                if (this.dailyInfoListBuilder_ != null) {
                    this.dailyInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDailyInfoListIsMutable();
                    this.dailyInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDailyInfoList(int index, EffigyDailyInfoOuterClass.EffigyDailyInfo value) {
                if (this.dailyInfoListBuilder_ != null) {
                    this.dailyInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDailyInfoListIsMutable();
                    this.dailyInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDailyInfoList(EffigyDailyInfoOuterClass.EffigyDailyInfo.Builder builderForValue) {
                if (this.dailyInfoListBuilder_ == null) {
                    ensureDailyInfoListIsMutable();
                    this.dailyInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dailyInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDailyInfoList(int index, EffigyDailyInfoOuterClass.EffigyDailyInfo.Builder builderForValue) {
                if (this.dailyInfoListBuilder_ == null) {
                    ensureDailyInfoListIsMutable();
                    this.dailyInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dailyInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDailyInfoList(Iterable<? extends EffigyDailyInfoOuterClass.EffigyDailyInfo> values) {
                if (this.dailyInfoListBuilder_ == null) {
                    ensureDailyInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dailyInfoList_);
                    onChanged();
                } else {
                    this.dailyInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDailyInfoList() {
                if (this.dailyInfoListBuilder_ == null) {
                    this.dailyInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.dailyInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDailyInfoList(int index) {
                if (this.dailyInfoListBuilder_ == null) {
                    ensureDailyInfoListIsMutable();
                    this.dailyInfoList_.remove(index);
                    onChanged();
                } else {
                    this.dailyInfoListBuilder_.remove(index);
                }
                return this;
            }

            public EffigyDailyInfoOuterClass.EffigyDailyInfo.Builder getDailyInfoListBuilder(int index) {
                return getDailyInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
            public EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder getDailyInfoListOrBuilder(int index) {
                if (this.dailyInfoListBuilder_ == null) {
                    return this.dailyInfoList_.get(index);
                }
                return this.dailyInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
            public List<? extends EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder> getDailyInfoListOrBuilderList() {
                if (this.dailyInfoListBuilder_ != null) {
                    return this.dailyInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dailyInfoList_);
            }

            public EffigyDailyInfoOuterClass.EffigyDailyInfo.Builder addDailyInfoListBuilder() {
                return getDailyInfoListFieldBuilder().addBuilder(EffigyDailyInfoOuterClass.EffigyDailyInfo.getDefaultInstance());
            }

            public EffigyDailyInfoOuterClass.EffigyDailyInfo.Builder addDailyInfoListBuilder(int index) {
                return getDailyInfoListFieldBuilder().addBuilder(index, EffigyDailyInfoOuterClass.EffigyDailyInfo.getDefaultInstance());
            }

            public List<EffigyDailyInfoOuterClass.EffigyDailyInfo.Builder> getDailyInfoListBuilderList() {
                return getDailyInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<EffigyDailyInfoOuterClass.EffigyDailyInfo, EffigyDailyInfoOuterClass.EffigyDailyInfo.Builder, EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder> getDailyInfoListFieldBuilder() {
                if (this.dailyInfoListBuilder_ == null) {
                    this.dailyInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.dailyInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.dailyInfoList_ = null;
                }
                return this.dailyInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
            public int getCurScore() {
                return this.curScore_;
            }

            public Builder setCurScore(int value) {
                this.curScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurScore() {
                this.curScore_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyInfoOuterClass.EffigyInfoOrBuilder
            public int getLastDifficultyId() {
                return this.lastDifficultyId_;
            }

            public Builder setLastDifficultyId(int value) {
                this.lastDifficultyId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastDifficultyId() {
                this.lastDifficultyId_ = 0;
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

        public static EffigyInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EffigyInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EffigyInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EffigyInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        EffigyDailyInfoOuterClass.getDescriptor();
    }
}
