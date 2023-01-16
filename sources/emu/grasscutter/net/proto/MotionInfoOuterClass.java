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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.MotionStateOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MotionInfoOuterClass.class */
public final class MotionInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010MotionInfo.proto\u001a\u0011MotionState.proto\u001a\fVector.proto\"ß\u0001\n\nMotionInfo\u0012\u0014\n\u0003pos\u0018\u0001 \u0001(\u000b2\u0007.Vector\u0012\u0014\n\u0003rot\u0018\u0002 \u0001(\u000b2\u0007.Vector\u0012\u0016\n\u0005speed\u0018\u0003 \u0001(\u000b2\u0007.Vector\u0012\u001b\n\u0005state\u0018\u0004 \u0001(\u000e2\f.MotionState\u0012\u0017\n\u0006params\u0018\u0005 \u0003(\u000b2\u0007.Vector\u0012\u0018\n\u0007ref_pos\u0018\u0006 \u0001(\u000b2\u0007.Vector\u0012\u000e\n\u0006ref_id\u0018\u0007 \u0001(\r\u0012\u0012\n\nscene_time\u0018\b \u0001(\r\u0012\u0019\n\u0011interval_velocity\u0018\t \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MotionStateOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MotionInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MotionInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MotionInfo_descriptor, new String[]{"Pos", "Rot", "Speed", "State", "Params", "RefPos", "RefId", "SceneTime", "IntervalVelocity"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MotionInfoOuterClass$MotionInfoOrBuilder.class */
    public interface MotionInfoOrBuilder extends MessageOrBuilder {
        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        boolean hasRot();

        VectorOuterClass.Vector getRot();

        VectorOuterClass.VectorOrBuilder getRotOrBuilder();

        boolean hasSpeed();

        VectorOuterClass.Vector getSpeed();

        VectorOuterClass.VectorOrBuilder getSpeedOrBuilder();

        int getStateValue();

        MotionStateOuterClass.MotionState getState();

        List<VectorOuterClass.Vector> getParamsList();

        VectorOuterClass.Vector getParams(int i);

        int getParamsCount();

        List<? extends VectorOuterClass.VectorOrBuilder> getParamsOrBuilderList();

        VectorOuterClass.VectorOrBuilder getParamsOrBuilder(int i);

        boolean hasRefPos();

        VectorOuterClass.Vector getRefPos();

        VectorOuterClass.VectorOrBuilder getRefPosOrBuilder();

        int getRefId();

        int getSceneTime();

        long getIntervalVelocity();
    }

    private MotionInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MotionInfoOuterClass$MotionInfo.class */
    public static final class MotionInfo extends GeneratedMessageV3 implements MotionInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int POS_FIELD_NUMBER = 1;
        private VectorOuterClass.Vector pos_;
        public static final int ROT_FIELD_NUMBER = 2;
        private VectorOuterClass.Vector rot_;
        public static final int SPEED_FIELD_NUMBER = 3;
        private VectorOuterClass.Vector speed_;
        public static final int STATE_FIELD_NUMBER = 4;
        private int state_;
        public static final int PARAMS_FIELD_NUMBER = 5;
        private List<VectorOuterClass.Vector> params_;
        public static final int REF_POS_FIELD_NUMBER = 6;
        private VectorOuterClass.Vector refPos_;
        public static final int REF_ID_FIELD_NUMBER = 7;
        private int refId_;
        public static final int SCENE_TIME_FIELD_NUMBER = 8;
        private int sceneTime_;
        public static final int INTERVAL_VELOCITY_FIELD_NUMBER = 9;
        private long intervalVelocity_;
        private byte memoizedIsInitialized;
        private static final MotionInfo DEFAULT_INSTANCE = new MotionInfo();
        private static final Parser<MotionInfo> PARSER = new AbstractParser<MotionInfo>() { // from class: emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfo.1
            @Override // com.google.protobuf.Parser
            public MotionInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MotionInfo(input, extensionRegistry);
            }
        };

        private MotionInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MotionInfo() {
            this.memoizedIsInitialized = -1;
            this.state_ = 0;
            this.params_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MotionInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MotionInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 10:
                                    VectorOuterClass.Vector.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                    this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.pos_);
                                        this.pos_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 18:
                                    VectorOuterClass.Vector.Builder subBuilder2 = this.rot_ != null ? this.rot_.toBuilder() : null;
                                    this.rot_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.rot_);
                                        this.rot_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 26:
                                    VectorOuterClass.Vector.Builder subBuilder3 = this.speed_ != null ? this.speed_.toBuilder() : null;
                                    this.speed_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder3 == null) {
                                        break;
                                    } else {
                                        subBuilder3.mergeFrom(this.speed_);
                                        this.speed_ = subBuilder3.buildPartial();
                                        break;
                                    }
                                case 32:
                                    this.state_ = input.readEnum();
                                    break;
                                case 42:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.params_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.params_.add((VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry));
                                    break;
                                case 50:
                                    VectorOuterClass.Vector.Builder subBuilder4 = this.refPos_ != null ? this.refPos_.toBuilder() : null;
                                    this.refPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder4 == null) {
                                        break;
                                    } else {
                                        subBuilder4.mergeFrom(this.refPos_);
                                        this.refPos_ = subBuilder4.buildPartial();
                                        break;
                                    }
                                case 56:
                                    this.refId_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.sceneTime_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.intervalVelocity_ = input.readUInt64();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.params_ = Collections.unmodifiableList(this.params_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MotionInfoOuterClass.internal_static_MotionInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MotionInfoOuterClass.internal_static_MotionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MotionInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public boolean hasRot() {
            return this.rot_ != null;
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public VectorOuterClass.Vector getRot() {
            return this.rot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rot_;
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getRotOrBuilder() {
            return getRot();
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public boolean hasSpeed() {
            return this.speed_ != null;
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public VectorOuterClass.Vector getSpeed() {
            return this.speed_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.speed_;
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getSpeedOrBuilder() {
            return getSpeed();
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public int getStateValue() {
            return this.state_;
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public MotionStateOuterClass.MotionState getState() {
            MotionStateOuterClass.MotionState result = MotionStateOuterClass.MotionState.valueOf(this.state_);
            return result == null ? MotionStateOuterClass.MotionState.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public List<VectorOuterClass.Vector> getParamsList() {
            return this.params_;
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public List<? extends VectorOuterClass.VectorOrBuilder> getParamsOrBuilderList() {
            return this.params_;
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public int getParamsCount() {
            return this.params_.size();
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public VectorOuterClass.Vector getParams(int index) {
            return this.params_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getParamsOrBuilder(int index) {
            return this.params_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public boolean hasRefPos() {
            return this.refPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public VectorOuterClass.Vector getRefPos() {
            return this.refPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.refPos_;
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getRefPosOrBuilder() {
            return getRefPos();
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public int getRefId() {
            return this.refId_;
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public int getSceneTime() {
            return this.sceneTime_;
        }

        @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
        public long getIntervalVelocity() {
            return this.intervalVelocity_;
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
            if (this.pos_ != null) {
                output.writeMessage(1, getPos());
            }
            if (this.rot_ != null) {
                output.writeMessage(2, getRot());
            }
            if (this.speed_ != null) {
                output.writeMessage(3, getSpeed());
            }
            if (this.state_ != MotionStateOuterClass.MotionState.MOTION_STATE_NONE.getNumber()) {
                output.writeEnum(4, this.state_);
            }
            for (int i = 0; i < this.params_.size(); i++) {
                output.writeMessage(5, this.params_.get(i));
            }
            if (this.refPos_ != null) {
                output.writeMessage(6, getRefPos());
            }
            if (this.refId_ != 0) {
                output.writeUInt32(7, this.refId_);
            }
            if (this.sceneTime_ != 0) {
                output.writeUInt32(8, this.sceneTime_);
            }
            if (this.intervalVelocity_ != 0) {
                output.writeUInt64(9, this.intervalVelocity_);
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
            if (this.pos_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getPos());
            }
            if (this.rot_ != null) {
                size2 += CodedOutputStream.computeMessageSize(2, getRot());
            }
            if (this.speed_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getSpeed());
            }
            if (this.state_ != MotionStateOuterClass.MotionState.MOTION_STATE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(4, this.state_);
            }
            for (int i = 0; i < this.params_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.params_.get(i));
            }
            if (this.refPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getRefPos());
            }
            if (this.refId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.refId_);
            }
            if (this.sceneTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.sceneTime_);
            }
            if (this.intervalVelocity_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(9, this.intervalVelocity_);
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
            if (!(obj instanceof MotionInfo)) {
                return equals(obj);
            }
            MotionInfo other = (MotionInfo) obj;
            if (hasPos() != other.hasPos()) {
                return false;
            }
            if ((hasPos() && !getPos().equals(other.getPos())) || hasRot() != other.hasRot()) {
                return false;
            }
            if ((hasRot() && !getRot().equals(other.getRot())) || hasSpeed() != other.hasSpeed()) {
                return false;
            }
            if ((!hasSpeed() || getSpeed().equals(other.getSpeed())) && this.state_ == other.state_ && getParamsList().equals(other.getParamsList()) && hasRefPos() == other.hasRefPos()) {
                return (!hasRefPos() || getRefPos().equals(other.getRefPos())) && getRefId() == other.getRefId() && getSceneTime() == other.getSceneTime() && getIntervalVelocity() == other.getIntervalVelocity() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 1)) + getPos().hashCode();
            }
            if (hasRot()) {
                hash = (53 * ((37 * hash) + 2)) + getRot().hashCode();
            }
            if (hasSpeed()) {
                hash = (53 * ((37 * hash) + 3)) + getSpeed().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 4)) + this.state_;
            if (getParamsCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 5)) + getParamsList().hashCode();
            }
            if (hasRefPos()) {
                hash2 = (53 * ((37 * hash2) + 6)) + getRefPos().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 7)) + getRefId())) + 8)) + getSceneTime())) + 9)) + Internal.hashLong(getIntervalVelocity()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static MotionInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MotionInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MotionInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MotionInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MotionInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MotionInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MotionInfo parseFrom(InputStream input) throws IOException {
            return (MotionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MotionInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MotionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MotionInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MotionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MotionInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MotionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MotionInfo parseFrom(CodedInputStream input) throws IOException {
            return (MotionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MotionInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MotionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MotionInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MotionInfoOuterClass$MotionInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MotionInfoOrBuilder {
            private int bitField0_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private VectorOuterClass.Vector rot_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> rotBuilder_;
            private VectorOuterClass.Vector speed_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> speedBuilder_;
            private int state_ = 0;
            private List<VectorOuterClass.Vector> params_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> paramsBuilder_;
            private VectorOuterClass.Vector refPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> refPosBuilder_;
            private int refId_;
            private int sceneTime_;
            private long intervalVelocity_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MotionInfoOuterClass.internal_static_MotionInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MotionInfoOuterClass.internal_static_MotionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MotionInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MotionInfo.alwaysUseFieldBuilders) {
                    getParamsFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                if (this.rotBuilder_ == null) {
                    this.rot_ = null;
                } else {
                    this.rot_ = null;
                    this.rotBuilder_ = null;
                }
                if (this.speedBuilder_ == null) {
                    this.speed_ = null;
                } else {
                    this.speed_ = null;
                    this.speedBuilder_ = null;
                }
                this.state_ = 0;
                if (this.paramsBuilder_ == null) {
                    this.params_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.paramsBuilder_.clear();
                }
                if (this.refPosBuilder_ == null) {
                    this.refPos_ = null;
                } else {
                    this.refPos_ = null;
                    this.refPosBuilder_ = null;
                }
                this.refId_ = 0;
                this.sceneTime_ = 0;
                this.intervalVelocity_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MotionInfoOuterClass.internal_static_MotionInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MotionInfo getDefaultInstanceForType() {
                return MotionInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MotionInfo build() {
                MotionInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MotionInfo buildPartial() {
                MotionInfo result = new MotionInfo(this);
                int i = this.bitField0_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                if (this.rotBuilder_ == null) {
                    result.rot_ = this.rot_;
                } else {
                    result.rot_ = this.rotBuilder_.build();
                }
                if (this.speedBuilder_ == null) {
                    result.speed_ = this.speed_;
                } else {
                    result.speed_ = this.speedBuilder_.build();
                }
                result.state_ = this.state_;
                if (this.paramsBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.params_ = Collections.unmodifiableList(this.params_);
                        this.bitField0_ &= -2;
                    }
                    result.params_ = this.params_;
                } else {
                    result.params_ = this.paramsBuilder_.build();
                }
                if (this.refPosBuilder_ == null) {
                    result.refPos_ = this.refPos_;
                } else {
                    result.refPos_ = this.refPosBuilder_.build();
                }
                result.refId_ = this.refId_;
                result.sceneTime_ = this.sceneTime_;
                result.intervalVelocity_ = this.intervalVelocity_;
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
                if (other instanceof MotionInfo) {
                    return mergeFrom((MotionInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MotionInfo other) {
                if (other == MotionInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.hasRot()) {
                    mergeRot(other.getRot());
                }
                if (other.hasSpeed()) {
                    mergeSpeed(other.getSpeed());
                }
                if (other.state_ != 0) {
                    setStateValue(other.getStateValue());
                }
                if (this.paramsBuilder_ == null) {
                    if (!other.params_.isEmpty()) {
                        if (this.params_.isEmpty()) {
                            this.params_ = other.params_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureParamsIsMutable();
                            this.params_.addAll(other.params_);
                        }
                        onChanged();
                    }
                } else if (!other.params_.isEmpty()) {
                    if (this.paramsBuilder_.isEmpty()) {
                        this.paramsBuilder_.dispose();
                        this.paramsBuilder_ = null;
                        this.params_ = other.params_;
                        this.bitField0_ &= -2;
                        this.paramsBuilder_ = MotionInfo.alwaysUseFieldBuilders ? getParamsFieldBuilder() : null;
                    } else {
                        this.paramsBuilder_.addAllMessages(other.params_);
                    }
                }
                if (other.hasRefPos()) {
                    mergeRefPos(other.getRefPos());
                }
                if (other.getRefId() != 0) {
                    setRefId(other.getRefId());
                }
                if (other.getSceneTime() != 0) {
                    setSceneTime(other.getSceneTime());
                }
                if (other.getIntervalVelocity() != 0) {
                    setIntervalVelocity(other.getIntervalVelocity());
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
                MotionInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = MotionInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MotionInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public VectorOuterClass.Vector getPos() {
                if (this.posBuilder_ == null) {
                    return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
                }
                return this.posBuilder_.getMessage();
            }

            public Builder setPos(VectorOuterClass.Vector value) {
                if (this.posBuilder_ != null) {
                    this.posBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.pos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.posBuilder_ == null) {
                    this.pos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.posBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePos(VectorOuterClass.Vector value) {
                if (this.posBuilder_ == null) {
                    if (this.pos_ != null) {
                        this.pos_ = VectorOuterClass.Vector.newBuilder(this.pos_).mergeFrom(value).buildPartial();
                    } else {
                        this.pos_ = value;
                    }
                    onChanged();
                } else {
                    this.posBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPos() {
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                    onChanged();
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getPosBuilder() {
                onChanged();
                return getPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
                if (this.posBuilder_ != null) {
                    return this.posBuilder_.getMessageOrBuilder();
                }
                return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getPosFieldBuilder() {
                if (this.posBuilder_ == null) {
                    this.posBuilder_ = new SingleFieldBuilderV3<>(getPos(), getParentForChildren(), isClean());
                    this.pos_ = null;
                }
                return this.posBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public boolean hasRot() {
                return (this.rotBuilder_ == null && this.rot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public VectorOuterClass.Vector getRot() {
                if (this.rotBuilder_ == null) {
                    return this.rot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rot_;
                }
                return this.rotBuilder_.getMessage();
            }

            public Builder setRot(VectorOuterClass.Vector value) {
                if (this.rotBuilder_ != null) {
                    this.rotBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.rot_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRot(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.rotBuilder_ == null) {
                    this.rot_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rotBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRot(VectorOuterClass.Vector value) {
                if (this.rotBuilder_ == null) {
                    if (this.rot_ != null) {
                        this.rot_ = VectorOuterClass.Vector.newBuilder(this.rot_).mergeFrom(value).buildPartial();
                    } else {
                        this.rot_ = value;
                    }
                    onChanged();
                } else {
                    this.rotBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRot() {
                if (this.rotBuilder_ == null) {
                    this.rot_ = null;
                    onChanged();
                } else {
                    this.rot_ = null;
                    this.rotBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getRotBuilder() {
                onChanged();
                return getRotFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getRotOrBuilder() {
                if (this.rotBuilder_ != null) {
                    return this.rotBuilder_.getMessageOrBuilder();
                }
                return this.rot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rot_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getRotFieldBuilder() {
                if (this.rotBuilder_ == null) {
                    this.rotBuilder_ = new SingleFieldBuilderV3<>(getRot(), getParentForChildren(), isClean());
                    this.rot_ = null;
                }
                return this.rotBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public boolean hasSpeed() {
                return (this.speedBuilder_ == null && this.speed_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public VectorOuterClass.Vector getSpeed() {
                if (this.speedBuilder_ == null) {
                    return this.speed_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.speed_;
                }
                return this.speedBuilder_.getMessage();
            }

            public Builder setSpeed(VectorOuterClass.Vector value) {
                if (this.speedBuilder_ != null) {
                    this.speedBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.speed_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSpeed(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.speedBuilder_ == null) {
                    this.speed_ = builderForValue.build();
                    onChanged();
                } else {
                    this.speedBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSpeed(VectorOuterClass.Vector value) {
                if (this.speedBuilder_ == null) {
                    if (this.speed_ != null) {
                        this.speed_ = VectorOuterClass.Vector.newBuilder(this.speed_).mergeFrom(value).buildPartial();
                    } else {
                        this.speed_ = value;
                    }
                    onChanged();
                } else {
                    this.speedBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSpeed() {
                if (this.speedBuilder_ == null) {
                    this.speed_ = null;
                    onChanged();
                } else {
                    this.speed_ = null;
                    this.speedBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getSpeedBuilder() {
                onChanged();
                return getSpeedFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getSpeedOrBuilder() {
                if (this.speedBuilder_ != null) {
                    return this.speedBuilder_.getMessageOrBuilder();
                }
                return this.speed_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.speed_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getSpeedFieldBuilder() {
                if (this.speedBuilder_ == null) {
                    this.speedBuilder_ = new SingleFieldBuilderV3<>(getSpeed(), getParentForChildren(), isClean());
                    this.speed_ = null;
                }
                return this.speedBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public int getStateValue() {
                return this.state_;
            }

            public Builder setStateValue(int value) {
                this.state_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public MotionStateOuterClass.MotionState getState() {
                MotionStateOuterClass.MotionState result = MotionStateOuterClass.MotionState.valueOf(this.state_);
                return result == null ? MotionStateOuterClass.MotionState.UNRECOGNIZED : result;
            }

            public Builder setState(MotionStateOuterClass.MotionState value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.state_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.state_ = 0;
                onChanged();
                return this;
            }

            private void ensureParamsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.params_ = new ArrayList(this.params_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public List<VectorOuterClass.Vector> getParamsList() {
                if (this.paramsBuilder_ == null) {
                    return Collections.unmodifiableList(this.params_);
                }
                return this.paramsBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public int getParamsCount() {
                if (this.paramsBuilder_ == null) {
                    return this.params_.size();
                }
                return this.paramsBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public VectorOuterClass.Vector getParams(int index) {
                if (this.paramsBuilder_ == null) {
                    return this.params_.get(index);
                }
                return this.paramsBuilder_.getMessage(index);
            }

            public Builder setParams(int index, VectorOuterClass.Vector value) {
                if (this.paramsBuilder_ != null) {
                    this.paramsBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureParamsIsMutable();
                    this.params_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setParams(int index, VectorOuterClass.Vector.Builder builderForValue) {
                if (this.paramsBuilder_ == null) {
                    ensureParamsIsMutable();
                    this.params_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.paramsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addParams(VectorOuterClass.Vector value) {
                if (this.paramsBuilder_ != null) {
                    this.paramsBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureParamsIsMutable();
                    this.params_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addParams(int index, VectorOuterClass.Vector value) {
                if (this.paramsBuilder_ != null) {
                    this.paramsBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureParamsIsMutable();
                    this.params_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addParams(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.paramsBuilder_ == null) {
                    ensureParamsIsMutable();
                    this.params_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.paramsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addParams(int index, VectorOuterClass.Vector.Builder builderForValue) {
                if (this.paramsBuilder_ == null) {
                    ensureParamsIsMutable();
                    this.params_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.paramsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllParams(Iterable<? extends VectorOuterClass.Vector> values) {
                if (this.paramsBuilder_ == null) {
                    ensureParamsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.params_);
                    onChanged();
                } else {
                    this.paramsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearParams() {
                if (this.paramsBuilder_ == null) {
                    this.params_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.paramsBuilder_.clear();
                }
                return this;
            }

            public Builder removeParams(int index) {
                if (this.paramsBuilder_ == null) {
                    ensureParamsIsMutable();
                    this.params_.remove(index);
                    onChanged();
                } else {
                    this.paramsBuilder_.remove(index);
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getParamsBuilder(int index) {
                return getParamsFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getParamsOrBuilder(int index) {
                if (this.paramsBuilder_ == null) {
                    return this.params_.get(index);
                }
                return this.paramsBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public List<? extends VectorOuterClass.VectorOrBuilder> getParamsOrBuilderList() {
                if (this.paramsBuilder_ != null) {
                    return this.paramsBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.params_);
            }

            public VectorOuterClass.Vector.Builder addParamsBuilder() {
                return getParamsFieldBuilder().addBuilder(VectorOuterClass.Vector.getDefaultInstance());
            }

            public VectorOuterClass.Vector.Builder addParamsBuilder(int index) {
                return getParamsFieldBuilder().addBuilder(index, VectorOuterClass.Vector.getDefaultInstance());
            }

            public List<VectorOuterClass.Vector.Builder> getParamsBuilderList() {
                return getParamsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getParamsFieldBuilder() {
                if (this.paramsBuilder_ == null) {
                    this.paramsBuilder_ = new RepeatedFieldBuilderV3<>(this.params_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.params_ = null;
                }
                return this.paramsBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public boolean hasRefPos() {
                return (this.refPosBuilder_ == null && this.refPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public VectorOuterClass.Vector getRefPos() {
                if (this.refPosBuilder_ == null) {
                    return this.refPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.refPos_;
                }
                return this.refPosBuilder_.getMessage();
            }

            public Builder setRefPos(VectorOuterClass.Vector value) {
                if (this.refPosBuilder_ != null) {
                    this.refPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.refPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRefPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.refPosBuilder_ == null) {
                    this.refPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.refPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRefPos(VectorOuterClass.Vector value) {
                if (this.refPosBuilder_ == null) {
                    if (this.refPos_ != null) {
                        this.refPos_ = VectorOuterClass.Vector.newBuilder(this.refPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.refPos_ = value;
                    }
                    onChanged();
                } else {
                    this.refPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRefPos() {
                if (this.refPosBuilder_ == null) {
                    this.refPos_ = null;
                    onChanged();
                } else {
                    this.refPos_ = null;
                    this.refPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getRefPosBuilder() {
                onChanged();
                return getRefPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getRefPosOrBuilder() {
                if (this.refPosBuilder_ != null) {
                    return this.refPosBuilder_.getMessageOrBuilder();
                }
                return this.refPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.refPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getRefPosFieldBuilder() {
                if (this.refPosBuilder_ == null) {
                    this.refPosBuilder_ = new SingleFieldBuilderV3<>(getRefPos(), getParentForChildren(), isClean());
                    this.refPos_ = null;
                }
                return this.refPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public int getRefId() {
                return this.refId_;
            }

            public Builder setRefId(int value) {
                this.refId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRefId() {
                this.refId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public int getSceneTime() {
                return this.sceneTime_;
            }

            public Builder setSceneTime(int value) {
                this.sceneTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneTime() {
                this.sceneTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MotionInfoOuterClass.MotionInfoOrBuilder
            public long getIntervalVelocity() {
                return this.intervalVelocity_;
            }

            public Builder setIntervalVelocity(long value) {
                this.intervalVelocity_ = value;
                onChanged();
                return this;
            }

            public Builder clearIntervalVelocity() {
                this.intervalVelocity_ = 0;
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

        public static MotionInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MotionInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MotionInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MotionInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MotionStateOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
