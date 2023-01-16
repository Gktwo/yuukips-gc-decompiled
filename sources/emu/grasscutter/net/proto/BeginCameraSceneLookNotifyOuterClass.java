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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BeginCameraSceneLookNotifyOuterClass.class */
public final class BeginCameraSceneLookNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n BeginCameraSceneLookNotify.proto\u001a\fVector.proto\"¸\u0005\n\u001aBeginCameraSceneLookNotify\u0012\u001c\n\u0013Unk3300_HKKCHCEMJIE\u0018´\r \u0001(\u0002\u0012\u001b\n\u0013Unk3300_DFPCMOFONNK\u0018\u000f \u0001(\b\u0012\u001b\n\u0013Unk3300_EELNOAICHOJ\u0018\u0004 \u0001(\b\u0012\u001b\n\u0013Unk3300_ODADMBBFPAP\u0018\u0007 \u0001(\b\u0012\u0010\n\bduration\u0018\u0002 \u0001(\u0002\u0012\u001c\n\u0013Unk3300_KCHKKBODNCJ\u0018Ò\r \u0001(\r\u0012\u001b\n\u0013Unk3300_FIOLGCIKFLH\u0018\n \u0001(\u0002\u0012\u0014\n\fother_params\u0018\t \u0003(\t\u0012\u001b\n\u0013Unk3300_NJLBIMJDFHJ\u0018\u0003 \u0001(\b\u0012\u001c\n\u0013Unk3300_AAOGBCCNJAF\u0018È\t \u0001(\b\u0012\u0012\n\tentity_id\u0018û\n \u0001(\r\u0012>\n\rkeep_rot_type\u0018\u000b \u0001(\u000e2'.BeginCameraSceneLookNotify.KeepRotType\u0012$\n\u0013Unk3300_PPCIDICMIEN\u0018\b \u0001(\u000b2\u0007.Vector\u0012\u001c\n\u0013Unk3300_AJEENEOCFON\u0018Å\u0007 \u0001(\r\u0012\u001b\n\u0013Unk3300_ONBDMCHFPDL\u0018\u0005 \u0001(\b\u0012\u001b\n\u0013Unk3300_PIEFLAEGGBI\u0018\u0006 \u0001(\b\u0012$\n\u0013Unk3300_FJDFGLNLMBN\u0018\r \u0001(\u000b2\u0007.Vector\u0012\u001b\n\u0013Unk3300_ILMHDLHLKGJ\u0018\u0001 \u0001(\b\u0012\u001b\n\u0013Unk3300_HCLPGGAOIAC\u0018\f \u0001(\u0002\u0012\u001b\n\u0013Unk3300_HFPCHFNFJKP\u0018\u000e \u0001(\u0002\"8\n\u000bKeepRotType\u0012\u0013\n\u000fKEEP_ROT_TYPE_X\u0010��\u0012\u0014\n\u0010KEEP_ROT_TYPE_XY\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BeginCameraSceneLookNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BeginCameraSceneLookNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BeginCameraSceneLookNotify_descriptor, new String[]{"Unk3300HKKCHCEMJIE", "Unk3300DFPCMOFONNK", "Unk3300EELNOAICHOJ", "Unk3300ODADMBBFPAP", "Duration", "Unk3300KCHKKBODNCJ", "Unk3300FIOLGCIKFLH", "OtherParams", "Unk3300NJLBIMJDFHJ", "Unk3300AAOGBCCNJAF", "EntityId", "KeepRotType", "Unk3300PPCIDICMIEN", "Unk3300AJEENEOCFON", "Unk3300ONBDMCHFPDL", "Unk3300PIEFLAEGGBI", "Unk3300FJDFGLNLMBN", "Unk3300ILMHDLHLKGJ", "Unk3300HCLPGGAOIAC", "Unk3300HFPCHFNFJKP"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BeginCameraSceneLookNotifyOuterClass$BeginCameraSceneLookNotifyOrBuilder.class */
    public interface BeginCameraSceneLookNotifyOrBuilder extends MessageOrBuilder {
        float getUnk3300HKKCHCEMJIE();

        boolean getUnk3300DFPCMOFONNK();

        boolean getUnk3300EELNOAICHOJ();

        boolean getUnk3300ODADMBBFPAP();

        float getDuration();

        int getUnk3300KCHKKBODNCJ();

        float getUnk3300FIOLGCIKFLH();

        List<String> getOtherParamsList();

        int getOtherParamsCount();

        String getOtherParams(int i);

        ByteString getOtherParamsBytes(int i);

        boolean getUnk3300NJLBIMJDFHJ();

        boolean getUnk3300AAOGBCCNJAF();

        int getEntityId();

        int getKeepRotTypeValue();

        BeginCameraSceneLookNotify.KeepRotType getKeepRotType();

        boolean hasUnk3300PPCIDICMIEN();

        VectorOuterClass.Vector getUnk3300PPCIDICMIEN();

        VectorOuterClass.VectorOrBuilder getUnk3300PPCIDICMIENOrBuilder();

        int getUnk3300AJEENEOCFON();

        boolean getUnk3300ONBDMCHFPDL();

        boolean getUnk3300PIEFLAEGGBI();

        boolean hasUnk3300FJDFGLNLMBN();

        VectorOuterClass.Vector getUnk3300FJDFGLNLMBN();

        VectorOuterClass.VectorOrBuilder getUnk3300FJDFGLNLMBNOrBuilder();

        boolean getUnk3300ILMHDLHLKGJ();

        float getUnk3300HCLPGGAOIAC();

        float getUnk3300HFPCHFNFJKP();
    }

    private BeginCameraSceneLookNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BeginCameraSceneLookNotifyOuterClass$BeginCameraSceneLookNotify.class */
    public static final class BeginCameraSceneLookNotify extends GeneratedMessageV3 implements BeginCameraSceneLookNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_HKKCHCEMJIE_FIELD_NUMBER = 1716;
        private float unk3300HKKCHCEMJIE_;
        public static final int UNK3300_DFPCMOFONNK_FIELD_NUMBER = 15;
        private boolean unk3300DFPCMOFONNK_;
        public static final int UNK3300_EELNOAICHOJ_FIELD_NUMBER = 4;
        private boolean unk3300EELNOAICHOJ_;
        public static final int UNK3300_ODADMBBFPAP_FIELD_NUMBER = 7;
        private boolean unk3300ODADMBBFPAP_;
        public static final int DURATION_FIELD_NUMBER = 2;
        private float duration_;
        public static final int UNK3300_KCHKKBODNCJ_FIELD_NUMBER = 1746;
        private int unk3300KCHKKBODNCJ_;
        public static final int UNK3300_FIOLGCIKFLH_FIELD_NUMBER = 10;
        private float unk3300FIOLGCIKFLH_;
        public static final int OTHER_PARAMS_FIELD_NUMBER = 9;
        private LazyStringList otherParams_;
        public static final int UNK3300_NJLBIMJDFHJ_FIELD_NUMBER = 3;
        private boolean unk3300NJLBIMJDFHJ_;
        public static final int UNK3300_AAOGBCCNJAF_FIELD_NUMBER = 1224;
        private boolean unk3300AAOGBCCNJAF_;
        public static final int ENTITY_ID_FIELD_NUMBER = 1403;
        private int entityId_;
        public static final int KEEP_ROT_TYPE_FIELD_NUMBER = 11;
        private int keepRotType_;
        public static final int UNK3300_PPCIDICMIEN_FIELD_NUMBER = 8;
        private VectorOuterClass.Vector unk3300PPCIDICMIEN_;
        public static final int UNK3300_AJEENEOCFON_FIELD_NUMBER = 965;
        private int unk3300AJEENEOCFON_;
        public static final int UNK3300_ONBDMCHFPDL_FIELD_NUMBER = 5;
        private boolean unk3300ONBDMCHFPDL_;
        public static final int UNK3300_PIEFLAEGGBI_FIELD_NUMBER = 6;
        private boolean unk3300PIEFLAEGGBI_;
        public static final int UNK3300_FJDFGLNLMBN_FIELD_NUMBER = 13;
        private VectorOuterClass.Vector unk3300FJDFGLNLMBN_;
        public static final int UNK3300_ILMHDLHLKGJ_FIELD_NUMBER = 1;
        private boolean unk3300ILMHDLHLKGJ_;
        public static final int UNK3300_HCLPGGAOIAC_FIELD_NUMBER = 12;
        private float unk3300HCLPGGAOIAC_;
        public static final int UNK3300_HFPCHFNFJKP_FIELD_NUMBER = 14;
        private float unk3300HFPCHFNFJKP_;
        private byte memoizedIsInitialized;
        private static final BeginCameraSceneLookNotify DEFAULT_INSTANCE = new BeginCameraSceneLookNotify();
        private static final Parser<BeginCameraSceneLookNotify> PARSER = new AbstractParser<BeginCameraSceneLookNotify>() { // from class: emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotify.1
            @Override // com.google.protobuf.Parser
            public BeginCameraSceneLookNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BeginCameraSceneLookNotify(input, extensionRegistry);
            }
        };

        private BeginCameraSceneLookNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BeginCameraSceneLookNotify() {
            this.memoizedIsInitialized = -1;
            this.otherParams_ = LazyStringArrayList.EMPTY;
            this.keepRotType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BeginCameraSceneLookNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BeginCameraSceneLookNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.unk3300ILMHDLHLKGJ_ = input.readBool();
                                    break;
                                case 21:
                                    this.duration_ = input.readFloat();
                                    break;
                                case 24:
                                    this.unk3300NJLBIMJDFHJ_ = input.readBool();
                                    break;
                                case 32:
                                    this.unk3300EELNOAICHOJ_ = input.readBool();
                                    break;
                                case 40:
                                    this.unk3300ONBDMCHFPDL_ = input.readBool();
                                    break;
                                case 48:
                                    this.unk3300PIEFLAEGGBI_ = input.readBool();
                                    break;
                                case 56:
                                    this.unk3300ODADMBBFPAP_ = input.readBool();
                                    break;
                                case 66:
                                    VectorOuterClass.Vector.Builder subBuilder = this.unk3300PPCIDICMIEN_ != null ? this.unk3300PPCIDICMIEN_.toBuilder() : null;
                                    this.unk3300PPCIDICMIEN_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.unk3300PPCIDICMIEN_);
                                        this.unk3300PPCIDICMIEN_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 74:
                                    String s = input.readStringRequireUtf8();
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.otherParams_ = new LazyStringArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.otherParams_.add(s);
                                    break;
                                case 85:
                                    this.unk3300FIOLGCIKFLH_ = input.readFloat();
                                    break;
                                case 88:
                                    this.keepRotType_ = input.readEnum();
                                    break;
                                case 101:
                                    this.unk3300HCLPGGAOIAC_ = input.readFloat();
                                    break;
                                case 106:
                                    VectorOuterClass.Vector.Builder subBuilder2 = this.unk3300FJDFGLNLMBN_ != null ? this.unk3300FJDFGLNLMBN_.toBuilder() : null;
                                    this.unk3300FJDFGLNLMBN_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.unk3300FJDFGLNLMBN_);
                                        this.unk3300FJDFGLNLMBN_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 117:
                                    this.unk3300HFPCHFNFJKP_ = input.readFloat();
                                    break;
                                case 120:
                                    this.unk3300DFPCMOFONNK_ = input.readBool();
                                    break;
                                case 7720:
                                    this.unk3300AJEENEOCFON_ = input.readUInt32();
                                    break;
                                case RET_HOME_BGM_ID_NOT_FOUND_VALUE:
                                    this.unk3300AAOGBCCNJAF_ = input.readBool();
                                    break;
                                case 11224:
                                    this.entityId_ = input.readUInt32();
                                    break;
                                case 13733:
                                    this.unk3300HKKCHCEMJIE_ = input.readFloat();
                                    break;
                                case 13968:
                                    this.unk3300KCHKKBODNCJ_ = input.readUInt32();
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
                    this.otherParams_ = this.otherParams_.getUnmodifiableView();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BeginCameraSceneLookNotifyOuterClass.internal_static_BeginCameraSceneLookNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BeginCameraSceneLookNotifyOuterClass.internal_static_BeginCameraSceneLookNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(BeginCameraSceneLookNotify.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BeginCameraSceneLookNotifyOuterClass$BeginCameraSceneLookNotify$KeepRotType.class */
        public enum KeepRotType implements ProtocolMessageEnum {
            KEEP_ROT_TYPE_X(0),
            KEEP_ROT_TYPE_XY(1),
            UNRECOGNIZED(-1);
            
            public static final int KEEP_ROT_TYPE_X_VALUE = 0;
            public static final int KEEP_ROT_TYPE_XY_VALUE = 1;
            private static final Internal.EnumLiteMap<KeepRotType> internalValueMap = new Internal.EnumLiteMap<KeepRotType>() { // from class: emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotify.KeepRotType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public KeepRotType findValueByNumber(int number) {
                    return KeepRotType.forNumber(number);
                }
            };
            private static final KeepRotType[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static KeepRotType valueOf(int value) {
                return forNumber(value);
            }

            public static KeepRotType forNumber(int value) {
                switch (value) {
                    case 0:
                        return KEEP_ROT_TYPE_X;
                    case 1:
                        return KEEP_ROT_TYPE_XY;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<KeepRotType> internalGetValueMap() {
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
                return BeginCameraSceneLookNotify.getDescriptor().getEnumTypes().get(0);
            }

            public static KeepRotType valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            KeepRotType(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public float getUnk3300HKKCHCEMJIE() {
            return this.unk3300HKKCHCEMJIE_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public boolean getUnk3300DFPCMOFONNK() {
            return this.unk3300DFPCMOFONNK_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public boolean getUnk3300EELNOAICHOJ() {
            return this.unk3300EELNOAICHOJ_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public boolean getUnk3300ODADMBBFPAP() {
            return this.unk3300ODADMBBFPAP_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public float getDuration() {
            return this.duration_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public int getUnk3300KCHKKBODNCJ() {
            return this.unk3300KCHKKBODNCJ_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public float getUnk3300FIOLGCIKFLH() {
            return this.unk3300FIOLGCIKFLH_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public ProtocolStringList getOtherParamsList() {
            return this.otherParams_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public int getOtherParamsCount() {
            return this.otherParams_.size();
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public String getOtherParams(int index) {
            return (String) this.otherParams_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public ByteString getOtherParamsBytes(int index) {
            return this.otherParams_.getByteString(index);
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public boolean getUnk3300NJLBIMJDFHJ() {
            return this.unk3300NJLBIMJDFHJ_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public boolean getUnk3300AAOGBCCNJAF() {
            return this.unk3300AAOGBCCNJAF_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public int getKeepRotTypeValue() {
            return this.keepRotType_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public KeepRotType getKeepRotType() {
            KeepRotType result = KeepRotType.valueOf(this.keepRotType_);
            return result == null ? KeepRotType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public boolean hasUnk3300PPCIDICMIEN() {
            return this.unk3300PPCIDICMIEN_ != null;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public VectorOuterClass.Vector getUnk3300PPCIDICMIEN() {
            return this.unk3300PPCIDICMIEN_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.unk3300PPCIDICMIEN_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public VectorOuterClass.VectorOrBuilder getUnk3300PPCIDICMIENOrBuilder() {
            return getUnk3300PPCIDICMIEN();
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public int getUnk3300AJEENEOCFON() {
            return this.unk3300AJEENEOCFON_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public boolean getUnk3300ONBDMCHFPDL() {
            return this.unk3300ONBDMCHFPDL_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public boolean getUnk3300PIEFLAEGGBI() {
            return this.unk3300PIEFLAEGGBI_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public boolean hasUnk3300FJDFGLNLMBN() {
            return this.unk3300FJDFGLNLMBN_ != null;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public VectorOuterClass.Vector getUnk3300FJDFGLNLMBN() {
            return this.unk3300FJDFGLNLMBN_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.unk3300FJDFGLNLMBN_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public VectorOuterClass.VectorOrBuilder getUnk3300FJDFGLNLMBNOrBuilder() {
            return getUnk3300FJDFGLNLMBN();
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public boolean getUnk3300ILMHDLHLKGJ() {
            return this.unk3300ILMHDLHLKGJ_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public float getUnk3300HCLPGGAOIAC() {
            return this.unk3300HCLPGGAOIAC_;
        }

        @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
        public float getUnk3300HFPCHFNFJKP() {
            return this.unk3300HFPCHFNFJKP_;
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
            if (this.unk3300ILMHDLHLKGJ_) {
                output.writeBool(1, this.unk3300ILMHDLHLKGJ_);
            }
            if (this.duration_ != 0.0f) {
                output.writeFloat(2, this.duration_);
            }
            if (this.unk3300NJLBIMJDFHJ_) {
                output.writeBool(3, this.unk3300NJLBIMJDFHJ_);
            }
            if (this.unk3300EELNOAICHOJ_) {
                output.writeBool(4, this.unk3300EELNOAICHOJ_);
            }
            if (this.unk3300ONBDMCHFPDL_) {
                output.writeBool(5, this.unk3300ONBDMCHFPDL_);
            }
            if (this.unk3300PIEFLAEGGBI_) {
                output.writeBool(6, this.unk3300PIEFLAEGGBI_);
            }
            if (this.unk3300ODADMBBFPAP_) {
                output.writeBool(7, this.unk3300ODADMBBFPAP_);
            }
            if (this.unk3300PPCIDICMIEN_ != null) {
                output.writeMessage(8, getUnk3300PPCIDICMIEN());
            }
            for (int i = 0; i < this.otherParams_.size(); i++) {
                GeneratedMessageV3.writeString(output, 9, this.otherParams_.getRaw(i));
            }
            if (this.unk3300FIOLGCIKFLH_ != 0.0f) {
                output.writeFloat(10, this.unk3300FIOLGCIKFLH_);
            }
            if (this.keepRotType_ != KeepRotType.KEEP_ROT_TYPE_X.getNumber()) {
                output.writeEnum(11, this.keepRotType_);
            }
            if (this.unk3300HCLPGGAOIAC_ != 0.0f) {
                output.writeFloat(12, this.unk3300HCLPGGAOIAC_);
            }
            if (this.unk3300FJDFGLNLMBN_ != null) {
                output.writeMessage(13, getUnk3300FJDFGLNLMBN());
            }
            if (this.unk3300HFPCHFNFJKP_ != 0.0f) {
                output.writeFloat(14, this.unk3300HFPCHFNFJKP_);
            }
            if (this.unk3300DFPCMOFONNK_) {
                output.writeBool(15, this.unk3300DFPCMOFONNK_);
            }
            if (this.unk3300AJEENEOCFON_ != 0) {
                output.writeUInt32(UNK3300_AJEENEOCFON_FIELD_NUMBER, this.unk3300AJEENEOCFON_);
            }
            if (this.unk3300AAOGBCCNJAF_) {
                output.writeBool(1224, this.unk3300AAOGBCCNJAF_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(1403, this.entityId_);
            }
            if (this.unk3300HKKCHCEMJIE_ != 0.0f) {
                output.writeFloat(UNK3300_HKKCHCEMJIE_FIELD_NUMBER, this.unk3300HKKCHCEMJIE_);
            }
            if (this.unk3300KCHKKBODNCJ_ != 0) {
                output.writeUInt32(UNK3300_KCHKKBODNCJ_FIELD_NUMBER, this.unk3300KCHKKBODNCJ_);
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
            if (this.unk3300ILMHDLHLKGJ_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.unk3300ILMHDLHLKGJ_);
            }
            if (this.duration_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(2, this.duration_);
            }
            if (this.unk3300NJLBIMJDFHJ_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.unk3300NJLBIMJDFHJ_);
            }
            if (this.unk3300EELNOAICHOJ_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.unk3300EELNOAICHOJ_);
            }
            if (this.unk3300ONBDMCHFPDL_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.unk3300ONBDMCHFPDL_);
            }
            if (this.unk3300PIEFLAEGGBI_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.unk3300PIEFLAEGGBI_);
            }
            if (this.unk3300ODADMBBFPAP_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.unk3300ODADMBBFPAP_);
            }
            if (this.unk3300PPCIDICMIEN_ != null) {
                size2 += CodedOutputStream.computeMessageSize(8, getUnk3300PPCIDICMIEN());
            }
            int dataSize = 0;
            for (int i = 0; i < this.otherParams_.size(); i++) {
                dataSize += computeStringSizeNoTag(this.otherParams_.getRaw(i));
            }
            int size3 = size2 + dataSize + (1 * getOtherParamsList().size());
            if (this.unk3300FIOLGCIKFLH_ != 0.0f) {
                size3 += CodedOutputStream.computeFloatSize(10, this.unk3300FIOLGCIKFLH_);
            }
            if (this.keepRotType_ != KeepRotType.KEEP_ROT_TYPE_X.getNumber()) {
                size3 += CodedOutputStream.computeEnumSize(11, this.keepRotType_);
            }
            if (this.unk3300HCLPGGAOIAC_ != 0.0f) {
                size3 += CodedOutputStream.computeFloatSize(12, this.unk3300HCLPGGAOIAC_);
            }
            if (this.unk3300FJDFGLNLMBN_ != null) {
                size3 += CodedOutputStream.computeMessageSize(13, getUnk3300FJDFGLNLMBN());
            }
            if (this.unk3300HFPCHFNFJKP_ != 0.0f) {
                size3 += CodedOutputStream.computeFloatSize(14, this.unk3300HFPCHFNFJKP_);
            }
            if (this.unk3300DFPCMOFONNK_) {
                size3 += CodedOutputStream.computeBoolSize(15, this.unk3300DFPCMOFONNK_);
            }
            if (this.unk3300AJEENEOCFON_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(UNK3300_AJEENEOCFON_FIELD_NUMBER, this.unk3300AJEENEOCFON_);
            }
            if (this.unk3300AAOGBCCNJAF_) {
                size3 += CodedOutputStream.computeBoolSize(1224, this.unk3300AAOGBCCNJAF_);
            }
            if (this.entityId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(1403, this.entityId_);
            }
            if (this.unk3300HKKCHCEMJIE_ != 0.0f) {
                size3 += CodedOutputStream.computeFloatSize(UNK3300_HKKCHCEMJIE_FIELD_NUMBER, this.unk3300HKKCHCEMJIE_);
            }
            if (this.unk3300KCHKKBODNCJ_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(UNK3300_KCHKKBODNCJ_FIELD_NUMBER, this.unk3300KCHKKBODNCJ_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BeginCameraSceneLookNotify)) {
                return equals(obj);
            }
            BeginCameraSceneLookNotify other = (BeginCameraSceneLookNotify) obj;
            if (Float.floatToIntBits(getUnk3300HKKCHCEMJIE()) != Float.floatToIntBits(other.getUnk3300HKKCHCEMJIE()) || getUnk3300DFPCMOFONNK() != other.getUnk3300DFPCMOFONNK() || getUnk3300EELNOAICHOJ() != other.getUnk3300EELNOAICHOJ() || getUnk3300ODADMBBFPAP() != other.getUnk3300ODADMBBFPAP() || Float.floatToIntBits(getDuration()) != Float.floatToIntBits(other.getDuration()) || getUnk3300KCHKKBODNCJ() != other.getUnk3300KCHKKBODNCJ() || Float.floatToIntBits(getUnk3300FIOLGCIKFLH()) != Float.floatToIntBits(other.getUnk3300FIOLGCIKFLH()) || !getOtherParamsList().equals(other.getOtherParamsList()) || getUnk3300NJLBIMJDFHJ() != other.getUnk3300NJLBIMJDFHJ() || getUnk3300AAOGBCCNJAF() != other.getUnk3300AAOGBCCNJAF() || getEntityId() != other.getEntityId() || this.keepRotType_ != other.keepRotType_ || hasUnk3300PPCIDICMIEN() != other.hasUnk3300PPCIDICMIEN()) {
                return false;
            }
            if ((!hasUnk3300PPCIDICMIEN() || getUnk3300PPCIDICMIEN().equals(other.getUnk3300PPCIDICMIEN())) && getUnk3300AJEENEOCFON() == other.getUnk3300AJEENEOCFON() && getUnk3300ONBDMCHFPDL() == other.getUnk3300ONBDMCHFPDL() && getUnk3300PIEFLAEGGBI() == other.getUnk3300PIEFLAEGGBI() && hasUnk3300FJDFGLNLMBN() == other.hasUnk3300FJDFGLNLMBN()) {
                return (!hasUnk3300FJDFGLNLMBN() || getUnk3300FJDFGLNLMBN().equals(other.getUnk3300FJDFGLNLMBN())) && getUnk3300ILMHDLHLKGJ() == other.getUnk3300ILMHDLHLKGJ() && Float.floatToIntBits(getUnk3300HCLPGGAOIAC()) == Float.floatToIntBits(other.getUnk3300HCLPGGAOIAC()) && Float.floatToIntBits(getUnk3300HFPCHFNFJKP()) == Float.floatToIntBits(other.getUnk3300HFPCHFNFJKP()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + UNK3300_HKKCHCEMJIE_FIELD_NUMBER)) + Float.floatToIntBits(getUnk3300HKKCHCEMJIE()))) + 15)) + Internal.hashBoolean(getUnk3300DFPCMOFONNK()))) + 4)) + Internal.hashBoolean(getUnk3300EELNOAICHOJ()))) + 7)) + Internal.hashBoolean(getUnk3300ODADMBBFPAP()))) + 2)) + Float.floatToIntBits(getDuration()))) + UNK3300_KCHKKBODNCJ_FIELD_NUMBER)) + getUnk3300KCHKKBODNCJ())) + 10)) + Float.floatToIntBits(getUnk3300FIOLGCIKFLH());
            if (getOtherParamsCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getOtherParamsList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 3)) + Internal.hashBoolean(getUnk3300NJLBIMJDFHJ()))) + 1224)) + Internal.hashBoolean(getUnk3300AAOGBCCNJAF()))) + 1403)) + getEntityId())) + 11)) + this.keepRotType_;
            if (hasUnk3300PPCIDICMIEN()) {
                hash2 = (53 * ((37 * hash2) + 8)) + getUnk3300PPCIDICMIEN().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + UNK3300_AJEENEOCFON_FIELD_NUMBER)) + getUnk3300AJEENEOCFON())) + 5)) + Internal.hashBoolean(getUnk3300ONBDMCHFPDL()))) + 6)) + Internal.hashBoolean(getUnk3300PIEFLAEGGBI());
            if (hasUnk3300FJDFGLNLMBN()) {
                hash3 = (53 * ((37 * hash3) + 13)) + getUnk3300FJDFGLNLMBN().hashCode();
            }
            int hash4 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash3) + 1)) + Internal.hashBoolean(getUnk3300ILMHDLHLKGJ()))) + 12)) + Float.floatToIntBits(getUnk3300HCLPGGAOIAC()))) + 14)) + Float.floatToIntBits(getUnk3300HFPCHFNFJKP()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static BeginCameraSceneLookNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BeginCameraSceneLookNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BeginCameraSceneLookNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BeginCameraSceneLookNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BeginCameraSceneLookNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BeginCameraSceneLookNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BeginCameraSceneLookNotify parseFrom(InputStream input) throws IOException {
            return (BeginCameraSceneLookNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BeginCameraSceneLookNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BeginCameraSceneLookNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BeginCameraSceneLookNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (BeginCameraSceneLookNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BeginCameraSceneLookNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BeginCameraSceneLookNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BeginCameraSceneLookNotify parseFrom(CodedInputStream input) throws IOException {
            return (BeginCameraSceneLookNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BeginCameraSceneLookNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BeginCameraSceneLookNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BeginCameraSceneLookNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BeginCameraSceneLookNotifyOuterClass$BeginCameraSceneLookNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BeginCameraSceneLookNotifyOrBuilder {
            private int bitField0_;
            private float unk3300HKKCHCEMJIE_;
            private boolean unk3300DFPCMOFONNK_;
            private boolean unk3300EELNOAICHOJ_;
            private boolean unk3300ODADMBBFPAP_;
            private float duration_;
            private int unk3300KCHKKBODNCJ_;
            private float unk3300FIOLGCIKFLH_;
            private boolean unk3300NJLBIMJDFHJ_;
            private boolean unk3300AAOGBCCNJAF_;
            private int entityId_;
            private VectorOuterClass.Vector unk3300PPCIDICMIEN_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> unk3300PPCIDICMIENBuilder_;
            private int unk3300AJEENEOCFON_;
            private boolean unk3300ONBDMCHFPDL_;
            private boolean unk3300PIEFLAEGGBI_;
            private VectorOuterClass.Vector unk3300FJDFGLNLMBN_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> unk3300FJDFGLNLMBNBuilder_;
            private boolean unk3300ILMHDLHLKGJ_;
            private float unk3300HCLPGGAOIAC_;
            private float unk3300HFPCHFNFJKP_;
            private LazyStringList otherParams_ = LazyStringArrayList.EMPTY;
            private int keepRotType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return BeginCameraSceneLookNotifyOuterClass.internal_static_BeginCameraSceneLookNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BeginCameraSceneLookNotifyOuterClass.internal_static_BeginCameraSceneLookNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(BeginCameraSceneLookNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BeginCameraSceneLookNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300HKKCHCEMJIE_ = 0.0f;
                this.unk3300DFPCMOFONNK_ = false;
                this.unk3300EELNOAICHOJ_ = false;
                this.unk3300ODADMBBFPAP_ = false;
                this.duration_ = 0.0f;
                this.unk3300KCHKKBODNCJ_ = 0;
                this.unk3300FIOLGCIKFLH_ = 0.0f;
                this.otherParams_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                this.unk3300NJLBIMJDFHJ_ = false;
                this.unk3300AAOGBCCNJAF_ = false;
                this.entityId_ = 0;
                this.keepRotType_ = 0;
                if (this.unk3300PPCIDICMIENBuilder_ == null) {
                    this.unk3300PPCIDICMIEN_ = null;
                } else {
                    this.unk3300PPCIDICMIEN_ = null;
                    this.unk3300PPCIDICMIENBuilder_ = null;
                }
                this.unk3300AJEENEOCFON_ = 0;
                this.unk3300ONBDMCHFPDL_ = false;
                this.unk3300PIEFLAEGGBI_ = false;
                if (this.unk3300FJDFGLNLMBNBuilder_ == null) {
                    this.unk3300FJDFGLNLMBN_ = null;
                } else {
                    this.unk3300FJDFGLNLMBN_ = null;
                    this.unk3300FJDFGLNLMBNBuilder_ = null;
                }
                this.unk3300ILMHDLHLKGJ_ = false;
                this.unk3300HCLPGGAOIAC_ = 0.0f;
                this.unk3300HFPCHFNFJKP_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BeginCameraSceneLookNotifyOuterClass.internal_static_BeginCameraSceneLookNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BeginCameraSceneLookNotify getDefaultInstanceForType() {
                return BeginCameraSceneLookNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BeginCameraSceneLookNotify build() {
                BeginCameraSceneLookNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BeginCameraSceneLookNotify buildPartial() {
                BeginCameraSceneLookNotify result = new BeginCameraSceneLookNotify(this);
                int i = this.bitField0_;
                result.unk3300HKKCHCEMJIE_ = this.unk3300HKKCHCEMJIE_;
                result.unk3300DFPCMOFONNK_ = this.unk3300DFPCMOFONNK_;
                result.unk3300EELNOAICHOJ_ = this.unk3300EELNOAICHOJ_;
                result.unk3300ODADMBBFPAP_ = this.unk3300ODADMBBFPAP_;
                result.duration_ = this.duration_;
                result.unk3300KCHKKBODNCJ_ = this.unk3300KCHKKBODNCJ_;
                result.unk3300FIOLGCIKFLH_ = this.unk3300FIOLGCIKFLH_;
                if ((this.bitField0_ & 1) != 0) {
                    this.otherParams_ = this.otherParams_.getUnmodifiableView();
                    this.bitField0_ &= -2;
                }
                result.otherParams_ = this.otherParams_;
                result.unk3300NJLBIMJDFHJ_ = this.unk3300NJLBIMJDFHJ_;
                result.unk3300AAOGBCCNJAF_ = this.unk3300AAOGBCCNJAF_;
                result.entityId_ = this.entityId_;
                result.keepRotType_ = this.keepRotType_;
                if (this.unk3300PPCIDICMIENBuilder_ == null) {
                    result.unk3300PPCIDICMIEN_ = this.unk3300PPCIDICMIEN_;
                } else {
                    result.unk3300PPCIDICMIEN_ = this.unk3300PPCIDICMIENBuilder_.build();
                }
                result.unk3300AJEENEOCFON_ = this.unk3300AJEENEOCFON_;
                result.unk3300ONBDMCHFPDL_ = this.unk3300ONBDMCHFPDL_;
                result.unk3300PIEFLAEGGBI_ = this.unk3300PIEFLAEGGBI_;
                if (this.unk3300FJDFGLNLMBNBuilder_ == null) {
                    result.unk3300FJDFGLNLMBN_ = this.unk3300FJDFGLNLMBN_;
                } else {
                    result.unk3300FJDFGLNLMBN_ = this.unk3300FJDFGLNLMBNBuilder_.build();
                }
                result.unk3300ILMHDLHLKGJ_ = this.unk3300ILMHDLHLKGJ_;
                result.unk3300HCLPGGAOIAC_ = this.unk3300HCLPGGAOIAC_;
                result.unk3300HFPCHFNFJKP_ = this.unk3300HFPCHFNFJKP_;
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
                if (other instanceof BeginCameraSceneLookNotify) {
                    return mergeFrom((BeginCameraSceneLookNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BeginCameraSceneLookNotify other) {
                if (other == BeginCameraSceneLookNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300HKKCHCEMJIE() != 0.0f) {
                    setUnk3300HKKCHCEMJIE(other.getUnk3300HKKCHCEMJIE());
                }
                if (other.getUnk3300DFPCMOFONNK()) {
                    setUnk3300DFPCMOFONNK(other.getUnk3300DFPCMOFONNK());
                }
                if (other.getUnk3300EELNOAICHOJ()) {
                    setUnk3300EELNOAICHOJ(other.getUnk3300EELNOAICHOJ());
                }
                if (other.getUnk3300ODADMBBFPAP()) {
                    setUnk3300ODADMBBFPAP(other.getUnk3300ODADMBBFPAP());
                }
                if (other.getDuration() != 0.0f) {
                    setDuration(other.getDuration());
                }
                if (other.getUnk3300KCHKKBODNCJ() != 0) {
                    setUnk3300KCHKKBODNCJ(other.getUnk3300KCHKKBODNCJ());
                }
                if (other.getUnk3300FIOLGCIKFLH() != 0.0f) {
                    setUnk3300FIOLGCIKFLH(other.getUnk3300FIOLGCIKFLH());
                }
                if (!other.otherParams_.isEmpty()) {
                    if (this.otherParams_.isEmpty()) {
                        this.otherParams_ = other.otherParams_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureOtherParamsIsMutable();
                        this.otherParams_.addAll(other.otherParams_);
                    }
                    onChanged();
                }
                if (other.getUnk3300NJLBIMJDFHJ()) {
                    setUnk3300NJLBIMJDFHJ(other.getUnk3300NJLBIMJDFHJ());
                }
                if (other.getUnk3300AAOGBCCNJAF()) {
                    setUnk3300AAOGBCCNJAF(other.getUnk3300AAOGBCCNJAF());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.keepRotType_ != 0) {
                    setKeepRotTypeValue(other.getKeepRotTypeValue());
                }
                if (other.hasUnk3300PPCIDICMIEN()) {
                    mergeUnk3300PPCIDICMIEN(other.getUnk3300PPCIDICMIEN());
                }
                if (other.getUnk3300AJEENEOCFON() != 0) {
                    setUnk3300AJEENEOCFON(other.getUnk3300AJEENEOCFON());
                }
                if (other.getUnk3300ONBDMCHFPDL()) {
                    setUnk3300ONBDMCHFPDL(other.getUnk3300ONBDMCHFPDL());
                }
                if (other.getUnk3300PIEFLAEGGBI()) {
                    setUnk3300PIEFLAEGGBI(other.getUnk3300PIEFLAEGGBI());
                }
                if (other.hasUnk3300FJDFGLNLMBN()) {
                    mergeUnk3300FJDFGLNLMBN(other.getUnk3300FJDFGLNLMBN());
                }
                if (other.getUnk3300ILMHDLHLKGJ()) {
                    setUnk3300ILMHDLHLKGJ(other.getUnk3300ILMHDLHLKGJ());
                }
                if (other.getUnk3300HCLPGGAOIAC() != 0.0f) {
                    setUnk3300HCLPGGAOIAC(other.getUnk3300HCLPGGAOIAC());
                }
                if (other.getUnk3300HFPCHFNFJKP() != 0.0f) {
                    setUnk3300HFPCHFNFJKP(other.getUnk3300HFPCHFNFJKP());
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
                BeginCameraSceneLookNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = BeginCameraSceneLookNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BeginCameraSceneLookNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public float getUnk3300HKKCHCEMJIE() {
                return this.unk3300HKKCHCEMJIE_;
            }

            public Builder setUnk3300HKKCHCEMJIE(float value) {
                this.unk3300HKKCHCEMJIE_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HKKCHCEMJIE() {
                this.unk3300HKKCHCEMJIE_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public boolean getUnk3300DFPCMOFONNK() {
                return this.unk3300DFPCMOFONNK_;
            }

            public Builder setUnk3300DFPCMOFONNK(boolean value) {
                this.unk3300DFPCMOFONNK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DFPCMOFONNK() {
                this.unk3300DFPCMOFONNK_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public boolean getUnk3300EELNOAICHOJ() {
                return this.unk3300EELNOAICHOJ_;
            }

            public Builder setUnk3300EELNOAICHOJ(boolean value) {
                this.unk3300EELNOAICHOJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300EELNOAICHOJ() {
                this.unk3300EELNOAICHOJ_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public boolean getUnk3300ODADMBBFPAP() {
                return this.unk3300ODADMBBFPAP_;
            }

            public Builder setUnk3300ODADMBBFPAP(boolean value) {
                this.unk3300ODADMBBFPAP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ODADMBBFPAP() {
                this.unk3300ODADMBBFPAP_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public float getDuration() {
                return this.duration_;
            }

            public Builder setDuration(float value) {
                this.duration_ = value;
                onChanged();
                return this;
            }

            public Builder clearDuration() {
                this.duration_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public int getUnk3300KCHKKBODNCJ() {
                return this.unk3300KCHKKBODNCJ_;
            }

            public Builder setUnk3300KCHKKBODNCJ(int value) {
                this.unk3300KCHKKBODNCJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300KCHKKBODNCJ() {
                this.unk3300KCHKKBODNCJ_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public float getUnk3300FIOLGCIKFLH() {
                return this.unk3300FIOLGCIKFLH_;
            }

            public Builder setUnk3300FIOLGCIKFLH(float value) {
                this.unk3300FIOLGCIKFLH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300FIOLGCIKFLH() {
                this.unk3300FIOLGCIKFLH_ = 0.0f;
                onChanged();
                return this;
            }

            private void ensureOtherParamsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.otherParams_ = new LazyStringArrayList(this.otherParams_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public ProtocolStringList getOtherParamsList() {
                return this.otherParams_.getUnmodifiableView();
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public int getOtherParamsCount() {
                return this.otherParams_.size();
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public String getOtherParams(int index) {
                return (String) this.otherParams_.get(index);
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public ByteString getOtherParamsBytes(int index) {
                return this.otherParams_.getByteString(index);
            }

            public Builder setOtherParams(int index, String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureOtherParamsIsMutable();
                this.otherParams_.set(index, value);
                onChanged();
                return this;
            }

            public Builder addOtherParams(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureOtherParamsIsMutable();
                this.otherParams_.add(value);
                onChanged();
                return this;
            }

            public Builder addAllOtherParams(Iterable<String> values) {
                ensureOtherParamsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.otherParams_);
                onChanged();
                return this;
            }

            public Builder clearOtherParams() {
                this.otherParams_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder addOtherParamsBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                BeginCameraSceneLookNotify.checkByteStringIsUtf8(value);
                ensureOtherParamsIsMutable();
                this.otherParams_.add(value);
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public boolean getUnk3300NJLBIMJDFHJ() {
                return this.unk3300NJLBIMJDFHJ_;
            }

            public Builder setUnk3300NJLBIMJDFHJ(boolean value) {
                this.unk3300NJLBIMJDFHJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NJLBIMJDFHJ() {
                this.unk3300NJLBIMJDFHJ_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public boolean getUnk3300AAOGBCCNJAF() {
                return this.unk3300AAOGBCCNJAF_;
            }

            public Builder setUnk3300AAOGBCCNJAF(boolean value) {
                this.unk3300AAOGBCCNJAF_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300AAOGBCCNJAF() {
                this.unk3300AAOGBCCNJAF_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public int getKeepRotTypeValue() {
                return this.keepRotType_;
            }

            public Builder setKeepRotTypeValue(int value) {
                this.keepRotType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public KeepRotType getKeepRotType() {
                KeepRotType result = KeepRotType.valueOf(this.keepRotType_);
                return result == null ? KeepRotType.UNRECOGNIZED : result;
            }

            public Builder setKeepRotType(KeepRotType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.keepRotType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearKeepRotType() {
                this.keepRotType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public boolean hasUnk3300PPCIDICMIEN() {
                return (this.unk3300PPCIDICMIENBuilder_ == null && this.unk3300PPCIDICMIEN_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public VectorOuterClass.Vector getUnk3300PPCIDICMIEN() {
                if (this.unk3300PPCIDICMIENBuilder_ == null) {
                    return this.unk3300PPCIDICMIEN_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.unk3300PPCIDICMIEN_;
                }
                return this.unk3300PPCIDICMIENBuilder_.getMessage();
            }

            public Builder setUnk3300PPCIDICMIEN(VectorOuterClass.Vector value) {
                if (this.unk3300PPCIDICMIENBuilder_ != null) {
                    this.unk3300PPCIDICMIENBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.unk3300PPCIDICMIEN_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setUnk3300PPCIDICMIEN(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.unk3300PPCIDICMIENBuilder_ == null) {
                    this.unk3300PPCIDICMIEN_ = builderForValue.build();
                    onChanged();
                } else {
                    this.unk3300PPCIDICMIENBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeUnk3300PPCIDICMIEN(VectorOuterClass.Vector value) {
                if (this.unk3300PPCIDICMIENBuilder_ == null) {
                    if (this.unk3300PPCIDICMIEN_ != null) {
                        this.unk3300PPCIDICMIEN_ = VectorOuterClass.Vector.newBuilder(this.unk3300PPCIDICMIEN_).mergeFrom(value).buildPartial();
                    } else {
                        this.unk3300PPCIDICMIEN_ = value;
                    }
                    onChanged();
                } else {
                    this.unk3300PPCIDICMIENBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearUnk3300PPCIDICMIEN() {
                if (this.unk3300PPCIDICMIENBuilder_ == null) {
                    this.unk3300PPCIDICMIEN_ = null;
                    onChanged();
                } else {
                    this.unk3300PPCIDICMIEN_ = null;
                    this.unk3300PPCIDICMIENBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getUnk3300PPCIDICMIENBuilder() {
                onChanged();
                return getUnk3300PPCIDICMIENFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public VectorOuterClass.VectorOrBuilder getUnk3300PPCIDICMIENOrBuilder() {
                if (this.unk3300PPCIDICMIENBuilder_ != null) {
                    return this.unk3300PPCIDICMIENBuilder_.getMessageOrBuilder();
                }
                return this.unk3300PPCIDICMIEN_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.unk3300PPCIDICMIEN_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getUnk3300PPCIDICMIENFieldBuilder() {
                if (this.unk3300PPCIDICMIENBuilder_ == null) {
                    this.unk3300PPCIDICMIENBuilder_ = new SingleFieldBuilderV3<>(getUnk3300PPCIDICMIEN(), getParentForChildren(), isClean());
                    this.unk3300PPCIDICMIEN_ = null;
                }
                return this.unk3300PPCIDICMIENBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public int getUnk3300AJEENEOCFON() {
                return this.unk3300AJEENEOCFON_;
            }

            public Builder setUnk3300AJEENEOCFON(int value) {
                this.unk3300AJEENEOCFON_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300AJEENEOCFON() {
                this.unk3300AJEENEOCFON_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public boolean getUnk3300ONBDMCHFPDL() {
                return this.unk3300ONBDMCHFPDL_;
            }

            public Builder setUnk3300ONBDMCHFPDL(boolean value) {
                this.unk3300ONBDMCHFPDL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ONBDMCHFPDL() {
                this.unk3300ONBDMCHFPDL_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public boolean getUnk3300PIEFLAEGGBI() {
                return this.unk3300PIEFLAEGGBI_;
            }

            public Builder setUnk3300PIEFLAEGGBI(boolean value) {
                this.unk3300PIEFLAEGGBI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PIEFLAEGGBI() {
                this.unk3300PIEFLAEGGBI_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public boolean hasUnk3300FJDFGLNLMBN() {
                return (this.unk3300FJDFGLNLMBNBuilder_ == null && this.unk3300FJDFGLNLMBN_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public VectorOuterClass.Vector getUnk3300FJDFGLNLMBN() {
                if (this.unk3300FJDFGLNLMBNBuilder_ == null) {
                    return this.unk3300FJDFGLNLMBN_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.unk3300FJDFGLNLMBN_;
                }
                return this.unk3300FJDFGLNLMBNBuilder_.getMessage();
            }

            public Builder setUnk3300FJDFGLNLMBN(VectorOuterClass.Vector value) {
                if (this.unk3300FJDFGLNLMBNBuilder_ != null) {
                    this.unk3300FJDFGLNLMBNBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.unk3300FJDFGLNLMBN_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setUnk3300FJDFGLNLMBN(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.unk3300FJDFGLNLMBNBuilder_ == null) {
                    this.unk3300FJDFGLNLMBN_ = builderForValue.build();
                    onChanged();
                } else {
                    this.unk3300FJDFGLNLMBNBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeUnk3300FJDFGLNLMBN(VectorOuterClass.Vector value) {
                if (this.unk3300FJDFGLNLMBNBuilder_ == null) {
                    if (this.unk3300FJDFGLNLMBN_ != null) {
                        this.unk3300FJDFGLNLMBN_ = VectorOuterClass.Vector.newBuilder(this.unk3300FJDFGLNLMBN_).mergeFrom(value).buildPartial();
                    } else {
                        this.unk3300FJDFGLNLMBN_ = value;
                    }
                    onChanged();
                } else {
                    this.unk3300FJDFGLNLMBNBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearUnk3300FJDFGLNLMBN() {
                if (this.unk3300FJDFGLNLMBNBuilder_ == null) {
                    this.unk3300FJDFGLNLMBN_ = null;
                    onChanged();
                } else {
                    this.unk3300FJDFGLNLMBN_ = null;
                    this.unk3300FJDFGLNLMBNBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getUnk3300FJDFGLNLMBNBuilder() {
                onChanged();
                return getUnk3300FJDFGLNLMBNFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public VectorOuterClass.VectorOrBuilder getUnk3300FJDFGLNLMBNOrBuilder() {
                if (this.unk3300FJDFGLNLMBNBuilder_ != null) {
                    return this.unk3300FJDFGLNLMBNBuilder_.getMessageOrBuilder();
                }
                return this.unk3300FJDFGLNLMBN_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.unk3300FJDFGLNLMBN_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getUnk3300FJDFGLNLMBNFieldBuilder() {
                if (this.unk3300FJDFGLNLMBNBuilder_ == null) {
                    this.unk3300FJDFGLNLMBNBuilder_ = new SingleFieldBuilderV3<>(getUnk3300FJDFGLNLMBN(), getParentForChildren(), isClean());
                    this.unk3300FJDFGLNLMBN_ = null;
                }
                return this.unk3300FJDFGLNLMBNBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public boolean getUnk3300ILMHDLHLKGJ() {
                return this.unk3300ILMHDLHLKGJ_;
            }

            public Builder setUnk3300ILMHDLHLKGJ(boolean value) {
                this.unk3300ILMHDLHLKGJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ILMHDLHLKGJ() {
                this.unk3300ILMHDLHLKGJ_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public float getUnk3300HCLPGGAOIAC() {
                return this.unk3300HCLPGGAOIAC_;
            }

            public Builder setUnk3300HCLPGGAOIAC(float value) {
                this.unk3300HCLPGGAOIAC_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HCLPGGAOIAC() {
                this.unk3300HCLPGGAOIAC_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BeginCameraSceneLookNotifyOuterClass.BeginCameraSceneLookNotifyOrBuilder
            public float getUnk3300HFPCHFNFJKP() {
                return this.unk3300HFPCHFNFJKP_;
            }

            public Builder setUnk3300HFPCHFNFJKP(float value) {
                this.unk3300HFPCHFNFJKP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HFPCHFNFJKP() {
                this.unk3300HFPCHFNFJKP_ = 0.0f;
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

        public static BeginCameraSceneLookNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BeginCameraSceneLookNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BeginCameraSceneLookNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BeginCameraSceneLookNotify getDefaultInstanceForType() {
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
