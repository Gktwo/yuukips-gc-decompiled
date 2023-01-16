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
import emu.grasscutter.net.proto.HomeMarkPointNPCDataOuterClass;
import emu.grasscutter.net.proto.HomeMarkPointSuiteDataOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeMarkPointFurnitureDataOuterClass.class */
public final class HomeMarkPointFurnitureDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n HomeMarkPointFurnitureData.proto\u001a\u001aHomeMarkPointNPCData.proto\u001a\u001cHomeMarkPointSuiteData.proto\u001a\fVector.proto\"Ñ\u0001\n\u001aHomeMarkPointFurnitureData\u0012\f\n\u0004guid\u0018\u0001 \u0001(\r\u0012\u0014\n\ffurniture_id\u0018\u0002 \u0001(\r\u0012\u0016\n\u000efurniture_type\u0018\u0003 \u0001(\r\u0012\u0014\n\u0003pos\u0018\u0004 \u0001(\u000b2\u0007.Vector\u0012)\n\bnpc_data\u0018\u0006 \u0001(\u000b2\u0015.HomeMarkPointNPCDataH��\u0012-\n\nsuite_data\u0018\u0007 \u0001(\u000b2\u0017.HomeMarkPointSuiteDataH��B\u0007\n\u0005extraB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeMarkPointNPCDataOuterClass.getDescriptor(), HomeMarkPointSuiteDataOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeMarkPointFurnitureData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeMarkPointFurnitureData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeMarkPointFurnitureData_descriptor, new String[]{"Guid", "FurnitureId", "FurnitureType", "Pos", "NpcData", "SuiteData", "Extra"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeMarkPointFurnitureDataOuterClass$HomeMarkPointFurnitureDataOrBuilder.class */
    public interface HomeMarkPointFurnitureDataOrBuilder extends MessageOrBuilder {
        int getGuid();

        int getFurnitureId();

        int getFurnitureType();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        boolean hasNpcData();

        HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData getNpcData();

        HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCDataOrBuilder getNpcDataOrBuilder();

        boolean hasSuiteData();

        HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData getSuiteData();

        HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteDataOrBuilder getSuiteDataOrBuilder();

        HomeMarkPointFurnitureData.ExtraCase getExtraCase();
    }

    private HomeMarkPointFurnitureDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeMarkPointFurnitureDataOuterClass$HomeMarkPointFurnitureData.class */
    public static final class HomeMarkPointFurnitureData extends GeneratedMessageV3 implements HomeMarkPointFurnitureDataOrBuilder {
        private static final long serialVersionUID = 0;
        private int extraCase_;
        private Object extra_;
        public static final int GUID_FIELD_NUMBER = 1;
        private int guid_;
        public static final int FURNITURE_ID_FIELD_NUMBER = 2;
        private int furnitureId_;
        public static final int FURNITURE_TYPE_FIELD_NUMBER = 3;
        private int furnitureType_;
        public static final int POS_FIELD_NUMBER = 4;
        private VectorOuterClass.Vector pos_;
        public static final int NPC_DATA_FIELD_NUMBER = 6;
        public static final int SUITE_DATA_FIELD_NUMBER = 7;
        private byte memoizedIsInitialized;
        private static final HomeMarkPointFurnitureData DEFAULT_INSTANCE = new HomeMarkPointFurnitureData();
        private static final Parser<HomeMarkPointFurnitureData> PARSER = new AbstractParser<HomeMarkPointFurnitureData>() { // from class: emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData.1
            @Override // com.google.protobuf.Parser
            public HomeMarkPointFurnitureData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeMarkPointFurnitureData(input, extensionRegistry);
            }
        };

        private HomeMarkPointFurnitureData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.extraCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private HomeMarkPointFurnitureData() {
            this.extraCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeMarkPointFurnitureData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeMarkPointFurnitureData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.guid_ = input.readUInt32();
                                break;
                            case 16:
                                this.furnitureId_ = input.readUInt32();
                                break;
                            case 24:
                                this.furnitureType_ = input.readUInt32();
                                break;
                            case 34:
                                VectorOuterClass.Vector.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.pos_);
                                    this.pos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 50:
                                HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData.Builder subBuilder2 = this.extraCase_ == 6 ? ((HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData) this.extra_).toBuilder() : null;
                                this.extra_ = input.readMessage(HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData) this.extra_);
                                    this.extra_ = subBuilder2.buildPartial();
                                }
                                this.extraCase_ = 6;
                                break;
                            case 58:
                                HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData.Builder subBuilder3 = this.extraCase_ == 7 ? ((HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData) this.extra_).toBuilder() : null;
                                this.extra_ = input.readMessage(HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData.parser(), extensionRegistry);
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData) this.extra_);
                                    this.extra_ = subBuilder3.buildPartial();
                                }
                                this.extraCase_ = 7;
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
            return HomeMarkPointFurnitureDataOuterClass.internal_static_HomeMarkPointFurnitureData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeMarkPointFurnitureDataOuterClass.internal_static_HomeMarkPointFurnitureData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeMarkPointFurnitureData.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeMarkPointFurnitureDataOuterClass$HomeMarkPointFurnitureData$ExtraCase.class */
        public enum ExtraCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            NPC_DATA(6),
            SUITE_DATA(7),
            EXTRA_NOT_SET(0);
            
            private final int value;

            ExtraCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ExtraCase valueOf(int value) {
                return forNumber(value);
            }

            public static ExtraCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return EXTRA_NOT_SET;
                    case 6:
                        return NPC_DATA;
                    case 7:
                        return SUITE_DATA;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
        public ExtraCase getExtraCase() {
            return ExtraCase.forNumber(this.extraCase_);
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
        public int getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
        public int getFurnitureId() {
            return this.furnitureId_;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
        public int getFurnitureType() {
            return this.furnitureType_;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
        public boolean hasNpcData() {
            return this.extraCase_ == 6;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
        public HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData getNpcData() {
            if (this.extraCase_ == 6) {
                return (HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData) this.extra_;
            }
            return HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
        public HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCDataOrBuilder getNpcDataOrBuilder() {
            if (this.extraCase_ == 6) {
                return (HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData) this.extra_;
            }
            return HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
        public boolean hasSuiteData() {
            return this.extraCase_ == 7;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
        public HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData getSuiteData() {
            if (this.extraCase_ == 7) {
                return (HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData) this.extra_;
            }
            return HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
        public HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteDataOrBuilder getSuiteDataOrBuilder() {
            if (this.extraCase_ == 7) {
                return (HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData) this.extra_;
            }
            return HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData.getDefaultInstance();
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
            if (this.guid_ != 0) {
                output.writeUInt32(1, this.guid_);
            }
            if (this.furnitureId_ != 0) {
                output.writeUInt32(2, this.furnitureId_);
            }
            if (this.furnitureType_ != 0) {
                output.writeUInt32(3, this.furnitureType_);
            }
            if (this.pos_ != null) {
                output.writeMessage(4, getPos());
            }
            if (this.extraCase_ == 6) {
                output.writeMessage(6, (HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData) this.extra_);
            }
            if (this.extraCase_ == 7) {
                output.writeMessage(7, (HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData) this.extra_);
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
            if (this.guid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.guid_);
            }
            if (this.furnitureId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.furnitureId_);
            }
            if (this.furnitureType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.furnitureType_);
            }
            if (this.pos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getPos());
            }
            if (this.extraCase_ == 6) {
                size2 += CodedOutputStream.computeMessageSize(6, (HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData) this.extra_);
            }
            if (this.extraCase_ == 7) {
                size2 += CodedOutputStream.computeMessageSize(7, (HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData) this.extra_);
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
            if (!(obj instanceof HomeMarkPointFurnitureData)) {
                return equals(obj);
            }
            HomeMarkPointFurnitureData other = (HomeMarkPointFurnitureData) obj;
            if (getGuid() != other.getGuid() || getFurnitureId() != other.getFurnitureId() || getFurnitureType() != other.getFurnitureType() || hasPos() != other.hasPos()) {
                return false;
            }
            if ((hasPos() && !getPos().equals(other.getPos())) || !getExtraCase().equals(other.getExtraCase())) {
                return false;
            }
            switch (this.extraCase_) {
                case 6:
                    if (!getNpcData().equals(other.getNpcData())) {
                        return false;
                    }
                    break;
                case 7:
                    if (!getSuiteData().equals(other.getSuiteData())) {
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
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getGuid())) + 2)) + getFurnitureId())) + 3)) + getFurnitureType();
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 4)) + getPos().hashCode();
            }
            switch (this.extraCase_) {
                case 6:
                    hash = (53 * ((37 * hash) + 6)) + getNpcData().hashCode();
                    break;
                case 7:
                    hash = (53 * ((37 * hash) + 7)) + getSuiteData().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeMarkPointFurnitureData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeMarkPointFurnitureData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeMarkPointFurnitureData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeMarkPointFurnitureData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeMarkPointFurnitureData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeMarkPointFurnitureData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeMarkPointFurnitureData parseFrom(InputStream input) throws IOException {
            return (HomeMarkPointFurnitureData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeMarkPointFurnitureData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeMarkPointFurnitureData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeMarkPointFurnitureData parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeMarkPointFurnitureData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeMarkPointFurnitureData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeMarkPointFurnitureData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeMarkPointFurnitureData parseFrom(CodedInputStream input) throws IOException {
            return (HomeMarkPointFurnitureData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeMarkPointFurnitureData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeMarkPointFurnitureData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeMarkPointFurnitureData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeMarkPointFurnitureDataOuterClass$HomeMarkPointFurnitureData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeMarkPointFurnitureDataOrBuilder {
            private int extraCase_ = 0;
            private Object extra_;
            private int guid_;
            private int furnitureId_;
            private int furnitureType_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private SingleFieldBuilderV3<HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData, HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData.Builder, HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCDataOrBuilder> npcDataBuilder_;
            private SingleFieldBuilderV3<HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData, HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData.Builder, HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteDataOrBuilder> suiteDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeMarkPointFurnitureDataOuterClass.internal_static_HomeMarkPointFurnitureData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeMarkPointFurnitureDataOuterClass.internal_static_HomeMarkPointFurnitureData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeMarkPointFurnitureData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeMarkPointFurnitureData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.guid_ = 0;
                this.furnitureId_ = 0;
                this.furnitureType_ = 0;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                this.extraCase_ = 0;
                this.extra_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeMarkPointFurnitureDataOuterClass.internal_static_HomeMarkPointFurnitureData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeMarkPointFurnitureData getDefaultInstanceForType() {
                return HomeMarkPointFurnitureData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeMarkPointFurnitureData build() {
                HomeMarkPointFurnitureData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeMarkPointFurnitureData buildPartial() {
                HomeMarkPointFurnitureData result = new HomeMarkPointFurnitureData(this);
                result.guid_ = this.guid_;
                result.furnitureId_ = this.furnitureId_;
                result.furnitureType_ = this.furnitureType_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                if (this.extraCase_ == 6) {
                    if (this.npcDataBuilder_ == null) {
                        result.extra_ = this.extra_;
                    } else {
                        result.extra_ = this.npcDataBuilder_.build();
                    }
                }
                if (this.extraCase_ == 7) {
                    if (this.suiteDataBuilder_ == null) {
                        result.extra_ = this.extra_;
                    } else {
                        result.extra_ = this.suiteDataBuilder_.build();
                    }
                }
                result.extraCase_ = this.extraCase_;
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
                if (other instanceof HomeMarkPointFurnitureData) {
                    return mergeFrom((HomeMarkPointFurnitureData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeMarkPointFurnitureData other) {
                if (other == HomeMarkPointFurnitureData.getDefaultInstance()) {
                    return this;
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                if (other.getFurnitureId() != 0) {
                    setFurnitureId(other.getFurnitureId());
                }
                if (other.getFurnitureType() != 0) {
                    setFurnitureType(other.getFurnitureType());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                switch (other.getExtraCase()) {
                    case NPC_DATA:
                        mergeNpcData(other.getNpcData());
                        break;
                    case SUITE_DATA:
                        mergeSuiteData(other.getSuiteData());
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
                HomeMarkPointFurnitureData parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeMarkPointFurnitureData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeMarkPointFurnitureData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
            public ExtraCase getExtraCase() {
                return ExtraCase.forNumber(this.extraCase_);
            }

            public Builder clearExtra() {
                this.extraCase_ = 0;
                this.extra_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
            public int getFurnitureType() {
                return this.furnitureType_;
            }

            public Builder setFurnitureType(int value) {
                this.furnitureType_ = value;
                onChanged();
                return this;
            }

            public Builder clearFurnitureType() {
                this.furnitureType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
            public boolean hasNpcData() {
                return this.extraCase_ == 6;
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
            public HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData getNpcData() {
                if (this.npcDataBuilder_ == null) {
                    if (this.extraCase_ == 6) {
                        return (HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData) this.extra_;
                    }
                    return HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData.getDefaultInstance();
                } else if (this.extraCase_ == 6) {
                    return this.npcDataBuilder_.getMessage();
                } else {
                    return HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData.getDefaultInstance();
                }
            }

            public Builder setNpcData(HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData value) {
                if (this.npcDataBuilder_ != null) {
                    this.npcDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.extra_ = value;
                    onChanged();
                }
                this.extraCase_ = 6;
                return this;
            }

            public Builder setNpcData(HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData.Builder builderForValue) {
                if (this.npcDataBuilder_ == null) {
                    this.extra_ = builderForValue.build();
                    onChanged();
                } else {
                    this.npcDataBuilder_.setMessage(builderForValue.build());
                }
                this.extraCase_ = 6;
                return this;
            }

            public Builder mergeNpcData(HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData value) {
                if (this.npcDataBuilder_ == null) {
                    if (this.extraCase_ != 6 || this.extra_ == HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData.getDefaultInstance()) {
                        this.extra_ = value;
                    } else {
                        this.extra_ = HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData.newBuilder((HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData) this.extra_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.extraCase_ == 6) {
                        this.npcDataBuilder_.mergeFrom(value);
                    }
                    this.npcDataBuilder_.setMessage(value);
                }
                this.extraCase_ = 6;
                return this;
            }

            public Builder clearNpcData() {
                if (this.npcDataBuilder_ != null) {
                    if (this.extraCase_ == 6) {
                        this.extraCase_ = 0;
                        this.extra_ = null;
                    }
                    this.npcDataBuilder_.clear();
                } else if (this.extraCase_ == 6) {
                    this.extraCase_ = 0;
                    this.extra_ = null;
                    onChanged();
                }
                return this;
            }

            public HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData.Builder getNpcDataBuilder() {
                return getNpcDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
            public HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCDataOrBuilder getNpcDataOrBuilder() {
                if (this.extraCase_ == 6 && this.npcDataBuilder_ != null) {
                    return this.npcDataBuilder_.getMessageOrBuilder();
                }
                if (this.extraCase_ == 6) {
                    return (HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData) this.extra_;
                }
                return HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData.getDefaultInstance();
            }

            private SingleFieldBuilderV3<HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData, HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData.Builder, HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCDataOrBuilder> getNpcDataFieldBuilder() {
                if (this.npcDataBuilder_ == null) {
                    if (this.extraCase_ != 6) {
                        this.extra_ = HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData.getDefaultInstance();
                    }
                    this.npcDataBuilder_ = new SingleFieldBuilderV3<>((HomeMarkPointNPCDataOuterClass.HomeMarkPointNPCData) this.extra_, getParentForChildren(), isClean());
                    this.extra_ = null;
                }
                this.extraCase_ = 6;
                onChanged();
                return this.npcDataBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
            public boolean hasSuiteData() {
                return this.extraCase_ == 7;
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
            public HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData getSuiteData() {
                if (this.suiteDataBuilder_ == null) {
                    if (this.extraCase_ == 7) {
                        return (HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData) this.extra_;
                    }
                    return HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData.getDefaultInstance();
                } else if (this.extraCase_ == 7) {
                    return this.suiteDataBuilder_.getMessage();
                } else {
                    return HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData.getDefaultInstance();
                }
            }

            public Builder setSuiteData(HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData value) {
                if (this.suiteDataBuilder_ != null) {
                    this.suiteDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.extra_ = value;
                    onChanged();
                }
                this.extraCase_ = 7;
                return this;
            }

            public Builder setSuiteData(HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData.Builder builderForValue) {
                if (this.suiteDataBuilder_ == null) {
                    this.extra_ = builderForValue.build();
                    onChanged();
                } else {
                    this.suiteDataBuilder_.setMessage(builderForValue.build());
                }
                this.extraCase_ = 7;
                return this;
            }

            public Builder mergeSuiteData(HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData value) {
                if (this.suiteDataBuilder_ == null) {
                    if (this.extraCase_ != 7 || this.extra_ == HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData.getDefaultInstance()) {
                        this.extra_ = value;
                    } else {
                        this.extra_ = HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData.newBuilder((HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData) this.extra_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.extraCase_ == 7) {
                        this.suiteDataBuilder_.mergeFrom(value);
                    }
                    this.suiteDataBuilder_.setMessage(value);
                }
                this.extraCase_ = 7;
                return this;
            }

            public Builder clearSuiteData() {
                if (this.suiteDataBuilder_ != null) {
                    if (this.extraCase_ == 7) {
                        this.extraCase_ = 0;
                        this.extra_ = null;
                    }
                    this.suiteDataBuilder_.clear();
                } else if (this.extraCase_ == 7) {
                    this.extraCase_ = 0;
                    this.extra_ = null;
                    onChanged();
                }
                return this;
            }

            public HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData.Builder getSuiteDataBuilder() {
                return getSuiteDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureDataOrBuilder
            public HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteDataOrBuilder getSuiteDataOrBuilder() {
                if (this.extraCase_ == 7 && this.suiteDataBuilder_ != null) {
                    return this.suiteDataBuilder_.getMessageOrBuilder();
                }
                if (this.extraCase_ == 7) {
                    return (HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData) this.extra_;
                }
                return HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData.getDefaultInstance();
            }

            private SingleFieldBuilderV3<HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData, HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData.Builder, HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteDataOrBuilder> getSuiteDataFieldBuilder() {
                if (this.suiteDataBuilder_ == null) {
                    if (this.extraCase_ != 7) {
                        this.extra_ = HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData.getDefaultInstance();
                    }
                    this.suiteDataBuilder_ = new SingleFieldBuilderV3<>((HomeMarkPointSuiteDataOuterClass.HomeMarkPointSuiteData) this.extra_, getParentForChildren(), isClean());
                    this.extra_ = null;
                }
                this.extraCase_ = 7;
                onChanged();
                return this.suiteDataBuilder_;
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

        public static HomeMarkPointFurnitureData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeMarkPointFurnitureData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeMarkPointFurnitureData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeMarkPointFurnitureData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeMarkPointNPCDataOuterClass.getDescriptor();
        HomeMarkPointSuiteDataOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
