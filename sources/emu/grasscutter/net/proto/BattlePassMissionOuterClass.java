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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassMissionOuterClass.class */
public final class BattlePassMissionOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017BattlePassMission.proto\"É\u0002\n\u0011BattlePassMission\u0012\u0011\n\tmissionId\u0018\u0006 \u0001(\r\u0012\u0013\n\u000bmissionType\u0018\u000e \u0001(\r\u00127\n\rmissionStatus\u0018\t \u0001(\u000e2 .BattlePassMission.MissionStatus\u0012\u0013\n\u000bcurProgress\u0018\u000b \u0001(\r\u0012\u001d\n\u0015rewardBattlePassPoint\u0018\n \u0001(\r\u0012\u0015\n\rtotalProgress\u0018\r \u0001(\r\"\u0001\n\rMissionStatus\u0012\u001a\n\u0016MISSION_STATUS_INVALID\u0010��\u0012\u001d\n\u0019MISSION_STATUS_UNFINISHED\u0010\u0001\u0012\u001b\n\u0017MISSION_STATUS_FINISHED\u0010\u0002\u0012\u001e\n\u001aMISSION_STATUS_POINT_TAKEN\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BattlePassMission_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BattlePassMission_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BattlePassMission_descriptor, new String[]{"MissionId", "MissionType", "MissionStatus", "CurProgress", "RewardBattlePassPoint", "TotalProgress"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassMissionOuterClass$BattlePassMissionOrBuilder.class */
    public interface BattlePassMissionOrBuilder extends MessageOrBuilder {
        int getMissionId();

        int getMissionType();

        int getMissionStatusValue();

        BattlePassMission.MissionStatus getMissionStatus();

        int getCurProgress();

        int getRewardBattlePassPoint();

        int getTotalProgress();
    }

    private BattlePassMissionOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassMissionOuterClass$BattlePassMission.class */
    public static final class BattlePassMission extends GeneratedMessageV3 implements BattlePassMissionOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MISSIONID_FIELD_NUMBER = 6;
        private int missionId_;
        public static final int MISSIONTYPE_FIELD_NUMBER = 14;
        private int missionType_;
        public static final int MISSIONSTATUS_FIELD_NUMBER = 9;
        private int missionStatus_;
        public static final int CURPROGRESS_FIELD_NUMBER = 11;
        private int curProgress_;
        public static final int REWARDBATTLEPASSPOINT_FIELD_NUMBER = 10;
        private int rewardBattlePassPoint_;
        public static final int TOTALPROGRESS_FIELD_NUMBER = 13;
        private int totalProgress_;
        private byte memoizedIsInitialized;
        private static final BattlePassMission DEFAULT_INSTANCE = new BattlePassMission();
        private static final Parser<BattlePassMission> PARSER = new AbstractParser<BattlePassMission>() { // from class: emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMission.1
            @Override // com.google.protobuf.Parser
            public BattlePassMission parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattlePassMission(input, extensionRegistry);
            }
        };

        private BattlePassMission(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BattlePassMission() {
            this.memoizedIsInitialized = -1;
            this.missionStatus_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BattlePassMission();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BattlePassMission(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 48:
                                this.missionId_ = input.readUInt32();
                                break;
                            case 72:
                                this.missionStatus_ = input.readEnum();
                                break;
                            case 80:
                                this.rewardBattlePassPoint_ = input.readUInt32();
                                break;
                            case 88:
                                this.curProgress_ = input.readUInt32();
                                break;
                            case 104:
                                this.totalProgress_ = input.readUInt32();
                                break;
                            case 112:
                                this.missionType_ = input.readUInt32();
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
            return BattlePassMissionOuterClass.internal_static_BattlePassMission_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattlePassMissionOuterClass.internal_static_BattlePassMission_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassMission.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassMissionOuterClass$BattlePassMission$MissionStatus.class */
        public enum MissionStatus implements ProtocolMessageEnum {
            MISSION_STATUS_INVALID(0),
            MISSION_STATUS_UNFINISHED(1),
            MISSION_STATUS_FINISHED(2),
            MISSION_STATUS_POINT_TAKEN(3),
            UNRECOGNIZED(-1);
            
            public static final int MISSION_STATUS_INVALID_VALUE = 0;
            public static final int MISSION_STATUS_UNFINISHED_VALUE = 1;
            public static final int MISSION_STATUS_FINISHED_VALUE = 2;
            public static final int MISSION_STATUS_POINT_TAKEN_VALUE = 3;
            private static final Internal.EnumLiteMap<MissionStatus> internalValueMap = new Internal.EnumLiteMap<MissionStatus>() { // from class: emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMission.MissionStatus.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public MissionStatus findValueByNumber(int number) {
                    return MissionStatus.forNumber(number);
                }
            };
            private static final MissionStatus[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static MissionStatus valueOf(int value) {
                return forNumber(value);
            }

            public static MissionStatus forNumber(int value) {
                switch (value) {
                    case 0:
                        return MISSION_STATUS_INVALID;
                    case 1:
                        return MISSION_STATUS_UNFINISHED;
                    case 2:
                        return MISSION_STATUS_FINISHED;
                    case 3:
                        return MISSION_STATUS_POINT_TAKEN;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<MissionStatus> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return BattlePassMission.getDescriptor().getEnumTypes().get(0);
            }

            public static MissionStatus valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            MissionStatus(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMissionOrBuilder
        public int getMissionId() {
            return this.missionId_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMissionOrBuilder
        public int getMissionType() {
            return this.missionType_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMissionOrBuilder
        public int getMissionStatusValue() {
            return this.missionStatus_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMissionOrBuilder
        public MissionStatus getMissionStatus() {
            MissionStatus result = MissionStatus.valueOf(this.missionStatus_);
            return result == null ? MissionStatus.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMissionOrBuilder
        public int getCurProgress() {
            return this.curProgress_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMissionOrBuilder
        public int getRewardBattlePassPoint() {
            return this.rewardBattlePassPoint_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMissionOrBuilder
        public int getTotalProgress() {
            return this.totalProgress_;
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
            if (this.missionId_ != 0) {
                output.writeUInt32(6, this.missionId_);
            }
            if (this.missionStatus_ != MissionStatus.MISSION_STATUS_INVALID.getNumber()) {
                output.writeEnum(9, this.missionStatus_);
            }
            if (this.rewardBattlePassPoint_ != 0) {
                output.writeUInt32(10, this.rewardBattlePassPoint_);
            }
            if (this.curProgress_ != 0) {
                output.writeUInt32(11, this.curProgress_);
            }
            if (this.totalProgress_ != 0) {
                output.writeUInt32(13, this.totalProgress_);
            }
            if (this.missionType_ != 0) {
                output.writeUInt32(14, this.missionType_);
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
            if (this.missionId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.missionId_);
            }
            if (this.missionStatus_ != MissionStatus.MISSION_STATUS_INVALID.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(9, this.missionStatus_);
            }
            if (this.rewardBattlePassPoint_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.rewardBattlePassPoint_);
            }
            if (this.curProgress_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.curProgress_);
            }
            if (this.totalProgress_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.totalProgress_);
            }
            if (this.missionType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.missionType_);
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
            if (!(obj instanceof BattlePassMission)) {
                return equals(obj);
            }
            BattlePassMission other = (BattlePassMission) obj;
            return getMissionId() == other.getMissionId() && getMissionType() == other.getMissionType() && this.missionStatus_ == other.missionStatus_ && getCurProgress() == other.getCurProgress() && getRewardBattlePassPoint() == other.getRewardBattlePassPoint() && getTotalProgress() == other.getTotalProgress() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getMissionId())) + 14)) + getMissionType())) + 9)) + this.missionStatus_)) + 11)) + getCurProgress())) + 10)) + getRewardBattlePassPoint())) + 13)) + getTotalProgress())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BattlePassMission parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassMission parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassMission parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassMission parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassMission parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassMission parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassMission parseFrom(InputStream input) throws IOException {
            return (BattlePassMission) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassMission parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassMission) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassMission parseDelimitedFrom(InputStream input) throws IOException {
            return (BattlePassMission) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BattlePassMission parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassMission) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassMission parseFrom(CodedInputStream input) throws IOException {
            return (BattlePassMission) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassMission parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassMission) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BattlePassMission prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassMissionOuterClass$BattlePassMission$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BattlePassMissionOrBuilder {
            private int missionId_;
            private int missionType_;
            private int missionStatus_ = 0;
            private int curProgress_;
            private int rewardBattlePassPoint_;
            private int totalProgress_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BattlePassMissionOuterClass.internal_static_BattlePassMission_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattlePassMissionOuterClass.internal_static_BattlePassMission_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassMission.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BattlePassMission.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.missionId_ = 0;
                this.missionType_ = 0;
                this.missionStatus_ = 0;
                this.curProgress_ = 0;
                this.rewardBattlePassPoint_ = 0;
                this.totalProgress_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BattlePassMissionOuterClass.internal_static_BattlePassMission_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BattlePassMission getDefaultInstanceForType() {
                return BattlePassMission.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassMission build() {
                BattlePassMission result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassMission buildPartial() {
                BattlePassMission result = new BattlePassMission(this);
                result.missionId_ = this.missionId_;
                result.missionType_ = this.missionType_;
                result.missionStatus_ = this.missionStatus_;
                result.curProgress_ = this.curProgress_;
                result.rewardBattlePassPoint_ = this.rewardBattlePassPoint_;
                result.totalProgress_ = this.totalProgress_;
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
                if (other instanceof BattlePassMission) {
                    return mergeFrom((BattlePassMission) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BattlePassMission other) {
                if (other == BattlePassMission.getDefaultInstance()) {
                    return this;
                }
                if (other.getMissionId() != 0) {
                    setMissionId(other.getMissionId());
                }
                if (other.getMissionType() != 0) {
                    setMissionType(other.getMissionType());
                }
                if (other.missionStatus_ != 0) {
                    setMissionStatusValue(other.getMissionStatusValue());
                }
                if (other.getCurProgress() != 0) {
                    setCurProgress(other.getCurProgress());
                }
                if (other.getRewardBattlePassPoint() != 0) {
                    setRewardBattlePassPoint(other.getRewardBattlePassPoint());
                }
                if (other.getTotalProgress() != 0) {
                    setTotalProgress(other.getTotalProgress());
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
                BattlePassMission parsedMessage = null;
                try {
                    try {
                        parsedMessage = BattlePassMission.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BattlePassMission) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMissionOrBuilder
            public int getMissionId() {
                return this.missionId_;
            }

            public Builder setMissionId(int value) {
                this.missionId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMissionId() {
                this.missionId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMissionOrBuilder
            public int getMissionType() {
                return this.missionType_;
            }

            public Builder setMissionType(int value) {
                this.missionType_ = value;
                onChanged();
                return this;
            }

            public Builder clearMissionType() {
                this.missionType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMissionOrBuilder
            public int getMissionStatusValue() {
                return this.missionStatus_;
            }

            public Builder setMissionStatusValue(int value) {
                this.missionStatus_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMissionOrBuilder
            public MissionStatus getMissionStatus() {
                MissionStatus result = MissionStatus.valueOf(this.missionStatus_);
                return result == null ? MissionStatus.UNRECOGNIZED : result;
            }

            public Builder setMissionStatus(MissionStatus value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.missionStatus_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearMissionStatus() {
                this.missionStatus_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMissionOrBuilder
            public int getCurProgress() {
                return this.curProgress_;
            }

            public Builder setCurProgress(int value) {
                this.curProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurProgress() {
                this.curProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMissionOrBuilder
            public int getRewardBattlePassPoint() {
                return this.rewardBattlePassPoint_;
            }

            public Builder setRewardBattlePassPoint(int value) {
                this.rewardBattlePassPoint_ = value;
                onChanged();
                return this;
            }

            public Builder clearRewardBattlePassPoint() {
                this.rewardBattlePassPoint_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassMissionOuterClass.BattlePassMissionOrBuilder
            public int getTotalProgress() {
                return this.totalProgress_;
            }

            public Builder setTotalProgress(int value) {
                this.totalProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalProgress() {
                this.totalProgress_ = 0;
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

        public static BattlePassMission getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BattlePassMission> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BattlePassMission> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BattlePassMission getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
