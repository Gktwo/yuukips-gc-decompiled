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
import emu.grasscutter.net.proto.SceneReliquaryInfoOuterClass;
import emu.grasscutter.net.proto.SceneWeaponInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEquipChangeNotifyOuterClass.class */
public final class AvatarEquipChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dAvatarEquipChangeNotify.proto\u001a\u0018SceneReliquaryInfo.proto\u001a\u0015SceneWeaponInfo.proto\"­\u0001\n\u0017AvatarEquipChangeNotify\u0012\u000e\n\u0006itemId\u0018\u0002 \u0001(\r\u0012\u0011\n\tequipGuid\u0018\u000b \u0001(\u0004\u0012\u0011\n\tequipType\u0018\f \u0001(\r\u0012&\n\treliquary\u0018\r \u0001(\u000b2\u0013.SceneReliquaryInfo\u0012\u0012\n\navatarGuid\u0018\u000f \u0001(\u0004\u0012 \n\u0006weapon\u0018\n \u0001(\u000b2\u0010.SceneWeaponInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SceneReliquaryInfoOuterClass.getDescriptor(), SceneWeaponInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarEquipChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarEquipChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarEquipChangeNotify_descriptor, new String[]{"ItemId", "EquipGuid", "EquipType", "Reliquary", "AvatarGuid", "Weapon"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEquipChangeNotifyOuterClass$AvatarEquipChangeNotifyOrBuilder.class */
    public interface AvatarEquipChangeNotifyOrBuilder extends MessageOrBuilder {
        int getItemId();

        long getEquipGuid();

        int getEquipType();

        boolean hasReliquary();

        SceneReliquaryInfoOuterClass.SceneReliquaryInfo getReliquary();

        SceneReliquaryInfoOuterClass.SceneReliquaryInfoOrBuilder getReliquaryOrBuilder();

        long getAvatarGuid();

        boolean hasWeapon();

        SceneWeaponInfoOuterClass.SceneWeaponInfo getWeapon();

        SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder getWeaponOrBuilder();
    }

    private AvatarEquipChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEquipChangeNotifyOuterClass$AvatarEquipChangeNotify.class */
    public static final class AvatarEquipChangeNotify extends GeneratedMessageV3 implements AvatarEquipChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ITEMID_FIELD_NUMBER = 2;
        private int itemId_;
        public static final int EQUIPGUID_FIELD_NUMBER = 11;
        private long equipGuid_;
        public static final int EQUIPTYPE_FIELD_NUMBER = 12;
        private int equipType_;
        public static final int RELIQUARY_FIELD_NUMBER = 13;
        private SceneReliquaryInfoOuterClass.SceneReliquaryInfo reliquary_;
        public static final int AVATARGUID_FIELD_NUMBER = 15;
        private long avatarGuid_;
        public static final int WEAPON_FIELD_NUMBER = 10;
        private SceneWeaponInfoOuterClass.SceneWeaponInfo weapon_;
        private byte memoizedIsInitialized;
        private static final AvatarEquipChangeNotify DEFAULT_INSTANCE = new AvatarEquipChangeNotify();
        private static final Parser<AvatarEquipChangeNotify> PARSER = new AbstractParser<AvatarEquipChangeNotify>() { // from class: emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarEquipChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarEquipChangeNotify(input, extensionRegistry);
            }
        };

        private AvatarEquipChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarEquipChangeNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarEquipChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarEquipChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.itemId_ = input.readUInt32();
                                break;
                            case 82:
                                SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder subBuilder = this.weapon_ != null ? this.weapon_.toBuilder() : null;
                                this.weapon_ = (SceneWeaponInfoOuterClass.SceneWeaponInfo) input.readMessage(SceneWeaponInfoOuterClass.SceneWeaponInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.weapon_);
                                    this.weapon_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 88:
                                this.equipGuid_ = input.readUInt64();
                                break;
                            case 96:
                                this.equipType_ = input.readUInt32();
                                break;
                            case 106:
                                SceneReliquaryInfoOuterClass.SceneReliquaryInfo.Builder subBuilder2 = this.reliquary_ != null ? this.reliquary_.toBuilder() : null;
                                this.reliquary_ = (SceneReliquaryInfoOuterClass.SceneReliquaryInfo) input.readMessage(SceneReliquaryInfoOuterClass.SceneReliquaryInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.reliquary_);
                                    this.reliquary_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 120:
                                this.avatarGuid_ = input.readUInt64();
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
            return AvatarEquipChangeNotifyOuterClass.internal_static_AvatarEquipChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarEquipChangeNotifyOuterClass.internal_static_AvatarEquipChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarEquipChangeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
        public int getItemId() {
            return this.itemId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
        public long getEquipGuid() {
            return this.equipGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
        public int getEquipType() {
            return this.equipType_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
        public boolean hasReliquary() {
            return this.reliquary_ != null;
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
        public SceneReliquaryInfoOuterClass.SceneReliquaryInfo getReliquary() {
            return this.reliquary_ == null ? SceneReliquaryInfoOuterClass.SceneReliquaryInfo.getDefaultInstance() : this.reliquary_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
        public SceneReliquaryInfoOuterClass.SceneReliquaryInfoOrBuilder getReliquaryOrBuilder() {
            return getReliquary();
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
        public boolean hasWeapon() {
            return this.weapon_ != null;
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
        public SceneWeaponInfoOuterClass.SceneWeaponInfo getWeapon() {
            return this.weapon_ == null ? SceneWeaponInfoOuterClass.SceneWeaponInfo.getDefaultInstance() : this.weapon_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
        public SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder getWeaponOrBuilder() {
            return getWeapon();
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
            if (this.itemId_ != 0) {
                output.writeUInt32(2, this.itemId_);
            }
            if (this.weapon_ != null) {
                output.writeMessage(10, getWeapon());
            }
            if (this.equipGuid_ != 0) {
                output.writeUInt64(11, this.equipGuid_);
            }
            if (this.equipType_ != 0) {
                output.writeUInt32(12, this.equipType_);
            }
            if (this.reliquary_ != null) {
                output.writeMessage(13, getReliquary());
            }
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(15, this.avatarGuid_);
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
            if (this.itemId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.itemId_);
            }
            if (this.weapon_ != null) {
                size2 += CodedOutputStream.computeMessageSize(10, getWeapon());
            }
            if (this.equipGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(11, this.equipGuid_);
            }
            if (this.equipType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.equipType_);
            }
            if (this.reliquary_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getReliquary());
            }
            if (this.avatarGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(15, this.avatarGuid_);
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
            if (!(obj instanceof AvatarEquipChangeNotify)) {
                return equals(obj);
            }
            AvatarEquipChangeNotify other = (AvatarEquipChangeNotify) obj;
            if (getItemId() != other.getItemId() || getEquipGuid() != other.getEquipGuid() || getEquipType() != other.getEquipType() || hasReliquary() != other.hasReliquary()) {
                return false;
            }
            if ((!hasReliquary() || getReliquary().equals(other.getReliquary())) && getAvatarGuid() == other.getAvatarGuid() && hasWeapon() == other.hasWeapon()) {
                return (!hasWeapon() || getWeapon().equals(other.getWeapon())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getItemId())) + 11)) + Internal.hashLong(getEquipGuid()))) + 12)) + getEquipType();
            if (hasReliquary()) {
                hash = (53 * ((37 * hash) + 13)) + getReliquary().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 15)) + Internal.hashLong(getAvatarGuid());
            if (hasWeapon()) {
                hash2 = (53 * ((37 * hash2) + 10)) + getWeapon().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static AvatarEquipChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarEquipChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarEquipChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarEquipChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarEquipChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarEquipChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarEquipChangeNotify parseFrom(InputStream input) throws IOException {
            return (AvatarEquipChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarEquipChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarEquipChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarEquipChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarEquipChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarEquipChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarEquipChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarEquipChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarEquipChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarEquipChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarEquipChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarEquipChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEquipChangeNotifyOuterClass$AvatarEquipChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarEquipChangeNotifyOrBuilder {
            private int itemId_;
            private long equipGuid_;
            private int equipType_;
            private SceneReliquaryInfoOuterClass.SceneReliquaryInfo reliquary_;
            private SingleFieldBuilderV3<SceneReliquaryInfoOuterClass.SceneReliquaryInfo, SceneReliquaryInfoOuterClass.SceneReliquaryInfo.Builder, SceneReliquaryInfoOuterClass.SceneReliquaryInfoOrBuilder> reliquaryBuilder_;
            private long avatarGuid_;
            private SceneWeaponInfoOuterClass.SceneWeaponInfo weapon_;
            private SingleFieldBuilderV3<SceneWeaponInfoOuterClass.SceneWeaponInfo, SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder, SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder> weaponBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarEquipChangeNotifyOuterClass.internal_static_AvatarEquipChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarEquipChangeNotifyOuterClass.internal_static_AvatarEquipChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarEquipChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarEquipChangeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.itemId_ = 0;
                this.equipGuid_ = 0;
                this.equipType_ = 0;
                if (this.reliquaryBuilder_ == null) {
                    this.reliquary_ = null;
                } else {
                    this.reliquary_ = null;
                    this.reliquaryBuilder_ = null;
                }
                this.avatarGuid_ = 0;
                if (this.weaponBuilder_ == null) {
                    this.weapon_ = null;
                } else {
                    this.weapon_ = null;
                    this.weaponBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarEquipChangeNotifyOuterClass.internal_static_AvatarEquipChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarEquipChangeNotify getDefaultInstanceForType() {
                return AvatarEquipChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarEquipChangeNotify build() {
                AvatarEquipChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarEquipChangeNotify buildPartial() {
                AvatarEquipChangeNotify result = new AvatarEquipChangeNotify(this);
                result.itemId_ = this.itemId_;
                result.equipGuid_ = this.equipGuid_;
                result.equipType_ = this.equipType_;
                if (this.reliquaryBuilder_ == null) {
                    result.reliquary_ = this.reliquary_;
                } else {
                    result.reliquary_ = this.reliquaryBuilder_.build();
                }
                result.avatarGuid_ = this.avatarGuid_;
                if (this.weaponBuilder_ == null) {
                    result.weapon_ = this.weapon_;
                } else {
                    result.weapon_ = this.weaponBuilder_.build();
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
                if (other instanceof AvatarEquipChangeNotify) {
                    return mergeFrom((AvatarEquipChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarEquipChangeNotify other) {
                if (other == AvatarEquipChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getItemId() != 0) {
                    setItemId(other.getItemId());
                }
                if (other.getEquipGuid() != 0) {
                    setEquipGuid(other.getEquipGuid());
                }
                if (other.getEquipType() != 0) {
                    setEquipType(other.getEquipType());
                }
                if (other.hasReliquary()) {
                    mergeReliquary(other.getReliquary());
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (other.hasWeapon()) {
                    mergeWeapon(other.getWeapon());
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
                AvatarEquipChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarEquipChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarEquipChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
            public int getItemId() {
                return this.itemId_;
            }

            public Builder setItemId(int value) {
                this.itemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemId() {
                this.itemId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
            public long getEquipGuid() {
                return this.equipGuid_;
            }

            public Builder setEquipGuid(long value) {
                this.equipGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearEquipGuid() {
                this.equipGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
            public int getEquipType() {
                return this.equipType_;
            }

            public Builder setEquipType(int value) {
                this.equipType_ = value;
                onChanged();
                return this;
            }

            public Builder clearEquipType() {
                this.equipType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
            public boolean hasReliquary() {
                return (this.reliquaryBuilder_ == null && this.reliquary_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
            public SceneReliquaryInfoOuterClass.SceneReliquaryInfo getReliquary() {
                if (this.reliquaryBuilder_ == null) {
                    return this.reliquary_ == null ? SceneReliquaryInfoOuterClass.SceneReliquaryInfo.getDefaultInstance() : this.reliquary_;
                }
                return this.reliquaryBuilder_.getMessage();
            }

            public Builder setReliquary(SceneReliquaryInfoOuterClass.SceneReliquaryInfo value) {
                if (this.reliquaryBuilder_ != null) {
                    this.reliquaryBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.reliquary_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setReliquary(SceneReliquaryInfoOuterClass.SceneReliquaryInfo.Builder builderForValue) {
                if (this.reliquaryBuilder_ == null) {
                    this.reliquary_ = builderForValue.build();
                    onChanged();
                } else {
                    this.reliquaryBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeReliquary(SceneReliquaryInfoOuterClass.SceneReliquaryInfo value) {
                if (this.reliquaryBuilder_ == null) {
                    if (this.reliquary_ != null) {
                        this.reliquary_ = SceneReliquaryInfoOuterClass.SceneReliquaryInfo.newBuilder(this.reliquary_).mergeFrom(value).buildPartial();
                    } else {
                        this.reliquary_ = value;
                    }
                    onChanged();
                } else {
                    this.reliquaryBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearReliquary() {
                if (this.reliquaryBuilder_ == null) {
                    this.reliquary_ = null;
                    onChanged();
                } else {
                    this.reliquary_ = null;
                    this.reliquaryBuilder_ = null;
                }
                return this;
            }

            public SceneReliquaryInfoOuterClass.SceneReliquaryInfo.Builder getReliquaryBuilder() {
                onChanged();
                return getReliquaryFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
            public SceneReliquaryInfoOuterClass.SceneReliquaryInfoOrBuilder getReliquaryOrBuilder() {
                if (this.reliquaryBuilder_ != null) {
                    return this.reliquaryBuilder_.getMessageOrBuilder();
                }
                return this.reliquary_ == null ? SceneReliquaryInfoOuterClass.SceneReliquaryInfo.getDefaultInstance() : this.reliquary_;
            }

            private SingleFieldBuilderV3<SceneReliquaryInfoOuterClass.SceneReliquaryInfo, SceneReliquaryInfoOuterClass.SceneReliquaryInfo.Builder, SceneReliquaryInfoOuterClass.SceneReliquaryInfoOrBuilder> getReliquaryFieldBuilder() {
                if (this.reliquaryBuilder_ == null) {
                    this.reliquaryBuilder_ = new SingleFieldBuilderV3<>(getReliquary(), getParentForChildren(), isClean());
                    this.reliquary_ = null;
                }
                return this.reliquaryBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
            public long getAvatarGuid() {
                return this.avatarGuid_;
            }

            public Builder setAvatarGuid(long value) {
                this.avatarGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarGuid() {
                this.avatarGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
            public boolean hasWeapon() {
                return (this.weaponBuilder_ == null && this.weapon_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
            public SceneWeaponInfoOuterClass.SceneWeaponInfo getWeapon() {
                if (this.weaponBuilder_ == null) {
                    return this.weapon_ == null ? SceneWeaponInfoOuterClass.SceneWeaponInfo.getDefaultInstance() : this.weapon_;
                }
                return this.weaponBuilder_.getMessage();
            }

            public Builder setWeapon(SceneWeaponInfoOuterClass.SceneWeaponInfo value) {
                if (this.weaponBuilder_ != null) {
                    this.weaponBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.weapon_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setWeapon(SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder builderForValue) {
                if (this.weaponBuilder_ == null) {
                    this.weapon_ = builderForValue.build();
                    onChanged();
                } else {
                    this.weaponBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeWeapon(SceneWeaponInfoOuterClass.SceneWeaponInfo value) {
                if (this.weaponBuilder_ == null) {
                    if (this.weapon_ != null) {
                        this.weapon_ = SceneWeaponInfoOuterClass.SceneWeaponInfo.newBuilder(this.weapon_).mergeFrom(value).buildPartial();
                    } else {
                        this.weapon_ = value;
                    }
                    onChanged();
                } else {
                    this.weaponBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearWeapon() {
                if (this.weaponBuilder_ == null) {
                    this.weapon_ = null;
                    onChanged();
                } else {
                    this.weapon_ = null;
                    this.weaponBuilder_ = null;
                }
                return this;
            }

            public SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder getWeaponBuilder() {
                onChanged();
                return getWeaponFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotifyOrBuilder
            public SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder getWeaponOrBuilder() {
                if (this.weaponBuilder_ != null) {
                    return this.weaponBuilder_.getMessageOrBuilder();
                }
                return this.weapon_ == null ? SceneWeaponInfoOuterClass.SceneWeaponInfo.getDefaultInstance() : this.weapon_;
            }

            private SingleFieldBuilderV3<SceneWeaponInfoOuterClass.SceneWeaponInfo, SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder, SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder> getWeaponFieldBuilder() {
                if (this.weaponBuilder_ == null) {
                    this.weaponBuilder_ = new SingleFieldBuilderV3<>(getWeapon(), getParentForChildren(), isClean());
                    this.weapon_ = null;
                }
                return this.weaponBuilder_;
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

        public static AvatarEquipChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarEquipChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarEquipChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarEquipChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SceneReliquaryInfoOuterClass.getDescriptor();
        SceneWeaponInfoOuterClass.getDescriptor();
    }
}
