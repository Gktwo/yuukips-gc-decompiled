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
import emu.grasscutter.net.proto.BonusInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OpActivityInfoOuterClass.class */
public final class OpActivityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014OpActivityInfo.proto\u001a\u000fBonusInfo.proto\"\u0001\n\u000eOpActivityInfo\u0012\u0012\n\nscheduleId\u0018\u0001 \u0001(\r\u0012\u0011\n\tbeginTime\u0018\b \u0001(\r\u0012\u0012\n\nactivityId\u0018\u000f \u0001(\r\u0012\u0013\n\u000bisHasChange\u0018\u0003 \u0001(\b\u0012 \n\nbonus_info\u0018\u000b \u0001(\u000b2\n.BonusInfoH��\u0012\u000f\n\u0007endTime\u0018\n \u0001(\rB\b\n\u0006detailB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BonusInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_OpActivityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_OpActivityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_OpActivityInfo_descriptor, new String[]{"ScheduleId", "BeginTime", "ActivityId", "IsHasChange", "BonusInfo", "EndTime", "Detail"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OpActivityInfoOuterClass$OpActivityInfoOrBuilder.class */
    public interface OpActivityInfoOrBuilder extends MessageOrBuilder {
        int getScheduleId();

        int getBeginTime();

        int getActivityId();

        boolean getIsHasChange();

        boolean hasBonusInfo();

        BonusInfoOuterClass.BonusInfo getBonusInfo();

        BonusInfoOuterClass.BonusInfoOrBuilder getBonusInfoOrBuilder();

        int getEndTime();

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
        public static final int SCHEDULEID_FIELD_NUMBER = 1;
        private int scheduleId_;
        public static final int BEGINTIME_FIELD_NUMBER = 8;
        private int beginTime_;
        public static final int ACTIVITYID_FIELD_NUMBER = 15;
        private int activityId_;
        public static final int ISHASCHANGE_FIELD_NUMBER = 3;
        private boolean isHasChange_;
        public static final int BONUS_INFO_FIELD_NUMBER = 11;
        public static final int ENDTIME_FIELD_NUMBER = 10;
        private int endTime_;
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
                            case 8:
                                this.scheduleId_ = input.readUInt32();
                                break;
                            case 24:
                                this.isHasChange_ = input.readBool();
                                break;
                            case 64:
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 80:
                                this.endTime_ = input.readUInt32();
                                break;
                            case 90:
                                BonusInfoOuterClass.BonusInfo.Builder subBuilder = this.detailCase_ == 11 ? ((BonusInfoOuterClass.BonusInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(BonusInfoOuterClass.BonusInfo.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((BonusInfoOuterClass.BonusInfo) this.detail_);
                                    this.detail_ = subBuilder.buildPartial();
                                }
                                this.detailCase_ = 11;
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
            BONUS_INFO(11),
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
                    case 11:
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
        public int getScheduleId() {
            return this.scheduleId_;
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public int getActivityId() {
            return this.activityId_;
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public boolean getIsHasChange() {
            return this.isHasChange_;
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public boolean hasBonusInfo() {
            return this.detailCase_ == 11;
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public BonusInfoOuterClass.BonusInfo getBonusInfo() {
            if (this.detailCase_ == 11) {
                return (BonusInfoOuterClass.BonusInfo) this.detail_;
            }
            return BonusInfoOuterClass.BonusInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public BonusInfoOuterClass.BonusInfoOrBuilder getBonusInfoOrBuilder() {
            if (this.detailCase_ == 11) {
                return (BonusInfoOuterClass.BonusInfo) this.detail_;
            }
            return BonusInfoOuterClass.BonusInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
        public int getEndTime() {
            return this.endTime_;
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
            if (this.scheduleId_ != 0) {
                output.writeUInt32(1, this.scheduleId_);
            }
            if (this.isHasChange_) {
                output.writeBool(3, this.isHasChange_);
            }
            if (this.beginTime_ != 0) {
                output.writeUInt32(8, this.beginTime_);
            }
            if (this.endTime_ != 0) {
                output.writeUInt32(10, this.endTime_);
            }
            if (this.detailCase_ == 11) {
                output.writeMessage(11, (BonusInfoOuterClass.BonusInfo) this.detail_);
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
            if (this.scheduleId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.scheduleId_);
            }
            if (this.isHasChange_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isHasChange_);
            }
            if (this.beginTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.beginTime_);
            }
            if (this.endTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.endTime_);
            }
            if (this.detailCase_ == 11) {
                size2 += CodedOutputStream.computeMessageSize(11, (BonusInfoOuterClass.BonusInfo) this.detail_);
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
            if (getScheduleId() != other.getScheduleId() || getBeginTime() != other.getBeginTime() || getActivityId() != other.getActivityId() || getIsHasChange() != other.getIsHasChange() || getEndTime() != other.getEndTime() || !getDetailCase().equals(other.getDetailCase())) {
                return false;
            }
            switch (this.detailCase_) {
                case 11:
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
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getScheduleId())) + 8)) + getBeginTime())) + 15)) + getActivityId())) + 3)) + Internal.hashBoolean(getIsHasChange()))) + 10)) + getEndTime();
            switch (this.detailCase_) {
                case 11:
                    hash = (53 * ((37 * hash) + 11)) + getBonusInfo().hashCode();
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
            private int scheduleId_;
            private int beginTime_;
            private int activityId_;
            private boolean isHasChange_;
            private SingleFieldBuilderV3<BonusInfoOuterClass.BonusInfo, BonusInfoOuterClass.BonusInfo.Builder, BonusInfoOuterClass.BonusInfoOrBuilder> bonusInfoBuilder_;
            private int endTime_;

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
                this.scheduleId_ = 0;
                this.beginTime_ = 0;
                this.activityId_ = 0;
                this.isHasChange_ = false;
                this.endTime_ = 0;
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
                result.scheduleId_ = this.scheduleId_;
                result.beginTime_ = this.beginTime_;
                result.activityId_ = this.activityId_;
                result.isHasChange_ = this.isHasChange_;
                if (this.detailCase_ == 11) {
                    if (this.bonusInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.bonusInfoBuilder_.build();
                    }
                }
                result.endTime_ = this.endTime_;
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
                if (other.getScheduleId() != 0) {
                    setScheduleId(other.getScheduleId());
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (other.getActivityId() != 0) {
                    setActivityId(other.getActivityId());
                }
                if (other.getIsHasChange()) {
                    setIsHasChange(other.getIsHasChange());
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
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
                return this.detailCase_ == 11;
            }

            @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
            public BonusInfoOuterClass.BonusInfo getBonusInfo() {
                if (this.bonusInfoBuilder_ == null) {
                    if (this.detailCase_ == 11) {
                        return (BonusInfoOuterClass.BonusInfo) this.detail_;
                    }
                    return BonusInfoOuterClass.BonusInfo.getDefaultInstance();
                } else if (this.detailCase_ == 11) {
                    return this.bonusInfoBuilder_.getMessage();
                } else {
                    return BonusInfoOuterClass.BonusInfo.getDefaultInstance();
                }
            }

            public Builder setBonusInfo(BonusInfoOuterClass.BonusInfo value) {
                if (this.bonusInfoBuilder_ != null) {
                    this.bonusInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 11;
                return this;
            }

            public Builder setBonusInfo(BonusInfoOuterClass.BonusInfo.Builder builderForValue) {
                if (this.bonusInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.bonusInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 11;
                return this;
            }

            public Builder mergeBonusInfo(BonusInfoOuterClass.BonusInfo value) {
                if (this.bonusInfoBuilder_ == null) {
                    if (this.detailCase_ != 11 || this.detail_ == BonusInfoOuterClass.BonusInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BonusInfoOuterClass.BonusInfo.newBuilder((BonusInfoOuterClass.BonusInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 11) {
                        this.bonusInfoBuilder_.mergeFrom(value);
                    }
                    this.bonusInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 11;
                return this;
            }

            public Builder clearBonusInfo() {
                if (this.bonusInfoBuilder_ != null) {
                    if (this.detailCase_ == 11) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.bonusInfoBuilder_.clear();
                } else if (this.detailCase_ == 11) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BonusInfoOuterClass.BonusInfo.Builder getBonusInfoBuilder() {
                return getBonusInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.OpActivityInfoOuterClass.OpActivityInfoOrBuilder
            public BonusInfoOuterClass.BonusInfoOrBuilder getBonusInfoOrBuilder() {
                if (this.detailCase_ == 11 && this.bonusInfoBuilder_ != null) {
                    return this.bonusInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 11) {
                    return (BonusInfoOuterClass.BonusInfo) this.detail_;
                }
                return BonusInfoOuterClass.BonusInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BonusInfoOuterClass.BonusInfo, BonusInfoOuterClass.BonusInfo.Builder, BonusInfoOuterClass.BonusInfoOrBuilder> getBonusInfoFieldBuilder() {
                if (this.bonusInfoBuilder_ == null) {
                    if (this.detailCase_ != 11) {
                        this.detail_ = BonusInfoOuterClass.BonusInfo.getDefaultInstance();
                    }
                    this.bonusInfoBuilder_ = new SingleFieldBuilderV3<>((BonusInfoOuterClass.BonusInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 11;
                onChanged();
                return this.bonusInfoBuilder_;
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
        BonusInfoOuterClass.getDescriptor();
    }
}
