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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureArrangementMuipDataOuterClass.class */
public final class HomeFurnitureArrangementMuipDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n&HomeFurnitureArrangementMuipData.proto\u001a\fVector.proto\"p\n HomeFurnitureArrangementMuipData\u0012\u0014\n\ffurniture_id\u0018\u0001 \u0001(\r\u0012\u001a\n\tspawn_pos\u0018\u0002 \u0001(\u000b2\u0007.Vector\u0012\u001a\n\tspawn_rot\u0018\u0003 \u0001(\u000b2\u0007.VectorB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeFurnitureArrangementMuipData_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_HomeFurnitureArrangementMuipData_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f759xcd9e8d6d = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeFurnitureArrangementMuipData_descriptor, new String[]{"FurnitureId", "SpawnPos", "SpawnRot"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureArrangementMuipDataOuterClass$HomeFurnitureArrangementMuipDataOrBuilder.class */
    public interface HomeFurnitureArrangementMuipDataOrBuilder extends MessageOrBuilder {
        int getFurnitureId();

        boolean hasSpawnPos();

        VectorOuterClass.Vector getSpawnPos();

        VectorOuterClass.VectorOrBuilder getSpawnPosOrBuilder();

        boolean hasSpawnRot();

        VectorOuterClass.Vector getSpawnRot();

        VectorOuterClass.VectorOrBuilder getSpawnRotOrBuilder();
    }

    private HomeFurnitureArrangementMuipDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureArrangementMuipDataOuterClass$HomeFurnitureArrangementMuipData.class */
    public static final class HomeFurnitureArrangementMuipData extends GeneratedMessageV3 implements HomeFurnitureArrangementMuipDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FURNITURE_ID_FIELD_NUMBER = 1;
        private int furnitureId_;
        public static final int SPAWN_POS_FIELD_NUMBER = 2;
        private VectorOuterClass.Vector spawnPos_;
        public static final int SPAWN_ROT_FIELD_NUMBER = 3;
        private VectorOuterClass.Vector spawnRot_;
        private byte memoizedIsInitialized;
        private static final HomeFurnitureArrangementMuipData DEFAULT_INSTANCE = new HomeFurnitureArrangementMuipData();
        private static final Parser<HomeFurnitureArrangementMuipData> PARSER = new AbstractParser<HomeFurnitureArrangementMuipData>() { // from class: emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipData.1
            @Override // com.google.protobuf.Parser
            public HomeFurnitureArrangementMuipData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeFurnitureArrangementMuipData(input, extensionRegistry);
            }
        };

        private HomeFurnitureArrangementMuipData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeFurnitureArrangementMuipData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeFurnitureArrangementMuipData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeFurnitureArrangementMuipData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.furnitureId_ = input.readUInt32();
                                break;
                            case 18:
                                VectorOuterClass.Vector.Builder subBuilder = this.spawnPos_ != null ? this.spawnPos_.toBuilder() : null;
                                this.spawnPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.spawnPos_);
                                    this.spawnPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 26:
                                VectorOuterClass.Vector.Builder subBuilder2 = this.spawnRot_ != null ? this.spawnRot_.toBuilder() : null;
                                this.spawnRot_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.spawnRot_);
                                    this.spawnRot_ = subBuilder2.buildPartial();
                                    break;
                                }
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
            return HomeFurnitureArrangementMuipDataOuterClass.internal_static_HomeFurnitureArrangementMuipData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeFurnitureArrangementMuipDataOuterClass.f759xcd9e8d6d.ensureFieldAccessorsInitialized(HomeFurnitureArrangementMuipData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipDataOrBuilder
        public int getFurnitureId() {
            return this.furnitureId_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipDataOrBuilder
        public boolean hasSpawnPos() {
            return this.spawnPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipDataOrBuilder
        public VectorOuterClass.Vector getSpawnPos() {
            return this.spawnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnPos_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getSpawnPosOrBuilder() {
            return getSpawnPos();
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipDataOrBuilder
        public boolean hasSpawnRot() {
            return this.spawnRot_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipDataOrBuilder
        public VectorOuterClass.Vector getSpawnRot() {
            return this.spawnRot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnRot_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipDataOrBuilder
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
            if (this.furnitureId_ != 0) {
                output.writeUInt32(1, this.furnitureId_);
            }
            if (this.spawnPos_ != null) {
                output.writeMessage(2, getSpawnPos());
            }
            if (this.spawnRot_ != null) {
                output.writeMessage(3, getSpawnRot());
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
            if (this.furnitureId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.furnitureId_);
            }
            if (this.spawnPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(2, getSpawnPos());
            }
            if (this.spawnRot_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getSpawnRot());
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
            if (!(obj instanceof HomeFurnitureArrangementMuipData)) {
                return equals(obj);
            }
            HomeFurnitureArrangementMuipData other = (HomeFurnitureArrangementMuipData) obj;
            if (getFurnitureId() != other.getFurnitureId() || hasSpawnPos() != other.hasSpawnPos()) {
                return false;
            }
            if ((!hasSpawnPos() || getSpawnPos().equals(other.getSpawnPos())) && hasSpawnRot() == other.hasSpawnRot()) {
                return (!hasSpawnRot() || getSpawnRot().equals(other.getSpawnRot())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getFurnitureId();
            if (hasSpawnPos()) {
                hash = (53 * ((37 * hash) + 2)) + getSpawnPos().hashCode();
            }
            if (hasSpawnRot()) {
                hash = (53 * ((37 * hash) + 3)) + getSpawnRot().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeFurnitureArrangementMuipData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureArrangementMuipData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureArrangementMuipData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureArrangementMuipData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureArrangementMuipData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureArrangementMuipData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureArrangementMuipData parseFrom(InputStream input) throws IOException {
            return (HomeFurnitureArrangementMuipData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeFurnitureArrangementMuipData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureArrangementMuipData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeFurnitureArrangementMuipData parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeFurnitureArrangementMuipData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeFurnitureArrangementMuipData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureArrangementMuipData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeFurnitureArrangementMuipData parseFrom(CodedInputStream input) throws IOException {
            return (HomeFurnitureArrangementMuipData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeFurnitureArrangementMuipData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureArrangementMuipData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeFurnitureArrangementMuipData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureArrangementMuipDataOuterClass$HomeFurnitureArrangementMuipData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeFurnitureArrangementMuipDataOrBuilder {
            private int furnitureId_;
            private VectorOuterClass.Vector spawnPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> spawnPosBuilder_;
            private VectorOuterClass.Vector spawnRot_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> spawnRotBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeFurnitureArrangementMuipDataOuterClass.internal_static_HomeFurnitureArrangementMuipData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeFurnitureArrangementMuipDataOuterClass.f759xcd9e8d6d.ensureFieldAccessorsInitialized(HomeFurnitureArrangementMuipData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeFurnitureArrangementMuipData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.furnitureId_ = 0;
                if (this.spawnPosBuilder_ == null) {
                    this.spawnPos_ = null;
                } else {
                    this.spawnPos_ = null;
                    this.spawnPosBuilder_ = null;
                }
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
                return HomeFurnitureArrangementMuipDataOuterClass.internal_static_HomeFurnitureArrangementMuipData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeFurnitureArrangementMuipData getDefaultInstanceForType() {
                return HomeFurnitureArrangementMuipData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeFurnitureArrangementMuipData build() {
                HomeFurnitureArrangementMuipData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeFurnitureArrangementMuipData buildPartial() {
                HomeFurnitureArrangementMuipData result = new HomeFurnitureArrangementMuipData(this);
                result.furnitureId_ = this.furnitureId_;
                if (this.spawnPosBuilder_ == null) {
                    result.spawnPos_ = this.spawnPos_;
                } else {
                    result.spawnPos_ = this.spawnPosBuilder_.build();
                }
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
                if (other instanceof HomeFurnitureArrangementMuipData) {
                    return mergeFrom((HomeFurnitureArrangementMuipData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeFurnitureArrangementMuipData other) {
                if (other == HomeFurnitureArrangementMuipData.getDefaultInstance()) {
                    return this;
                }
                if (other.getFurnitureId() != 0) {
                    setFurnitureId(other.getFurnitureId());
                }
                if (other.hasSpawnPos()) {
                    mergeSpawnPos(other.getSpawnPos());
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
                HomeFurnitureArrangementMuipData parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeFurnitureArrangementMuipData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeFurnitureArrangementMuipData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipDataOrBuilder
            public int getFurnitureId() {
                return this.furnitureId_;
            }

            public Builder setFurnitureId(int value) {
                this.furnitureId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFurnitureId() {
                this.furnitureId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipDataOrBuilder
            public boolean hasSpawnPos() {
                return (this.spawnPosBuilder_ == null && this.spawnPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipDataOrBuilder
            public boolean hasSpawnRot() {
                return (this.spawnRotBuilder_ == null && this.spawnRot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeFurnitureArrangementMuipDataOuterClass.HomeFurnitureArrangementMuipDataOrBuilder
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

        public static HomeFurnitureArrangementMuipData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeFurnitureArrangementMuipData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeFurnitureArrangementMuipData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeFurnitureArrangementMuipData getDefaultInstanceForType() {
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
