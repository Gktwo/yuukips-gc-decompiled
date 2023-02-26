package emu.grasscutter.net.proto;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.WeeklyBossResinDiscountInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryInfoOuterClass.class */
public final class DungeonEntryInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016DungeonEntryInfo.proto\u001a!WeeklyBossResinDiscountInfo.proto\"\u0002\n\u0010DungeonEntryInfo\u0012\u0017\n\u000fmaxBossChestNum\u0018\n \u0001(\r\u0012\u0011\n\tstartTime\u0018\u0001 \u0001(\r\u0012\u0011\n\tleftTimes\u0018\u0006 \u0001(\r\u0012\u000f\n\u0007endTime\u0018\u000e \u0001(\r\u0012A\n\u001bweeklyBossResinDiscountInfo\u0018\r \u0001(\u000b2\u001c.WeeklyBossResinDiscountInfo\u0012\u0011\n\tdungeonId\u0018\u0003 \u0001(\r\u0012 \n\u0018nextBossChestRefreshTime\u0018\u0005 \u0001(\r\u0012\u0010\n\bisPassed\u0018\u0002 \u0001(\b\u0012\u0017\n\u000fnextRefreshTime\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WeeklyBossResinDiscountInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DungeonEntryInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DungeonEntryInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DungeonEntryInfo_descriptor, new String[]{"MaxBossChestNum", "StartTime", "LeftTimes", "EndTime", "WeeklyBossResinDiscountInfo", "DungeonId", "NextBossChestRefreshTime", "IsPassed", "NextRefreshTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryInfoOuterClass$DungeonEntryInfoOrBuilder.class */
    public interface DungeonEntryInfoOrBuilder extends MessageOrBuilder {
        int getMaxBossChestNum();

        int getStartTime();

        int getLeftTimes();

        int getEndTime();

        boolean hasWeeklyBossResinDiscountInfo();

        WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo getWeeklyBossResinDiscountInfo();

        WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder getWeeklyBossResinDiscountInfoOrBuilder();

        int getDungeonId();

        int getNextBossChestRefreshTime();

        boolean getIsPassed();

        int getNextRefreshTime();
    }

    private DungeonEntryInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryInfoOuterClass$DungeonEntryInfo.class */
    public static final class DungeonEntryInfo extends GeneratedMessageV3 implements DungeonEntryInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MAXBOSSCHESTNUM_FIELD_NUMBER = 10;
        private int maxBossChestNum_;
        public static final int STARTTIME_FIELD_NUMBER = 1;
        private int startTime_;
        public static final int LEFTTIMES_FIELD_NUMBER = 6;
        private int leftTimes_;
        public static final int ENDTIME_FIELD_NUMBER = 14;
        private int endTime_;
        public static final int WEEKLYBOSSRESINDISCOUNTINFO_FIELD_NUMBER = 13;
        private WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo weeklyBossResinDiscountInfo_;
        public static final int DUNGEONID_FIELD_NUMBER = 3;
        private int dungeonId_;
        public static final int NEXTBOSSCHESTREFRESHTIME_FIELD_NUMBER = 5;
        private int nextBossChestRefreshTime_;
        public static final int ISPASSED_FIELD_NUMBER = 2;
        private boolean isPassed_;
        public static final int NEXTREFRESHTIME_FIELD_NUMBER = 8;
        private int nextRefreshTime_;
        private byte memoizedIsInitialized;
        private static final DungeonEntryInfo DEFAULT_INSTANCE = new DungeonEntryInfo();
        private static final Parser<DungeonEntryInfo> PARSER = new AbstractParser<DungeonEntryInfo>() { // from class: emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfo.1
            @Override // com.google.protobuf.Parser
            public DungeonEntryInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DungeonEntryInfo(input, extensionRegistry);
            }
        };

        private DungeonEntryInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DungeonEntryInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DungeonEntryInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DungeonEntryInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
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
                                this.startTime_ = input.readUInt32();
                                break;
                            case 16:
                                this.isPassed_ = input.readBool();
                                break;
                            case 24:
                                this.dungeonId_ = input.readUInt32();
                                break;
                            case 40:
                                this.nextBossChestRefreshTime_ = input.readUInt32();
                                break;
                            case 48:
                                this.leftTimes_ = input.readUInt32();
                                break;
                            case 64:
                                this.nextRefreshTime_ = input.readUInt32();
                                break;
                            case 80:
                                this.maxBossChestNum_ = input.readUInt32();
                                break;
                            case 106:
                                WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.Builder subBuilder = this.weeklyBossResinDiscountInfo_ != null ? this.weeklyBossResinDiscountInfo_.toBuilder() : null;
                                this.weeklyBossResinDiscountInfo_ = (WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo) input.readMessage(WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.weeklyBossResinDiscountInfo_);
                                    this.weeklyBossResinDiscountInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 112:
                                this.endTime_ = input.readUInt32();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DungeonEntryInfoOuterClass.internal_static_DungeonEntryInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DungeonEntryInfoOuterClass.internal_static_DungeonEntryInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonEntryInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
        public int getMaxBossChestNum() {
            return this.maxBossChestNum_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
        public int getStartTime() {
            return this.startTime_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
        public int getLeftTimes() {
            return this.leftTimes_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
        public boolean hasWeeklyBossResinDiscountInfo() {
            return this.weeklyBossResinDiscountInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
        public WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo getWeeklyBossResinDiscountInfo() {
            return this.weeklyBossResinDiscountInfo_ == null ? WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.getDefaultInstance() : this.weeklyBossResinDiscountInfo_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
        public WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder getWeeklyBossResinDiscountInfoOrBuilder() {
            return getWeeklyBossResinDiscountInfo();
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
        public int getDungeonId() {
            return this.dungeonId_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
        public int getNextBossChestRefreshTime() {
            return this.nextBossChestRefreshTime_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
        public boolean getIsPassed() {
            return this.isPassed_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
        public int getNextRefreshTime() {
            return this.nextRefreshTime_;
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
            if (this.startTime_ != 0) {
                output.writeUInt32(1, this.startTime_);
            }
            if (this.isPassed_) {
                output.writeBool(2, this.isPassed_);
            }
            if (this.dungeonId_ != 0) {
                output.writeUInt32(3, this.dungeonId_);
            }
            if (this.nextBossChestRefreshTime_ != 0) {
                output.writeUInt32(5, this.nextBossChestRefreshTime_);
            }
            if (this.leftTimes_ != 0) {
                output.writeUInt32(6, this.leftTimes_);
            }
            if (this.nextRefreshTime_ != 0) {
                output.writeUInt32(8, this.nextRefreshTime_);
            }
            if (this.maxBossChestNum_ != 0) {
                output.writeUInt32(10, this.maxBossChestNum_);
            }
            if (this.weeklyBossResinDiscountInfo_ != null) {
                output.writeMessage(13, getWeeklyBossResinDiscountInfo());
            }
            if (this.endTime_ != 0) {
                output.writeUInt32(14, this.endTime_);
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
            if (this.startTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.startTime_);
            }
            if (this.isPassed_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.isPassed_);
            }
            if (this.dungeonId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.dungeonId_);
            }
            if (this.nextBossChestRefreshTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.nextBossChestRefreshTime_);
            }
            if (this.leftTimes_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.leftTimes_);
            }
            if (this.nextRefreshTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.nextRefreshTime_);
            }
            if (this.maxBossChestNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.maxBossChestNum_);
            }
            if (this.weeklyBossResinDiscountInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getWeeklyBossResinDiscountInfo());
            }
            if (this.endTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.endTime_);
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
            if (!(obj instanceof DungeonEntryInfo)) {
                return equals(obj);
            }
            DungeonEntryInfo other = (DungeonEntryInfo) obj;
            if (getMaxBossChestNum() == other.getMaxBossChestNum() && getStartTime() == other.getStartTime() && getLeftTimes() == other.getLeftTimes() && getEndTime() == other.getEndTime() && hasWeeklyBossResinDiscountInfo() == other.hasWeeklyBossResinDiscountInfo()) {
                return (!hasWeeklyBossResinDiscountInfo() || getWeeklyBossResinDiscountInfo().equals(other.getWeeklyBossResinDiscountInfo())) && getDungeonId() == other.getDungeonId() && getNextBossChestRefreshTime() == other.getNextBossChestRefreshTime() && getIsPassed() == other.getIsPassed() && getNextRefreshTime() == other.getNextRefreshTime() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getMaxBossChestNum())) + 1)) + getStartTime())) + 6)) + getLeftTimes())) + 14)) + getEndTime();
            if (hasWeeklyBossResinDiscountInfo()) {
                hash = (53 * ((37 * hash) + 13)) + getWeeklyBossResinDiscountInfo().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 3)) + getDungeonId())) + 5)) + getNextBossChestRefreshTime())) + 2)) + Internal.hashBoolean(getIsPassed()))) + 8)) + getNextRefreshTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DungeonEntryInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonEntryInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonEntryInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonEntryInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonEntryInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonEntryInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonEntryInfo parseFrom(InputStream input) throws IOException {
            return (DungeonEntryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonEntryInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonEntryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonEntryInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DungeonEntryInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DungeonEntryInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonEntryInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonEntryInfo parseFrom(CodedInputStream input) throws IOException {
            return (DungeonEntryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonEntryInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonEntryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DungeonEntryInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryInfoOuterClass$DungeonEntryInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DungeonEntryInfoOrBuilder {
            private int maxBossChestNum_;
            private int startTime_;
            private int leftTimes_;
            private int endTime_;
            private WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo weeklyBossResinDiscountInfo_;
            private SingleFieldBuilderV3<WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.Builder, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder> weeklyBossResinDiscountInfoBuilder_;
            private int dungeonId_;
            private int nextBossChestRefreshTime_;
            private boolean isPassed_;
            private int nextRefreshTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DungeonEntryInfoOuterClass.internal_static_DungeonEntryInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DungeonEntryInfoOuterClass.internal_static_DungeonEntryInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonEntryInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DungeonEntryInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.maxBossChestNum_ = 0;
                this.startTime_ = 0;
                this.leftTimes_ = 0;
                this.endTime_ = 0;
                if (this.weeklyBossResinDiscountInfoBuilder_ == null) {
                    this.weeklyBossResinDiscountInfo_ = null;
                } else {
                    this.weeklyBossResinDiscountInfo_ = null;
                    this.weeklyBossResinDiscountInfoBuilder_ = null;
                }
                this.dungeonId_ = 0;
                this.nextBossChestRefreshTime_ = 0;
                this.isPassed_ = false;
                this.nextRefreshTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DungeonEntryInfoOuterClass.internal_static_DungeonEntryInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DungeonEntryInfo getDefaultInstanceForType() {
                return DungeonEntryInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonEntryInfo build() {
                DungeonEntryInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonEntryInfo buildPartial() {
                DungeonEntryInfo result = new DungeonEntryInfo(this);
                result.maxBossChestNum_ = this.maxBossChestNum_;
                result.startTime_ = this.startTime_;
                result.leftTimes_ = this.leftTimes_;
                result.endTime_ = this.endTime_;
                if (this.weeklyBossResinDiscountInfoBuilder_ == null) {
                    result.weeklyBossResinDiscountInfo_ = this.weeklyBossResinDiscountInfo_;
                } else {
                    result.weeklyBossResinDiscountInfo_ = this.weeklyBossResinDiscountInfoBuilder_.build();
                }
                result.dungeonId_ = this.dungeonId_;
                result.nextBossChestRefreshTime_ = this.nextBossChestRefreshTime_;
                result.isPassed_ = this.isPassed_;
                result.nextRefreshTime_ = this.nextRefreshTime_;
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
                if (other instanceof DungeonEntryInfo) {
                    return mergeFrom((DungeonEntryInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DungeonEntryInfo other) {
                if (other == DungeonEntryInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getMaxBossChestNum() != 0) {
                    setMaxBossChestNum(other.getMaxBossChestNum());
                }
                if (other.getStartTime() != 0) {
                    setStartTime(other.getStartTime());
                }
                if (other.getLeftTimes() != 0) {
                    setLeftTimes(other.getLeftTimes());
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
                }
                if (other.hasWeeklyBossResinDiscountInfo()) {
                    mergeWeeklyBossResinDiscountInfo(other.getWeeklyBossResinDiscountInfo());
                }
                if (other.getDungeonId() != 0) {
                    setDungeonId(other.getDungeonId());
                }
                if (other.getNextBossChestRefreshTime() != 0) {
                    setNextBossChestRefreshTime(other.getNextBossChestRefreshTime());
                }
                if (other.getIsPassed()) {
                    setIsPassed(other.getIsPassed());
                }
                if (other.getNextRefreshTime() != 0) {
                    setNextRefreshTime(other.getNextRefreshTime());
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
                DungeonEntryInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = DungeonEntryInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DungeonEntryInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
            public int getMaxBossChestNum() {
                return this.maxBossChestNum_;
            }

            public Builder setMaxBossChestNum(int value) {
                this.maxBossChestNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxBossChestNum() {
                this.maxBossChestNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
            public int getStartTime() {
                return this.startTime_;
            }

            public Builder setStartTime(int value) {
                this.startTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartTime() {
                this.startTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
            public int getLeftTimes() {
                return this.leftTimes_;
            }

            public Builder setLeftTimes(int value) {
                this.leftTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftTimes() {
                this.leftTimes_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
            public int getEndTime() {
                return this.endTime_;
            }

            public Builder setEndTime(int value) {
                this.endTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndTime() {
                this.endTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
            public boolean hasWeeklyBossResinDiscountInfo() {
                return (this.weeklyBossResinDiscountInfoBuilder_ == null && this.weeklyBossResinDiscountInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
            public WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo getWeeklyBossResinDiscountInfo() {
                if (this.weeklyBossResinDiscountInfoBuilder_ == null) {
                    return this.weeklyBossResinDiscountInfo_ == null ? WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.getDefaultInstance() : this.weeklyBossResinDiscountInfo_;
                }
                return this.weeklyBossResinDiscountInfoBuilder_.getMessage();
            }

            public Builder setWeeklyBossResinDiscountInfo(WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo value) {
                if (this.weeklyBossResinDiscountInfoBuilder_ != null) {
                    this.weeklyBossResinDiscountInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.weeklyBossResinDiscountInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setWeeklyBossResinDiscountInfo(WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.Builder builderForValue) {
                if (this.weeklyBossResinDiscountInfoBuilder_ == null) {
                    this.weeklyBossResinDiscountInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.weeklyBossResinDiscountInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeWeeklyBossResinDiscountInfo(WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo value) {
                if (this.weeklyBossResinDiscountInfoBuilder_ == null) {
                    if (this.weeklyBossResinDiscountInfo_ != null) {
                        this.weeklyBossResinDiscountInfo_ = WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.newBuilder(this.weeklyBossResinDiscountInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.weeklyBossResinDiscountInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.weeklyBossResinDiscountInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearWeeklyBossResinDiscountInfo() {
                if (this.weeklyBossResinDiscountInfoBuilder_ == null) {
                    this.weeklyBossResinDiscountInfo_ = null;
                    onChanged();
                } else {
                    this.weeklyBossResinDiscountInfo_ = null;
                    this.weeklyBossResinDiscountInfoBuilder_ = null;
                }
                return this;
            }

            public WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.Builder getWeeklyBossResinDiscountInfoBuilder() {
                onChanged();
                return getWeeklyBossResinDiscountInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
            public WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder getWeeklyBossResinDiscountInfoOrBuilder() {
                if (this.weeklyBossResinDiscountInfoBuilder_ != null) {
                    return this.weeklyBossResinDiscountInfoBuilder_.getMessageOrBuilder();
                }
                return this.weeklyBossResinDiscountInfo_ == null ? WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.getDefaultInstance() : this.weeklyBossResinDiscountInfo_;
            }

            private SingleFieldBuilderV3<WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.Builder, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder> getWeeklyBossResinDiscountInfoFieldBuilder() {
                if (this.weeklyBossResinDiscountInfoBuilder_ == null) {
                    this.weeklyBossResinDiscountInfoBuilder_ = new SingleFieldBuilderV3<>(getWeeklyBossResinDiscountInfo(), getParentForChildren(), isClean());
                    this.weeklyBossResinDiscountInfo_ = null;
                }
                return this.weeklyBossResinDiscountInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
            public int getDungeonId() {
                return this.dungeonId_;
            }

            public Builder setDungeonId(int value) {
                this.dungeonId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDungeonId() {
                this.dungeonId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
            public int getNextBossChestRefreshTime() {
                return this.nextBossChestRefreshTime_;
            }

            public Builder setNextBossChestRefreshTime(int value) {
                this.nextBossChestRefreshTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextBossChestRefreshTime() {
                this.nextBossChestRefreshTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
            public boolean getIsPassed() {
                return this.isPassed_;
            }

            public Builder setIsPassed(boolean value) {
                this.isPassed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsPassed() {
                this.isPassed_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder
            public int getNextRefreshTime() {
                return this.nextRefreshTime_;
            }

            public Builder setNextRefreshTime(int value) {
                this.nextRefreshTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextRefreshTime() {
                this.nextRefreshTime_ = 0;
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

        public static DungeonEntryInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DungeonEntryInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DungeonEntryInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DungeonEntryInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WeeklyBossResinDiscountInfoOuterClass.getDescriptor();
    }
}
