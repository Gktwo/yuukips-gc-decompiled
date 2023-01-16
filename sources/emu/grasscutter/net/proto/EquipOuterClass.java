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
import emu.grasscutter.net.proto.ReliquaryOuterClass;
import emu.grasscutter.net.proto.WeaponOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipOuterClass.class */
public final class EquipOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000bEquip.proto\u001a\u000fReliquary.proto\u001a\fWeapon.proto\"`\n\u0005Equip\u0012\u0011\n\tis_locked\u0018\u0003 \u0001(\b\u0012\u001f\n\treliquary\u0018\u0001 \u0001(\u000b2\n.ReliquaryH��\u0012\u0019\n\u0006weapon\u0018\u0002 \u0001(\u000b2\u0007.WeaponH��B\b\n\u0006detailB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ReliquaryOuterClass.getDescriptor(), WeaponOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_Equip_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_Equip_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_Equip_descriptor, new String[]{"IsLocked", "Reliquary", "Weapon", "Detail"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipOuterClass$EquipOrBuilder.class */
    public interface EquipOrBuilder extends MessageOrBuilder {
        boolean getIsLocked();

        boolean hasReliquary();

        ReliquaryOuterClass.Reliquary getReliquary();

        ReliquaryOuterClass.ReliquaryOrBuilder getReliquaryOrBuilder();

        boolean hasWeapon();

        WeaponOuterClass.Weapon getWeapon();

        WeaponOuterClass.WeaponOrBuilder getWeaponOrBuilder();

        Equip.DetailCase getDetailCase();
    }

    private EquipOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipOuterClass$Equip.class */
    public static final class Equip extends GeneratedMessageV3 implements EquipOrBuilder {
        private static final long serialVersionUID = 0;
        private int detailCase_;
        private Object detail_;
        public static final int IS_LOCKED_FIELD_NUMBER = 3;
        private boolean isLocked_;
        public static final int RELIQUARY_FIELD_NUMBER = 1;
        public static final int WEAPON_FIELD_NUMBER = 2;
        private byte memoizedIsInitialized;
        private static final Equip DEFAULT_INSTANCE = new Equip();
        private static final Parser<Equip> PARSER = new AbstractParser<Equip>() { // from class: emu.grasscutter.net.proto.EquipOuterClass.Equip.1
            @Override // com.google.protobuf.Parser
            public Equip parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Equip(input, extensionRegistry);
            }
        };

        private Equip(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private Equip() {
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new Equip();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Equip(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                ReliquaryOuterClass.Reliquary.Builder subBuilder = this.detailCase_ == 1 ? ((ReliquaryOuterClass.Reliquary) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(ReliquaryOuterClass.Reliquary.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((ReliquaryOuterClass.Reliquary) this.detail_);
                                    this.detail_ = subBuilder.buildPartial();
                                }
                                this.detailCase_ = 1;
                                break;
                            case 18:
                                WeaponOuterClass.Weapon.Builder subBuilder2 = this.detailCase_ == 2 ? ((WeaponOuterClass.Weapon) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(WeaponOuterClass.Weapon.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((WeaponOuterClass.Weapon) this.detail_);
                                    this.detail_ = subBuilder2.buildPartial();
                                }
                                this.detailCase_ = 2;
                                break;
                            case 24:
                                this.isLocked_ = input.readBool();
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
            return EquipOuterClass.internal_static_Equip_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EquipOuterClass.internal_static_Equip_fieldAccessorTable.ensureFieldAccessorsInitialized(Equip.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipOuterClass$Equip$DetailCase.class */
        public enum DetailCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            RELIQUARY(1),
            WEAPON(2),
            DETAIL_NOT_SET(0);
            
            private final int value;

            DetailCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static DetailCase valueOf(int value) {
                return forNumber(value);
            }

            public static DetailCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return DETAIL_NOT_SET;
                    case 1:
                        return RELIQUARY;
                    case 2:
                        return WEAPON;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
        public DetailCase getDetailCase() {
            return DetailCase.forNumber(this.detailCase_);
        }

        @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
        public boolean getIsLocked() {
            return this.isLocked_;
        }

        @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
        public boolean hasReliquary() {
            return this.detailCase_ == 1;
        }

        @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
        public ReliquaryOuterClass.Reliquary getReliquary() {
            if (this.detailCase_ == 1) {
                return (ReliquaryOuterClass.Reliquary) this.detail_;
            }
            return ReliquaryOuterClass.Reliquary.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
        public ReliquaryOuterClass.ReliquaryOrBuilder getReliquaryOrBuilder() {
            if (this.detailCase_ == 1) {
                return (ReliquaryOuterClass.Reliquary) this.detail_;
            }
            return ReliquaryOuterClass.Reliquary.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
        public boolean hasWeapon() {
            return this.detailCase_ == 2;
        }

        @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
        public WeaponOuterClass.Weapon getWeapon() {
            if (this.detailCase_ == 2) {
                return (WeaponOuterClass.Weapon) this.detail_;
            }
            return WeaponOuterClass.Weapon.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
        public WeaponOuterClass.WeaponOrBuilder getWeaponOrBuilder() {
            if (this.detailCase_ == 2) {
                return (WeaponOuterClass.Weapon) this.detail_;
            }
            return WeaponOuterClass.Weapon.getDefaultInstance();
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
            if (this.detailCase_ == 1) {
                output.writeMessage(1, (ReliquaryOuterClass.Reliquary) this.detail_);
            }
            if (this.detailCase_ == 2) {
                output.writeMessage(2, (WeaponOuterClass.Weapon) this.detail_);
            }
            if (this.isLocked_) {
                output.writeBool(3, this.isLocked_);
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
            if (this.detailCase_ == 1) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, (ReliquaryOuterClass.Reliquary) this.detail_);
            }
            if (this.detailCase_ == 2) {
                size2 += CodedOutputStream.computeMessageSize(2, (WeaponOuterClass.Weapon) this.detail_);
            }
            if (this.isLocked_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isLocked_);
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
            if (!(obj instanceof Equip)) {
                return equals(obj);
            }
            Equip other = (Equip) obj;
            if (getIsLocked() != other.getIsLocked() || !getDetailCase().equals(other.getDetailCase())) {
                return false;
            }
            switch (this.detailCase_) {
                case 1:
                    if (!getReliquary().equals(other.getReliquary())) {
                        return false;
                    }
                    break;
                case 2:
                    if (!getWeapon().equals(other.getWeapon())) {
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
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + Internal.hashBoolean(getIsLocked());
            switch (this.detailCase_) {
                case 1:
                    hash = (53 * ((37 * hash) + 1)) + getReliquary().hashCode();
                    break;
                case 2:
                    hash = (53 * ((37 * hash) + 2)) + getWeapon().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static Equip parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Equip parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Equip parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Equip parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Equip parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Equip parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Equip parseFrom(InputStream input) throws IOException {
            return (Equip) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Equip parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Equip) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Equip parseDelimitedFrom(InputStream input) throws IOException {
            return (Equip) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static Equip parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Equip) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static Equip parseFrom(CodedInputStream input) throws IOException {
            return (Equip) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Equip parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Equip) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Equip prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipOuterClass$Equip$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EquipOrBuilder {
            private int detailCase_ = 0;
            private Object detail_;
            private boolean isLocked_;
            private SingleFieldBuilderV3<ReliquaryOuterClass.Reliquary, ReliquaryOuterClass.Reliquary.Builder, ReliquaryOuterClass.ReliquaryOrBuilder> reliquaryBuilder_;
            private SingleFieldBuilderV3<WeaponOuterClass.Weapon, WeaponOuterClass.Weapon.Builder, WeaponOuterClass.WeaponOrBuilder> weaponBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EquipOuterClass.internal_static_Equip_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EquipOuterClass.internal_static_Equip_fieldAccessorTable.ensureFieldAccessorsInitialized(Equip.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Equip.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isLocked_ = false;
                this.detailCase_ = 0;
                this.detail_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EquipOuterClass.internal_static_Equip_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Equip getDefaultInstanceForType() {
                return Equip.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Equip build() {
                Equip result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Equip buildPartial() {
                Equip result = new Equip(this);
                result.isLocked_ = this.isLocked_;
                if (this.detailCase_ == 1) {
                    if (this.reliquaryBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.reliquaryBuilder_.build();
                    }
                }
                if (this.detailCase_ == 2) {
                    if (this.weaponBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.weaponBuilder_.build();
                    }
                }
                result.detailCase_ = this.detailCase_;
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
                if (other instanceof Equip) {
                    return mergeFrom((Equip) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Equip other) {
                if (other == Equip.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsLocked()) {
                    setIsLocked(other.getIsLocked());
                }
                switch (other.getDetailCase()) {
                    case RELIQUARY:
                        mergeReliquary(other.getReliquary());
                        break;
                    case WEAPON:
                        mergeWeapon(other.getWeapon());
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
                Equip parsedMessage = null;
                try {
                    try {
                        parsedMessage = Equip.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (Equip) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
            public DetailCase getDetailCase() {
                return DetailCase.forNumber(this.detailCase_);
            }

            public Builder clearDetail() {
                this.detailCase_ = 0;
                this.detail_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
            public boolean getIsLocked() {
                return this.isLocked_;
            }

            public Builder setIsLocked(boolean value) {
                this.isLocked_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsLocked() {
                this.isLocked_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
            public boolean hasReliquary() {
                return this.detailCase_ == 1;
            }

            @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
            public ReliquaryOuterClass.Reliquary getReliquary() {
                if (this.reliquaryBuilder_ == null) {
                    if (this.detailCase_ == 1) {
                        return (ReliquaryOuterClass.Reliquary) this.detail_;
                    }
                    return ReliquaryOuterClass.Reliquary.getDefaultInstance();
                } else if (this.detailCase_ == 1) {
                    return this.reliquaryBuilder_.getMessage();
                } else {
                    return ReliquaryOuterClass.Reliquary.getDefaultInstance();
                }
            }

            public Builder setReliquary(ReliquaryOuterClass.Reliquary value) {
                if (this.reliquaryBuilder_ != null) {
                    this.reliquaryBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1;
                return this;
            }

            public Builder setReliquary(ReliquaryOuterClass.Reliquary.Builder builderForValue) {
                if (this.reliquaryBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.reliquaryBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1;
                return this;
            }

            public Builder mergeReliquary(ReliquaryOuterClass.Reliquary value) {
                if (this.reliquaryBuilder_ == null) {
                    if (this.detailCase_ != 1 || this.detail_ == ReliquaryOuterClass.Reliquary.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = ReliquaryOuterClass.Reliquary.newBuilder((ReliquaryOuterClass.Reliquary) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1) {
                        this.reliquaryBuilder_.mergeFrom(value);
                    }
                    this.reliquaryBuilder_.setMessage(value);
                }
                this.detailCase_ = 1;
                return this;
            }

            public Builder clearReliquary() {
                if (this.reliquaryBuilder_ != null) {
                    if (this.detailCase_ == 1) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.reliquaryBuilder_.clear();
                } else if (this.detailCase_ == 1) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public ReliquaryOuterClass.Reliquary.Builder getReliquaryBuilder() {
                return getReliquaryFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
            public ReliquaryOuterClass.ReliquaryOrBuilder getReliquaryOrBuilder() {
                if (this.detailCase_ == 1 && this.reliquaryBuilder_ != null) {
                    return this.reliquaryBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1) {
                    return (ReliquaryOuterClass.Reliquary) this.detail_;
                }
                return ReliquaryOuterClass.Reliquary.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ReliquaryOuterClass.Reliquary, ReliquaryOuterClass.Reliquary.Builder, ReliquaryOuterClass.ReliquaryOrBuilder> getReliquaryFieldBuilder() {
                if (this.reliquaryBuilder_ == null) {
                    if (this.detailCase_ != 1) {
                        this.detail_ = ReliquaryOuterClass.Reliquary.getDefaultInstance();
                    }
                    this.reliquaryBuilder_ = new SingleFieldBuilderV3<>((ReliquaryOuterClass.Reliquary) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1;
                onChanged();
                return this.reliquaryBuilder_;
            }

            @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
            public boolean hasWeapon() {
                return this.detailCase_ == 2;
            }

            @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
            public WeaponOuterClass.Weapon getWeapon() {
                if (this.weaponBuilder_ == null) {
                    if (this.detailCase_ == 2) {
                        return (WeaponOuterClass.Weapon) this.detail_;
                    }
                    return WeaponOuterClass.Weapon.getDefaultInstance();
                } else if (this.detailCase_ == 2) {
                    return this.weaponBuilder_.getMessage();
                } else {
                    return WeaponOuterClass.Weapon.getDefaultInstance();
                }
            }

            public Builder setWeapon(WeaponOuterClass.Weapon value) {
                if (this.weaponBuilder_ != null) {
                    this.weaponBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 2;
                return this;
            }

            public Builder setWeapon(WeaponOuterClass.Weapon.Builder builderForValue) {
                if (this.weaponBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.weaponBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 2;
                return this;
            }

            public Builder mergeWeapon(WeaponOuterClass.Weapon value) {
                if (this.weaponBuilder_ == null) {
                    if (this.detailCase_ != 2 || this.detail_ == WeaponOuterClass.Weapon.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = WeaponOuterClass.Weapon.newBuilder((WeaponOuterClass.Weapon) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 2) {
                        this.weaponBuilder_.mergeFrom(value);
                    }
                    this.weaponBuilder_.setMessage(value);
                }
                this.detailCase_ = 2;
                return this;
            }

            public Builder clearWeapon() {
                if (this.weaponBuilder_ != null) {
                    if (this.detailCase_ == 2) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.weaponBuilder_.clear();
                } else if (this.detailCase_ == 2) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public WeaponOuterClass.Weapon.Builder getWeaponBuilder() {
                return getWeaponFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.EquipOuterClass.EquipOrBuilder
            public WeaponOuterClass.WeaponOrBuilder getWeaponOrBuilder() {
                if (this.detailCase_ == 2 && this.weaponBuilder_ != null) {
                    return this.weaponBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 2) {
                    return (WeaponOuterClass.Weapon) this.detail_;
                }
                return WeaponOuterClass.Weapon.getDefaultInstance();
            }

            private SingleFieldBuilderV3<WeaponOuterClass.Weapon, WeaponOuterClass.Weapon.Builder, WeaponOuterClass.WeaponOrBuilder> getWeaponFieldBuilder() {
                if (this.weaponBuilder_ == null) {
                    if (this.detailCase_ != 2) {
                        this.detail_ = WeaponOuterClass.Weapon.getDefaultInstance();
                    }
                    this.weaponBuilder_ = new SingleFieldBuilderV3<>((WeaponOuterClass.Weapon) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 2;
                onChanged();
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

        public static Equip getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Equip> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Equip> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Equip getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ReliquaryOuterClass.getDescriptor();
        WeaponOuterClass.getDescriptor();
    }
}
