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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathReqOuterClass.class */
public final class ToTheMoonQueryPathReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bToTheMoonQueryPathReq.proto\u001a\fVector.proto\"ý\u0004\n\u0015ToTheMoonQueryPathReq\u00125\n\nquery_type\u0018\u0005 \u0001(\u000e2!.ToTheMoonQueryPathReq.OptionType\u0012\u001b\n\u0013Unk3300_BBLMBILIOGP\u0018\b \u0001(\b\u00126\n\u000bfilter_type\u0018\r \u0001(\u000e2!.ToTheMoonQueryPathReq.FilterType\u0012\u0010\n\bquery_id\u0018\u0002 \u0001(\u0005\u00128\n\fastar_method\u0018\f \u0001(\u000e2\".ToTheMoonQueryPathReq.AStarMethod\u0012\u001b\n\nsource_pos\u0018\u000b \u0001(\u000b2\u0007.Vector\u0012 \n\u000fdestination_pos\u0018\u0003 \u0001(\u000b2\u0007.Vector\u0012\u0013\n\u000bfuzzy_range\u0018\u0007 \u0001(\u0005\u0012\u001b\n\u0013Unk3300_OFGONAMNIJG\u0018\u0006 \u0001(\b\u0012\u0010\n\bscene_id\u0018\u0004 \u0001(\r\":\n\nOptionType\u0012\u0014\n\u0010OPTION_TYPE_NONE\u0010��\u0012\u0016\n\u0012OPTION_TYPE_NORMAL\u0010\u0001\"~\n\u000bAStarMethod\u0012\u0019\n\u0015A_STAR_METHOD_CLASSIC\u0010��\u0012\u001a\n\u0016A_STAR_METHOD_TENDENCY\u0010\u0001\u0012\u001a\n\u0016A_STAR_METHOD_ADAPTIVE\u0010\u0002\u0012\u001c\n\u0018A_STAR_METHOD_INFLECTION\u0010\u0003\"M\n\nFilterType\u0012\u0013\n\u000fFILTER_TYPE_ALL\u0010��\u0012\u0013\n\u000fFILTER_TYPE_AIR\u0010\u0001\u0012\u0015\n\u0011FILTER_TYPE_WATER\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ToTheMoonQueryPathReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ToTheMoonQueryPathReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ToTheMoonQueryPathReq_descriptor, new String[]{"QueryType", "Unk3300BBLMBILIOGP", "FilterType", "QueryId", "AstarMethod", "SourcePos", "DestinationPos", "FuzzyRange", "Unk3300OFGONAMNIJG", "SceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathReqOuterClass$ToTheMoonQueryPathReqOrBuilder.class */
    public interface ToTheMoonQueryPathReqOrBuilder extends MessageOrBuilder {
        int getQueryTypeValue();

        ToTheMoonQueryPathReq.OptionType getQueryType();

        boolean getUnk3300BBLMBILIOGP();

        int getFilterTypeValue();

        ToTheMoonQueryPathReq.FilterType getFilterType();

        int getQueryId();

        int getAstarMethodValue();

        ToTheMoonQueryPathReq.AStarMethod getAstarMethod();

        boolean hasSourcePos();

        VectorOuterClass.Vector getSourcePos();

        VectorOuterClass.VectorOrBuilder getSourcePosOrBuilder();

        boolean hasDestinationPos();

        VectorOuterClass.Vector getDestinationPos();

        VectorOuterClass.VectorOrBuilder getDestinationPosOrBuilder();

        int getFuzzyRange();

        boolean getUnk3300OFGONAMNIJG();

        int getSceneId();
    }

    private ToTheMoonQueryPathReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathReqOuterClass$ToTheMoonQueryPathReq.class */
    public static final class ToTheMoonQueryPathReq extends GeneratedMessageV3 implements ToTheMoonQueryPathReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int QUERY_TYPE_FIELD_NUMBER = 5;
        private int queryType_;
        public static final int UNK3300_BBLMBILIOGP_FIELD_NUMBER = 8;
        private boolean unk3300BBLMBILIOGP_;
        public static final int FILTER_TYPE_FIELD_NUMBER = 13;
        private int filterType_;
        public static final int QUERY_ID_FIELD_NUMBER = 2;
        private int queryId_;
        public static final int ASTAR_METHOD_FIELD_NUMBER = 12;
        private int astarMethod_;
        public static final int SOURCE_POS_FIELD_NUMBER = 11;
        private VectorOuterClass.Vector sourcePos_;
        public static final int DESTINATION_POS_FIELD_NUMBER = 3;
        private VectorOuterClass.Vector destinationPos_;
        public static final int FUZZY_RANGE_FIELD_NUMBER = 7;
        private int fuzzyRange_;
        public static final int UNK3300_OFGONAMNIJG_FIELD_NUMBER = 6;
        private boolean unk3300OFGONAMNIJG_;
        public static final int SCENE_ID_FIELD_NUMBER = 4;
        private int sceneId_;
        private byte memoizedIsInitialized;
        private static final ToTheMoonQueryPathReq DEFAULT_INSTANCE = new ToTheMoonQueryPathReq();
        private static final Parser<ToTheMoonQueryPathReq> PARSER = new AbstractParser<ToTheMoonQueryPathReq>() { // from class: emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReq.1
            @Override // com.google.protobuf.Parser
            public ToTheMoonQueryPathReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ToTheMoonQueryPathReq(input, extensionRegistry);
            }
        };

        private ToTheMoonQueryPathReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ToTheMoonQueryPathReq() {
            this.memoizedIsInitialized = -1;
            this.queryType_ = 0;
            this.filterType_ = 0;
            this.astarMethod_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ToTheMoonQueryPathReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ToTheMoonQueryPathReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.queryId_ = input.readInt32();
                                break;
                            case 26:
                                VectorOuterClass.Vector.Builder subBuilder = this.destinationPos_ != null ? this.destinationPos_.toBuilder() : null;
                                this.destinationPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.destinationPos_);
                                    this.destinationPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 32:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 40:
                                this.queryType_ = input.readEnum();
                                break;
                            case 48:
                                this.unk3300OFGONAMNIJG_ = input.readBool();
                                break;
                            case 56:
                                this.fuzzyRange_ = input.readInt32();
                                break;
                            case 64:
                                this.unk3300BBLMBILIOGP_ = input.readBool();
                                break;
                            case 90:
                                VectorOuterClass.Vector.Builder subBuilder2 = this.sourcePos_ != null ? this.sourcePos_.toBuilder() : null;
                                this.sourcePos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.sourcePos_);
                                    this.sourcePos_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 96:
                                this.astarMethod_ = input.readEnum();
                                break;
                            case 104:
                                this.filterType_ = input.readEnum();
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
            return ToTheMoonQueryPathReqOuterClass.internal_static_ToTheMoonQueryPathReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ToTheMoonQueryPathReqOuterClass.internal_static_ToTheMoonQueryPathReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ToTheMoonQueryPathReq.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathReqOuterClass$ToTheMoonQueryPathReq$OptionType.class */
        public enum OptionType implements ProtocolMessageEnum {
            OPTION_TYPE_NONE(0),
            OPTION_TYPE_NORMAL(1),
            UNRECOGNIZED(-1);
            
            public static final int OPTION_TYPE_NONE_VALUE = 0;
            public static final int OPTION_TYPE_NORMAL_VALUE = 1;
            private static final Internal.EnumLiteMap<OptionType> internalValueMap = new Internal.EnumLiteMap<OptionType>() { // from class: emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReq.OptionType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public OptionType findValueByNumber(int number) {
                    return OptionType.forNumber(number);
                }
            };
            private static final OptionType[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static OptionType valueOf(int value) {
                return forNumber(value);
            }

            public static OptionType forNumber(int value) {
                switch (value) {
                    case 0:
                        return OPTION_TYPE_NONE;
                    case 1:
                        return OPTION_TYPE_NORMAL;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<OptionType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return ToTheMoonQueryPathReq.getDescriptor().getEnumTypes().get(0);
            }

            public static OptionType valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            OptionType(int value) {
                this.value = value;
            }
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathReqOuterClass$ToTheMoonQueryPathReq$AStarMethod.class */
        public enum AStarMethod implements ProtocolMessageEnum {
            A_STAR_METHOD_CLASSIC(0),
            A_STAR_METHOD_TENDENCY(1),
            A_STAR_METHOD_ADAPTIVE(2),
            A_STAR_METHOD_INFLECTION(3),
            UNRECOGNIZED(-1);
            
            public static final int A_STAR_METHOD_CLASSIC_VALUE = 0;
            public static final int A_STAR_METHOD_TENDENCY_VALUE = 1;
            public static final int A_STAR_METHOD_ADAPTIVE_VALUE = 2;
            public static final int A_STAR_METHOD_INFLECTION_VALUE = 3;
            private static final Internal.EnumLiteMap<AStarMethod> internalValueMap = new Internal.EnumLiteMap<AStarMethod>() { // from class: emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReq.AStarMethod.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public AStarMethod findValueByNumber(int number) {
                    return AStarMethod.forNumber(number);
                }
            };
            private static final AStarMethod[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static AStarMethod valueOf(int value) {
                return forNumber(value);
            }

            public static AStarMethod forNumber(int value) {
                switch (value) {
                    case 0:
                        return A_STAR_METHOD_CLASSIC;
                    case 1:
                        return A_STAR_METHOD_TENDENCY;
                    case 2:
                        return A_STAR_METHOD_ADAPTIVE;
                    case 3:
                        return A_STAR_METHOD_INFLECTION;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<AStarMethod> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return ToTheMoonQueryPathReq.getDescriptor().getEnumTypes().get(1);
            }

            public static AStarMethod valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            AStarMethod(int value) {
                this.value = value;
            }
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathReqOuterClass$ToTheMoonQueryPathReq$FilterType.class */
        public enum FilterType implements ProtocolMessageEnum {
            FILTER_TYPE_ALL(0),
            FILTER_TYPE_AIR(1),
            FILTER_TYPE_WATER(2),
            UNRECOGNIZED(-1);
            
            public static final int FILTER_TYPE_ALL_VALUE = 0;
            public static final int FILTER_TYPE_AIR_VALUE = 1;
            public static final int FILTER_TYPE_WATER_VALUE = 2;
            private static final Internal.EnumLiteMap<FilterType> internalValueMap = new Internal.EnumLiteMap<FilterType>() { // from class: emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReq.FilterType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public FilterType findValueByNumber(int number) {
                    return FilterType.forNumber(number);
                }
            };
            private static final FilterType[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static FilterType valueOf(int value) {
                return forNumber(value);
            }

            public static FilterType forNumber(int value) {
                switch (value) {
                    case 0:
                        return FILTER_TYPE_ALL;
                    case 1:
                        return FILTER_TYPE_AIR;
                    case 2:
                        return FILTER_TYPE_WATER;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<FilterType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return ToTheMoonQueryPathReq.getDescriptor().getEnumTypes().get(2);
            }

            public static FilterType valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            FilterType(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public int getQueryTypeValue() {
            return this.queryType_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public OptionType getQueryType() {
            OptionType result = OptionType.valueOf(this.queryType_);
            return result == null ? OptionType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public boolean getUnk3300BBLMBILIOGP() {
            return this.unk3300BBLMBILIOGP_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public int getFilterTypeValue() {
            return this.filterType_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public FilterType getFilterType() {
            FilterType result = FilterType.valueOf(this.filterType_);
            return result == null ? FilterType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public int getQueryId() {
            return this.queryId_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public int getAstarMethodValue() {
            return this.astarMethod_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public AStarMethod getAstarMethod() {
            AStarMethod result = AStarMethod.valueOf(this.astarMethod_);
            return result == null ? AStarMethod.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public boolean hasSourcePos() {
            return this.sourcePos_ != null;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public VectorOuterClass.Vector getSourcePos() {
            return this.sourcePos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.sourcePos_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public VectorOuterClass.VectorOrBuilder getSourcePosOrBuilder() {
            return getSourcePos();
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public boolean hasDestinationPos() {
            return this.destinationPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public VectorOuterClass.Vector getDestinationPos() {
            return this.destinationPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.destinationPos_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public VectorOuterClass.VectorOrBuilder getDestinationPosOrBuilder() {
            return getDestinationPos();
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public int getFuzzyRange() {
            return this.fuzzyRange_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public boolean getUnk3300OFGONAMNIJG() {
            return this.unk3300OFGONAMNIJG_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public int getSceneId() {
            return this.sceneId_;
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
            if (this.queryId_ != 0) {
                output.writeInt32(2, this.queryId_);
            }
            if (this.destinationPos_ != null) {
                output.writeMessage(3, getDestinationPos());
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(4, this.sceneId_);
            }
            if (this.queryType_ != OptionType.OPTION_TYPE_NONE.getNumber()) {
                output.writeEnum(5, this.queryType_);
            }
            if (this.unk3300OFGONAMNIJG_) {
                output.writeBool(6, this.unk3300OFGONAMNIJG_);
            }
            if (this.fuzzyRange_ != 0) {
                output.writeInt32(7, this.fuzzyRange_);
            }
            if (this.unk3300BBLMBILIOGP_) {
                output.writeBool(8, this.unk3300BBLMBILIOGP_);
            }
            if (this.sourcePos_ != null) {
                output.writeMessage(11, getSourcePos());
            }
            if (this.astarMethod_ != AStarMethod.A_STAR_METHOD_CLASSIC.getNumber()) {
                output.writeEnum(12, this.astarMethod_);
            }
            if (this.filterType_ != FilterType.FILTER_TYPE_ALL.getNumber()) {
                output.writeEnum(13, this.filterType_);
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
            if (this.queryId_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(2, this.queryId_);
            }
            if (this.destinationPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getDestinationPos());
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.sceneId_);
            }
            if (this.queryType_ != OptionType.OPTION_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(5, this.queryType_);
            }
            if (this.unk3300OFGONAMNIJG_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.unk3300OFGONAMNIJG_);
            }
            if (this.fuzzyRange_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(7, this.fuzzyRange_);
            }
            if (this.unk3300BBLMBILIOGP_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.unk3300BBLMBILIOGP_);
            }
            if (this.sourcePos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getSourcePos());
            }
            if (this.astarMethod_ != AStarMethod.A_STAR_METHOD_CLASSIC.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(12, this.astarMethod_);
            }
            if (this.filterType_ != FilterType.FILTER_TYPE_ALL.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(13, this.filterType_);
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
            if (!(obj instanceof ToTheMoonQueryPathReq)) {
                return equals(obj);
            }
            ToTheMoonQueryPathReq other = (ToTheMoonQueryPathReq) obj;
            if (this.queryType_ != other.queryType_ || getUnk3300BBLMBILIOGP() != other.getUnk3300BBLMBILIOGP() || this.filterType_ != other.filterType_ || getQueryId() != other.getQueryId() || this.astarMethod_ != other.astarMethod_ || hasSourcePos() != other.hasSourcePos()) {
                return false;
            }
            if ((!hasSourcePos() || getSourcePos().equals(other.getSourcePos())) && hasDestinationPos() == other.hasDestinationPos()) {
                return (!hasDestinationPos() || getDestinationPos().equals(other.getDestinationPos())) && getFuzzyRange() == other.getFuzzyRange() && getUnk3300OFGONAMNIJG() == other.getUnk3300OFGONAMNIJG() && getSceneId() == other.getSceneId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + this.queryType_)) + 8)) + Internal.hashBoolean(getUnk3300BBLMBILIOGP()))) + 13)) + this.filterType_)) + 2)) + getQueryId())) + 12)) + this.astarMethod_;
            if (hasSourcePos()) {
                hash = (53 * ((37 * hash) + 11)) + getSourcePos().hashCode();
            }
            if (hasDestinationPos()) {
                hash = (53 * ((37 * hash) + 3)) + getDestinationPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 7)) + getFuzzyRange())) + 6)) + Internal.hashBoolean(getUnk3300OFGONAMNIJG()))) + 4)) + getSceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ToTheMoonQueryPathReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ToTheMoonQueryPathReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ToTheMoonQueryPathReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ToTheMoonQueryPathReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ToTheMoonQueryPathReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ToTheMoonQueryPathReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ToTheMoonQueryPathReq parseFrom(InputStream input) throws IOException {
            return (ToTheMoonQueryPathReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ToTheMoonQueryPathReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ToTheMoonQueryPathReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ToTheMoonQueryPathReq parseDelimitedFrom(InputStream input) throws IOException {
            return (ToTheMoonQueryPathReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ToTheMoonQueryPathReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ToTheMoonQueryPathReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ToTheMoonQueryPathReq parseFrom(CodedInputStream input) throws IOException {
            return (ToTheMoonQueryPathReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ToTheMoonQueryPathReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ToTheMoonQueryPathReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ToTheMoonQueryPathReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathReqOuterClass$ToTheMoonQueryPathReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ToTheMoonQueryPathReqOrBuilder {
            private boolean unk3300BBLMBILIOGP_;
            private int queryId_;
            private VectorOuterClass.Vector sourcePos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> sourcePosBuilder_;
            private VectorOuterClass.Vector destinationPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> destinationPosBuilder_;
            private int fuzzyRange_;
            private boolean unk3300OFGONAMNIJG_;
            private int sceneId_;
            private int queryType_ = 0;
            private int filterType_ = 0;
            private int astarMethod_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return ToTheMoonQueryPathReqOuterClass.internal_static_ToTheMoonQueryPathReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ToTheMoonQueryPathReqOuterClass.internal_static_ToTheMoonQueryPathReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ToTheMoonQueryPathReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ToTheMoonQueryPathReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.queryType_ = 0;
                this.unk3300BBLMBILIOGP_ = false;
                this.filterType_ = 0;
                this.queryId_ = 0;
                this.astarMethod_ = 0;
                if (this.sourcePosBuilder_ == null) {
                    this.sourcePos_ = null;
                } else {
                    this.sourcePos_ = null;
                    this.sourcePosBuilder_ = null;
                }
                if (this.destinationPosBuilder_ == null) {
                    this.destinationPos_ = null;
                } else {
                    this.destinationPos_ = null;
                    this.destinationPosBuilder_ = null;
                }
                this.fuzzyRange_ = 0;
                this.unk3300OFGONAMNIJG_ = false;
                this.sceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ToTheMoonQueryPathReqOuterClass.internal_static_ToTheMoonQueryPathReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ToTheMoonQueryPathReq getDefaultInstanceForType() {
                return ToTheMoonQueryPathReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ToTheMoonQueryPathReq build() {
                ToTheMoonQueryPathReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ToTheMoonQueryPathReq buildPartial() {
                ToTheMoonQueryPathReq result = new ToTheMoonQueryPathReq(this);
                result.queryType_ = this.queryType_;
                result.unk3300BBLMBILIOGP_ = this.unk3300BBLMBILIOGP_;
                result.filterType_ = this.filterType_;
                result.queryId_ = this.queryId_;
                result.astarMethod_ = this.astarMethod_;
                if (this.sourcePosBuilder_ == null) {
                    result.sourcePos_ = this.sourcePos_;
                } else {
                    result.sourcePos_ = this.sourcePosBuilder_.build();
                }
                if (this.destinationPosBuilder_ == null) {
                    result.destinationPos_ = this.destinationPos_;
                } else {
                    result.destinationPos_ = this.destinationPosBuilder_.build();
                }
                result.fuzzyRange_ = this.fuzzyRange_;
                result.unk3300OFGONAMNIJG_ = this.unk3300OFGONAMNIJG_;
                result.sceneId_ = this.sceneId_;
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
                if (other instanceof ToTheMoonQueryPathReq) {
                    return mergeFrom((ToTheMoonQueryPathReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ToTheMoonQueryPathReq other) {
                if (other == ToTheMoonQueryPathReq.getDefaultInstance()) {
                    return this;
                }
                if (other.queryType_ != 0) {
                    setQueryTypeValue(other.getQueryTypeValue());
                }
                if (other.getUnk3300BBLMBILIOGP()) {
                    setUnk3300BBLMBILIOGP(other.getUnk3300BBLMBILIOGP());
                }
                if (other.filterType_ != 0) {
                    setFilterTypeValue(other.getFilterTypeValue());
                }
                if (other.getQueryId() != 0) {
                    setQueryId(other.getQueryId());
                }
                if (other.astarMethod_ != 0) {
                    setAstarMethodValue(other.getAstarMethodValue());
                }
                if (other.hasSourcePos()) {
                    mergeSourcePos(other.getSourcePos());
                }
                if (other.hasDestinationPos()) {
                    mergeDestinationPos(other.getDestinationPos());
                }
                if (other.getFuzzyRange() != 0) {
                    setFuzzyRange(other.getFuzzyRange());
                }
                if (other.getUnk3300OFGONAMNIJG()) {
                    setUnk3300OFGONAMNIJG(other.getUnk3300OFGONAMNIJG());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
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
                ToTheMoonQueryPathReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = ToTheMoonQueryPathReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ToTheMoonQueryPathReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public int getQueryTypeValue() {
                return this.queryType_;
            }

            public Builder setQueryTypeValue(int value) {
                this.queryType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public OptionType getQueryType() {
                OptionType result = OptionType.valueOf(this.queryType_);
                return result == null ? OptionType.UNRECOGNIZED : result;
            }

            public Builder setQueryType(OptionType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.queryType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearQueryType() {
                this.queryType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public boolean getUnk3300BBLMBILIOGP() {
                return this.unk3300BBLMBILIOGP_;
            }

            public Builder setUnk3300BBLMBILIOGP(boolean value) {
                this.unk3300BBLMBILIOGP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300BBLMBILIOGP() {
                this.unk3300BBLMBILIOGP_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public int getFilterTypeValue() {
                return this.filterType_;
            }

            public Builder setFilterTypeValue(int value) {
                this.filterType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public FilterType getFilterType() {
                FilterType result = FilterType.valueOf(this.filterType_);
                return result == null ? FilterType.UNRECOGNIZED : result;
            }

            public Builder setFilterType(FilterType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.filterType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearFilterType() {
                this.filterType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public int getQueryId() {
                return this.queryId_;
            }

            public Builder setQueryId(int value) {
                this.queryId_ = value;
                onChanged();
                return this;
            }

            public Builder clearQueryId() {
                this.queryId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public int getAstarMethodValue() {
                return this.astarMethod_;
            }

            public Builder setAstarMethodValue(int value) {
                this.astarMethod_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public AStarMethod getAstarMethod() {
                AStarMethod result = AStarMethod.valueOf(this.astarMethod_);
                return result == null ? AStarMethod.UNRECOGNIZED : result;
            }

            public Builder setAstarMethod(AStarMethod value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.astarMethod_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearAstarMethod() {
                this.astarMethod_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public boolean hasSourcePos() {
                return (this.sourcePosBuilder_ == null && this.sourcePos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public VectorOuterClass.Vector getSourcePos() {
                if (this.sourcePosBuilder_ == null) {
                    return this.sourcePos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.sourcePos_;
                }
                return this.sourcePosBuilder_.getMessage();
            }

            public Builder setSourcePos(VectorOuterClass.Vector value) {
                if (this.sourcePosBuilder_ != null) {
                    this.sourcePosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.sourcePos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSourcePos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.sourcePosBuilder_ == null) {
                    this.sourcePos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.sourcePosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSourcePos(VectorOuterClass.Vector value) {
                if (this.sourcePosBuilder_ == null) {
                    if (this.sourcePos_ != null) {
                        this.sourcePos_ = VectorOuterClass.Vector.newBuilder(this.sourcePos_).mergeFrom(value).buildPartial();
                    } else {
                        this.sourcePos_ = value;
                    }
                    onChanged();
                } else {
                    this.sourcePosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSourcePos() {
                if (this.sourcePosBuilder_ == null) {
                    this.sourcePos_ = null;
                    onChanged();
                } else {
                    this.sourcePos_ = null;
                    this.sourcePosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getSourcePosBuilder() {
                onChanged();
                return getSourcePosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public VectorOuterClass.VectorOrBuilder getSourcePosOrBuilder() {
                if (this.sourcePosBuilder_ != null) {
                    return this.sourcePosBuilder_.getMessageOrBuilder();
                }
                return this.sourcePos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.sourcePos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getSourcePosFieldBuilder() {
                if (this.sourcePosBuilder_ == null) {
                    this.sourcePosBuilder_ = new SingleFieldBuilderV3<>(getSourcePos(), getParentForChildren(), isClean());
                    this.sourcePos_ = null;
                }
                return this.sourcePosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public boolean hasDestinationPos() {
                return (this.destinationPosBuilder_ == null && this.destinationPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public VectorOuterClass.Vector getDestinationPos() {
                if (this.destinationPosBuilder_ == null) {
                    return this.destinationPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.destinationPos_;
                }
                return this.destinationPosBuilder_.getMessage();
            }

            public Builder setDestinationPos(VectorOuterClass.Vector value) {
                if (this.destinationPosBuilder_ != null) {
                    this.destinationPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.destinationPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setDestinationPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.destinationPosBuilder_ == null) {
                    this.destinationPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.destinationPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeDestinationPos(VectorOuterClass.Vector value) {
                if (this.destinationPosBuilder_ == null) {
                    if (this.destinationPos_ != null) {
                        this.destinationPos_ = VectorOuterClass.Vector.newBuilder(this.destinationPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.destinationPos_ = value;
                    }
                    onChanged();
                } else {
                    this.destinationPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearDestinationPos() {
                if (this.destinationPosBuilder_ == null) {
                    this.destinationPos_ = null;
                    onChanged();
                } else {
                    this.destinationPos_ = null;
                    this.destinationPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getDestinationPosBuilder() {
                onChanged();
                return getDestinationPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public VectorOuterClass.VectorOrBuilder getDestinationPosOrBuilder() {
                if (this.destinationPosBuilder_ != null) {
                    return this.destinationPosBuilder_.getMessageOrBuilder();
                }
                return this.destinationPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.destinationPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getDestinationPosFieldBuilder() {
                if (this.destinationPosBuilder_ == null) {
                    this.destinationPosBuilder_ = new SingleFieldBuilderV3<>(getDestinationPos(), getParentForChildren(), isClean());
                    this.destinationPos_ = null;
                }
                return this.destinationPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public int getFuzzyRange() {
                return this.fuzzyRange_;
            }

            public Builder setFuzzyRange(int value) {
                this.fuzzyRange_ = value;
                onChanged();
                return this;
            }

            public Builder clearFuzzyRange() {
                this.fuzzyRange_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public boolean getUnk3300OFGONAMNIJG() {
                return this.unk3300OFGONAMNIJG_;
            }

            public Builder setUnk3300OFGONAMNIJG(boolean value) {
                this.unk3300OFGONAMNIJG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300OFGONAMNIJG() {
                this.unk3300OFGONAMNIJG_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static ToTheMoonQueryPathReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ToTheMoonQueryPathReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ToTheMoonQueryPathReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ToTheMoonQueryPathReq getDefaultInstanceForType() {
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
