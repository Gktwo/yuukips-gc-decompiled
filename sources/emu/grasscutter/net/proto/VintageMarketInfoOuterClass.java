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
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.VintageMarketDealInfoOuterClass;
import emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketInfoOuterClass.class */
public final class VintageMarketInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017VintageMarketInfo.proto\u001a\u001bVintageMarketDealInfo.proto\u001a\u001cVintageMarketStoreInfo.proto\"\u0006\n\u0011VintageMarketInfo\u0012@\n\u0010bargain_info_map\u0018\t \u0003(\u000b2&.VintageMarketInfo.BargainInfoMapEntry\u0012\u001b\n\u0013Unk3300_FJDIMCJEAOB\u0018\b \u0001(\b\u0012\u001c\n\u0013Unk3300_COKBOKAOCNJ\u0018ï\u0007 \u0003(\r\u0012\u0016\n\rhelp_skill_id\u0018ø\u0005 \u0001(\r\u0012\u001b\n\u0013Unk3300_ABHHACBDCFI\u0018\u0007 \u0003(\r\u00120\n\u000fopen_store_list\u0018\u0002 \u0003(\u000b2\u0017.VintageMarketStoreInfo\u0012\u001b\n\u0013Unk3300_EDBJLBICEJF\u0018\n \u0003(\r\u0012\u001b\n\u0013Unk3300_PAMKPAOCJJJ\u0018\u000b \u0001(\b\u0012\u001c\n\u0013Unk3300_FOPKAIIAMFM\u0018¢\u000e \u0001(\r\u0012\u001c\n\u0013Unk3300_NBNOJJBNJPB\u0018Ö\u0003 \u0001(\b\u0012)\n\tdeal_info\u0018\f \u0001(\u000b2\u0016.VintageMarketDealInfo\u0012\u0013\n\u000bstore_round\u0018\u0003 \u0001(\r\u0012\u001c\n\u0014unlock_strategy_list\u0018\r \u0003(\r\u0012\u001b\n\u0013Unk3300_AIAMBBODLBO\u0018\u000e \u0003(\r\u0012\u001b\n\u0013Unk3300_NDFHAGHBCFN\u0018\u0006 \u0001(\b\u0012\u001b\n\u0013Unk3300_LMNLHHPMAMN\u0018\u0001 \u0001(\r\u0012\u001c\n\u0013Unk3300_ALHLENELIEO\u0018º\f \u0001(\b\u0012\u001c\n\u0013Unk3300_ACJLANLBCGK\u0018ú\f \u0001(\r\u0012\u001b\n\u0013Unk3300_HHKKEDDIGLA\u0018\u0005 \u0001(\r\u0012\u001b\n\u0013Unk3300_KJDEFIBKBPE\u0018\u0004 \u0001(\b\u0012\u001b\n\u0013Unk3300_ICJOCDGLFFD\u0018\u000f \u0001(\b\u0012\u001c\n\u0013Unk3300_NMHHGNPKBEL\u0018¹\r \u0001(\b\u001a5\n\u0013BargainInfoMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\b:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VintageMarketDealInfoOuterClass.getDescriptor(), VintageMarketStoreInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_VintageMarketInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VintageMarketInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VintageMarketInfo_descriptor, new String[]{"BargainInfoMap", "Unk3300FJDIMCJEAOB", "Unk3300COKBOKAOCNJ", "HelpSkillId", "Unk3300ABHHACBDCFI", "OpenStoreList", "Unk3300EDBJLBICEJF", "Unk3300PAMKPAOCJJJ", "Unk3300FOPKAIIAMFM", "Unk3300NBNOJJBNJPB", "DealInfo", "StoreRound", "UnlockStrategyList", "Unk3300AIAMBBODLBO", "Unk3300NDFHAGHBCFN", "Unk3300LMNLHHPMAMN", "Unk3300ALHLENELIEO", "Unk3300ACJLANLBCGK", "Unk3300HHKKEDDIGLA", "Unk3300KJDEFIBKBPE", "Unk3300ICJOCDGLFFD", "Unk3300NMHHGNPKBEL"});
    private static final Descriptors.Descriptor internal_static_VintageMarketInfo_BargainInfoMapEntry_descriptor = internal_static_VintageMarketInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_VintageMarketInfo_BargainInfoMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f933xb592af94 = new GeneratedMessageV3.FieldAccessorTable(internal_static_VintageMarketInfo_BargainInfoMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketInfoOuterClass$VintageMarketInfoOrBuilder.class */
    public interface VintageMarketInfoOrBuilder extends MessageOrBuilder {
        int getBargainInfoMapCount();

        boolean containsBargainInfoMap(int i);

        @Deprecated
        Map<Integer, Boolean> getBargainInfoMap();

        Map<Integer, Boolean> getBargainInfoMapMap();

        boolean getBargainInfoMapOrDefault(int i, boolean z);

        boolean getBargainInfoMapOrThrow(int i);

        boolean getUnk3300FJDIMCJEAOB();

        List<Integer> getUnk3300COKBOKAOCNJList();

        int getUnk3300COKBOKAOCNJCount();

        int getUnk3300COKBOKAOCNJ(int i);

        int getHelpSkillId();

        List<Integer> getUnk3300ABHHACBDCFIList();

        int getUnk3300ABHHACBDCFICount();

        int getUnk3300ABHHACBDCFI(int i);

        List<VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo> getOpenStoreListList();

        VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo getOpenStoreList(int i);

        int getOpenStoreListCount();

        List<? extends VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder> getOpenStoreListOrBuilderList();

        VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder getOpenStoreListOrBuilder(int i);

        List<Integer> getUnk3300EDBJLBICEJFList();

        int getUnk3300EDBJLBICEJFCount();

        int getUnk3300EDBJLBICEJF(int i);

        boolean getUnk3300PAMKPAOCJJJ();

        int getUnk3300FOPKAIIAMFM();

        boolean getUnk3300NBNOJJBNJPB();

        boolean hasDealInfo();

        VintageMarketDealInfoOuterClass.VintageMarketDealInfo getDealInfo();

        VintageMarketDealInfoOuterClass.VintageMarketDealInfoOrBuilder getDealInfoOrBuilder();

        int getStoreRound();

        List<Integer> getUnlockStrategyListList();

        int getUnlockStrategyListCount();

        int getUnlockStrategyList(int i);

        List<Integer> getUnk3300AIAMBBODLBOList();

        int getUnk3300AIAMBBODLBOCount();

        int getUnk3300AIAMBBODLBO(int i);

        boolean getUnk3300NDFHAGHBCFN();

        int getUnk3300LMNLHHPMAMN();

        boolean getUnk3300ALHLENELIEO();

        int getUnk3300ACJLANLBCGK();

        int getUnk3300HHKKEDDIGLA();

        boolean getUnk3300KJDEFIBKBPE();

        boolean getUnk3300ICJOCDGLFFD();

        boolean getUnk3300NMHHGNPKBEL();
    }

    private VintageMarketInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketInfoOuterClass$VintageMarketInfo.class */
    public static final class VintageMarketInfo extends GeneratedMessageV3 implements VintageMarketInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BARGAIN_INFO_MAP_FIELD_NUMBER = 9;
        private MapField<Integer, Boolean> bargainInfoMap_;
        public static final int UNK3300_FJDIMCJEAOB_FIELD_NUMBER = 8;
        private boolean unk3300FJDIMCJEAOB_;
        public static final int UNK3300_COKBOKAOCNJ_FIELD_NUMBER = 1007;
        private Internal.IntList unk3300COKBOKAOCNJ_;
        private int unk3300COKBOKAOCNJMemoizedSerializedSize;
        public static final int HELP_SKILL_ID_FIELD_NUMBER = 760;
        private int helpSkillId_;
        public static final int UNK3300_ABHHACBDCFI_FIELD_NUMBER = 7;
        private Internal.IntList unk3300ABHHACBDCFI_;
        private int unk3300ABHHACBDCFIMemoizedSerializedSize;
        public static final int OPEN_STORE_LIST_FIELD_NUMBER = 2;
        private List<VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo> openStoreList_;
        public static final int UNK3300_EDBJLBICEJF_FIELD_NUMBER = 10;
        private Internal.IntList unk3300EDBJLBICEJF_;
        private int unk3300EDBJLBICEJFMemoizedSerializedSize;
        public static final int UNK3300_PAMKPAOCJJJ_FIELD_NUMBER = 11;
        private boolean unk3300PAMKPAOCJJJ_;
        public static final int UNK3300_FOPKAIIAMFM_FIELD_NUMBER = 1826;
        private int unk3300FOPKAIIAMFM_;
        public static final int UNK3300_NBNOJJBNJPB_FIELD_NUMBER = 470;
        private boolean unk3300NBNOJJBNJPB_;
        public static final int DEAL_INFO_FIELD_NUMBER = 12;
        private VintageMarketDealInfoOuterClass.VintageMarketDealInfo dealInfo_;
        public static final int STORE_ROUND_FIELD_NUMBER = 3;
        private int storeRound_;
        public static final int UNLOCK_STRATEGY_LIST_FIELD_NUMBER = 13;
        private Internal.IntList unlockStrategyList_;
        private int unlockStrategyListMemoizedSerializedSize;
        public static final int UNK3300_AIAMBBODLBO_FIELD_NUMBER = 14;
        private Internal.IntList unk3300AIAMBBODLBO_;
        private int unk3300AIAMBBODLBOMemoizedSerializedSize;
        public static final int UNK3300_NDFHAGHBCFN_FIELD_NUMBER = 6;
        private boolean unk3300NDFHAGHBCFN_;
        public static final int UNK3300_LMNLHHPMAMN_FIELD_NUMBER = 1;
        private int unk3300LMNLHHPMAMN_;
        public static final int UNK3300_ALHLENELIEO_FIELD_NUMBER = 1594;
        private boolean unk3300ALHLENELIEO_;
        public static final int UNK3300_ACJLANLBCGK_FIELD_NUMBER = 1658;
        private int unk3300ACJLANLBCGK_;
        public static final int UNK3300_HHKKEDDIGLA_FIELD_NUMBER = 5;
        private int unk3300HHKKEDDIGLA_;
        public static final int UNK3300_KJDEFIBKBPE_FIELD_NUMBER = 4;
        private boolean unk3300KJDEFIBKBPE_;
        public static final int UNK3300_ICJOCDGLFFD_FIELD_NUMBER = 15;
        private boolean unk3300ICJOCDGLFFD_;
        public static final int UNK3300_NMHHGNPKBEL_FIELD_NUMBER = 1721;
        private boolean unk3300NMHHGNPKBEL_;
        private byte memoizedIsInitialized;
        private static final VintageMarketInfo DEFAULT_INSTANCE = new VintageMarketInfo();
        private static final Parser<VintageMarketInfo> PARSER = new AbstractParser<VintageMarketInfo>() { // from class: emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfo.1
            @Override // com.google.protobuf.Parser
            public VintageMarketInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VintageMarketInfo(input, extensionRegistry);
            }
        };

        /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 9: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetBargainInfoMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private VintageMarketInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300COKBOKAOCNJMemoizedSerializedSize = -1;
            this.unk3300ABHHACBDCFIMemoizedSerializedSize = -1;
            this.unk3300EDBJLBICEJFMemoizedSerializedSize = -1;
            this.unlockStrategyListMemoizedSerializedSize = -1;
            this.unk3300AIAMBBODLBOMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private VintageMarketInfo() {
            this.unk3300COKBOKAOCNJMemoizedSerializedSize = -1;
            this.unk3300ABHHACBDCFIMemoizedSerializedSize = -1;
            this.unk3300EDBJLBICEJFMemoizedSerializedSize = -1;
            this.unlockStrategyListMemoizedSerializedSize = -1;
            this.unk3300AIAMBBODLBOMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk3300COKBOKAOCNJ_ = emptyIntList();
            this.unk3300ABHHACBDCFI_ = emptyIntList();
            this.openStoreList_ = Collections.emptyList();
            this.unk3300EDBJLBICEJF_ = emptyIntList();
            this.unlockStrategyList_ = emptyIntList();
            this.unk3300AIAMBBODLBO_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VintageMarketInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:193:0x047f */
        private VintageMarketInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8:
                                this.unk3300LMNLHHPMAMN_ = input.readUInt32();
                                break;
                            case 18:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.openStoreList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.openStoreList_.add((VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo) input.readMessage(VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.parser(), extensionRegistry));
                                break;
                            case 24:
                                this.storeRound_ = input.readUInt32();
                                break;
                            case 32:
                                this.unk3300KJDEFIBKBPE_ = input.readBool();
                                break;
                            case 40:
                                this.unk3300HHKKEDDIGLA_ = input.readUInt32();
                                break;
                            case 48:
                                this.unk3300NDFHAGHBCFN_ = input.readBool();
                                break;
                            case 56:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.unk3300ABHHACBDCFI_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.unk3300ABHHACBDCFI_.addInt(input.readUInt32());
                                break;
                            case 58:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300ABHHACBDCFI_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300ABHHACBDCFI_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 64:
                                this.unk3300FJDIMCJEAOB_ = input.readBool();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.bargainInfoMap_ = MapField.newMapField(BargainInfoMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Boolean> bargainInfoMap__ = (MapEntry) input.readMessage(BargainInfoMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.bargainInfoMap_.getMutableMap().put(bargainInfoMap__.getKey(), bargainInfoMap__.getValue());
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 16) == 0) {
                                    this.unk3300EDBJLBICEJF_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                this.unk3300EDBJLBICEJF_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 16) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300EDBJLBICEJF_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300EDBJLBICEJF_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 88:
                                this.unk3300PAMKPAOCJJJ_ = input.readBool();
                                break;
                            case 98:
                                VintageMarketDealInfoOuterClass.VintageMarketDealInfo.Builder subBuilder = this.dealInfo_ != null ? this.dealInfo_.toBuilder() : null;
                                this.dealInfo_ = (VintageMarketDealInfoOuterClass.VintageMarketDealInfo) input.readMessage(VintageMarketDealInfoOuterClass.VintageMarketDealInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.dealInfo_);
                                    this.dealInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 104:
                                if ((mutable_bitField0_ & 32) == 0) {
                                    this.unlockStrategyList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                }
                                this.unlockStrategyList_.addInt(input.readUInt32());
                                break;
                            case 106:
                                int limit3 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 32) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unlockStrategyList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unlockStrategyList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit3);
                                break;
                            case 112:
                                if ((mutable_bitField0_ & 64) == 0) {
                                    this.unk3300AIAMBBODLBO_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                }
                                this.unk3300AIAMBBODLBO_.addInt(input.readUInt32());
                                break;
                            case 114:
                                int limit4 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 64) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300AIAMBBODLBO_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300AIAMBBODLBO_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit4);
                                break;
                            case 120:
                                this.unk3300ICJOCDGLFFD_ = input.readBool();
                                break;
                            case 3760:
                                this.unk3300NBNOJJBNJPB_ = input.readBool();
                                break;
                            case 6080:
                                this.helpSkillId_ = input.readUInt32();
                                break;
                            case 8056:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300COKBOKAOCNJ_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unk3300COKBOKAOCNJ_.addInt(input.readUInt32());
                                break;
                            case 8058:
                                int limit5 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300COKBOKAOCNJ_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300COKBOKAOCNJ_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit5);
                                break;
                            case 12752:
                                this.unk3300ALHLENELIEO_ = input.readBool();
                                break;
                            case 13264:
                                this.unk3300ACJLANLBCGK_ = input.readUInt32();
                                break;
                            case 13768:
                                this.unk3300NMHHGNPKBEL_ = input.readBool();
                                break;
                            case 14608:
                                this.unk3300FOPKAIIAMFM_ = input.readUInt32();
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 8) != 0) {
                    this.openStoreList_ = Collections.unmodifiableList(this.openStoreList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.unk3300ABHHACBDCFI_.makeImmutable();
                }
                if ((mutable_bitField0_ & 16) != 0) {
                    this.unk3300EDBJLBICEJF_.makeImmutable();
                }
                if ((mutable_bitField0_ & 32) != 0) {
                    this.unlockStrategyList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 64) != 0) {
                    this.unk3300AIAMBBODLBO_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk3300COKBOKAOCNJ_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return VintageMarketInfoOuterClass.internal_static_VintageMarketInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VintageMarketInfoOuterClass.internal_static_VintageMarketInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageMarketInfo.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketInfoOuterClass$VintageMarketInfo$BargainInfoMapDefaultEntryHolder.class */
        public static final class BargainInfoMapDefaultEntryHolder {
            static final MapEntry<Integer, Boolean> defaultEntry = MapEntry.newDefaultInstance(VintageMarketInfoOuterClass.internal_static_VintageMarketInfo_BargainInfoMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.BOOL, false);

            private BargainInfoMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Boolean> internalGetBargainInfoMap() {
            if (this.bargainInfoMap_ == null) {
                return MapField.emptyMapField(BargainInfoMapDefaultEntryHolder.defaultEntry);
            }
            return this.bargainInfoMap_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getBargainInfoMapCount() {
            return internalGetBargainInfoMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean containsBargainInfoMap(int key) {
            return internalGetBargainInfoMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        @Deprecated
        public Map<Integer, Boolean> getBargainInfoMap() {
            return getBargainInfoMapMap();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public Map<Integer, Boolean> getBargainInfoMapMap() {
            return internalGetBargainInfoMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean getBargainInfoMapOrDefault(int key, boolean defaultValue) {
            Map<Integer, Boolean> map = internalGetBargainInfoMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).booleanValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean getBargainInfoMapOrThrow(int key) {
            Map<Integer, Boolean> map = internalGetBargainInfoMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).booleanValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean getUnk3300FJDIMCJEAOB() {
            return this.unk3300FJDIMCJEAOB_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public List<Integer> getUnk3300COKBOKAOCNJList() {
            return this.unk3300COKBOKAOCNJ_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300COKBOKAOCNJCount() {
            return this.unk3300COKBOKAOCNJ_.size();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300COKBOKAOCNJ(int index) {
            return this.unk3300COKBOKAOCNJ_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getHelpSkillId() {
            return this.helpSkillId_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public List<Integer> getUnk3300ABHHACBDCFIList() {
            return this.unk3300ABHHACBDCFI_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300ABHHACBDCFICount() {
            return this.unk3300ABHHACBDCFI_.size();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300ABHHACBDCFI(int index) {
            return this.unk3300ABHHACBDCFI_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public List<VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo> getOpenStoreListList() {
            return this.openStoreList_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public List<? extends VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder> getOpenStoreListOrBuilderList() {
            return this.openStoreList_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getOpenStoreListCount() {
            return this.openStoreList_.size();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo getOpenStoreList(int index) {
            return this.openStoreList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder getOpenStoreListOrBuilder(int index) {
            return this.openStoreList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public List<Integer> getUnk3300EDBJLBICEJFList() {
            return this.unk3300EDBJLBICEJF_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300EDBJLBICEJFCount() {
            return this.unk3300EDBJLBICEJF_.size();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300EDBJLBICEJF(int index) {
            return this.unk3300EDBJLBICEJF_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean getUnk3300PAMKPAOCJJJ() {
            return this.unk3300PAMKPAOCJJJ_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300FOPKAIIAMFM() {
            return this.unk3300FOPKAIIAMFM_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean getUnk3300NBNOJJBNJPB() {
            return this.unk3300NBNOJJBNJPB_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean hasDealInfo() {
            return this.dealInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public VintageMarketDealInfoOuterClass.VintageMarketDealInfo getDealInfo() {
            return this.dealInfo_ == null ? VintageMarketDealInfoOuterClass.VintageMarketDealInfo.getDefaultInstance() : this.dealInfo_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public VintageMarketDealInfoOuterClass.VintageMarketDealInfoOrBuilder getDealInfoOrBuilder() {
            return getDealInfo();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getStoreRound() {
            return this.storeRound_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public List<Integer> getUnlockStrategyListList() {
            return this.unlockStrategyList_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnlockStrategyListCount() {
            return this.unlockStrategyList_.size();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnlockStrategyList(int index) {
            return this.unlockStrategyList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public List<Integer> getUnk3300AIAMBBODLBOList() {
            return this.unk3300AIAMBBODLBO_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300AIAMBBODLBOCount() {
            return this.unk3300AIAMBBODLBO_.size();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300AIAMBBODLBO(int index) {
            return this.unk3300AIAMBBODLBO_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean getUnk3300NDFHAGHBCFN() {
            return this.unk3300NDFHAGHBCFN_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300LMNLHHPMAMN() {
            return this.unk3300LMNLHHPMAMN_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean getUnk3300ALHLENELIEO() {
            return this.unk3300ALHLENELIEO_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300ACJLANLBCGK() {
            return this.unk3300ACJLANLBCGK_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300HHKKEDDIGLA() {
            return this.unk3300HHKKEDDIGLA_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean getUnk3300KJDEFIBKBPE() {
            return this.unk3300KJDEFIBKBPE_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean getUnk3300ICJOCDGLFFD() {
            return this.unk3300ICJOCDGLFFD_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean getUnk3300NMHHGNPKBEL() {
            return this.unk3300NMHHGNPKBEL_;
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
            getSerializedSize();
            if (this.unk3300LMNLHHPMAMN_ != 0) {
                output.writeUInt32(1, this.unk3300LMNLHHPMAMN_);
            }
            for (int i = 0; i < this.openStoreList_.size(); i++) {
                output.writeMessage(2, this.openStoreList_.get(i));
            }
            if (this.storeRound_ != 0) {
                output.writeUInt32(3, this.storeRound_);
            }
            if (this.unk3300KJDEFIBKBPE_) {
                output.writeBool(4, this.unk3300KJDEFIBKBPE_);
            }
            if (this.unk3300HHKKEDDIGLA_ != 0) {
                output.writeUInt32(5, this.unk3300HHKKEDDIGLA_);
            }
            if (this.unk3300NDFHAGHBCFN_) {
                output.writeBool(6, this.unk3300NDFHAGHBCFN_);
            }
            if (getUnk3300ABHHACBDCFIList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.unk3300ABHHACBDCFIMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk3300ABHHACBDCFI_.size(); i2++) {
                output.writeUInt32NoTag(this.unk3300ABHHACBDCFI_.getInt(i2));
            }
            if (this.unk3300FJDIMCJEAOB_) {
                output.writeBool(8, this.unk3300FJDIMCJEAOB_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetBargainInfoMap(), BargainInfoMapDefaultEntryHolder.defaultEntry, 9);
            if (getUnk3300EDBJLBICEJFList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.unk3300EDBJLBICEJFMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.unk3300EDBJLBICEJF_.size(); i3++) {
                output.writeUInt32NoTag(this.unk3300EDBJLBICEJF_.getInt(i3));
            }
            if (this.unk3300PAMKPAOCJJJ_) {
                output.writeBool(11, this.unk3300PAMKPAOCJJJ_);
            }
            if (this.dealInfo_ != null) {
                output.writeMessage(12, getDealInfo());
            }
            if (getUnlockStrategyListList().size() > 0) {
                output.writeUInt32NoTag(106);
                output.writeUInt32NoTag(this.unlockStrategyListMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.unlockStrategyList_.size(); i4++) {
                output.writeUInt32NoTag(this.unlockStrategyList_.getInt(i4));
            }
            if (getUnk3300AIAMBBODLBOList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.unk3300AIAMBBODLBOMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.unk3300AIAMBBODLBO_.size(); i5++) {
                output.writeUInt32NoTag(this.unk3300AIAMBBODLBO_.getInt(i5));
            }
            if (this.unk3300ICJOCDGLFFD_) {
                output.writeBool(15, this.unk3300ICJOCDGLFFD_);
            }
            if (this.unk3300NBNOJJBNJPB_) {
                output.writeBool(UNK3300_NBNOJJBNJPB_FIELD_NUMBER, this.unk3300NBNOJJBNJPB_);
            }
            if (this.helpSkillId_ != 0) {
                output.writeUInt32(HELP_SKILL_ID_FIELD_NUMBER, this.helpSkillId_);
            }
            if (getUnk3300COKBOKAOCNJList().size() > 0) {
                output.writeUInt32NoTag(8058);
                output.writeUInt32NoTag(this.unk3300COKBOKAOCNJMemoizedSerializedSize);
            }
            for (int i6 = 0; i6 < this.unk3300COKBOKAOCNJ_.size(); i6++) {
                output.writeUInt32NoTag(this.unk3300COKBOKAOCNJ_.getInt(i6));
            }
            if (this.unk3300ALHLENELIEO_) {
                output.writeBool(1594, this.unk3300ALHLENELIEO_);
            }
            if (this.unk3300ACJLANLBCGK_ != 0) {
                output.writeUInt32(1658, this.unk3300ACJLANLBCGK_);
            }
            if (this.unk3300NMHHGNPKBEL_) {
                output.writeBool(UNK3300_NMHHGNPKBEL_FIELD_NUMBER, this.unk3300NMHHGNPKBEL_);
            }
            if (this.unk3300FOPKAIIAMFM_ != 0) {
                output.writeUInt32(UNK3300_FOPKAIIAMFM_FIELD_NUMBER, this.unk3300FOPKAIIAMFM_);
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
            if (this.unk3300LMNLHHPMAMN_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300LMNLHHPMAMN_);
            }
            for (int i = 0; i < this.openStoreList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.openStoreList_.get(i));
            }
            if (this.storeRound_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.storeRound_);
            }
            if (this.unk3300KJDEFIBKBPE_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.unk3300KJDEFIBKBPE_);
            }
            if (this.unk3300HHKKEDDIGLA_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.unk3300HHKKEDDIGLA_);
            }
            if (this.unk3300NDFHAGHBCFN_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.unk3300NDFHAGHBCFN_);
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.unk3300ABHHACBDCFI_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300ABHHACBDCFI_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getUnk3300ABHHACBDCFIList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk3300ABHHACBDCFIMemoizedSerializedSize = dataSize;
            if (this.unk3300FJDIMCJEAOB_) {
                size3 += CodedOutputStream.computeBoolSize(8, this.unk3300FJDIMCJEAOB_);
            }
            for (Map.Entry<Integer, Boolean> entry : internalGetBargainInfoMap().getMap().entrySet()) {
                size3 += CodedOutputStream.computeMessageSize(9, BargainInfoMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            int dataSize2 = 0;
            for (int i3 = 0; i3 < this.unk3300EDBJLBICEJF_.size(); i3++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300EDBJLBICEJF_.getInt(i3));
            }
            int size4 = size3 + dataSize2;
            if (!getUnk3300EDBJLBICEJFList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300EDBJLBICEJFMemoizedSerializedSize = dataSize2;
            if (this.unk3300PAMKPAOCJJJ_) {
                size4 += CodedOutputStream.computeBoolSize(11, this.unk3300PAMKPAOCJJJ_);
            }
            if (this.dealInfo_ != null) {
                size4 += CodedOutputStream.computeMessageSize(12, getDealInfo());
            }
            int dataSize3 = 0;
            for (int i4 = 0; i4 < this.unlockStrategyList_.size(); i4++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.unlockStrategyList_.getInt(i4));
            }
            int size5 = size4 + dataSize3;
            if (!getUnlockStrategyListList().isEmpty()) {
                size5 = size5 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.unlockStrategyListMemoizedSerializedSize = dataSize3;
            int dataSize4 = 0;
            for (int i5 = 0; i5 < this.unk3300AIAMBBODLBO_.size(); i5++) {
                dataSize4 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300AIAMBBODLBO_.getInt(i5));
            }
            int size6 = size5 + dataSize4;
            if (!getUnk3300AIAMBBODLBOList().isEmpty()) {
                size6 = size6 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize4);
            }
            this.unk3300AIAMBBODLBOMemoizedSerializedSize = dataSize4;
            if (this.unk3300ICJOCDGLFFD_) {
                size6 += CodedOutputStream.computeBoolSize(15, this.unk3300ICJOCDGLFFD_);
            }
            if (this.unk3300NBNOJJBNJPB_) {
                size6 += CodedOutputStream.computeBoolSize(UNK3300_NBNOJJBNJPB_FIELD_NUMBER, this.unk3300NBNOJJBNJPB_);
            }
            if (this.helpSkillId_ != 0) {
                size6 += CodedOutputStream.computeUInt32Size(HELP_SKILL_ID_FIELD_NUMBER, this.helpSkillId_);
            }
            int dataSize5 = 0;
            for (int i6 = 0; i6 < this.unk3300COKBOKAOCNJ_.size(); i6++) {
                dataSize5 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300COKBOKAOCNJ_.getInt(i6));
            }
            int size7 = size6 + dataSize5;
            if (!getUnk3300COKBOKAOCNJList().isEmpty()) {
                size7 = size7 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize5);
            }
            this.unk3300COKBOKAOCNJMemoizedSerializedSize = dataSize5;
            if (this.unk3300ALHLENELIEO_) {
                size7 += CodedOutputStream.computeBoolSize(1594, this.unk3300ALHLENELIEO_);
            }
            if (this.unk3300ACJLANLBCGK_ != 0) {
                size7 += CodedOutputStream.computeUInt32Size(1658, this.unk3300ACJLANLBCGK_);
            }
            if (this.unk3300NMHHGNPKBEL_) {
                size7 += CodedOutputStream.computeBoolSize(UNK3300_NMHHGNPKBEL_FIELD_NUMBER, this.unk3300NMHHGNPKBEL_);
            }
            if (this.unk3300FOPKAIIAMFM_ != 0) {
                size7 += CodedOutputStream.computeUInt32Size(UNK3300_FOPKAIIAMFM_FIELD_NUMBER, this.unk3300FOPKAIIAMFM_);
            }
            int size8 = size7 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size8;
            return size8;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof VintageMarketInfo)) {
                return equals(obj);
            }
            VintageMarketInfo other = (VintageMarketInfo) obj;
            if (internalGetBargainInfoMap().equals(other.internalGetBargainInfoMap()) && getUnk3300FJDIMCJEAOB() == other.getUnk3300FJDIMCJEAOB() && getUnk3300COKBOKAOCNJList().equals(other.getUnk3300COKBOKAOCNJList()) && getHelpSkillId() == other.getHelpSkillId() && getUnk3300ABHHACBDCFIList().equals(other.getUnk3300ABHHACBDCFIList()) && getOpenStoreListList().equals(other.getOpenStoreListList()) && getUnk3300EDBJLBICEJFList().equals(other.getUnk3300EDBJLBICEJFList()) && getUnk3300PAMKPAOCJJJ() == other.getUnk3300PAMKPAOCJJJ() && getUnk3300FOPKAIIAMFM() == other.getUnk3300FOPKAIIAMFM() && getUnk3300NBNOJJBNJPB() == other.getUnk3300NBNOJJBNJPB() && hasDealInfo() == other.hasDealInfo()) {
                return (!hasDealInfo() || getDealInfo().equals(other.getDealInfo())) && getStoreRound() == other.getStoreRound() && getUnlockStrategyListList().equals(other.getUnlockStrategyListList()) && getUnk3300AIAMBBODLBOList().equals(other.getUnk3300AIAMBBODLBOList()) && getUnk3300NDFHAGHBCFN() == other.getUnk3300NDFHAGHBCFN() && getUnk3300LMNLHHPMAMN() == other.getUnk3300LMNLHHPMAMN() && getUnk3300ALHLENELIEO() == other.getUnk3300ALHLENELIEO() && getUnk3300ACJLANLBCGK() == other.getUnk3300ACJLANLBCGK() && getUnk3300HHKKEDDIGLA() == other.getUnk3300HHKKEDDIGLA() && getUnk3300KJDEFIBKBPE() == other.getUnk3300KJDEFIBKBPE() && getUnk3300ICJOCDGLFFD() == other.getUnk3300ICJOCDGLFFD() && getUnk3300NMHHGNPKBEL() == other.getUnk3300NMHHGNPKBEL() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetBargainInfoMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 9)) + internalGetBargainInfoMap().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 8)) + Internal.hashBoolean(getUnk3300FJDIMCJEAOB());
            if (getUnk3300COKBOKAOCNJCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 1007)) + getUnk3300COKBOKAOCNJList().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + HELP_SKILL_ID_FIELD_NUMBER)) + getHelpSkillId();
            if (getUnk3300ABHHACBDCFICount() > 0) {
                hash3 = (53 * ((37 * hash3) + 7)) + getUnk3300ABHHACBDCFIList().hashCode();
            }
            if (getOpenStoreListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 2)) + getOpenStoreListList().hashCode();
            }
            if (getUnk3300EDBJLBICEJFCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 10)) + getUnk3300EDBJLBICEJFList().hashCode();
            }
            int hash4 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash3) + 11)) + Internal.hashBoolean(getUnk3300PAMKPAOCJJJ()))) + UNK3300_FOPKAIIAMFM_FIELD_NUMBER)) + getUnk3300FOPKAIIAMFM())) + UNK3300_NBNOJJBNJPB_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300NBNOJJBNJPB());
            if (hasDealInfo()) {
                hash4 = (53 * ((37 * hash4) + 12)) + getDealInfo().hashCode();
            }
            int hash5 = (53 * ((37 * hash4) + 3)) + getStoreRound();
            if (getUnlockStrategyListCount() > 0) {
                hash5 = (53 * ((37 * hash5) + 13)) + getUnlockStrategyListList().hashCode();
            }
            if (getUnk3300AIAMBBODLBOCount() > 0) {
                hash5 = (53 * ((37 * hash5) + 14)) + getUnk3300AIAMBBODLBOList().hashCode();
            }
            int hash6 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash5) + 6)) + Internal.hashBoolean(getUnk3300NDFHAGHBCFN()))) + 1)) + getUnk3300LMNLHHPMAMN())) + 1594)) + Internal.hashBoolean(getUnk3300ALHLENELIEO()))) + 1658)) + getUnk3300ACJLANLBCGK())) + 5)) + getUnk3300HHKKEDDIGLA())) + 4)) + Internal.hashBoolean(getUnk3300KJDEFIBKBPE()))) + 15)) + Internal.hashBoolean(getUnk3300ICJOCDGLFFD()))) + UNK3300_NMHHGNPKBEL_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300NMHHGNPKBEL()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash6;
            return hash6;
        }

        public static VintageMarketInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketInfo parseFrom(InputStream input) throws IOException {
            return (VintageMarketInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageMarketInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageMarketInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (VintageMarketInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VintageMarketInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageMarketInfo parseFrom(CodedInputStream input) throws IOException {
            return (VintageMarketInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageMarketInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VintageMarketInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketInfoOuterClass$VintageMarketInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VintageMarketInfoOrBuilder {
            private int bitField0_;
            private MapField<Integer, Boolean> bargainInfoMap_;
            private boolean unk3300FJDIMCJEAOB_;
            private int helpSkillId_;
            private RepeatedFieldBuilderV3<VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo, VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.Builder, VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder> openStoreListBuilder_;
            private boolean unk3300PAMKPAOCJJJ_;
            private int unk3300FOPKAIIAMFM_;
            private boolean unk3300NBNOJJBNJPB_;
            private VintageMarketDealInfoOuterClass.VintageMarketDealInfo dealInfo_;
            private SingleFieldBuilderV3<VintageMarketDealInfoOuterClass.VintageMarketDealInfo, VintageMarketDealInfoOuterClass.VintageMarketDealInfo.Builder, VintageMarketDealInfoOuterClass.VintageMarketDealInfoOrBuilder> dealInfoBuilder_;
            private int storeRound_;
            private boolean unk3300NDFHAGHBCFN_;
            private int unk3300LMNLHHPMAMN_;
            private boolean unk3300ALHLENELIEO_;
            private int unk3300ACJLANLBCGK_;
            private int unk3300HHKKEDDIGLA_;
            private boolean unk3300KJDEFIBKBPE_;
            private boolean unk3300ICJOCDGLFFD_;
            private boolean unk3300NMHHGNPKBEL_;
            private Internal.IntList unk3300COKBOKAOCNJ_ = VintageMarketInfo.emptyIntList();
            private Internal.IntList unk3300ABHHACBDCFI_ = VintageMarketInfo.emptyIntList();
            private List<VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo> openStoreList_ = Collections.emptyList();
            private Internal.IntList unk3300EDBJLBICEJF_ = VintageMarketInfo.emptyIntList();
            private Internal.IntList unlockStrategyList_ = VintageMarketInfo.emptyIntList();
            private Internal.IntList unk3300AIAMBBODLBO_ = VintageMarketInfo.emptyIntList();

            /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 9: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetBargainInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
            }

            /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 9: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableBargainInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return VintageMarketInfoOuterClass.internal_static_VintageMarketInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VintageMarketInfoOuterClass.internal_static_VintageMarketInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageMarketInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VintageMarketInfo.alwaysUseFieldBuilders) {
                    getOpenStoreListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableBargainInfoMap().clear();
                this.unk3300FJDIMCJEAOB_ = false;
                this.unk3300COKBOKAOCNJ_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.helpSkillId_ = 0;
                this.unk3300ABHHACBDCFI_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -5;
                if (this.openStoreListBuilder_ == null) {
                    this.openStoreList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.openStoreListBuilder_.clear();
                }
                this.unk3300EDBJLBICEJF_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -17;
                this.unk3300PAMKPAOCJJJ_ = false;
                this.unk3300FOPKAIIAMFM_ = 0;
                this.unk3300NBNOJJBNJPB_ = false;
                if (this.dealInfoBuilder_ == null) {
                    this.dealInfo_ = null;
                } else {
                    this.dealInfo_ = null;
                    this.dealInfoBuilder_ = null;
                }
                this.storeRound_ = 0;
                this.unlockStrategyList_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -33;
                this.unk3300AIAMBBODLBO_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -65;
                this.unk3300NDFHAGHBCFN_ = false;
                this.unk3300LMNLHHPMAMN_ = 0;
                this.unk3300ALHLENELIEO_ = false;
                this.unk3300ACJLANLBCGK_ = 0;
                this.unk3300HHKKEDDIGLA_ = 0;
                this.unk3300KJDEFIBKBPE_ = false;
                this.unk3300ICJOCDGLFFD_ = false;
                this.unk3300NMHHGNPKBEL_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VintageMarketInfoOuterClass.internal_static_VintageMarketInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VintageMarketInfo getDefaultInstanceForType() {
                return VintageMarketInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageMarketInfo build() {
                VintageMarketInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageMarketInfo buildPartial() {
                VintageMarketInfo result = new VintageMarketInfo(this);
                int i = this.bitField0_;
                result.bargainInfoMap_ = internalGetBargainInfoMap();
                result.bargainInfoMap_.makeImmutable();
                result.unk3300FJDIMCJEAOB_ = this.unk3300FJDIMCJEAOB_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unk3300COKBOKAOCNJ_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk3300COKBOKAOCNJ_ = this.unk3300COKBOKAOCNJ_;
                result.helpSkillId_ = this.helpSkillId_;
                if ((this.bitField0_ & 4) != 0) {
                    this.unk3300ABHHACBDCFI_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.unk3300ABHHACBDCFI_ = this.unk3300ABHHACBDCFI_;
                if (this.openStoreListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.openStoreList_ = Collections.unmodifiableList(this.openStoreList_);
                        this.bitField0_ &= -9;
                    }
                    result.openStoreList_ = this.openStoreList_;
                } else {
                    result.openStoreList_ = this.openStoreListBuilder_.build();
                }
                if ((this.bitField0_ & 16) != 0) {
                    this.unk3300EDBJLBICEJF_.makeImmutable();
                    this.bitField0_ &= -17;
                }
                result.unk3300EDBJLBICEJF_ = this.unk3300EDBJLBICEJF_;
                result.unk3300PAMKPAOCJJJ_ = this.unk3300PAMKPAOCJJJ_;
                result.unk3300FOPKAIIAMFM_ = this.unk3300FOPKAIIAMFM_;
                result.unk3300NBNOJJBNJPB_ = this.unk3300NBNOJJBNJPB_;
                if (this.dealInfoBuilder_ == null) {
                    result.dealInfo_ = this.dealInfo_;
                } else {
                    result.dealInfo_ = this.dealInfoBuilder_.build();
                }
                result.storeRound_ = this.storeRound_;
                if ((this.bitField0_ & 32) != 0) {
                    this.unlockStrategyList_.makeImmutable();
                    this.bitField0_ &= -33;
                }
                result.unlockStrategyList_ = this.unlockStrategyList_;
                if ((this.bitField0_ & 64) != 0) {
                    this.unk3300AIAMBBODLBO_.makeImmutable();
                    this.bitField0_ &= -65;
                }
                result.unk3300AIAMBBODLBO_ = this.unk3300AIAMBBODLBO_;
                result.unk3300NDFHAGHBCFN_ = this.unk3300NDFHAGHBCFN_;
                result.unk3300LMNLHHPMAMN_ = this.unk3300LMNLHHPMAMN_;
                result.unk3300ALHLENELIEO_ = this.unk3300ALHLENELIEO_;
                result.unk3300ACJLANLBCGK_ = this.unk3300ACJLANLBCGK_;
                result.unk3300HHKKEDDIGLA_ = this.unk3300HHKKEDDIGLA_;
                result.unk3300KJDEFIBKBPE_ = this.unk3300KJDEFIBKBPE_;
                result.unk3300ICJOCDGLFFD_ = this.unk3300ICJOCDGLFFD_;
                result.unk3300NMHHGNPKBEL_ = this.unk3300NMHHGNPKBEL_;
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
                if (other instanceof VintageMarketInfo) {
                    return mergeFrom((VintageMarketInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VintageMarketInfo other) {
                if (other == VintageMarketInfo.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableBargainInfoMap().mergeFrom(other.internalGetBargainInfoMap());
                if (other.getUnk3300FJDIMCJEAOB()) {
                    setUnk3300FJDIMCJEAOB(other.getUnk3300FJDIMCJEAOB());
                }
                if (!other.unk3300COKBOKAOCNJ_.isEmpty()) {
                    if (this.unk3300COKBOKAOCNJ_.isEmpty()) {
                        this.unk3300COKBOKAOCNJ_ = other.unk3300COKBOKAOCNJ_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnk3300COKBOKAOCNJIsMutable();
                        this.unk3300COKBOKAOCNJ_.addAll(other.unk3300COKBOKAOCNJ_);
                    }
                    onChanged();
                }
                if (other.getHelpSkillId() != 0) {
                    setHelpSkillId(other.getHelpSkillId());
                }
                if (!other.unk3300ABHHACBDCFI_.isEmpty()) {
                    if (this.unk3300ABHHACBDCFI_.isEmpty()) {
                        this.unk3300ABHHACBDCFI_ = other.unk3300ABHHACBDCFI_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureUnk3300ABHHACBDCFIIsMutable();
                        this.unk3300ABHHACBDCFI_.addAll(other.unk3300ABHHACBDCFI_);
                    }
                    onChanged();
                }
                if (this.openStoreListBuilder_ == null) {
                    if (!other.openStoreList_.isEmpty()) {
                        if (this.openStoreList_.isEmpty()) {
                            this.openStoreList_ = other.openStoreList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureOpenStoreListIsMutable();
                            this.openStoreList_.addAll(other.openStoreList_);
                        }
                        onChanged();
                    }
                } else if (!other.openStoreList_.isEmpty()) {
                    if (this.openStoreListBuilder_.isEmpty()) {
                        this.openStoreListBuilder_.dispose();
                        this.openStoreListBuilder_ = null;
                        this.openStoreList_ = other.openStoreList_;
                        this.bitField0_ &= -9;
                        this.openStoreListBuilder_ = VintageMarketInfo.alwaysUseFieldBuilders ? getOpenStoreListFieldBuilder() : null;
                    } else {
                        this.openStoreListBuilder_.addAllMessages(other.openStoreList_);
                    }
                }
                if (!other.unk3300EDBJLBICEJF_.isEmpty()) {
                    if (this.unk3300EDBJLBICEJF_.isEmpty()) {
                        this.unk3300EDBJLBICEJF_ = other.unk3300EDBJLBICEJF_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureUnk3300EDBJLBICEJFIsMutable();
                        this.unk3300EDBJLBICEJF_.addAll(other.unk3300EDBJLBICEJF_);
                    }
                    onChanged();
                }
                if (other.getUnk3300PAMKPAOCJJJ()) {
                    setUnk3300PAMKPAOCJJJ(other.getUnk3300PAMKPAOCJJJ());
                }
                if (other.getUnk3300FOPKAIIAMFM() != 0) {
                    setUnk3300FOPKAIIAMFM(other.getUnk3300FOPKAIIAMFM());
                }
                if (other.getUnk3300NBNOJJBNJPB()) {
                    setUnk3300NBNOJJBNJPB(other.getUnk3300NBNOJJBNJPB());
                }
                if (other.hasDealInfo()) {
                    mergeDealInfo(other.getDealInfo());
                }
                if (other.getStoreRound() != 0) {
                    setStoreRound(other.getStoreRound());
                }
                if (!other.unlockStrategyList_.isEmpty()) {
                    if (this.unlockStrategyList_.isEmpty()) {
                        this.unlockStrategyList_ = other.unlockStrategyList_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureUnlockStrategyListIsMutable();
                        this.unlockStrategyList_.addAll(other.unlockStrategyList_);
                    }
                    onChanged();
                }
                if (!other.unk3300AIAMBBODLBO_.isEmpty()) {
                    if (this.unk3300AIAMBBODLBO_.isEmpty()) {
                        this.unk3300AIAMBBODLBO_ = other.unk3300AIAMBBODLBO_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureUnk3300AIAMBBODLBOIsMutable();
                        this.unk3300AIAMBBODLBO_.addAll(other.unk3300AIAMBBODLBO_);
                    }
                    onChanged();
                }
                if (other.getUnk3300NDFHAGHBCFN()) {
                    setUnk3300NDFHAGHBCFN(other.getUnk3300NDFHAGHBCFN());
                }
                if (other.getUnk3300LMNLHHPMAMN() != 0) {
                    setUnk3300LMNLHHPMAMN(other.getUnk3300LMNLHHPMAMN());
                }
                if (other.getUnk3300ALHLENELIEO()) {
                    setUnk3300ALHLENELIEO(other.getUnk3300ALHLENELIEO());
                }
                if (other.getUnk3300ACJLANLBCGK() != 0) {
                    setUnk3300ACJLANLBCGK(other.getUnk3300ACJLANLBCGK());
                }
                if (other.getUnk3300HHKKEDDIGLA() != 0) {
                    setUnk3300HHKKEDDIGLA(other.getUnk3300HHKKEDDIGLA());
                }
                if (other.getUnk3300KJDEFIBKBPE()) {
                    setUnk3300KJDEFIBKBPE(other.getUnk3300KJDEFIBKBPE());
                }
                if (other.getUnk3300ICJOCDGLFFD()) {
                    setUnk3300ICJOCDGLFFD(other.getUnk3300ICJOCDGLFFD());
                }
                if (other.getUnk3300NMHHGNPKBEL()) {
                    setUnk3300NMHHGNPKBEL(other.getUnk3300NMHHGNPKBEL());
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
                VintageMarketInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = VintageMarketInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VintageMarketInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, Boolean> internalGetBargainInfoMap() {
                if (this.bargainInfoMap_ == null) {
                    return MapField.emptyMapField(BargainInfoMapDefaultEntryHolder.defaultEntry);
                }
                return this.bargainInfoMap_;
            }

            private MapField<Integer, Boolean> internalGetMutableBargainInfoMap() {
                onChanged();
                if (this.bargainInfoMap_ == null) {
                    this.bargainInfoMap_ = MapField.newMapField(BargainInfoMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.bargainInfoMap_.isMutable()) {
                    this.bargainInfoMap_ = this.bargainInfoMap_.copy();
                }
                return this.bargainInfoMap_;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getBargainInfoMapCount() {
                return internalGetBargainInfoMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public boolean containsBargainInfoMap(int key) {
                return internalGetBargainInfoMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            @Deprecated
            public Map<Integer, Boolean> getBargainInfoMap() {
                return getBargainInfoMapMap();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public Map<Integer, Boolean> getBargainInfoMapMap() {
                return internalGetBargainInfoMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public boolean getBargainInfoMapOrDefault(int key, boolean defaultValue) {
                Map<Integer, Boolean> map = internalGetBargainInfoMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).booleanValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public boolean getBargainInfoMapOrThrow(int key) {
                Map<Integer, Boolean> map = internalGetBargainInfoMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).booleanValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearBargainInfoMap() {
                internalGetMutableBargainInfoMap().getMutableMap().clear();
                return this;
            }

            public Builder removeBargainInfoMap(int key) {
                internalGetMutableBargainInfoMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Boolean> getMutableBargainInfoMap() {
                return internalGetMutableBargainInfoMap().getMutableMap();
            }

            public Builder putBargainInfoMap(int key, boolean value) {
                internalGetMutableBargainInfoMap().getMutableMap().put(Integer.valueOf(key), Boolean.valueOf(value));
                return this;
            }

            public Builder putAllBargainInfoMap(Map<Integer, Boolean> values) {
                internalGetMutableBargainInfoMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public boolean getUnk3300FJDIMCJEAOB() {
                return this.unk3300FJDIMCJEAOB_;
            }

            public Builder setUnk3300FJDIMCJEAOB(boolean value) {
                this.unk3300FJDIMCJEAOB_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300FJDIMCJEAOB() {
                this.unk3300FJDIMCJEAOB_ = false;
                onChanged();
                return this;
            }

            private void ensureUnk3300COKBOKAOCNJIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300COKBOKAOCNJ_ = VintageMarketInfo.mutableCopy(this.unk3300COKBOKAOCNJ_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public List<Integer> getUnk3300COKBOKAOCNJList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unk3300COKBOKAOCNJ_) : this.unk3300COKBOKAOCNJ_;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getUnk3300COKBOKAOCNJCount() {
                return this.unk3300COKBOKAOCNJ_.size();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getUnk3300COKBOKAOCNJ(int index) {
                return this.unk3300COKBOKAOCNJ_.getInt(index);
            }

            public Builder setUnk3300COKBOKAOCNJ(int index, int value) {
                ensureUnk3300COKBOKAOCNJIsMutable();
                this.unk3300COKBOKAOCNJ_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300COKBOKAOCNJ(int value) {
                ensureUnk3300COKBOKAOCNJIsMutable();
                this.unk3300COKBOKAOCNJ_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300COKBOKAOCNJ(Iterable<? extends Integer> values) {
                ensureUnk3300COKBOKAOCNJIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300COKBOKAOCNJ_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300COKBOKAOCNJ() {
                this.unk3300COKBOKAOCNJ_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getHelpSkillId() {
                return this.helpSkillId_;
            }

            public Builder setHelpSkillId(int value) {
                this.helpSkillId_ = value;
                onChanged();
                return this;
            }

            public Builder clearHelpSkillId() {
                this.helpSkillId_ = 0;
                onChanged();
                return this;
            }

            private void ensureUnk3300ABHHACBDCFIIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.unk3300ABHHACBDCFI_ = VintageMarketInfo.mutableCopy(this.unk3300ABHHACBDCFI_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public List<Integer> getUnk3300ABHHACBDCFIList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.unk3300ABHHACBDCFI_) : this.unk3300ABHHACBDCFI_;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getUnk3300ABHHACBDCFICount() {
                return this.unk3300ABHHACBDCFI_.size();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getUnk3300ABHHACBDCFI(int index) {
                return this.unk3300ABHHACBDCFI_.getInt(index);
            }

            public Builder setUnk3300ABHHACBDCFI(int index, int value) {
                ensureUnk3300ABHHACBDCFIIsMutable();
                this.unk3300ABHHACBDCFI_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300ABHHACBDCFI(int value) {
                ensureUnk3300ABHHACBDCFIIsMutable();
                this.unk3300ABHHACBDCFI_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300ABHHACBDCFI(Iterable<? extends Integer> values) {
                ensureUnk3300ABHHACBDCFIIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300ABHHACBDCFI_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300ABHHACBDCFI() {
                this.unk3300ABHHACBDCFI_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private void ensureOpenStoreListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.openStoreList_ = new ArrayList(this.openStoreList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public List<VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo> getOpenStoreListList() {
                if (this.openStoreListBuilder_ == null) {
                    return Collections.unmodifiableList(this.openStoreList_);
                }
                return this.openStoreListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getOpenStoreListCount() {
                if (this.openStoreListBuilder_ == null) {
                    return this.openStoreList_.size();
                }
                return this.openStoreListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo getOpenStoreList(int index) {
                if (this.openStoreListBuilder_ == null) {
                    return this.openStoreList_.get(index);
                }
                return this.openStoreListBuilder_.getMessage(index);
            }

            public Builder setOpenStoreList(int index, VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo value) {
                if (this.openStoreListBuilder_ != null) {
                    this.openStoreListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOpenStoreListIsMutable();
                    this.openStoreList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setOpenStoreList(int index, VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.Builder builderForValue) {
                if (this.openStoreListBuilder_ == null) {
                    ensureOpenStoreListIsMutable();
                    this.openStoreList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.openStoreListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addOpenStoreList(VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo value) {
                if (this.openStoreListBuilder_ != null) {
                    this.openStoreListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOpenStoreListIsMutable();
                    this.openStoreList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addOpenStoreList(int index, VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo value) {
                if (this.openStoreListBuilder_ != null) {
                    this.openStoreListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOpenStoreListIsMutable();
                    this.openStoreList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addOpenStoreList(VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.Builder builderForValue) {
                if (this.openStoreListBuilder_ == null) {
                    ensureOpenStoreListIsMutable();
                    this.openStoreList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.openStoreListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addOpenStoreList(int index, VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.Builder builderForValue) {
                if (this.openStoreListBuilder_ == null) {
                    ensureOpenStoreListIsMutable();
                    this.openStoreList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.openStoreListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllOpenStoreList(Iterable<? extends VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo> values) {
                if (this.openStoreListBuilder_ == null) {
                    ensureOpenStoreListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.openStoreList_);
                    onChanged();
                } else {
                    this.openStoreListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearOpenStoreList() {
                if (this.openStoreListBuilder_ == null) {
                    this.openStoreList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.openStoreListBuilder_.clear();
                }
                return this;
            }

            public Builder removeOpenStoreList(int index) {
                if (this.openStoreListBuilder_ == null) {
                    ensureOpenStoreListIsMutable();
                    this.openStoreList_.remove(index);
                    onChanged();
                } else {
                    this.openStoreListBuilder_.remove(index);
                }
                return this;
            }

            public VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.Builder getOpenStoreListBuilder(int index) {
                return getOpenStoreListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder getOpenStoreListOrBuilder(int index) {
                if (this.openStoreListBuilder_ == null) {
                    return this.openStoreList_.get(index);
                }
                return this.openStoreListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public List<? extends VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder> getOpenStoreListOrBuilderList() {
                if (this.openStoreListBuilder_ != null) {
                    return this.openStoreListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.openStoreList_);
            }

            public VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.Builder addOpenStoreListBuilder() {
                return getOpenStoreListFieldBuilder().addBuilder(VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.getDefaultInstance());
            }

            public VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.Builder addOpenStoreListBuilder(int index) {
                return getOpenStoreListFieldBuilder().addBuilder(index, VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.getDefaultInstance());
            }

            public List<VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.Builder> getOpenStoreListBuilderList() {
                return getOpenStoreListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo, VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.Builder, VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder> getOpenStoreListFieldBuilder() {
                if (this.openStoreListBuilder_ == null) {
                    this.openStoreListBuilder_ = new RepeatedFieldBuilderV3<>(this.openStoreList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.openStoreList_ = null;
                }
                return this.openStoreListBuilder_;
            }

            private void ensureUnk3300EDBJLBICEJFIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.unk3300EDBJLBICEJF_ = VintageMarketInfo.mutableCopy(this.unk3300EDBJLBICEJF_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public List<Integer> getUnk3300EDBJLBICEJFList() {
                return (this.bitField0_ & 16) != 0 ? Collections.unmodifiableList(this.unk3300EDBJLBICEJF_) : this.unk3300EDBJLBICEJF_;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getUnk3300EDBJLBICEJFCount() {
                return this.unk3300EDBJLBICEJF_.size();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getUnk3300EDBJLBICEJF(int index) {
                return this.unk3300EDBJLBICEJF_.getInt(index);
            }

            public Builder setUnk3300EDBJLBICEJF(int index, int value) {
                ensureUnk3300EDBJLBICEJFIsMutable();
                this.unk3300EDBJLBICEJF_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300EDBJLBICEJF(int value) {
                ensureUnk3300EDBJLBICEJFIsMutable();
                this.unk3300EDBJLBICEJF_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300EDBJLBICEJF(Iterable<? extends Integer> values) {
                ensureUnk3300EDBJLBICEJFIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300EDBJLBICEJF_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300EDBJLBICEJF() {
                this.unk3300EDBJLBICEJF_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -17;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public boolean getUnk3300PAMKPAOCJJJ() {
                return this.unk3300PAMKPAOCJJJ_;
            }

            public Builder setUnk3300PAMKPAOCJJJ(boolean value) {
                this.unk3300PAMKPAOCJJJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PAMKPAOCJJJ() {
                this.unk3300PAMKPAOCJJJ_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getUnk3300FOPKAIIAMFM() {
                return this.unk3300FOPKAIIAMFM_;
            }

            public Builder setUnk3300FOPKAIIAMFM(int value) {
                this.unk3300FOPKAIIAMFM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300FOPKAIIAMFM() {
                this.unk3300FOPKAIIAMFM_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public boolean getUnk3300NBNOJJBNJPB() {
                return this.unk3300NBNOJJBNJPB_;
            }

            public Builder setUnk3300NBNOJJBNJPB(boolean value) {
                this.unk3300NBNOJJBNJPB_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NBNOJJBNJPB() {
                this.unk3300NBNOJJBNJPB_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public boolean hasDealInfo() {
                return (this.dealInfoBuilder_ == null && this.dealInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public VintageMarketDealInfoOuterClass.VintageMarketDealInfo getDealInfo() {
                if (this.dealInfoBuilder_ == null) {
                    return this.dealInfo_ == null ? VintageMarketDealInfoOuterClass.VintageMarketDealInfo.getDefaultInstance() : this.dealInfo_;
                }
                return this.dealInfoBuilder_.getMessage();
            }

            public Builder setDealInfo(VintageMarketDealInfoOuterClass.VintageMarketDealInfo value) {
                if (this.dealInfoBuilder_ != null) {
                    this.dealInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.dealInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setDealInfo(VintageMarketDealInfoOuterClass.VintageMarketDealInfo.Builder builderForValue) {
                if (this.dealInfoBuilder_ == null) {
                    this.dealInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.dealInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeDealInfo(VintageMarketDealInfoOuterClass.VintageMarketDealInfo value) {
                if (this.dealInfoBuilder_ == null) {
                    if (this.dealInfo_ != null) {
                        this.dealInfo_ = VintageMarketDealInfoOuterClass.VintageMarketDealInfo.newBuilder(this.dealInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.dealInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.dealInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearDealInfo() {
                if (this.dealInfoBuilder_ == null) {
                    this.dealInfo_ = null;
                    onChanged();
                } else {
                    this.dealInfo_ = null;
                    this.dealInfoBuilder_ = null;
                }
                return this;
            }

            public VintageMarketDealInfoOuterClass.VintageMarketDealInfo.Builder getDealInfoBuilder() {
                onChanged();
                return getDealInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public VintageMarketDealInfoOuterClass.VintageMarketDealInfoOrBuilder getDealInfoOrBuilder() {
                if (this.dealInfoBuilder_ != null) {
                    return this.dealInfoBuilder_.getMessageOrBuilder();
                }
                return this.dealInfo_ == null ? VintageMarketDealInfoOuterClass.VintageMarketDealInfo.getDefaultInstance() : this.dealInfo_;
            }

            private SingleFieldBuilderV3<VintageMarketDealInfoOuterClass.VintageMarketDealInfo, VintageMarketDealInfoOuterClass.VintageMarketDealInfo.Builder, VintageMarketDealInfoOuterClass.VintageMarketDealInfoOrBuilder> getDealInfoFieldBuilder() {
                if (this.dealInfoBuilder_ == null) {
                    this.dealInfoBuilder_ = new SingleFieldBuilderV3<>(getDealInfo(), getParentForChildren(), isClean());
                    this.dealInfo_ = null;
                }
                return this.dealInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getStoreRound() {
                return this.storeRound_;
            }

            public Builder setStoreRound(int value) {
                this.storeRound_ = value;
                onChanged();
                return this;
            }

            public Builder clearStoreRound() {
                this.storeRound_ = 0;
                onChanged();
                return this;
            }

            private void ensureUnlockStrategyListIsMutable() {
                if ((this.bitField0_ & 32) == 0) {
                    this.unlockStrategyList_ = VintageMarketInfo.mutableCopy(this.unlockStrategyList_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public List<Integer> getUnlockStrategyListList() {
                return (this.bitField0_ & 32) != 0 ? Collections.unmodifiableList(this.unlockStrategyList_) : this.unlockStrategyList_;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getUnlockStrategyListCount() {
                return this.unlockStrategyList_.size();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getUnlockStrategyList(int index) {
                return this.unlockStrategyList_.getInt(index);
            }

            public Builder setUnlockStrategyList(int index, int value) {
                ensureUnlockStrategyListIsMutable();
                this.unlockStrategyList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnlockStrategyList(int value) {
                ensureUnlockStrategyListIsMutable();
                this.unlockStrategyList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnlockStrategyList(Iterable<? extends Integer> values) {
                ensureUnlockStrategyListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unlockStrategyList_);
                onChanged();
                return this;
            }

            public Builder clearUnlockStrategyList() {
                this.unlockStrategyList_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }

            private void ensureUnk3300AIAMBBODLBOIsMutable() {
                if ((this.bitField0_ & 64) == 0) {
                    this.unk3300AIAMBBODLBO_ = VintageMarketInfo.mutableCopy(this.unk3300AIAMBBODLBO_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public List<Integer> getUnk3300AIAMBBODLBOList() {
                return (this.bitField0_ & 64) != 0 ? Collections.unmodifiableList(this.unk3300AIAMBBODLBO_) : this.unk3300AIAMBBODLBO_;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getUnk3300AIAMBBODLBOCount() {
                return this.unk3300AIAMBBODLBO_.size();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getUnk3300AIAMBBODLBO(int index) {
                return this.unk3300AIAMBBODLBO_.getInt(index);
            }

            public Builder setUnk3300AIAMBBODLBO(int index, int value) {
                ensureUnk3300AIAMBBODLBOIsMutable();
                this.unk3300AIAMBBODLBO_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300AIAMBBODLBO(int value) {
                ensureUnk3300AIAMBBODLBOIsMutable();
                this.unk3300AIAMBBODLBO_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300AIAMBBODLBO(Iterable<? extends Integer> values) {
                ensureUnk3300AIAMBBODLBOIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300AIAMBBODLBO_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300AIAMBBODLBO() {
                this.unk3300AIAMBBODLBO_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -65;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public boolean getUnk3300NDFHAGHBCFN() {
                return this.unk3300NDFHAGHBCFN_;
            }

            public Builder setUnk3300NDFHAGHBCFN(boolean value) {
                this.unk3300NDFHAGHBCFN_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NDFHAGHBCFN() {
                this.unk3300NDFHAGHBCFN_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getUnk3300LMNLHHPMAMN() {
                return this.unk3300LMNLHHPMAMN_;
            }

            public Builder setUnk3300LMNLHHPMAMN(int value) {
                this.unk3300LMNLHHPMAMN_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LMNLHHPMAMN() {
                this.unk3300LMNLHHPMAMN_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public boolean getUnk3300ALHLENELIEO() {
                return this.unk3300ALHLENELIEO_;
            }

            public Builder setUnk3300ALHLENELIEO(boolean value) {
                this.unk3300ALHLENELIEO_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ALHLENELIEO() {
                this.unk3300ALHLENELIEO_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getUnk3300ACJLANLBCGK() {
                return this.unk3300ACJLANLBCGK_;
            }

            public Builder setUnk3300ACJLANLBCGK(int value) {
                this.unk3300ACJLANLBCGK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ACJLANLBCGK() {
                this.unk3300ACJLANLBCGK_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public int getUnk3300HHKKEDDIGLA() {
                return this.unk3300HHKKEDDIGLA_;
            }

            public Builder setUnk3300HHKKEDDIGLA(int value) {
                this.unk3300HHKKEDDIGLA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HHKKEDDIGLA() {
                this.unk3300HHKKEDDIGLA_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public boolean getUnk3300KJDEFIBKBPE() {
                return this.unk3300KJDEFIBKBPE_;
            }

            public Builder setUnk3300KJDEFIBKBPE(boolean value) {
                this.unk3300KJDEFIBKBPE_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300KJDEFIBKBPE() {
                this.unk3300KJDEFIBKBPE_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public boolean getUnk3300ICJOCDGLFFD() {
                return this.unk3300ICJOCDGLFFD_;
            }

            public Builder setUnk3300ICJOCDGLFFD(boolean value) {
                this.unk3300ICJOCDGLFFD_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ICJOCDGLFFD() {
                this.unk3300ICJOCDGLFFD_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public boolean getUnk3300NMHHGNPKBEL() {
                return this.unk3300NMHHGNPKBEL_;
            }

            public Builder setUnk3300NMHHGNPKBEL(boolean value) {
                this.unk3300NMHHGNPKBEL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NMHHGNPKBEL() {
                this.unk3300NMHHGNPKBEL_ = false;
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

        public static VintageMarketInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VintageMarketInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VintageMarketInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VintageMarketInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VintageMarketDealInfoOuterClass.getDescriptor();
        VintageMarketStoreInfoOuterClass.getDescriptor();
    }
}
