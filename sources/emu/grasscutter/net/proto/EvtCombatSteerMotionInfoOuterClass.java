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
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtCombatSteerMotionInfoOuterClass.class */
public final class EvtCombatSteerMotionInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eEvtCombatSteerMotionInfo.proto\u001a\fVector.proto\"y\n\u0018EvtCombatSteerMotionInfo\u0012\u0019\n\bface_dir\u0018\u0005 \u0001(\u000b2\u0007.Vector\u0012\u0014\n\u0003pos\u0018\u0001 \u0001(\u000b2\u0007.Vector\u0012\u0019\n\bvelocity\u0018\b \u0001(\u000b2\u0007.Vector\u0012\u0011\n\tentity_id\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EvtCombatSteerMotionInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EvtCombatSteerMotionInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EvtCombatSteerMotionInfo_descriptor, new String[]{"FaceDir", "Pos", "Velocity", "EntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtCombatSteerMotionInfoOuterClass$EvtCombatSteerMotionInfoOrBuilder.class */
    public interface EvtCombatSteerMotionInfoOrBuilder extends MessageOrBuilder {
        boolean hasFaceDir();

        VectorOuterClass.Vector getFaceDir();

        VectorOuterClass.VectorOrBuilder getFaceDirOrBuilder();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        boolean hasVelocity();

        VectorOuterClass.Vector getVelocity();

        VectorOuterClass.VectorOrBuilder getVelocityOrBuilder();

        int getEntityId();
    }

    private EvtCombatSteerMotionInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtCombatSteerMotionInfoOuterClass$EvtCombatSteerMotionInfo.class */
    public static final class EvtCombatSteerMotionInfo extends GeneratedMessageV3 implements EvtCombatSteerMotionInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FACE_DIR_FIELD_NUMBER = 5;
        private VectorOuterClass.Vector faceDir_;
        public static final int POS_FIELD_NUMBER = 1;
        private VectorOuterClass.Vector pos_;
        public static final int VELOCITY_FIELD_NUMBER = 8;
        private VectorOuterClass.Vector velocity_;
        public static final int ENTITY_ID_FIELD_NUMBER = 11;
        private int entityId_;
        private byte memoizedIsInitialized;
        private static final EvtCombatSteerMotionInfo DEFAULT_INSTANCE = new EvtCombatSteerMotionInfo();
        private static final Parser<EvtCombatSteerMotionInfo> PARSER = new AbstractParser<EvtCombatSteerMotionInfo>() { // from class: emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfo.1
            @Override // com.google.protobuf.Parser
            public EvtCombatSteerMotionInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EvtCombatSteerMotionInfo(input, extensionRegistry);
            }
        };

        private EvtCombatSteerMotionInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EvtCombatSteerMotionInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EvtCombatSteerMotionInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EvtCombatSteerMotionInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                VectorOuterClass.Vector.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.pos_);
                                    this.pos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 42:
                                VectorOuterClass.Vector.Builder subBuilder2 = this.faceDir_ != null ? this.faceDir_.toBuilder() : null;
                                this.faceDir_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.faceDir_);
                                    this.faceDir_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 66:
                                VectorOuterClass.Vector.Builder subBuilder3 = this.velocity_ != null ? this.velocity_.toBuilder() : null;
                                this.velocity_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.velocity_);
                                    this.velocity_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 88:
                                this.entityId_ = input.readUInt32();
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
            return EvtCombatSteerMotionInfoOuterClass.internal_static_EvtCombatSteerMotionInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EvtCombatSteerMotionInfoOuterClass.internal_static_EvtCombatSteerMotionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtCombatSteerMotionInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
        public boolean hasFaceDir() {
            return this.faceDir_ != null;
        }

        @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
        public VectorOuterClass.Vector getFaceDir() {
            return this.faceDir_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.faceDir_;
        }

        @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getFaceDirOrBuilder() {
            return getFaceDir();
        }

        @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
        public boolean hasVelocity() {
            return this.velocity_ != null;
        }

        @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
        public VectorOuterClass.Vector getVelocity() {
            return this.velocity_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.velocity_;
        }

        @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getVelocityOrBuilder() {
            return getVelocity();
        }

        @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
        public int getEntityId() {
            return this.entityId_;
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
            if (this.faceDir_ != null) {
                output.writeMessage(5, getFaceDir());
            }
            if (this.velocity_ != null) {
                output.writeMessage(8, getVelocity());
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(11, this.entityId_);
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
            if (this.faceDir_ != null) {
                size2 += CodedOutputStream.computeMessageSize(5, getFaceDir());
            }
            if (this.velocity_ != null) {
                size2 += CodedOutputStream.computeMessageSize(8, getVelocity());
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.entityId_);
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
            if (!(obj instanceof EvtCombatSteerMotionInfo)) {
                return equals(obj);
            }
            EvtCombatSteerMotionInfo other = (EvtCombatSteerMotionInfo) obj;
            if (hasFaceDir() != other.hasFaceDir()) {
                return false;
            }
            if ((hasFaceDir() && !getFaceDir().equals(other.getFaceDir())) || hasPos() != other.hasPos()) {
                return false;
            }
            if ((!hasPos() || getPos().equals(other.getPos())) && hasVelocity() == other.hasVelocity()) {
                return (!hasVelocity() || getVelocity().equals(other.getVelocity())) && getEntityId() == other.getEntityId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasFaceDir()) {
                hash = (53 * ((37 * hash) + 5)) + getFaceDir().hashCode();
            }
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 1)) + getPos().hashCode();
            }
            if (hasVelocity()) {
                hash = (53 * ((37 * hash) + 8)) + getVelocity().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 11)) + getEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EvtCombatSteerMotionInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtCombatSteerMotionInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtCombatSteerMotionInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtCombatSteerMotionInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtCombatSteerMotionInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtCombatSteerMotionInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtCombatSteerMotionInfo parseFrom(InputStream input) throws IOException {
            return (EvtCombatSteerMotionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtCombatSteerMotionInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtCombatSteerMotionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtCombatSteerMotionInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EvtCombatSteerMotionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EvtCombatSteerMotionInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtCombatSteerMotionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtCombatSteerMotionInfo parseFrom(CodedInputStream input) throws IOException {
            return (EvtCombatSteerMotionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtCombatSteerMotionInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtCombatSteerMotionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EvtCombatSteerMotionInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtCombatSteerMotionInfoOuterClass$EvtCombatSteerMotionInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EvtCombatSteerMotionInfoOrBuilder {
            private VectorOuterClass.Vector faceDir_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> faceDirBuilder_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private VectorOuterClass.Vector velocity_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> velocityBuilder_;
            private int entityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EvtCombatSteerMotionInfoOuterClass.internal_static_EvtCombatSteerMotionInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EvtCombatSteerMotionInfoOuterClass.internal_static_EvtCombatSteerMotionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtCombatSteerMotionInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EvtCombatSteerMotionInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.faceDirBuilder_ == null) {
                    this.faceDir_ = null;
                } else {
                    this.faceDir_ = null;
                    this.faceDirBuilder_ = null;
                }
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                if (this.velocityBuilder_ == null) {
                    this.velocity_ = null;
                } else {
                    this.velocity_ = null;
                    this.velocityBuilder_ = null;
                }
                this.entityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EvtCombatSteerMotionInfoOuterClass.internal_static_EvtCombatSteerMotionInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EvtCombatSteerMotionInfo getDefaultInstanceForType() {
                return EvtCombatSteerMotionInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtCombatSteerMotionInfo build() {
                EvtCombatSteerMotionInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtCombatSteerMotionInfo buildPartial() {
                EvtCombatSteerMotionInfo result = new EvtCombatSteerMotionInfo(this);
                if (this.faceDirBuilder_ == null) {
                    result.faceDir_ = this.faceDir_;
                } else {
                    result.faceDir_ = this.faceDirBuilder_.build();
                }
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                if (this.velocityBuilder_ == null) {
                    result.velocity_ = this.velocity_;
                } else {
                    result.velocity_ = this.velocityBuilder_.build();
                }
                result.entityId_ = this.entityId_;
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
                if (other instanceof EvtCombatSteerMotionInfo) {
                    return mergeFrom((EvtCombatSteerMotionInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EvtCombatSteerMotionInfo other) {
                if (other == EvtCombatSteerMotionInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFaceDir()) {
                    mergeFaceDir(other.getFaceDir());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.hasVelocity()) {
                    mergeVelocity(other.getVelocity());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
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
                EvtCombatSteerMotionInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = EvtCombatSteerMotionInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EvtCombatSteerMotionInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
            public boolean hasFaceDir() {
                return (this.faceDirBuilder_ == null && this.faceDir_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
            public VectorOuterClass.Vector getFaceDir() {
                if (this.faceDirBuilder_ == null) {
                    return this.faceDir_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.faceDir_;
                }
                return this.faceDirBuilder_.getMessage();
            }

            public Builder setFaceDir(VectorOuterClass.Vector value) {
                if (this.faceDirBuilder_ != null) {
                    this.faceDirBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.faceDir_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setFaceDir(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.faceDirBuilder_ == null) {
                    this.faceDir_ = builderForValue.build();
                    onChanged();
                } else {
                    this.faceDirBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeFaceDir(VectorOuterClass.Vector value) {
                if (this.faceDirBuilder_ == null) {
                    if (this.faceDir_ != null) {
                        this.faceDir_ = VectorOuterClass.Vector.newBuilder(this.faceDir_).mergeFrom(value).buildPartial();
                    } else {
                        this.faceDir_ = value;
                    }
                    onChanged();
                } else {
                    this.faceDirBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearFaceDir() {
                if (this.faceDirBuilder_ == null) {
                    this.faceDir_ = null;
                    onChanged();
                } else {
                    this.faceDir_ = null;
                    this.faceDirBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getFaceDirBuilder() {
                onChanged();
                return getFaceDirFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getFaceDirOrBuilder() {
                if (this.faceDirBuilder_ != null) {
                    return this.faceDirBuilder_.getMessageOrBuilder();
                }
                return this.faceDir_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.faceDir_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getFaceDirFieldBuilder() {
                if (this.faceDirBuilder_ == null) {
                    this.faceDirBuilder_ = new SingleFieldBuilderV3<>(getFaceDir(), getParentForChildren(), isClean());
                    this.faceDir_ = null;
                }
                return this.faceDirBuilder_;
            }

            @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
            public boolean hasVelocity() {
                return (this.velocityBuilder_ == null && this.velocity_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
            public VectorOuterClass.Vector getVelocity() {
                if (this.velocityBuilder_ == null) {
                    return this.velocity_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.velocity_;
                }
                return this.velocityBuilder_.getMessage();
            }

            public Builder setVelocity(VectorOuterClass.Vector value) {
                if (this.velocityBuilder_ != null) {
                    this.velocityBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.velocity_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setVelocity(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.velocityBuilder_ == null) {
                    this.velocity_ = builderForValue.build();
                    onChanged();
                } else {
                    this.velocityBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeVelocity(VectorOuterClass.Vector value) {
                if (this.velocityBuilder_ == null) {
                    if (this.velocity_ != null) {
                        this.velocity_ = VectorOuterClass.Vector.newBuilder(this.velocity_).mergeFrom(value).buildPartial();
                    } else {
                        this.velocity_ = value;
                    }
                    onChanged();
                } else {
                    this.velocityBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearVelocity() {
                if (this.velocityBuilder_ == null) {
                    this.velocity_ = null;
                    onChanged();
                } else {
                    this.velocity_ = null;
                    this.velocityBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getVelocityBuilder() {
                onChanged();
                return getVelocityFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getVelocityOrBuilder() {
                if (this.velocityBuilder_ != null) {
                    return this.velocityBuilder_.getMessageOrBuilder();
                }
                return this.velocity_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.velocity_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getVelocityFieldBuilder() {
                if (this.velocityBuilder_ == null) {
                    this.velocityBuilder_ = new SingleFieldBuilderV3<>(getVelocity(), getParentForChildren(), isClean());
                    this.velocity_ = null;
                }
                return this.velocityBuilder_;
            }

            @Override // emu.grasscutter.net.proto.EvtCombatSteerMotionInfoOuterClass.EvtCombatSteerMotionInfoOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
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

        public static EvtCombatSteerMotionInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EvtCombatSteerMotionInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EvtCombatSteerMotionInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EvtCombatSteerMotionInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
    }
}
