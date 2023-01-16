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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.MathQuaternionOuterClass;
import emu.grasscutter.net.proto.Vector3IntOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ObstacleInfoOuterClass.class */
public final class ObstacleInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012ObstacleInfo.proto\u001a\u0014MathQuaternion.proto\u001a\fVector.proto\u001a\u0010Vector3Int.proto\"ü\u0001\n\fObstacleInfo\u0012!\n\brotation\u0018\u000b \u0001(\u000b2\u000f.MathQuaternion\u0012&\n\u0005shape\u0018\u0002 \u0001(\u000e2\u0017.ObstacleInfo.ShapeType\u0012\u001c\n\u0007extents\u0018\u0004 \u0001(\u000b2\u000b.Vector3Int\u0012\u0017\n\u0006center\u0018\u0007 \u0001(\u000b2\u0007.Vector\u0012\u0013\n\u000bobstacle_id\u0018\n \u0001(\u0005\"U\n\tShapeType\u0012%\n!SHAPE_TYPE_OBSTACLE_SHAPE_CAPSULE\u0010��\u0012!\n\u001dSHAPE_TYPE_OBSTACLE_SHAPE_BOX\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MathQuaternionOuterClass.getDescriptor(), VectorOuterClass.getDescriptor(), Vector3IntOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ObstacleInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ObstacleInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ObstacleInfo_descriptor, new String[]{"Rotation", "Shape", "Extents", "Center", "ObstacleId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ObstacleInfoOuterClass$ObstacleInfoOrBuilder.class */
    public interface ObstacleInfoOrBuilder extends MessageOrBuilder {
        boolean hasRotation();

        MathQuaternionOuterClass.MathQuaternion getRotation();

        MathQuaternionOuterClass.MathQuaternionOrBuilder getRotationOrBuilder();

        int getShapeValue();

        ObstacleInfo.ShapeType getShape();

        boolean hasExtents();

        Vector3IntOuterClass.Vector3Int getExtents();

        Vector3IntOuterClass.Vector3IntOrBuilder getExtentsOrBuilder();

        boolean hasCenter();

        VectorOuterClass.Vector getCenter();

        VectorOuterClass.VectorOrBuilder getCenterOrBuilder();

        int getObstacleId();
    }

    private ObstacleInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ObstacleInfoOuterClass$ObstacleInfo.class */
    public static final class ObstacleInfo extends GeneratedMessageV3 implements ObstacleInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ROTATION_FIELD_NUMBER = 11;
        private MathQuaternionOuterClass.MathQuaternion rotation_;
        public static final int SHAPE_FIELD_NUMBER = 2;
        private int shape_;
        public static final int EXTENTS_FIELD_NUMBER = 4;
        private Vector3IntOuterClass.Vector3Int extents_;
        public static final int CENTER_FIELD_NUMBER = 7;
        private VectorOuterClass.Vector center_;
        public static final int OBSTACLE_ID_FIELD_NUMBER = 10;
        private int obstacleId_;
        private byte memoizedIsInitialized;
        private static final ObstacleInfo DEFAULT_INSTANCE = new ObstacleInfo();
        private static final Parser<ObstacleInfo> PARSER = new AbstractParser<ObstacleInfo>() { // from class: emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfo.1
            @Override // com.google.protobuf.Parser
            public ObstacleInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ObstacleInfo(input, extensionRegistry);
            }
        };

        private ObstacleInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ObstacleInfo() {
            this.memoizedIsInitialized = -1;
            this.shape_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ObstacleInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ObstacleInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.shape_ = input.readEnum();
                                    break;
                                case 34:
                                    Vector3IntOuterClass.Vector3Int.Builder subBuilder = this.extents_ != null ? this.extents_.toBuilder() : null;
                                    this.extents_ = (Vector3IntOuterClass.Vector3Int) input.readMessage(Vector3IntOuterClass.Vector3Int.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.extents_);
                                        this.extents_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 58:
                                    VectorOuterClass.Vector.Builder subBuilder2 = this.center_ != null ? this.center_.toBuilder() : null;
                                    this.center_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.center_);
                                        this.center_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 80:
                                    this.obstacleId_ = input.readInt32();
                                    break;
                                case 90:
                                    MathQuaternionOuterClass.MathQuaternion.Builder subBuilder3 = this.rotation_ != null ? this.rotation_.toBuilder() : null;
                                    this.rotation_ = (MathQuaternionOuterClass.MathQuaternion) input.readMessage(MathQuaternionOuterClass.MathQuaternion.parser(), extensionRegistry);
                                    if (subBuilder3 == null) {
                                        break;
                                    } else {
                                        subBuilder3.mergeFrom(this.rotation_);
                                        this.rotation_ = subBuilder3.buildPartial();
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
            return ObstacleInfoOuterClass.internal_static_ObstacleInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ObstacleInfoOuterClass.internal_static_ObstacleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ObstacleInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ObstacleInfoOuterClass$ObstacleInfo$ShapeType.class */
        public enum ShapeType implements ProtocolMessageEnum {
            SHAPE_TYPE_OBSTACLE_SHAPE_CAPSULE(0),
            SHAPE_TYPE_OBSTACLE_SHAPE_BOX(1),
            UNRECOGNIZED(-1);
            
            public static final int SHAPE_TYPE_OBSTACLE_SHAPE_CAPSULE_VALUE = 0;
            public static final int SHAPE_TYPE_OBSTACLE_SHAPE_BOX_VALUE = 1;
            private static final Internal.EnumLiteMap<ShapeType> internalValueMap = new Internal.EnumLiteMap<ShapeType>() { // from class: emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfo.ShapeType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public ShapeType findValueByNumber(int number) {
                    return ShapeType.forNumber(number);
                }
            };
            private static final ShapeType[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static ShapeType valueOf(int value) {
                return forNumber(value);
            }

            public static ShapeType forNumber(int value) {
                switch (value) {
                    case 0:
                        return SHAPE_TYPE_OBSTACLE_SHAPE_CAPSULE;
                    case 1:
                        return SHAPE_TYPE_OBSTACLE_SHAPE_BOX;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<ShapeType> internalGetValueMap() {
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
                return ObstacleInfo.getDescriptor().getEnumTypes().get(0);
            }

            public static ShapeType valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            ShapeType(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
        public boolean hasRotation() {
            return this.rotation_ != null;
        }

        @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
        public MathQuaternionOuterClass.MathQuaternion getRotation() {
            return this.rotation_ == null ? MathQuaternionOuterClass.MathQuaternion.getDefaultInstance() : this.rotation_;
        }

        @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
        public MathQuaternionOuterClass.MathQuaternionOrBuilder getRotationOrBuilder() {
            return getRotation();
        }

        @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
        public int getShapeValue() {
            return this.shape_;
        }

        @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
        public ShapeType getShape() {
            ShapeType result = ShapeType.valueOf(this.shape_);
            return result == null ? ShapeType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
        public boolean hasExtents() {
            return this.extents_ != null;
        }

        @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
        public Vector3IntOuterClass.Vector3Int getExtents() {
            return this.extents_ == null ? Vector3IntOuterClass.Vector3Int.getDefaultInstance() : this.extents_;
        }

        @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
        public Vector3IntOuterClass.Vector3IntOrBuilder getExtentsOrBuilder() {
            return getExtents();
        }

        @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
        public boolean hasCenter() {
            return this.center_ != null;
        }

        @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
        public VectorOuterClass.Vector getCenter() {
            return this.center_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.center_;
        }

        @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getCenterOrBuilder() {
            return getCenter();
        }

        @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
        public int getObstacleId() {
            return this.obstacleId_;
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
            if (this.shape_ != ShapeType.SHAPE_TYPE_OBSTACLE_SHAPE_CAPSULE.getNumber()) {
                output.writeEnum(2, this.shape_);
            }
            if (this.extents_ != null) {
                output.writeMessage(4, getExtents());
            }
            if (this.center_ != null) {
                output.writeMessage(7, getCenter());
            }
            if (this.obstacleId_ != 0) {
                output.writeInt32(10, this.obstacleId_);
            }
            if (this.rotation_ != null) {
                output.writeMessage(11, getRotation());
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
            if (this.shape_ != ShapeType.SHAPE_TYPE_OBSTACLE_SHAPE_CAPSULE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(2, this.shape_);
            }
            if (this.extents_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getExtents());
            }
            if (this.center_ != null) {
                size2 += CodedOutputStream.computeMessageSize(7, getCenter());
            }
            if (this.obstacleId_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(10, this.obstacleId_);
            }
            if (this.rotation_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getRotation());
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
            if (!(obj instanceof ObstacleInfo)) {
                return equals(obj);
            }
            ObstacleInfo other = (ObstacleInfo) obj;
            if (hasRotation() != other.hasRotation()) {
                return false;
            }
            if ((hasRotation() && !getRotation().equals(other.getRotation())) || this.shape_ != other.shape_ || hasExtents() != other.hasExtents()) {
                return false;
            }
            if ((!hasExtents() || getExtents().equals(other.getExtents())) && hasCenter() == other.hasCenter()) {
                return (!hasCenter() || getCenter().equals(other.getCenter())) && getObstacleId() == other.getObstacleId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasRotation()) {
                hash = (53 * ((37 * hash) + 11)) + getRotation().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 2)) + this.shape_;
            if (hasExtents()) {
                hash2 = (53 * ((37 * hash2) + 4)) + getExtents().hashCode();
            }
            if (hasCenter()) {
                hash2 = (53 * ((37 * hash2) + 7)) + getCenter().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 10)) + getObstacleId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ObstacleInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ObstacleInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ObstacleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ObstacleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ObstacleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ObstacleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ObstacleInfo parseFrom(InputStream input) throws IOException {
            return (ObstacleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ObstacleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ObstacleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ObstacleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ObstacleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ObstacleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ObstacleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ObstacleInfo parseFrom(CodedInputStream input) throws IOException {
            return (ObstacleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ObstacleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ObstacleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ObstacleInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ObstacleInfoOuterClass$ObstacleInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ObstacleInfoOrBuilder {
            private MathQuaternionOuterClass.MathQuaternion rotation_;
            private SingleFieldBuilderV3<MathQuaternionOuterClass.MathQuaternion, MathQuaternionOuterClass.MathQuaternion.Builder, MathQuaternionOuterClass.MathQuaternionOrBuilder> rotationBuilder_;
            private int shape_ = 0;
            private Vector3IntOuterClass.Vector3Int extents_;
            private SingleFieldBuilderV3<Vector3IntOuterClass.Vector3Int, Vector3IntOuterClass.Vector3Int.Builder, Vector3IntOuterClass.Vector3IntOrBuilder> extentsBuilder_;
            private VectorOuterClass.Vector center_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> centerBuilder_;
            private int obstacleId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ObstacleInfoOuterClass.internal_static_ObstacleInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ObstacleInfoOuterClass.internal_static_ObstacleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ObstacleInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ObstacleInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.rotationBuilder_ == null) {
                    this.rotation_ = null;
                } else {
                    this.rotation_ = null;
                    this.rotationBuilder_ = null;
                }
                this.shape_ = 0;
                if (this.extentsBuilder_ == null) {
                    this.extents_ = null;
                } else {
                    this.extents_ = null;
                    this.extentsBuilder_ = null;
                }
                if (this.centerBuilder_ == null) {
                    this.center_ = null;
                } else {
                    this.center_ = null;
                    this.centerBuilder_ = null;
                }
                this.obstacleId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ObstacleInfoOuterClass.internal_static_ObstacleInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ObstacleInfo getDefaultInstanceForType() {
                return ObstacleInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ObstacleInfo build() {
                ObstacleInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ObstacleInfo buildPartial() {
                ObstacleInfo result = new ObstacleInfo(this);
                if (this.rotationBuilder_ == null) {
                    result.rotation_ = this.rotation_;
                } else {
                    result.rotation_ = this.rotationBuilder_.build();
                }
                result.shape_ = this.shape_;
                if (this.extentsBuilder_ == null) {
                    result.extents_ = this.extents_;
                } else {
                    result.extents_ = this.extentsBuilder_.build();
                }
                if (this.centerBuilder_ == null) {
                    result.center_ = this.center_;
                } else {
                    result.center_ = this.centerBuilder_.build();
                }
                result.obstacleId_ = this.obstacleId_;
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
                if (other instanceof ObstacleInfo) {
                    return mergeFrom((ObstacleInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ObstacleInfo other) {
                if (other == ObstacleInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasRotation()) {
                    mergeRotation(other.getRotation());
                }
                if (other.shape_ != 0) {
                    setShapeValue(other.getShapeValue());
                }
                if (other.hasExtents()) {
                    mergeExtents(other.getExtents());
                }
                if (other.hasCenter()) {
                    mergeCenter(other.getCenter());
                }
                if (other.getObstacleId() != 0) {
                    setObstacleId(other.getObstacleId());
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
                ObstacleInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ObstacleInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ObstacleInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
            public boolean hasRotation() {
                return (this.rotationBuilder_ == null && this.rotation_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
            public MathQuaternionOuterClass.MathQuaternion getRotation() {
                if (this.rotationBuilder_ == null) {
                    return this.rotation_ == null ? MathQuaternionOuterClass.MathQuaternion.getDefaultInstance() : this.rotation_;
                }
                return this.rotationBuilder_.getMessage();
            }

            public Builder setRotation(MathQuaternionOuterClass.MathQuaternion value) {
                if (this.rotationBuilder_ != null) {
                    this.rotationBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.rotation_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRotation(MathQuaternionOuterClass.MathQuaternion.Builder builderForValue) {
                if (this.rotationBuilder_ == null) {
                    this.rotation_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rotationBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRotation(MathQuaternionOuterClass.MathQuaternion value) {
                if (this.rotationBuilder_ == null) {
                    if (this.rotation_ != null) {
                        this.rotation_ = MathQuaternionOuterClass.MathQuaternion.newBuilder(this.rotation_).mergeFrom(value).buildPartial();
                    } else {
                        this.rotation_ = value;
                    }
                    onChanged();
                } else {
                    this.rotationBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRotation() {
                if (this.rotationBuilder_ == null) {
                    this.rotation_ = null;
                    onChanged();
                } else {
                    this.rotation_ = null;
                    this.rotationBuilder_ = null;
                }
                return this;
            }

            public MathQuaternionOuterClass.MathQuaternion.Builder getRotationBuilder() {
                onChanged();
                return getRotationFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
            public MathQuaternionOuterClass.MathQuaternionOrBuilder getRotationOrBuilder() {
                if (this.rotationBuilder_ != null) {
                    return this.rotationBuilder_.getMessageOrBuilder();
                }
                return this.rotation_ == null ? MathQuaternionOuterClass.MathQuaternion.getDefaultInstance() : this.rotation_;
            }

            private SingleFieldBuilderV3<MathQuaternionOuterClass.MathQuaternion, MathQuaternionOuterClass.MathQuaternion.Builder, MathQuaternionOuterClass.MathQuaternionOrBuilder> getRotationFieldBuilder() {
                if (this.rotationBuilder_ == null) {
                    this.rotationBuilder_ = new SingleFieldBuilderV3<>(getRotation(), getParentForChildren(), isClean());
                    this.rotation_ = null;
                }
                return this.rotationBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
            public int getShapeValue() {
                return this.shape_;
            }

            public Builder setShapeValue(int value) {
                this.shape_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
            public ShapeType getShape() {
                ShapeType result = ShapeType.valueOf(this.shape_);
                return result == null ? ShapeType.UNRECOGNIZED : result;
            }

            public Builder setShape(ShapeType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.shape_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearShape() {
                this.shape_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
            public boolean hasExtents() {
                return (this.extentsBuilder_ == null && this.extents_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
            public Vector3IntOuterClass.Vector3Int getExtents() {
                if (this.extentsBuilder_ == null) {
                    return this.extents_ == null ? Vector3IntOuterClass.Vector3Int.getDefaultInstance() : this.extents_;
                }
                return this.extentsBuilder_.getMessage();
            }

            public Builder setExtents(Vector3IntOuterClass.Vector3Int value) {
                if (this.extentsBuilder_ != null) {
                    this.extentsBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.extents_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setExtents(Vector3IntOuterClass.Vector3Int.Builder builderForValue) {
                if (this.extentsBuilder_ == null) {
                    this.extents_ = builderForValue.build();
                    onChanged();
                } else {
                    this.extentsBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeExtents(Vector3IntOuterClass.Vector3Int value) {
                if (this.extentsBuilder_ == null) {
                    if (this.extents_ != null) {
                        this.extents_ = Vector3IntOuterClass.Vector3Int.newBuilder(this.extents_).mergeFrom(value).buildPartial();
                    } else {
                        this.extents_ = value;
                    }
                    onChanged();
                } else {
                    this.extentsBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearExtents() {
                if (this.extentsBuilder_ == null) {
                    this.extents_ = null;
                    onChanged();
                } else {
                    this.extents_ = null;
                    this.extentsBuilder_ = null;
                }
                return this;
            }

            public Vector3IntOuterClass.Vector3Int.Builder getExtentsBuilder() {
                onChanged();
                return getExtentsFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
            public Vector3IntOuterClass.Vector3IntOrBuilder getExtentsOrBuilder() {
                if (this.extentsBuilder_ != null) {
                    return this.extentsBuilder_.getMessageOrBuilder();
                }
                return this.extents_ == null ? Vector3IntOuterClass.Vector3Int.getDefaultInstance() : this.extents_;
            }

            private SingleFieldBuilderV3<Vector3IntOuterClass.Vector3Int, Vector3IntOuterClass.Vector3Int.Builder, Vector3IntOuterClass.Vector3IntOrBuilder> getExtentsFieldBuilder() {
                if (this.extentsBuilder_ == null) {
                    this.extentsBuilder_ = new SingleFieldBuilderV3<>(getExtents(), getParentForChildren(), isClean());
                    this.extents_ = null;
                }
                return this.extentsBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
            public boolean hasCenter() {
                return (this.centerBuilder_ == null && this.center_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
            public VectorOuterClass.Vector getCenter() {
                if (this.centerBuilder_ == null) {
                    return this.center_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.center_;
                }
                return this.centerBuilder_.getMessage();
            }

            public Builder setCenter(VectorOuterClass.Vector value) {
                if (this.centerBuilder_ != null) {
                    this.centerBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.center_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCenter(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.centerBuilder_ == null) {
                    this.center_ = builderForValue.build();
                    onChanged();
                } else {
                    this.centerBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCenter(VectorOuterClass.Vector value) {
                if (this.centerBuilder_ == null) {
                    if (this.center_ != null) {
                        this.center_ = VectorOuterClass.Vector.newBuilder(this.center_).mergeFrom(value).buildPartial();
                    } else {
                        this.center_ = value;
                    }
                    onChanged();
                } else {
                    this.centerBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCenter() {
                if (this.centerBuilder_ == null) {
                    this.center_ = null;
                    onChanged();
                } else {
                    this.center_ = null;
                    this.centerBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getCenterBuilder() {
                onChanged();
                return getCenterFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getCenterOrBuilder() {
                if (this.centerBuilder_ != null) {
                    return this.centerBuilder_.getMessageOrBuilder();
                }
                return this.center_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.center_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getCenterFieldBuilder() {
                if (this.centerBuilder_ == null) {
                    this.centerBuilder_ = new SingleFieldBuilderV3<>(getCenter(), getParentForChildren(), isClean());
                    this.center_ = null;
                }
                return this.centerBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ObstacleInfoOuterClass.ObstacleInfoOrBuilder
            public int getObstacleId() {
                return this.obstacleId_;
            }

            public Builder setObstacleId(int value) {
                this.obstacleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearObstacleId() {
                this.obstacleId_ = 0;
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

        public static ObstacleInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ObstacleInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ObstacleInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ObstacleInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MathQuaternionOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
        Vector3IntOuterClass.getDescriptor();
    }
}
