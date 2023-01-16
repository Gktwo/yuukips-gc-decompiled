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
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureSeelieRegionDataOuterClass.class */
public final class TreasureSeelieRegionDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eTreasureSeelieRegionData.proto\u001a\fVector.proto\"\u0002\n\u0018TreasureSeelieRegionData\u0012\u0011\n\tregion_id\u0018\u000f \u0001(\r\u0012\u000f\n\u0007is_open\u0018\u0001 \u0001(\b\u0012\u0011\n\topen_time\u0018\u000b \u0001(\r\u0012\"\n\u0011region_center_pos\u0018\t \u0001(\u000b2\u0007.Vector\u0012\u001b\n\u0013Unk3300_CPHOJNMEDBC\u0018\b \u0001(\r\u0012\u0015\n\rregion_radius\u0018\u0006 \u0001(\u0002\u0012\u001b\n\u0013Unk3300_KGECOIIKJLJ\u0018\u0005 \u0001(\r\u0012\u001b\n\u0013Unk3300_AFAMHPCEIKP\u0018\u000e \u0001(\r\u0012\u000f\n\u0007is_done\u0018\n \u0001(\b\u0012\u0010\n\bscene_id\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TreasureSeelieRegionData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TreasureSeelieRegionData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TreasureSeelieRegionData_descriptor, new String[]{"RegionId", "IsOpen", "OpenTime", "RegionCenterPos", "Unk3300CPHOJNMEDBC", "RegionRadius", "Unk3300KGECOIIKJLJ", "Unk3300AFAMHPCEIKP", "IsDone", "SceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureSeelieRegionDataOuterClass$TreasureSeelieRegionDataOrBuilder.class */
    public interface TreasureSeelieRegionDataOrBuilder extends MessageOrBuilder {
        int getRegionId();

        boolean getIsOpen();

        int getOpenTime();

        boolean hasRegionCenterPos();

        VectorOuterClass.Vector getRegionCenterPos();

        VectorOuterClass.VectorOrBuilder getRegionCenterPosOrBuilder();

        int getUnk3300CPHOJNMEDBC();

        float getRegionRadius();

        int getUnk3300KGECOIIKJLJ();

        int getUnk3300AFAMHPCEIKP();

        boolean getIsDone();

        int getSceneId();
    }

    private TreasureSeelieRegionDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureSeelieRegionDataOuterClass$TreasureSeelieRegionData.class */
    public static final class TreasureSeelieRegionData extends GeneratedMessageV3 implements TreasureSeelieRegionDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int REGION_ID_FIELD_NUMBER = 15;
        private int regionId_;
        public static final int IS_OPEN_FIELD_NUMBER = 1;
        private boolean isOpen_;
        public static final int OPEN_TIME_FIELD_NUMBER = 11;
        private int openTime_;
        public static final int REGION_CENTER_POS_FIELD_NUMBER = 9;
        private VectorOuterClass.Vector regionCenterPos_;
        public static final int UNK3300_CPHOJNMEDBC_FIELD_NUMBER = 8;
        private int unk3300CPHOJNMEDBC_;
        public static final int REGION_RADIUS_FIELD_NUMBER = 6;
        private float regionRadius_;
        public static final int UNK3300_KGECOIIKJLJ_FIELD_NUMBER = 5;
        private int unk3300KGECOIIKJLJ_;
        public static final int UNK3300_AFAMHPCEIKP_FIELD_NUMBER = 14;
        private int unk3300AFAMHPCEIKP_;
        public static final int IS_DONE_FIELD_NUMBER = 10;
        private boolean isDone_;
        public static final int SCENE_ID_FIELD_NUMBER = 3;
        private int sceneId_;
        private byte memoizedIsInitialized;
        private static final TreasureSeelieRegionData DEFAULT_INSTANCE = new TreasureSeelieRegionData();
        private static final Parser<TreasureSeelieRegionData> PARSER = new AbstractParser<TreasureSeelieRegionData>() { // from class: emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData.1
            @Override // com.google.protobuf.Parser
            public TreasureSeelieRegionData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureSeelieRegionData(input, extensionRegistry);
            }
        };

        private TreasureSeelieRegionData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TreasureSeelieRegionData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TreasureSeelieRegionData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TreasureSeelieRegionData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isOpen_ = input.readBool();
                                break;
                            case 24:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 40:
                                this.unk3300KGECOIIKJLJ_ = input.readUInt32();
                                break;
                            case 53:
                                this.regionRadius_ = input.readFloat();
                                break;
                            case 64:
                                this.unk3300CPHOJNMEDBC_ = input.readUInt32();
                                break;
                            case 74:
                                VectorOuterClass.Vector.Builder subBuilder = this.regionCenterPos_ != null ? this.regionCenterPos_.toBuilder() : null;
                                this.regionCenterPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.regionCenterPos_);
                                    this.regionCenterPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 80:
                                this.isDone_ = input.readBool();
                                break;
                            case 88:
                                this.openTime_ = input.readUInt32();
                                break;
                            case 112:
                                this.unk3300AFAMHPCEIKP_ = input.readUInt32();
                                break;
                            case 120:
                                this.regionId_ = input.readUInt32();
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
            return TreasureSeelieRegionDataOuterClass.internal_static_TreasureSeelieRegionData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureSeelieRegionDataOuterClass.internal_static_TreasureSeelieRegionData_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureSeelieRegionData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
        public int getRegionId() {
            return this.regionId_;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
        public boolean hasRegionCenterPos() {
            return this.regionCenterPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
        public VectorOuterClass.Vector getRegionCenterPos() {
            return this.regionCenterPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.regionCenterPos_;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getRegionCenterPosOrBuilder() {
            return getRegionCenterPos();
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
        public int getUnk3300CPHOJNMEDBC() {
            return this.unk3300CPHOJNMEDBC_;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
        public float getRegionRadius() {
            return this.regionRadius_;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
        public int getUnk3300KGECOIIKJLJ() {
            return this.unk3300KGECOIIKJLJ_;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
        public int getUnk3300AFAMHPCEIKP() {
            return this.unk3300AFAMHPCEIKP_;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
        public boolean getIsDone() {
            return this.isDone_;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
        public int getSceneId() {
            return this.sceneId_;
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
            if (this.isOpen_) {
                output.writeBool(1, this.isOpen_);
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(3, this.sceneId_);
            }
            if (this.unk3300KGECOIIKJLJ_ != 0) {
                output.writeUInt32(5, this.unk3300KGECOIIKJLJ_);
            }
            if (this.regionRadius_ != 0.0f) {
                output.writeFloat(6, this.regionRadius_);
            }
            if (this.unk3300CPHOJNMEDBC_ != 0) {
                output.writeUInt32(8, this.unk3300CPHOJNMEDBC_);
            }
            if (this.regionCenterPos_ != null) {
                output.writeMessage(9, getRegionCenterPos());
            }
            if (this.isDone_) {
                output.writeBool(10, this.isDone_);
            }
            if (this.openTime_ != 0) {
                output.writeUInt32(11, this.openTime_);
            }
            if (this.unk3300AFAMHPCEIKP_ != 0) {
                output.writeUInt32(14, this.unk3300AFAMHPCEIKP_);
            }
            if (this.regionId_ != 0) {
                output.writeUInt32(15, this.regionId_);
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
            if (this.isOpen_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isOpen_);
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.sceneId_);
            }
            if (this.unk3300KGECOIIKJLJ_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.unk3300KGECOIIKJLJ_);
            }
            if (this.regionRadius_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(6, this.regionRadius_);
            }
            if (this.unk3300CPHOJNMEDBC_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.unk3300CPHOJNMEDBC_);
            }
            if (this.regionCenterPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(9, getRegionCenterPos());
            }
            if (this.isDone_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.isDone_);
            }
            if (this.openTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.openTime_);
            }
            if (this.unk3300AFAMHPCEIKP_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.unk3300AFAMHPCEIKP_);
            }
            if (this.regionId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.regionId_);
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
            if (!(obj instanceof TreasureSeelieRegionData)) {
                return equals(obj);
            }
            TreasureSeelieRegionData other = (TreasureSeelieRegionData) obj;
            if (getRegionId() == other.getRegionId() && getIsOpen() == other.getIsOpen() && getOpenTime() == other.getOpenTime() && hasRegionCenterPos() == other.hasRegionCenterPos()) {
                return (!hasRegionCenterPos() || getRegionCenterPos().equals(other.getRegionCenterPos())) && getUnk3300CPHOJNMEDBC() == other.getUnk3300CPHOJNMEDBC() && Float.floatToIntBits(getRegionRadius()) == Float.floatToIntBits(other.getRegionRadius()) && getUnk3300KGECOIIKJLJ() == other.getUnk3300KGECOIIKJLJ() && getUnk3300AFAMHPCEIKP() == other.getUnk3300AFAMHPCEIKP() && getIsDone() == other.getIsDone() && getSceneId() == other.getSceneId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getRegionId())) + 1)) + Internal.hashBoolean(getIsOpen()))) + 11)) + getOpenTime();
            if (hasRegionCenterPos()) {
                hash = (53 * ((37 * hash) + 9)) + getRegionCenterPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 8)) + getUnk3300CPHOJNMEDBC())) + 6)) + Float.floatToIntBits(getRegionRadius()))) + 5)) + getUnk3300KGECOIIKJLJ())) + 14)) + getUnk3300AFAMHPCEIKP())) + 10)) + Internal.hashBoolean(getIsDone()))) + 3)) + getSceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TreasureSeelieRegionData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureSeelieRegionData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureSeelieRegionData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureSeelieRegionData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureSeelieRegionData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureSeelieRegionData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureSeelieRegionData parseFrom(InputStream input) throws IOException {
            return (TreasureSeelieRegionData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureSeelieRegionData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureSeelieRegionData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureSeelieRegionData parseDelimitedFrom(InputStream input) throws IOException {
            return (TreasureSeelieRegionData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TreasureSeelieRegionData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureSeelieRegionData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureSeelieRegionData parseFrom(CodedInputStream input) throws IOException {
            return (TreasureSeelieRegionData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureSeelieRegionData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureSeelieRegionData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TreasureSeelieRegionData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureSeelieRegionDataOuterClass$TreasureSeelieRegionData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TreasureSeelieRegionDataOrBuilder {
            private int regionId_;
            private boolean isOpen_;
            private int openTime_;
            private VectorOuterClass.Vector regionCenterPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> regionCenterPosBuilder_;
            private int unk3300CPHOJNMEDBC_;
            private float regionRadius_;
            private int unk3300KGECOIIKJLJ_;
            private int unk3300AFAMHPCEIKP_;
            private boolean isDone_;
            private int sceneId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureSeelieRegionDataOuterClass.internal_static_TreasureSeelieRegionData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureSeelieRegionDataOuterClass.internal_static_TreasureSeelieRegionData_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureSeelieRegionData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TreasureSeelieRegionData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.regionId_ = 0;
                this.isOpen_ = false;
                this.openTime_ = 0;
                if (this.regionCenterPosBuilder_ == null) {
                    this.regionCenterPos_ = null;
                } else {
                    this.regionCenterPos_ = null;
                    this.regionCenterPosBuilder_ = null;
                }
                this.unk3300CPHOJNMEDBC_ = 0;
                this.regionRadius_ = 0.0f;
                this.unk3300KGECOIIKJLJ_ = 0;
                this.unk3300AFAMHPCEIKP_ = 0;
                this.isDone_ = false;
                this.sceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TreasureSeelieRegionDataOuterClass.internal_static_TreasureSeelieRegionData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TreasureSeelieRegionData getDefaultInstanceForType() {
                return TreasureSeelieRegionData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureSeelieRegionData build() {
                TreasureSeelieRegionData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureSeelieRegionData buildPartial() {
                TreasureSeelieRegionData result = new TreasureSeelieRegionData(this);
                result.regionId_ = this.regionId_;
                result.isOpen_ = this.isOpen_;
                result.openTime_ = this.openTime_;
                if (this.regionCenterPosBuilder_ == null) {
                    result.regionCenterPos_ = this.regionCenterPos_;
                } else {
                    result.regionCenterPos_ = this.regionCenterPosBuilder_.build();
                }
                result.unk3300CPHOJNMEDBC_ = this.unk3300CPHOJNMEDBC_;
                result.regionRadius_ = this.regionRadius_;
                result.unk3300KGECOIIKJLJ_ = this.unk3300KGECOIIKJLJ_;
                result.unk3300AFAMHPCEIKP_ = this.unk3300AFAMHPCEIKP_;
                result.isDone_ = this.isDone_;
                result.sceneId_ = this.sceneId_;
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
                if (other instanceof TreasureSeelieRegionData) {
                    return mergeFrom((TreasureSeelieRegionData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TreasureSeelieRegionData other) {
                if (other == TreasureSeelieRegionData.getDefaultInstance()) {
                    return this;
                }
                if (other.getRegionId() != 0) {
                    setRegionId(other.getRegionId());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.hasRegionCenterPos()) {
                    mergeRegionCenterPos(other.getRegionCenterPos());
                }
                if (other.getUnk3300CPHOJNMEDBC() != 0) {
                    setUnk3300CPHOJNMEDBC(other.getUnk3300CPHOJNMEDBC());
                }
                if (other.getRegionRadius() != 0.0f) {
                    setRegionRadius(other.getRegionRadius());
                }
                if (other.getUnk3300KGECOIIKJLJ() != 0) {
                    setUnk3300KGECOIIKJLJ(other.getUnk3300KGECOIIKJLJ());
                }
                if (other.getUnk3300AFAMHPCEIKP() != 0) {
                    setUnk3300AFAMHPCEIKP(other.getUnk3300AFAMHPCEIKP());
                }
                if (other.getIsDone()) {
                    setIsDone(other.getIsDone());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
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
                TreasureSeelieRegionData parsedMessage = null;
                try {
                    try {
                        parsedMessage = TreasureSeelieRegionData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TreasureSeelieRegionData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
            public int getRegionId() {
                return this.regionId_;
            }

            public Builder setRegionId(int value) {
                this.regionId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRegionId() {
                this.regionId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
            public int getOpenTime() {
                return this.openTime_;
            }

            public Builder setOpenTime(int value) {
                this.openTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearOpenTime() {
                this.openTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
            public boolean hasRegionCenterPos() {
                return (this.regionCenterPosBuilder_ == null && this.regionCenterPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
            public VectorOuterClass.Vector getRegionCenterPos() {
                if (this.regionCenterPosBuilder_ == null) {
                    return this.regionCenterPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.regionCenterPos_;
                }
                return this.regionCenterPosBuilder_.getMessage();
            }

            public Builder setRegionCenterPos(VectorOuterClass.Vector value) {
                if (this.regionCenterPosBuilder_ != null) {
                    this.regionCenterPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.regionCenterPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRegionCenterPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.regionCenterPosBuilder_ == null) {
                    this.regionCenterPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.regionCenterPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRegionCenterPos(VectorOuterClass.Vector value) {
                if (this.regionCenterPosBuilder_ == null) {
                    if (this.regionCenterPos_ != null) {
                        this.regionCenterPos_ = VectorOuterClass.Vector.newBuilder(this.regionCenterPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.regionCenterPos_ = value;
                    }
                    onChanged();
                } else {
                    this.regionCenterPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRegionCenterPos() {
                if (this.regionCenterPosBuilder_ == null) {
                    this.regionCenterPos_ = null;
                    onChanged();
                } else {
                    this.regionCenterPos_ = null;
                    this.regionCenterPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getRegionCenterPosBuilder() {
                onChanged();
                return getRegionCenterPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
            public VectorOuterClass.VectorOrBuilder getRegionCenterPosOrBuilder() {
                if (this.regionCenterPosBuilder_ != null) {
                    return this.regionCenterPosBuilder_.getMessageOrBuilder();
                }
                return this.regionCenterPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.regionCenterPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getRegionCenterPosFieldBuilder() {
                if (this.regionCenterPosBuilder_ == null) {
                    this.regionCenterPosBuilder_ = new SingleFieldBuilderV3<>(getRegionCenterPos(), getParentForChildren(), isClean());
                    this.regionCenterPos_ = null;
                }
                return this.regionCenterPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
            public int getUnk3300CPHOJNMEDBC() {
                return this.unk3300CPHOJNMEDBC_;
            }

            public Builder setUnk3300CPHOJNMEDBC(int value) {
                this.unk3300CPHOJNMEDBC_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300CPHOJNMEDBC() {
                this.unk3300CPHOJNMEDBC_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
            public float getRegionRadius() {
                return this.regionRadius_;
            }

            public Builder setRegionRadius(float value) {
                this.regionRadius_ = value;
                onChanged();
                return this;
            }

            public Builder clearRegionRadius() {
                this.regionRadius_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
            public int getUnk3300KGECOIIKJLJ() {
                return this.unk3300KGECOIIKJLJ_;
            }

            public Builder setUnk3300KGECOIIKJLJ(int value) {
                this.unk3300KGECOIIKJLJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300KGECOIIKJLJ() {
                this.unk3300KGECOIIKJLJ_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
            public int getUnk3300AFAMHPCEIKP() {
                return this.unk3300AFAMHPCEIKP_;
            }

            public Builder setUnk3300AFAMHPCEIKP(int value) {
                this.unk3300AFAMHPCEIKP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300AFAMHPCEIKP() {
                this.unk3300AFAMHPCEIKP_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
            public boolean getIsDone() {
                return this.isDone_;
            }

            public Builder setIsDone(boolean value) {
                this.isDone_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsDone() {
                this.isDone_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
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

        public static TreasureSeelieRegionData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TreasureSeelieRegionData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TreasureSeelieRegionData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TreasureSeelieRegionData getDefaultInstanceForType() {
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
