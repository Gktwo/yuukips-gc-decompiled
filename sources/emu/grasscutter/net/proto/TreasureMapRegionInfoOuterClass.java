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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapRegionInfoOuterClass.class */
public final class TreasureMapRegionInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bTreasureMapRegionInfo.proto\u001a\fVector.proto\"ù\u0001\n\u0015TreasureMapRegionInfo\u0012\u001b\n\u0013Unk3300_LKEMEDPMIGM\u0018\u0005 \u0001(\r\u0012\u001b\n\u0013Unk3300_MNEKJILFHOA\u0018\f \u0001(\r\u0012\u0011\n\tstartTime\u0018\u0006 \u0001(\r\u0012\u000f\n\u0007sceneId\u0018\u0001 \u0001(\r\u0012\u0010\n\bregionId\u0018\u000e \u0001(\r\u0012\u0014\n\fregionRadius\u0018\b \u0001(\r\u0012\u001b\n\u0013Unk3300_HHBHLPHLHIL\u0018\u000f \u0001(\b\u0012\u001b\n\u0013Unk3300_NIBJOAJLCJI\u0018\u0002 \u0001(\b\u0012 \n\u000fregionCenterPos\u0018\r \u0001(\u000b2\u0007.VectorB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TreasureMapRegionInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TreasureMapRegionInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TreasureMapRegionInfo_descriptor, new String[]{"Unk3300LKEMEDPMIGM", "Unk3300MNEKJILFHOA", "StartTime", "SceneId", "RegionId", "RegionRadius", "Unk3300HHBHLPHLHIL", "Unk3300NIBJOAJLCJI", "RegionCenterPos"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapRegionInfoOuterClass$TreasureMapRegionInfoOrBuilder.class */
    public interface TreasureMapRegionInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300LKEMEDPMIGM();

        int getUnk3300MNEKJILFHOA();

        int getStartTime();

        int getSceneId();

        int getRegionId();

        int getRegionRadius();

        boolean getUnk3300HHBHLPHLHIL();

        boolean getUnk3300NIBJOAJLCJI();

        boolean hasRegionCenterPos();

        VectorOuterClass.Vector getRegionCenterPos();

        VectorOuterClass.VectorOrBuilder getRegionCenterPosOrBuilder();
    }

    private TreasureMapRegionInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapRegionInfoOuterClass$TreasureMapRegionInfo.class */
    public static final class TreasureMapRegionInfo extends GeneratedMessageV3 implements TreasureMapRegionInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_LKEMEDPMIGM_FIELD_NUMBER = 5;
        private int unk3300LKEMEDPMIGM_;
        public static final int UNK3300_MNEKJILFHOA_FIELD_NUMBER = 12;
        private int unk3300MNEKJILFHOA_;
        public static final int STARTTIME_FIELD_NUMBER = 6;
        private int startTime_;
        public static final int SCENEID_FIELD_NUMBER = 1;
        private int sceneId_;
        public static final int REGIONID_FIELD_NUMBER = 14;
        private int regionId_;
        public static final int REGIONRADIUS_FIELD_NUMBER = 8;
        private int regionRadius_;
        public static final int UNK3300_HHBHLPHLHIL_FIELD_NUMBER = 15;
        private boolean unk3300HHBHLPHLHIL_;
        public static final int UNK3300_NIBJOAJLCJI_FIELD_NUMBER = 2;
        private boolean unk3300NIBJOAJLCJI_;
        public static final int REGIONCENTERPOS_FIELD_NUMBER = 13;
        private VectorOuterClass.Vector regionCenterPos_;
        private byte memoizedIsInitialized;
        private static final TreasureMapRegionInfo DEFAULT_INSTANCE = new TreasureMapRegionInfo();
        private static final Parser<TreasureMapRegionInfo> PARSER = new AbstractParser<TreasureMapRegionInfo>() { // from class: emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.1
            @Override // com.google.protobuf.Parser
            public TreasureMapRegionInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureMapRegionInfo(input, extensionRegistry);
            }
        };

        private TreasureMapRegionInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TreasureMapRegionInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TreasureMapRegionInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TreasureMapRegionInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 16:
                                this.unk3300NIBJOAJLCJI_ = input.readBool();
                                break;
                            case 40:
                                this.unk3300LKEMEDPMIGM_ = input.readUInt32();
                                break;
                            case 48:
                                this.startTime_ = input.readUInt32();
                                break;
                            case 64:
                                this.regionRadius_ = input.readUInt32();
                                break;
                            case 96:
                                this.unk3300MNEKJILFHOA_ = input.readUInt32();
                                break;
                            case 106:
                                VectorOuterClass.Vector.Builder subBuilder = this.regionCenterPos_ != null ? this.regionCenterPos_.toBuilder() : null;
                                this.regionCenterPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.regionCenterPos_);
                                    this.regionCenterPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 112:
                                this.regionId_ = input.readUInt32();
                                break;
                            case 120:
                                this.unk3300HHBHLPHLHIL_ = input.readBool();
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
            return TreasureMapRegionInfoOuterClass.internal_static_TreasureMapRegionInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureMapRegionInfoOuterClass.internal_static_TreasureMapRegionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureMapRegionInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
        public int getUnk3300LKEMEDPMIGM() {
            return this.unk3300LKEMEDPMIGM_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
        public int getUnk3300MNEKJILFHOA() {
            return this.unk3300MNEKJILFHOA_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
        public int getStartTime() {
            return this.startTime_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
        public int getRegionId() {
            return this.regionId_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
        public int getRegionRadius() {
            return this.regionRadius_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
        public boolean getUnk3300HHBHLPHLHIL() {
            return this.unk3300HHBHLPHLHIL_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
        public boolean getUnk3300NIBJOAJLCJI() {
            return this.unk3300NIBJOAJLCJI_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
        public boolean hasRegionCenterPos() {
            return this.regionCenterPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
        public VectorOuterClass.Vector getRegionCenterPos() {
            return this.regionCenterPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.regionCenterPos_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getRegionCenterPosOrBuilder() {
            return getRegionCenterPos();
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
            if (this.sceneId_ != 0) {
                output.writeUInt32(1, this.sceneId_);
            }
            if (this.unk3300NIBJOAJLCJI_) {
                output.writeBool(2, this.unk3300NIBJOAJLCJI_);
            }
            if (this.unk3300LKEMEDPMIGM_ != 0) {
                output.writeUInt32(5, this.unk3300LKEMEDPMIGM_);
            }
            if (this.startTime_ != 0) {
                output.writeUInt32(6, this.startTime_);
            }
            if (this.regionRadius_ != 0) {
                output.writeUInt32(8, this.regionRadius_);
            }
            if (this.unk3300MNEKJILFHOA_ != 0) {
                output.writeUInt32(12, this.unk3300MNEKJILFHOA_);
            }
            if (this.regionCenterPos_ != null) {
                output.writeMessage(13, getRegionCenterPos());
            }
            if (this.regionId_ != 0) {
                output.writeUInt32(14, this.regionId_);
            }
            if (this.unk3300HHBHLPHLHIL_) {
                output.writeBool(15, this.unk3300HHBHLPHLHIL_);
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
            if (this.sceneId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.sceneId_);
            }
            if (this.unk3300NIBJOAJLCJI_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.unk3300NIBJOAJLCJI_);
            }
            if (this.unk3300LKEMEDPMIGM_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.unk3300LKEMEDPMIGM_);
            }
            if (this.startTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.startTime_);
            }
            if (this.regionRadius_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.regionRadius_);
            }
            if (this.unk3300MNEKJILFHOA_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.unk3300MNEKJILFHOA_);
            }
            if (this.regionCenterPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getRegionCenterPos());
            }
            if (this.regionId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.regionId_);
            }
            if (this.unk3300HHBHLPHLHIL_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.unk3300HHBHLPHLHIL_);
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
            if (!(obj instanceof TreasureMapRegionInfo)) {
                return equals(obj);
            }
            TreasureMapRegionInfo other = (TreasureMapRegionInfo) obj;
            if (getUnk3300LKEMEDPMIGM() == other.getUnk3300LKEMEDPMIGM() && getUnk3300MNEKJILFHOA() == other.getUnk3300MNEKJILFHOA() && getStartTime() == other.getStartTime() && getSceneId() == other.getSceneId() && getRegionId() == other.getRegionId() && getRegionRadius() == other.getRegionRadius() && getUnk3300HHBHLPHLHIL() == other.getUnk3300HHBHLPHLHIL() && getUnk3300NIBJOAJLCJI() == other.getUnk3300NIBJOAJLCJI() && hasRegionCenterPos() == other.hasRegionCenterPos()) {
                return (!hasRegionCenterPos() || getRegionCenterPos().equals(other.getRegionCenterPos())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getUnk3300LKEMEDPMIGM())) + 12)) + getUnk3300MNEKJILFHOA())) + 6)) + getStartTime())) + 1)) + getSceneId())) + 14)) + getRegionId())) + 8)) + getRegionRadius())) + 15)) + Internal.hashBoolean(getUnk3300HHBHLPHLHIL()))) + 2)) + Internal.hashBoolean(getUnk3300NIBJOAJLCJI());
            if (hasRegionCenterPos()) {
                hash = (53 * ((37 * hash) + 13)) + getRegionCenterPos().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TreasureMapRegionInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapRegionInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapRegionInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapRegionInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapRegionInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapRegionInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapRegionInfo parseFrom(InputStream input) throws IOException {
            return (TreasureMapRegionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureMapRegionInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapRegionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureMapRegionInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TreasureMapRegionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TreasureMapRegionInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapRegionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureMapRegionInfo parseFrom(CodedInputStream input) throws IOException {
            return (TreasureMapRegionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureMapRegionInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapRegionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TreasureMapRegionInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapRegionInfoOuterClass$TreasureMapRegionInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TreasureMapRegionInfoOrBuilder {
            private int unk3300LKEMEDPMIGM_;
            private int unk3300MNEKJILFHOA_;
            private int startTime_;
            private int sceneId_;
            private int regionId_;
            private int regionRadius_;
            private boolean unk3300HHBHLPHLHIL_;
            private boolean unk3300NIBJOAJLCJI_;
            private VectorOuterClass.Vector regionCenterPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> regionCenterPosBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureMapRegionInfoOuterClass.internal_static_TreasureMapRegionInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureMapRegionInfoOuterClass.internal_static_TreasureMapRegionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureMapRegionInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TreasureMapRegionInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300LKEMEDPMIGM_ = 0;
                this.unk3300MNEKJILFHOA_ = 0;
                this.startTime_ = 0;
                this.sceneId_ = 0;
                this.regionId_ = 0;
                this.regionRadius_ = 0;
                this.unk3300HHBHLPHLHIL_ = false;
                this.unk3300NIBJOAJLCJI_ = false;
                if (this.regionCenterPosBuilder_ == null) {
                    this.regionCenterPos_ = null;
                } else {
                    this.regionCenterPos_ = null;
                    this.regionCenterPosBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TreasureMapRegionInfoOuterClass.internal_static_TreasureMapRegionInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TreasureMapRegionInfo getDefaultInstanceForType() {
                return TreasureMapRegionInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureMapRegionInfo build() {
                TreasureMapRegionInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureMapRegionInfo buildPartial() {
                TreasureMapRegionInfo result = new TreasureMapRegionInfo(this);
                result.unk3300LKEMEDPMIGM_ = this.unk3300LKEMEDPMIGM_;
                result.unk3300MNEKJILFHOA_ = this.unk3300MNEKJILFHOA_;
                result.startTime_ = this.startTime_;
                result.sceneId_ = this.sceneId_;
                result.regionId_ = this.regionId_;
                result.regionRadius_ = this.regionRadius_;
                result.unk3300HHBHLPHLHIL_ = this.unk3300HHBHLPHLHIL_;
                result.unk3300NIBJOAJLCJI_ = this.unk3300NIBJOAJLCJI_;
                if (this.regionCenterPosBuilder_ == null) {
                    result.regionCenterPos_ = this.regionCenterPos_;
                } else {
                    result.regionCenterPos_ = this.regionCenterPosBuilder_.build();
                }
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
                if (other instanceof TreasureMapRegionInfo) {
                    return mergeFrom((TreasureMapRegionInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TreasureMapRegionInfo other) {
                if (other == TreasureMapRegionInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300LKEMEDPMIGM() != 0) {
                    setUnk3300LKEMEDPMIGM(other.getUnk3300LKEMEDPMIGM());
                }
                if (other.getUnk3300MNEKJILFHOA() != 0) {
                    setUnk3300MNEKJILFHOA(other.getUnk3300MNEKJILFHOA());
                }
                if (other.getStartTime() != 0) {
                    setStartTime(other.getStartTime());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (other.getRegionId() != 0) {
                    setRegionId(other.getRegionId());
                }
                if (other.getRegionRadius() != 0) {
                    setRegionRadius(other.getRegionRadius());
                }
                if (other.getUnk3300HHBHLPHLHIL()) {
                    setUnk3300HHBHLPHLHIL(other.getUnk3300HHBHLPHLHIL());
                }
                if (other.getUnk3300NIBJOAJLCJI()) {
                    setUnk3300NIBJOAJLCJI(other.getUnk3300NIBJOAJLCJI());
                }
                if (other.hasRegionCenterPos()) {
                    mergeRegionCenterPos(other.getRegionCenterPos());
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
                TreasureMapRegionInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TreasureMapRegionInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TreasureMapRegionInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
            public int getUnk3300LKEMEDPMIGM() {
                return this.unk3300LKEMEDPMIGM_;
            }

            public Builder setUnk3300LKEMEDPMIGM(int value) {
                this.unk3300LKEMEDPMIGM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LKEMEDPMIGM() {
                this.unk3300LKEMEDPMIGM_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
            public int getUnk3300MNEKJILFHOA() {
                return this.unk3300MNEKJILFHOA_;
            }

            public Builder setUnk3300MNEKJILFHOA(int value) {
                this.unk3300MNEKJILFHOA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MNEKJILFHOA() {
                this.unk3300MNEKJILFHOA_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
            public int getStartTime() {
                return this.startTime_;
            }

            public Builder setStartTime(int value) {
                this.startTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartTime() {
                this.startTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
            public int getRegionRadius() {
                return this.regionRadius_;
            }

            public Builder setRegionRadius(int value) {
                this.regionRadius_ = value;
                onChanged();
                return this;
            }

            public Builder clearRegionRadius() {
                this.regionRadius_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
            public boolean getUnk3300HHBHLPHLHIL() {
                return this.unk3300HHBHLPHLHIL_;
            }

            public Builder setUnk3300HHBHLPHLHIL(boolean value) {
                this.unk3300HHBHLPHLHIL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HHBHLPHLHIL() {
                this.unk3300HHBHLPHLHIL_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
            public boolean getUnk3300NIBJOAJLCJI() {
                return this.unk3300NIBJOAJLCJI_;
            }

            public Builder setUnk3300NIBJOAJLCJI(boolean value) {
                this.unk3300NIBJOAJLCJI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NIBJOAJLCJI() {
                this.unk3300NIBJOAJLCJI_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
            public boolean hasRegionCenterPos() {
                return (this.regionCenterPosBuilder_ == null && this.regionCenterPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static TreasureMapRegionInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TreasureMapRegionInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TreasureMapRegionInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TreasureMapRegionInfo getDefaultInstanceForType() {
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
