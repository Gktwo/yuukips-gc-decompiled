package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.HitColliderTypeOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HitCollisionOuterClass.class */
public final class HitCollisionOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012HitCollision.proto\u001a\fVector.proto\u001a\u0015HitColliderType.proto\"Á\u0001\n\fHitCollision\u0012\u001e\n\u0016attackeeHitEntityAngle\u0018\f \u0001(\u0002\u0012\u0017\n\u0006hitDir\u0018\u0004 \u0001(\u000b2\u0007.Vector\u0012\u0019\n\bhitPoint\u0018\u0003 \u0001(\u000b2\u0007.Vector\u0012\u0013\n\u000bhitBoxIndex\u0018\n \u0001(\u0005\u0012\u001d\n\u0015attackeeHitForceAngle\u0018\u000f \u0001(\u0002\u0012)\n\u000fhitColliderType\u0018\t \u0001(\u000e2\u0010.HitColliderTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor(), HitColliderTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HitCollision_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HitCollision_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HitCollision_descriptor, new String[]{"AttackeeHitEntityAngle", "HitDir", "HitPoint", "HitBoxIndex", "AttackeeHitForceAngle", "HitColliderType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HitCollisionOuterClass$HitCollisionOrBuilder.class */
    public interface HitCollisionOrBuilder extends MessageOrBuilder {
        float getAttackeeHitEntityAngle();

        boolean hasHitDir();

        VectorOuterClass.Vector getHitDir();

        VectorOuterClass.VectorOrBuilder getHitDirOrBuilder();

        boolean hasHitPoint();

        VectorOuterClass.Vector getHitPoint();

        VectorOuterClass.VectorOrBuilder getHitPointOrBuilder();

        int getHitBoxIndex();

        float getAttackeeHitForceAngle();

        int getHitColliderTypeValue();

        HitColliderTypeOuterClass.HitColliderType getHitColliderType();
    }

    private HitCollisionOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HitCollisionOuterClass$HitCollision.class */
    public static final class HitCollision extends GeneratedMessageV3 implements HitCollisionOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ATTACKEEHITENTITYANGLE_FIELD_NUMBER = 12;
        private float attackeeHitEntityAngle_;
        public static final int HITDIR_FIELD_NUMBER = 4;
        private VectorOuterClass.Vector hitDir_;
        public static final int HITPOINT_FIELD_NUMBER = 3;
        private VectorOuterClass.Vector hitPoint_;
        public static final int HITBOXINDEX_FIELD_NUMBER = 10;
        private int hitBoxIndex_;
        public static final int ATTACKEEHITFORCEANGLE_FIELD_NUMBER = 15;
        private float attackeeHitForceAngle_;
        public static final int HITCOLLIDERTYPE_FIELD_NUMBER = 9;
        private int hitColliderType_;
        private byte memoizedIsInitialized;
        private static final HitCollision DEFAULT_INSTANCE = new HitCollision();
        private static final Parser<HitCollision> PARSER = new AbstractParser<HitCollision>() { // from class: emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollision.1
            @Override // com.google.protobuf.Parser
            public HitCollision parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HitCollision(input, extensionRegistry);
            }
        };

        private HitCollision(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HitCollision() {
            this.memoizedIsInitialized = -1;
            this.hitColliderType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HitCollision();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HitCollision(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 26:
                                    VectorOuterClass.Vector.Builder subBuilder = this.hitPoint_ != null ? this.hitPoint_.toBuilder() : null;
                                    this.hitPoint_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.hitPoint_);
                                        this.hitPoint_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 34:
                                    VectorOuterClass.Vector.Builder subBuilder2 = this.hitDir_ != null ? this.hitDir_.toBuilder() : null;
                                    this.hitDir_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.hitDir_);
                                        this.hitDir_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 72:
                                    this.hitColliderType_ = input.readEnum();
                                    break;
                                case 80:
                                    this.hitBoxIndex_ = input.readInt32();
                                    break;
                                case 101:
                                    this.attackeeHitEntityAngle_ = input.readFloat();
                                    break;
                                case 125:
                                    this.attackeeHitForceAngle_ = input.readFloat();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HitCollisionOuterClass.internal_static_HitCollision_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HitCollisionOuterClass.internal_static_HitCollision_fieldAccessorTable.ensureFieldAccessorsInitialized(HitCollision.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
        public float getAttackeeHitEntityAngle() {
            return this.attackeeHitEntityAngle_;
        }

        @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
        public boolean hasHitDir() {
            return this.hitDir_ != null;
        }

        @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
        public VectorOuterClass.Vector getHitDir() {
            return this.hitDir_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.hitDir_;
        }

        @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
        public VectorOuterClass.VectorOrBuilder getHitDirOrBuilder() {
            return getHitDir();
        }

        @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
        public boolean hasHitPoint() {
            return this.hitPoint_ != null;
        }

        @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
        public VectorOuterClass.Vector getHitPoint() {
            return this.hitPoint_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.hitPoint_;
        }

        @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
        public VectorOuterClass.VectorOrBuilder getHitPointOrBuilder() {
            return getHitPoint();
        }

        @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
        public int getHitBoxIndex() {
            return this.hitBoxIndex_;
        }

        @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
        public float getAttackeeHitForceAngle() {
            return this.attackeeHitForceAngle_;
        }

        @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
        public int getHitColliderTypeValue() {
            return this.hitColliderType_;
        }

        @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
        public HitColliderTypeOuterClass.HitColliderType getHitColliderType() {
            HitColliderTypeOuterClass.HitColliderType result = HitColliderTypeOuterClass.HitColliderType.valueOf(this.hitColliderType_);
            return result == null ? HitColliderTypeOuterClass.HitColliderType.UNRECOGNIZED : result;
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
            if (this.hitPoint_ != null) {
                output.writeMessage(3, getHitPoint());
            }
            if (this.hitDir_ != null) {
                output.writeMessage(4, getHitDir());
            }
            if (this.hitColliderType_ != HitColliderTypeOuterClass.HitColliderType.HIT_COLLIDER_TYPE_INVALID.getNumber()) {
                output.writeEnum(9, this.hitColliderType_);
            }
            if (this.hitBoxIndex_ != 0) {
                output.writeInt32(10, this.hitBoxIndex_);
            }
            if (this.attackeeHitEntityAngle_ != 0.0f) {
                output.writeFloat(12, this.attackeeHitEntityAngle_);
            }
            if (this.attackeeHitForceAngle_ != 0.0f) {
                output.writeFloat(15, this.attackeeHitForceAngle_);
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
            if (this.hitPoint_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(3, getHitPoint());
            }
            if (this.hitDir_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getHitDir());
            }
            if (this.hitColliderType_ != HitColliderTypeOuterClass.HitColliderType.HIT_COLLIDER_TYPE_INVALID.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(9, this.hitColliderType_);
            }
            if (this.hitBoxIndex_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(10, this.hitBoxIndex_);
            }
            if (this.attackeeHitEntityAngle_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(12, this.attackeeHitEntityAngle_);
            }
            if (this.attackeeHitForceAngle_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(15, this.attackeeHitForceAngle_);
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
            if (!(obj instanceof HitCollision)) {
                return equals(obj);
            }
            HitCollision other = (HitCollision) obj;
            if (Float.floatToIntBits(getAttackeeHitEntityAngle()) != Float.floatToIntBits(other.getAttackeeHitEntityAngle()) || hasHitDir() != other.hasHitDir()) {
                return false;
            }
            if ((!hasHitDir() || getHitDir().equals(other.getHitDir())) && hasHitPoint() == other.hasHitPoint()) {
                return (!hasHitPoint() || getHitPoint().equals(other.getHitPoint())) && getHitBoxIndex() == other.getHitBoxIndex() && Float.floatToIntBits(getAttackeeHitForceAngle()) == Float.floatToIntBits(other.getAttackeeHitForceAngle()) && this.hitColliderType_ == other.hitColliderType_ && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + Float.floatToIntBits(getAttackeeHitEntityAngle());
            if (hasHitDir()) {
                hash = (53 * ((37 * hash) + 4)) + getHitDir().hashCode();
            }
            if (hasHitPoint()) {
                hash = (53 * ((37 * hash) + 3)) + getHitPoint().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 10)) + getHitBoxIndex())) + 15)) + Float.floatToIntBits(getAttackeeHitForceAngle()))) + 9)) + this.hitColliderType_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HitCollision parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HitCollision parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HitCollision parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HitCollision parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HitCollision parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HitCollision parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HitCollision parseFrom(InputStream input) throws IOException {
            return (HitCollision) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HitCollision parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HitCollision) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HitCollision parseDelimitedFrom(InputStream input) throws IOException {
            return (HitCollision) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HitCollision parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HitCollision) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HitCollision parseFrom(CodedInputStream input) throws IOException {
            return (HitCollision) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HitCollision parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HitCollision) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HitCollision prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HitCollisionOuterClass$HitCollision$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HitCollisionOrBuilder {
            private float attackeeHitEntityAngle_;
            private VectorOuterClass.Vector hitDir_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> hitDirBuilder_;
            private VectorOuterClass.Vector hitPoint_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> hitPointBuilder_;
            private int hitBoxIndex_;
            private float attackeeHitForceAngle_;
            private int hitColliderType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return HitCollisionOuterClass.internal_static_HitCollision_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HitCollisionOuterClass.internal_static_HitCollision_fieldAccessorTable.ensureFieldAccessorsInitialized(HitCollision.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HitCollision.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.attackeeHitEntityAngle_ = 0.0f;
                if (this.hitDirBuilder_ == null) {
                    this.hitDir_ = null;
                } else {
                    this.hitDir_ = null;
                    this.hitDirBuilder_ = null;
                }
                if (this.hitPointBuilder_ == null) {
                    this.hitPoint_ = null;
                } else {
                    this.hitPoint_ = null;
                    this.hitPointBuilder_ = null;
                }
                this.hitBoxIndex_ = 0;
                this.attackeeHitForceAngle_ = 0.0f;
                this.hitColliderType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HitCollisionOuterClass.internal_static_HitCollision_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HitCollision getDefaultInstanceForType() {
                return HitCollision.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HitCollision build() {
                HitCollision result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HitCollision buildPartial() {
                HitCollision result = new HitCollision(this);
                result.attackeeHitEntityAngle_ = this.attackeeHitEntityAngle_;
                if (this.hitDirBuilder_ == null) {
                    result.hitDir_ = this.hitDir_;
                } else {
                    result.hitDir_ = this.hitDirBuilder_.build();
                }
                if (this.hitPointBuilder_ == null) {
                    result.hitPoint_ = this.hitPoint_;
                } else {
                    result.hitPoint_ = this.hitPointBuilder_.build();
                }
                result.hitBoxIndex_ = this.hitBoxIndex_;
                result.attackeeHitForceAngle_ = this.attackeeHitForceAngle_;
                result.hitColliderType_ = this.hitColliderType_;
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
                if (other instanceof HitCollision) {
                    return mergeFrom((HitCollision) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HitCollision other) {
                if (other == HitCollision.getDefaultInstance()) {
                    return this;
                }
                if (other.getAttackeeHitEntityAngle() != 0.0f) {
                    setAttackeeHitEntityAngle(other.getAttackeeHitEntityAngle());
                }
                if (other.hasHitDir()) {
                    mergeHitDir(other.getHitDir());
                }
                if (other.hasHitPoint()) {
                    mergeHitPoint(other.getHitPoint());
                }
                if (other.getHitBoxIndex() != 0) {
                    setHitBoxIndex(other.getHitBoxIndex());
                }
                if (other.getAttackeeHitForceAngle() != 0.0f) {
                    setAttackeeHitForceAngle(other.getAttackeeHitForceAngle());
                }
                if (other.hitColliderType_ != 0) {
                    setHitColliderTypeValue(other.getHitColliderTypeValue());
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
                HitCollision parsedMessage = null;
                try {
                    try {
                        parsedMessage = HitCollision.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HitCollision) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
            public float getAttackeeHitEntityAngle() {
                return this.attackeeHitEntityAngle_;
            }

            public Builder setAttackeeHitEntityAngle(float value) {
                this.attackeeHitEntityAngle_ = value;
                onChanged();
                return this;
            }

            public Builder clearAttackeeHitEntityAngle() {
                this.attackeeHitEntityAngle_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
            public boolean hasHitDir() {
                return (this.hitDirBuilder_ == null && this.hitDir_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
            public VectorOuterClass.Vector getHitDir() {
                if (this.hitDirBuilder_ == null) {
                    return this.hitDir_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.hitDir_;
                }
                return this.hitDirBuilder_.getMessage();
            }

            public Builder setHitDir(VectorOuterClass.Vector value) {
                if (this.hitDirBuilder_ != null) {
                    this.hitDirBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.hitDir_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setHitDir(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.hitDirBuilder_ == null) {
                    this.hitDir_ = builderForValue.build();
                    onChanged();
                } else {
                    this.hitDirBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeHitDir(VectorOuterClass.Vector value) {
                if (this.hitDirBuilder_ == null) {
                    if (this.hitDir_ != null) {
                        this.hitDir_ = VectorOuterClass.Vector.newBuilder(this.hitDir_).mergeFrom(value).buildPartial();
                    } else {
                        this.hitDir_ = value;
                    }
                    onChanged();
                } else {
                    this.hitDirBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearHitDir() {
                if (this.hitDirBuilder_ == null) {
                    this.hitDir_ = null;
                    onChanged();
                } else {
                    this.hitDir_ = null;
                    this.hitDirBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getHitDirBuilder() {
                onChanged();
                return getHitDirFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
            public VectorOuterClass.VectorOrBuilder getHitDirOrBuilder() {
                if (this.hitDirBuilder_ != null) {
                    return this.hitDirBuilder_.getMessageOrBuilder();
                }
                return this.hitDir_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.hitDir_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getHitDirFieldBuilder() {
                if (this.hitDirBuilder_ == null) {
                    this.hitDirBuilder_ = new SingleFieldBuilderV3<>(getHitDir(), getParentForChildren(), isClean());
                    this.hitDir_ = null;
                }
                return this.hitDirBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
            public boolean hasHitPoint() {
                return (this.hitPointBuilder_ == null && this.hitPoint_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
            public VectorOuterClass.Vector getHitPoint() {
                if (this.hitPointBuilder_ == null) {
                    return this.hitPoint_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.hitPoint_;
                }
                return this.hitPointBuilder_.getMessage();
            }

            public Builder setHitPoint(VectorOuterClass.Vector value) {
                if (this.hitPointBuilder_ != null) {
                    this.hitPointBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.hitPoint_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setHitPoint(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.hitPointBuilder_ == null) {
                    this.hitPoint_ = builderForValue.build();
                    onChanged();
                } else {
                    this.hitPointBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeHitPoint(VectorOuterClass.Vector value) {
                if (this.hitPointBuilder_ == null) {
                    if (this.hitPoint_ != null) {
                        this.hitPoint_ = VectorOuterClass.Vector.newBuilder(this.hitPoint_).mergeFrom(value).buildPartial();
                    } else {
                        this.hitPoint_ = value;
                    }
                    onChanged();
                } else {
                    this.hitPointBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearHitPoint() {
                if (this.hitPointBuilder_ == null) {
                    this.hitPoint_ = null;
                    onChanged();
                } else {
                    this.hitPoint_ = null;
                    this.hitPointBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getHitPointBuilder() {
                onChanged();
                return getHitPointFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
            public VectorOuterClass.VectorOrBuilder getHitPointOrBuilder() {
                if (this.hitPointBuilder_ != null) {
                    return this.hitPointBuilder_.getMessageOrBuilder();
                }
                return this.hitPoint_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.hitPoint_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getHitPointFieldBuilder() {
                if (this.hitPointBuilder_ == null) {
                    this.hitPointBuilder_ = new SingleFieldBuilderV3<>(getHitPoint(), getParentForChildren(), isClean());
                    this.hitPoint_ = null;
                }
                return this.hitPointBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
            public int getHitBoxIndex() {
                return this.hitBoxIndex_;
            }

            public Builder setHitBoxIndex(int value) {
                this.hitBoxIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearHitBoxIndex() {
                this.hitBoxIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
            public float getAttackeeHitForceAngle() {
                return this.attackeeHitForceAngle_;
            }

            public Builder setAttackeeHitForceAngle(float value) {
                this.attackeeHitForceAngle_ = value;
                onChanged();
                return this;
            }

            public Builder clearAttackeeHitForceAngle() {
                this.attackeeHitForceAngle_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
            public int getHitColliderTypeValue() {
                return this.hitColliderType_;
            }

            public Builder setHitColliderTypeValue(int value) {
                this.hitColliderType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HitCollisionOuterClass.HitCollisionOrBuilder
            public HitColliderTypeOuterClass.HitColliderType getHitColliderType() {
                HitColliderTypeOuterClass.HitColliderType result = HitColliderTypeOuterClass.HitColliderType.valueOf(this.hitColliderType_);
                return result == null ? HitColliderTypeOuterClass.HitColliderType.UNRECOGNIZED : result;
            }

            public Builder setHitColliderType(HitColliderTypeOuterClass.HitColliderType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.hitColliderType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearHitColliderType() {
                this.hitColliderType_ = 0;
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

        public static HitCollision getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HitCollision> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HitCollision> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HitCollision getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
        HitColliderTypeOuterClass.getDescriptor();
    }
}
