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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.BonusOpActivityInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OpActivityInfoOuterClass.class */
public final class OpActivityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014OpActivityInfo.proto\u001a\u0019BonusOpActivityInfo.proto\"­\u0001\n\u000eOpActivityInfo\u0012\u0013\n\u000bactivity_id\u0018\u000f \u0001(\r\u0012\u0013\n\u000bschedule_id\u0018\u000e \u0001(\r\u0012\u0010\n\bend_time\u0018\u0004 \u0001(\r\u0012\u0012\n\nbegin_time\u0018\r \u0001(\r\u0012\u0015\n\ris_has_change\u0018\u0007 \u0001(\b\u0012*\n\nbonus_info\u0018\u0006 \u0001(\u000b2\u0014.BonusOpActivityInfoH��B\b\n\u0006detailB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BonusOpActivityInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_OpActivityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_OpActivityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_OpActivityInfo_descriptor, new String[]{"ActivityId", "ScheduleId", "EndTime", "BeginTime", "IsHasChange", "BonusInfo", "Detail"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OpActivityInfoOuterClass$OpActivityInfoOrBuilder.class */
    public interface OpActivityInfoOrBuilder extends MessageOrBuilder {
        int getActivityId();

        int getScheduleId();

        int getEndTime();

        int getBeginTime();

        boolean getIsHasChange();

        boolean hasBonusInfo();

        BonusOpActivityInfoOuterClass.BonusOpActivityInfo getBonusInfo();

        BonusOpActivityInfoOuterClass.BonusOpActivityInfoOrBuilder getBonusInfoOrBuilder();

        OpActivityInfo.DetailCase getDetailCase();
    }

    private OpActivityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OpActivityInfoOuterClass$OpActivityInfo.class */
    public static final class OpActivityInfo extends GeneratedMessageV3 implements OpActivityInfoOrBuilder {
        private static final long serialVersionUID = 0;
        private int detailCase_;
        private Object detail_;
        public static final int ACTIVITY_ID_FIELD_NUMBER = 15;
        private int activityId_;
        public static final int SCHEDULE_ID_FIELD_NUMBER = 14;
        private int scheduleId_;
        public static final int END_TIME_FIELD_NUMBER = 4;
        private int endTime_;
        public static final int BEGIN_TIME_FIELD_NUMBER = 13;
        private int beginTime_;
        public static final int IS_HAS_CHANGE_FIELD_NUMBER = 7;
        private boolean isHasChange_;
        public static final int BONUS_INFO_FIELD_NUMBER = 6;
        private byte memoizedIsInitialized;
        private static final OpActivityInfo DEFAULT_INSTANCE = new OpActivityInfo();
        private static final Parser<OpActivityInfo> PARSER = new AbstractParser<OpActivityInfo>() { // from class: emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfo.1
            @Override // com.google.protobuf.Parser
            public OpActivityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new OpActivityInfo(input, extensionRegistry);
            }
        };

        private OpActivityInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private OpActivityInfo() {
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new OpActivityInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OpActivityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.endTime_ = input.readUInt32();
                                break;
                            case 50:
                                BonusOpActivityInfoOuterClass.BonusOpActivityInfo.Builder subBuilder = this.detailCase_ == 6 ? ((BonusOpActivityInfoOuterClass.BonusOpActivityInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(BonusOpActivityInfoOuterClass.BonusOpActivityInfo.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((BonusOpActivityInfoOuterClass.BonusOpActivityInfo) this.detail_);
                                    this.detail_ = subBuilder.buildPartial();
                                }
                                this.detailCase_ = 6;
                                break;
                            case 56:
                                this.isHasChange_ = input.readBool();
                                break;
                            case 104:
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 112:
                                this.scheduleId_ = input.readUInt32();
                                break;
                            case 120:
                                this.activityId_ = input.readUInt32();
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
            return OpActivityInfoOuterClass.internal_static_OpActivityInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return OpActivityInfoOuterClass.internal_static_OpActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(OpActivityInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OpActivityInfoOuterClass$OpActivityInfo$DetailCase.class */
        public enum DetailCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            BONUS_INFO(6),
            DETAIL_NOT_SET(0);
            
            private final int value;

            DetailCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static DetailCase valueOf(int value) {
                return forNumber(value);
            }

            public static DetailCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return DETAIL_NOT_SET;
                    case 6:
                        return BONUS_INFO;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public DetailCase getDetailCase() {
            return DetailCase.forNumber(this.detailCase_);
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public int getActivityId() {
            return this.activityId_;
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public int getScheduleId() {
            return this.scheduleId_;
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public boolean getIsHasChange() {
            return this.isHasChange_;
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public boolean hasBonusInfo() {
            return this.detailCase_ == 6;
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public BonusOpActivityInfoOuterClass.BonusOpActivityInfo getBonusInfo() {
            if (this.detailCase_ == 6) {
                return (BonusOpActivityInfoOuterClass.BonusOpActivityInfo) this.detail_;
            }
            return BonusOpActivityInfoOuterClass.BonusOpActivityInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public BonusOpActivityInfoOuterClass.BonusOpActivityInfoOrBuilder getBonusInfoOrBuilder() {
            if (this.detailCase_ == 6) {
                return (BonusOpActivityInfoOuterClass.BonusOpActivityInfo) this.detail_;
            }
            return BonusOpActivityInfoOuterClass.BonusOpActivityInfo.getDefaultInstance();
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
            if (this.endTime_ != 0) {
                output.writeUInt32(4, this.endTime_);
            }
            if (this.detailCase_ == 6) {
                output.writeMessage(6, (BonusOpActivityInfoOuterClass.BonusOpActivityInfo) this.detail_);
            }
            if (this.isHasChange_) {
                output.writeBool(7, this.isHasChange_);
            }
            if (this.beginTime_ != 0) {
                output.writeUInt32(13, this.beginTime_);
            }
            if (this.scheduleId_ != 0) {
                output.writeUInt32(14, this.scheduleId_);
            }
            if (this.activityId_ != 0) {
                output.writeUInt32(15, this.activityId_);
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
            if (this.endTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.endTime_);
            }
            if (this.detailCase_ == 6) {
                size2 += CodedOutputStream.computeMessageSize(6, (BonusOpActivityInfoOuterClass.BonusOpActivityInfo) this.detail_);
            }
            if (this.isHasChange_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isHasChange_);
            }
            if (this.beginTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.beginTime_);
            }
            if (this.scheduleId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.scheduleId_);
            }
            if (this.activityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.activityId_);
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
            if (!(obj instanceof OpActivityInfo)) {
                return equals(obj);
            }
            OpActivityInfo other = (OpActivityInfo) obj;
            if (getActivityId() != other.getActivityId() || getScheduleId() != other.getScheduleId() || getEndTime() != other.getEndTime() || getBeginTime() != other.getBeginTime() || getIsHasChange() != other.getIsHasChange() || !getDetailCase().equals(other.getDetailCase())) {
                return false;
            }
            switch (this.detailCase_) {
                case 6:
                    if (!getBonusInfo().equals(other.getBonusInfo())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getActivityId())) + 14)) + getScheduleId())) + 4)) + getEndTime())) + 13)) + getBeginTime())) + 7)) + Internal.hashBoolean(getIsHasChange());
            switch (this.detailCase_) {
                case 6:
                    hash = (53 * ((37 * hash) + 6)) + getBonusInfo().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static OpActivityInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OpActivityInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OpActivityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OpActivityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OpActivityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OpActivityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OpActivityInfo parseFrom(InputStream input) throws IOException {
            return (OpActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static OpActivityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static OpActivityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (OpActivityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static OpActivityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpActivityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static OpActivityInfo parseFrom(CodedInputStream input) throws IOException {
            return (OpActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static OpActivityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(OpActivityInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OpActivityInfoOuterClass$OpActivityInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OpActivityInfoOrBuilder {
            private int detailCase_ = 0;
            private Object detail_;
            private int activityId_;
            private int scheduleId_;
            private int endTime_;
            private int beginTime_;
            private boolean isHasChange_;
            private SingleFieldBuilderV3<BonusOpActivityInfoOuterClass.BonusOpActivityInfo, BonusOpActivityInfoOuterClass.BonusOpActivityInfo.Builder, BonusOpActivityInfoOuterClass.BonusOpActivityInfoOrBuilder> bonusInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return OpActivityInfoOuterClass.internal_static_OpActivityInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return OpActivityInfoOuterClass.internal_static_OpActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(OpActivityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (OpActivityInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.activityId_ = 0;
                this.scheduleId_ = 0;
                this.endTime_ = 0;
                this.beginTime_ = 0;
                this.isHasChange_ = false;
                this.detailCase_ = 0;
                this.detail_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return OpActivityInfoOuterClass.internal_static_OpActivityInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public OpActivityInfo getDefaultInstanceForType() {
                return OpActivityInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OpActivityInfo build() {
                OpActivityInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OpActivityInfo buildPartial() {
                OpActivityInfo result = new OpActivityInfo(this);
                result.activityId_ = this.activityId_;
                result.scheduleId_ = this.scheduleId_;
                result.endTime_ = this.endTime_;
                result.beginTime_ = this.beginTime_;
                result.isHasChange_ = this.isHasChange_;
                if (this.detailCase_ == 6) {
                    if (this.bonusInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.bonusInfoBuilder_.build();
                    }
                }
                result.detailCase_ = this.detailCase_;
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
                if (other instanceof OpActivityInfo) {
                    return mergeFrom((OpActivityInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(OpActivityInfo other) {
                if (other == OpActivityInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getActivityId() != 0) {
                    setActivityId(other.getActivityId());
                }
                if (other.getScheduleId() != 0) {
                    setScheduleId(other.getScheduleId());
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (other.getIsHasChange()) {
                    setIsHasChange(other.getIsHasChange());
                }
                switch (other.getDetailCase()) {
                    case BONUS_INFO:
                        mergeBonusInfo(other.getBonusInfo());
                        break;
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
                OpActivityInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = OpActivityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (OpActivityInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
            public DetailCase getDetailCase() {
                return DetailCase.forNumber(this.detailCase_);
            }

            public Builder clearDetail() {
                this.detailCase_ = 0;
                this.detail_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
            public int getActivityId() {
                return this.activityId_;
            }

            public Builder setActivityId(int value) {
                this.activityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearActivityId() {
                this.activityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
            public int getScheduleId() {
                return this.scheduleId_;
            }

            public Builder setScheduleId(int value) {
                this.scheduleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearScheduleId() {
                this.scheduleId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
            public int getBeginTime() {
                return this.beginTime_;
            }

            public Builder setBeginTime(int value) {
                this.beginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBeginTime() {
                this.beginTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
            public boolean getIsHasChange() {
                return this.isHasChange_;
            }

            public Builder setIsHasChange(boolean value) {
                this.isHasChange_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsHasChange() {
                this.isHasChange_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
            public boolean hasBonusInfo() {
                return this.detailCase_ == 6;
            }

            @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
            public BonusOpActivityInfoOuterClass.BonusOpActivityInfo getBonusInfo() {
                if (this.bonusInfoBuilder_ == null) {
                    if (this.detailCase_ == 6) {
                        return (BonusOpActivityInfoOuterClass.BonusOpActivityInfo) this.detail_;
                    }
                    return BonusOpActivityInfoOuterClass.BonusOpActivityInfo.getDefaultInstance();
                } else if (this.detailCase_ == 6) {
                    return this.bonusInfoBuilder_.getMessage();
                } else {
                    return BonusOpActivityInfoOuterClass.BonusOpActivityInfo.getDefaultInstance();
                }
            }

            public Builder setBonusInfo(BonusOpActivityInfoOuterClass.BonusOpActivityInfo value) {
                if (this.bonusInfoBuilder_ != null) {
                    this.bonusInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 6;
                return this;
            }

            public Builder setBonusInfo(BonusOpActivityInfoOuterClass.BonusOpActivityInfo.Builder builderForValue) {
                if (this.bonusInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.bonusInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 6;
                return this;
            }

            public Builder mergeBonusInfo(BonusOpActivityInfoOuterClass.BonusOpActivityInfo value) {
                if (this.bonusInfoBuilder_ == null) {
                    if (this.detailCase_ != 6 || this.detail_ == BonusOpActivityInfoOuterClass.BonusOpActivityInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BonusOpActivityInfoOuterClass.BonusOpActivityInfo.newBuilder((BonusOpActivityInfoOuterClass.BonusOpActivityInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 6) {
                        this.bonusInfoBuilder_.mergeFrom(value);
                    }
                    this.bonusInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 6;
                return this;
            }

            public Builder clearBonusInfo() {
                if (this.bonusInfoBuilder_ != null) {
                    if (this.detailCase_ == 6) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.bonusInfoBuilder_.clear();
                } else if (this.detailCase_ == 6) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BonusOpActivityInfoOuterClass.BonusOpActivityInfo.Builder getBonusInfoBuilder() {
                return getBonusInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
            public BonusOpActivityInfoOuterClass.BonusOpActivityInfoOrBuilder getBonusInfoOrBuilder() {
                if (this.detailCase_ == 6 && this.bonusInfoBuilder_ != null) {
                    return this.bonusInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 6) {
                    return (BonusOpActivityInfoOuterClass.BonusOpActivityInfo) this.detail_;
                }
                return BonusOpActivityInfoOuterClass.BonusOpActivityInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BonusOpActivityInfoOuterClass.BonusOpActivityInfo, BonusOpActivityInfoOuterClass.BonusOpActivityInfo.Builder, BonusOpActivityInfoOuterClass.BonusOpActivityInfoOrBuilder> getBonusInfoFieldBuilder() {
                if (this.bonusInfoBuilder_ == null) {
                    if (this.detailCase_ != 6) {
                        this.detail_ = BonusOpActivityInfoOuterClass.BonusOpActivityInfo.getDefaultInstance();
                    }
                    this.bonusInfoBuilder_ = new SingleFieldBuilderV3<>((BonusOpActivityInfoOuterClass.BonusOpActivityInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 6;
                onChanged();
                return this.bonusInfoBuilder_;
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

        public static OpActivityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OpActivityInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<OpActivityInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public OpActivityInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BonusOpActivityInfoOuterClass.getDescriptor();
    }
}
