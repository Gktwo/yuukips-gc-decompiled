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
import emu.grasscutter.net.proto.PlayerDieTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerDieNotifyOuterClass.class */
public final class WorldPlayerDieNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aWorldPlayerDieNotify.proto\u001a\u0013PlayerDieType.proto\"\u0001\n\u0014WorldPlayerDieNotify\u0012\u001a\n\u0012murderer_entity_id\u0018\u0003 \u0001(\r\u0012 \n\bdie_type\u0018\r \u0001(\u000e2\u000e.PlayerDieType\u0012\u0014\n\nmonster_id\u0018\u0006 \u0001(\rH��\u0012\u0013\n\tgadget_id\u0018\f \u0001(\rH��B\b\n\u0006entityB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PlayerDieTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WorldPlayerDieNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WorldPlayerDieNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WorldPlayerDieNotify_descriptor, new String[]{"MurdererEntityId", "DieType", "MonsterId", "GadgetId", "Entity"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerDieNotifyOuterClass$WorldPlayerDieNotifyOrBuilder.class */
    public interface WorldPlayerDieNotifyOrBuilder extends MessageOrBuilder {
        int getMurdererEntityId();

        int getDieTypeValue();

        PlayerDieTypeOuterClass.PlayerDieType getDieType();

        boolean hasMonsterId();

        int getMonsterId();

        boolean hasGadgetId();

        int getGadgetId();

        WorldPlayerDieNotify.EntityCase getEntityCase();
    }

    private WorldPlayerDieNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerDieNotifyOuterClass$WorldPlayerDieNotify.class */
    public static final class WorldPlayerDieNotify extends GeneratedMessageV3 implements WorldPlayerDieNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        private int entityCase_;
        private Object entity_;
        public static final int MURDERER_ENTITY_ID_FIELD_NUMBER = 3;
        private int murdererEntityId_;
        public static final int DIE_TYPE_FIELD_NUMBER = 13;
        private int dieType_;
        public static final int MONSTER_ID_FIELD_NUMBER = 6;
        public static final int GADGET_ID_FIELD_NUMBER = 12;
        private byte memoizedIsInitialized;
        private static final WorldPlayerDieNotify DEFAULT_INSTANCE = new WorldPlayerDieNotify();
        private static final Parser<WorldPlayerDieNotify> PARSER = new AbstractParser<WorldPlayerDieNotify>() { // from class: emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotify.1
            @Override // com.google.protobuf.Parser
            public WorldPlayerDieNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WorldPlayerDieNotify(input, extensionRegistry);
            }
        };

        private WorldPlayerDieNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.entityCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private WorldPlayerDieNotify() {
            this.entityCase_ = 0;
            this.memoizedIsInitialized = -1;
            this.dieType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WorldPlayerDieNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WorldPlayerDieNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.murdererEntityId_ = input.readUInt32();
                                break;
                            case 48:
                                this.entityCase_ = 6;
                                this.entity_ = Integer.valueOf(input.readUInt32());
                                break;
                            case 96:
                                this.entityCase_ = 12;
                                this.entity_ = Integer.valueOf(input.readUInt32());
                                break;
                            case 104:
                                this.dieType_ = input.readEnum();
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
            return WorldPlayerDieNotifyOuterClass.internal_static_WorldPlayerDieNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WorldPlayerDieNotifyOuterClass.internal_static_WorldPlayerDieNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WorldPlayerDieNotify.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerDieNotifyOuterClass$WorldPlayerDieNotify$EntityCase.class */
        public enum EntityCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            MONSTER_ID(6),
            GADGET_ID(12),
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
                    case 6:
                        return MONSTER_ID;
                    case 12:
                        return GADGET_ID;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
        public EntityCase getEntityCase() {
            return EntityCase.forNumber(this.entityCase_);
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
        public int getMurdererEntityId() {
            return this.murdererEntityId_;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
        public int getDieTypeValue() {
            return this.dieType_;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
        public PlayerDieTypeOuterClass.PlayerDieType getDieType() {
            PlayerDieTypeOuterClass.PlayerDieType result = PlayerDieTypeOuterClass.PlayerDieType.valueOf(this.dieType_);
            return result == null ? PlayerDieTypeOuterClass.PlayerDieType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
        public boolean hasMonsterId() {
            return this.entityCase_ == 6;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
        public int getMonsterId() {
            if (this.entityCase_ == 6) {
                return ((Integer) this.entity_).intValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
        public boolean hasGadgetId() {
            return this.entityCase_ == 12;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
        public int getGadgetId() {
            if (this.entityCase_ == 12) {
                return ((Integer) this.entity_).intValue();
            }
            return 0;
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
            if (this.murdererEntityId_ != 0) {
                output.writeUInt32(3, this.murdererEntityId_);
            }
            if (this.entityCase_ == 6) {
                output.writeUInt32(6, ((Integer) this.entity_).intValue());
            }
            if (this.entityCase_ == 12) {
                output.writeUInt32(12, ((Integer) this.entity_).intValue());
            }
            if (this.dieType_ != PlayerDieTypeOuterClass.PlayerDieType.PLAYER_DIE_TYPE_NONE.getNumber()) {
                output.writeEnum(13, this.dieType_);
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
            if (this.murdererEntityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.murdererEntityId_);
            }
            if (this.entityCase_ == 6) {
                size2 += CodedOutputStream.computeUInt32Size(6, ((Integer) this.entity_).intValue());
            }
            if (this.entityCase_ == 12) {
                size2 += CodedOutputStream.computeUInt32Size(12, ((Integer) this.entity_).intValue());
            }
            if (this.dieType_ != PlayerDieTypeOuterClass.PlayerDieType.PLAYER_DIE_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(13, this.dieType_);
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
            if (!(obj instanceof WorldPlayerDieNotify)) {
                return equals(obj);
            }
            WorldPlayerDieNotify other = (WorldPlayerDieNotify) obj;
            if (getMurdererEntityId() != other.getMurdererEntityId() || this.dieType_ != other.dieType_ || !getEntityCase().equals(other.getEntityCase())) {
                return false;
            }
            switch (this.entityCase_) {
                case 6:
                    if (getMonsterId() != other.getMonsterId()) {
                        return false;
                    }
                    break;
                case 12:
                    if (getGadgetId() != other.getGadgetId()) {
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
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getMurdererEntityId())) + 13)) + this.dieType_;
            switch (this.entityCase_) {
                case 6:
                    hash = (53 * ((37 * hash) + 6)) + getMonsterId();
                    break;
                case 12:
                    hash = (53 * ((37 * hash) + 12)) + getGadgetId();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WorldPlayerDieNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldPlayerDieNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldPlayerDieNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldPlayerDieNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldPlayerDieNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldPlayerDieNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldPlayerDieNotify parseFrom(InputStream input) throws IOException {
            return (WorldPlayerDieNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WorldPlayerDieNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldPlayerDieNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WorldPlayerDieNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (WorldPlayerDieNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WorldPlayerDieNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldPlayerDieNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WorldPlayerDieNotify parseFrom(CodedInputStream input) throws IOException {
            return (WorldPlayerDieNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WorldPlayerDieNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldPlayerDieNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WorldPlayerDieNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerDieNotifyOuterClass$WorldPlayerDieNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WorldPlayerDieNotifyOrBuilder {
            private Object entity_;
            private int murdererEntityId_;
            private int entityCase_ = 0;
            private int dieType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return WorldPlayerDieNotifyOuterClass.internal_static_WorldPlayerDieNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WorldPlayerDieNotifyOuterClass.internal_static_WorldPlayerDieNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WorldPlayerDieNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WorldPlayerDieNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.murdererEntityId_ = 0;
                this.dieType_ = 0;
                this.entityCase_ = 0;
                this.entity_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WorldPlayerDieNotifyOuterClass.internal_static_WorldPlayerDieNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WorldPlayerDieNotify getDefaultInstanceForType() {
                return WorldPlayerDieNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WorldPlayerDieNotify build() {
                WorldPlayerDieNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WorldPlayerDieNotify buildPartial() {
                WorldPlayerDieNotify result = new WorldPlayerDieNotify(this);
                result.murdererEntityId_ = this.murdererEntityId_;
                result.dieType_ = this.dieType_;
                if (this.entityCase_ == 6) {
                    result.entity_ = this.entity_;
                }
                if (this.entityCase_ == 12) {
                    result.entity_ = this.entity_;
                }
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
                if (other instanceof WorldPlayerDieNotify) {
                    return mergeFrom((WorldPlayerDieNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WorldPlayerDieNotify other) {
                if (other == WorldPlayerDieNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getMurdererEntityId() != 0) {
                    setMurdererEntityId(other.getMurdererEntityId());
                }
                if (other.dieType_ != 0) {
                    setDieTypeValue(other.getDieTypeValue());
                }
                switch (other.getEntityCase()) {
                    case MONSTER_ID:
                        setMonsterId(other.getMonsterId());
                        break;
                    case GADGET_ID:
                        setGadgetId(other.getGadgetId());
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
                WorldPlayerDieNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = WorldPlayerDieNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WorldPlayerDieNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
            public EntityCase getEntityCase() {
                return EntityCase.forNumber(this.entityCase_);
            }

            public Builder clearEntity() {
                this.entityCase_ = 0;
                this.entity_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
            public int getMurdererEntityId() {
                return this.murdererEntityId_;
            }

            public Builder setMurdererEntityId(int value) {
                this.murdererEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMurdererEntityId() {
                this.murdererEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
            public int getDieTypeValue() {
                return this.dieType_;
            }

            public Builder setDieTypeValue(int value) {
                this.dieType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
            public PlayerDieTypeOuterClass.PlayerDieType getDieType() {
                PlayerDieTypeOuterClass.PlayerDieType result = PlayerDieTypeOuterClass.PlayerDieType.valueOf(this.dieType_);
                return result == null ? PlayerDieTypeOuterClass.PlayerDieType.UNRECOGNIZED : result;
            }

            public Builder setDieType(PlayerDieTypeOuterClass.PlayerDieType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.dieType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearDieType() {
                this.dieType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
            public boolean hasMonsterId() {
                return this.entityCase_ == 6;
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
            public int getMonsterId() {
                if (this.entityCase_ == 6) {
                    return ((Integer) this.entity_).intValue();
                }
                return 0;
            }

            public Builder setMonsterId(int value) {
                this.entityCase_ = 6;
                this.entity_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearMonsterId() {
                if (this.entityCase_ == 6) {
                    this.entityCase_ = 0;
                    this.entity_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
            public boolean hasGadgetId() {
                return this.entityCase_ == 12;
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotifyOrBuilder
            public int getGadgetId() {
                if (this.entityCase_ == 12) {
                    return ((Integer) this.entity_).intValue();
                }
                return 0;
            }

            public Builder setGadgetId(int value) {
                this.entityCase_ = 12;
                this.entity_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearGadgetId() {
                if (this.entityCase_ == 12) {
                    this.entityCase_ = 0;
                    this.entity_ = null;
                    onChanged();
                }
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

        public static WorldPlayerDieNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WorldPlayerDieNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WorldPlayerDieNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WorldPlayerDieNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PlayerDieTypeOuterClass.getDescriptor();
    }
}
