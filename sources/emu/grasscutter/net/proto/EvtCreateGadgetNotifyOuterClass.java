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
import emu.grasscutter.net.proto.ForwardTypeOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtCreateGadgetNotifyOuterClass.class */
public final class EvtCreateGadgetNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bEvtCreateGadgetNotify.proto\u001a\fVector.proto\u001a\u0011ForwardType.proto\"ñ\u0003\n\u0015EvtCreateGadgetNotify\u0012\u001c\n\u0014targetLockPointIndex\u0018\u0006 \u0001(\r\u0012\u0016\n\ris_async_load\u0018\u0001 \u0001(\b\u0012\u0015\n\rownerEntityId\u0018\u0003 \u0001(\r\u0012 \n\u000finitEulerAngles\u0018\u000b \u0001(\u000b2\u0007.Vector\u0012\u0019\n\u0011propOwnerEntityId\u0018\u0001 \u0001(\r\u0012\u000e\n\u0006roomId\u0018\u000f \u0001(\r\u0012!\n\u000bforwardType\u0018\u0007 \u0001(\u000e2\f.ForwardType\u0012\u000e\n\u0006campId\u0018\u000e \u0001(\r\u0012\u0010\n\bconfigId\u0018\r \u0001(\r\u0012\u0016\n\u000etargetEntityId\u0018\n \u0001(\r\u0012\f\n\u0004guid\u0018\u0005 \u0001(\u0004\u0012\u001b\n\u0013Unk3300_DLBIJFOONBA\u0018\u0002 \u0001(\b\u0012\u0018\n\u0007initPos\u0018\t \u0001(\u000b2\u0007.Vector\u0012\u0010\n\bentityId\u0018\u0004 \u0001(\r\u0012\u001b\n\u0012isPeerIdFromPlayer\u0018\u0006 \u0001(\b\u0012!\n\u0018targetLockPointIndexList\u0018ä\t \u0003(\r\u0012\u001b\n\u0013Unk3300_EJNBIGLGMII\u0018\b \u0001(\b\u0012\u0010\n\bcampType\u0018\f \u0001(\r\u0012\u001b\n\u0012targetEntityIdList\u0018·\f \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor(), ForwardTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EvtCreateGadgetNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EvtCreateGadgetNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EvtCreateGadgetNotify_descriptor, new String[]{"TargetLockPointIndex", "IsAsyncLoad", "OwnerEntityId", "InitEulerAngles", "PropOwnerEntityId", "RoomId", "ForwardType", "CampId", "ConfigId", "TargetEntityId", "Guid", "Unk3300DLBIJFOONBA", "InitPos", "EntityId", "IsPeerIdFromPlayer", "TargetLockPointIndexList", "Unk3300EJNBIGLGMII", "CampType", "TargetEntityIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtCreateGadgetNotifyOuterClass$EvtCreateGadgetNotifyOrBuilder.class */
    public interface EvtCreateGadgetNotifyOrBuilder extends MessageOrBuilder {
        int getTargetLockPointIndex();

        boolean getIsAsyncLoad();

        int getOwnerEntityId();

        boolean hasInitEulerAngles();

        VectorOuterClass.Vector getInitEulerAngles();

        VectorOuterClass.VectorOrBuilder getInitEulerAnglesOrBuilder();

        int getPropOwnerEntityId();

        int getRoomId();

        int getForwardTypeValue();

        ForwardTypeOuterClass.ForwardType getForwardType();

        int getCampId();

        int getConfigId();

        int getTargetEntityId();

        long getGuid();

        boolean getUnk3300DLBIJFOONBA();

        boolean hasInitPos();

        VectorOuterClass.Vector getInitPos();

        VectorOuterClass.VectorOrBuilder getInitPosOrBuilder();

        int getEntityId();

        boolean getIsPeerIdFromPlayer();

        List<Integer> getTargetLockPointIndexListList();

        int getTargetLockPointIndexListCount();

        int getTargetLockPointIndexList(int i);

        boolean getUnk3300EJNBIGLGMII();

        int getCampType();

        List<Integer> getTargetEntityIdListList();

        int getTargetEntityIdListCount();

        int getTargetEntityIdList(int i);
    }

    private EvtCreateGadgetNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtCreateGadgetNotifyOuterClass$EvtCreateGadgetNotify.class */
    public static final class EvtCreateGadgetNotify extends GeneratedMessageV3 implements EvtCreateGadgetNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TARGETLOCKPOINTINDEX_FIELD_NUMBER = 6;
        private int targetLockPointIndex_;
        public static final int IS_ASYNC_LOAD_FIELD_NUMBER = 137;
        private boolean isAsyncLoad_;
        public static final int OWNERENTITYID_FIELD_NUMBER = 3;
        private int ownerEntityId_;
        public static final int INITEULERANGLES_FIELD_NUMBER = 11;
        private VectorOuterClass.Vector initEulerAngles_;
        public static final int PROPOWNERENTITYID_FIELD_NUMBER = 1;
        private int propOwnerEntityId_;
        public static final int ROOMID_FIELD_NUMBER = 15;
        private int roomId_;
        public static final int FORWARDTYPE_FIELD_NUMBER = 7;
        private int forwardType_;
        public static final int CAMPID_FIELD_NUMBER = 14;
        private int campId_;
        public static final int CONFIGID_FIELD_NUMBER = 13;
        private int configId_;
        public static final int TARGETENTITYID_FIELD_NUMBER = 10;
        private int targetEntityId_;
        public static final int GUID_FIELD_NUMBER = 5;
        private long guid_;
        public static final int UNK3300_DLBIJFOONBA_FIELD_NUMBER = 2;
        private boolean unk3300DLBIJFOONBA_;
        public static final int INITPOS_FIELD_NUMBER = 9;
        private VectorOuterClass.Vector initPos_;
        public static final int ENTITYID_FIELD_NUMBER = 4;
        private int entityId_;
        public static final int ISPEERIDFROMPLAYER_FIELD_NUMBER = 771;
        private boolean isPeerIdFromPlayer_;
        public static final int TARGETLOCKPOINTINDEXLIST_FIELD_NUMBER = 1252;
        private Internal.IntList targetLockPointIndexList_;
        private int targetLockPointIndexListMemoizedSerializedSize;
        public static final int UNK3300_EJNBIGLGMII_FIELD_NUMBER = 8;
        private boolean unk3300EJNBIGLGMII_;
        public static final int CAMPTYPE_FIELD_NUMBER = 12;
        private int campType_;
        public static final int TARGETENTITYIDLIST_FIELD_NUMBER = 1591;
        private Internal.IntList targetEntityIdList_;
        private int targetEntityIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final EvtCreateGadgetNotify DEFAULT_INSTANCE = new EvtCreateGadgetNotify();
        private static final Parser<EvtCreateGadgetNotify> PARSER = new AbstractParser<EvtCreateGadgetNotify>() { // from class: emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotify.1
            @Override // com.google.protobuf.Parser
            public EvtCreateGadgetNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EvtCreateGadgetNotify(input, extensionRegistry);
            }
        };

        private EvtCreateGadgetNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.targetLockPointIndexListMemoizedSerializedSize = -1;
            this.targetEntityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private EvtCreateGadgetNotify() {
            this.targetLockPointIndexListMemoizedSerializedSize = -1;
            this.targetEntityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.forwardType_ = 0;
            this.targetLockPointIndexList_ = emptyIntList();
            this.targetEntityIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EvtCreateGadgetNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:124:0x02e7 */
        private EvtCreateGadgetNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.propOwnerEntityId_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.unk3300DLBIJFOONBA_ = input.readBool();
                                    break;
                                case 24:
                                    this.ownerEntityId_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.entityId_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.guid_ = input.readUInt64();
                                    break;
                                case 48:
                                    this.targetLockPointIndex_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.forwardType_ = input.readEnum();
                                    break;
                                case 64:
                                    this.unk3300EJNBIGLGMII_ = input.readBool();
                                    break;
                                case 74:
                                    VectorOuterClass.Vector.Builder subBuilder = this.initPos_ != null ? this.initPos_.toBuilder() : null;
                                    this.initPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.initPos_);
                                        this.initPos_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 80:
                                    this.targetEntityId_ = input.readUInt32();
                                    break;
                                case 90:
                                    VectorOuterClass.Vector.Builder subBuilder2 = this.initEulerAngles_ != null ? this.initEulerAngles_.toBuilder() : null;
                                    this.initEulerAngles_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.initEulerAngles_);
                                        this.initEulerAngles_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 96:
                                    this.campType_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.configId_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.campId_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.roomId_ = input.readUInt32();
                                    break;
                                case 1096:
                                    this.isAsyncLoad_ = input.readBool();
                                    break;
                                case 6168:
                                    this.isPeerIdFromPlayer_ = input.readBool();
                                    break;
                                case RET_DIG_FIND_NEAREST_POS_FAIL_VALUE:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.targetLockPointIndexList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.targetLockPointIndexList_.addInt(input.readUInt32());
                                    break;
                                case 10018:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.targetLockPointIndexList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.targetLockPointIndexList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 12728:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.targetEntityIdList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.targetEntityIdList_.addInt(input.readUInt32());
                                    break;
                                case 12730:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.targetEntityIdList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.targetEntityIdList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                            done = done;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.targetLockPointIndexList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.targetEntityIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EvtCreateGadgetNotifyOuterClass.internal_static_EvtCreateGadgetNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EvtCreateGadgetNotifyOuterClass.internal_static_EvtCreateGadgetNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtCreateGadgetNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public int getTargetLockPointIndex() {
            return this.targetLockPointIndex_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public boolean getIsAsyncLoad() {
            return this.isAsyncLoad_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public int getOwnerEntityId() {
            return this.ownerEntityId_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public boolean hasInitEulerAngles() {
            return this.initEulerAngles_ != null;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public VectorOuterClass.Vector getInitEulerAngles() {
            return this.initEulerAngles_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.initEulerAngles_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public VectorOuterClass.VectorOrBuilder getInitEulerAnglesOrBuilder() {
            return getInitEulerAngles();
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public int getPropOwnerEntityId() {
            return this.propOwnerEntityId_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public int getRoomId() {
            return this.roomId_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public int getForwardTypeValue() {
            return this.forwardType_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public ForwardTypeOuterClass.ForwardType getForwardType() {
            ForwardTypeOuterClass.ForwardType result = ForwardTypeOuterClass.ForwardType.valueOf(this.forwardType_);
            return result == null ? ForwardTypeOuterClass.ForwardType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public int getCampId() {
            return this.campId_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public int getConfigId() {
            return this.configId_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public int getTargetEntityId() {
            return this.targetEntityId_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public long getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public boolean getUnk3300DLBIJFOONBA() {
            return this.unk3300DLBIJFOONBA_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public boolean hasInitPos() {
            return this.initPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public VectorOuterClass.Vector getInitPos() {
            return this.initPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.initPos_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public VectorOuterClass.VectorOrBuilder getInitPosOrBuilder() {
            return getInitPos();
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public boolean getIsPeerIdFromPlayer() {
            return this.isPeerIdFromPlayer_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public List<Integer> getTargetLockPointIndexListList() {
            return this.targetLockPointIndexList_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public int getTargetLockPointIndexListCount() {
            return this.targetLockPointIndexList_.size();
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public int getTargetLockPointIndexList(int index) {
            return this.targetLockPointIndexList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public boolean getUnk3300EJNBIGLGMII() {
            return this.unk3300EJNBIGLGMII_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public int getCampType() {
            return this.campType_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public List<Integer> getTargetEntityIdListList() {
            return this.targetEntityIdList_;
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public int getTargetEntityIdListCount() {
            return this.targetEntityIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
        public int getTargetEntityIdList(int index) {
            return this.targetEntityIdList_.getInt(index);
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
            if (this.propOwnerEntityId_ != 0) {
                output.writeUInt32(1, this.propOwnerEntityId_);
            }
            if (this.unk3300DLBIJFOONBA_) {
                output.writeBool(2, this.unk3300DLBIJFOONBA_);
            }
            if (this.ownerEntityId_ != 0) {
                output.writeUInt32(3, this.ownerEntityId_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(4, this.entityId_);
            }
            if (this.guid_ != 0) {
                output.writeUInt64(5, this.guid_);
            }
            if (this.targetLockPointIndex_ != 0) {
                output.writeUInt32(6, this.targetLockPointIndex_);
            }
            if (this.forwardType_ != ForwardTypeOuterClass.ForwardType.FORWARD_TYPE_LOCAL.getNumber()) {
                output.writeEnum(7, this.forwardType_);
            }
            if (this.unk3300EJNBIGLGMII_) {
                output.writeBool(8, this.unk3300EJNBIGLGMII_);
            }
            if (this.initPos_ != null) {
                output.writeMessage(9, getInitPos());
            }
            if (this.targetEntityId_ != 0) {
                output.writeUInt32(10, this.targetEntityId_);
            }
            if (this.initEulerAngles_ != null) {
                output.writeMessage(11, getInitEulerAngles());
            }
            if (this.campType_ != 0) {
                output.writeUInt32(12, this.campType_);
            }
            if (this.configId_ != 0) {
                output.writeUInt32(13, this.configId_);
            }
            if (this.campId_ != 0) {
                output.writeUInt32(14, this.campId_);
            }
            if (this.roomId_ != 0) {
                output.writeUInt32(15, this.roomId_);
            }
            if (this.isAsyncLoad_) {
                output.writeBool(137, this.isAsyncLoad_);
            }
            if (this.isPeerIdFromPlayer_) {
                output.writeBool(ISPEERIDFROMPLAYER_FIELD_NUMBER, this.isPeerIdFromPlayer_);
            }
            if (getTargetLockPointIndexListList().size() > 0) {
                output.writeUInt32NoTag(10018);
                output.writeUInt32NoTag(this.targetLockPointIndexListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.targetLockPointIndexList_.size(); i++) {
                output.writeUInt32NoTag(this.targetLockPointIndexList_.getInt(i));
            }
            if (getTargetEntityIdListList().size() > 0) {
                output.writeUInt32NoTag(12730);
                output.writeUInt32NoTag(this.targetEntityIdListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.targetEntityIdList_.size(); i2++) {
                output.writeUInt32NoTag(this.targetEntityIdList_.getInt(i2));
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
            if (this.propOwnerEntityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.propOwnerEntityId_);
            }
            if (this.unk3300DLBIJFOONBA_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.unk3300DLBIJFOONBA_);
            }
            if (this.ownerEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.ownerEntityId_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.entityId_);
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(5, this.guid_);
            }
            if (this.targetLockPointIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.targetLockPointIndex_);
            }
            if (this.forwardType_ != ForwardTypeOuterClass.ForwardType.FORWARD_TYPE_LOCAL.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(7, this.forwardType_);
            }
            if (this.unk3300EJNBIGLGMII_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.unk3300EJNBIGLGMII_);
            }
            if (this.initPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(9, getInitPos());
            }
            if (this.targetEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.targetEntityId_);
            }
            if (this.initEulerAngles_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getInitEulerAngles());
            }
            if (this.campType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.campType_);
            }
            if (this.configId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.configId_);
            }
            if (this.campId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.campId_);
            }
            if (this.roomId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.roomId_);
            }
            if (this.isAsyncLoad_) {
                size2 += CodedOutputStream.computeBoolSize(137, this.isAsyncLoad_);
            }
            if (this.isPeerIdFromPlayer_) {
                size2 += CodedOutputStream.computeBoolSize(ISPEERIDFROMPLAYER_FIELD_NUMBER, this.isPeerIdFromPlayer_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.targetLockPointIndexList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.targetLockPointIndexList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getTargetLockPointIndexListList().isEmpty()) {
                size3 = size3 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.targetLockPointIndexListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.targetEntityIdList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.targetEntityIdList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getTargetEntityIdListList().isEmpty()) {
                size4 = size4 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.targetEntityIdListMemoizedSerializedSize = dataSize2;
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EvtCreateGadgetNotify)) {
                return equals(obj);
            }
            EvtCreateGadgetNotify other = (EvtCreateGadgetNotify) obj;
            if (getTargetLockPointIndex() != other.getTargetLockPointIndex() || getIsAsyncLoad() != other.getIsAsyncLoad() || getOwnerEntityId() != other.getOwnerEntityId() || hasInitEulerAngles() != other.hasInitEulerAngles()) {
                return false;
            }
            if ((!hasInitEulerAngles() || getInitEulerAngles().equals(other.getInitEulerAngles())) && getPropOwnerEntityId() == other.getPropOwnerEntityId() && getRoomId() == other.getRoomId() && this.forwardType_ == other.forwardType_ && getCampId() == other.getCampId() && getConfigId() == other.getConfigId() && getTargetEntityId() == other.getTargetEntityId() && getGuid() == other.getGuid() && getUnk3300DLBIJFOONBA() == other.getUnk3300DLBIJFOONBA() && hasInitPos() == other.hasInitPos()) {
                return (!hasInitPos() || getInitPos().equals(other.getInitPos())) && getEntityId() == other.getEntityId() && getIsPeerIdFromPlayer() == other.getIsPeerIdFromPlayer() && getTargetLockPointIndexListList().equals(other.getTargetLockPointIndexListList()) && getUnk3300EJNBIGLGMII() == other.getUnk3300EJNBIGLGMII() && getCampType() == other.getCampType() && getTargetEntityIdListList().equals(other.getTargetEntityIdListList()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getTargetLockPointIndex())) + 137)) + Internal.hashBoolean(getIsAsyncLoad()))) + 3)) + getOwnerEntityId();
            if (hasInitEulerAngles()) {
                hash = (53 * ((37 * hash) + 11)) + getInitEulerAngles().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 1)) + getPropOwnerEntityId())) + 15)) + getRoomId())) + 7)) + this.forwardType_)) + 14)) + getCampId())) + 13)) + getConfigId())) + 10)) + getTargetEntityId())) + 5)) + Internal.hashLong(getGuid()))) + 2)) + Internal.hashBoolean(getUnk3300DLBIJFOONBA());
            if (hasInitPos()) {
                hash2 = (53 * ((37 * hash2) + 9)) + getInitPos().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * hash2) + 4)) + getEntityId())) + ISPEERIDFROMPLAYER_FIELD_NUMBER)) + Internal.hashBoolean(getIsPeerIdFromPlayer());
            if (getTargetLockPointIndexListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + TARGETLOCKPOINTINDEXLIST_FIELD_NUMBER)) + getTargetLockPointIndexListList().hashCode();
            }
            int hash4 = (53 * ((37 * ((53 * ((37 * hash3) + 8)) + Internal.hashBoolean(getUnk3300EJNBIGLGMII()))) + 12)) + getCampType();
            if (getTargetEntityIdListCount() > 0) {
                hash4 = (53 * ((37 * hash4) + 1591)) + getTargetEntityIdListList().hashCode();
            }
            int hash5 = (29 * hash4) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash5;
            return hash5;
        }

        public static EvtCreateGadgetNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtCreateGadgetNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtCreateGadgetNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtCreateGadgetNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtCreateGadgetNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtCreateGadgetNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtCreateGadgetNotify parseFrom(InputStream input) throws IOException {
            return (EvtCreateGadgetNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtCreateGadgetNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtCreateGadgetNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtCreateGadgetNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (EvtCreateGadgetNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EvtCreateGadgetNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtCreateGadgetNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtCreateGadgetNotify parseFrom(CodedInputStream input) throws IOException {
            return (EvtCreateGadgetNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtCreateGadgetNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtCreateGadgetNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EvtCreateGadgetNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtCreateGadgetNotifyOuterClass$EvtCreateGadgetNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EvtCreateGadgetNotifyOrBuilder {
            private int bitField0_;
            private int targetLockPointIndex_;
            private boolean isAsyncLoad_;
            private int ownerEntityId_;
            private VectorOuterClass.Vector initEulerAngles_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> initEulerAnglesBuilder_;
            private int propOwnerEntityId_;
            private int roomId_;
            private int campId_;
            private int configId_;
            private int targetEntityId_;
            private long guid_;
            private boolean unk3300DLBIJFOONBA_;
            private VectorOuterClass.Vector initPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> initPosBuilder_;
            private int entityId_;
            private boolean isPeerIdFromPlayer_;
            private boolean unk3300EJNBIGLGMII_;
            private int campType_;
            private int forwardType_ = 0;
            private Internal.IntList targetLockPointIndexList_ = EvtCreateGadgetNotify.emptyIntList();
            private Internal.IntList targetEntityIdList_ = EvtCreateGadgetNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return EvtCreateGadgetNotifyOuterClass.internal_static_EvtCreateGadgetNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EvtCreateGadgetNotifyOuterClass.internal_static_EvtCreateGadgetNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtCreateGadgetNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EvtCreateGadgetNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.targetLockPointIndex_ = 0;
                this.isAsyncLoad_ = false;
                this.ownerEntityId_ = 0;
                if (this.initEulerAnglesBuilder_ == null) {
                    this.initEulerAngles_ = null;
                } else {
                    this.initEulerAngles_ = null;
                    this.initEulerAnglesBuilder_ = null;
                }
                this.propOwnerEntityId_ = 0;
                this.roomId_ = 0;
                this.forwardType_ = 0;
                this.campId_ = 0;
                this.configId_ = 0;
                this.targetEntityId_ = 0;
                this.guid_ = 0;
                this.unk3300DLBIJFOONBA_ = false;
                if (this.initPosBuilder_ == null) {
                    this.initPos_ = null;
                } else {
                    this.initPos_ = null;
                    this.initPosBuilder_ = null;
                }
                this.entityId_ = 0;
                this.isPeerIdFromPlayer_ = false;
                this.targetLockPointIndexList_ = EvtCreateGadgetNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.unk3300EJNBIGLGMII_ = false;
                this.campType_ = 0;
                this.targetEntityIdList_ = EvtCreateGadgetNotify.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EvtCreateGadgetNotifyOuterClass.internal_static_EvtCreateGadgetNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EvtCreateGadgetNotify getDefaultInstanceForType() {
                return EvtCreateGadgetNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtCreateGadgetNotify build() {
                EvtCreateGadgetNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtCreateGadgetNotify buildPartial() {
                EvtCreateGadgetNotify result = new EvtCreateGadgetNotify(this);
                int i = this.bitField0_;
                result.targetLockPointIndex_ = this.targetLockPointIndex_;
                result.isAsyncLoad_ = this.isAsyncLoad_;
                result.ownerEntityId_ = this.ownerEntityId_;
                if (this.initEulerAnglesBuilder_ == null) {
                    result.initEulerAngles_ = this.initEulerAngles_;
                } else {
                    result.initEulerAngles_ = this.initEulerAnglesBuilder_.build();
                }
                result.propOwnerEntityId_ = this.propOwnerEntityId_;
                result.roomId_ = this.roomId_;
                result.forwardType_ = this.forwardType_;
                result.campId_ = this.campId_;
                result.configId_ = this.configId_;
                result.targetEntityId_ = this.targetEntityId_;
                result.guid_ = this.guid_;
                result.unk3300DLBIJFOONBA_ = this.unk3300DLBIJFOONBA_;
                if (this.initPosBuilder_ == null) {
                    result.initPos_ = this.initPos_;
                } else {
                    result.initPos_ = this.initPosBuilder_.build();
                }
                result.entityId_ = this.entityId_;
                result.isPeerIdFromPlayer_ = this.isPeerIdFromPlayer_;
                if ((this.bitField0_ & 1) != 0) {
                    this.targetLockPointIndexList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.targetLockPointIndexList_ = this.targetLockPointIndexList_;
                result.unk3300EJNBIGLGMII_ = this.unk3300EJNBIGLGMII_;
                result.campType_ = this.campType_;
                if ((this.bitField0_ & 2) != 0) {
                    this.targetEntityIdList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.targetEntityIdList_ = this.targetEntityIdList_;
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
                if (other instanceof EvtCreateGadgetNotify) {
                    return mergeFrom((EvtCreateGadgetNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EvtCreateGadgetNotify other) {
                if (other == EvtCreateGadgetNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getTargetLockPointIndex() != 0) {
                    setTargetLockPointIndex(other.getTargetLockPointIndex());
                }
                if (other.getIsAsyncLoad()) {
                    setIsAsyncLoad(other.getIsAsyncLoad());
                }
                if (other.getOwnerEntityId() != 0) {
                    setOwnerEntityId(other.getOwnerEntityId());
                }
                if (other.hasInitEulerAngles()) {
                    mergeInitEulerAngles(other.getInitEulerAngles());
                }
                if (other.getPropOwnerEntityId() != 0) {
                    setPropOwnerEntityId(other.getPropOwnerEntityId());
                }
                if (other.getRoomId() != 0) {
                    setRoomId(other.getRoomId());
                }
                if (other.forwardType_ != 0) {
                    setForwardTypeValue(other.getForwardTypeValue());
                }
                if (other.getCampId() != 0) {
                    setCampId(other.getCampId());
                }
                if (other.getConfigId() != 0) {
                    setConfigId(other.getConfigId());
                }
                if (other.getTargetEntityId() != 0) {
                    setTargetEntityId(other.getTargetEntityId());
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                if (other.getUnk3300DLBIJFOONBA()) {
                    setUnk3300DLBIJFOONBA(other.getUnk3300DLBIJFOONBA());
                }
                if (other.hasInitPos()) {
                    mergeInitPos(other.getInitPos());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getIsPeerIdFromPlayer()) {
                    setIsPeerIdFromPlayer(other.getIsPeerIdFromPlayer());
                }
                if (!other.targetLockPointIndexList_.isEmpty()) {
                    if (this.targetLockPointIndexList_.isEmpty()) {
                        this.targetLockPointIndexList_ = other.targetLockPointIndexList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureTargetLockPointIndexListIsMutable();
                        this.targetLockPointIndexList_.addAll(other.targetLockPointIndexList_);
                    }
                    onChanged();
                }
                if (other.getUnk3300EJNBIGLGMII()) {
                    setUnk3300EJNBIGLGMII(other.getUnk3300EJNBIGLGMII());
                }
                if (other.getCampType() != 0) {
                    setCampType(other.getCampType());
                }
                if (!other.targetEntityIdList_.isEmpty()) {
                    if (this.targetEntityIdList_.isEmpty()) {
                        this.targetEntityIdList_ = other.targetEntityIdList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureTargetEntityIdListIsMutable();
                        this.targetEntityIdList_.addAll(other.targetEntityIdList_);
                    }
                    onChanged();
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
                EvtCreateGadgetNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = EvtCreateGadgetNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EvtCreateGadgetNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public int getTargetLockPointIndex() {
                return this.targetLockPointIndex_;
            }

            public Builder setTargetLockPointIndex(int value) {
                this.targetLockPointIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetLockPointIndex() {
                this.targetLockPointIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public boolean getIsAsyncLoad() {
                return this.isAsyncLoad_;
            }

            public Builder setIsAsyncLoad(boolean value) {
                this.isAsyncLoad_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAsyncLoad() {
                this.isAsyncLoad_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public int getOwnerEntityId() {
                return this.ownerEntityId_;
            }

            public Builder setOwnerEntityId(int value) {
                this.ownerEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearOwnerEntityId() {
                this.ownerEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public boolean hasInitEulerAngles() {
                return (this.initEulerAnglesBuilder_ == null && this.initEulerAngles_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public VectorOuterClass.Vector getInitEulerAngles() {
                if (this.initEulerAnglesBuilder_ == null) {
                    return this.initEulerAngles_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.initEulerAngles_;
                }
                return this.initEulerAnglesBuilder_.getMessage();
            }

            public Builder setInitEulerAngles(VectorOuterClass.Vector value) {
                if (this.initEulerAnglesBuilder_ != null) {
                    this.initEulerAnglesBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.initEulerAngles_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setInitEulerAngles(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.initEulerAnglesBuilder_ == null) {
                    this.initEulerAngles_ = builderForValue.build();
                    onChanged();
                } else {
                    this.initEulerAnglesBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeInitEulerAngles(VectorOuterClass.Vector value) {
                if (this.initEulerAnglesBuilder_ == null) {
                    if (this.initEulerAngles_ != null) {
                        this.initEulerAngles_ = VectorOuterClass.Vector.newBuilder(this.initEulerAngles_).mergeFrom(value).buildPartial();
                    } else {
                        this.initEulerAngles_ = value;
                    }
                    onChanged();
                } else {
                    this.initEulerAnglesBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearInitEulerAngles() {
                if (this.initEulerAnglesBuilder_ == null) {
                    this.initEulerAngles_ = null;
                    onChanged();
                } else {
                    this.initEulerAngles_ = null;
                    this.initEulerAnglesBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getInitEulerAnglesBuilder() {
                onChanged();
                return getInitEulerAnglesFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public VectorOuterClass.VectorOrBuilder getInitEulerAnglesOrBuilder() {
                if (this.initEulerAnglesBuilder_ != null) {
                    return this.initEulerAnglesBuilder_.getMessageOrBuilder();
                }
                return this.initEulerAngles_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.initEulerAngles_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getInitEulerAnglesFieldBuilder() {
                if (this.initEulerAnglesBuilder_ == null) {
                    this.initEulerAnglesBuilder_ = new SingleFieldBuilderV3<>(getInitEulerAngles(), getParentForChildren(), isClean());
                    this.initEulerAngles_ = null;
                }
                return this.initEulerAnglesBuilder_;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public int getPropOwnerEntityId() {
                return this.propOwnerEntityId_;
            }

            public Builder setPropOwnerEntityId(int value) {
                this.propOwnerEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPropOwnerEntityId() {
                this.propOwnerEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public int getRoomId() {
                return this.roomId_;
            }

            public Builder setRoomId(int value) {
                this.roomId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRoomId() {
                this.roomId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public int getForwardTypeValue() {
                return this.forwardType_;
            }

            public Builder setForwardTypeValue(int value) {
                this.forwardType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public ForwardTypeOuterClass.ForwardType getForwardType() {
                ForwardTypeOuterClass.ForwardType result = ForwardTypeOuterClass.ForwardType.valueOf(this.forwardType_);
                return result == null ? ForwardTypeOuterClass.ForwardType.UNRECOGNIZED : result;
            }

            public Builder setForwardType(ForwardTypeOuterClass.ForwardType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.forwardType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearForwardType() {
                this.forwardType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public int getCampId() {
                return this.campId_;
            }

            public Builder setCampId(int value) {
                this.campId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCampId() {
                this.campId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public int getConfigId() {
                return this.configId_;
            }

            public Builder setConfigId(int value) {
                this.configId_ = value;
                onChanged();
                return this;
            }

            public Builder clearConfigId() {
                this.configId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public int getTargetEntityId() {
                return this.targetEntityId_;
            }

            public Builder setTargetEntityId(int value) {
                this.targetEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetEntityId() {
                this.targetEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public long getGuid() {
                return this.guid_;
            }

            public Builder setGuid(long value) {
                this.guid_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuid() {
                this.guid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public boolean getUnk3300DLBIJFOONBA() {
                return this.unk3300DLBIJFOONBA_;
            }

            public Builder setUnk3300DLBIJFOONBA(boolean value) {
                this.unk3300DLBIJFOONBA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DLBIJFOONBA() {
                this.unk3300DLBIJFOONBA_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public boolean hasInitPos() {
                return (this.initPosBuilder_ == null && this.initPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public VectorOuterClass.Vector getInitPos() {
                if (this.initPosBuilder_ == null) {
                    return this.initPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.initPos_;
                }
                return this.initPosBuilder_.getMessage();
            }

            public Builder setInitPos(VectorOuterClass.Vector value) {
                if (this.initPosBuilder_ != null) {
                    this.initPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.initPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setInitPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.initPosBuilder_ == null) {
                    this.initPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.initPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeInitPos(VectorOuterClass.Vector value) {
                if (this.initPosBuilder_ == null) {
                    if (this.initPos_ != null) {
                        this.initPos_ = VectorOuterClass.Vector.newBuilder(this.initPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.initPos_ = value;
                    }
                    onChanged();
                } else {
                    this.initPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearInitPos() {
                if (this.initPosBuilder_ == null) {
                    this.initPos_ = null;
                    onChanged();
                } else {
                    this.initPos_ = null;
                    this.initPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getInitPosBuilder() {
                onChanged();
                return getInitPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public VectorOuterClass.VectorOrBuilder getInitPosOrBuilder() {
                if (this.initPosBuilder_ != null) {
                    return this.initPosBuilder_.getMessageOrBuilder();
                }
                return this.initPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.initPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getInitPosFieldBuilder() {
                if (this.initPosBuilder_ == null) {
                    this.initPosBuilder_ = new SingleFieldBuilderV3<>(getInitPos(), getParentForChildren(), isClean());
                    this.initPos_ = null;
                }
                return this.initPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public boolean getIsPeerIdFromPlayer() {
                return this.isPeerIdFromPlayer_;
            }

            public Builder setIsPeerIdFromPlayer(boolean value) {
                this.isPeerIdFromPlayer_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsPeerIdFromPlayer() {
                this.isPeerIdFromPlayer_ = false;
                onChanged();
                return this;
            }

            private void ensureTargetLockPointIndexListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.targetLockPointIndexList_ = EvtCreateGadgetNotify.mutableCopy(this.targetLockPointIndexList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public List<Integer> getTargetLockPointIndexListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.targetLockPointIndexList_) : this.targetLockPointIndexList_;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public int getTargetLockPointIndexListCount() {
                return this.targetLockPointIndexList_.size();
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public int getTargetLockPointIndexList(int index) {
                return this.targetLockPointIndexList_.getInt(index);
            }

            public Builder setTargetLockPointIndexList(int index, int value) {
                ensureTargetLockPointIndexListIsMutable();
                this.targetLockPointIndexList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addTargetLockPointIndexList(int value) {
                ensureTargetLockPointIndexListIsMutable();
                this.targetLockPointIndexList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllTargetLockPointIndexList(Iterable<? extends Integer> values) {
                ensureTargetLockPointIndexListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.targetLockPointIndexList_);
                onChanged();
                return this;
            }

            public Builder clearTargetLockPointIndexList() {
                this.targetLockPointIndexList_ = EvtCreateGadgetNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public boolean getUnk3300EJNBIGLGMII() {
                return this.unk3300EJNBIGLGMII_;
            }

            public Builder setUnk3300EJNBIGLGMII(boolean value) {
                this.unk3300EJNBIGLGMII_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300EJNBIGLGMII() {
                this.unk3300EJNBIGLGMII_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public int getCampType() {
                return this.campType_;
            }

            public Builder setCampType(int value) {
                this.campType_ = value;
                onChanged();
                return this;
            }

            public Builder clearCampType() {
                this.campType_ = 0;
                onChanged();
                return this;
            }

            private void ensureTargetEntityIdListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.targetEntityIdList_ = EvtCreateGadgetNotify.mutableCopy(this.targetEntityIdList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public List<Integer> getTargetEntityIdListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.targetEntityIdList_) : this.targetEntityIdList_;
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public int getTargetEntityIdListCount() {
                return this.targetEntityIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotifyOrBuilder
            public int getTargetEntityIdList(int index) {
                return this.targetEntityIdList_.getInt(index);
            }

            public Builder setTargetEntityIdList(int index, int value) {
                ensureTargetEntityIdListIsMutable();
                this.targetEntityIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addTargetEntityIdList(int value) {
                ensureTargetEntityIdListIsMutable();
                this.targetEntityIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllTargetEntityIdList(Iterable<? extends Integer> values) {
                ensureTargetEntityIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.targetEntityIdList_);
                onChanged();
                return this;
            }

            public Builder clearTargetEntityIdList() {
                this.targetEntityIdList_ = EvtCreateGadgetNotify.emptyIntList();
                this.bitField0_ &= -3;
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

        public static EvtCreateGadgetNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EvtCreateGadgetNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EvtCreateGadgetNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EvtCreateGadgetNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
        ForwardTypeOuterClass.getDescriptor();
    }
}
