package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeNpcDataOuterClass.class */
public final class HomeNpcDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011HomeNpcData.proto\u001a\fVector.proto\"h\n\u000bHomeNpcData\u0012\u0019\n\bspawnPos\u0018\u0004 \u0001(\u000b2\u0007.Vector\u0012\u0011\n\tcostumeId\u0018\r \u0001(\r\u0012\u0010\n\bavatarId\u0018\u0005 \u0001(\r\u0012\u0019\n\bspawnRot\u0018\u0006 \u0001(\u000b2\u0007.VectorB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeNpcData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeNpcData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeNpcData_descriptor, new String[]{"SpawnPos", "CostumeId", "AvatarId", "SpawnRot"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeNpcDataOuterClass$HomeNpcDataOrBuilder.class */
    public interface HomeNpcDataOrBuilder extends MessageOrBuilder {
        boolean hasSpawnPos();

        VectorOuterClass.Vector getSpawnPos();

        VectorOuterClass.VectorOrBuilder getSpawnPosOrBuilder();

        int getCostumeId();

        int getAvatarId();

        boolean hasSpawnRot();

        VectorOuterClass.Vector getSpawnRot();

        VectorOuterClass.VectorOrBuilder getSpawnRotOrBuilder();
    }

    private HomeNpcDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeNpcDataOuterClass$HomeNpcData.class */
    public static final class HomeNpcData extends GeneratedMessageV3 implements HomeNpcDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SPAWNPOS_FIELD_NUMBER = 4;
        private VectorOuterClass.Vector spawnPos_;
        public static final int COSTUMEID_FIELD_NUMBER = 13;
        private int costumeId_;
        public static final int AVATARID_FIELD_NUMBER = 5;
        private int avatarId_;
        public static final int SPAWNROT_FIELD_NUMBER = 6;
        private VectorOuterClass.Vector spawnRot_;
        private byte memoizedIsInitialized;
        private static final HomeNpcData DEFAULT_INSTANCE = new HomeNpcData();
        private static final Parser<HomeNpcData> PARSER = new AbstractParser<HomeNpcData>() { // from class: emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcData.1
            @Override // com.google.protobuf.Parser
            public HomeNpcData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeNpcData(input, extensionRegistry);
            }
        };

        private HomeNpcData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeNpcData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeNpcData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeNpcData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 34:
                                VectorOuterClass.Vector.Builder subBuilder = this.spawnPos_ != null ? this.spawnPos_.toBuilder() : null;
                                this.spawnPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.spawnPos_);
                                    this.spawnPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 40:
                                this.avatarId_ = input.readUInt32();
                                break;
                            case 50:
                                VectorOuterClass.Vector.Builder subBuilder2 = this.spawnRot_ != null ? this.spawnRot_.toBuilder() : null;
                                this.spawnRot_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.spawnRot_);
                                    this.spawnRot_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 104:
                                this.costumeId_ = input.readUInt32();
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
            return HomeNpcDataOuterClass.internal_static_HomeNpcData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeNpcDataOuterClass.internal_static_HomeNpcData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeNpcData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
        public boolean hasSpawnPos() {
            return this.spawnPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
        public VectorOuterClass.Vector getSpawnPos() {
            return this.spawnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnPos_;
        }

        @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getSpawnPosOrBuilder() {
            return getSpawnPos();
        }

        @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
        public int getCostumeId() {
            return this.costumeId_;
        }

        @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
        }

        @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
        public boolean hasSpawnRot() {
            return this.spawnRot_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
        public VectorOuterClass.Vector getSpawnRot() {
            return this.spawnRot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnRot_;
        }

        @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getSpawnRotOrBuilder() {
            return getSpawnRot();
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
            if (this.spawnPos_ != null) {
                output.writeMessage(4, getSpawnPos());
            }
            if (this.avatarId_ != 0) {
                output.writeUInt32(5, this.avatarId_);
            }
            if (this.spawnRot_ != null) {
                output.writeMessage(6, getSpawnRot());
            }
            if (this.costumeId_ != 0) {
                output.writeUInt32(13, this.costumeId_);
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
            if (this.spawnPos_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(4, getSpawnPos());
            }
            if (this.avatarId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.avatarId_);
            }
            if (this.spawnRot_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getSpawnRot());
            }
            if (this.costumeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.costumeId_);
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
            if (!(obj instanceof HomeNpcData)) {
                return equals(obj);
            }
            HomeNpcData other = (HomeNpcData) obj;
            if (hasSpawnPos() != other.hasSpawnPos()) {
                return false;
            }
            if ((!hasSpawnPos() || getSpawnPos().equals(other.getSpawnPos())) && getCostumeId() == other.getCostumeId() && getAvatarId() == other.getAvatarId() && hasSpawnRot() == other.hasSpawnRot()) {
                return (!hasSpawnRot() || getSpawnRot().equals(other.getSpawnRot())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasSpawnPos()) {
                hash = (53 * ((37 * hash) + 4)) + getSpawnPos().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 13)) + getCostumeId())) + 5)) + getAvatarId();
            if (hasSpawnRot()) {
                hash2 = (53 * ((37 * hash2) + 6)) + getSpawnRot().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static HomeNpcData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeNpcData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeNpcData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeNpcData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeNpcData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeNpcData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeNpcData parseFrom(InputStream input) throws IOException {
            return (HomeNpcData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeNpcData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeNpcData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeNpcData parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeNpcData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeNpcData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeNpcData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeNpcData parseFrom(CodedInputStream input) throws IOException {
            return (HomeNpcData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeNpcData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeNpcData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeNpcData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeNpcDataOuterClass$HomeNpcData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeNpcDataOrBuilder {
            private VectorOuterClass.Vector spawnPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> spawnPosBuilder_;
            private int costumeId_;
            private int avatarId_;
            private VectorOuterClass.Vector spawnRot_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> spawnRotBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeNpcDataOuterClass.internal_static_HomeNpcData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeNpcDataOuterClass.internal_static_HomeNpcData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeNpcData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeNpcData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.spawnPosBuilder_ == null) {
                    this.spawnPos_ = null;
                } else {
                    this.spawnPos_ = null;
                    this.spawnPosBuilder_ = null;
                }
                this.costumeId_ = 0;
                this.avatarId_ = 0;
                if (this.spawnRotBuilder_ == null) {
                    this.spawnRot_ = null;
                } else {
                    this.spawnRot_ = null;
                    this.spawnRotBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeNpcDataOuterClass.internal_static_HomeNpcData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeNpcData getDefaultInstanceForType() {
                return HomeNpcData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeNpcData build() {
                HomeNpcData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeNpcData buildPartial() {
                HomeNpcData result = new HomeNpcData(this);
                if (this.spawnPosBuilder_ == null) {
                    result.spawnPos_ = this.spawnPos_;
                } else {
                    result.spawnPos_ = this.spawnPosBuilder_.build();
                }
                result.costumeId_ = this.costumeId_;
                result.avatarId_ = this.avatarId_;
                if (this.spawnRotBuilder_ == null) {
                    result.spawnRot_ = this.spawnRot_;
                } else {
                    result.spawnRot_ = this.spawnRotBuilder_.build();
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
                if (other instanceof HomeNpcData) {
                    return mergeFrom((HomeNpcData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeNpcData other) {
                if (other == HomeNpcData.getDefaultInstance()) {
                    return this;
                }
                if (other.hasSpawnPos()) {
                    mergeSpawnPos(other.getSpawnPos());
                }
                if (other.getCostumeId() != 0) {
                    setCostumeId(other.getCostumeId());
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
                }
                if (other.hasSpawnRot()) {
                    mergeSpawnRot(other.getSpawnRot());
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
                HomeNpcData parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeNpcData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeNpcData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
            public boolean hasSpawnPos() {
                return (this.spawnPosBuilder_ == null && this.spawnPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
            public VectorOuterClass.Vector getSpawnPos() {
                if (this.spawnPosBuilder_ == null) {
                    return this.spawnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnPos_;
                }
                return this.spawnPosBuilder_.getMessage();
            }

            public Builder setSpawnPos(VectorOuterClass.Vector value) {
                if (this.spawnPosBuilder_ != null) {
                    this.spawnPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.spawnPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSpawnPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.spawnPosBuilder_ == null) {
                    this.spawnPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.spawnPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSpawnPos(VectorOuterClass.Vector value) {
                if (this.spawnPosBuilder_ == null) {
                    if (this.spawnPos_ != null) {
                        this.spawnPos_ = VectorOuterClass.Vector.newBuilder(this.spawnPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.spawnPos_ = value;
                    }
                    onChanged();
                } else {
                    this.spawnPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSpawnPos() {
                if (this.spawnPosBuilder_ == null) {
                    this.spawnPos_ = null;
                    onChanged();
                } else {
                    this.spawnPos_ = null;
                    this.spawnPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getSpawnPosBuilder() {
                onChanged();
                return getSpawnPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
            public VectorOuterClass.VectorOrBuilder getSpawnPosOrBuilder() {
                if (this.spawnPosBuilder_ != null) {
                    return this.spawnPosBuilder_.getMessageOrBuilder();
                }
                return this.spawnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getSpawnPosFieldBuilder() {
                if (this.spawnPosBuilder_ == null) {
                    this.spawnPosBuilder_ = new SingleFieldBuilderV3<>(getSpawnPos(), getParentForChildren(), isClean());
                    this.spawnPos_ = null;
                }
                return this.spawnPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
            public int getCostumeId() {
                return this.costumeId_;
            }

            public Builder setCostumeId(int value) {
                this.costumeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCostumeId() {
                this.costumeId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
            public int getAvatarId() {
                return this.avatarId_;
            }

            public Builder setAvatarId(int value) {
                this.avatarId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarId() {
                this.avatarId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
            public boolean hasSpawnRot() {
                return (this.spawnRotBuilder_ == null && this.spawnRot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
            public VectorOuterClass.Vector getSpawnRot() {
                if (this.spawnRotBuilder_ == null) {
                    return this.spawnRot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnRot_;
                }
                return this.spawnRotBuilder_.getMessage();
            }

            public Builder setSpawnRot(VectorOuterClass.Vector value) {
                if (this.spawnRotBuilder_ != null) {
                    this.spawnRotBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.spawnRot_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSpawnRot(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.spawnRotBuilder_ == null) {
                    this.spawnRot_ = builderForValue.build();
                    onChanged();
                } else {
                    this.spawnRotBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSpawnRot(VectorOuterClass.Vector value) {
                if (this.spawnRotBuilder_ == null) {
                    if (this.spawnRot_ != null) {
                        this.spawnRot_ = VectorOuterClass.Vector.newBuilder(this.spawnRot_).mergeFrom(value).buildPartial();
                    } else {
                        this.spawnRot_ = value;
                    }
                    onChanged();
                } else {
                    this.spawnRotBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSpawnRot() {
                if (this.spawnRotBuilder_ == null) {
                    this.spawnRot_ = null;
                    onChanged();
                } else {
                    this.spawnRot_ = null;
                    this.spawnRotBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getSpawnRotBuilder() {
                onChanged();
                return getSpawnRotFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeNpcDataOuterClass.HomeNpcDataOrBuilder
            public VectorOuterClass.VectorOrBuilder getSpawnRotOrBuilder() {
                if (this.spawnRotBuilder_ != null) {
                    return this.spawnRotBuilder_.getMessageOrBuilder();
                }
                return this.spawnRot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnRot_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getSpawnRotFieldBuilder() {
                if (this.spawnRotBuilder_ == null) {
                    this.spawnRotBuilder_ = new SingleFieldBuilderV3<>(getSpawnRot(), getParentForChildren(), isClean());
                    this.spawnRot_ = null;
                }
                return this.spawnRotBuilder_;
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

        public static HomeNpcData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeNpcData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeNpcData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeNpcData getDefaultInstanceForType() {
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
