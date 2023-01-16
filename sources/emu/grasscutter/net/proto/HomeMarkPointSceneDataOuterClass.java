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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeMarkPointSceneDataOuterClass.class */
public final class HomeMarkPointSceneDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cHomeMarkPointSceneData.proto\u001a HomeMarkPointFurnitureData.proto\u001a\fVector.proto\"·\u0001\n\u0016HomeMarkPointSceneData\u0012\"\n\u0011teapot_spirit_pos\u0018\t \u0001(\u000b2\u0007.Vector\u0012\u0010\n\bscene_id\u0018\u0006 \u0001(\r\u0012\u001f\n\u000esafe_point_pos\u0018\u000b \u0001(\u000b2\u0007.Vector\u0012\u0011\n\tmodule_id\u0018\b \u0001(\r\u00123\n\u000efurniture_list\u0018\r \u0003(\u000b2\u001b.HomeMarkPointFurnitureDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeMarkPointFurnitureDataOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeMarkPointSceneData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeMarkPointSceneData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeMarkPointSceneData_descriptor, new String[]{"TeapotSpiritPos", "SceneId", "SafePointPos", "ModuleId", "FurnitureList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeMarkPointSceneDataOuterClass$HomeMarkPointSceneDataOrBuilder.class */
    public interface HomeMarkPointSceneDataOrBuilder extends MessageOrBuilder {
        boolean hasTeapotSpiritPos();

        VectorOuterClass.Vector getTeapotSpiritPos();

        VectorOuterClass.VectorOrBuilder getTeapotSpiritPosOrBuilder();

        int getSceneId();

        boolean hasSafePointPos();

        VectorOuterClass.Vector getSafePointPos();

        VectorOuterClass.VectorOrBuilder getSafePointPosOrBuilder();

        int getModuleId();

        List<HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData> getFurnitureListList();

        HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData getFurnitureList(int i);

        int getFurnitureListCount();

        List<? extends HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder> getFurnitureListOrBuilderList();

        HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder getFurnitureListOrBuilder(int i);
    }

    private HomeMarkPointSceneDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeMarkPointSceneDataOuterClass$HomeMarkPointSceneData.class */
    public static final class HomeMarkPointSceneData extends GeneratedMessageV3 implements HomeMarkPointSceneDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TEAPOT_SPIRIT_POS_FIELD_NUMBER = 9;
        private VectorOuterClass.Vector teapotSpiritPos_;
        public static final int SCENE_ID_FIELD_NUMBER = 6;
        private int sceneId_;
        public static final int SAFE_POINT_POS_FIELD_NUMBER = 11;
        private VectorOuterClass.Vector safePointPos_;
        public static final int MODULE_ID_FIELD_NUMBER = 8;
        private int moduleId_;
        public static final int FURNITURE_LIST_FIELD_NUMBER = 13;
        private List<HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData> furnitureList_;
        private byte memoizedIsInitialized;
        private static final HomeMarkPointSceneData DEFAULT_INSTANCE = new HomeMarkPointSceneData();
        private static final Parser<HomeMarkPointSceneData> PARSER = new AbstractParser<HomeMarkPointSceneData>() { // from class: emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.1
            @Override // com.google.protobuf.Parser
            public HomeMarkPointSceneData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeMarkPointSceneData(input, extensionRegistry);
            }
        };

        private HomeMarkPointSceneData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeMarkPointSceneData() {
            this.memoizedIsInitialized = -1;
            this.furnitureList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeMarkPointSceneData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeMarkPointSceneData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    this.sceneId_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.moduleId_ = input.readUInt32();
                                    break;
                                case 74:
                                    VectorOuterClass.Vector.Builder subBuilder = this.teapotSpiritPos_ != null ? this.teapotSpiritPos_.toBuilder() : null;
                                    this.teapotSpiritPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.teapotSpiritPos_);
                                        this.teapotSpiritPos_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 90:
                                    VectorOuterClass.Vector.Builder subBuilder2 = this.safePointPos_ != null ? this.safePointPos_.toBuilder() : null;
                                    this.safePointPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.safePointPos_);
                                        this.safePointPos_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 106:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.furnitureList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.furnitureList_.add((HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData) input.readMessage(HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData.parser(), extensionRegistry));
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.furnitureList_ = Collections.unmodifiableList(this.furnitureList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeMarkPointSceneDataOuterClass.internal_static_HomeMarkPointSceneData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeMarkPointSceneDataOuterClass.internal_static_HomeMarkPointSceneData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeMarkPointSceneData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
        public boolean hasTeapotSpiritPos() {
            return this.teapotSpiritPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
        public VectorOuterClass.Vector getTeapotSpiritPos() {
            return this.teapotSpiritPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.teapotSpiritPos_;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getTeapotSpiritPosOrBuilder() {
            return getTeapotSpiritPos();
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
        public boolean hasSafePointPos() {
            return this.safePointPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
        public VectorOuterClass.Vector getSafePointPos() {
            return this.safePointPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.safePointPos_;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getSafePointPosOrBuilder() {
            return getSafePointPos();
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
        public int getModuleId() {
            return this.moduleId_;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
        public List<HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData> getFurnitureListList() {
            return this.furnitureList_;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
        public List<? extends HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder> getFurnitureListOrBuilderList() {
            return this.furnitureList_;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
        public int getFurnitureListCount() {
            return this.furnitureList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
        public HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData getFurnitureList(int index) {
            return this.furnitureList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
        public HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder getFurnitureListOrBuilder(int index) {
            return this.furnitureList_.get(index);
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
            if (this.sceneId_ != 0) {
                output.writeUInt32(6, this.sceneId_);
            }
            if (this.moduleId_ != 0) {
                output.writeUInt32(8, this.moduleId_);
            }
            if (this.teapotSpiritPos_ != null) {
                output.writeMessage(9, getTeapotSpiritPos());
            }
            if (this.safePointPos_ != null) {
                output.writeMessage(11, getSafePointPos());
            }
            for (int i = 0; i < this.furnitureList_.size(); i++) {
                output.writeMessage(13, this.furnitureList_.get(i));
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
            if (this.sceneId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.sceneId_);
            }
            if (this.moduleId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.moduleId_);
            }
            if (this.teapotSpiritPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(9, getTeapotSpiritPos());
            }
            if (this.safePointPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getSafePointPos());
            }
            for (int i = 0; i < this.furnitureList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.furnitureList_.get(i));
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
            if (!(obj instanceof HomeMarkPointSceneData)) {
                return equals(obj);
            }
            HomeMarkPointSceneData other = (HomeMarkPointSceneData) obj;
            if (hasTeapotSpiritPos() != other.hasTeapotSpiritPos()) {
                return false;
            }
            if ((!hasTeapotSpiritPos() || getTeapotSpiritPos().equals(other.getTeapotSpiritPos())) && getSceneId() == other.getSceneId() && hasSafePointPos() == other.hasSafePointPos()) {
                return (!hasSafePointPos() || getSafePointPos().equals(other.getSafePointPos())) && getModuleId() == other.getModuleId() && getFurnitureListList().equals(other.getFurnitureListList()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasTeapotSpiritPos()) {
                hash = (53 * ((37 * hash) + 9)) + getTeapotSpiritPos().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 6)) + getSceneId();
            if (hasSafePointPos()) {
                hash2 = (53 * ((37 * hash2) + 11)) + getSafePointPos().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 8)) + getModuleId();
            if (getFurnitureListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 13)) + getFurnitureListList().hashCode();
            }
            int hash4 = (29 * hash3) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static HomeMarkPointSceneData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeMarkPointSceneData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeMarkPointSceneData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeMarkPointSceneData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeMarkPointSceneData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeMarkPointSceneData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeMarkPointSceneData parseFrom(InputStream input) throws IOException {
            return (HomeMarkPointSceneData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeMarkPointSceneData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeMarkPointSceneData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeMarkPointSceneData parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeMarkPointSceneData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeMarkPointSceneData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeMarkPointSceneData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeMarkPointSceneData parseFrom(CodedInputStream input) throws IOException {
            return (HomeMarkPointSceneData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeMarkPointSceneData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeMarkPointSceneData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeMarkPointSceneData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeMarkPointSceneDataOuterClass$HomeMarkPointSceneData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeMarkPointSceneDataOrBuilder {
            private int bitField0_;
            private VectorOuterClass.Vector teapotSpiritPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> teapotSpiritPosBuilder_;
            private int sceneId_;
            private VectorOuterClass.Vector safePointPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> safePointPosBuilder_;
            private int moduleId_;
            private List<HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData> furnitureList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData, HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData.Builder, HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder> furnitureListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeMarkPointSceneDataOuterClass.internal_static_HomeMarkPointSceneData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeMarkPointSceneDataOuterClass.internal_static_HomeMarkPointSceneData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeMarkPointSceneData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeMarkPointSceneData.alwaysUseFieldBuilders) {
                    getFurnitureListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.teapotSpiritPosBuilder_ == null) {
                    this.teapotSpiritPos_ = null;
                } else {
                    this.teapotSpiritPos_ = null;
                    this.teapotSpiritPosBuilder_ = null;
                }
                this.sceneId_ = 0;
                if (this.safePointPosBuilder_ == null) {
                    this.safePointPos_ = null;
                } else {
                    this.safePointPos_ = null;
                    this.safePointPosBuilder_ = null;
                }
                this.moduleId_ = 0;
                if (this.furnitureListBuilder_ == null) {
                    this.furnitureList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.furnitureListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeMarkPointSceneDataOuterClass.internal_static_HomeMarkPointSceneData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeMarkPointSceneData getDefaultInstanceForType() {
                return HomeMarkPointSceneData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeMarkPointSceneData build() {
                HomeMarkPointSceneData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeMarkPointSceneData buildPartial() {
                HomeMarkPointSceneData result = new HomeMarkPointSceneData(this);
                int i = this.bitField0_;
                if (this.teapotSpiritPosBuilder_ == null) {
                    result.teapotSpiritPos_ = this.teapotSpiritPos_;
                } else {
                    result.teapotSpiritPos_ = this.teapotSpiritPosBuilder_.build();
                }
                result.sceneId_ = this.sceneId_;
                if (this.safePointPosBuilder_ == null) {
                    result.safePointPos_ = this.safePointPos_;
                } else {
                    result.safePointPos_ = this.safePointPosBuilder_.build();
                }
                result.moduleId_ = this.moduleId_;
                if (this.furnitureListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.furnitureList_ = Collections.unmodifiableList(this.furnitureList_);
                        this.bitField0_ &= -2;
                    }
                    result.furnitureList_ = this.furnitureList_;
                } else {
                    result.furnitureList_ = this.furnitureListBuilder_.build();
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
                if (other instanceof HomeMarkPointSceneData) {
                    return mergeFrom((HomeMarkPointSceneData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeMarkPointSceneData other) {
                if (other == HomeMarkPointSceneData.getDefaultInstance()) {
                    return this;
                }
                if (other.hasTeapotSpiritPos()) {
                    mergeTeapotSpiritPos(other.getTeapotSpiritPos());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (other.hasSafePointPos()) {
                    mergeSafePointPos(other.getSafePointPos());
                }
                if (other.getModuleId() != 0) {
                    setModuleId(other.getModuleId());
                }
                if (this.furnitureListBuilder_ == null) {
                    if (!other.furnitureList_.isEmpty()) {
                        if (this.furnitureList_.isEmpty()) {
                            this.furnitureList_ = other.furnitureList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureFurnitureListIsMutable();
                            this.furnitureList_.addAll(other.furnitureList_);
                        }
                        onChanged();
                    }
                } else if (!other.furnitureList_.isEmpty()) {
                    if (this.furnitureListBuilder_.isEmpty()) {
                        this.furnitureListBuilder_.dispose();
                        this.furnitureListBuilder_ = null;
                        this.furnitureList_ = other.furnitureList_;
                        this.bitField0_ &= -2;
                        this.furnitureListBuilder_ = HomeMarkPointSceneData.alwaysUseFieldBuilders ? getFurnitureListFieldBuilder() : null;
                    } else {
                        this.furnitureListBuilder_.addAllMessages(other.furnitureList_);
                    }
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
                HomeMarkPointSceneData parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeMarkPointSceneData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeMarkPointSceneData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
            public boolean hasTeapotSpiritPos() {
                return (this.teapotSpiritPosBuilder_ == null && this.teapotSpiritPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
            public VectorOuterClass.Vector getTeapotSpiritPos() {
                if (this.teapotSpiritPosBuilder_ == null) {
                    return this.teapotSpiritPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.teapotSpiritPos_;
                }
                return this.teapotSpiritPosBuilder_.getMessage();
            }

            public Builder setTeapotSpiritPos(VectorOuterClass.Vector value) {
                if (this.teapotSpiritPosBuilder_ != null) {
                    this.teapotSpiritPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.teapotSpiritPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setTeapotSpiritPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.teapotSpiritPosBuilder_ == null) {
                    this.teapotSpiritPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.teapotSpiritPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeTeapotSpiritPos(VectorOuterClass.Vector value) {
                if (this.teapotSpiritPosBuilder_ == null) {
                    if (this.teapotSpiritPos_ != null) {
                        this.teapotSpiritPos_ = VectorOuterClass.Vector.newBuilder(this.teapotSpiritPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.teapotSpiritPos_ = value;
                    }
                    onChanged();
                } else {
                    this.teapotSpiritPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearTeapotSpiritPos() {
                if (this.teapotSpiritPosBuilder_ == null) {
                    this.teapotSpiritPos_ = null;
                    onChanged();
                } else {
                    this.teapotSpiritPos_ = null;
                    this.teapotSpiritPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getTeapotSpiritPosBuilder() {
                onChanged();
                return getTeapotSpiritPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
            public VectorOuterClass.VectorOrBuilder getTeapotSpiritPosOrBuilder() {
                if (this.teapotSpiritPosBuilder_ != null) {
                    return this.teapotSpiritPosBuilder_.getMessageOrBuilder();
                }
                return this.teapotSpiritPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.teapotSpiritPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getTeapotSpiritPosFieldBuilder() {
                if (this.teapotSpiritPosBuilder_ == null) {
                    this.teapotSpiritPosBuilder_ = new SingleFieldBuilderV3<>(getTeapotSpiritPos(), getParentForChildren(), isClean());
                    this.teapotSpiritPos_ = null;
                }
                return this.teapotSpiritPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
            public boolean hasSafePointPos() {
                return (this.safePointPosBuilder_ == null && this.safePointPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
            public VectorOuterClass.Vector getSafePointPos() {
                if (this.safePointPosBuilder_ == null) {
                    return this.safePointPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.safePointPos_;
                }
                return this.safePointPosBuilder_.getMessage();
            }

            public Builder setSafePointPos(VectorOuterClass.Vector value) {
                if (this.safePointPosBuilder_ != null) {
                    this.safePointPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.safePointPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSafePointPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.safePointPosBuilder_ == null) {
                    this.safePointPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.safePointPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSafePointPos(VectorOuterClass.Vector value) {
                if (this.safePointPosBuilder_ == null) {
                    if (this.safePointPos_ != null) {
                        this.safePointPos_ = VectorOuterClass.Vector.newBuilder(this.safePointPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.safePointPos_ = value;
                    }
                    onChanged();
                } else {
                    this.safePointPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSafePointPos() {
                if (this.safePointPosBuilder_ == null) {
                    this.safePointPos_ = null;
                    onChanged();
                } else {
                    this.safePointPos_ = null;
                    this.safePointPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getSafePointPosBuilder() {
                onChanged();
                return getSafePointPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
            public VectorOuterClass.VectorOrBuilder getSafePointPosOrBuilder() {
                if (this.safePointPosBuilder_ != null) {
                    return this.safePointPosBuilder_.getMessageOrBuilder();
                }
                return this.safePointPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.safePointPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getSafePointPosFieldBuilder() {
                if (this.safePointPosBuilder_ == null) {
                    this.safePointPosBuilder_ = new SingleFieldBuilderV3<>(getSafePointPos(), getParentForChildren(), isClean());
                    this.safePointPos_ = null;
                }
                return this.safePointPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
            public int getModuleId() {
                return this.moduleId_;
            }

            public Builder setModuleId(int value) {
                this.moduleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearModuleId() {
                this.moduleId_ = 0;
                onChanged();
                return this;
            }

            private void ensureFurnitureListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.furnitureList_ = new ArrayList(this.furnitureList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
            public List<HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData> getFurnitureListList() {
                if (this.furnitureListBuilder_ == null) {
                    return Collections.unmodifiableList(this.furnitureList_);
                }
                return this.furnitureListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
            public int getFurnitureListCount() {
                if (this.furnitureListBuilder_ == null) {
                    return this.furnitureList_.size();
                }
                return this.furnitureListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
            public HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData getFurnitureList(int index) {
                if (this.furnitureListBuilder_ == null) {
                    return this.furnitureList_.get(index);
                }
                return this.furnitureListBuilder_.getMessage(index);
            }

            public Builder setFurnitureList(int index, HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData value) {
                if (this.furnitureListBuilder_ != null) {
                    this.furnitureListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureListIsMutable();
                    this.furnitureList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFurnitureList(int index, HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData.Builder builderForValue) {
                if (this.furnitureListBuilder_ == null) {
                    ensureFurnitureListIsMutable();
                    this.furnitureList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFurnitureList(HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData value) {
                if (this.furnitureListBuilder_ != null) {
                    this.furnitureListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureListIsMutable();
                    this.furnitureList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFurnitureList(int index, HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData value) {
                if (this.furnitureListBuilder_ != null) {
                    this.furnitureListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureListIsMutable();
                    this.furnitureList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFurnitureList(HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData.Builder builderForValue) {
                if (this.furnitureListBuilder_ == null) {
                    ensureFurnitureListIsMutable();
                    this.furnitureList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFurnitureList(int index, HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData.Builder builderForValue) {
                if (this.furnitureListBuilder_ == null) {
                    ensureFurnitureListIsMutable();
                    this.furnitureList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFurnitureList(Iterable<? extends HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData> values) {
                if (this.furnitureListBuilder_ == null) {
                    ensureFurnitureListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.furnitureList_);
                    onChanged();
                } else {
                    this.furnitureListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFurnitureList() {
                if (this.furnitureListBuilder_ == null) {
                    this.furnitureList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.furnitureListBuilder_.clear();
                }
                return this;
            }

            public Builder removeFurnitureList(int index) {
                if (this.furnitureListBuilder_ == null) {
                    ensureFurnitureListIsMutable();
                    this.furnitureList_.remove(index);
                    onChanged();
                } else {
                    this.furnitureListBuilder_.remove(index);
                }
                return this;
            }

            public HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData.Builder getFurnitureListBuilder(int index) {
                return getFurnitureListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
            public HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder getFurnitureListOrBuilder(int index) {
                if (this.furnitureListBuilder_ == null) {
                    return this.furnitureList_.get(index);
                }
                return this.furnitureListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder
            public List<? extends HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder> getFurnitureListOrBuilderList() {
                if (this.furnitureListBuilder_ != null) {
                    return this.furnitureListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.furnitureList_);
            }

            public HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData.Builder addFurnitureListBuilder() {
                return getFurnitureListFieldBuilder().addBuilder(HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData.getDefaultInstance());
            }

            public HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData.Builder addFurnitureListBuilder(int index) {
                return getFurnitureListFieldBuilder().addBuilder(index, HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData.getDefaultInstance());
            }

            public List<HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData.Builder> getFurnitureListBuilderList() {
                return getFurnitureListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData, HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData.Builder, HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder> getFurnitureListFieldBuilder() {
                if (this.furnitureListBuilder_ == null) {
                    this.furnitureListBuilder_ = new RepeatedFieldBuilderV3<>(this.furnitureList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.furnitureList_ = null;
                }
                return this.furnitureListBuilder_;
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

        public static HomeMarkPointSceneData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeMarkPointSceneData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeMarkPointSceneData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeMarkPointSceneData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeMarkPointFurnitureDataOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
