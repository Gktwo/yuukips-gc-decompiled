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
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.RetcodeOuterClass;
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
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017VintageMarketInfo.proto\u001a\u001bVintageMarketDealInfo.proto\u001a\u001cVintageMarketStoreInfo.proto\"\u0006\n\u0011VintageMarketInfo\u0012\u001a\n\u0012unlockStrategyList\u0018\u000f \u0003(\r\u0012\u0012\n\nstoreRound\u0018\u0002 \u0001(\r\u0012\u001c\n\u0013Unk3300_COKBOKAOCNJ\u0018À\t \u0003(\r\u0012>\n\u000ebargainInfoMap\u0018\t \u0003(\u000b2&.VintageMarketInfo.BargainInfoMapEntry\u0012\u001b\n\u0013Unk3300_ABHHACBDCFI\u0018\u0003 \u0003(\r\u0012\u001b\n\u0013Unk3300_EDBJLBICEJF\u0018\u0001 \u0003(\r\u0012\u001b\n\u0013Unk3300_KJDEFIBKBPE\u0018\u0005 \u0001(\b\u0012\u001c\n\u0013Unk3300_NMHHGNPKBEL\u0018\t \u0001(\b\u0012\u001c\n\u0013Unk3300_FOPKAIIAMFM\u0018ÿ\u0001 \u0001(\r\u0012\u001b\n\u0013Unk3300_LMNLHHPMAMN\u0018\f \u0001(\r\u0012\u001c\n\u0013Unk3300_ALHLENELIEO\u0018\b \u0001(\b\u0012\u001b\n\u0013Unk3300_PAMKPAOCJJJ\u0018\u0004 \u0001(\b\u0012\u001b\n\u0013Unk3300_ICJOCDGLFFD\u0018\n \u0001(\b\u0012(\n\bdealInfo\u0018\u000e \u0001(\u000b2\u0016.VintageMarketDealInfo\u0012\u001b\n\u0013Unk3300_NDFHAGHBCFN\u0018\u0006 \u0001(\b\u0012.\n\ropenStoreList\u0018\u0007 \u0003(\u000b2\u0017.VintageMarketStoreInfo\u0012\u001b\n\u0013Unk3300_AIAMBBODLBO\u0018\r \u0003(\r\u0012\u0014\n\u000bhelpSkillId\u0018Æ\t \u0001(\r\u0012\u001b\n\u0013Unk3300_FJDIMCJEAOB\u0018\b \u0001(\b\u0012\u001b\n\u0013Unk3300_HHKKEDDIGLA\u0018\u000b \u0001(\r\u0012\u001c\n\u0013Unk3300_ACJLANLBCGK\u0018Ê\u0003 \u0001(\r\u0012\u001c\n\u0013Unk3300_NBNOJJBNJPB\u0018¦\t \u0001(\b\u001a5\n\u0013BargainInfoMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\b:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VintageMarketDealInfoOuterClass.getDescriptor(), VintageMarketStoreInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_VintageMarketInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VintageMarketInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VintageMarketInfo_descriptor, new String[]{"UnlockStrategyList", "StoreRound", "Unk3300COKBOKAOCNJ", "BargainInfoMap", "Unk3300ABHHACBDCFI", "Unk3300EDBJLBICEJF", "Unk3300KJDEFIBKBPE", "Unk3300NMHHGNPKBEL", "Unk3300FOPKAIIAMFM", "Unk3300LMNLHHPMAMN", "Unk3300ALHLENELIEO", "Unk3300PAMKPAOCJJJ", "Unk3300ICJOCDGLFFD", "DealInfo", "Unk3300NDFHAGHBCFN", "OpenStoreList", "Unk3300AIAMBBODLBO", "HelpSkillId", "Unk3300FJDIMCJEAOB", "Unk3300HHKKEDDIGLA", "Unk3300ACJLANLBCGK", "Unk3300NBNOJJBNJPB"});
    private static final Descriptors.Descriptor internal_static_VintageMarketInfo_BargainInfoMapEntry_descriptor = internal_static_VintageMarketInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_VintageMarketInfo_BargainInfoMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f899xb592af94 = new GeneratedMessageV3.FieldAccessorTable(internal_static_VintageMarketInfo_BargainInfoMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketInfoOuterClass$VintageMarketInfoOrBuilder.class */
    public interface VintageMarketInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getUnlockStrategyListList();

        int getUnlockStrategyListCount();

        int getUnlockStrategyList(int i);

        int getStoreRound();

        List<Integer> getUnk3300COKBOKAOCNJList();

        int getUnk3300COKBOKAOCNJCount();

        int getUnk3300COKBOKAOCNJ(int i);

        int getBargainInfoMapCount();

        boolean containsBargainInfoMap(int i);

        @Deprecated
        Map<Integer, Boolean> getBargainInfoMap();

        Map<Integer, Boolean> getBargainInfoMapMap();

        boolean getBargainInfoMapOrDefault(int i, boolean z);

        boolean getBargainInfoMapOrThrow(int i);

        List<Integer> getUnk3300ABHHACBDCFIList();

        int getUnk3300ABHHACBDCFICount();

        int getUnk3300ABHHACBDCFI(int i);

        List<Integer> getUnk3300EDBJLBICEJFList();

        int getUnk3300EDBJLBICEJFCount();

        int getUnk3300EDBJLBICEJF(int i);

        boolean getUnk3300KJDEFIBKBPE();

        boolean getUnk3300NMHHGNPKBEL();

        int getUnk3300FOPKAIIAMFM();

        int getUnk3300LMNLHHPMAMN();

        boolean getUnk3300ALHLENELIEO();

        boolean getUnk3300PAMKPAOCJJJ();

        boolean getUnk3300ICJOCDGLFFD();

        boolean hasDealInfo();

        VintageMarketDealInfoOuterClass.VintageMarketDealInfo getDealInfo();

        VintageMarketDealInfoOuterClass.VintageMarketDealInfoOrBuilder getDealInfoOrBuilder();

        boolean getUnk3300NDFHAGHBCFN();

        List<VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo> getOpenStoreListList();

        VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo getOpenStoreList(int i);

        int getOpenStoreListCount();

        List<? extends VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder> getOpenStoreListOrBuilderList();

        VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder getOpenStoreListOrBuilder(int i);

        List<Integer> getUnk3300AIAMBBODLBOList();

        int getUnk3300AIAMBBODLBOCount();

        int getUnk3300AIAMBBODLBO(int i);

        int getHelpSkillId();

        boolean getUnk3300FJDIMCJEAOB();

        int getUnk3300HHKKEDDIGLA();

        int getUnk3300ACJLANLBCGK();

        boolean getUnk3300NBNOJJBNJPB();
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
        public static final int UNLOCKSTRATEGYLIST_FIELD_NUMBER = 15;
        private Internal.IntList unlockStrategyList_;
        private int unlockStrategyListMemoizedSerializedSize;
        public static final int STOREROUND_FIELD_NUMBER = 2;
        private int storeRound_;
        public static final int UNK3300_COKBOKAOCNJ_FIELD_NUMBER = 1216;
        private Internal.IntList unk3300COKBOKAOCNJ_;
        private int unk3300COKBOKAOCNJMemoizedSerializedSize;
        public static final int BARGAININFOMAP_FIELD_NUMBER = 9;
        private MapField<Integer, Boolean> bargainInfoMap_;
        public static final int UNK3300_ABHHACBDCFI_FIELD_NUMBER = 3;
        private Internal.IntList unk3300ABHHACBDCFI_;
        private int unk3300ABHHACBDCFIMemoizedSerializedSize;
        public static final int UNK3300_EDBJLBICEJF_FIELD_NUMBER = 1;
        private Internal.IntList unk3300EDBJLBICEJF_;
        private int unk3300EDBJLBICEJFMemoizedSerializedSize;
        public static final int UNK3300_KJDEFIBKBPE_FIELD_NUMBER = 5;
        private boolean unk3300KJDEFIBKBPE_;
        public static final int UNK3300_NMHHGNPKBEL_FIELD_NUMBER = 1164;
        private boolean unk3300NMHHGNPKBEL_;
        public static final int UNK3300_FOPKAIIAMFM_FIELD_NUMBER = 255;
        private int unk3300FOPKAIIAMFM_;
        public static final int UNK3300_LMNLHHPMAMN_FIELD_NUMBER = 12;
        private int unk3300LMNLHHPMAMN_;
        public static final int UNK3300_ALHLENELIEO_FIELD_NUMBER = 1035;
        private boolean unk3300ALHLENELIEO_;
        public static final int UNK3300_PAMKPAOCJJJ_FIELD_NUMBER = 4;
        private boolean unk3300PAMKPAOCJJJ_;
        public static final int UNK3300_ICJOCDGLFFD_FIELD_NUMBER = 10;
        private boolean unk3300ICJOCDGLFFD_;
        public static final int DEALINFO_FIELD_NUMBER = 14;
        private VintageMarketDealInfoOuterClass.VintageMarketDealInfo dealInfo_;
        public static final int UNK3300_NDFHAGHBCFN_FIELD_NUMBER = 6;
        private boolean unk3300NDFHAGHBCFN_;
        public static final int OPENSTORELIST_FIELD_NUMBER = 7;
        private List<VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo> openStoreList_;
        public static final int UNK3300_AIAMBBODLBO_FIELD_NUMBER = 13;
        private Internal.IntList unk3300AIAMBBODLBO_;
        private int unk3300AIAMBBODLBOMemoizedSerializedSize;
        public static final int HELPSKILLID_FIELD_NUMBER = 1222;
        private int helpSkillId_;
        public static final int UNK3300_FJDIMCJEAOB_FIELD_NUMBER = 8;
        private boolean unk3300FJDIMCJEAOB_;
        public static final int UNK3300_HHKKEDDIGLA_FIELD_NUMBER = 11;
        private int unk3300HHKKEDDIGLA_;
        public static final int UNK3300_ACJLANLBCGK_FIELD_NUMBER = 458;
        private int unk3300ACJLANLBCGK_;
        public static final int UNK3300_NBNOJJBNJPB_FIELD_NUMBER = 1190;
        private boolean unk3300NBNOJJBNJPB_;
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
            this.unlockStrategyListMemoizedSerializedSize = -1;
            this.unk3300COKBOKAOCNJMemoizedSerializedSize = -1;
            this.unk3300ABHHACBDCFIMemoizedSerializedSize = -1;
            this.unk3300EDBJLBICEJFMemoizedSerializedSize = -1;
            this.unk3300AIAMBBODLBOMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private VintageMarketInfo() {
            this.unlockStrategyListMemoizedSerializedSize = -1;
            this.unk3300COKBOKAOCNJMemoizedSerializedSize = -1;
            this.unk3300ABHHACBDCFIMemoizedSerializedSize = -1;
            this.unk3300EDBJLBICEJFMemoizedSerializedSize = -1;
            this.unk3300AIAMBBODLBOMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unlockStrategyList_ = emptyIntList();
            this.unk3300COKBOKAOCNJ_ = emptyIntList();
            this.unk3300ABHHACBDCFI_ = emptyIntList();
            this.unk3300EDBJLBICEJF_ = emptyIntList();
            this.openStoreList_ = Collections.emptyList();
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
                                if ((mutable_bitField0_ & 16) == 0) {
                                    this.unk3300EDBJLBICEJF_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                this.unk3300EDBJLBICEJF_.addInt(input.readUInt32());
                                break;
                            case 10:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 16) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300EDBJLBICEJF_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300EDBJLBICEJF_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 16:
                                this.storeRound_ = input.readUInt32();
                                break;
                            case 24:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.unk3300ABHHACBDCFI_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.unk3300ABHHACBDCFI_.addInt(input.readUInt32());
                                break;
                            case 26:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300ABHHACBDCFI_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300ABHHACBDCFI_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 32:
                                this.unk3300PAMKPAOCJJJ_ = input.readBool();
                                break;
                            case 40:
                                this.unk3300KJDEFIBKBPE_ = input.readBool();
                                break;
                            case 48:
                                this.unk3300NDFHAGHBCFN_ = input.readBool();
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 32) == 0) {
                                    this.openStoreList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                }
                                this.openStoreList_.add((VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo) input.readMessage(VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.parser(), extensionRegistry));
                                break;
                            case 64:
                                this.unk3300FJDIMCJEAOB_ = input.readBool();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.bargainInfoMap_ = MapField.newMapField(BargainInfoMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Boolean> bargainInfoMap__ = (MapEntry) input.readMessage(BargainInfoMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.bargainInfoMap_.getMutableMap().put(bargainInfoMap__.getKey(), bargainInfoMap__.getValue());
                                break;
                            case 80:
                                this.unk3300ICJOCDGLFFD_ = input.readBool();
                                break;
                            case 88:
                                this.unk3300HHKKEDDIGLA_ = input.readUInt32();
                                break;
                            case 96:
                                this.unk3300LMNLHHPMAMN_ = input.readUInt32();
                                break;
                            case 104:
                                if ((mutable_bitField0_ & 64) == 0) {
                                    this.unk3300AIAMBBODLBO_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                }
                                this.unk3300AIAMBBODLBO_.addInt(input.readUInt32());
                                break;
                            case 106:
                                int limit3 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 64) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300AIAMBBODLBO_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300AIAMBBODLBO_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit3);
                                break;
                            case 114:
                                VintageMarketDealInfoOuterClass.VintageMarketDealInfo.Builder subBuilder = this.dealInfo_ != null ? this.dealInfo_.toBuilder() : null;
                                this.dealInfo_ = (VintageMarketDealInfoOuterClass.VintageMarketDealInfo) input.readMessage(VintageMarketDealInfoOuterClass.VintageMarketDealInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.dealInfo_);
                                    this.dealInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 120:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unlockStrategyList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.unlockStrategyList_.addInt(input.readUInt32());
                                break;
                            case 122:
                                int limit4 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unlockStrategyList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unlockStrategyList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit4);
                                break;
                            case PacketOpcodes.FleurFairReplayMiniGameRsp:
                                this.unk3300FOPKAIIAMFM_ = input.readUInt32();
                                break;
                            case 3664:
                                this.unk3300ACJLANLBCGK_ = input.readUInt32();
                                break;
                            case 8280:
                                this.unk3300ALHLENELIEO_ = input.readBool();
                                break;
                            case 9312:
                                this.unk3300NMHHGNPKBEL_ = input.readBool();
                                break;
                            case 9520:
                                this.unk3300NBNOJJBNJPB_ = input.readBool();
                                break;
                            case RET_HOME_FURNITURE_SUITE_NOT_UNLOCKED_VALUE:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300COKBOKAOCNJ_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unk3300COKBOKAOCNJ_.addInt(input.readUInt32());
                                break;
                            case RET_HOME_IN_COMBAT_VALUE:
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
                            case RET_HOME_FURNITURE_ARRANGE_LIMIT_VALUE:
                                this.helpSkillId_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 16) != 0) {
                    this.unk3300EDBJLBICEJF_.makeImmutable();
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.unk3300ABHHACBDCFI_.makeImmutable();
                }
                if ((mutable_bitField0_ & 32) != 0) {
                    this.openStoreList_ = Collections.unmodifiableList(this.openStoreList_);
                }
                if ((mutable_bitField0_ & 64) != 0) {
                    this.unk3300AIAMBBODLBO_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unlockStrategyList_.makeImmutable();
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
        public int getStoreRound() {
            return this.storeRound_;
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
        public boolean getUnk3300KJDEFIBKBPE() {
            return this.unk3300KJDEFIBKBPE_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean getUnk3300NMHHGNPKBEL() {
            return this.unk3300NMHHGNPKBEL_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300FOPKAIIAMFM() {
            return this.unk3300FOPKAIIAMFM_;
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
        public boolean getUnk3300PAMKPAOCJJJ() {
            return this.unk3300PAMKPAOCJJJ_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean getUnk3300ICJOCDGLFFD() {
            return this.unk3300ICJOCDGLFFD_;
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
        public boolean getUnk3300NDFHAGHBCFN() {
            return this.unk3300NDFHAGHBCFN_;
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
        public int getHelpSkillId() {
            return this.helpSkillId_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean getUnk3300FJDIMCJEAOB() {
            return this.unk3300FJDIMCJEAOB_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300HHKKEDDIGLA() {
            return this.unk3300HHKKEDDIGLA_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public int getUnk3300ACJLANLBCGK() {
            return this.unk3300ACJLANLBCGK_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
        public boolean getUnk3300NBNOJJBNJPB() {
            return this.unk3300NBNOJJBNJPB_;
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
            if (getUnk3300EDBJLBICEJFList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.unk3300EDBJLBICEJFMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk3300EDBJLBICEJF_.size(); i++) {
                output.writeUInt32NoTag(this.unk3300EDBJLBICEJF_.getInt(i));
            }
            if (this.storeRound_ != 0) {
                output.writeUInt32(2, this.storeRound_);
            }
            if (getUnk3300ABHHACBDCFIList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.unk3300ABHHACBDCFIMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk3300ABHHACBDCFI_.size(); i2++) {
                output.writeUInt32NoTag(this.unk3300ABHHACBDCFI_.getInt(i2));
            }
            if (this.unk3300PAMKPAOCJJJ_) {
                output.writeBool(4, this.unk3300PAMKPAOCJJJ_);
            }
            if (this.unk3300KJDEFIBKBPE_) {
                output.writeBool(5, this.unk3300KJDEFIBKBPE_);
            }
            if (this.unk3300NDFHAGHBCFN_) {
                output.writeBool(6, this.unk3300NDFHAGHBCFN_);
            }
            for (int i3 = 0; i3 < this.openStoreList_.size(); i3++) {
                output.writeMessage(7, this.openStoreList_.get(i3));
            }
            if (this.unk3300FJDIMCJEAOB_) {
                output.writeBool(8, this.unk3300FJDIMCJEAOB_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetBargainInfoMap(), BargainInfoMapDefaultEntryHolder.defaultEntry, 9);
            if (this.unk3300ICJOCDGLFFD_) {
                output.writeBool(10, this.unk3300ICJOCDGLFFD_);
            }
            if (this.unk3300HHKKEDDIGLA_ != 0) {
                output.writeUInt32(11, this.unk3300HHKKEDDIGLA_);
            }
            if (this.unk3300LMNLHHPMAMN_ != 0) {
                output.writeUInt32(12, this.unk3300LMNLHHPMAMN_);
            }
            if (getUnk3300AIAMBBODLBOList().size() > 0) {
                output.writeUInt32NoTag(106);
                output.writeUInt32NoTag(this.unk3300AIAMBBODLBOMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.unk3300AIAMBBODLBO_.size(); i4++) {
                output.writeUInt32NoTag(this.unk3300AIAMBBODLBO_.getInt(i4));
            }
            if (this.dealInfo_ != null) {
                output.writeMessage(14, getDealInfo());
            }
            if (getUnlockStrategyListList().size() > 0) {
                output.writeUInt32NoTag(122);
                output.writeUInt32NoTag(this.unlockStrategyListMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.unlockStrategyList_.size(); i5++) {
                output.writeUInt32NoTag(this.unlockStrategyList_.getInt(i5));
            }
            if (this.unk3300FOPKAIIAMFM_ != 0) {
                output.writeUInt32(255, this.unk3300FOPKAIIAMFM_);
            }
            if (this.unk3300ACJLANLBCGK_ != 0) {
                output.writeUInt32(458, this.unk3300ACJLANLBCGK_);
            }
            if (this.unk3300ALHLENELIEO_) {
                output.writeBool(UNK3300_ALHLENELIEO_FIELD_NUMBER, this.unk3300ALHLENELIEO_);
            }
            if (this.unk3300NMHHGNPKBEL_) {
                output.writeBool(UNK3300_NMHHGNPKBEL_FIELD_NUMBER, this.unk3300NMHHGNPKBEL_);
            }
            if (this.unk3300NBNOJJBNJPB_) {
                output.writeBool(UNK3300_NBNOJJBNJPB_FIELD_NUMBER, this.unk3300NBNOJJBNJPB_);
            }
            if (getUnk3300COKBOKAOCNJList().size() > 0) {
                output.writeUInt32NoTag(RetcodeOuterClass.Retcode.RET_HOME_IN_COMBAT_VALUE);
                output.writeUInt32NoTag(this.unk3300COKBOKAOCNJMemoizedSerializedSize);
            }
            for (int i6 = 0; i6 < this.unk3300COKBOKAOCNJ_.size(); i6++) {
                output.writeUInt32NoTag(this.unk3300COKBOKAOCNJ_.getInt(i6));
            }
            if (this.helpSkillId_ != 0) {
                output.writeUInt32(HELPSKILLID_FIELD_NUMBER, this.helpSkillId_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.unk3300EDBJLBICEJF_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300EDBJLBICEJF_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getUnk3300EDBJLBICEJFList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk3300EDBJLBICEJFMemoizedSerializedSize = dataSize;
            if (this.storeRound_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.storeRound_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unk3300ABHHACBDCFI_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300ABHHACBDCFI_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getUnk3300ABHHACBDCFIList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300ABHHACBDCFIMemoizedSerializedSize = dataSize2;
            if (this.unk3300PAMKPAOCJJJ_) {
                size3 += CodedOutputStream.computeBoolSize(4, this.unk3300PAMKPAOCJJJ_);
            }
            if (this.unk3300KJDEFIBKBPE_) {
                size3 += CodedOutputStream.computeBoolSize(5, this.unk3300KJDEFIBKBPE_);
            }
            if (this.unk3300NDFHAGHBCFN_) {
                size3 += CodedOutputStream.computeBoolSize(6, this.unk3300NDFHAGHBCFN_);
            }
            for (int i3 = 0; i3 < this.openStoreList_.size(); i3++) {
                size3 += CodedOutputStream.computeMessageSize(7, this.openStoreList_.get(i3));
            }
            if (this.unk3300FJDIMCJEAOB_) {
                size3 += CodedOutputStream.computeBoolSize(8, this.unk3300FJDIMCJEAOB_);
            }
            for (Map.Entry<Integer, Boolean> entry : internalGetBargainInfoMap().getMap().entrySet()) {
                size3 += CodedOutputStream.computeMessageSize(9, BargainInfoMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.unk3300ICJOCDGLFFD_) {
                size3 += CodedOutputStream.computeBoolSize(10, this.unk3300ICJOCDGLFFD_);
            }
            if (this.unk3300HHKKEDDIGLA_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(11, this.unk3300HHKKEDDIGLA_);
            }
            if (this.unk3300LMNLHHPMAMN_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(12, this.unk3300LMNLHHPMAMN_);
            }
            int dataSize3 = 0;
            for (int i4 = 0; i4 < this.unk3300AIAMBBODLBO_.size(); i4++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300AIAMBBODLBO_.getInt(i4));
            }
            int size4 = size3 + dataSize3;
            if (!getUnk3300AIAMBBODLBOList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.unk3300AIAMBBODLBOMemoizedSerializedSize = dataSize3;
            if (this.dealInfo_ != null) {
                size4 += CodedOutputStream.computeMessageSize(14, getDealInfo());
            }
            int dataSize4 = 0;
            for (int i5 = 0; i5 < this.unlockStrategyList_.size(); i5++) {
                dataSize4 += CodedOutputStream.computeUInt32SizeNoTag(this.unlockStrategyList_.getInt(i5));
            }
            int size5 = size4 + dataSize4;
            if (!getUnlockStrategyListList().isEmpty()) {
                size5 = size5 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize4);
            }
            this.unlockStrategyListMemoizedSerializedSize = dataSize4;
            if (this.unk3300FOPKAIIAMFM_ != 0) {
                size5 += CodedOutputStream.computeUInt32Size(255, this.unk3300FOPKAIIAMFM_);
            }
            if (this.unk3300ACJLANLBCGK_ != 0) {
                size5 += CodedOutputStream.computeUInt32Size(458, this.unk3300ACJLANLBCGK_);
            }
            if (this.unk3300ALHLENELIEO_) {
                size5 += CodedOutputStream.computeBoolSize(UNK3300_ALHLENELIEO_FIELD_NUMBER, this.unk3300ALHLENELIEO_);
            }
            if (this.unk3300NMHHGNPKBEL_) {
                size5 += CodedOutputStream.computeBoolSize(UNK3300_NMHHGNPKBEL_FIELD_NUMBER, this.unk3300NMHHGNPKBEL_);
            }
            if (this.unk3300NBNOJJBNJPB_) {
                size5 += CodedOutputStream.computeBoolSize(UNK3300_NBNOJJBNJPB_FIELD_NUMBER, this.unk3300NBNOJJBNJPB_);
            }
            int dataSize5 = 0;
            for (int i6 = 0; i6 < this.unk3300COKBOKAOCNJ_.size(); i6++) {
                dataSize5 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300COKBOKAOCNJ_.getInt(i6));
            }
            int size6 = size5 + dataSize5;
            if (!getUnk3300COKBOKAOCNJList().isEmpty()) {
                size6 = size6 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize5);
            }
            this.unk3300COKBOKAOCNJMemoizedSerializedSize = dataSize5;
            if (this.helpSkillId_ != 0) {
                size6 += CodedOutputStream.computeUInt32Size(HELPSKILLID_FIELD_NUMBER, this.helpSkillId_);
            }
            int size7 = size6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size7;
            return size7;
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
            if (getUnlockStrategyListList().equals(other.getUnlockStrategyListList()) && getStoreRound() == other.getStoreRound() && getUnk3300COKBOKAOCNJList().equals(other.getUnk3300COKBOKAOCNJList()) && internalGetBargainInfoMap().equals(other.internalGetBargainInfoMap()) && getUnk3300ABHHACBDCFIList().equals(other.getUnk3300ABHHACBDCFIList()) && getUnk3300EDBJLBICEJFList().equals(other.getUnk3300EDBJLBICEJFList()) && getUnk3300KJDEFIBKBPE() == other.getUnk3300KJDEFIBKBPE() && getUnk3300NMHHGNPKBEL() == other.getUnk3300NMHHGNPKBEL() && getUnk3300FOPKAIIAMFM() == other.getUnk3300FOPKAIIAMFM() && getUnk3300LMNLHHPMAMN() == other.getUnk3300LMNLHHPMAMN() && getUnk3300ALHLENELIEO() == other.getUnk3300ALHLENELIEO() && getUnk3300PAMKPAOCJJJ() == other.getUnk3300PAMKPAOCJJJ() && getUnk3300ICJOCDGLFFD() == other.getUnk3300ICJOCDGLFFD() && hasDealInfo() == other.hasDealInfo()) {
                return (!hasDealInfo() || getDealInfo().equals(other.getDealInfo())) && getUnk3300NDFHAGHBCFN() == other.getUnk3300NDFHAGHBCFN() && getOpenStoreListList().equals(other.getOpenStoreListList()) && getUnk3300AIAMBBODLBOList().equals(other.getUnk3300AIAMBBODLBOList()) && getHelpSkillId() == other.getHelpSkillId() && getUnk3300FJDIMCJEAOB() == other.getUnk3300FJDIMCJEAOB() && getUnk3300HHKKEDDIGLA() == other.getUnk3300HHKKEDDIGLA() && getUnk3300ACJLANLBCGK() == other.getUnk3300ACJLANLBCGK() && getUnk3300NBNOJJBNJPB() == other.getUnk3300NBNOJJBNJPB() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnlockStrategyListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getUnlockStrategyListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 2)) + getStoreRound();
            if (getUnk3300COKBOKAOCNJCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 1216)) + getUnk3300COKBOKAOCNJList().hashCode();
            }
            if (!internalGetBargainInfoMap().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 9)) + internalGetBargainInfoMap().hashCode();
            }
            if (getUnk3300ABHHACBDCFICount() > 0) {
                hash2 = (53 * ((37 * hash2) + 3)) + getUnk3300ABHHACBDCFIList().hashCode();
            }
            if (getUnk3300EDBJLBICEJFCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 1)) + getUnk3300EDBJLBICEJFList().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 5)) + Internal.hashBoolean(getUnk3300KJDEFIBKBPE()))) + UNK3300_NMHHGNPKBEL_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300NMHHGNPKBEL()))) + 255)) + getUnk3300FOPKAIIAMFM())) + 12)) + getUnk3300LMNLHHPMAMN())) + UNK3300_ALHLENELIEO_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300ALHLENELIEO()))) + 4)) + Internal.hashBoolean(getUnk3300PAMKPAOCJJJ()))) + 10)) + Internal.hashBoolean(getUnk3300ICJOCDGLFFD());
            if (hasDealInfo()) {
                hash3 = (53 * ((37 * hash3) + 14)) + getDealInfo().hashCode();
            }
            int hash4 = (53 * ((37 * hash3) + 6)) + Internal.hashBoolean(getUnk3300NDFHAGHBCFN());
            if (getOpenStoreListCount() > 0) {
                hash4 = (53 * ((37 * hash4) + 7)) + getOpenStoreListList().hashCode();
            }
            if (getUnk3300AIAMBBODLBOCount() > 0) {
                hash4 = (53 * ((37 * hash4) + 13)) + getUnk3300AIAMBBODLBOList().hashCode();
            }
            int hash5 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash4) + HELPSKILLID_FIELD_NUMBER)) + getHelpSkillId())) + 8)) + Internal.hashBoolean(getUnk3300FJDIMCJEAOB()))) + 11)) + getUnk3300HHKKEDDIGLA())) + 458)) + getUnk3300ACJLANLBCGK())) + UNK3300_NBNOJJBNJPB_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300NBNOJJBNJPB()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash5;
            return hash5;
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
            private int storeRound_;
            private MapField<Integer, Boolean> bargainInfoMap_;
            private boolean unk3300KJDEFIBKBPE_;
            private boolean unk3300NMHHGNPKBEL_;
            private int unk3300FOPKAIIAMFM_;
            private int unk3300LMNLHHPMAMN_;
            private boolean unk3300ALHLENELIEO_;
            private boolean unk3300PAMKPAOCJJJ_;
            private boolean unk3300ICJOCDGLFFD_;
            private VintageMarketDealInfoOuterClass.VintageMarketDealInfo dealInfo_;
            private SingleFieldBuilderV3<VintageMarketDealInfoOuterClass.VintageMarketDealInfo, VintageMarketDealInfoOuterClass.VintageMarketDealInfo.Builder, VintageMarketDealInfoOuterClass.VintageMarketDealInfoOrBuilder> dealInfoBuilder_;
            private boolean unk3300NDFHAGHBCFN_;
            private RepeatedFieldBuilderV3<VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo, VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.Builder, VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder> openStoreListBuilder_;
            private int helpSkillId_;
            private boolean unk3300FJDIMCJEAOB_;
            private int unk3300HHKKEDDIGLA_;
            private int unk3300ACJLANLBCGK_;
            private boolean unk3300NBNOJJBNJPB_;
            private Internal.IntList unlockStrategyList_ = VintageMarketInfo.emptyIntList();
            private Internal.IntList unk3300COKBOKAOCNJ_ = VintageMarketInfo.emptyIntList();
            private Internal.IntList unk3300ABHHACBDCFI_ = VintageMarketInfo.emptyIntList();
            private Internal.IntList unk3300EDBJLBICEJF_ = VintageMarketInfo.emptyIntList();
            private List<VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo> openStoreList_ = Collections.emptyList();
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
                this.unlockStrategyList_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.storeRound_ = 0;
                this.unk3300COKBOKAOCNJ_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -3;
                internalGetMutableBargainInfoMap().clear();
                this.unk3300ABHHACBDCFI_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -9;
                this.unk3300EDBJLBICEJF_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -17;
                this.unk3300KJDEFIBKBPE_ = false;
                this.unk3300NMHHGNPKBEL_ = false;
                this.unk3300FOPKAIIAMFM_ = 0;
                this.unk3300LMNLHHPMAMN_ = 0;
                this.unk3300ALHLENELIEO_ = false;
                this.unk3300PAMKPAOCJJJ_ = false;
                this.unk3300ICJOCDGLFFD_ = false;
                if (this.dealInfoBuilder_ == null) {
                    this.dealInfo_ = null;
                } else {
                    this.dealInfo_ = null;
                    this.dealInfoBuilder_ = null;
                }
                this.unk3300NDFHAGHBCFN_ = false;
                if (this.openStoreListBuilder_ == null) {
                    this.openStoreList_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                } else {
                    this.openStoreListBuilder_.clear();
                }
                this.unk3300AIAMBBODLBO_ = VintageMarketInfo.emptyIntList();
                this.bitField0_ &= -65;
                this.helpSkillId_ = 0;
                this.unk3300FJDIMCJEAOB_ = false;
                this.unk3300HHKKEDDIGLA_ = 0;
                this.unk3300ACJLANLBCGK_ = 0;
                this.unk3300NBNOJJBNJPB_ = false;
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
                if ((this.bitField0_ & 1) != 0) {
                    this.unlockStrategyList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unlockStrategyList_ = this.unlockStrategyList_;
                result.storeRound_ = this.storeRound_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unk3300COKBOKAOCNJ_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk3300COKBOKAOCNJ_ = this.unk3300COKBOKAOCNJ_;
                result.bargainInfoMap_ = internalGetBargainInfoMap();
                result.bargainInfoMap_.makeImmutable();
                if ((this.bitField0_ & 8) != 0) {
                    this.unk3300ABHHACBDCFI_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                result.unk3300ABHHACBDCFI_ = this.unk3300ABHHACBDCFI_;
                if ((this.bitField0_ & 16) != 0) {
                    this.unk3300EDBJLBICEJF_.makeImmutable();
                    this.bitField0_ &= -17;
                }
                result.unk3300EDBJLBICEJF_ = this.unk3300EDBJLBICEJF_;
                result.unk3300KJDEFIBKBPE_ = this.unk3300KJDEFIBKBPE_;
                result.unk3300NMHHGNPKBEL_ = this.unk3300NMHHGNPKBEL_;
                result.unk3300FOPKAIIAMFM_ = this.unk3300FOPKAIIAMFM_;
                result.unk3300LMNLHHPMAMN_ = this.unk3300LMNLHHPMAMN_;
                result.unk3300ALHLENELIEO_ = this.unk3300ALHLENELIEO_;
                result.unk3300PAMKPAOCJJJ_ = this.unk3300PAMKPAOCJJJ_;
                result.unk3300ICJOCDGLFFD_ = this.unk3300ICJOCDGLFFD_;
                if (this.dealInfoBuilder_ == null) {
                    result.dealInfo_ = this.dealInfo_;
                } else {
                    result.dealInfo_ = this.dealInfoBuilder_.build();
                }
                result.unk3300NDFHAGHBCFN_ = this.unk3300NDFHAGHBCFN_;
                if (this.openStoreListBuilder_ == null) {
                    if ((this.bitField0_ & 32) != 0) {
                        this.openStoreList_ = Collections.unmodifiableList(this.openStoreList_);
                        this.bitField0_ &= -33;
                    }
                    result.openStoreList_ = this.openStoreList_;
                } else {
                    result.openStoreList_ = this.openStoreListBuilder_.build();
                }
                if ((this.bitField0_ & 64) != 0) {
                    this.unk3300AIAMBBODLBO_.makeImmutable();
                    this.bitField0_ &= -65;
                }
                result.unk3300AIAMBBODLBO_ = this.unk3300AIAMBBODLBO_;
                result.helpSkillId_ = this.helpSkillId_;
                result.unk3300FJDIMCJEAOB_ = this.unk3300FJDIMCJEAOB_;
                result.unk3300HHKKEDDIGLA_ = this.unk3300HHKKEDDIGLA_;
                result.unk3300ACJLANLBCGK_ = this.unk3300ACJLANLBCGK_;
                result.unk3300NBNOJJBNJPB_ = this.unk3300NBNOJJBNJPB_;
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
                if (!other.unlockStrategyList_.isEmpty()) {
                    if (this.unlockStrategyList_.isEmpty()) {
                        this.unlockStrategyList_ = other.unlockStrategyList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnlockStrategyListIsMutable();
                        this.unlockStrategyList_.addAll(other.unlockStrategyList_);
                    }
                    onChanged();
                }
                if (other.getStoreRound() != 0) {
                    setStoreRound(other.getStoreRound());
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
                internalGetMutableBargainInfoMap().mergeFrom(other.internalGetBargainInfoMap());
                if (!other.unk3300ABHHACBDCFI_.isEmpty()) {
                    if (this.unk3300ABHHACBDCFI_.isEmpty()) {
                        this.unk3300ABHHACBDCFI_ = other.unk3300ABHHACBDCFI_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureUnk3300ABHHACBDCFIIsMutable();
                        this.unk3300ABHHACBDCFI_.addAll(other.unk3300ABHHACBDCFI_);
                    }
                    onChanged();
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
                if (other.getUnk3300KJDEFIBKBPE()) {
                    setUnk3300KJDEFIBKBPE(other.getUnk3300KJDEFIBKBPE());
                }
                if (other.getUnk3300NMHHGNPKBEL()) {
                    setUnk3300NMHHGNPKBEL(other.getUnk3300NMHHGNPKBEL());
                }
                if (other.getUnk3300FOPKAIIAMFM() != 0) {
                    setUnk3300FOPKAIIAMFM(other.getUnk3300FOPKAIIAMFM());
                }
                if (other.getUnk3300LMNLHHPMAMN() != 0) {
                    setUnk3300LMNLHHPMAMN(other.getUnk3300LMNLHHPMAMN());
                }
                if (other.getUnk3300ALHLENELIEO()) {
                    setUnk3300ALHLENELIEO(other.getUnk3300ALHLENELIEO());
                }
                if (other.getUnk3300PAMKPAOCJJJ()) {
                    setUnk3300PAMKPAOCJJJ(other.getUnk3300PAMKPAOCJJJ());
                }
                if (other.getUnk3300ICJOCDGLFFD()) {
                    setUnk3300ICJOCDGLFFD(other.getUnk3300ICJOCDGLFFD());
                }
                if (other.hasDealInfo()) {
                    mergeDealInfo(other.getDealInfo());
                }
                if (other.getUnk3300NDFHAGHBCFN()) {
                    setUnk3300NDFHAGHBCFN(other.getUnk3300NDFHAGHBCFN());
                }
                if (this.openStoreListBuilder_ == null) {
                    if (!other.openStoreList_.isEmpty()) {
                        if (this.openStoreList_.isEmpty()) {
                            this.openStoreList_ = other.openStoreList_;
                            this.bitField0_ &= -33;
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
                        this.bitField0_ &= -33;
                        this.openStoreListBuilder_ = VintageMarketInfo.alwaysUseFieldBuilders ? getOpenStoreListFieldBuilder() : null;
                    } else {
                        this.openStoreListBuilder_.addAllMessages(other.openStoreList_);
                    }
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
                if (other.getHelpSkillId() != 0) {
                    setHelpSkillId(other.getHelpSkillId());
                }
                if (other.getUnk3300FJDIMCJEAOB()) {
                    setUnk3300FJDIMCJEAOB(other.getUnk3300FJDIMCJEAOB());
                }
                if (other.getUnk3300HHKKEDDIGLA() != 0) {
                    setUnk3300HHKKEDDIGLA(other.getUnk3300HHKKEDDIGLA());
                }
                if (other.getUnk3300ACJLANLBCGK() != 0) {
                    setUnk3300ACJLANLBCGK(other.getUnk3300ACJLANLBCGK());
                }
                if (other.getUnk3300NBNOJJBNJPB()) {
                    setUnk3300NBNOJJBNJPB(other.getUnk3300NBNOJJBNJPB());
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

            private void ensureUnlockStrategyListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unlockStrategyList_ = VintageMarketInfo.mutableCopy(this.unlockStrategyList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public List<Integer> getUnlockStrategyListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unlockStrategyList_) : this.unlockStrategyList_;
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
                this.bitField0_ &= -2;
                onChanged();
                return this;
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

            private void ensureUnk3300ABHHACBDCFIIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.unk3300ABHHACBDCFI_ = VintageMarketInfo.mutableCopy(this.unk3300ABHHACBDCFI_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketInfoOuterClass.VintageMarketInfoOrBuilder
            public List<Integer> getUnk3300ABHHACBDCFIList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.unk3300ABHHACBDCFI_) : this.unk3300ABHHACBDCFI_;
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
                this.bitField0_ &= -9;
                onChanged();
                return this;
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

            private void ensureOpenStoreListIsMutable() {
                if ((this.bitField0_ & 32) == 0) {
                    this.openStoreList_ = new ArrayList(this.openStoreList_);
                    this.bitField0_ |= 32;
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
                    this.bitField0_ &= -33;
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
                    this.openStoreListBuilder_ = new RepeatedFieldBuilderV3<>(this.openStoreList_, (this.bitField0_ & 32) != 0, getParentForChildren(), isClean());
                    this.openStoreList_ = null;
                }
                return this.openStoreListBuilder_;
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
