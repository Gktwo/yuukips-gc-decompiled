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
import emu.grasscutter.net.proto.MathQuaternionOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoutePointOuterClass.class */
public final class RoutePointOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010RoutePoint.proto\u001a\u0014MathQuaternion.proto\u001a\fVector.proto\"\u0002\n\nRoutePoint\u0012\u0019\n\bposition\u0018\u0001 \u0001(\u000b2\u0007.Vector\u0012\u0014\n\farrive_range\u0018\u0002 \u0001(\u0002\u0012\u0017\n\u000fhas_reach_event\u0018\u0003 \u0001(\b\u0012\u0012\n\bvelocity\u0018\u000b \u0001(\u0002H��\u0012\u000e\n\u0004time\u0018\f \u0001(\u0002H��\u0012\u001b\n\brotation\u0018\u0015 \u0001(\u000b2\u0007.VectorH\u0001\u0012)\n\u000erotation_speed\u0018\u0016 \u0001(\u000b2\u000f.MathQuaternionH\u0001\u0012%\n\naxis_speed\u0018\u0017 \u0001(\u000b2\u000f.MathQuaternionH\u0001B\r\n\u000bmove_paramsB\u000f\n\rrotate_paramsB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MathQuaternionOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_RoutePoint_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RoutePoint_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RoutePoint_descriptor, new String[]{"Position", "ArriveRange", "HasReachEvent", "Velocity", "Time", "Rotation", "RotationSpeed", "AxisSpeed", "MoveParams", "RotateParams"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoutePointOuterClass$RoutePointOrBuilder.class */
    public interface RoutePointOrBuilder extends MessageOrBuilder {
        boolean hasPosition();

        VectorOuterClass.Vector getPosition();

        VectorOuterClass.VectorOrBuilder getPositionOrBuilder();

        float getArriveRange();

        boolean getHasReachEvent();

        boolean hasVelocity();

        float getVelocity();

        boolean hasTime();

        float getTime();

        boolean hasRotation();

        VectorOuterClass.Vector getRotation();

        VectorOuterClass.VectorOrBuilder getRotationOrBuilder();

        boolean hasRotationSpeed();

        MathQuaternionOuterClass.MathQuaternion getRotationSpeed();

        MathQuaternionOuterClass.MathQuaternionOrBuilder getRotationSpeedOrBuilder();

        boolean hasAxisSpeed();

        MathQuaternionOuterClass.MathQuaternion getAxisSpeed();

        MathQuaternionOuterClass.MathQuaternionOrBuilder getAxisSpeedOrBuilder();

        RoutePoint.MoveParamsCase getMoveParamsCase();

        RoutePoint.RotateParamsCase getRotateParamsCase();
    }

    private RoutePointOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoutePointOuterClass$RoutePoint.class */
    public static final class RoutePoint extends GeneratedMessageV3 implements RoutePointOrBuilder {
        private static final long serialVersionUID = 0;
        private int moveParamsCase_;
        private Object moveParams_;
        private int rotateParamsCase_;
        private Object rotateParams_;
        public static final int POSITION_FIELD_NUMBER = 1;
        private VectorOuterClass.Vector position_;
        public static final int ARRIVE_RANGE_FIELD_NUMBER = 2;
        private float arriveRange_;
        public static final int HAS_REACH_EVENT_FIELD_NUMBER = 3;
        private boolean hasReachEvent_;
        public static final int VELOCITY_FIELD_NUMBER = 11;
        public static final int TIME_FIELD_NUMBER = 12;
        public static final int ROTATION_FIELD_NUMBER = 21;
        public static final int ROTATION_SPEED_FIELD_NUMBER = 22;
        public static final int AXIS_SPEED_FIELD_NUMBER = 23;
        private byte memoizedIsInitialized;
        private static final RoutePoint DEFAULT_INSTANCE = new RoutePoint();
        private static final Parser<RoutePoint> PARSER = new AbstractParser<RoutePoint>() { // from class: emu.grasscutter.net.proto.RoutePointOuterClass.RoutePoint.1
            @Override // com.google.protobuf.Parser
            public RoutePoint parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RoutePoint(input, extensionRegistry);
            }
        };

        private RoutePoint(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.moveParamsCase_ = 0;
            this.rotateParamsCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private RoutePoint() {
            this.moveParamsCase_ = 0;
            this.rotateParamsCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RoutePoint();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RoutePoint(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                VectorOuterClass.Vector.Builder subBuilder = this.position_ != null ? this.position_.toBuilder() : null;
                                this.position_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.position_);
                                    this.position_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 21:
                                this.arriveRange_ = input.readFloat();
                                break;
                            case 24:
                                this.hasReachEvent_ = input.readBool();
                                break;
                            case 93:
                                this.moveParamsCase_ = 11;
                                this.moveParams_ = Float.valueOf(input.readFloat());
                                break;
                            case 101:
                                this.moveParamsCase_ = 12;
                                this.moveParams_ = Float.valueOf(input.readFloat());
                                break;
                            case 170:
                                VectorOuterClass.Vector.Builder subBuilder2 = this.rotateParamsCase_ == 21 ? ((VectorOuterClass.Vector) this.rotateParams_).toBuilder() : null;
                                this.rotateParams_ = input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((VectorOuterClass.Vector) this.rotateParams_);
                                    this.rotateParams_ = subBuilder2.buildPartial();
                                }
                                this.rotateParamsCase_ = 21;
                                break;
                            case 178:
                                MathQuaternionOuterClass.MathQuaternion.Builder subBuilder3 = this.rotateParamsCase_ == 22 ? ((MathQuaternionOuterClass.MathQuaternion) this.rotateParams_).toBuilder() : null;
                                this.rotateParams_ = input.readMessage(MathQuaternionOuterClass.MathQuaternion.parser(), extensionRegistry);
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((MathQuaternionOuterClass.MathQuaternion) this.rotateParams_);
                                    this.rotateParams_ = subBuilder3.buildPartial();
                                }
                                this.rotateParamsCase_ = 22;
                                break;
                            case 186:
                                MathQuaternionOuterClass.MathQuaternion.Builder subBuilder4 = this.rotateParamsCase_ == 23 ? ((MathQuaternionOuterClass.MathQuaternion) this.rotateParams_).toBuilder() : null;
                                this.rotateParams_ = input.readMessage(MathQuaternionOuterClass.MathQuaternion.parser(), extensionRegistry);
                                if (subBuilder4 != null) {
                                    subBuilder4.mergeFrom((MathQuaternionOuterClass.MathQuaternion) this.rotateParams_);
                                    this.rotateParams_ = subBuilder4.buildPartial();
                                }
                                this.rotateParamsCase_ = 23;
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
            return RoutePointOuterClass.internal_static_RoutePoint_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RoutePointOuterClass.internal_static_RoutePoint_fieldAccessorTable.ensureFieldAccessorsInitialized(RoutePoint.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoutePointOuterClass$RoutePoint$MoveParamsCase.class */
        public enum MoveParamsCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            VELOCITY(11),
            TIME(12),
            MOVEPARAMS_NOT_SET(0);
            
            private final int value;

            MoveParamsCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static MoveParamsCase valueOf(int value) {
                return forNumber(value);
            }

            public static MoveParamsCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return MOVEPARAMS_NOT_SET;
                    case 11:
                        return VELOCITY;
                    case 12:
                        return TIME;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public MoveParamsCase getMoveParamsCase() {
            return MoveParamsCase.forNumber(this.moveParamsCase_);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoutePointOuterClass$RoutePoint$RotateParamsCase.class */
        public enum RotateParamsCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            ROTATION(21),
            ROTATION_SPEED(22),
            AXIS_SPEED(23),
            ROTATEPARAMS_NOT_SET(0);
            
            private final int value;

            RotateParamsCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static RotateParamsCase valueOf(int value) {
                return forNumber(value);
            }

            public static RotateParamsCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return ROTATEPARAMS_NOT_SET;
                    case 21:
                        return ROTATION;
                    case 22:
                        return ROTATION_SPEED;
                    case 23:
                        return AXIS_SPEED;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public RotateParamsCase getRotateParamsCase() {
            return RotateParamsCase.forNumber(this.rotateParamsCase_);
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public boolean hasPosition() {
            return this.position_ != null;
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public VectorOuterClass.Vector getPosition() {
            return this.position_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.position_;
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public VectorOuterClass.VectorOrBuilder getPositionOrBuilder() {
            return getPosition();
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public float getArriveRange() {
            return this.arriveRange_;
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public boolean getHasReachEvent() {
            return this.hasReachEvent_;
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public boolean hasVelocity() {
            return this.moveParamsCase_ == 11;
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public float getVelocity() {
            if (this.moveParamsCase_ == 11) {
                return ((Float) this.moveParams_).floatValue();
            }
            return 0.0f;
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public boolean hasTime() {
            return this.moveParamsCase_ == 12;
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public float getTime() {
            if (this.moveParamsCase_ == 12) {
                return ((Float) this.moveParams_).floatValue();
            }
            return 0.0f;
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public boolean hasRotation() {
            return this.rotateParamsCase_ == 21;
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public VectorOuterClass.Vector getRotation() {
            if (this.rotateParamsCase_ == 21) {
                return (VectorOuterClass.Vector) this.rotateParams_;
            }
            return VectorOuterClass.Vector.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public VectorOuterClass.VectorOrBuilder getRotationOrBuilder() {
            if (this.rotateParamsCase_ == 21) {
                return (VectorOuterClass.Vector) this.rotateParams_;
            }
            return VectorOuterClass.Vector.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public boolean hasRotationSpeed() {
            return this.rotateParamsCase_ == 22;
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public MathQuaternionOuterClass.MathQuaternion getRotationSpeed() {
            if (this.rotateParamsCase_ == 22) {
                return (MathQuaternionOuterClass.MathQuaternion) this.rotateParams_;
            }
            return MathQuaternionOuterClass.MathQuaternion.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public MathQuaternionOuterClass.MathQuaternionOrBuilder getRotationSpeedOrBuilder() {
            if (this.rotateParamsCase_ == 22) {
                return (MathQuaternionOuterClass.MathQuaternion) this.rotateParams_;
            }
            return MathQuaternionOuterClass.MathQuaternion.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public boolean hasAxisSpeed() {
            return this.rotateParamsCase_ == 23;
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public MathQuaternionOuterClass.MathQuaternion getAxisSpeed() {
            if (this.rotateParamsCase_ == 23) {
                return (MathQuaternionOuterClass.MathQuaternion) this.rotateParams_;
            }
            return MathQuaternionOuterClass.MathQuaternion.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
        public MathQuaternionOuterClass.MathQuaternionOrBuilder getAxisSpeedOrBuilder() {
            if (this.rotateParamsCase_ == 23) {
                return (MathQuaternionOuterClass.MathQuaternion) this.rotateParams_;
            }
            return MathQuaternionOuterClass.MathQuaternion.getDefaultInstance();
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
            if (this.position_ != null) {
                output.writeMessage(1, getPosition());
            }
            if (this.arriveRange_ != 0.0f) {
                output.writeFloat(2, this.arriveRange_);
            }
            if (this.hasReachEvent_) {
                output.writeBool(3, this.hasReachEvent_);
            }
            if (this.moveParamsCase_ == 11) {
                output.writeFloat(11, ((Float) this.moveParams_).floatValue());
            }
            if (this.moveParamsCase_ == 12) {
                output.writeFloat(12, ((Float) this.moveParams_).floatValue());
            }
            if (this.rotateParamsCase_ == 21) {
                output.writeMessage(21, (VectorOuterClass.Vector) this.rotateParams_);
            }
            if (this.rotateParamsCase_ == 22) {
                output.writeMessage(22, (MathQuaternionOuterClass.MathQuaternion) this.rotateParams_);
            }
            if (this.rotateParamsCase_ == 23) {
                output.writeMessage(23, (MathQuaternionOuterClass.MathQuaternion) this.rotateParams_);
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
            if (this.position_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getPosition());
            }
            if (this.arriveRange_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(2, this.arriveRange_);
            }
            if (this.hasReachEvent_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.hasReachEvent_);
            }
            if (this.moveParamsCase_ == 11) {
                size2 += CodedOutputStream.computeFloatSize(11, ((Float) this.moveParams_).floatValue());
            }
            if (this.moveParamsCase_ == 12) {
                size2 += CodedOutputStream.computeFloatSize(12, ((Float) this.moveParams_).floatValue());
            }
            if (this.rotateParamsCase_ == 21) {
                size2 += CodedOutputStream.computeMessageSize(21, (VectorOuterClass.Vector) this.rotateParams_);
            }
            if (this.rotateParamsCase_ == 22) {
                size2 += CodedOutputStream.computeMessageSize(22, (MathQuaternionOuterClass.MathQuaternion) this.rotateParams_);
            }
            if (this.rotateParamsCase_ == 23) {
                size2 += CodedOutputStream.computeMessageSize(23, (MathQuaternionOuterClass.MathQuaternion) this.rotateParams_);
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
            if (!(obj instanceof RoutePoint)) {
                return equals(obj);
            }
            RoutePoint other = (RoutePoint) obj;
            if (hasPosition() != other.hasPosition()) {
                return false;
            }
            if ((hasPosition() && !getPosition().equals(other.getPosition())) || Float.floatToIntBits(getArriveRange()) != Float.floatToIntBits(other.getArriveRange()) || getHasReachEvent() != other.getHasReachEvent() || !getMoveParamsCase().equals(other.getMoveParamsCase())) {
                return false;
            }
            switch (this.moveParamsCase_) {
                case 11:
                    if (Float.floatToIntBits(getVelocity()) != Float.floatToIntBits(other.getVelocity())) {
                        return false;
                    }
                    break;
                case 12:
                    if (Float.floatToIntBits(getTime()) != Float.floatToIntBits(other.getTime())) {
                        return false;
                    }
                    break;
            }
            if (!getRotateParamsCase().equals(other.getRotateParamsCase())) {
                return false;
            }
            switch (this.rotateParamsCase_) {
                case 21:
                    if (!getRotation().equals(other.getRotation())) {
                        return false;
                    }
                    break;
                case 22:
                    if (!getRotationSpeed().equals(other.getRotationSpeed())) {
                        return false;
                    }
                    break;
                case 23:
                    if (!getAxisSpeed().equals(other.getAxisSpeed())) {
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
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasPosition()) {
                hash = (53 * ((37 * hash) + 1)) + getPosition().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 2)) + Float.floatToIntBits(getArriveRange()))) + 3)) + Internal.hashBoolean(getHasReachEvent());
            switch (this.moveParamsCase_) {
                case 11:
                    hash2 = (53 * ((37 * hash2) + 11)) + Float.floatToIntBits(getVelocity());
                    break;
                case 12:
                    hash2 = (53 * ((37 * hash2) + 12)) + Float.floatToIntBits(getTime());
                    break;
            }
            switch (this.rotateParamsCase_) {
                case 21:
                    hash2 = (53 * ((37 * hash2) + 21)) + getRotation().hashCode();
                    break;
                case 22:
                    hash2 = (53 * ((37 * hash2) + 22)) + getRotationSpeed().hashCode();
                    break;
                case 23:
                    hash2 = (53 * ((37 * hash2) + 23)) + getAxisSpeed().hashCode();
                    break;
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static RoutePoint parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoutePoint parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoutePoint parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoutePoint parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoutePoint parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoutePoint parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoutePoint parseFrom(InputStream input) throws IOException {
            return (RoutePoint) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoutePoint parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoutePoint) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoutePoint parseDelimitedFrom(InputStream input) throws IOException {
            return (RoutePoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RoutePoint parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoutePoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoutePoint parseFrom(CodedInputStream input) throws IOException {
            return (RoutePoint) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoutePoint parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoutePoint) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RoutePoint prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoutePointOuterClass$RoutePoint$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RoutePointOrBuilder {
            private Object moveParams_;
            private Object rotateParams_;
            private VectorOuterClass.Vector position_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> positionBuilder_;
            private float arriveRange_;
            private boolean hasReachEvent_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> rotationBuilder_;
            private SingleFieldBuilderV3<MathQuaternionOuterClass.MathQuaternion, MathQuaternionOuterClass.MathQuaternion.Builder, MathQuaternionOuterClass.MathQuaternionOrBuilder> rotationSpeedBuilder_;
            private SingleFieldBuilderV3<MathQuaternionOuterClass.MathQuaternion, MathQuaternionOuterClass.MathQuaternion.Builder, MathQuaternionOuterClass.MathQuaternionOrBuilder> axisSpeedBuilder_;
            private int moveParamsCase_ = 0;
            private int rotateParamsCase_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return RoutePointOuterClass.internal_static_RoutePoint_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RoutePointOuterClass.internal_static_RoutePoint_fieldAccessorTable.ensureFieldAccessorsInitialized(RoutePoint.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RoutePoint.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.positionBuilder_ == null) {
                    this.position_ = null;
                } else {
                    this.position_ = null;
                    this.positionBuilder_ = null;
                }
                this.arriveRange_ = 0.0f;
                this.hasReachEvent_ = false;
                this.moveParamsCase_ = 0;
                this.moveParams_ = null;
                this.rotateParamsCase_ = 0;
                this.rotateParams_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RoutePointOuterClass.internal_static_RoutePoint_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RoutePoint getDefaultInstanceForType() {
                return RoutePoint.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoutePoint build() {
                RoutePoint result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoutePoint buildPartial() {
                RoutePoint result = new RoutePoint(this);
                if (this.positionBuilder_ == null) {
                    result.position_ = this.position_;
                } else {
                    result.position_ = this.positionBuilder_.build();
                }
                result.arriveRange_ = this.arriveRange_;
                result.hasReachEvent_ = this.hasReachEvent_;
                if (this.moveParamsCase_ == 11) {
                    result.moveParams_ = this.moveParams_;
                }
                if (this.moveParamsCase_ == 12) {
                    result.moveParams_ = this.moveParams_;
                }
                if (this.rotateParamsCase_ == 21) {
                    if (this.rotationBuilder_ == null) {
                        result.rotateParams_ = this.rotateParams_;
                    } else {
                        result.rotateParams_ = this.rotationBuilder_.build();
                    }
                }
                if (this.rotateParamsCase_ == 22) {
                    if (this.rotationSpeedBuilder_ == null) {
                        result.rotateParams_ = this.rotateParams_;
                    } else {
                        result.rotateParams_ = this.rotationSpeedBuilder_.build();
                    }
                }
                if (this.rotateParamsCase_ == 23) {
                    if (this.axisSpeedBuilder_ == null) {
                        result.rotateParams_ = this.rotateParams_;
                    } else {
                        result.rotateParams_ = this.axisSpeedBuilder_.build();
                    }
                }
                result.moveParamsCase_ = this.moveParamsCase_;
                result.rotateParamsCase_ = this.rotateParamsCase_;
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
                if (other instanceof RoutePoint) {
                    return mergeFrom((RoutePoint) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RoutePoint other) {
                if (other == RoutePoint.getDefaultInstance()) {
                    return this;
                }
                if (other.hasPosition()) {
                    mergePosition(other.getPosition());
                }
                if (other.getArriveRange() != 0.0f) {
                    setArriveRange(other.getArriveRange());
                }
                if (other.getHasReachEvent()) {
                    setHasReachEvent(other.getHasReachEvent());
                }
                switch (other.getMoveParamsCase()) {
                    case VELOCITY:
                        setVelocity(other.getVelocity());
                        break;
                    case TIME:
                        setTime(other.getTime());
                        break;
                }
                switch (other.getRotateParamsCase()) {
                    case ROTATION:
                        mergeRotation(other.getRotation());
                        break;
                    case ROTATION_SPEED:
                        mergeRotationSpeed(other.getRotationSpeed());
                        break;
                    case AXIS_SPEED:
                        mergeAxisSpeed(other.getAxisSpeed());
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
                RoutePoint parsedMessage = null;
                try {
                    try {
                        parsedMessage = RoutePoint.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RoutePoint) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public MoveParamsCase getMoveParamsCase() {
                return MoveParamsCase.forNumber(this.moveParamsCase_);
            }

            public Builder clearMoveParams() {
                this.moveParamsCase_ = 0;
                this.moveParams_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public RotateParamsCase getRotateParamsCase() {
                return RotateParamsCase.forNumber(this.rotateParamsCase_);
            }

            public Builder clearRotateParams() {
                this.rotateParamsCase_ = 0;
                this.rotateParams_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public boolean hasPosition() {
                return (this.positionBuilder_ == null && this.position_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public VectorOuterClass.Vector getPosition() {
                if (this.positionBuilder_ == null) {
                    return this.position_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.position_;
                }
                return this.positionBuilder_.getMessage();
            }

            public Builder setPosition(VectorOuterClass.Vector value) {
                if (this.positionBuilder_ != null) {
                    this.positionBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.position_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPosition(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.positionBuilder_ == null) {
                    this.position_ = builderForValue.build();
                    onChanged();
                } else {
                    this.positionBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePosition(VectorOuterClass.Vector value) {
                if (this.positionBuilder_ == null) {
                    if (this.position_ != null) {
                        this.position_ = VectorOuterClass.Vector.newBuilder(this.position_).mergeFrom(value).buildPartial();
                    } else {
                        this.position_ = value;
                    }
                    onChanged();
                } else {
                    this.positionBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPosition() {
                if (this.positionBuilder_ == null) {
                    this.position_ = null;
                    onChanged();
                } else {
                    this.position_ = null;
                    this.positionBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getPositionBuilder() {
                onChanged();
                return getPositionFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public VectorOuterClass.VectorOrBuilder getPositionOrBuilder() {
                if (this.positionBuilder_ != null) {
                    return this.positionBuilder_.getMessageOrBuilder();
                }
                return this.position_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.position_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getPositionFieldBuilder() {
                if (this.positionBuilder_ == null) {
                    this.positionBuilder_ = new SingleFieldBuilderV3<>(getPosition(), getParentForChildren(), isClean());
                    this.position_ = null;
                }
                return this.positionBuilder_;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public float getArriveRange() {
                return this.arriveRange_;
            }

            public Builder setArriveRange(float value) {
                this.arriveRange_ = value;
                onChanged();
                return this;
            }

            public Builder clearArriveRange() {
                this.arriveRange_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public boolean getHasReachEvent() {
                return this.hasReachEvent_;
            }

            public Builder setHasReachEvent(boolean value) {
                this.hasReachEvent_ = value;
                onChanged();
                return this;
            }

            public Builder clearHasReachEvent() {
                this.hasReachEvent_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public boolean hasVelocity() {
                return this.moveParamsCase_ == 11;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public float getVelocity() {
                if (this.moveParamsCase_ == 11) {
                    return ((Float) this.moveParams_).floatValue();
                }
                return 0.0f;
            }

            public Builder setVelocity(float value) {
                this.moveParamsCase_ = 11;
                this.moveParams_ = Float.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearVelocity() {
                if (this.moveParamsCase_ == 11) {
                    this.moveParamsCase_ = 0;
                    this.moveParams_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public boolean hasTime() {
                return this.moveParamsCase_ == 12;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public float getTime() {
                if (this.moveParamsCase_ == 12) {
                    return ((Float) this.moveParams_).floatValue();
                }
                return 0.0f;
            }

            public Builder setTime(float value) {
                this.moveParamsCase_ = 12;
                this.moveParams_ = Float.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearTime() {
                if (this.moveParamsCase_ == 12) {
                    this.moveParamsCase_ = 0;
                    this.moveParams_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public boolean hasRotation() {
                return this.rotateParamsCase_ == 21;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public VectorOuterClass.Vector getRotation() {
                if (this.rotationBuilder_ == null) {
                    if (this.rotateParamsCase_ == 21) {
                        return (VectorOuterClass.Vector) this.rotateParams_;
                    }
                    return VectorOuterClass.Vector.getDefaultInstance();
                } else if (this.rotateParamsCase_ == 21) {
                    return this.rotationBuilder_.getMessage();
                } else {
                    return VectorOuterClass.Vector.getDefaultInstance();
                }
            }

            public Builder setRotation(VectorOuterClass.Vector value) {
                if (this.rotationBuilder_ != null) {
                    this.rotationBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.rotateParams_ = value;
                    onChanged();
                }
                this.rotateParamsCase_ = 21;
                return this;
            }

            public Builder setRotation(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.rotationBuilder_ == null) {
                    this.rotateParams_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rotationBuilder_.setMessage(builderForValue.build());
                }
                this.rotateParamsCase_ = 21;
                return this;
            }

            public Builder mergeRotation(VectorOuterClass.Vector value) {
                if (this.rotationBuilder_ == null) {
                    if (this.rotateParamsCase_ != 21 || this.rotateParams_ == VectorOuterClass.Vector.getDefaultInstance()) {
                        this.rotateParams_ = value;
                    } else {
                        this.rotateParams_ = VectorOuterClass.Vector.newBuilder((VectorOuterClass.Vector) this.rotateParams_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.rotateParamsCase_ == 21) {
                        this.rotationBuilder_.mergeFrom(value);
                    }
                    this.rotationBuilder_.setMessage(value);
                }
                this.rotateParamsCase_ = 21;
                return this;
            }

            public Builder clearRotation() {
                if (this.rotationBuilder_ != null) {
                    if (this.rotateParamsCase_ == 21) {
                        this.rotateParamsCase_ = 0;
                        this.rotateParams_ = null;
                    }
                    this.rotationBuilder_.clear();
                } else if (this.rotateParamsCase_ == 21) {
                    this.rotateParamsCase_ = 0;
                    this.rotateParams_ = null;
                    onChanged();
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getRotationBuilder() {
                return getRotationFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public VectorOuterClass.VectorOrBuilder getRotationOrBuilder() {
                if (this.rotateParamsCase_ == 21 && this.rotationBuilder_ != null) {
                    return this.rotationBuilder_.getMessageOrBuilder();
                }
                if (this.rotateParamsCase_ == 21) {
                    return (VectorOuterClass.Vector) this.rotateParams_;
                }
                return VectorOuterClass.Vector.getDefaultInstance();
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getRotationFieldBuilder() {
                if (this.rotationBuilder_ == null) {
                    if (this.rotateParamsCase_ != 21) {
                        this.rotateParams_ = VectorOuterClass.Vector.getDefaultInstance();
                    }
                    this.rotationBuilder_ = new SingleFieldBuilderV3<>((VectorOuterClass.Vector) this.rotateParams_, getParentForChildren(), isClean());
                    this.rotateParams_ = null;
                }
                this.rotateParamsCase_ = 21;
                onChanged();
                return this.rotationBuilder_;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public boolean hasRotationSpeed() {
                return this.rotateParamsCase_ == 22;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public MathQuaternionOuterClass.MathQuaternion getRotationSpeed() {
                if (this.rotationSpeedBuilder_ == null) {
                    if (this.rotateParamsCase_ == 22) {
                        return (MathQuaternionOuterClass.MathQuaternion) this.rotateParams_;
                    }
                    return MathQuaternionOuterClass.MathQuaternion.getDefaultInstance();
                } else if (this.rotateParamsCase_ == 22) {
                    return this.rotationSpeedBuilder_.getMessage();
                } else {
                    return MathQuaternionOuterClass.MathQuaternion.getDefaultInstance();
                }
            }

            public Builder setRotationSpeed(MathQuaternionOuterClass.MathQuaternion value) {
                if (this.rotationSpeedBuilder_ != null) {
                    this.rotationSpeedBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.rotateParams_ = value;
                    onChanged();
                }
                this.rotateParamsCase_ = 22;
                return this;
            }

            public Builder setRotationSpeed(MathQuaternionOuterClass.MathQuaternion.Builder builderForValue) {
                if (this.rotationSpeedBuilder_ == null) {
                    this.rotateParams_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rotationSpeedBuilder_.setMessage(builderForValue.build());
                }
                this.rotateParamsCase_ = 22;
                return this;
            }

            public Builder mergeRotationSpeed(MathQuaternionOuterClass.MathQuaternion value) {
                if (this.rotationSpeedBuilder_ == null) {
                    if (this.rotateParamsCase_ != 22 || this.rotateParams_ == MathQuaternionOuterClass.MathQuaternion.getDefaultInstance()) {
                        this.rotateParams_ = value;
                    } else {
                        this.rotateParams_ = MathQuaternionOuterClass.MathQuaternion.newBuilder((MathQuaternionOuterClass.MathQuaternion) this.rotateParams_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.rotateParamsCase_ == 22) {
                        this.rotationSpeedBuilder_.mergeFrom(value);
                    }
                    this.rotationSpeedBuilder_.setMessage(value);
                }
                this.rotateParamsCase_ = 22;
                return this;
            }

            public Builder clearRotationSpeed() {
                if (this.rotationSpeedBuilder_ != null) {
                    if (this.rotateParamsCase_ == 22) {
                        this.rotateParamsCase_ = 0;
                        this.rotateParams_ = null;
                    }
                    this.rotationSpeedBuilder_.clear();
                } else if (this.rotateParamsCase_ == 22) {
                    this.rotateParamsCase_ = 0;
                    this.rotateParams_ = null;
                    onChanged();
                }
                return this;
            }

            public MathQuaternionOuterClass.MathQuaternion.Builder getRotationSpeedBuilder() {
                return getRotationSpeedFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public MathQuaternionOuterClass.MathQuaternionOrBuilder getRotationSpeedOrBuilder() {
                if (this.rotateParamsCase_ == 22 && this.rotationSpeedBuilder_ != null) {
                    return this.rotationSpeedBuilder_.getMessageOrBuilder();
                }
                if (this.rotateParamsCase_ == 22) {
                    return (MathQuaternionOuterClass.MathQuaternion) this.rotateParams_;
                }
                return MathQuaternionOuterClass.MathQuaternion.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MathQuaternionOuterClass.MathQuaternion, MathQuaternionOuterClass.MathQuaternion.Builder, MathQuaternionOuterClass.MathQuaternionOrBuilder> getRotationSpeedFieldBuilder() {
                if (this.rotationSpeedBuilder_ == null) {
                    if (this.rotateParamsCase_ != 22) {
                        this.rotateParams_ = MathQuaternionOuterClass.MathQuaternion.getDefaultInstance();
                    }
                    this.rotationSpeedBuilder_ = new SingleFieldBuilderV3<>((MathQuaternionOuterClass.MathQuaternion) this.rotateParams_, getParentForChildren(), isClean());
                    this.rotateParams_ = null;
                }
                this.rotateParamsCase_ = 22;
                onChanged();
                return this.rotationSpeedBuilder_;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public boolean hasAxisSpeed() {
                return this.rotateParamsCase_ == 23;
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public MathQuaternionOuterClass.MathQuaternion getAxisSpeed() {
                if (this.axisSpeedBuilder_ == null) {
                    if (this.rotateParamsCase_ == 23) {
                        return (MathQuaternionOuterClass.MathQuaternion) this.rotateParams_;
                    }
                    return MathQuaternionOuterClass.MathQuaternion.getDefaultInstance();
                } else if (this.rotateParamsCase_ == 23) {
                    return this.axisSpeedBuilder_.getMessage();
                } else {
                    return MathQuaternionOuterClass.MathQuaternion.getDefaultInstance();
                }
            }

            public Builder setAxisSpeed(MathQuaternionOuterClass.MathQuaternion value) {
                if (this.axisSpeedBuilder_ != null) {
                    this.axisSpeedBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.rotateParams_ = value;
                    onChanged();
                }
                this.rotateParamsCase_ = 23;
                return this;
            }

            public Builder setAxisSpeed(MathQuaternionOuterClass.MathQuaternion.Builder builderForValue) {
                if (this.axisSpeedBuilder_ == null) {
                    this.rotateParams_ = builderForValue.build();
                    onChanged();
                } else {
                    this.axisSpeedBuilder_.setMessage(builderForValue.build());
                }
                this.rotateParamsCase_ = 23;
                return this;
            }

            public Builder mergeAxisSpeed(MathQuaternionOuterClass.MathQuaternion value) {
                if (this.axisSpeedBuilder_ == null) {
                    if (this.rotateParamsCase_ != 23 || this.rotateParams_ == MathQuaternionOuterClass.MathQuaternion.getDefaultInstance()) {
                        this.rotateParams_ = value;
                    } else {
                        this.rotateParams_ = MathQuaternionOuterClass.MathQuaternion.newBuilder((MathQuaternionOuterClass.MathQuaternion) this.rotateParams_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.rotateParamsCase_ == 23) {
                        this.axisSpeedBuilder_.mergeFrom(value);
                    }
                    this.axisSpeedBuilder_.setMessage(value);
                }
                this.rotateParamsCase_ = 23;
                return this;
            }

            public Builder clearAxisSpeed() {
                if (this.axisSpeedBuilder_ != null) {
                    if (this.rotateParamsCase_ == 23) {
                        this.rotateParamsCase_ = 0;
                        this.rotateParams_ = null;
                    }
                    this.axisSpeedBuilder_.clear();
                } else if (this.rotateParamsCase_ == 23) {
                    this.rotateParamsCase_ = 0;
                    this.rotateParams_ = null;
                    onChanged();
                }
                return this;
            }

            public MathQuaternionOuterClass.MathQuaternion.Builder getAxisSpeedBuilder() {
                return getAxisSpeedFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.RoutePointOuterClass.RoutePointOrBuilder
            public MathQuaternionOuterClass.MathQuaternionOrBuilder getAxisSpeedOrBuilder() {
                if (this.rotateParamsCase_ == 23 && this.axisSpeedBuilder_ != null) {
                    return this.axisSpeedBuilder_.getMessageOrBuilder();
                }
                if (this.rotateParamsCase_ == 23) {
                    return (MathQuaternionOuterClass.MathQuaternion) this.rotateParams_;
                }
                return MathQuaternionOuterClass.MathQuaternion.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MathQuaternionOuterClass.MathQuaternion, MathQuaternionOuterClass.MathQuaternion.Builder, MathQuaternionOuterClass.MathQuaternionOrBuilder> getAxisSpeedFieldBuilder() {
                if (this.axisSpeedBuilder_ == null) {
                    if (this.rotateParamsCase_ != 23) {
                        this.rotateParams_ = MathQuaternionOuterClass.MathQuaternion.getDefaultInstance();
                    }
                    this.axisSpeedBuilder_ = new SingleFieldBuilderV3<>((MathQuaternionOuterClass.MathQuaternion) this.rotateParams_, getParentForChildren(), isClean());
                    this.rotateParams_ = null;
                }
                this.rotateParamsCase_ = 23;
                onChanged();
                return this.axisSpeedBuilder_;
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

        public static RoutePoint getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RoutePoint> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RoutePoint> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RoutePoint getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MathQuaternionOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
