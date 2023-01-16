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
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.VintageBoothUsedItemDataOuterClass;
import emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass;
import emu.grasscutter.net.proto.VintageHuntingStageDataOuterClass;
import emu.grasscutter.net.proto.VintageMarketInfoOuterClass;
import emu.grasscutter.net.proto.VintagePresentStageDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageActivityDetailInfoOuterClass.class */
public final class VintageActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fVintageActivityDetailInfo.proto\u001a\u001eVintageBoothUsedItemData.proto\u001a#VintageCampChallengeStageData.proto\u001a\u001dVintageHuntingStageData.proto\u001a\u0017VintageMarketInfo.proto\u001a\u001dVintagePresentStageData.proto\"\u0005\n\u0019VintageActivityDetailInfo\u0012O\n\u0013Unk3300_PCIIGPJJHGF\u0018\u000b \u0003(\u000b22.VintageActivityDetailInfo.Unk3300PCIIGPJJHGFEntry\u0012\u0019\n\u0011is_content_closed\u0018\r \u0001(\b\u0012O\n\u0013Unk3300_EHHPFKIOKOO\u0018\n \u0003(\u000b22.VintageActivityDetailInfo.Unk3300EHHPFKIOKOOEntry\u0012-\n\nbooth_data\u0018\t \u0001(\u000b2\u0019.VintageBoothUsedItemData\u0012O\n\u0013Unk3300_NPKMDFCLGBJ\u0018\u0002 \u0003(\u000b22.VintageActivityDetailInfo.Unk3300NPKMDFCLGBJEntry\u0012'\n\u000bmarket_info\u0018\u000e \u0001(\u000b2\u0012.VintageMarketInfo\u001aS\n\u0017Unk3300PCIIGPJJHGFEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012'\n\u0005value\u0018\u0002 \u0001(\u000b2\u0018.VintagePresentStageData:\u00028\u0001\u001aS\n\u0017Unk3300EHHPFKIOKOOEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012'\n\u0005value\u0018\u0002 \u0001(\u000b2\u0018.VintageHuntingStageData:\u00028\u0001\u001aY\n\u0017Unk3300NPKMDFCLGBJEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012-\n\u0005value\u0018\u0002 \u0001(\u000b2\u001e.VintageCampChallengeStageData:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VintageBoothUsedItemDataOuterClass.getDescriptor(), VintageCampChallengeStageDataOuterClass.getDescriptor(), VintageHuntingStageDataOuterClass.getDescriptor(), VintageMarketInfoOuterClass.getDescriptor(), VintagePresentStageDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_VintageActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VintageActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VintageActivityDetailInfo_descriptor, new String[]{"Unk3300PCIIGPJJHGF", "IsContentClosed", "Unk3300EHHPFKIOKOO", "BoothData", "Unk3300NPKMDFCLGBJ", "MarketInfo"});

    /* renamed from: internal_static_VintageActivityDetailInfo_Unk3300PCIIGPJJHGFEntry_descriptor */
    private static final Descriptors.Descriptor f923xc495a28f = internal_static_VintageActivityDetailInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_VintageActivityDetailInfo_Unk3300PCIIGPJJHGFEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f924xa37cca0d = new GeneratedMessageV3.FieldAccessorTable(f923xc495a28f, new String[]{"Key", "Value"});

    /* renamed from: internal_static_VintageActivityDetailInfo_Unk3300EHHPFKIOKOOEntry_descriptor */
    private static final Descriptors.Descriptor f925xa97c2539 = internal_static_VintageActivityDetailInfo_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_VintageActivityDetailInfo_Unk3300EHHPFKIOKOOEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f926x783302b7 = new GeneratedMessageV3.FieldAccessorTable(f925xa97c2539, new String[]{"Key", "Value"});

    /* renamed from: internal_static_VintageActivityDetailInfo_Unk3300NPKMDFCLGBJEntry_descriptor */
    private static final Descriptors.Descriptor f927x57ce1b04 = internal_static_VintageActivityDetailInfo_descriptor.getNestedTypes().get(2);

    /* renamed from: internal_static_VintageActivityDetailInfo_Unk3300NPKMDFCLGBJEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f928x5603fd82 = new GeneratedMessageV3.FieldAccessorTable(f927x57ce1b04, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageActivityDetailInfoOuterClass$VintageActivityDetailInfoOrBuilder.class */
    public interface VintageActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300PCIIGPJJHGFCount();

        boolean containsUnk3300PCIIGPJJHGF(int i);

        @Deprecated
        Map<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> getUnk3300PCIIGPJJHGF();

        Map<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> getUnk3300PCIIGPJJHGFMap();

        VintagePresentStageDataOuterClass.VintagePresentStageData getUnk3300PCIIGPJJHGFOrDefault(int i, VintagePresentStageDataOuterClass.VintagePresentStageData vintagePresentStageData);

        VintagePresentStageDataOuterClass.VintagePresentStageData getUnk3300PCIIGPJJHGFOrThrow(int i);

        boolean getIsContentClosed();

        int getUnk3300EHHPFKIOKOOCount();

        boolean containsUnk3300EHHPFKIOKOO(int i);

        @Deprecated
        Map<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> getUnk3300EHHPFKIOKOO();

        Map<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> getUnk3300EHHPFKIOKOOMap();

        VintageHuntingStageDataOuterClass.VintageHuntingStageData getUnk3300EHHPFKIOKOOOrDefault(int i, VintageHuntingStageDataOuterClass.VintageHuntingStageData vintageHuntingStageData);

        VintageHuntingStageDataOuterClass.VintageHuntingStageData getUnk3300EHHPFKIOKOOOrThrow(int i);

        boolean hasBoothData();

        VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData getBoothData();

        VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemDataOrBuilder getBoothDataOrBuilder();

        int getUnk3300NPKMDFCLGBJCount();

        boolean containsUnk3300NPKMDFCLGBJ(int i);

        @Deprecated
        Map<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> getUnk3300NPKMDFCLGBJ();

        Map<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> getUnk3300NPKMDFCLGBJMap();

        VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData getUnk3300NPKMDFCLGBJOrDefault(int i, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData vintageCampChallengeStageData);

        VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData getUnk3300NPKMDFCLGBJOrThrow(int i);

        boolean hasMarketInfo();

        VintageMarketInfoOuterClass.VintageMarketInfo getMarketInfo();

        VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder getMarketInfoOrBuilder();
    }

    private VintageActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageActivityDetailInfoOuterClass$VintageActivityDetailInfo.class */
    public static final class VintageActivityDetailInfo extends GeneratedMessageV3 implements VintageActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_PCIIGPJJHGF_FIELD_NUMBER = 11;
        private MapField<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> unk3300PCIIGPJJHGF_;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 13;
        private boolean isContentClosed_;
        public static final int UNK3300_EHHPFKIOKOO_FIELD_NUMBER = 10;
        private MapField<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> unk3300EHHPFKIOKOO_;
        public static final int BOOTH_DATA_FIELD_NUMBER = 9;
        private VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData boothData_;
        public static final int UNK3300_NPKMDFCLGBJ_FIELD_NUMBER = 2;
        private MapField<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> unk3300NPKMDFCLGBJ_;
        public static final int MARKET_INFO_FIELD_NUMBER = 14;
        private VintageMarketInfoOuterClass.VintageMarketInfo marketInfo_;
        private byte memoizedIsInitialized;
        private static final VintageActivityDetailInfo DEFAULT_INSTANCE = new VintageActivityDetailInfo();
        private static final Parser<VintageActivityDetailInfo> PARSER = new AbstractParser<VintageActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public VintageActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VintageActivityDetailInfo(input, extensionRegistry);
            }
        };

        /*  JADX ERROR: Dependency scan failed at insn: 0x0038: INVOKE_CUSTOM r0
            java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
            	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
            */
        /*  JADX ERROR: Failed to decode insn: 0x0038: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.MapField internalGetMapField(int r5) {
            /*
                r4 = this;
                r0 = r5
                switch(r0) {
                    case 2: goto L_0x002e;
                    case 10: goto L_0x0029;
                    case 11: goto L_0x0024;
                    default: goto L_0x0033;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetUnk3300PCIIGPJJHGF()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetUnk3300EHHPFKIOKOO()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetUnk3300NPKMDFCLGBJ()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private VintageActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private VintageActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VintageActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VintageActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                int mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 18:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.unk3300NPKMDFCLGBJ_ = MapField.newMapField(Unk3300NPKMDFCLGBJDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 4;
                                }
                                MapEntry<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> unk3300NPKMDFCLGBJ__ = (MapEntry) input.readMessage(Unk3300NPKMDFCLGBJDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.unk3300NPKMDFCLGBJ_.getMutableMap().put(unk3300NPKMDFCLGBJ__.getKey(), unk3300NPKMDFCLGBJ__.getValue());
                                break;
                            case 74:
                                VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData.Builder subBuilder = this.boothData_ != null ? this.boothData_.toBuilder() : null;
                                this.boothData_ = (VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData) input.readMessage(VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.boothData_);
                                    this.boothData_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 82:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300EHHPFKIOKOO_ = MapField.newMapField(Unk3300EHHPFKIOKOODefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 2;
                                }
                                MapEntry<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> unk3300EHHPFKIOKOO__ = (MapEntry) input.readMessage(Unk3300EHHPFKIOKOODefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.unk3300EHHPFKIOKOO_.getMutableMap().put(unk3300EHHPFKIOKOO__.getKey(), unk3300EHHPFKIOKOO__.getValue());
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300PCIIGPJJHGF_ = MapField.newMapField(Unk3300PCIIGPJJHGFDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> unk3300PCIIGPJJHGF__ = (MapEntry) input.readMessage(Unk3300PCIIGPJJHGFDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.unk3300PCIIGPJJHGF_.getMutableMap().put(unk3300PCIIGPJJHGF__.getKey(), unk3300PCIIGPJJHGF__.getValue());
                                break;
                            case 104:
                                this.isContentClosed_ = input.readBool();
                                break;
                            case 114:
                                VintageMarketInfoOuterClass.VintageMarketInfo.Builder subBuilder2 = this.marketInfo_ != null ? this.marketInfo_.toBuilder() : null;
                                this.marketInfo_ = (VintageMarketInfoOuterClass.VintageMarketInfo) input.readMessage(VintageMarketInfoOuterClass.VintageMarketInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.marketInfo_);
                                    this.marketInfo_ = subBuilder2.buildPartial();
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
            return VintageActivityDetailInfoOuterClass.internal_static_VintageActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VintageActivityDetailInfoOuterClass.internal_static_VintageActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageActivityDetailInfo.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageActivityDetailInfoOuterClass$VintageActivityDetailInfo$Unk3300PCIIGPJJHGFDefaultEntryHolder.class */
        public static final class Unk3300PCIIGPJJHGFDefaultEntryHolder {
            static final MapEntry<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> defaultEntry = MapEntry.newDefaultInstance(VintageActivityDetailInfoOuterClass.f923xc495a28f, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, VintagePresentStageDataOuterClass.VintagePresentStageData.getDefaultInstance());

            private Unk3300PCIIGPJJHGFDefaultEntryHolder() {
            }
        }

        private MapField<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> internalGetUnk3300PCIIGPJJHGF() {
            if (this.unk3300PCIIGPJJHGF_ == null) {
                return MapField.emptyMapField(Unk3300PCIIGPJJHGFDefaultEntryHolder.defaultEntry);
            }
            return this.unk3300PCIIGPJJHGF_;
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public int getUnk3300PCIIGPJJHGFCount() {
            return internalGetUnk3300PCIIGPJJHGF().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public boolean containsUnk3300PCIIGPJJHGF(int key) {
            return internalGetUnk3300PCIIGPJJHGF().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> getUnk3300PCIIGPJJHGF() {
            return getUnk3300PCIIGPJJHGFMap();
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public Map<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> getUnk3300PCIIGPJJHGFMap() {
            return internalGetUnk3300PCIIGPJJHGF().getMap();
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public VintagePresentStageDataOuterClass.VintagePresentStageData getUnk3300PCIIGPJJHGFOrDefault(int key, VintagePresentStageDataOuterClass.VintagePresentStageData defaultValue) {
            Map<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> map = internalGetUnk3300PCIIGPJJHGF().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public VintagePresentStageDataOuterClass.VintagePresentStageData getUnk3300PCIIGPJJHGFOrThrow(int key) {
            Map<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> map = internalGetUnk3300PCIIGPJJHGF().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageActivityDetailInfoOuterClass$VintageActivityDetailInfo$Unk3300EHHPFKIOKOODefaultEntryHolder.class */
        public static final class Unk3300EHHPFKIOKOODefaultEntryHolder {
            static final MapEntry<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> defaultEntry = MapEntry.newDefaultInstance(VintageActivityDetailInfoOuterClass.f925xa97c2539, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, VintageHuntingStageDataOuterClass.VintageHuntingStageData.getDefaultInstance());

            private Unk3300EHHPFKIOKOODefaultEntryHolder() {
            }
        }

        private MapField<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> internalGetUnk3300EHHPFKIOKOO() {
            if (this.unk3300EHHPFKIOKOO_ == null) {
                return MapField.emptyMapField(Unk3300EHHPFKIOKOODefaultEntryHolder.defaultEntry);
            }
            return this.unk3300EHHPFKIOKOO_;
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public int getUnk3300EHHPFKIOKOOCount() {
            return internalGetUnk3300EHHPFKIOKOO().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public boolean containsUnk3300EHHPFKIOKOO(int key) {
            return internalGetUnk3300EHHPFKIOKOO().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> getUnk3300EHHPFKIOKOO() {
            return getUnk3300EHHPFKIOKOOMap();
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public Map<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> getUnk3300EHHPFKIOKOOMap() {
            return internalGetUnk3300EHHPFKIOKOO().getMap();
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public VintageHuntingStageDataOuterClass.VintageHuntingStageData getUnk3300EHHPFKIOKOOOrDefault(int key, VintageHuntingStageDataOuterClass.VintageHuntingStageData defaultValue) {
            Map<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> map = internalGetUnk3300EHHPFKIOKOO().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public VintageHuntingStageDataOuterClass.VintageHuntingStageData getUnk3300EHHPFKIOKOOOrThrow(int key) {
            Map<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> map = internalGetUnk3300EHHPFKIOKOO().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public boolean hasBoothData() {
            return this.boothData_ != null;
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData getBoothData() {
            return this.boothData_ == null ? VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData.getDefaultInstance() : this.boothData_;
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemDataOrBuilder getBoothDataOrBuilder() {
            return getBoothData();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageActivityDetailInfoOuterClass$VintageActivityDetailInfo$Unk3300NPKMDFCLGBJDefaultEntryHolder.class */
        public static final class Unk3300NPKMDFCLGBJDefaultEntryHolder {
            static final MapEntry<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> defaultEntry = MapEntry.newDefaultInstance(VintageActivityDetailInfoOuterClass.f927x57ce1b04, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData.getDefaultInstance());

            private Unk3300NPKMDFCLGBJDefaultEntryHolder() {
            }
        }

        private MapField<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> internalGetUnk3300NPKMDFCLGBJ() {
            if (this.unk3300NPKMDFCLGBJ_ == null) {
                return MapField.emptyMapField(Unk3300NPKMDFCLGBJDefaultEntryHolder.defaultEntry);
            }
            return this.unk3300NPKMDFCLGBJ_;
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public int getUnk3300NPKMDFCLGBJCount() {
            return internalGetUnk3300NPKMDFCLGBJ().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public boolean containsUnk3300NPKMDFCLGBJ(int key) {
            return internalGetUnk3300NPKMDFCLGBJ().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> getUnk3300NPKMDFCLGBJ() {
            return getUnk3300NPKMDFCLGBJMap();
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public Map<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> getUnk3300NPKMDFCLGBJMap() {
            return internalGetUnk3300NPKMDFCLGBJ().getMap();
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData getUnk3300NPKMDFCLGBJOrDefault(int key, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData defaultValue) {
            Map<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> map = internalGetUnk3300NPKMDFCLGBJ().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData getUnk3300NPKMDFCLGBJOrThrow(int key) {
            Map<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> map = internalGetUnk3300NPKMDFCLGBJ().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public boolean hasMarketInfo() {
            return this.marketInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public VintageMarketInfoOuterClass.VintageMarketInfo getMarketInfo() {
            return this.marketInfo_ == null ? VintageMarketInfoOuterClass.VintageMarketInfo.getDefaultInstance() : this.marketInfo_;
        }

        @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
        public VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder getMarketInfoOrBuilder() {
            return getMarketInfo();
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetUnk3300NPKMDFCLGBJ(), Unk3300NPKMDFCLGBJDefaultEntryHolder.defaultEntry, 2);
            if (this.boothData_ != null) {
                output.writeMessage(9, getBoothData());
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetUnk3300EHHPFKIOKOO(), Unk3300EHHPFKIOKOODefaultEntryHolder.defaultEntry, 10);
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetUnk3300PCIIGPJJHGF(), Unk3300PCIIGPJJHGFDefaultEntryHolder.defaultEntry, 11);
            if (this.isContentClosed_) {
                output.writeBool(13, this.isContentClosed_);
            }
            if (this.marketInfo_ != null) {
                output.writeMessage(14, getMarketInfo());
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
            for (Map.Entry<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> entry : internalGetUnk3300NPKMDFCLGBJ().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(2, Unk3300NPKMDFCLGBJDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.boothData_ != null) {
                size2 += CodedOutputStream.computeMessageSize(9, getBoothData());
            }
            for (Map.Entry<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> entry2 : internalGetUnk3300EHHPFKIOKOO().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(10, Unk3300EHHPFKIOKOODefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            for (Map.Entry<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> entry3 : internalGetUnk3300PCIIGPJJHGF().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(11, Unk3300PCIIGPJJHGFDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry3.getKey()).setValue(entry3.getValue()).build());
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isContentClosed_);
            }
            if (this.marketInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(14, getMarketInfo());
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
            if (!(obj instanceof VintageActivityDetailInfo)) {
                return equals(obj);
            }
            VintageActivityDetailInfo other = (VintageActivityDetailInfo) obj;
            if (!internalGetUnk3300PCIIGPJJHGF().equals(other.internalGetUnk3300PCIIGPJJHGF()) || getIsContentClosed() != other.getIsContentClosed() || !internalGetUnk3300EHHPFKIOKOO().equals(other.internalGetUnk3300EHHPFKIOKOO()) || hasBoothData() != other.hasBoothData()) {
                return false;
            }
            if ((!hasBoothData() || getBoothData().equals(other.getBoothData())) && internalGetUnk3300NPKMDFCLGBJ().equals(other.internalGetUnk3300NPKMDFCLGBJ()) && hasMarketInfo() == other.hasMarketInfo()) {
                return (!hasMarketInfo() || getMarketInfo().equals(other.getMarketInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetUnk3300PCIIGPJJHGF().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 11)) + internalGetUnk3300PCIIGPJJHGF().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 13)) + Internal.hashBoolean(getIsContentClosed());
            if (!internalGetUnk3300EHHPFKIOKOO().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 10)) + internalGetUnk3300EHHPFKIOKOO().hashCode();
            }
            if (hasBoothData()) {
                hash2 = (53 * ((37 * hash2) + 9)) + getBoothData().hashCode();
            }
            if (!internalGetUnk3300NPKMDFCLGBJ().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 2)) + internalGetUnk3300NPKMDFCLGBJ().hashCode();
            }
            if (hasMarketInfo()) {
                hash2 = (53 * ((37 * hash2) + 14)) + getMarketInfo().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static VintageActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (VintageActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (VintageActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VintageActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (VintageActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VintageActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageActivityDetailInfoOuterClass$VintageActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VintageActivityDetailInfoOrBuilder {
            private int bitField0_;
            private MapField<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> unk3300PCIIGPJJHGF_;
            private boolean isContentClosed_;
            private MapField<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> unk3300EHHPFKIOKOO_;
            private VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData boothData_;
            private SingleFieldBuilderV3<VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData, VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData.Builder, VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemDataOrBuilder> boothDataBuilder_;
            private MapField<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> unk3300NPKMDFCLGBJ_;
            private VintageMarketInfoOuterClass.VintageMarketInfo marketInfo_;
            private SingleFieldBuilderV3<VintageMarketInfoOuterClass.VintageMarketInfo, VintageMarketInfoOuterClass.VintageMarketInfo.Builder, VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder> marketInfoBuilder_;

            /*  JADX ERROR: Dependency scan failed at insn: 0x0038: INVOKE_CUSTOM r0
                java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                */
            /*  JADX ERROR: Failed to decode insn: 0x0038: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.MapField internalGetMapField(int r5) {
                /*
                    r4 = this;
                    r0 = r5
                    switch(r0) {
                        case 2: goto L_0x002e;
                        case 10: goto L_0x0029;
                        case 11: goto L_0x0024;
                        default: goto L_0x0033;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetUnk3300PCIIGPJJHGF()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetUnk3300EHHPFKIOKOO()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetUnk3300NPKMDFCLGBJ()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
            }

            /*  JADX ERROR: Dependency scan failed at insn: 0x0038: INVOKE_CUSTOM r0
                java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                */
            /*  JADX ERROR: Failed to decode insn: 0x0038: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.MapField internalGetMutableMapField(int r5) {
                /*
                    r4 = this;
                    r0 = r5
                    switch(r0) {
                        case 2: goto L_0x002e;
                        case 10: goto L_0x0029;
                        case 11: goto L_0x0024;
                        default: goto L_0x0033;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableUnk3300PCIIGPJJHGF()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableUnk3300EHHPFKIOKOO()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableUnk3300NPKMDFCLGBJ()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return VintageActivityDetailInfoOuterClass.internal_static_VintageActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VintageActivityDetailInfoOuterClass.internal_static_VintageActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VintageActivityDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableUnk3300PCIIGPJJHGF().clear();
                this.isContentClosed_ = false;
                internalGetMutableUnk3300EHHPFKIOKOO().clear();
                if (this.boothDataBuilder_ == null) {
                    this.boothData_ = null;
                } else {
                    this.boothData_ = null;
                    this.boothDataBuilder_ = null;
                }
                internalGetMutableUnk3300NPKMDFCLGBJ().clear();
                if (this.marketInfoBuilder_ == null) {
                    this.marketInfo_ = null;
                } else {
                    this.marketInfo_ = null;
                    this.marketInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VintageActivityDetailInfoOuterClass.internal_static_VintageActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VintageActivityDetailInfo getDefaultInstanceForType() {
                return VintageActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageActivityDetailInfo build() {
                VintageActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageActivityDetailInfo buildPartial() {
                VintageActivityDetailInfo result = new VintageActivityDetailInfo(this);
                int i = this.bitField0_;
                result.unk3300PCIIGPJJHGF_ = internalGetUnk3300PCIIGPJJHGF();
                result.unk3300PCIIGPJJHGF_.makeImmutable();
                result.isContentClosed_ = this.isContentClosed_;
                result.unk3300EHHPFKIOKOO_ = internalGetUnk3300EHHPFKIOKOO();
                result.unk3300EHHPFKIOKOO_.makeImmutable();
                if (this.boothDataBuilder_ == null) {
                    result.boothData_ = this.boothData_;
                } else {
                    result.boothData_ = this.boothDataBuilder_.build();
                }
                result.unk3300NPKMDFCLGBJ_ = internalGetUnk3300NPKMDFCLGBJ();
                result.unk3300NPKMDFCLGBJ_.makeImmutable();
                if (this.marketInfoBuilder_ == null) {
                    result.marketInfo_ = this.marketInfo_;
                } else {
                    result.marketInfo_ = this.marketInfoBuilder_.build();
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
                if (other instanceof VintageActivityDetailInfo) {
                    return mergeFrom((VintageActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VintageActivityDetailInfo other) {
                if (other == VintageActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableUnk3300PCIIGPJJHGF().mergeFrom(other.internalGetUnk3300PCIIGPJJHGF());
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                internalGetMutableUnk3300EHHPFKIOKOO().mergeFrom(other.internalGetUnk3300EHHPFKIOKOO());
                if (other.hasBoothData()) {
                    mergeBoothData(other.getBoothData());
                }
                internalGetMutableUnk3300NPKMDFCLGBJ().mergeFrom(other.internalGetUnk3300NPKMDFCLGBJ());
                if (other.hasMarketInfo()) {
                    mergeMarketInfo(other.getMarketInfo());
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
                VintageActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = VintageActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VintageActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> internalGetUnk3300PCIIGPJJHGF() {
                if (this.unk3300PCIIGPJJHGF_ == null) {
                    return MapField.emptyMapField(Unk3300PCIIGPJJHGFDefaultEntryHolder.defaultEntry);
                }
                return this.unk3300PCIIGPJJHGF_;
            }

            private MapField<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> internalGetMutableUnk3300PCIIGPJJHGF() {
                onChanged();
                if (this.unk3300PCIIGPJJHGF_ == null) {
                    this.unk3300PCIIGPJJHGF_ = MapField.newMapField(Unk3300PCIIGPJJHGFDefaultEntryHolder.defaultEntry);
                }
                if (!this.unk3300PCIIGPJJHGF_.isMutable()) {
                    this.unk3300PCIIGPJJHGF_ = this.unk3300PCIIGPJJHGF_.copy();
                }
                return this.unk3300PCIIGPJJHGF_;
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public int getUnk3300PCIIGPJJHGFCount() {
                return internalGetUnk3300PCIIGPJJHGF().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public boolean containsUnk3300PCIIGPJJHGF(int key) {
                return internalGetUnk3300PCIIGPJJHGF().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> getUnk3300PCIIGPJJHGF() {
                return getUnk3300PCIIGPJJHGFMap();
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public Map<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> getUnk3300PCIIGPJJHGFMap() {
                return internalGetUnk3300PCIIGPJJHGF().getMap();
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public VintagePresentStageDataOuterClass.VintagePresentStageData getUnk3300PCIIGPJJHGFOrDefault(int key, VintagePresentStageDataOuterClass.VintagePresentStageData defaultValue) {
                Map<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> map = internalGetUnk3300PCIIGPJJHGF().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public VintagePresentStageDataOuterClass.VintagePresentStageData getUnk3300PCIIGPJJHGFOrThrow(int key) {
                Map<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> map = internalGetUnk3300PCIIGPJJHGF().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearUnk3300PCIIGPJJHGF() {
                internalGetMutableUnk3300PCIIGPJJHGF().getMutableMap().clear();
                return this;
            }

            public Builder removeUnk3300PCIIGPJJHGF(int key) {
                internalGetMutableUnk3300PCIIGPJJHGF().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> getMutableUnk3300PCIIGPJJHGF() {
                return internalGetMutableUnk3300PCIIGPJJHGF().getMutableMap();
            }

            public Builder putUnk3300PCIIGPJJHGF(int key, VintagePresentStageDataOuterClass.VintagePresentStageData value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableUnk3300PCIIGPJJHGF().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllUnk3300PCIIGPJJHGF(Map<Integer, VintagePresentStageDataOuterClass.VintagePresentStageData> values) {
                internalGetMutableUnk3300PCIIGPJJHGF().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public boolean getIsContentClosed() {
                return this.isContentClosed_;
            }

            public Builder setIsContentClosed(boolean value) {
                this.isContentClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsContentClosed() {
                this.isContentClosed_ = false;
                onChanged();
                return this;
            }

            private MapField<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> internalGetUnk3300EHHPFKIOKOO() {
                if (this.unk3300EHHPFKIOKOO_ == null) {
                    return MapField.emptyMapField(Unk3300EHHPFKIOKOODefaultEntryHolder.defaultEntry);
                }
                return this.unk3300EHHPFKIOKOO_;
            }

            private MapField<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> internalGetMutableUnk3300EHHPFKIOKOO() {
                onChanged();
                if (this.unk3300EHHPFKIOKOO_ == null) {
                    this.unk3300EHHPFKIOKOO_ = MapField.newMapField(Unk3300EHHPFKIOKOODefaultEntryHolder.defaultEntry);
                }
                if (!this.unk3300EHHPFKIOKOO_.isMutable()) {
                    this.unk3300EHHPFKIOKOO_ = this.unk3300EHHPFKIOKOO_.copy();
                }
                return this.unk3300EHHPFKIOKOO_;
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public int getUnk3300EHHPFKIOKOOCount() {
                return internalGetUnk3300EHHPFKIOKOO().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public boolean containsUnk3300EHHPFKIOKOO(int key) {
                return internalGetUnk3300EHHPFKIOKOO().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> getUnk3300EHHPFKIOKOO() {
                return getUnk3300EHHPFKIOKOOMap();
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public Map<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> getUnk3300EHHPFKIOKOOMap() {
                return internalGetUnk3300EHHPFKIOKOO().getMap();
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public VintageHuntingStageDataOuterClass.VintageHuntingStageData getUnk3300EHHPFKIOKOOOrDefault(int key, VintageHuntingStageDataOuterClass.VintageHuntingStageData defaultValue) {
                Map<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> map = internalGetUnk3300EHHPFKIOKOO().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public VintageHuntingStageDataOuterClass.VintageHuntingStageData getUnk3300EHHPFKIOKOOOrThrow(int key) {
                Map<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> map = internalGetUnk3300EHHPFKIOKOO().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearUnk3300EHHPFKIOKOO() {
                internalGetMutableUnk3300EHHPFKIOKOO().getMutableMap().clear();
                return this;
            }

            public Builder removeUnk3300EHHPFKIOKOO(int key) {
                internalGetMutableUnk3300EHHPFKIOKOO().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> getMutableUnk3300EHHPFKIOKOO() {
                return internalGetMutableUnk3300EHHPFKIOKOO().getMutableMap();
            }

            public Builder putUnk3300EHHPFKIOKOO(int key, VintageHuntingStageDataOuterClass.VintageHuntingStageData value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableUnk3300EHHPFKIOKOO().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllUnk3300EHHPFKIOKOO(Map<Integer, VintageHuntingStageDataOuterClass.VintageHuntingStageData> values) {
                internalGetMutableUnk3300EHHPFKIOKOO().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public boolean hasBoothData() {
                return (this.boothDataBuilder_ == null && this.boothData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData getBoothData() {
                if (this.boothDataBuilder_ == null) {
                    return this.boothData_ == null ? VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData.getDefaultInstance() : this.boothData_;
                }
                return this.boothDataBuilder_.getMessage();
            }

            public Builder setBoothData(VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData value) {
                if (this.boothDataBuilder_ != null) {
                    this.boothDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.boothData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setBoothData(VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData.Builder builderForValue) {
                if (this.boothDataBuilder_ == null) {
                    this.boothData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.boothDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeBoothData(VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData value) {
                if (this.boothDataBuilder_ == null) {
                    if (this.boothData_ != null) {
                        this.boothData_ = VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData.newBuilder(this.boothData_).mergeFrom(value).buildPartial();
                    } else {
                        this.boothData_ = value;
                    }
                    onChanged();
                } else {
                    this.boothDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearBoothData() {
                if (this.boothDataBuilder_ == null) {
                    this.boothData_ = null;
                    onChanged();
                } else {
                    this.boothData_ = null;
                    this.boothDataBuilder_ = null;
                }
                return this;
            }

            public VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData.Builder getBoothDataBuilder() {
                onChanged();
                return getBoothDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemDataOrBuilder getBoothDataOrBuilder() {
                if (this.boothDataBuilder_ != null) {
                    return this.boothDataBuilder_.getMessageOrBuilder();
                }
                return this.boothData_ == null ? VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData.getDefaultInstance() : this.boothData_;
            }

            private SingleFieldBuilderV3<VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData, VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemData.Builder, VintageBoothUsedItemDataOuterClass.VintageBoothUsedItemDataOrBuilder> getBoothDataFieldBuilder() {
                if (this.boothDataBuilder_ == null) {
                    this.boothDataBuilder_ = new SingleFieldBuilderV3<>(getBoothData(), getParentForChildren(), isClean());
                    this.boothData_ = null;
                }
                return this.boothDataBuilder_;
            }

            private MapField<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> internalGetUnk3300NPKMDFCLGBJ() {
                if (this.unk3300NPKMDFCLGBJ_ == null) {
                    return MapField.emptyMapField(Unk3300NPKMDFCLGBJDefaultEntryHolder.defaultEntry);
                }
                return this.unk3300NPKMDFCLGBJ_;
            }

            private MapField<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> internalGetMutableUnk3300NPKMDFCLGBJ() {
                onChanged();
                if (this.unk3300NPKMDFCLGBJ_ == null) {
                    this.unk3300NPKMDFCLGBJ_ = MapField.newMapField(Unk3300NPKMDFCLGBJDefaultEntryHolder.defaultEntry);
                }
                if (!this.unk3300NPKMDFCLGBJ_.isMutable()) {
                    this.unk3300NPKMDFCLGBJ_ = this.unk3300NPKMDFCLGBJ_.copy();
                }
                return this.unk3300NPKMDFCLGBJ_;
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public int getUnk3300NPKMDFCLGBJCount() {
                return internalGetUnk3300NPKMDFCLGBJ().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public boolean containsUnk3300NPKMDFCLGBJ(int key) {
                return internalGetUnk3300NPKMDFCLGBJ().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> getUnk3300NPKMDFCLGBJ() {
                return getUnk3300NPKMDFCLGBJMap();
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public Map<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> getUnk3300NPKMDFCLGBJMap() {
                return internalGetUnk3300NPKMDFCLGBJ().getMap();
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData getUnk3300NPKMDFCLGBJOrDefault(int key, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData defaultValue) {
                Map<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> map = internalGetUnk3300NPKMDFCLGBJ().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData getUnk3300NPKMDFCLGBJOrThrow(int key) {
                Map<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> map = internalGetUnk3300NPKMDFCLGBJ().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearUnk3300NPKMDFCLGBJ() {
                internalGetMutableUnk3300NPKMDFCLGBJ().getMutableMap().clear();
                return this;
            }

            public Builder removeUnk3300NPKMDFCLGBJ(int key) {
                internalGetMutableUnk3300NPKMDFCLGBJ().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> getMutableUnk3300NPKMDFCLGBJ() {
                return internalGetMutableUnk3300NPKMDFCLGBJ().getMutableMap();
            }

            public Builder putUnk3300NPKMDFCLGBJ(int key, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableUnk3300NPKMDFCLGBJ().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllUnk3300NPKMDFCLGBJ(Map<Integer, VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData> values) {
                internalGetMutableUnk3300NPKMDFCLGBJ().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public boolean hasMarketInfo() {
                return (this.marketInfoBuilder_ == null && this.marketInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public VintageMarketInfoOuterClass.VintageMarketInfo getMarketInfo() {
                if (this.marketInfoBuilder_ == null) {
                    return this.marketInfo_ == null ? VintageMarketInfoOuterClass.VintageMarketInfo.getDefaultInstance() : this.marketInfo_;
                }
                return this.marketInfoBuilder_.getMessage();
            }

            public Builder setMarketInfo(VintageMarketInfoOuterClass.VintageMarketInfo value) {
                if (this.marketInfoBuilder_ != null) {
                    this.marketInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.marketInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMarketInfo(VintageMarketInfoOuterClass.VintageMarketInfo.Builder builderForValue) {
                if (this.marketInfoBuilder_ == null) {
                    this.marketInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.marketInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMarketInfo(VintageMarketInfoOuterClass.VintageMarketInfo value) {
                if (this.marketInfoBuilder_ == null) {
                    if (this.marketInfo_ != null) {
                        this.marketInfo_ = VintageMarketInfoOuterClass.VintageMarketInfo.newBuilder(this.marketInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.marketInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.marketInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMarketInfo() {
                if (this.marketInfoBuilder_ == null) {
                    this.marketInfo_ = null;
                    onChanged();
                } else {
                    this.marketInfo_ = null;
                    this.marketInfoBuilder_ = null;
                }
                return this;
            }

            public VintageMarketInfoOuterClass.VintageMarketInfo.Builder getMarketInfoBuilder() {
                onChanged();
                return getMarketInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder
            public VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder getMarketInfoOrBuilder() {
                if (this.marketInfoBuilder_ != null) {
                    return this.marketInfoBuilder_.getMessageOrBuilder();
                }
                return this.marketInfo_ == null ? VintageMarketInfoOuterClass.VintageMarketInfo.getDefaultInstance() : this.marketInfo_;
            }

            private SingleFieldBuilderV3<VintageMarketInfoOuterClass.VintageMarketInfo, VintageMarketInfoOuterClass.VintageMarketInfo.Builder, VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder> getMarketInfoFieldBuilder() {
                if (this.marketInfoBuilder_ == null) {
                    this.marketInfoBuilder_ = new SingleFieldBuilderV3<>(getMarketInfo(), getParentForChildren(), isClean());
                    this.marketInfo_ = null;
                }
                return this.marketInfoBuilder_;
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

        public static VintageActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VintageActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VintageActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VintageActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VintageBoothUsedItemDataOuterClass.getDescriptor();
        VintageCampChallengeStageDataOuterClass.getDescriptor();
        VintageHuntingStageDataOuterClass.getDescriptor();
        VintageMarketInfoOuterClass.getDescriptor();
        VintagePresentStageDataOuterClass.getDescriptor();
    }
}
