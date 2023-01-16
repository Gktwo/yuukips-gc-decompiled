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
import emu.grasscutter.net.proto.MathQuaternionOuterClass;
import emu.grasscutter.net.proto.MovingPlatformTypeOuterClass;
import emu.grasscutter.net.proto.RouteOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlatformInfoOuterClass.class */
public final class PlatformInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012PlatformInfo.proto\u001a\u0014MathQuaternion.proto\u001a\u0018MovingPlatformType.proto\u001a\u000bRoute.proto\u001a\fVector.proto\"\u0003\n\fPlatformInfo\u0012\u0010\n\broute_id\u0018\u0001 \u0001(\r\u0012\u0013\n\u000bstart_index\u0018\u0002 \u0001(\u0005\u0012\u0018\n\u0010start_route_time\u0018\u0003 \u0001(\r\u0012\u0018\n\u0010start_scene_time\u0018\u0004 \u0001(\r\u0012\u001a\n\tstart_pos\u0018\u0007 \u0001(\u000b2\u0007.Vector\u0012\u0012\n\nis_started\u0018\b \u0001(\b\u0012\"\n\tstart_rot\u0018\t \u0001(\u000b2\u000f.MathQuaternion\u0012\u0017\n\u000fstop_scene_time\u0018\n \u0001(\r\u0012\u001b\n\npos_offset\u0018\u000b \u0001(\u000b2\u0007.Vector\u0012#\n\nrot_offset\u0018\f \u0001(\u000b2\u000f.MathQuaternion\u00121\n\u0014moving_platform_type\u0018\r \u0001(\u000e2\u0013.MovingPlatformType\u0012\u0011\n\tis_active\u0018\u000e \u0001(\b\u0012\u0015\n\u0005route\u0018\u000f \u0001(\u000b2\u0006.Route\u0012\u0010\n\bpoint_id\u0018\u0010 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MathQuaternionOuterClass.getDescriptor(), MovingPlatformTypeOuterClass.getDescriptor(), RouteOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlatformInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlatformInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlatformInfo_descriptor, new String[]{"RouteId", "StartIndex", "StartRouteTime", "StartSceneTime", "StartPos", "IsStarted", "StartRot", "StopSceneTime", "PosOffset", "RotOffset", "MovingPlatformType", "IsActive", "Route", "PointId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlatformInfoOuterClass$PlatformInfoOrBuilder.class */
    public interface PlatformInfoOrBuilder extends MessageOrBuilder {
        int getRouteId();

        int getStartIndex();

        int getStartRouteTime();

        int getStartSceneTime();

        boolean hasStartPos();

        VectorOuterClass.Vector getStartPos();

        VectorOuterClass.VectorOrBuilder getStartPosOrBuilder();

        boolean getIsStarted();

        boolean hasStartRot();

        MathQuaternionOuterClass.MathQuaternion getStartRot();

        MathQuaternionOuterClass.MathQuaternionOrBuilder getStartRotOrBuilder();

        int getStopSceneTime();

        boolean hasPosOffset();

        VectorOuterClass.Vector getPosOffset();

        VectorOuterClass.VectorOrBuilder getPosOffsetOrBuilder();

        boolean hasRotOffset();

        MathQuaternionOuterClass.MathQuaternion getRotOffset();

        MathQuaternionOuterClass.MathQuaternionOrBuilder getRotOffsetOrBuilder();

        int getMovingPlatformTypeValue();

        MovingPlatformTypeOuterClass.MovingPlatformType getMovingPlatformType();

        boolean getIsActive();

        boolean hasRoute();

        RouteOuterClass.Route getRoute();

        RouteOuterClass.RouteOrBuilder getRouteOrBuilder();

        int getPointId();
    }

    private PlatformInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlatformInfoOuterClass$PlatformInfo.class */
    public static final class PlatformInfo extends GeneratedMessageV3 implements PlatformInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ROUTE_ID_FIELD_NUMBER = 1;
        private int routeId_;
        public static final int START_INDEX_FIELD_NUMBER = 2;
        private int startIndex_;
        public static final int START_ROUTE_TIME_FIELD_NUMBER = 3;
        private int startRouteTime_;
        public static final int START_SCENE_TIME_FIELD_NUMBER = 4;
        private int startSceneTime_;
        public static final int START_POS_FIELD_NUMBER = 7;
        private VectorOuterClass.Vector startPos_;
        public static final int IS_STARTED_FIELD_NUMBER = 8;
        private boolean isStarted_;
        public static final int START_ROT_FIELD_NUMBER = 9;
        private MathQuaternionOuterClass.MathQuaternion startRot_;
        public static final int STOP_SCENE_TIME_FIELD_NUMBER = 10;
        private int stopSceneTime_;
        public static final int POS_OFFSET_FIELD_NUMBER = 11;
        private VectorOuterClass.Vector posOffset_;
        public static final int ROT_OFFSET_FIELD_NUMBER = 12;
        private MathQuaternionOuterClass.MathQuaternion rotOffset_;
        public static final int MOVING_PLATFORM_TYPE_FIELD_NUMBER = 13;
        private int movingPlatformType_;
        public static final int IS_ACTIVE_FIELD_NUMBER = 14;
        private boolean isActive_;
        public static final int ROUTE_FIELD_NUMBER = 15;
        private RouteOuterClass.Route route_;
        public static final int POINT_ID_FIELD_NUMBER = 16;
        private int pointId_;
        private byte memoizedIsInitialized;
        private static final PlatformInfo DEFAULT_INSTANCE = new PlatformInfo();
        private static final Parser<PlatformInfo> PARSER = new AbstractParser<PlatformInfo>() { // from class: emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfo.1
            @Override // com.google.protobuf.Parser
            public PlatformInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlatformInfo(input, extensionRegistry);
            }
        };

        private PlatformInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlatformInfo() {
            this.memoizedIsInitialized = -1;
            this.movingPlatformType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlatformInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlatformInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 8:
                                    this.routeId_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.startIndex_ = input.readInt32();
                                    break;
                                case 24:
                                    this.startRouteTime_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.startSceneTime_ = input.readUInt32();
                                    break;
                                case 58:
                                    VectorOuterClass.Vector.Builder subBuilder = this.startPos_ != null ? this.startPos_.toBuilder() : null;
                                    this.startPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.startPos_);
                                        this.startPos_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 64:
                                    this.isStarted_ = input.readBool();
                                    break;
                                case 74:
                                    MathQuaternionOuterClass.MathQuaternion.Builder subBuilder2 = this.startRot_ != null ? this.startRot_.toBuilder() : null;
                                    this.startRot_ = (MathQuaternionOuterClass.MathQuaternion) input.readMessage(MathQuaternionOuterClass.MathQuaternion.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.startRot_);
                                        this.startRot_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 80:
                                    this.stopSceneTime_ = input.readUInt32();
                                    break;
                                case 90:
                                    VectorOuterClass.Vector.Builder subBuilder3 = this.posOffset_ != null ? this.posOffset_.toBuilder() : null;
                                    this.posOffset_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder3 == null) {
                                        break;
                                    } else {
                                        subBuilder3.mergeFrom(this.posOffset_);
                                        this.posOffset_ = subBuilder3.buildPartial();
                                        break;
                                    }
                                case 98:
                                    MathQuaternionOuterClass.MathQuaternion.Builder subBuilder4 = this.rotOffset_ != null ? this.rotOffset_.toBuilder() : null;
                                    this.rotOffset_ = (MathQuaternionOuterClass.MathQuaternion) input.readMessage(MathQuaternionOuterClass.MathQuaternion.parser(), extensionRegistry);
                                    if (subBuilder4 == null) {
                                        break;
                                    } else {
                                        subBuilder4.mergeFrom(this.rotOffset_);
                                        this.rotOffset_ = subBuilder4.buildPartial();
                                        break;
                                    }
                                case 104:
                                    this.movingPlatformType_ = input.readEnum();
                                    break;
                                case 112:
                                    this.isActive_ = input.readBool();
                                    break;
                                case 122:
                                    RouteOuterClass.Route.Builder subBuilder5 = this.route_ != null ? this.route_.toBuilder() : null;
                                    this.route_ = (RouteOuterClass.Route) input.readMessage(RouteOuterClass.Route.parser(), extensionRegistry);
                                    if (subBuilder5 == null) {
                                        break;
                                    } else {
                                        subBuilder5.mergeFrom(this.route_);
                                        this.route_ = subBuilder5.buildPartial();
                                        break;
                                    }
                                case 128:
                                    this.pointId_ = input.readUInt32();
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
                        }
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
            return PlatformInfoOuterClass.internal_static_PlatformInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlatformInfoOuterClass.internal_static_PlatformInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public int getRouteId() {
            return this.routeId_;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public int getStartIndex() {
            return this.startIndex_;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public int getStartRouteTime() {
            return this.startRouteTime_;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public int getStartSceneTime() {
            return this.startSceneTime_;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public boolean hasStartPos() {
            return this.startPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public VectorOuterClass.Vector getStartPos() {
            return this.startPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.startPos_;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getStartPosOrBuilder() {
            return getStartPos();
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public boolean getIsStarted() {
            return this.isStarted_;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public boolean hasStartRot() {
            return this.startRot_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public MathQuaternionOuterClass.MathQuaternion getStartRot() {
            return this.startRot_ == null ? MathQuaternionOuterClass.MathQuaternion.getDefaultInstance() : this.startRot_;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public MathQuaternionOuterClass.MathQuaternionOrBuilder getStartRotOrBuilder() {
            return getStartRot();
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public int getStopSceneTime() {
            return this.stopSceneTime_;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public boolean hasPosOffset() {
            return this.posOffset_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public VectorOuterClass.Vector getPosOffset() {
            return this.posOffset_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.posOffset_;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOffsetOrBuilder() {
            return getPosOffset();
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public boolean hasRotOffset() {
            return this.rotOffset_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public MathQuaternionOuterClass.MathQuaternion getRotOffset() {
            return this.rotOffset_ == null ? MathQuaternionOuterClass.MathQuaternion.getDefaultInstance() : this.rotOffset_;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public MathQuaternionOuterClass.MathQuaternionOrBuilder getRotOffsetOrBuilder() {
            return getRotOffset();
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public int getMovingPlatformTypeValue() {
            return this.movingPlatformType_;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public MovingPlatformTypeOuterClass.MovingPlatformType getMovingPlatformType() {
            MovingPlatformTypeOuterClass.MovingPlatformType result = MovingPlatformTypeOuterClass.MovingPlatformType.valueOf(this.movingPlatformType_);
            return result == null ? MovingPlatformTypeOuterClass.MovingPlatformType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public boolean getIsActive() {
            return this.isActive_;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public boolean hasRoute() {
            return this.route_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public RouteOuterClass.Route getRoute() {
            return this.route_ == null ? RouteOuterClass.Route.getDefaultInstance() : this.route_;
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public RouteOuterClass.RouteOrBuilder getRouteOrBuilder() {
            return getRoute();
        }

        @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
        public int getPointId() {
            return this.pointId_;
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
            if (this.routeId_ != 0) {
                output.writeUInt32(1, this.routeId_);
            }
            if (this.startIndex_ != 0) {
                output.writeInt32(2, this.startIndex_);
            }
            if (this.startRouteTime_ != 0) {
                output.writeUInt32(3, this.startRouteTime_);
            }
            if (this.startSceneTime_ != 0) {
                output.writeUInt32(4, this.startSceneTime_);
            }
            if (this.startPos_ != null) {
                output.writeMessage(7, getStartPos());
            }
            if (this.isStarted_) {
                output.writeBool(8, this.isStarted_);
            }
            if (this.startRot_ != null) {
                output.writeMessage(9, getStartRot());
            }
            if (this.stopSceneTime_ != 0) {
                output.writeUInt32(10, this.stopSceneTime_);
            }
            if (this.posOffset_ != null) {
                output.writeMessage(11, getPosOffset());
            }
            if (this.rotOffset_ != null) {
                output.writeMessage(12, getRotOffset());
            }
            if (this.movingPlatformType_ != MovingPlatformTypeOuterClass.MovingPlatformType.MOVING_PLATFORM_TYPE_NONE.getNumber()) {
                output.writeEnum(13, this.movingPlatformType_);
            }
            if (this.isActive_) {
                output.writeBool(14, this.isActive_);
            }
            if (this.route_ != null) {
                output.writeMessage(15, getRoute());
            }
            if (this.pointId_ != 0) {
                output.writeUInt32(16, this.pointId_);
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
            if (this.routeId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.routeId_);
            }
            if (this.startIndex_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(2, this.startIndex_);
            }
            if (this.startRouteTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.startRouteTime_);
            }
            if (this.startSceneTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.startSceneTime_);
            }
            if (this.startPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(7, getStartPos());
            }
            if (this.isStarted_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isStarted_);
            }
            if (this.startRot_ != null) {
                size2 += CodedOutputStream.computeMessageSize(9, getStartRot());
            }
            if (this.stopSceneTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.stopSceneTime_);
            }
            if (this.posOffset_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getPosOffset());
            }
            if (this.rotOffset_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getRotOffset());
            }
            if (this.movingPlatformType_ != MovingPlatformTypeOuterClass.MovingPlatformType.MOVING_PLATFORM_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(13, this.movingPlatformType_);
            }
            if (this.isActive_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isActive_);
            }
            if (this.route_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getRoute());
            }
            if (this.pointId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(16, this.pointId_);
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
            if (!(obj instanceof PlatformInfo)) {
                return equals(obj);
            }
            PlatformInfo other = (PlatformInfo) obj;
            if (getRouteId() != other.getRouteId() || getStartIndex() != other.getStartIndex() || getStartRouteTime() != other.getStartRouteTime() || getStartSceneTime() != other.getStartSceneTime() || hasStartPos() != other.hasStartPos()) {
                return false;
            }
            if ((hasStartPos() && !getStartPos().equals(other.getStartPos())) || getIsStarted() != other.getIsStarted() || hasStartRot() != other.hasStartRot()) {
                return false;
            }
            if ((hasStartRot() && !getStartRot().equals(other.getStartRot())) || getStopSceneTime() != other.getStopSceneTime() || hasPosOffset() != other.hasPosOffset()) {
                return false;
            }
            if ((hasPosOffset() && !getPosOffset().equals(other.getPosOffset())) || hasRotOffset() != other.hasRotOffset()) {
                return false;
            }
            if ((!hasRotOffset() || getRotOffset().equals(other.getRotOffset())) && this.movingPlatformType_ == other.movingPlatformType_ && getIsActive() == other.getIsActive() && hasRoute() == other.hasRoute()) {
                return (!hasRoute() || getRoute().equals(other.getRoute())) && getPointId() == other.getPointId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getRouteId())) + 2)) + getStartIndex())) + 3)) + getStartRouteTime())) + 4)) + getStartSceneTime();
            if (hasStartPos()) {
                hash = (53 * ((37 * hash) + 7)) + getStartPos().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 8)) + Internal.hashBoolean(getIsStarted());
            if (hasStartRot()) {
                hash2 = (53 * ((37 * hash2) + 9)) + getStartRot().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 10)) + getStopSceneTime();
            if (hasPosOffset()) {
                hash3 = (53 * ((37 * hash3) + 11)) + getPosOffset().hashCode();
            }
            if (hasRotOffset()) {
                hash3 = (53 * ((37 * hash3) + 12)) + getRotOffset().hashCode();
            }
            int hash4 = (53 * ((37 * ((53 * ((37 * hash3) + 13)) + this.movingPlatformType_)) + 14)) + Internal.hashBoolean(getIsActive());
            if (hasRoute()) {
                hash4 = (53 * ((37 * hash4) + 15)) + getRoute().hashCode();
            }
            int hash5 = (29 * ((53 * ((37 * hash4) + 16)) + getPointId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash5;
            return hash5;
        }

        public static PlatformInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlatformInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlatformInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlatformInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlatformInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlatformInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlatformInfo parseFrom(InputStream input) throws IOException {
            return (PlatformInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlatformInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlatformInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlatformInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (PlatformInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlatformInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlatformInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlatformInfo parseFrom(CodedInputStream input) throws IOException {
            return (PlatformInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlatformInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlatformInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlatformInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlatformInfoOuterClass$PlatformInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlatformInfoOrBuilder {
            private int routeId_;
            private int startIndex_;
            private int startRouteTime_;
            private int startSceneTime_;
            private VectorOuterClass.Vector startPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> startPosBuilder_;
            private boolean isStarted_;
            private MathQuaternionOuterClass.MathQuaternion startRot_;
            private SingleFieldBuilderV3<MathQuaternionOuterClass.MathQuaternion, MathQuaternionOuterClass.MathQuaternion.Builder, MathQuaternionOuterClass.MathQuaternionOrBuilder> startRotBuilder_;
            private int stopSceneTime_;
            private VectorOuterClass.Vector posOffset_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posOffsetBuilder_;
            private MathQuaternionOuterClass.MathQuaternion rotOffset_;
            private SingleFieldBuilderV3<MathQuaternionOuterClass.MathQuaternion, MathQuaternionOuterClass.MathQuaternion.Builder, MathQuaternionOuterClass.MathQuaternionOrBuilder> rotOffsetBuilder_;
            private int movingPlatformType_ = 0;
            private boolean isActive_;
            private RouteOuterClass.Route route_;
            private SingleFieldBuilderV3<RouteOuterClass.Route, RouteOuterClass.Route.Builder, RouteOuterClass.RouteOrBuilder> routeBuilder_;
            private int pointId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlatformInfoOuterClass.internal_static_PlatformInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlatformInfoOuterClass.internal_static_PlatformInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlatformInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.routeId_ = 0;
                this.startIndex_ = 0;
                this.startRouteTime_ = 0;
                this.startSceneTime_ = 0;
                if (this.startPosBuilder_ == null) {
                    this.startPos_ = null;
                } else {
                    this.startPos_ = null;
                    this.startPosBuilder_ = null;
                }
                this.isStarted_ = false;
                if (this.startRotBuilder_ == null) {
                    this.startRot_ = null;
                } else {
                    this.startRot_ = null;
                    this.startRotBuilder_ = null;
                }
                this.stopSceneTime_ = 0;
                if (this.posOffsetBuilder_ == null) {
                    this.posOffset_ = null;
                } else {
                    this.posOffset_ = null;
                    this.posOffsetBuilder_ = null;
                }
                if (this.rotOffsetBuilder_ == null) {
                    this.rotOffset_ = null;
                } else {
                    this.rotOffset_ = null;
                    this.rotOffsetBuilder_ = null;
                }
                this.movingPlatformType_ = 0;
                this.isActive_ = false;
                if (this.routeBuilder_ == null) {
                    this.route_ = null;
                } else {
                    this.route_ = null;
                    this.routeBuilder_ = null;
                }
                this.pointId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlatformInfoOuterClass.internal_static_PlatformInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlatformInfo getDefaultInstanceForType() {
                return PlatformInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlatformInfo build() {
                PlatformInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlatformInfo buildPartial() {
                PlatformInfo result = new PlatformInfo(this);
                result.routeId_ = this.routeId_;
                result.startIndex_ = this.startIndex_;
                result.startRouteTime_ = this.startRouteTime_;
                result.startSceneTime_ = this.startSceneTime_;
                if (this.startPosBuilder_ == null) {
                    result.startPos_ = this.startPos_;
                } else {
                    result.startPos_ = this.startPosBuilder_.build();
                }
                result.isStarted_ = this.isStarted_;
                if (this.startRotBuilder_ == null) {
                    result.startRot_ = this.startRot_;
                } else {
                    result.startRot_ = this.startRotBuilder_.build();
                }
                result.stopSceneTime_ = this.stopSceneTime_;
                if (this.posOffsetBuilder_ == null) {
                    result.posOffset_ = this.posOffset_;
                } else {
                    result.posOffset_ = this.posOffsetBuilder_.build();
                }
                if (this.rotOffsetBuilder_ == null) {
                    result.rotOffset_ = this.rotOffset_;
                } else {
                    result.rotOffset_ = this.rotOffsetBuilder_.build();
                }
                result.movingPlatformType_ = this.movingPlatformType_;
                result.isActive_ = this.isActive_;
                if (this.routeBuilder_ == null) {
                    result.route_ = this.route_;
                } else {
                    result.route_ = this.routeBuilder_.build();
                }
                result.pointId_ = this.pointId_;
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
                if (other instanceof PlatformInfo) {
                    return mergeFrom((PlatformInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlatformInfo other) {
                if (other == PlatformInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getRouteId() != 0) {
                    setRouteId(other.getRouteId());
                }
                if (other.getStartIndex() != 0) {
                    setStartIndex(other.getStartIndex());
                }
                if (other.getStartRouteTime() != 0) {
                    setStartRouteTime(other.getStartRouteTime());
                }
                if (other.getStartSceneTime() != 0) {
                    setStartSceneTime(other.getStartSceneTime());
                }
                if (other.hasStartPos()) {
                    mergeStartPos(other.getStartPos());
                }
                if (other.getIsStarted()) {
                    setIsStarted(other.getIsStarted());
                }
                if (other.hasStartRot()) {
                    mergeStartRot(other.getStartRot());
                }
                if (other.getStopSceneTime() != 0) {
                    setStopSceneTime(other.getStopSceneTime());
                }
                if (other.hasPosOffset()) {
                    mergePosOffset(other.getPosOffset());
                }
                if (other.hasRotOffset()) {
                    mergeRotOffset(other.getRotOffset());
                }
                if (other.movingPlatformType_ != 0) {
                    setMovingPlatformTypeValue(other.getMovingPlatformTypeValue());
                }
                if (other.getIsActive()) {
                    setIsActive(other.getIsActive());
                }
                if (other.hasRoute()) {
                    mergeRoute(other.getRoute());
                }
                if (other.getPointId() != 0) {
                    setPointId(other.getPointId());
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
                PlatformInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlatformInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlatformInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public int getRouteId() {
                return this.routeId_;
            }

            public Builder setRouteId(int value) {
                this.routeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRouteId() {
                this.routeId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public int getStartIndex() {
                return this.startIndex_;
            }

            public Builder setStartIndex(int value) {
                this.startIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartIndex() {
                this.startIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public int getStartRouteTime() {
                return this.startRouteTime_;
            }

            public Builder setStartRouteTime(int value) {
                this.startRouteTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartRouteTime() {
                this.startRouteTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public int getStartSceneTime() {
                return this.startSceneTime_;
            }

            public Builder setStartSceneTime(int value) {
                this.startSceneTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartSceneTime() {
                this.startSceneTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public boolean hasStartPos() {
                return (this.startPosBuilder_ == null && this.startPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public VectorOuterClass.Vector getStartPos() {
                if (this.startPosBuilder_ == null) {
                    return this.startPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.startPos_;
                }
                return this.startPosBuilder_.getMessage();
            }

            public Builder setStartPos(VectorOuterClass.Vector value) {
                if (this.startPosBuilder_ != null) {
                    this.startPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.startPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setStartPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.startPosBuilder_ == null) {
                    this.startPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.startPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeStartPos(VectorOuterClass.Vector value) {
                if (this.startPosBuilder_ == null) {
                    if (this.startPos_ != null) {
                        this.startPos_ = VectorOuterClass.Vector.newBuilder(this.startPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.startPos_ = value;
                    }
                    onChanged();
                } else {
                    this.startPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearStartPos() {
                if (this.startPosBuilder_ == null) {
                    this.startPos_ = null;
                    onChanged();
                } else {
                    this.startPos_ = null;
                    this.startPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getStartPosBuilder() {
                onChanged();
                return getStartPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getStartPosOrBuilder() {
                if (this.startPosBuilder_ != null) {
                    return this.startPosBuilder_.getMessageOrBuilder();
                }
                return this.startPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.startPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getStartPosFieldBuilder() {
                if (this.startPosBuilder_ == null) {
                    this.startPosBuilder_ = new SingleFieldBuilderV3<>(getStartPos(), getParentForChildren(), isClean());
                    this.startPos_ = null;
                }
                return this.startPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public boolean getIsStarted() {
                return this.isStarted_;
            }

            public Builder setIsStarted(boolean value) {
                this.isStarted_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsStarted() {
                this.isStarted_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public boolean hasStartRot() {
                return (this.startRotBuilder_ == null && this.startRot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public MathQuaternionOuterClass.MathQuaternion getStartRot() {
                if (this.startRotBuilder_ == null) {
                    return this.startRot_ == null ? MathQuaternionOuterClass.MathQuaternion.getDefaultInstance() : this.startRot_;
                }
                return this.startRotBuilder_.getMessage();
            }

            public Builder setStartRot(MathQuaternionOuterClass.MathQuaternion value) {
                if (this.startRotBuilder_ != null) {
                    this.startRotBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.startRot_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setStartRot(MathQuaternionOuterClass.MathQuaternion.Builder builderForValue) {
                if (this.startRotBuilder_ == null) {
                    this.startRot_ = builderForValue.build();
                    onChanged();
                } else {
                    this.startRotBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeStartRot(MathQuaternionOuterClass.MathQuaternion value) {
                if (this.startRotBuilder_ == null) {
                    if (this.startRot_ != null) {
                        this.startRot_ = MathQuaternionOuterClass.MathQuaternion.newBuilder(this.startRot_).mergeFrom(value).buildPartial();
                    } else {
                        this.startRot_ = value;
                    }
                    onChanged();
                } else {
                    this.startRotBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearStartRot() {
                if (this.startRotBuilder_ == null) {
                    this.startRot_ = null;
                    onChanged();
                } else {
                    this.startRot_ = null;
                    this.startRotBuilder_ = null;
                }
                return this;
            }

            public MathQuaternionOuterClass.MathQuaternion.Builder getStartRotBuilder() {
                onChanged();
                return getStartRotFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public MathQuaternionOuterClass.MathQuaternionOrBuilder getStartRotOrBuilder() {
                if (this.startRotBuilder_ != null) {
                    return this.startRotBuilder_.getMessageOrBuilder();
                }
                return this.startRot_ == null ? MathQuaternionOuterClass.MathQuaternion.getDefaultInstance() : this.startRot_;
            }

            private SingleFieldBuilderV3<MathQuaternionOuterClass.MathQuaternion, MathQuaternionOuterClass.MathQuaternion.Builder, MathQuaternionOuterClass.MathQuaternionOrBuilder> getStartRotFieldBuilder() {
                if (this.startRotBuilder_ == null) {
                    this.startRotBuilder_ = new SingleFieldBuilderV3<>(getStartRot(), getParentForChildren(), isClean());
                    this.startRot_ = null;
                }
                return this.startRotBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public int getStopSceneTime() {
                return this.stopSceneTime_;
            }

            public Builder setStopSceneTime(int value) {
                this.stopSceneTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStopSceneTime() {
                this.stopSceneTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public boolean hasPosOffset() {
                return (this.posOffsetBuilder_ == null && this.posOffset_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public VectorOuterClass.Vector getPosOffset() {
                if (this.posOffsetBuilder_ == null) {
                    return this.posOffset_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.posOffset_;
                }
                return this.posOffsetBuilder_.getMessage();
            }

            public Builder setPosOffset(VectorOuterClass.Vector value) {
                if (this.posOffsetBuilder_ != null) {
                    this.posOffsetBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.posOffset_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPosOffset(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.posOffsetBuilder_ == null) {
                    this.posOffset_ = builderForValue.build();
                    onChanged();
                } else {
                    this.posOffsetBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePosOffset(VectorOuterClass.Vector value) {
                if (this.posOffsetBuilder_ == null) {
                    if (this.posOffset_ != null) {
                        this.posOffset_ = VectorOuterClass.Vector.newBuilder(this.posOffset_).mergeFrom(value).buildPartial();
                    } else {
                        this.posOffset_ = value;
                    }
                    onChanged();
                } else {
                    this.posOffsetBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPosOffset() {
                if (this.posOffsetBuilder_ == null) {
                    this.posOffset_ = null;
                    onChanged();
                } else {
                    this.posOffset_ = null;
                    this.posOffsetBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getPosOffsetBuilder() {
                onChanged();
                return getPosOffsetFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getPosOffsetOrBuilder() {
                if (this.posOffsetBuilder_ != null) {
                    return this.posOffsetBuilder_.getMessageOrBuilder();
                }
                return this.posOffset_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.posOffset_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getPosOffsetFieldBuilder() {
                if (this.posOffsetBuilder_ == null) {
                    this.posOffsetBuilder_ = new SingleFieldBuilderV3<>(getPosOffset(), getParentForChildren(), isClean());
                    this.posOffset_ = null;
                }
                return this.posOffsetBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public boolean hasRotOffset() {
                return (this.rotOffsetBuilder_ == null && this.rotOffset_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public MathQuaternionOuterClass.MathQuaternion getRotOffset() {
                if (this.rotOffsetBuilder_ == null) {
                    return this.rotOffset_ == null ? MathQuaternionOuterClass.MathQuaternion.getDefaultInstance() : this.rotOffset_;
                }
                return this.rotOffsetBuilder_.getMessage();
            }

            public Builder setRotOffset(MathQuaternionOuterClass.MathQuaternion value) {
                if (this.rotOffsetBuilder_ != null) {
                    this.rotOffsetBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.rotOffset_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRotOffset(MathQuaternionOuterClass.MathQuaternion.Builder builderForValue) {
                if (this.rotOffsetBuilder_ == null) {
                    this.rotOffset_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rotOffsetBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRotOffset(MathQuaternionOuterClass.MathQuaternion value) {
                if (this.rotOffsetBuilder_ == null) {
                    if (this.rotOffset_ != null) {
                        this.rotOffset_ = MathQuaternionOuterClass.MathQuaternion.newBuilder(this.rotOffset_).mergeFrom(value).buildPartial();
                    } else {
                        this.rotOffset_ = value;
                    }
                    onChanged();
                } else {
                    this.rotOffsetBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRotOffset() {
                if (this.rotOffsetBuilder_ == null) {
                    this.rotOffset_ = null;
                    onChanged();
                } else {
                    this.rotOffset_ = null;
                    this.rotOffsetBuilder_ = null;
                }
                return this;
            }

            public MathQuaternionOuterClass.MathQuaternion.Builder getRotOffsetBuilder() {
                onChanged();
                return getRotOffsetFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public MathQuaternionOuterClass.MathQuaternionOrBuilder getRotOffsetOrBuilder() {
                if (this.rotOffsetBuilder_ != null) {
                    return this.rotOffsetBuilder_.getMessageOrBuilder();
                }
                return this.rotOffset_ == null ? MathQuaternionOuterClass.MathQuaternion.getDefaultInstance() : this.rotOffset_;
            }

            private SingleFieldBuilderV3<MathQuaternionOuterClass.MathQuaternion, MathQuaternionOuterClass.MathQuaternion.Builder, MathQuaternionOuterClass.MathQuaternionOrBuilder> getRotOffsetFieldBuilder() {
                if (this.rotOffsetBuilder_ == null) {
                    this.rotOffsetBuilder_ = new SingleFieldBuilderV3<>(getRotOffset(), getParentForChildren(), isClean());
                    this.rotOffset_ = null;
                }
                return this.rotOffsetBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public int getMovingPlatformTypeValue() {
                return this.movingPlatformType_;
            }

            public Builder setMovingPlatformTypeValue(int value) {
                this.movingPlatformType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public MovingPlatformTypeOuterClass.MovingPlatformType getMovingPlatformType() {
                MovingPlatformTypeOuterClass.MovingPlatformType result = MovingPlatformTypeOuterClass.MovingPlatformType.valueOf(this.movingPlatformType_);
                return result == null ? MovingPlatformTypeOuterClass.MovingPlatformType.UNRECOGNIZED : result;
            }

            public Builder setMovingPlatformType(MovingPlatformTypeOuterClass.MovingPlatformType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.movingPlatformType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearMovingPlatformType() {
                this.movingPlatformType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public boolean getIsActive() {
                return this.isActive_;
            }

            public Builder setIsActive(boolean value) {
                this.isActive_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsActive() {
                this.isActive_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public boolean hasRoute() {
                return (this.routeBuilder_ == null && this.route_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public RouteOuterClass.Route getRoute() {
                if (this.routeBuilder_ == null) {
                    return this.route_ == null ? RouteOuterClass.Route.getDefaultInstance() : this.route_;
                }
                return this.routeBuilder_.getMessage();
            }

            public Builder setRoute(RouteOuterClass.Route value) {
                if (this.routeBuilder_ != null) {
                    this.routeBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.route_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRoute(RouteOuterClass.Route.Builder builderForValue) {
                if (this.routeBuilder_ == null) {
                    this.route_ = builderForValue.build();
                    onChanged();
                } else {
                    this.routeBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRoute(RouteOuterClass.Route value) {
                if (this.routeBuilder_ == null) {
                    if (this.route_ != null) {
                        this.route_ = RouteOuterClass.Route.newBuilder(this.route_).mergeFrom(value).buildPartial();
                    } else {
                        this.route_ = value;
                    }
                    onChanged();
                } else {
                    this.routeBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRoute() {
                if (this.routeBuilder_ == null) {
                    this.route_ = null;
                    onChanged();
                } else {
                    this.route_ = null;
                    this.routeBuilder_ = null;
                }
                return this;
            }

            public RouteOuterClass.Route.Builder getRouteBuilder() {
                onChanged();
                return getRouteFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public RouteOuterClass.RouteOrBuilder getRouteOrBuilder() {
                if (this.routeBuilder_ != null) {
                    return this.routeBuilder_.getMessageOrBuilder();
                }
                return this.route_ == null ? RouteOuterClass.Route.getDefaultInstance() : this.route_;
            }

            private SingleFieldBuilderV3<RouteOuterClass.Route, RouteOuterClass.Route.Builder, RouteOuterClass.RouteOrBuilder> getRouteFieldBuilder() {
                if (this.routeBuilder_ == null) {
                    this.routeBuilder_ = new SingleFieldBuilderV3<>(getRoute(), getParentForChildren(), isClean());
                    this.route_ = null;
                }
                return this.routeBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlatformInfoOuterClass.PlatformInfoOrBuilder
            public int getPointId() {
                return this.pointId_;
            }

            public Builder setPointId(int value) {
                this.pointId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPointId() {
                this.pointId_ = 0;
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

        public static PlatformInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlatformInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlatformInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlatformInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MathQuaternionOuterClass.getDescriptor();
        MovingPlatformTypeOuterClass.getDescriptor();
        RouteOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
