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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShowEquipOuterClass.class */
public final class ShowEquipOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fShowEquip.proto\u001a\u000fReliquary.proto\u001a\fWeapon.proto\"a\n\tShowEquip\u0012\u000e\n\u0006itemId\u0018\u0001 \u0001(\r\u0012\u001f\n\treliquary\u0018\u0002 \u0001(\u000b2\n.ReliquaryH��\u0012\u0019\n\u0006weapon\u0018\u0003 \u0001(\u000b2\u0007.WeaponH��B\b\n\u0006detailB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ReliquaryOuterClass.getDescriptor(), WeaponOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ShowEquip_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ShowEquip_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ShowEquip_descriptor, new String[]{"ItemId", "Reliquary", "Weapon", "Detail"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShowEquipOuterClass$ShowEquipOrBuilder.class */
    public interface ShowEquipOrBuilder extends MessageOrBuilder {
        int getItemId();

        boolean hasReliquary();

        ReliquaryOuterClass.Reliquary getReliquary();

        ReliquaryOuterClass.ReliquaryOrBuilder getReliquaryOrBuilder();

        boolean hasWeapon();

        WeaponOuterClass.Weapon getWeapon();

        WeaponOuterClass.WeaponOrBuilder getWeaponOrBuilder();

        ShowEquip.DetailCase getDetailCase();
    }

    private ShowEquipOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShowEquipOuterClass$ShowEquip.class */
    public static final class ShowEquip extends GeneratedMessageV3 implements ShowEquipOrBuilder {
        private static final long serialVersionUID = 0;
        private int detailCase_;
        private Object detail_;
        public static final int ITEMID_FIELD_NUMBER = 1;
        private int itemId_;
        public static final int RELIQUARY_FIELD_NUMBER = 2;
        public static final int WEAPON_FIELD_NUMBER = 3;
        private byte memoizedIsInitialized;
        private static final ShowEquip DEFAULT_INSTANCE = new ShowEquip();
        private static final Parser<ShowEquip> PARSER = new AbstractParser<ShowEquip>() { // from class: emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquip.1
            @Override // com.google.protobuf.Parser
            public ShowEquip parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShowEquip(input, extensionRegistry);
            }
        };

        private ShowEquip(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private ShowEquip() {
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ShowEquip();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ShowEquip(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.itemId_ = input.readUInt32();
                                break;
                            case 18:
                                ReliquaryOuterClass.Reliquary.Builder subBuilder = this.detailCase_ == 2 ? ((ReliquaryOuterClass.Reliquary) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(ReliquaryOuterClass.Reliquary.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((ReliquaryOuterClass.Reliquary) this.detail_);
                                    this.detail_ = subBuilder.buildPartial();
                                }
                                this.detailCase_ = 2;
                                break;
                            case 26:
                                WeaponOuterClass.Weapon.Builder subBuilder2 = this.detailCase_ == 3 ? ((WeaponOuterClass.Weapon) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(WeaponOuterClass.Weapon.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((WeaponOuterClass.Weapon) this.detail_);
                                    this.detail_ = subBuilder2.buildPartial();
                                }
                                this.detailCase_ = 3;
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
            return ShowEquipOuterClass.internal_static_ShowEquip_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShowEquipOuterClass.internal_static_ShowEquip_fieldAccessorTable.ensureFieldAccessorsInitialized(ShowEquip.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShowEquipOuterClass$ShowEquip$DetailCase.class */
        public enum DetailCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            RELIQUARY(2),
            WEAPON(3),
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
                    default:
                        return null;
                    case 2:
                        return RELIQUARY;
                    case 3:
                        return WEAPON;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
        public DetailCase getDetailCase() {
            return DetailCase.forNumber(this.detailCase_);
        }

        @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
        public int getItemId() {
            return this.itemId_;
        }

        @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
        public boolean hasReliquary() {
            return this.detailCase_ == 2;
        }

        @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
        public ReliquaryOuterClass.Reliquary getReliquary() {
            if (this.detailCase_ == 2) {
                return (ReliquaryOuterClass.Reliquary) this.detail_;
            }
            return ReliquaryOuterClass.Reliquary.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
        public ReliquaryOuterClass.ReliquaryOrBuilder getReliquaryOrBuilder() {
            if (this.detailCase_ == 2) {
                return (ReliquaryOuterClass.Reliquary) this.detail_;
            }
            return ReliquaryOuterClass.Reliquary.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
        public boolean hasWeapon() {
            return this.detailCase_ == 3;
        }

        @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
        public WeaponOuterClass.Weapon getWeapon() {
            if (this.detailCase_ == 3) {
                return (WeaponOuterClass.Weapon) this.detail_;
            }
            return WeaponOuterClass.Weapon.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
        public WeaponOuterClass.WeaponOrBuilder getWeaponOrBuilder() {
            if (this.detailCase_ == 3) {
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
            if (this.itemId_ != 0) {
                output.writeUInt32(1, this.itemId_);
            }
            if (this.detailCase_ == 2) {
                output.writeMessage(2, (ReliquaryOuterClass.Reliquary) this.detail_);
            }
            if (this.detailCase_ == 3) {
                output.writeMessage(3, (WeaponOuterClass.Weapon) this.detail_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.itemId_);
            }
            if (this.detailCase_ == 2) {
                size2 += CodedOutputStream.computeMessageSize(2, (ReliquaryOuterClass.Reliquary) this.detail_);
            }
            if (this.detailCase_ == 3) {
                size2 += CodedOutputStream.computeMessageSize(3, (WeaponOuterClass.Weapon) this.detail_);
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
            if (!(obj instanceof ShowEquip)) {
                return equals(obj);
            }
            ShowEquip other = (ShowEquip) obj;
            if (getItemId() != other.getItemId() || !getDetailCase().equals(other.getDetailCase())) {
                return false;
            }
            switch (this.detailCase_) {
                case 2:
                    if (!getReliquary().equals(other.getReliquary())) {
                        return false;
                    }
                    break;
                case 3:
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
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getItemId();
            switch (this.detailCase_) {
                case 2:
                    hash = (53 * ((37 * hash) + 2)) + getReliquary().hashCode();
                    break;
                case 3:
                    hash = (53 * ((37 * hash) + 3)) + getWeapon().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ShowEquip parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShowEquip parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShowEquip parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShowEquip parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShowEquip parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShowEquip parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShowEquip parseFrom(InputStream input) throws IOException {
            return (ShowEquip) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ShowEquip parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShowEquip) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ShowEquip parseDelimitedFrom(InputStream input) throws IOException {
            return (ShowEquip) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ShowEquip parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShowEquip) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ShowEquip parseFrom(CodedInputStream input) throws IOException {
            return (ShowEquip) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ShowEquip parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShowEquip) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ShowEquip prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShowEquipOuterClass$ShowEquip$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ShowEquipOrBuilder {
            private int detailCase_ = 0;
            private Object detail_;
            private int itemId_;
            private SingleFieldBuilderV3<ReliquaryOuterClass.Reliquary, ReliquaryOuterClass.Reliquary.Builder, ReliquaryOuterClass.ReliquaryOrBuilder> reliquaryBuilder_;
            private SingleFieldBuilderV3<WeaponOuterClass.Weapon, WeaponOuterClass.Weapon.Builder, WeaponOuterClass.WeaponOrBuilder> weaponBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ShowEquipOuterClass.internal_static_ShowEquip_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShowEquipOuterClass.internal_static_ShowEquip_fieldAccessorTable.ensureFieldAccessorsInitialized(ShowEquip.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ShowEquip.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.itemId_ = 0;
                this.detailCase_ = 0;
                this.detail_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ShowEquipOuterClass.internal_static_ShowEquip_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ShowEquip getDefaultInstanceForType() {
                return ShowEquip.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShowEquip build() {
                ShowEquip result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShowEquip buildPartial() {
                ShowEquip result = new ShowEquip(this);
                result.itemId_ = this.itemId_;
                if (this.detailCase_ == 2) {
                    if (this.reliquaryBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.reliquaryBuilder_.build();
                    }
                }
                if (this.detailCase_ == 3) {
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
                if (other instanceof ShowEquip) {
                    return mergeFrom((ShowEquip) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShowEquip other) {
                if (other == ShowEquip.getDefaultInstance()) {
                    return this;
                }
                if (other.getItemId() != 0) {
                    setItemId(other.getItemId());
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
                ShowEquip parsedMessage = null;
                try {
                    try {
                        parsedMessage = ShowEquip.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ShowEquip) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
            public DetailCase getDetailCase() {
                return DetailCase.forNumber(this.detailCase_);
            }

            public Builder clearDetail() {
                this.detailCase_ = 0;
                this.detail_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
            public boolean hasReliquary() {
                return this.detailCase_ == 2;
            }

            @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
            public ReliquaryOuterClass.Reliquary getReliquary() {
                if (this.reliquaryBuilder_ == null) {
                    if (this.detailCase_ == 2) {
                        return (ReliquaryOuterClass.Reliquary) this.detail_;
                    }
                    return ReliquaryOuterClass.Reliquary.getDefaultInstance();
                } else if (this.detailCase_ == 2) {
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
                this.detailCase_ = 2;
                return this;
            }

            public Builder setReliquary(ReliquaryOuterClass.Reliquary.Builder builderForValue) {
                if (this.reliquaryBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.reliquaryBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 2;
                return this;
            }

            public Builder mergeReliquary(ReliquaryOuterClass.Reliquary value) {
                if (this.reliquaryBuilder_ == null) {
                    if (this.detailCase_ != 2 || this.detail_ == ReliquaryOuterClass.Reliquary.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = ReliquaryOuterClass.Reliquary.newBuilder((ReliquaryOuterClass.Reliquary) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 2) {
                        this.reliquaryBuilder_.mergeFrom(value);
                    }
                    this.reliquaryBuilder_.setMessage(value);
                }
                this.detailCase_ = 2;
                return this;
            }

            public Builder clearReliquary() {
                if (this.reliquaryBuilder_ != null) {
                    if (this.detailCase_ == 2) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.reliquaryBuilder_.clear();
                } else if (this.detailCase_ == 2) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public ReliquaryOuterClass.Reliquary.Builder getReliquaryBuilder() {
                return getReliquaryFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
            public ReliquaryOuterClass.ReliquaryOrBuilder getReliquaryOrBuilder() {
                if (this.detailCase_ == 2 && this.reliquaryBuilder_ != null) {
                    return this.reliquaryBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 2) {
                    return (ReliquaryOuterClass.Reliquary) this.detail_;
                }
                return ReliquaryOuterClass.Reliquary.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ReliquaryOuterClass.Reliquary, ReliquaryOuterClass.Reliquary.Builder, ReliquaryOuterClass.ReliquaryOrBuilder> getReliquaryFieldBuilder() {
                if (this.reliquaryBuilder_ == null) {
                    if (this.detailCase_ != 2) {
                        this.detail_ = ReliquaryOuterClass.Reliquary.getDefaultInstance();
                    }
                    this.reliquaryBuilder_ = new SingleFieldBuilderV3<>((ReliquaryOuterClass.Reliquary) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 2;
                onChanged();
                return this.reliquaryBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
            public boolean hasWeapon() {
                return this.detailCase_ == 3;
            }

            @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
            public WeaponOuterClass.Weapon getWeapon() {
                if (this.weaponBuilder_ == null) {
                    if (this.detailCase_ == 3) {
                        return (WeaponOuterClass.Weapon) this.detail_;
                    }
                    return WeaponOuterClass.Weapon.getDefaultInstance();
                } else if (this.detailCase_ == 3) {
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
                this.detailCase_ = 3;
                return this;
            }

            public Builder setWeapon(WeaponOuterClass.Weapon.Builder builderForValue) {
                if (this.weaponBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.weaponBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 3;
                return this;
            }

            public Builder mergeWeapon(WeaponOuterClass.Weapon value) {
                if (this.weaponBuilder_ == null) {
                    if (this.detailCase_ != 3 || this.detail_ == WeaponOuterClass.Weapon.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = WeaponOuterClass.Weapon.newBuilder((WeaponOuterClass.Weapon) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 3) {
                        this.weaponBuilder_.mergeFrom(value);
                    }
                    this.weaponBuilder_.setMessage(value);
                }
                this.detailCase_ = 3;
                return this;
            }

            public Builder clearWeapon() {
                if (this.weaponBuilder_ != null) {
                    if (this.detailCase_ == 3) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.weaponBuilder_.clear();
                } else if (this.detailCase_ == 3) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public WeaponOuterClass.Weapon.Builder getWeaponBuilder() {
                return getWeaponFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ShowEquipOuterClass.ShowEquipOrBuilder
            public WeaponOuterClass.WeaponOrBuilder getWeaponOrBuilder() {
                if (this.detailCase_ == 3 && this.weaponBuilder_ != null) {
                    return this.weaponBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 3) {
                    return (WeaponOuterClass.Weapon) this.detail_;
                }
                return WeaponOuterClass.Weapon.getDefaultInstance();
            }

            private SingleFieldBuilderV3<WeaponOuterClass.Weapon, WeaponOuterClass.Weapon.Builder, WeaponOuterClass.WeaponOrBuilder> getWeaponFieldBuilder() {
                if (this.weaponBuilder_ == null) {
                    if (this.detailCase_ != 3) {
                        this.detail_ = WeaponOuterClass.Weapon.getDefaultInstance();
                    }
                    this.weaponBuilder_ = new SingleFieldBuilderV3<>((WeaponOuterClass.Weapon) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 3;
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

        public static ShowEquip getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ShowEquip> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ShowEquip> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ShowEquip getDefaultInstanceForType() {
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
