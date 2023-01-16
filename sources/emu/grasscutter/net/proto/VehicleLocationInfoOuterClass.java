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
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleLocationInfoOuterClass.class */
public final class VehicleLocationInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019VehicleLocationInfo.proto\u001a\fVector.proto\"¬\u0001\n\u0013VehicleLocationInfo\u0012\u0014\n\u0003rot\u0018\u0005 \u0001(\u000b2\u0007.Vector\u0012\u0011\n\towner_uid\u0018\u000b \u0001(\r\u0012\u0010\n\buid_list\u0018\u0004 \u0003(\r\u0012\u000e\n\u0006cur_hp\u0018\u0002 \u0001(\u0002\u0012\u0014\n\u0003pos\u0018\t \u0001(\u000b2\u0007.Vector\u0012\u0011\n\tgadget_id\u0018\u0001 \u0001(\r\u0012\u0011\n\tentity_id\u0018\u000e \u0001(\r\u0012\u000e\n\u0006max_hp\u0018\u000f \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_VehicleLocationInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VehicleLocationInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VehicleLocationInfo_descriptor, new String[]{"Rot", "OwnerUid", "UidList", "CurHp", "Pos", "GadgetId", "EntityId", "MaxHp"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleLocationInfoOuterClass$VehicleLocationInfoOrBuilder.class */
    public interface VehicleLocationInfoOrBuilder extends MessageOrBuilder {
        boolean hasRot();

        VectorOuterClass.Vector getRot();

        VectorOuterClass.VectorOrBuilder getRotOrBuilder();

        int getOwnerUid();

        List<Integer> getUidListList();

        int getUidListCount();

        int getUidList(int i);

        float getCurHp();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        int getGadgetId();

        int getEntityId();

        float getMaxHp();
    }

    private VehicleLocationInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleLocationInfoOuterClass$VehicleLocationInfo.class */
    public static final class VehicleLocationInfo extends GeneratedMessageV3 implements VehicleLocationInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ROT_FIELD_NUMBER = 5;
        private VectorOuterClass.Vector rot_;
        public static final int OWNER_UID_FIELD_NUMBER = 11;
        private int ownerUid_;
        public static final int UID_LIST_FIELD_NUMBER = 4;
        private Internal.IntList uidList_;
        private int uidListMemoizedSerializedSize;
        public static final int CUR_HP_FIELD_NUMBER = 2;
        private float curHp_;
        public static final int POS_FIELD_NUMBER = 9;
        private VectorOuterClass.Vector pos_;
        public static final int GADGET_ID_FIELD_NUMBER = 1;
        private int gadgetId_;
        public static final int ENTITY_ID_FIELD_NUMBER = 14;
        private int entityId_;
        public static final int MAX_HP_FIELD_NUMBER = 15;
        private float maxHp_;
        private byte memoizedIsInitialized;
        private static final VehicleLocationInfo DEFAULT_INSTANCE = new VehicleLocationInfo();
        private static final Parser<VehicleLocationInfo> PARSER = new AbstractParser<VehicleLocationInfo>() { // from class: emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfo.1
            @Override // com.google.protobuf.Parser
            public VehicleLocationInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VehicleLocationInfo(input, extensionRegistry);
            }
        };

        private VehicleLocationInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.uidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private VehicleLocationInfo() {
            this.uidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.uidList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VehicleLocationInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VehicleLocationInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8:
                                this.gadgetId_ = input.readUInt32();
                                break;
                            case 21:
                                this.curHp_ = input.readFloat();
                                break;
                            case 32:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.uidList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.uidList_.addInt(input.readUInt32());
                                break;
                            case 34:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.uidList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.uidList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 42:
                                VectorOuterClass.Vector.Builder subBuilder = this.rot_ != null ? this.rot_.toBuilder() : null;
                                this.rot_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.rot_);
                                    this.rot_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 74:
                                VectorOuterClass.Vector.Builder subBuilder2 = this.pos_ != null ? this.pos_.toBuilder() : null;
                                this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.pos_);
                                    this.pos_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 88:
                                this.ownerUid_ = input.readUInt32();
                                break;
                            case 112:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 125:
                                this.maxHp_ = input.readFloat();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.uidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return VehicleLocationInfoOuterClass.internal_static_VehicleLocationInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VehicleLocationInfoOuterClass.internal_static_VehicleLocationInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VehicleLocationInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
        public boolean hasRot() {
            return this.rot_ != null;
        }

        @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
        public VectorOuterClass.Vector getRot() {
            return this.rot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rot_;
        }

        @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getRotOrBuilder() {
            return getRot();
        }

        @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
        public int getOwnerUid() {
            return this.ownerUid_;
        }

        @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
        public List<Integer> getUidListList() {
            return this.uidList_;
        }

        @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
        public int getUidListCount() {
            return this.uidList_.size();
        }

        @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
        public int getUidList(int index) {
            return this.uidList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
        public float getCurHp() {
            return this.curHp_;
        }

        @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
        public int getGadgetId() {
            return this.gadgetId_;
        }

        @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
        public float getMaxHp() {
            return this.maxHp_;
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
            getSerializedSize();
            if (this.gadgetId_ != 0) {
                output.writeUInt32(1, this.gadgetId_);
            }
            if (this.curHp_ != 0.0f) {
                output.writeFloat(2, this.curHp_);
            }
            if (getUidListList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.uidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.uidList_.size(); i++) {
                output.writeUInt32NoTag(this.uidList_.getInt(i));
            }
            if (this.rot_ != null) {
                output.writeMessage(5, getRot());
            }
            if (this.pos_ != null) {
                output.writeMessage(9, getPos());
            }
            if (this.ownerUid_ != 0) {
                output.writeUInt32(11, this.ownerUid_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(14, this.entityId_);
            }
            if (this.maxHp_ != 0.0f) {
                output.writeFloat(15, this.maxHp_);
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
            if (this.gadgetId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.gadgetId_);
            }
            if (this.curHp_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(2, this.curHp_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.uidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.uidList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getUidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.uidListMemoizedSerializedSize = dataSize;
            if (this.rot_ != null) {
                size3 += CodedOutputStream.computeMessageSize(5, getRot());
            }
            if (this.pos_ != null) {
                size3 += CodedOutputStream.computeMessageSize(9, getPos());
            }
            if (this.ownerUid_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(11, this.ownerUid_);
            }
            if (this.entityId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(14, this.entityId_);
            }
            if (this.maxHp_ != 0.0f) {
                size3 += CodedOutputStream.computeFloatSize(15, this.maxHp_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof VehicleLocationInfo)) {
                return equals(obj);
            }
            VehicleLocationInfo other = (VehicleLocationInfo) obj;
            if (hasRot() != other.hasRot()) {
                return false;
            }
            if ((!hasRot() || getRot().equals(other.getRot())) && getOwnerUid() == other.getOwnerUid() && getUidListList().equals(other.getUidListList()) && Float.floatToIntBits(getCurHp()) == Float.floatToIntBits(other.getCurHp()) && hasPos() == other.hasPos()) {
                return (!hasPos() || getPos().equals(other.getPos())) && getGadgetId() == other.getGadgetId() && getEntityId() == other.getEntityId() && Float.floatToIntBits(getMaxHp()) == Float.floatToIntBits(other.getMaxHp()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasRot()) {
                hash = (53 * ((37 * hash) + 5)) + getRot().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 11)) + getOwnerUid();
            if (getUidListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 4)) + getUidListList().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 2)) + Float.floatToIntBits(getCurHp());
            if (hasPos()) {
                hash3 = (53 * ((37 * hash3) + 9)) + getPos().hashCode();
            }
            int hash4 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash3) + 1)) + getGadgetId())) + 14)) + getEntityId())) + 15)) + Float.floatToIntBits(getMaxHp()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static VehicleLocationInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VehicleLocationInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VehicleLocationInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VehicleLocationInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VehicleLocationInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VehicleLocationInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VehicleLocationInfo parseFrom(InputStream input) throws IOException {
            return (VehicleLocationInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VehicleLocationInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VehicleLocationInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VehicleLocationInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (VehicleLocationInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VehicleLocationInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VehicleLocationInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VehicleLocationInfo parseFrom(CodedInputStream input) throws IOException {
            return (VehicleLocationInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VehicleLocationInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VehicleLocationInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VehicleLocationInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleLocationInfoOuterClass$VehicleLocationInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VehicleLocationInfoOrBuilder {
            private int bitField0_;
            private VectorOuterClass.Vector rot_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> rotBuilder_;
            private int ownerUid_;
            private Internal.IntList uidList_ = VehicleLocationInfo.emptyIntList();
            private float curHp_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private int gadgetId_;
            private int entityId_;
            private float maxHp_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VehicleLocationInfoOuterClass.internal_static_VehicleLocationInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VehicleLocationInfoOuterClass.internal_static_VehicleLocationInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VehicleLocationInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VehicleLocationInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.rotBuilder_ == null) {
                    this.rot_ = null;
                } else {
                    this.rot_ = null;
                    this.rotBuilder_ = null;
                }
                this.ownerUid_ = 0;
                this.uidList_ = VehicleLocationInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.curHp_ = 0.0f;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                this.gadgetId_ = 0;
                this.entityId_ = 0;
                this.maxHp_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VehicleLocationInfoOuterClass.internal_static_VehicleLocationInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VehicleLocationInfo getDefaultInstanceForType() {
                return VehicleLocationInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VehicleLocationInfo build() {
                VehicleLocationInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VehicleLocationInfo buildPartial() {
                VehicleLocationInfo result = new VehicleLocationInfo(this);
                int i = this.bitField0_;
                if (this.rotBuilder_ == null) {
                    result.rot_ = this.rot_;
                } else {
                    result.rot_ = this.rotBuilder_.build();
                }
                result.ownerUid_ = this.ownerUid_;
                if ((this.bitField0_ & 1) != 0) {
                    this.uidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.uidList_ = this.uidList_;
                result.curHp_ = this.curHp_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                result.gadgetId_ = this.gadgetId_;
                result.entityId_ = this.entityId_;
                result.maxHp_ = this.maxHp_;
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
                if (other instanceof VehicleLocationInfo) {
                    return mergeFrom((VehicleLocationInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VehicleLocationInfo other) {
                if (other == VehicleLocationInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasRot()) {
                    mergeRot(other.getRot());
                }
                if (other.getOwnerUid() != 0) {
                    setOwnerUid(other.getOwnerUid());
                }
                if (!other.uidList_.isEmpty()) {
                    if (this.uidList_.isEmpty()) {
                        this.uidList_ = other.uidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUidListIsMutable();
                        this.uidList_.addAll(other.uidList_);
                    }
                    onChanged();
                }
                if (other.getCurHp() != 0.0f) {
                    setCurHp(other.getCurHp());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.getGadgetId() != 0) {
                    setGadgetId(other.getGadgetId());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getMaxHp() != 0.0f) {
                    setMaxHp(other.getMaxHp());
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
                VehicleLocationInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = VehicleLocationInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VehicleLocationInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
            public boolean hasRot() {
                return (this.rotBuilder_ == null && this.rot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
            public int getOwnerUid() {
                return this.ownerUid_;
            }

            public Builder setOwnerUid(int value) {
                this.ownerUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearOwnerUid() {
                this.ownerUid_ = 0;
                onChanged();
                return this;
            }

            private void ensureUidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.uidList_ = VehicleLocationInfo.mutableCopy(this.uidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
            public List<Integer> getUidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.uidList_) : this.uidList_;
            }

            @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
            public int getUidListCount() {
                return this.uidList_.size();
            }

            @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
            public int getUidList(int index) {
                return this.uidList_.getInt(index);
            }

            public Builder setUidList(int index, int value) {
                ensureUidListIsMutable();
                this.uidList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUidList(int value) {
                ensureUidListIsMutable();
                this.uidList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUidList(Iterable<? extends Integer> values) {
                ensureUidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.uidList_);
                onChanged();
                return this;
            }

            public Builder clearUidList() {
                this.uidList_ = VehicleLocationInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
            public float getCurHp() {
                return this.curHp_;
            }

            public Builder setCurHp(float value) {
                this.curHp_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurHp() {
                this.curHp_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
            public int getGadgetId() {
                return this.gadgetId_;
            }

            public Builder setGadgetId(int value) {
                this.gadgetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetId() {
                this.gadgetId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder
            public float getMaxHp() {
                return this.maxHp_;
            }

            public Builder setMaxHp(float value) {
                this.maxHp_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxHp() {
                this.maxHp_ = 0.0f;
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

        public static VehicleLocationInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VehicleLocationInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VehicleLocationInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VehicleLocationInfo getDefaultInstanceForType() {
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
