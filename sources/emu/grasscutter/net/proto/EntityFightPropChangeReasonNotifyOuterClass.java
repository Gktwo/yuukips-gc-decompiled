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
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ChangeEnergyReasonOuterClass;
import emu.grasscutter.net.proto.ChangeHpReasonOuterClass;
import emu.grasscutter.net.proto.PropChangeReasonOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityFightPropChangeReasonNotifyOuterClass.class */
public final class EntityFightPropChangeReasonNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n'EntityFightPropChangeReasonNotify.proto\u001a\u0016PropChangeReason.proto\u001a\u0014ChangeHpReason.proto\u001a\u0018ChangeEnergyReason.proto\"ê\u0001\n!EntityFightPropChangeReasonNotify\u0012\u0011\n\tpropDelta\u0018\u0004 \u0001(\u0002\u0012!\n\u0006reason\u0018\r \u0001(\u000e2\u0011.PropChangeReason\u0012\u0010\n\bentityId\u0018\f \u0001(\r\u0012\u0011\n\tparamList\u0018\u0001 \u0003(\r\u0012'\n\u000echangeHpReason\u0018\u0006 \u0001(\u000e2\u000f.ChangeHpReason\u0012/\n\u0012changeEnergyReason\u0018\u0003 \u0001(\u000e2\u0013.ChangeEnergyReason\u0012\u0010\n\bpropType\u0018\u000e \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PropChangeReasonOuterClass.getDescriptor(), ChangeHpReasonOuterClass.getDescriptor(), ChangeEnergyReasonOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EntityFightPropChangeReasonNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_EntityFightPropChangeReasonNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f693x7ed449ae = new GeneratedMessageV3.FieldAccessorTable(internal_static_EntityFightPropChangeReasonNotify_descriptor, new String[]{"PropDelta", "Reason", "EntityId", "ParamList", "ChangeHpReason", "ChangeEnergyReason", "PropType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityFightPropChangeReasonNotifyOuterClass$EntityFightPropChangeReasonNotifyOrBuilder.class */
    public interface EntityFightPropChangeReasonNotifyOrBuilder extends MessageOrBuilder {
        float getPropDelta();

        int getReasonValue();

        PropChangeReasonOuterClass.PropChangeReason getReason();

        int getEntityId();

        List<Integer> getParamListList();

        int getParamListCount();

        int getParamList(int i);

        int getChangeHpReasonValue();

        ChangeHpReasonOuterClass.ChangeHpReason getChangeHpReason();

        int getChangeEnergyReasonValue();

        ChangeEnergyReasonOuterClass.ChangeEnergyReason getChangeEnergyReason();

        int getPropType();
    }

    private EntityFightPropChangeReasonNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityFightPropChangeReasonNotifyOuterClass$EntityFightPropChangeReasonNotify.class */
    public static final class EntityFightPropChangeReasonNotify extends GeneratedMessageV3 implements EntityFightPropChangeReasonNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PROPDELTA_FIELD_NUMBER = 4;
        private float propDelta_;
        public static final int REASON_FIELD_NUMBER = 13;
        private int reason_;
        public static final int ENTITYID_FIELD_NUMBER = 12;
        private int entityId_;
        public static final int PARAMLIST_FIELD_NUMBER = 1;
        private Internal.IntList paramList_;
        private int paramListMemoizedSerializedSize;
        public static final int CHANGEHPREASON_FIELD_NUMBER = 6;
        private int changeHpReason_;
        public static final int CHANGEENERGYREASON_FIELD_NUMBER = 3;
        private int changeEnergyReason_;
        public static final int PROPTYPE_FIELD_NUMBER = 14;
        private int propType_;
        private byte memoizedIsInitialized;
        private static final EntityFightPropChangeReasonNotify DEFAULT_INSTANCE = new EntityFightPropChangeReasonNotify();
        private static final Parser<EntityFightPropChangeReasonNotify> PARSER = new AbstractParser<EntityFightPropChangeReasonNotify>() { // from class: emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotify.1
            @Override // com.google.protobuf.Parser
            public EntityFightPropChangeReasonNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntityFightPropChangeReasonNotify(input, extensionRegistry);
            }
        };

        private EntityFightPropChangeReasonNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.paramListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private EntityFightPropChangeReasonNotify() {
            this.paramListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.reason_ = 0;
            this.paramList_ = emptyIntList();
            this.changeHpReason_ = 0;
            this.changeEnergyReason_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EntityFightPropChangeReasonNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EntityFightPropChangeReasonNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.paramList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.paramList_.addInt(input.readUInt32());
                                break;
                            case 10:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.paramList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.paramList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 24:
                                this.changeEnergyReason_ = input.readEnum();
                                break;
                            case 37:
                                this.propDelta_ = input.readFloat();
                                break;
                            case 48:
                                this.changeHpReason_ = input.readEnum();
                                break;
                            case 96:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 104:
                                this.reason_ = input.readEnum();
                                break;
                            case 112:
                                this.propType_ = input.readUInt32();
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
                    this.paramList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EntityFightPropChangeReasonNotifyOuterClass.internal_static_EntityFightPropChangeReasonNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntityFightPropChangeReasonNotifyOuterClass.f693x7ed449ae.ensureFieldAccessorsInitialized(EntityFightPropChangeReasonNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
        public float getPropDelta() {
            return this.propDelta_;
        }

        @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
        public int getReasonValue() {
            return this.reason_;
        }

        @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
        public PropChangeReasonOuterClass.PropChangeReason getReason() {
            PropChangeReasonOuterClass.PropChangeReason result = PropChangeReasonOuterClass.PropChangeReason.valueOf(this.reason_);
            return result == null ? PropChangeReasonOuterClass.PropChangeReason.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
        public List<Integer> getParamListList() {
            return this.paramList_;
        }

        @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
        public int getParamListCount() {
            return this.paramList_.size();
        }

        @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
        public int getParamList(int index) {
            return this.paramList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
        public int getChangeHpReasonValue() {
            return this.changeHpReason_;
        }

        @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
        public ChangeHpReasonOuterClass.ChangeHpReason getChangeHpReason() {
            ChangeHpReasonOuterClass.ChangeHpReason result = ChangeHpReasonOuterClass.ChangeHpReason.valueOf(this.changeHpReason_);
            return result == null ? ChangeHpReasonOuterClass.ChangeHpReason.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
        public int getChangeEnergyReasonValue() {
            return this.changeEnergyReason_;
        }

        @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
        public ChangeEnergyReasonOuterClass.ChangeEnergyReason getChangeEnergyReason() {
            ChangeEnergyReasonOuterClass.ChangeEnergyReason result = ChangeEnergyReasonOuterClass.ChangeEnergyReason.valueOf(this.changeEnergyReason_);
            return result == null ? ChangeEnergyReasonOuterClass.ChangeEnergyReason.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
        public int getPropType() {
            return this.propType_;
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
            if (getParamListList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.paramListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.paramList_.size(); i++) {
                output.writeUInt32NoTag(this.paramList_.getInt(i));
            }
            if (this.changeEnergyReason_ != ChangeEnergyReasonOuterClass.ChangeEnergyReason.CHANGE_ENERGY_REASON_NONE.getNumber()) {
                output.writeEnum(3, this.changeEnergyReason_);
            }
            if (this.propDelta_ != 0.0f) {
                output.writeFloat(4, this.propDelta_);
            }
            if (this.changeHpReason_ != ChangeHpReasonOuterClass.ChangeHpReason.CHANGE_HP_REASON_NONE.getNumber()) {
                output.writeEnum(6, this.changeHpReason_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(12, this.entityId_);
            }
            if (this.reason_ != PropChangeReasonOuterClass.PropChangeReason.PROP_CHANGE_REASON_NONE.getNumber()) {
                output.writeEnum(13, this.reason_);
            }
            if (this.propType_ != 0) {
                output.writeUInt32(14, this.propType_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.paramList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.paramList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getParamListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.paramListMemoizedSerializedSize = dataSize;
            if (this.changeEnergyReason_ != ChangeEnergyReasonOuterClass.ChangeEnergyReason.CHANGE_ENERGY_REASON_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(3, this.changeEnergyReason_);
            }
            if (this.propDelta_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(4, this.propDelta_);
            }
            if (this.changeHpReason_ != ChangeHpReasonOuterClass.ChangeHpReason.CHANGE_HP_REASON_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(6, this.changeHpReason_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.entityId_);
            }
            if (this.reason_ != PropChangeReasonOuterClass.PropChangeReason.PROP_CHANGE_REASON_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(13, this.reason_);
            }
            if (this.propType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.propType_);
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
            if (!(obj instanceof EntityFightPropChangeReasonNotify)) {
                return equals(obj);
            }
            EntityFightPropChangeReasonNotify other = (EntityFightPropChangeReasonNotify) obj;
            return Float.floatToIntBits(getPropDelta()) == Float.floatToIntBits(other.getPropDelta()) && this.reason_ == other.reason_ && getEntityId() == other.getEntityId() && getParamListList().equals(other.getParamListList()) && this.changeHpReason_ == other.changeHpReason_ && this.changeEnergyReason_ == other.changeEnergyReason_ && getPropType() == other.getPropType() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + Float.floatToIntBits(getPropDelta()))) + 13)) + this.reason_)) + 12)) + getEntityId();
            if (getParamListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getParamListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 6)) + this.changeHpReason_)) + 3)) + this.changeEnergyReason_)) + 14)) + getPropType())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EntityFightPropChangeReasonNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityFightPropChangeReasonNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityFightPropChangeReasonNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityFightPropChangeReasonNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityFightPropChangeReasonNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityFightPropChangeReasonNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityFightPropChangeReasonNotify parseFrom(InputStream input) throws IOException {
            return (EntityFightPropChangeReasonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityFightPropChangeReasonNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityFightPropChangeReasonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityFightPropChangeReasonNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (EntityFightPropChangeReasonNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EntityFightPropChangeReasonNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityFightPropChangeReasonNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityFightPropChangeReasonNotify parseFrom(CodedInputStream input) throws IOException {
            return (EntityFightPropChangeReasonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityFightPropChangeReasonNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityFightPropChangeReasonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EntityFightPropChangeReasonNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityFightPropChangeReasonNotifyOuterClass$EntityFightPropChangeReasonNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EntityFightPropChangeReasonNotifyOrBuilder {
            private int bitField0_;
            private float propDelta_;
            private int entityId_;
            private int propType_;
            private int reason_ = 0;
            private Internal.IntList paramList_ = EntityFightPropChangeReasonNotify.emptyIntList();
            private int changeHpReason_ = 0;
            private int changeEnergyReason_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return EntityFightPropChangeReasonNotifyOuterClass.internal_static_EntityFightPropChangeReasonNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntityFightPropChangeReasonNotifyOuterClass.f693x7ed449ae.ensureFieldAccessorsInitialized(EntityFightPropChangeReasonNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EntityFightPropChangeReasonNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.propDelta_ = 0.0f;
                this.reason_ = 0;
                this.entityId_ = 0;
                this.paramList_ = EntityFightPropChangeReasonNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.changeHpReason_ = 0;
                this.changeEnergyReason_ = 0;
                this.propType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EntityFightPropChangeReasonNotifyOuterClass.internal_static_EntityFightPropChangeReasonNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EntityFightPropChangeReasonNotify getDefaultInstanceForType() {
                return EntityFightPropChangeReasonNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityFightPropChangeReasonNotify build() {
                EntityFightPropChangeReasonNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityFightPropChangeReasonNotify buildPartial() {
                EntityFightPropChangeReasonNotify result = new EntityFightPropChangeReasonNotify(this);
                int i = this.bitField0_;
                result.propDelta_ = this.propDelta_;
                result.reason_ = this.reason_;
                result.entityId_ = this.entityId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.paramList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.paramList_ = this.paramList_;
                result.changeHpReason_ = this.changeHpReason_;
                result.changeEnergyReason_ = this.changeEnergyReason_;
                result.propType_ = this.propType_;
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
                if (other instanceof EntityFightPropChangeReasonNotify) {
                    return mergeFrom((EntityFightPropChangeReasonNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EntityFightPropChangeReasonNotify other) {
                if (other == EntityFightPropChangeReasonNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getPropDelta() != 0.0f) {
                    setPropDelta(other.getPropDelta());
                }
                if (other.reason_ != 0) {
                    setReasonValue(other.getReasonValue());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (!other.paramList_.isEmpty()) {
                    if (this.paramList_.isEmpty()) {
                        this.paramList_ = other.paramList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureParamListIsMutable();
                        this.paramList_.addAll(other.paramList_);
                    }
                    onChanged();
                }
                if (other.changeHpReason_ != 0) {
                    setChangeHpReasonValue(other.getChangeHpReasonValue());
                }
                if (other.changeEnergyReason_ != 0) {
                    setChangeEnergyReasonValue(other.getChangeEnergyReasonValue());
                }
                if (other.getPropType() != 0) {
                    setPropType(other.getPropType());
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
                EntityFightPropChangeReasonNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = EntityFightPropChangeReasonNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EntityFightPropChangeReasonNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
            public float getPropDelta() {
                return this.propDelta_;
            }

            public Builder setPropDelta(float value) {
                this.propDelta_ = value;
                onChanged();
                return this;
            }

            public Builder clearPropDelta() {
                this.propDelta_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
            public int getReasonValue() {
                return this.reason_;
            }

            public Builder setReasonValue(int value) {
                this.reason_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
            public PropChangeReasonOuterClass.PropChangeReason getReason() {
                PropChangeReasonOuterClass.PropChangeReason result = PropChangeReasonOuterClass.PropChangeReason.valueOf(this.reason_);
                return result == null ? PropChangeReasonOuterClass.PropChangeReason.UNRECOGNIZED : result;
            }

            public Builder setReason(PropChangeReasonOuterClass.PropChangeReason value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.reason_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
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

            private void ensureParamListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.paramList_ = EntityFightPropChangeReasonNotify.mutableCopy(this.paramList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
            public List<Integer> getParamListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.paramList_) : this.paramList_;
            }

            @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
            public int getParamListCount() {
                return this.paramList_.size();
            }

            @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
            public int getParamList(int index) {
                return this.paramList_.getInt(index);
            }

            public Builder setParamList(int index, int value) {
                ensureParamListIsMutable();
                this.paramList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addParamList(int value) {
                ensureParamListIsMutable();
                this.paramList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllParamList(Iterable<? extends Integer> values) {
                ensureParamListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.paramList_);
                onChanged();
                return this;
            }

            public Builder clearParamList() {
                this.paramList_ = EntityFightPropChangeReasonNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
            public int getChangeHpReasonValue() {
                return this.changeHpReason_;
            }

            public Builder setChangeHpReasonValue(int value) {
                this.changeHpReason_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
            public ChangeHpReasonOuterClass.ChangeHpReason getChangeHpReason() {
                ChangeHpReasonOuterClass.ChangeHpReason result = ChangeHpReasonOuterClass.ChangeHpReason.valueOf(this.changeHpReason_);
                return result == null ? ChangeHpReasonOuterClass.ChangeHpReason.UNRECOGNIZED : result;
            }

            public Builder setChangeHpReason(ChangeHpReasonOuterClass.ChangeHpReason value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.changeHpReason_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearChangeHpReason() {
                this.changeHpReason_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
            public int getChangeEnergyReasonValue() {
                return this.changeEnergyReason_;
            }

            public Builder setChangeEnergyReasonValue(int value) {
                this.changeEnergyReason_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
            public ChangeEnergyReasonOuterClass.ChangeEnergyReason getChangeEnergyReason() {
                ChangeEnergyReasonOuterClass.ChangeEnergyReason result = ChangeEnergyReasonOuterClass.ChangeEnergyReason.valueOf(this.changeEnergyReason_);
                return result == null ? ChangeEnergyReasonOuterClass.ChangeEnergyReason.UNRECOGNIZED : result;
            }

            public Builder setChangeEnergyReason(ChangeEnergyReasonOuterClass.ChangeEnergyReason value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.changeEnergyReason_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearChangeEnergyReason() {
                this.changeEnergyReason_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotifyOrBuilder
            public int getPropType() {
                return this.propType_;
            }

            public Builder setPropType(int value) {
                this.propType_ = value;
                onChanged();
                return this;
            }

            public Builder clearPropType() {
                this.propType_ = 0;
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

        public static EntityFightPropChangeReasonNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EntityFightPropChangeReasonNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EntityFightPropChangeReasonNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EntityFightPropChangeReasonNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PropChangeReasonOuterClass.getDescriptor();
        ChangeHpReasonOuterClass.getDescriptor();
        ChangeEnergyReasonOuterClass.getDescriptor();
    }
}
