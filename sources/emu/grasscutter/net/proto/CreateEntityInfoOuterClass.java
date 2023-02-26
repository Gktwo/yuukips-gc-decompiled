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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateEntityInfoOuterClass.class */
public final class CreateEntityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016CreateEntityInfo.proto\u001a\fVector.proto\"à\u0001\n\u0010CreateEntityInfo\u0012\u0014\n\nmonster_id\u0018\u0001 \u0001(\rH��\u0012\u0010\n\u0006npc_id\u0018\u0002 \u0001(\rH��\u0012\u0013\n\tgadget_id\u0018\u0003 \u0001(\rH��\u0012\u0011\n\u0007item_id\u0018\u0004 \u0001(\rH��\u0012\r\n\u0005level\u0018\u0005 \u0001(\r\u0012\u0014\n\u0003pos\u0018\u0006 \u0001(\u000b2\u0007.Vector\u0012\u0014\n\u0003rot\u0018\u0007 \u0001(\u000b2\u0007.Vector\u0012\u000f\n\u0007sceneId\u0018\n \u0001(\r\u0012\u000e\n\u0006roomId\u0018\u000b \u0001(\r\u0012\u0016\n\u000eclientUniqueId\u0018\f \u0001(\rB\b\n\u0006entityB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CreateEntityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CreateEntityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CreateEntityInfo_descriptor, new String[]{"MonsterId", "NpcId", "GadgetId", "ItemId", "Level", "Pos", "Rot", "SceneId", "RoomId", "ClientUniqueId", "Entity"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateEntityInfoOuterClass$CreateEntityInfoOrBuilder.class */
    public interface CreateEntityInfoOrBuilder extends MessageOrBuilder {
        boolean hasMonsterId();

        int getMonsterId();

        boolean hasNpcId();

        int getNpcId();

        boolean hasGadgetId();

        int getGadgetId();

        boolean hasItemId();

        int getItemId();

        int getLevel();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        boolean hasRot();

        VectorOuterClass.Vector getRot();

        VectorOuterClass.VectorOrBuilder getRotOrBuilder();

        int getSceneId();

        int getRoomId();

        int getClientUniqueId();

        CreateEntityInfo.EntityCase getEntityCase();
    }

    private CreateEntityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateEntityInfoOuterClass$CreateEntityInfo.class */
    public static final class CreateEntityInfo extends GeneratedMessageV3 implements CreateEntityInfoOrBuilder {
        private static final long serialVersionUID = 0;
        private int entityCase_;
        private Object entity_;
        public static final int MONSTER_ID_FIELD_NUMBER = 1;
        public static final int NPC_ID_FIELD_NUMBER = 2;
        public static final int GADGET_ID_FIELD_NUMBER = 3;
        public static final int ITEM_ID_FIELD_NUMBER = 4;
        public static final int LEVEL_FIELD_NUMBER = 5;
        private int level_;
        public static final int POS_FIELD_NUMBER = 6;
        private VectorOuterClass.Vector pos_;
        public static final int ROT_FIELD_NUMBER = 7;
        private VectorOuterClass.Vector rot_;
        public static final int SCENEID_FIELD_NUMBER = 10;
        private int sceneId_;
        public static final int ROOMID_FIELD_NUMBER = 11;
        private int roomId_;
        public static final int CLIENTUNIQUEID_FIELD_NUMBER = 12;
        private int clientUniqueId_;
        private byte memoizedIsInitialized;
        private static final CreateEntityInfo DEFAULT_INSTANCE = new CreateEntityInfo();
        private static final Parser<CreateEntityInfo> PARSER = new AbstractParser<CreateEntityInfo>() { // from class: emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfo.1
            @Override // com.google.protobuf.Parser
            public CreateEntityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CreateEntityInfo(input, extensionRegistry);
            }
        };

        private CreateEntityInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.entityCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private CreateEntityInfo() {
            this.entityCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CreateEntityInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CreateEntityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.entityCase_ = 1;
                                this.entity_ = Integer.valueOf(input.readUInt32());
                                break;
                            case 16:
                                this.entityCase_ = 2;
                                this.entity_ = Integer.valueOf(input.readUInt32());
                                break;
                            case 24:
                                this.entityCase_ = 3;
                                this.entity_ = Integer.valueOf(input.readUInt32());
                                break;
                            case 32:
                                this.entityCase_ = 4;
                                this.entity_ = Integer.valueOf(input.readUInt32());
                                break;
                            case 40:
                                this.level_ = input.readUInt32();
                                break;
                            case 50:
                                VectorOuterClass.Vector.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.pos_);
                                    this.pos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 58:
                                VectorOuterClass.Vector.Builder subBuilder2 = this.rot_ != null ? this.rot_.toBuilder() : null;
                                this.rot_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.rot_);
                                    this.rot_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 80:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 88:
                                this.roomId_ = input.readUInt32();
                                break;
                            case 96:
                                this.clientUniqueId_ = input.readUInt32();
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
            return CreateEntityInfoOuterClass.internal_static_CreateEntityInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CreateEntityInfoOuterClass.internal_static_CreateEntityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CreateEntityInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateEntityInfoOuterClass$CreateEntityInfo$EntityCase.class */
        public enum EntityCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            MONSTER_ID(1),
            NPC_ID(2),
            GADGET_ID(3),
            ITEM_ID(4),
            ENTITY_NOT_SET(0);
            
            private final int value;

            EntityCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static EntityCase valueOf(int value) {
                return forNumber(value);
            }

            public static EntityCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return ENTITY_NOT_SET;
                    case 1:
                        return MONSTER_ID;
                    case 2:
                        return NPC_ID;
                    case 3:
                        return GADGET_ID;
                    case 4:
                        return ITEM_ID;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public EntityCase getEntityCase() {
            return EntityCase.forNumber(this.entityCase_);
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public boolean hasMonsterId() {
            return this.entityCase_ == 1;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public int getMonsterId() {
            if (this.entityCase_ == 1) {
                return ((Integer) this.entity_).intValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public boolean hasNpcId() {
            return this.entityCase_ == 2;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public int getNpcId() {
            if (this.entityCase_ == 2) {
                return ((Integer) this.entity_).intValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public boolean hasGadgetId() {
            return this.entityCase_ == 3;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public int getGadgetId() {
            if (this.entityCase_ == 3) {
                return ((Integer) this.entity_).intValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public boolean hasItemId() {
            return this.entityCase_ == 4;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public int getItemId() {
            if (this.entityCase_ == 4) {
                return ((Integer) this.entity_).intValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public boolean hasRot() {
            return this.rot_ != null;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public VectorOuterClass.Vector getRot() {
            return this.rot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rot_;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getRotOrBuilder() {
            return getRot();
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public int getRoomId() {
            return this.roomId_;
        }

        @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
        public int getClientUniqueId() {
            return this.clientUniqueId_;
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
            if (this.entityCase_ == 1) {
                output.writeUInt32(1, ((Integer) this.entity_).intValue());
            }
            if (this.entityCase_ == 2) {
                output.writeUInt32(2, ((Integer) this.entity_).intValue());
            }
            if (this.entityCase_ == 3) {
                output.writeUInt32(3, ((Integer) this.entity_).intValue());
            }
            if (this.entityCase_ == 4) {
                output.writeUInt32(4, ((Integer) this.entity_).intValue());
            }
            if (this.level_ != 0) {
                output.writeUInt32(5, this.level_);
            }
            if (this.pos_ != null) {
                output.writeMessage(6, getPos());
            }
            if (this.rot_ != null) {
                output.writeMessage(7, getRot());
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(10, this.sceneId_);
            }
            if (this.roomId_ != 0) {
                output.writeUInt32(11, this.roomId_);
            }
            if (this.clientUniqueId_ != 0) {
                output.writeUInt32(12, this.clientUniqueId_);
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
            if (this.entityCase_ == 1) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, ((Integer) this.entity_).intValue());
            }
            if (this.entityCase_ == 2) {
                size2 += CodedOutputStream.computeUInt32Size(2, ((Integer) this.entity_).intValue());
            }
            if (this.entityCase_ == 3) {
                size2 += CodedOutputStream.computeUInt32Size(3, ((Integer) this.entity_).intValue());
            }
            if (this.entityCase_ == 4) {
                size2 += CodedOutputStream.computeUInt32Size(4, ((Integer) this.entity_).intValue());
            }
            if (this.level_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.level_);
            }
            if (this.pos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getPos());
            }
            if (this.rot_ != null) {
                size2 += CodedOutputStream.computeMessageSize(7, getRot());
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.sceneId_);
            }
            if (this.roomId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.roomId_);
            }
            if (this.clientUniqueId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.clientUniqueId_);
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
            if (!(obj instanceof CreateEntityInfo)) {
                return equals(obj);
            }
            CreateEntityInfo other = (CreateEntityInfo) obj;
            if (getLevel() != other.getLevel() || hasPos() != other.hasPos()) {
                return false;
            }
            if ((hasPos() && !getPos().equals(other.getPos())) || hasRot() != other.hasRot()) {
                return false;
            }
            if ((hasRot() && !getRot().equals(other.getRot())) || getSceneId() != other.getSceneId() || getRoomId() != other.getRoomId() || getClientUniqueId() != other.getClientUniqueId() || !getEntityCase().equals(other.getEntityCase())) {
                return false;
            }
            switch (this.entityCase_) {
                case 1:
                    if (getMonsterId() != other.getMonsterId()) {
                        return false;
                    }
                    break;
                case 2:
                    if (getNpcId() != other.getNpcId()) {
                        return false;
                    }
                    break;
                case 3:
                    if (getGadgetId() != other.getGadgetId()) {
                        return false;
                    }
                    break;
                case 4:
                    if (getItemId() != other.getItemId()) {
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
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getLevel();
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 6)) + getPos().hashCode();
            }
            if (hasRot()) {
                hash = (53 * ((37 * hash) + 7)) + getRot().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 10)) + getSceneId())) + 11)) + getRoomId())) + 12)) + getClientUniqueId();
            switch (this.entityCase_) {
                case 1:
                    hash2 = (53 * ((37 * hash2) + 1)) + getMonsterId();
                    break;
                case 2:
                    hash2 = (53 * ((37 * hash2) + 2)) + getNpcId();
                    break;
                case 3:
                    hash2 = (53 * ((37 * hash2) + 3)) + getGadgetId();
                    break;
                case 4:
                    hash2 = (53 * ((37 * hash2) + 4)) + getItemId();
                    break;
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static CreateEntityInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CreateEntityInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CreateEntityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CreateEntityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CreateEntityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CreateEntityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CreateEntityInfo parseFrom(InputStream input) throws IOException {
            return (CreateEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CreateEntityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CreateEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CreateEntityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CreateEntityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CreateEntityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CreateEntityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CreateEntityInfo parseFrom(CodedInputStream input) throws IOException {
            return (CreateEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CreateEntityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CreateEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CreateEntityInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateEntityInfoOuterClass$CreateEntityInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CreateEntityInfoOrBuilder {
            private int entityCase_ = 0;
            private Object entity_;
            private int level_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private VectorOuterClass.Vector rot_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> rotBuilder_;
            private int sceneId_;
            private int roomId_;
            private int clientUniqueId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CreateEntityInfoOuterClass.internal_static_CreateEntityInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CreateEntityInfoOuterClass.internal_static_CreateEntityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CreateEntityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CreateEntityInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.level_ = 0;
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
                this.sceneId_ = 0;
                this.roomId_ = 0;
                this.clientUniqueId_ = 0;
                this.entityCase_ = 0;
                this.entity_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CreateEntityInfoOuterClass.internal_static_CreateEntityInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CreateEntityInfo getDefaultInstanceForType() {
                return CreateEntityInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CreateEntityInfo build() {
                CreateEntityInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CreateEntityInfo buildPartial() {
                CreateEntityInfo result = new CreateEntityInfo(this);
                if (this.entityCase_ == 1) {
                    result.entity_ = this.entity_;
                }
                if (this.entityCase_ == 2) {
                    result.entity_ = this.entity_;
                }
                if (this.entityCase_ == 3) {
                    result.entity_ = this.entity_;
                }
                if (this.entityCase_ == 4) {
                    result.entity_ = this.entity_;
                }
                result.level_ = this.level_;
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
                result.sceneId_ = this.sceneId_;
                result.roomId_ = this.roomId_;
                result.clientUniqueId_ = this.clientUniqueId_;
                result.entityCase_ = this.entityCase_;
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
                if (other instanceof CreateEntityInfo) {
                    return mergeFrom((CreateEntityInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CreateEntityInfo other) {
                if (other == CreateEntityInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.hasRot()) {
                    mergeRot(other.getRot());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (other.getRoomId() != 0) {
                    setRoomId(other.getRoomId());
                }
                if (other.getClientUniqueId() != 0) {
                    setClientUniqueId(other.getClientUniqueId());
                }
                switch (other.getEntityCase()) {
                    case MONSTER_ID:
                        setMonsterId(other.getMonsterId());
                        break;
                    case NPC_ID:
                        setNpcId(other.getNpcId());
                        break;
                    case GADGET_ID:
                        setGadgetId(other.getGadgetId());
                        break;
                    case ITEM_ID:
                        setItemId(other.getItemId());
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
                CreateEntityInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CreateEntityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CreateEntityInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
            public EntityCase getEntityCase() {
                return EntityCase.forNumber(this.entityCase_);
            }

            public Builder clearEntity() {
                this.entityCase_ = 0;
                this.entity_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
            public boolean hasMonsterId() {
                return this.entityCase_ == 1;
            }

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
            public int getMonsterId() {
                if (this.entityCase_ == 1) {
                    return ((Integer) this.entity_).intValue();
                }
                return 0;
            }

            public Builder setMonsterId(int value) {
                this.entityCase_ = 1;
                this.entity_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearMonsterId() {
                if (this.entityCase_ == 1) {
                    this.entityCase_ = 0;
                    this.entity_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
            public boolean hasNpcId() {
                return this.entityCase_ == 2;
            }

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
            public int getNpcId() {
                if (this.entityCase_ == 2) {
                    return ((Integer) this.entity_).intValue();
                }
                return 0;
            }

            public Builder setNpcId(int value) {
                this.entityCase_ = 2;
                this.entity_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearNpcId() {
                if (this.entityCase_ == 2) {
                    this.entityCase_ = 0;
                    this.entity_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
            public boolean hasGadgetId() {
                return this.entityCase_ == 3;
            }

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
            public int getGadgetId() {
                if (this.entityCase_ == 3) {
                    return ((Integer) this.entity_).intValue();
                }
                return 0;
            }

            public Builder setGadgetId(int value) {
                this.entityCase_ = 3;
                this.entity_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearGadgetId() {
                if (this.entityCase_ == 3) {
                    this.entityCase_ = 0;
                    this.entity_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
            public boolean hasItemId() {
                return this.entityCase_ == 4;
            }

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
            public int getItemId() {
                if (this.entityCase_ == 4) {
                    return ((Integer) this.entity_).intValue();
                }
                return 0;
            }

            public Builder setItemId(int value) {
                this.entityCase_ = 4;
                this.entity_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearItemId() {
                if (this.entityCase_ == 4) {
                    this.entityCase_ = 0;
                    this.entity_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.level_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
            public boolean hasRot() {
                return (this.rotBuilder_ == null && this.rot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder
            public int getClientUniqueId() {
                return this.clientUniqueId_;
            }

            public Builder setClientUniqueId(int value) {
                this.clientUniqueId_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientUniqueId() {
                this.clientUniqueId_ = 0;
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

        public static CreateEntityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CreateEntityInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CreateEntityInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CreateEntityInfo getDefaultInstanceForType() {
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
