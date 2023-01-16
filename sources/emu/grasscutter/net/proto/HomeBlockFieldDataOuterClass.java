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
import emu.grasscutter.net.proto.HomeBlockSubFieldDataOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBlockFieldDataOuterClass.class */
public final class HomeBlockFieldDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018HomeBlockFieldData.proto\u001a\u001bHomeBlockSubFieldData.proto\u001a\fVector.proto\"\u0001\n\u0012HomeBlockFieldData\u0012.\n\u000esub_field_list\u0018\u0004 \u0003(\u000b2\u0016.HomeBlockSubFieldData\u0012\f\n\u0004guid\u0018\u000f \u0001(\r\u0012\u0014\n\u0003pos\u0018\b \u0001(\u000b2\u0007.Vector\u0012\u0014\n\ffurniture_id\u0018\f \u0001(\r\u0012\u0014\n\u0003rot\u0018\r \u0001(\u000b2\u0007.VectorB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeBlockSubFieldDataOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeBlockFieldData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeBlockFieldData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeBlockFieldData_descriptor, new String[]{"SubFieldList", "Guid", "Pos", "FurnitureId", "Rot"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBlockFieldDataOuterClass$HomeBlockFieldDataOrBuilder.class */
    public interface HomeBlockFieldDataOrBuilder extends MessageOrBuilder {
        List<HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData> getSubFieldListList();

        HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData getSubFieldList(int i);

        int getSubFieldListCount();

        List<? extends HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldDataOrBuilder> getSubFieldListOrBuilderList();

        HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldDataOrBuilder getSubFieldListOrBuilder(int i);

        int getGuid();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        int getFurnitureId();

        boolean hasRot();

        VectorOuterClass.Vector getRot();

        VectorOuterClass.VectorOrBuilder getRotOrBuilder();
    }

    private HomeBlockFieldDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBlockFieldDataOuterClass$HomeBlockFieldData.class */
    public static final class HomeBlockFieldData extends GeneratedMessageV3 implements HomeBlockFieldDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SUB_FIELD_LIST_FIELD_NUMBER = 4;
        private List<HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData> subFieldList_;
        public static final int GUID_FIELD_NUMBER = 15;
        private int guid_;
        public static final int POS_FIELD_NUMBER = 8;
        private VectorOuterClass.Vector pos_;
        public static final int FURNITURE_ID_FIELD_NUMBER = 12;
        private int furnitureId_;
        public static final int ROT_FIELD_NUMBER = 13;
        private VectorOuterClass.Vector rot_;
        private byte memoizedIsInitialized;
        private static final HomeBlockFieldData DEFAULT_INSTANCE = new HomeBlockFieldData();
        private static final Parser<HomeBlockFieldData> PARSER = new AbstractParser<HomeBlockFieldData>() { // from class: emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldData.1
            @Override // com.google.protobuf.Parser
            public HomeBlockFieldData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeBlockFieldData(input, extensionRegistry);
            }
        };

        private HomeBlockFieldData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeBlockFieldData() {
            this.memoizedIsInitialized = -1;
            this.subFieldList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeBlockFieldData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeBlockFieldData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 34:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.subFieldList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.subFieldList_.add((HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData) input.readMessage(HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData.parser(), extensionRegistry));
                                    break;
                                case 66:
                                    VectorOuterClass.Vector.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                    this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.pos_);
                                        this.pos_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 96:
                                    this.furnitureId_ = input.readUInt32();
                                    break;
                                case 106:
                                    VectorOuterClass.Vector.Builder subBuilder2 = this.rot_ != null ? this.rot_.toBuilder() : null;
                                    this.rot_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.rot_);
                                        this.rot_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 120:
                                    this.guid_ = input.readUInt32();
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
                    this.subFieldList_ = Collections.unmodifiableList(this.subFieldList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeBlockFieldDataOuterClass.internal_static_HomeBlockFieldData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeBlockFieldDataOuterClass.internal_static_HomeBlockFieldData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeBlockFieldData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
        public List<HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData> getSubFieldListList() {
            return this.subFieldList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
        public List<? extends HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldDataOrBuilder> getSubFieldListOrBuilderList() {
            return this.subFieldList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
        public int getSubFieldListCount() {
            return this.subFieldList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
        public HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData getSubFieldList(int index) {
            return this.subFieldList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
        public HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldDataOrBuilder getSubFieldListOrBuilder(int index) {
            return this.subFieldList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
        public int getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
        public int getFurnitureId() {
            return this.furnitureId_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
        public boolean hasRot() {
            return this.rot_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
        public VectorOuterClass.Vector getRot() {
            return this.rot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rot_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getRotOrBuilder() {
            return getRot();
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
            for (int i = 0; i < this.subFieldList_.size(); i++) {
                output.writeMessage(4, this.subFieldList_.get(i));
            }
            if (this.pos_ != null) {
                output.writeMessage(8, getPos());
            }
            if (this.furnitureId_ != 0) {
                output.writeUInt32(12, this.furnitureId_);
            }
            if (this.rot_ != null) {
                output.writeMessage(13, getRot());
            }
            if (this.guid_ != 0) {
                output.writeUInt32(15, this.guid_);
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
            for (int i = 0; i < this.subFieldList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.subFieldList_.get(i));
            }
            if (this.pos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(8, getPos());
            }
            if (this.furnitureId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.furnitureId_);
            }
            if (this.rot_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getRot());
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.guid_);
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
            if (!(obj instanceof HomeBlockFieldData)) {
                return equals(obj);
            }
            HomeBlockFieldData other = (HomeBlockFieldData) obj;
            if (!getSubFieldListList().equals(other.getSubFieldListList()) || getGuid() != other.getGuid() || hasPos() != other.hasPos()) {
                return false;
            }
            if ((!hasPos() || getPos().equals(other.getPos())) && getFurnitureId() == other.getFurnitureId() && hasRot() == other.hasRot()) {
                return (!hasRot() || getRot().equals(other.getRot())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getSubFieldListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getSubFieldListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 15)) + getGuid();
            if (hasPos()) {
                hash2 = (53 * ((37 * hash2) + 8)) + getPos().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 12)) + getFurnitureId();
            if (hasRot()) {
                hash3 = (53 * ((37 * hash3) + 13)) + getRot().hashCode();
            }
            int hash4 = (29 * hash3) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static HomeBlockFieldData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBlockFieldData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBlockFieldData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBlockFieldData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBlockFieldData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBlockFieldData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBlockFieldData parseFrom(InputStream input) throws IOException {
            return (HomeBlockFieldData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeBlockFieldData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBlockFieldData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeBlockFieldData parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeBlockFieldData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeBlockFieldData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBlockFieldData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeBlockFieldData parseFrom(CodedInputStream input) throws IOException {
            return (HomeBlockFieldData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeBlockFieldData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBlockFieldData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeBlockFieldData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBlockFieldDataOuterClass$HomeBlockFieldData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeBlockFieldDataOrBuilder {
            private int bitField0_;
            private List<HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData> subFieldList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData, HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData.Builder, HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldDataOrBuilder> subFieldListBuilder_;
            private int guid_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private int furnitureId_;
            private VectorOuterClass.Vector rot_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> rotBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeBlockFieldDataOuterClass.internal_static_HomeBlockFieldData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeBlockFieldDataOuterClass.internal_static_HomeBlockFieldData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeBlockFieldData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeBlockFieldData.alwaysUseFieldBuilders) {
                    getSubFieldListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.subFieldListBuilder_ == null) {
                    this.subFieldList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.subFieldListBuilder_.clear();
                }
                this.guid_ = 0;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                this.furnitureId_ = 0;
                if (this.rotBuilder_ == null) {
                    this.rot_ = null;
                } else {
                    this.rot_ = null;
                    this.rotBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeBlockFieldDataOuterClass.internal_static_HomeBlockFieldData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeBlockFieldData getDefaultInstanceForType() {
                return HomeBlockFieldData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeBlockFieldData build() {
                HomeBlockFieldData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeBlockFieldData buildPartial() {
                HomeBlockFieldData result = new HomeBlockFieldData(this);
                int i = this.bitField0_;
                if (this.subFieldListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.subFieldList_ = Collections.unmodifiableList(this.subFieldList_);
                        this.bitField0_ &= -2;
                    }
                    result.subFieldList_ = this.subFieldList_;
                } else {
                    result.subFieldList_ = this.subFieldListBuilder_.build();
                }
                result.guid_ = this.guid_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                result.furnitureId_ = this.furnitureId_;
                if (this.rotBuilder_ == null) {
                    result.rot_ = this.rot_;
                } else {
                    result.rot_ = this.rotBuilder_.build();
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
                if (other instanceof HomeBlockFieldData) {
                    return mergeFrom((HomeBlockFieldData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeBlockFieldData other) {
                if (other == HomeBlockFieldData.getDefaultInstance()) {
                    return this;
                }
                if (this.subFieldListBuilder_ == null) {
                    if (!other.subFieldList_.isEmpty()) {
                        if (this.subFieldList_.isEmpty()) {
                            this.subFieldList_ = other.subFieldList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureSubFieldListIsMutable();
                            this.subFieldList_.addAll(other.subFieldList_);
                        }
                        onChanged();
                    }
                } else if (!other.subFieldList_.isEmpty()) {
                    if (this.subFieldListBuilder_.isEmpty()) {
                        this.subFieldListBuilder_.dispose();
                        this.subFieldListBuilder_ = null;
                        this.subFieldList_ = other.subFieldList_;
                        this.bitField0_ &= -2;
                        this.subFieldListBuilder_ = HomeBlockFieldData.alwaysUseFieldBuilders ? getSubFieldListFieldBuilder() : null;
                    } else {
                        this.subFieldListBuilder_.addAllMessages(other.subFieldList_);
                    }
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.getFurnitureId() != 0) {
                    setFurnitureId(other.getFurnitureId());
                }
                if (other.hasRot()) {
                    mergeRot(other.getRot());
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
                HomeBlockFieldData parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeBlockFieldData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeBlockFieldData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureSubFieldListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.subFieldList_ = new ArrayList(this.subFieldList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
            public List<HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData> getSubFieldListList() {
                if (this.subFieldListBuilder_ == null) {
                    return Collections.unmodifiableList(this.subFieldList_);
                }
                return this.subFieldListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
            public int getSubFieldListCount() {
                if (this.subFieldListBuilder_ == null) {
                    return this.subFieldList_.size();
                }
                return this.subFieldListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
            public HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData getSubFieldList(int index) {
                if (this.subFieldListBuilder_ == null) {
                    return this.subFieldList_.get(index);
                }
                return this.subFieldListBuilder_.getMessage(index);
            }

            public Builder setSubFieldList(int index, HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData value) {
                if (this.subFieldListBuilder_ != null) {
                    this.subFieldListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSubFieldListIsMutable();
                    this.subFieldList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSubFieldList(int index, HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData.Builder builderForValue) {
                if (this.subFieldListBuilder_ == null) {
                    ensureSubFieldListIsMutable();
                    this.subFieldList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.subFieldListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSubFieldList(HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData value) {
                if (this.subFieldListBuilder_ != null) {
                    this.subFieldListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSubFieldListIsMutable();
                    this.subFieldList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSubFieldList(int index, HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData value) {
                if (this.subFieldListBuilder_ != null) {
                    this.subFieldListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSubFieldListIsMutable();
                    this.subFieldList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSubFieldList(HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData.Builder builderForValue) {
                if (this.subFieldListBuilder_ == null) {
                    ensureSubFieldListIsMutable();
                    this.subFieldList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.subFieldListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSubFieldList(int index, HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData.Builder builderForValue) {
                if (this.subFieldListBuilder_ == null) {
                    ensureSubFieldListIsMutable();
                    this.subFieldList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.subFieldListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSubFieldList(Iterable<? extends HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData> values) {
                if (this.subFieldListBuilder_ == null) {
                    ensureSubFieldListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.subFieldList_);
                    onChanged();
                } else {
                    this.subFieldListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSubFieldList() {
                if (this.subFieldListBuilder_ == null) {
                    this.subFieldList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.subFieldListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSubFieldList(int index) {
                if (this.subFieldListBuilder_ == null) {
                    ensureSubFieldListIsMutable();
                    this.subFieldList_.remove(index);
                    onChanged();
                } else {
                    this.subFieldListBuilder_.remove(index);
                }
                return this;
            }

            public HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData.Builder getSubFieldListBuilder(int index) {
                return getSubFieldListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
            public HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldDataOrBuilder getSubFieldListOrBuilder(int index) {
                if (this.subFieldListBuilder_ == null) {
                    return this.subFieldList_.get(index);
                }
                return this.subFieldListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
            public List<? extends HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldDataOrBuilder> getSubFieldListOrBuilderList() {
                if (this.subFieldListBuilder_ != null) {
                    return this.subFieldListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.subFieldList_);
            }

            public HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData.Builder addSubFieldListBuilder() {
                return getSubFieldListFieldBuilder().addBuilder(HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData.getDefaultInstance());
            }

            public HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData.Builder addSubFieldListBuilder(int index) {
                return getSubFieldListFieldBuilder().addBuilder(index, HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData.getDefaultInstance());
            }

            public List<HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData.Builder> getSubFieldListBuilderList() {
                return getSubFieldListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData, HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldData.Builder, HomeBlockSubFieldDataOuterClass.HomeBlockSubFieldDataOrBuilder> getSubFieldListFieldBuilder() {
                if (this.subFieldListBuilder_ == null) {
                    this.subFieldListBuilder_ = new RepeatedFieldBuilderV3<>(this.subFieldList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.subFieldList_ = null;
                }
                return this.subFieldListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
            public int getGuid() {
                return this.guid_;
            }

            public Builder setGuid(int value) {
                this.guid_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuid() {
                this.guid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
            public boolean hasRot() {
                return (this.rotBuilder_ == null && this.rot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static HomeBlockFieldData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeBlockFieldData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeBlockFieldData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeBlockFieldData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeBlockSubFieldDataOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
