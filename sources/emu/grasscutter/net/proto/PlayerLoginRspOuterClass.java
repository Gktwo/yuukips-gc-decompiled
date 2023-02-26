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
import emu.grasscutter.net.proto.BlockInfoOuterClass;
import emu.grasscutter.net.proto.FeatureBlockInfoOuterClass;
import emu.grasscutter.net.proto.ResVersionConfigOuterClass;
import emu.grasscutter.net.proto.ShortAbilityHashPairOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLoginRspOuterClass.class */
public final class PlayerLoginRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014PlayerLoginRsp.proto\u001a\u0016ResVersionConfig.proto\u001a\u0016FeatureBlockInfo.proto\u001a\u000fBlockInfo.proto\u001a\u001aShortAbilityHashPair.proto\"\t\n\u000ePlayerLoginRsp\u0012\u0010\n\u0007isAudit\u0018É\u0001 \u0001(\b\u0012\u001b\n\u0013Unk3300_IIHDKKNJPGD\u0018\u0006 \u0001(\b\u0012\u0012\n\tclientMd5\u0018®\b \u0001(\t\u0012\u0019\n\u0011playerDataVersion\u0018\t \u0001(\r\u0012\u001c\n\u0013clientVersionSuffix\u0018ð\u0004 \u0001(\t\u0012\u0011\n\tloginRand\u0018\b \u0001(\u0004\u00120\n\u0014featureBlockInfoList\u0018ó\u000f \u0003(\u000b2\u0011.FeatureBlockInfo\u0012\u0018\n\u0010isUseAbilityHash\u0018\u000f \u0001(\b\u0012\u0011\n\bisScOpen\u0018¼\u000e \u0001(\b\u0012\u0012\n\nplayerData\u0018\u000e \u0001(\f\u0012\u0016\n\rtotalTickTime\u0018é\r \u0001(\u0001\u00128\n\fblockInfoMap\u0018Ö\u0007 \u0003(\u000b2!.PlayerLoginRsp.BlockInfoMapEntry\u0012\u0014\n\u000bcountryCode\u0018î\u0001 \u0001(\t\u0012,\n\u0010resVersionConfig\u0018\u0006 \u0001(\u000b2\u0011.ResVersionConfig\u0012 \n\u0018clientSilenceDataVersion\u0018\u0002 \u0001(\r\u0012#\n\u001aclientSilenceVersionSuffix\u0018§\u0007 \u0001(\t\u0012\u001c\n\u0013Unk3300_EJKCNNDFAAI\u0018æ\t \u0001(\b\u0012\u0019\n\u0010clientSilenceMd5\u0018Ó\u0007 \u0001(\t\u0012\u001a\n\u0011isDataNeedRelogin\u0018ý\u0007 \u0001(\b\u00123\n\u0013shortAbilityHashMap\u0018¯\t \u0003(\u000b2\u0015.ShortAbilityHashPair\u0012\u0011\n\ttargetUid\u0018\u0003 \u0001(\r\u0012\u000f\n\u0007gameBiz\u0018\u0004 \u0001(\t\u0012\u0013\n\nisTransfer\u0018¼\u0007 \u0001(\b\u0012\u000f\n\u0007retcode\u0018\u0001 \u0001(\u0005\u0012;\n\u000eabilityHashMap\u0018\u0005 \u0003(\u000b2#.PlayerLoginRsp.AbilityHashMapEntry\u0012\u001c\n\u0013Unk3300_IADLIIMGDMC\u0018\u000b \u0001(\b\u0012\u000f\n\u0006scInfo\u0018\u0001 \u0001(\f\u0012\u001b\n\u0013Unk3300_HGFNECIJDLN\u0018\n \u0001(\b\u0012\u0019\n\u0011clientDataVersion\u0018\u0007 \u0001(\r\u0012\u001b\n\u0012targetHomeOwnerUid\u0018\u0006 \u0001(\r\u0012\u0014\n\u000bregisterCps\u0018¨\u0004 \u0001(\t\u0012\u0011\n\bbirthday\u0018£\u0001 \u0001(\t\u00120\n\u0014nextResVersionConfig\u0018³\n \u0001(\u000b2\u0011.ResVersionConfig\u0012\u0017\n\u000fabilityHashCode\u0018\r \u0001(\u0005\u0012\u0018\n\u000fnextResourceUrl\u0018Ç\b \u0001(\t\u001a?\n\u0011BlockInfoMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u0019\n\u0005value\u0018\u0002 \u0001(\u000b2\n.BlockInfo:\u00028\u0001\u001a5\n\u0013AbilityHashMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\u0005:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ResVersionConfigOuterClass.getDescriptor(), FeatureBlockInfoOuterClass.getDescriptor(), BlockInfoOuterClass.getDescriptor(), ShortAbilityHashPairOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerLoginRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerLoginRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerLoginRsp_descriptor, new String[]{"IsAudit", "Unk3300IIHDKKNJPGD", "ClientMd5", "PlayerDataVersion", "ClientVersionSuffix", "LoginRand", "FeatureBlockInfoList", "IsUseAbilityHash", "IsScOpen", "PlayerData", "TotalTickTime", "BlockInfoMap", "CountryCode", "ResVersionConfig", "ClientSilenceDataVersion", "ClientSilenceVersionSuffix", "Unk3300EJKCNNDFAAI", "ClientSilenceMd5", "IsDataNeedRelogin", "ShortAbilityHashMap", "TargetUid", "GameBiz", "IsTransfer", "Retcode", "AbilityHashMap", "Unk3300IADLIIMGDMC", "ScInfo", "Unk3300HGFNECIJDLN", "ClientDataVersion", "TargetHomeOwnerUid", "RegisterCps", "Birthday", "NextResVersionConfig", "AbilityHashCode", "NextResourceUrl"});
    private static final Descriptors.Descriptor internal_static_PlayerLoginRsp_BlockInfoMapEntry_descriptor = internal_static_PlayerLoginRsp_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_PlayerLoginRsp_BlockInfoMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f808x20cffe04 = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerLoginRsp_BlockInfoMapEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_PlayerLoginRsp_AbilityHashMapEntry_descriptor = internal_static_PlayerLoginRsp_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_PlayerLoginRsp_AbilityHashMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f809xc9472327 = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerLoginRsp_AbilityHashMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLoginRspOuterClass$PlayerLoginRspOrBuilder.class */
    public interface PlayerLoginRspOrBuilder extends MessageOrBuilder {
        boolean getIsAudit();

        boolean getUnk3300IIHDKKNJPGD();

        String getClientMd5();

        ByteString getClientMd5Bytes();

        int getPlayerDataVersion();

        String getClientVersionSuffix();

        ByteString getClientVersionSuffixBytes();

        long getLoginRand();

        List<FeatureBlockInfoOuterClass.FeatureBlockInfo> getFeatureBlockInfoListList();

        FeatureBlockInfoOuterClass.FeatureBlockInfo getFeatureBlockInfoList(int i);

        int getFeatureBlockInfoListCount();

        List<? extends FeatureBlockInfoOuterClass.FeatureBlockInfoOrBuilder> getFeatureBlockInfoListOrBuilderList();

        FeatureBlockInfoOuterClass.FeatureBlockInfoOrBuilder getFeatureBlockInfoListOrBuilder(int i);

        boolean getIsUseAbilityHash();

        boolean getIsScOpen();

        ByteString getPlayerData();

        double getTotalTickTime();

        int getBlockInfoMapCount();

        boolean containsBlockInfoMap(int i);

        @Deprecated
        Map<Integer, BlockInfoOuterClass.BlockInfo> getBlockInfoMap();

        Map<Integer, BlockInfoOuterClass.BlockInfo> getBlockInfoMapMap();

        BlockInfoOuterClass.BlockInfo getBlockInfoMapOrDefault(int i, BlockInfoOuterClass.BlockInfo blockInfo);

        BlockInfoOuterClass.BlockInfo getBlockInfoMapOrThrow(int i);

        String getCountryCode();

        ByteString getCountryCodeBytes();

        boolean hasResVersionConfig();

        ResVersionConfigOuterClass.ResVersionConfig getResVersionConfig();

        ResVersionConfigOuterClass.ResVersionConfigOrBuilder getResVersionConfigOrBuilder();

        int getClientSilenceDataVersion();

        String getClientSilenceVersionSuffix();

        ByteString getClientSilenceVersionSuffixBytes();

        boolean getUnk3300EJKCNNDFAAI();

        String getClientSilenceMd5();

        ByteString getClientSilenceMd5Bytes();

        boolean getIsDataNeedRelogin();

        List<ShortAbilityHashPairOuterClass.ShortAbilityHashPair> getShortAbilityHashMapList();

        ShortAbilityHashPairOuterClass.ShortAbilityHashPair getShortAbilityHashMap(int i);

        int getShortAbilityHashMapCount();

        List<? extends ShortAbilityHashPairOuterClass.ShortAbilityHashPairOrBuilder> getShortAbilityHashMapOrBuilderList();

        ShortAbilityHashPairOuterClass.ShortAbilityHashPairOrBuilder getShortAbilityHashMapOrBuilder(int i);

        int getTargetUid();

        String getGameBiz();

        ByteString getGameBizBytes();

        boolean getIsTransfer();

        int getRetcode();

        int getAbilityHashMapCount();

        boolean containsAbilityHashMap(String str);

        @Deprecated
        Map<String, Integer> getAbilityHashMap();

        Map<String, Integer> getAbilityHashMapMap();

        int getAbilityHashMapOrDefault(String str, int i);

        int getAbilityHashMapOrThrow(String str);

        boolean getUnk3300IADLIIMGDMC();

        ByteString getScInfo();

        boolean getUnk3300HGFNECIJDLN();

        int getClientDataVersion();

        int getTargetHomeOwnerUid();

        String getRegisterCps();

        ByteString getRegisterCpsBytes();

        String getBirthday();

        ByteString getBirthdayBytes();

        boolean hasNextResVersionConfig();

        ResVersionConfigOuterClass.ResVersionConfig getNextResVersionConfig();

        ResVersionConfigOuterClass.ResVersionConfigOrBuilder getNextResVersionConfigOrBuilder();

        int getAbilityHashCode();

        String getNextResourceUrl();

        ByteString getNextResourceUrlBytes();
    }

    private PlayerLoginRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLoginRspOuterClass$PlayerLoginRsp.class */
    public static final class PlayerLoginRsp extends GeneratedMessageV3 implements PlayerLoginRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISAUDIT_FIELD_NUMBER = 201;
        private boolean isAudit_;
        public static final int UNK3300_IIHDKKNJPGD_FIELD_NUMBER = 6;
        private boolean unk3300IIHDKKNJPGD_;
        public static final int CLIENTMD5_FIELD_NUMBER = 1070;
        private volatile Object clientMd5_;
        public static final int PLAYERDATAVERSION_FIELD_NUMBER = 9;
        private int playerDataVersion_;
        public static final int CLIENTVERSIONSUFFIX_FIELD_NUMBER = 624;
        private volatile Object clientVersionSuffix_;
        public static final int LOGINRAND_FIELD_NUMBER = 8;
        private long loginRand_;
        public static final int FEATUREBLOCKINFOLIST_FIELD_NUMBER = 2035;
        private List<FeatureBlockInfoOuterClass.FeatureBlockInfo> featureBlockInfoList_;
        public static final int ISUSEABILITYHASH_FIELD_NUMBER = 15;
        private boolean isUseAbilityHash_;
        public static final int ISSCOPEN_FIELD_NUMBER = 1852;
        private boolean isScOpen_;
        public static final int PLAYERDATA_FIELD_NUMBER = 14;
        private ByteString playerData_;
        public static final int TOTALTICKTIME_FIELD_NUMBER = 1769;
        private double totalTickTime_;
        public static final int BLOCKINFOMAP_FIELD_NUMBER = 982;
        private MapField<Integer, BlockInfoOuterClass.BlockInfo> blockInfoMap_;
        public static final int COUNTRYCODE_FIELD_NUMBER = 238;
        private volatile Object countryCode_;
        public static final int RESVERSIONCONFIG_FIELD_NUMBER = 777;
        private ResVersionConfigOuterClass.ResVersionConfig resVersionConfig_;
        public static final int CLIENTSILENCEDATAVERSION_FIELD_NUMBER = 2;
        private int clientSilenceDataVersion_;
        public static final int CLIENTSILENCEVERSIONSUFFIX_FIELD_NUMBER = 935;
        private volatile Object clientSilenceVersionSuffix_;
        public static final int UNK3300_EJKCNNDFAAI_FIELD_NUMBER = 1254;
        private boolean unk3300EJKCNNDFAAI_;
        public static final int CLIENTSILENCEMD5_FIELD_NUMBER = 979;
        private volatile Object clientSilenceMd5_;
        public static final int ISDATANEEDRELOGIN_FIELD_NUMBER = 1021;
        private boolean isDataNeedRelogin_;
        public static final int SHORTABILITYHASHMAP_FIELD_NUMBER = 1199;
        private List<ShortAbilityHashPairOuterClass.ShortAbilityHashPair> shortAbilityHashMap_;
        public static final int TARGETUID_FIELD_NUMBER = 3;
        private int targetUid_;
        public static final int GAMEBIZ_FIELD_NUMBER = 4;
        private volatile Object gameBiz_;
        public static final int ISTRANSFER_FIELD_NUMBER = 956;
        private boolean isTransfer_;
        public static final int RETCODE_FIELD_NUMBER = 1;
        private int retcode_;
        public static final int ABILITYHASHMAP_FIELD_NUMBER = 5;
        private MapField<String, Integer> abilityHashMap_;
        public static final int UNK3300_IADLIIMGDMC_FIELD_NUMBER = 1435;
        private boolean unk3300IADLIIMGDMC_;
        public static final int SCINFO_FIELD_NUMBER = 151;
        private ByteString scInfo_;
        public static final int UNK3300_HGFNECIJDLN_FIELD_NUMBER = 10;
        private boolean unk3300HGFNECIJDLN_;
        public static final int CLIENTDATAVERSION_FIELD_NUMBER = 7;
        private int clientDataVersion_;
        public static final int TARGETHOMEOWNERUID_FIELD_NUMBER = 787;
        private int targetHomeOwnerUid_;
        public static final int REGISTERCPS_FIELD_NUMBER = 552;
        private volatile Object registerCps_;
        public static final int BIRTHDAY_FIELD_NUMBER = 163;
        private volatile Object birthday_;
        public static final int NEXTRESVERSIONCONFIG_FIELD_NUMBER = 1331;
        private ResVersionConfigOuterClass.ResVersionConfig nextResVersionConfig_;
        public static final int ABILITYHASHCODE_FIELD_NUMBER = 13;
        private int abilityHashCode_;
        public static final int NEXTRESOURCEURL_FIELD_NUMBER = 1095;
        private volatile Object nextResourceUrl_;
        private byte memoizedIsInitialized;
        private static final PlayerLoginRsp DEFAULT_INSTANCE = new PlayerLoginRsp();
        private static final Parser<PlayerLoginRsp> PARSER = new AbstractParser<PlayerLoginRsp>() { // from class: emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRsp.1
            @Override // com.google.protobuf.Parser
            public PlayerLoginRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerLoginRsp(input, extensionRegistry);
            }
        };

        /*  JADX ERROR: Dependency scan failed at insn: 0x002B: INVOKE_CUSTOM r0
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRsp.internalGetMapField(int):com.google.protobuf.MapField
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
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
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
                    case 5: goto L_0x0021;
                    case 982: goto L_0x001c;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetBlockInfoMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetAbilityHashMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRsp.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private PlayerLoginRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerLoginRsp() {
            this.memoizedIsInitialized = -1;
            this.clientMd5_ = "";
            this.clientVersionSuffix_ = "";
            this.featureBlockInfoList_ = Collections.emptyList();
            this.playerData_ = ByteString.EMPTY;
            this.countryCode_ = "";
            this.clientSilenceVersionSuffix_ = "";
            this.clientSilenceMd5_ = "";
            this.shortAbilityHashMap_ = Collections.emptyList();
            this.gameBiz_ = "";
            this.scInfo_ = ByteString.EMPTY;
            this.registerCps_ = "";
            this.birthday_ = "";
            this.nextResourceUrl_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerLoginRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:142:0x0427 */
        private PlayerLoginRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.retcode_ = input.readInt32();
                                break;
                            case 16:
                                this.clientSilenceDataVersion_ = input.readUInt32();
                                break;
                            case 24:
                                this.targetUid_ = input.readUInt32();
                                break;
                            case 34:
                                this.gameBiz_ = input.readStringRequireUtf8();
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.abilityHashMap_ = MapField.newMapField(AbilityHashMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                MapEntry<String, Integer> abilityHashMap__ = (MapEntry) input.readMessage(AbilityHashMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.abilityHashMap_.getMutableMap().put(abilityHashMap__.getKey(), abilityHashMap__.getValue());
                                break;
                            case 48:
                                this.unk3300IIHDKKNJPGD_ = input.readBool();
                                break;
                            case 56:
                                this.clientDataVersion_ = input.readUInt32();
                                break;
                            case 64:
                                this.loginRand_ = input.readUInt64();
                                break;
                            case 72:
                                this.playerDataVersion_ = input.readUInt32();
                                break;
                            case 80:
                                this.unk3300HGFNECIJDLN_ = input.readBool();
                                break;
                            case 104:
                                this.abilityHashCode_ = input.readInt32();
                                break;
                            case 114:
                                this.playerData_ = input.readBytes();
                                break;
                            case 120:
                                this.isUseAbilityHash_ = input.readBool();
                                break;
                            case RET_MP_PLAYER_DISCONNECTED_VALUE:
                                this.scInfo_ = input.readBytes();
                                break;
                            case RET_MAIL_SENDER_LEN_EXCEED_VALUE:
                                this.birthday_ = input.readStringRequireUtf8();
                                break;
                            case PacketOpcodes.FocusAvatarReq:
                                this.isAudit_ = input.readBool();
                                break;
                            case PacketOpcodes.InvestigationReadQuestDailyNotify:
                                this.countryCode_ = input.readStringRequireUtf8();
                                break;
                            case 4418:
                                this.registerCps_ = input.readStringRequireUtf8();
                                break;
                            case 4994:
                                this.clientVersionSuffix_ = input.readStringRequireUtf8();
                                break;
                            case PacketOpcodes.LikeCustomDungeonRsp:
                                ResVersionConfigOuterClass.ResVersionConfig.Builder subBuilder = this.resVersionConfig_ != null ? this.resVersionConfig_.toBuilder() : null;
                                this.resVersionConfig_ = (ResVersionConfigOuterClass.ResVersionConfig) input.readMessage(ResVersionConfigOuterClass.ResVersionConfig.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.resVersionConfig_);
                                    this.resVersionConfig_ = subBuilder.buildPartial();
                                    break;
                                }
                            case PacketOpcodes.PlayerDeathZoneNotify:
                                this.targetHomeOwnerUid_ = input.readUInt32();
                                break;
                            case 7482:
                                this.clientSilenceVersionSuffix_ = input.readStringRequireUtf8();
                                break;
                            case 7648:
                                this.isTransfer_ = input.readBool();
                                break;
                            case 7834:
                                this.clientSilenceMd5_ = input.readStringRequireUtf8();
                                break;
                            case 7858:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.blockInfoMap_ = MapField.newMapField(BlockInfoMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, BlockInfoOuterClass.BlockInfo> blockInfoMap__ = (MapEntry) input.readMessage(BlockInfoMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.blockInfoMap_.getMutableMap().put(blockInfoMap__.getKey(), blockInfoMap__.getValue());
                                break;
                            case PacketOpcodes.MichiaeMatsuriRemoveChallengeMarkNotify:
                                this.isDataNeedRelogin_ = input.readBool();
                                break;
                            case 8562:
                                this.clientMd5_ = input.readStringRequireUtf8();
                                break;
                            case PacketOpcodes.IrodoriFillPoetryRsp:
                                this.nextResourceUrl_ = input.readStringRequireUtf8();
                                break;
                            case 9594:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.shortAbilityHashMap_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.shortAbilityHashMap_.add((ShortAbilityHashPairOuterClass.ShortAbilityHashPair) input.readMessage(ShortAbilityHashPairOuterClass.ShortAbilityHashPair.parser(), extensionRegistry));
                                break;
                            case RET_ROGUELIKE_COIN_B_NOT_ENOUGH_VALUE:
                                this.unk3300EJKCNNDFAAI_ = input.readBool();
                                break;
                            case 10650:
                                ResVersionConfigOuterClass.ResVersionConfig.Builder subBuilder2 = this.nextResVersionConfig_ != null ? this.nextResVersionConfig_.toBuilder() : null;
                                this.nextResVersionConfig_ = (ResVersionConfigOuterClass.ResVersionConfig) input.readMessage(ResVersionConfigOuterClass.ResVersionConfig.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.nextResVersionConfig_);
                                    this.nextResVersionConfig_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 11480:
                                this.unk3300IADLIIMGDMC_ = input.readBool();
                                break;
                            case 14153:
                                this.totalTickTime_ = input.readDouble();
                                break;
                            case 14816:
                                this.isScOpen_ = input.readBool();
                                break;
                            case 16282:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.featureBlockInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.featureBlockInfoList_.add((FeatureBlockInfoOuterClass.FeatureBlockInfo) input.readMessage(FeatureBlockInfoOuterClass.FeatureBlockInfo.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 4) != 0) {
                    this.shortAbilityHashMap_ = Collections.unmodifiableList(this.shortAbilityHashMap_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.featureBlockInfoList_ = Collections.unmodifiableList(this.featureBlockInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerLoginRspOuterClass.internal_static_PlayerLoginRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerLoginRspOuterClass.internal_static_PlayerLoginRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerLoginRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public boolean getIsAudit() {
            return this.isAudit_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public boolean getUnk3300IIHDKKNJPGD() {
            return this.unk3300IIHDKKNJPGD_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public String getClientMd5() {
            Object ref = this.clientMd5_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientMd5_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ByteString getClientMd5Bytes() {
            Object ref = this.clientMd5_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientMd5_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public int getPlayerDataVersion() {
            return this.playerDataVersion_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public String getClientVersionSuffix() {
            Object ref = this.clientVersionSuffix_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientVersionSuffix_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ByteString getClientVersionSuffixBytes() {
            Object ref = this.clientVersionSuffix_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientVersionSuffix_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public long getLoginRand() {
            return this.loginRand_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public List<FeatureBlockInfoOuterClass.FeatureBlockInfo> getFeatureBlockInfoListList() {
            return this.featureBlockInfoList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public List<? extends FeatureBlockInfoOuterClass.FeatureBlockInfoOrBuilder> getFeatureBlockInfoListOrBuilderList() {
            return this.featureBlockInfoList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public int getFeatureBlockInfoListCount() {
            return this.featureBlockInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public FeatureBlockInfoOuterClass.FeatureBlockInfo getFeatureBlockInfoList(int index) {
            return this.featureBlockInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public FeatureBlockInfoOuterClass.FeatureBlockInfoOrBuilder getFeatureBlockInfoListOrBuilder(int index) {
            return this.featureBlockInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public boolean getIsUseAbilityHash() {
            return this.isUseAbilityHash_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public boolean getIsScOpen() {
            return this.isScOpen_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ByteString getPlayerData() {
            return this.playerData_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public double getTotalTickTime() {
            return this.totalTickTime_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLoginRspOuterClass$PlayerLoginRsp$BlockInfoMapDefaultEntryHolder.class */
        public static final class BlockInfoMapDefaultEntryHolder {
            static final MapEntry<Integer, BlockInfoOuterClass.BlockInfo> defaultEntry = MapEntry.newDefaultInstance(PlayerLoginRspOuterClass.internal_static_PlayerLoginRsp_BlockInfoMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, BlockInfoOuterClass.BlockInfo.getDefaultInstance());

            private BlockInfoMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, BlockInfoOuterClass.BlockInfo> internalGetBlockInfoMap() {
            if (this.blockInfoMap_ == null) {
                return MapField.emptyMapField(BlockInfoMapDefaultEntryHolder.defaultEntry);
            }
            return this.blockInfoMap_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public int getBlockInfoMapCount() {
            return internalGetBlockInfoMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public boolean containsBlockInfoMap(int key) {
            return internalGetBlockInfoMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        @Deprecated
        public Map<Integer, BlockInfoOuterClass.BlockInfo> getBlockInfoMap() {
            return getBlockInfoMapMap();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public Map<Integer, BlockInfoOuterClass.BlockInfo> getBlockInfoMapMap() {
            return internalGetBlockInfoMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public BlockInfoOuterClass.BlockInfo getBlockInfoMapOrDefault(int key, BlockInfoOuterClass.BlockInfo defaultValue) {
            Map<Integer, BlockInfoOuterClass.BlockInfo> map = internalGetBlockInfoMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public BlockInfoOuterClass.BlockInfo getBlockInfoMapOrThrow(int key) {
            Map<Integer, BlockInfoOuterClass.BlockInfo> map = internalGetBlockInfoMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public String getCountryCode() {
            Object ref = this.countryCode_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.countryCode_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ByteString getCountryCodeBytes() {
            Object ref = this.countryCode_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.countryCode_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public boolean hasResVersionConfig() {
            return this.resVersionConfig_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ResVersionConfigOuterClass.ResVersionConfig getResVersionConfig() {
            return this.resVersionConfig_ == null ? ResVersionConfigOuterClass.ResVersionConfig.getDefaultInstance() : this.resVersionConfig_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ResVersionConfigOuterClass.ResVersionConfigOrBuilder getResVersionConfigOrBuilder() {
            return getResVersionConfig();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public int getClientSilenceDataVersion() {
            return this.clientSilenceDataVersion_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public String getClientSilenceVersionSuffix() {
            Object ref = this.clientSilenceVersionSuffix_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientSilenceVersionSuffix_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ByteString getClientSilenceVersionSuffixBytes() {
            Object ref = this.clientSilenceVersionSuffix_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientSilenceVersionSuffix_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public boolean getUnk3300EJKCNNDFAAI() {
            return this.unk3300EJKCNNDFAAI_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public String getClientSilenceMd5() {
            Object ref = this.clientSilenceMd5_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientSilenceMd5_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ByteString getClientSilenceMd5Bytes() {
            Object ref = this.clientSilenceMd5_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientSilenceMd5_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public boolean getIsDataNeedRelogin() {
            return this.isDataNeedRelogin_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public List<ShortAbilityHashPairOuterClass.ShortAbilityHashPair> getShortAbilityHashMapList() {
            return this.shortAbilityHashMap_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public List<? extends ShortAbilityHashPairOuterClass.ShortAbilityHashPairOrBuilder> getShortAbilityHashMapOrBuilderList() {
            return this.shortAbilityHashMap_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public int getShortAbilityHashMapCount() {
            return this.shortAbilityHashMap_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ShortAbilityHashPairOuterClass.ShortAbilityHashPair getShortAbilityHashMap(int index) {
            return this.shortAbilityHashMap_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ShortAbilityHashPairOuterClass.ShortAbilityHashPairOrBuilder getShortAbilityHashMapOrBuilder(int index) {
            return this.shortAbilityHashMap_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public int getTargetUid() {
            return this.targetUid_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public String getGameBiz() {
            Object ref = this.gameBiz_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gameBiz_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ByteString getGameBizBytes() {
            Object ref = this.gameBiz_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gameBiz_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public boolean getIsTransfer() {
            return this.isTransfer_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLoginRspOuterClass$PlayerLoginRsp$AbilityHashMapDefaultEntryHolder.class */
        public static final class AbilityHashMapDefaultEntryHolder {
            static final MapEntry<String, Integer> defaultEntry = MapEntry.newDefaultInstance(PlayerLoginRspOuterClass.internal_static_PlayerLoginRsp_AbilityHashMapEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT32, 0);

            private AbilityHashMapDefaultEntryHolder() {
            }
        }

        private MapField<String, Integer> internalGetAbilityHashMap() {
            if (this.abilityHashMap_ == null) {
                return MapField.emptyMapField(AbilityHashMapDefaultEntryHolder.defaultEntry);
            }
            return this.abilityHashMap_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public int getAbilityHashMapCount() {
            return internalGetAbilityHashMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public boolean containsAbilityHashMap(String key) {
            if (key != null) {
                return internalGetAbilityHashMap().getMap().containsKey(key);
            }
            throw new NullPointerException();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        @Deprecated
        public Map<String, Integer> getAbilityHashMap() {
            return getAbilityHashMapMap();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public Map<String, Integer> getAbilityHashMapMap() {
            return internalGetAbilityHashMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public int getAbilityHashMapOrDefault(String key, int defaultValue) {
            if (key == null) {
                throw new NullPointerException();
            }
            Map<String, Integer> map = internalGetAbilityHashMap().getMap();
            return map.containsKey(key) ? map.get(key).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public int getAbilityHashMapOrThrow(String key) {
            if (key == null) {
                throw new NullPointerException();
            }
            Map<String, Integer> map = internalGetAbilityHashMap().getMap();
            if (map.containsKey(key)) {
                return map.get(key).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public boolean getUnk3300IADLIIMGDMC() {
            return this.unk3300IADLIIMGDMC_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ByteString getScInfo() {
            return this.scInfo_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public boolean getUnk3300HGFNECIJDLN() {
            return this.unk3300HGFNECIJDLN_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public int getClientDataVersion() {
            return this.clientDataVersion_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public int getTargetHomeOwnerUid() {
            return this.targetHomeOwnerUid_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public String getRegisterCps() {
            Object ref = this.registerCps_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.registerCps_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ByteString getRegisterCpsBytes() {
            Object ref = this.registerCps_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.registerCps_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public String getBirthday() {
            Object ref = this.birthday_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.birthday_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ByteString getBirthdayBytes() {
            Object ref = this.birthday_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.birthday_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public boolean hasNextResVersionConfig() {
            return this.nextResVersionConfig_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ResVersionConfigOuterClass.ResVersionConfig getNextResVersionConfig() {
            return this.nextResVersionConfig_ == null ? ResVersionConfigOuterClass.ResVersionConfig.getDefaultInstance() : this.nextResVersionConfig_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ResVersionConfigOuterClass.ResVersionConfigOrBuilder getNextResVersionConfigOrBuilder() {
            return getNextResVersionConfig();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public int getAbilityHashCode() {
            return this.abilityHashCode_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public String getNextResourceUrl() {
            Object ref = this.nextResourceUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.nextResourceUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
        public ByteString getNextResourceUrlBytes() {
            Object ref = this.nextResourceUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.nextResourceUrl_ = b;
            return b;
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
            if (this.retcode_ != 0) {
                output.writeInt32(1, this.retcode_);
            }
            if (this.clientSilenceDataVersion_ != 0) {
                output.writeUInt32(2, this.clientSilenceDataVersion_);
            }
            if (this.targetUid_ != 0) {
                output.writeUInt32(3, this.targetUid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gameBiz_)) {
                GeneratedMessageV3.writeString(output, 4, this.gameBiz_);
            }
            GeneratedMessageV3.serializeStringMapTo(output, internalGetAbilityHashMap(), AbilityHashMapDefaultEntryHolder.defaultEntry, 5);
            if (this.unk3300IIHDKKNJPGD_) {
                output.writeBool(6, this.unk3300IIHDKKNJPGD_);
            }
            if (this.clientDataVersion_ != 0) {
                output.writeUInt32(7, this.clientDataVersion_);
            }
            if (this.loginRand_ != 0) {
                output.writeUInt64(8, this.loginRand_);
            }
            if (this.playerDataVersion_ != 0) {
                output.writeUInt32(9, this.playerDataVersion_);
            }
            if (this.unk3300HGFNECIJDLN_) {
                output.writeBool(10, this.unk3300HGFNECIJDLN_);
            }
            if (this.abilityHashCode_ != 0) {
                output.writeInt32(13, this.abilityHashCode_);
            }
            if (!this.playerData_.isEmpty()) {
                output.writeBytes(14, this.playerData_);
            }
            if (this.isUseAbilityHash_) {
                output.writeBool(15, this.isUseAbilityHash_);
            }
            if (!this.scInfo_.isEmpty()) {
                output.writeBytes(151, this.scInfo_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.birthday_)) {
                GeneratedMessageV3.writeString(output, 163, this.birthday_);
            }
            if (this.isAudit_) {
                output.writeBool(201, this.isAudit_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countryCode_)) {
                GeneratedMessageV3.writeString(output, 238, this.countryCode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.registerCps_)) {
                GeneratedMessageV3.writeString(output, 552, this.registerCps_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVersionSuffix_)) {
                GeneratedMessageV3.writeString(output, 624, this.clientVersionSuffix_);
            }
            if (this.resVersionConfig_ != null) {
                output.writeMessage(RESVERSIONCONFIG_FIELD_NUMBER, getResVersionConfig());
            }
            if (this.targetHomeOwnerUid_ != 0) {
                output.writeUInt32(787, this.targetHomeOwnerUid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientSilenceVersionSuffix_)) {
                GeneratedMessageV3.writeString(output, 935, this.clientSilenceVersionSuffix_);
            }
            if (this.isTransfer_) {
                output.writeBool(956, this.isTransfer_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientSilenceMd5_)) {
                GeneratedMessageV3.writeString(output, 979, this.clientSilenceMd5_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetBlockInfoMap(), BlockInfoMapDefaultEntryHolder.defaultEntry, BLOCKINFOMAP_FIELD_NUMBER);
            if (this.isDataNeedRelogin_) {
                output.writeBool(1021, this.isDataNeedRelogin_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientMd5_)) {
                GeneratedMessageV3.writeString(output, 1070, this.clientMd5_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nextResourceUrl_)) {
                GeneratedMessageV3.writeString(output, NEXTRESOURCEURL_FIELD_NUMBER, this.nextResourceUrl_);
            }
            for (int i = 0; i < this.shortAbilityHashMap_.size(); i++) {
                output.writeMessage(SHORTABILITYHASHMAP_FIELD_NUMBER, this.shortAbilityHashMap_.get(i));
            }
            if (this.unk3300EJKCNNDFAAI_) {
                output.writeBool(UNK3300_EJKCNNDFAAI_FIELD_NUMBER, this.unk3300EJKCNNDFAAI_);
            }
            if (this.nextResVersionConfig_ != null) {
                output.writeMessage(1331, getNextResVersionConfig());
            }
            if (this.unk3300IADLIIMGDMC_) {
                output.writeBool(UNK3300_IADLIIMGDMC_FIELD_NUMBER, this.unk3300IADLIIMGDMC_);
            }
            if (this.totalTickTime_ != 0.0d) {
                output.writeDouble(TOTALTICKTIME_FIELD_NUMBER, this.totalTickTime_);
            }
            if (this.isScOpen_) {
                output.writeBool(ISSCOPEN_FIELD_NUMBER, this.isScOpen_);
            }
            for (int i2 = 0; i2 < this.featureBlockInfoList_.size(); i2++) {
                output.writeMessage(FEATUREBLOCKINFOLIST_FIELD_NUMBER, this.featureBlockInfoList_.get(i2));
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.retcode_);
            }
            if (this.clientSilenceDataVersion_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.clientSilenceDataVersion_);
            }
            if (this.targetUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.targetUid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gameBiz_)) {
                size2 += GeneratedMessageV3.computeStringSize(4, this.gameBiz_);
            }
            for (Map.Entry<String, Integer> entry : internalGetAbilityHashMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(5, AbilityHashMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.unk3300IIHDKKNJPGD_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.unk3300IIHDKKNJPGD_);
            }
            if (this.clientDataVersion_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.clientDataVersion_);
            }
            if (this.loginRand_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(8, this.loginRand_);
            }
            if (this.playerDataVersion_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.playerDataVersion_);
            }
            if (this.unk3300HGFNECIJDLN_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.unk3300HGFNECIJDLN_);
            }
            if (this.abilityHashCode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(13, this.abilityHashCode_);
            }
            if (!this.playerData_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(14, this.playerData_);
            }
            if (this.isUseAbilityHash_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.isUseAbilityHash_);
            }
            if (!this.scInfo_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(151, this.scInfo_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.birthday_)) {
                size2 += GeneratedMessageV3.computeStringSize(163, this.birthday_);
            }
            if (this.isAudit_) {
                size2 += CodedOutputStream.computeBoolSize(201, this.isAudit_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countryCode_)) {
                size2 += GeneratedMessageV3.computeStringSize(238, this.countryCode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.registerCps_)) {
                size2 += GeneratedMessageV3.computeStringSize(552, this.registerCps_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVersionSuffix_)) {
                size2 += GeneratedMessageV3.computeStringSize(624, this.clientVersionSuffix_);
            }
            if (this.resVersionConfig_ != null) {
                size2 += CodedOutputStream.computeMessageSize(RESVERSIONCONFIG_FIELD_NUMBER, getResVersionConfig());
            }
            if (this.targetHomeOwnerUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(787, this.targetHomeOwnerUid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientSilenceVersionSuffix_)) {
                size2 += GeneratedMessageV3.computeStringSize(935, this.clientSilenceVersionSuffix_);
            }
            if (this.isTransfer_) {
                size2 += CodedOutputStream.computeBoolSize(956, this.isTransfer_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientSilenceMd5_)) {
                size2 += GeneratedMessageV3.computeStringSize(979, this.clientSilenceMd5_);
            }
            for (Map.Entry<Integer, BlockInfoOuterClass.BlockInfo> entry2 : internalGetBlockInfoMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(BLOCKINFOMAP_FIELD_NUMBER, BlockInfoMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (this.isDataNeedRelogin_) {
                size2 += CodedOutputStream.computeBoolSize(1021, this.isDataNeedRelogin_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientMd5_)) {
                size2 += GeneratedMessageV3.computeStringSize(1070, this.clientMd5_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nextResourceUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(NEXTRESOURCEURL_FIELD_NUMBER, this.nextResourceUrl_);
            }
            for (int i = 0; i < this.shortAbilityHashMap_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(SHORTABILITYHASHMAP_FIELD_NUMBER, this.shortAbilityHashMap_.get(i));
            }
            if (this.unk3300EJKCNNDFAAI_) {
                size2 += CodedOutputStream.computeBoolSize(UNK3300_EJKCNNDFAAI_FIELD_NUMBER, this.unk3300EJKCNNDFAAI_);
            }
            if (this.nextResVersionConfig_ != null) {
                size2 += CodedOutputStream.computeMessageSize(1331, getNextResVersionConfig());
            }
            if (this.unk3300IADLIIMGDMC_) {
                size2 += CodedOutputStream.computeBoolSize(UNK3300_IADLIIMGDMC_FIELD_NUMBER, this.unk3300IADLIIMGDMC_);
            }
            if (this.totalTickTime_ != 0.0d) {
                size2 += CodedOutputStream.computeDoubleSize(TOTALTICKTIME_FIELD_NUMBER, this.totalTickTime_);
            }
            if (this.isScOpen_) {
                size2 += CodedOutputStream.computeBoolSize(ISSCOPEN_FIELD_NUMBER, this.isScOpen_);
            }
            for (int i2 = 0; i2 < this.featureBlockInfoList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(FEATUREBLOCKINFOLIST_FIELD_NUMBER, this.featureBlockInfoList_.get(i2));
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
            if (!(obj instanceof PlayerLoginRsp)) {
                return equals(obj);
            }
            PlayerLoginRsp other = (PlayerLoginRsp) obj;
            if (getIsAudit() != other.getIsAudit() || getUnk3300IIHDKKNJPGD() != other.getUnk3300IIHDKKNJPGD() || !getClientMd5().equals(other.getClientMd5()) || getPlayerDataVersion() != other.getPlayerDataVersion() || !getClientVersionSuffix().equals(other.getClientVersionSuffix()) || getLoginRand() != other.getLoginRand() || !getFeatureBlockInfoListList().equals(other.getFeatureBlockInfoListList()) || getIsUseAbilityHash() != other.getIsUseAbilityHash() || getIsScOpen() != other.getIsScOpen() || !getPlayerData().equals(other.getPlayerData()) || Double.doubleToLongBits(getTotalTickTime()) != Double.doubleToLongBits(other.getTotalTickTime()) || !internalGetBlockInfoMap().equals(other.internalGetBlockInfoMap()) || !getCountryCode().equals(other.getCountryCode()) || hasResVersionConfig() != other.hasResVersionConfig()) {
                return false;
            }
            if ((!hasResVersionConfig() || getResVersionConfig().equals(other.getResVersionConfig())) && getClientSilenceDataVersion() == other.getClientSilenceDataVersion() && getClientSilenceVersionSuffix().equals(other.getClientSilenceVersionSuffix()) && getUnk3300EJKCNNDFAAI() == other.getUnk3300EJKCNNDFAAI() && getClientSilenceMd5().equals(other.getClientSilenceMd5()) && getIsDataNeedRelogin() == other.getIsDataNeedRelogin() && getShortAbilityHashMapList().equals(other.getShortAbilityHashMapList()) && getTargetUid() == other.getTargetUid() && getGameBiz().equals(other.getGameBiz()) && getIsTransfer() == other.getIsTransfer() && getRetcode() == other.getRetcode() && internalGetAbilityHashMap().equals(other.internalGetAbilityHashMap()) && getUnk3300IADLIIMGDMC() == other.getUnk3300IADLIIMGDMC() && getScInfo().equals(other.getScInfo()) && getUnk3300HGFNECIJDLN() == other.getUnk3300HGFNECIJDLN() && getClientDataVersion() == other.getClientDataVersion() && getTargetHomeOwnerUid() == other.getTargetHomeOwnerUid() && getRegisterCps().equals(other.getRegisterCps()) && getBirthday().equals(other.getBirthday()) && hasNextResVersionConfig() == other.hasNextResVersionConfig()) {
                return (!hasNextResVersionConfig() || getNextResVersionConfig().equals(other.getNextResVersionConfig())) && getAbilityHashCode() == other.getAbilityHashCode() && getNextResourceUrl().equals(other.getNextResourceUrl()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 201)) + Internal.hashBoolean(getIsAudit()))) + 6)) + Internal.hashBoolean(getUnk3300IIHDKKNJPGD()))) + 1070)) + getClientMd5().hashCode())) + 9)) + getPlayerDataVersion())) + 624)) + getClientVersionSuffix().hashCode())) + 8)) + Internal.hashLong(getLoginRand());
            if (getFeatureBlockInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + FEATUREBLOCKINFOLIST_FIELD_NUMBER)) + getFeatureBlockInfoListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 15)) + Internal.hashBoolean(getIsUseAbilityHash()))) + ISSCOPEN_FIELD_NUMBER)) + Internal.hashBoolean(getIsScOpen()))) + 14)) + getPlayerData().hashCode())) + TOTALTICKTIME_FIELD_NUMBER)) + Internal.hashLong(Double.doubleToLongBits(getTotalTickTime()));
            if (!internalGetBlockInfoMap().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + BLOCKINFOMAP_FIELD_NUMBER)) + internalGetBlockInfoMap().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 238)) + getCountryCode().hashCode();
            if (hasResVersionConfig()) {
                hash3 = (53 * ((37 * hash3) + RESVERSIONCONFIG_FIELD_NUMBER)) + getResVersionConfig().hashCode();
            }
            int hash4 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash3) + 2)) + getClientSilenceDataVersion())) + 935)) + getClientSilenceVersionSuffix().hashCode())) + UNK3300_EJKCNNDFAAI_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300EJKCNNDFAAI()))) + 979)) + getClientSilenceMd5().hashCode())) + 1021)) + Internal.hashBoolean(getIsDataNeedRelogin());
            if (getShortAbilityHashMapCount() > 0) {
                hash4 = (53 * ((37 * hash4) + SHORTABILITYHASHMAP_FIELD_NUMBER)) + getShortAbilityHashMapList().hashCode();
            }
            int hash5 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash4) + 3)) + getTargetUid())) + 4)) + getGameBiz().hashCode())) + 956)) + Internal.hashBoolean(getIsTransfer()))) + 1)) + getRetcode();
            if (!internalGetAbilityHashMap().getMap().isEmpty()) {
                hash5 = (53 * ((37 * hash5) + 5)) + internalGetAbilityHashMap().hashCode();
            }
            int hash6 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash5) + UNK3300_IADLIIMGDMC_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300IADLIIMGDMC()))) + 151)) + getScInfo().hashCode())) + 10)) + Internal.hashBoolean(getUnk3300HGFNECIJDLN()))) + 7)) + getClientDataVersion())) + 787)) + getTargetHomeOwnerUid())) + 552)) + getRegisterCps().hashCode())) + 163)) + getBirthday().hashCode();
            if (hasNextResVersionConfig()) {
                hash6 = (53 * ((37 * hash6) + 1331)) + getNextResVersionConfig().hashCode();
            }
            int hash7 = (29 * ((53 * ((37 * ((53 * ((37 * hash6) + 13)) + getAbilityHashCode())) + NEXTRESOURCEURL_FIELD_NUMBER)) + getNextResourceUrl().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash7;
            return hash7;
        }

        public static PlayerLoginRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerLoginRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerLoginRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerLoginRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerLoginRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerLoginRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerLoginRsp parseFrom(InputStream input) throws IOException {
            return (PlayerLoginRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerLoginRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerLoginRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerLoginRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerLoginRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerLoginRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerLoginRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerLoginRsp parseFrom(CodedInputStream input) throws IOException {
            return (PlayerLoginRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerLoginRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerLoginRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerLoginRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLoginRspOuterClass$PlayerLoginRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerLoginRspOrBuilder {
            private int bitField0_;
            private boolean isAudit_;
            private boolean unk3300IIHDKKNJPGD_;
            private int playerDataVersion_;
            private long loginRand_;
            private RepeatedFieldBuilderV3<FeatureBlockInfoOuterClass.FeatureBlockInfo, FeatureBlockInfoOuterClass.FeatureBlockInfo.Builder, FeatureBlockInfoOuterClass.FeatureBlockInfoOrBuilder> featureBlockInfoListBuilder_;
            private boolean isUseAbilityHash_;
            private boolean isScOpen_;
            private double totalTickTime_;
            private MapField<Integer, BlockInfoOuterClass.BlockInfo> blockInfoMap_;
            private ResVersionConfigOuterClass.ResVersionConfig resVersionConfig_;
            private SingleFieldBuilderV3<ResVersionConfigOuterClass.ResVersionConfig, ResVersionConfigOuterClass.ResVersionConfig.Builder, ResVersionConfigOuterClass.ResVersionConfigOrBuilder> resVersionConfigBuilder_;
            private int clientSilenceDataVersion_;
            private boolean unk3300EJKCNNDFAAI_;
            private boolean isDataNeedRelogin_;
            private RepeatedFieldBuilderV3<ShortAbilityHashPairOuterClass.ShortAbilityHashPair, ShortAbilityHashPairOuterClass.ShortAbilityHashPair.Builder, ShortAbilityHashPairOuterClass.ShortAbilityHashPairOrBuilder> shortAbilityHashMapBuilder_;
            private int targetUid_;
            private boolean isTransfer_;
            private int retcode_;
            private MapField<String, Integer> abilityHashMap_;
            private boolean unk3300IADLIIMGDMC_;
            private boolean unk3300HGFNECIJDLN_;
            private int clientDataVersion_;
            private int targetHomeOwnerUid_;
            private ResVersionConfigOuterClass.ResVersionConfig nextResVersionConfig_;
            private SingleFieldBuilderV3<ResVersionConfigOuterClass.ResVersionConfig, ResVersionConfigOuterClass.ResVersionConfig.Builder, ResVersionConfigOuterClass.ResVersionConfigOrBuilder> nextResVersionConfigBuilder_;
            private int abilityHashCode_;
            private Object clientMd5_ = "";
            private Object clientVersionSuffix_ = "";
            private List<FeatureBlockInfoOuterClass.FeatureBlockInfo> featureBlockInfoList_ = Collections.emptyList();
            private ByteString playerData_ = ByteString.EMPTY;
            private Object countryCode_ = "";
            private Object clientSilenceVersionSuffix_ = "";
            private Object clientSilenceMd5_ = "";
            private List<ShortAbilityHashPairOuterClass.ShortAbilityHashPair> shortAbilityHashMap_ = Collections.emptyList();
            private Object gameBiz_ = "";
            private ByteString scInfo_ = ByteString.EMPTY;
            private Object registerCps_ = "";
            private Object birthday_ = "";
            private Object nextResourceUrl_ = "";

            /*  JADX ERROR: Dependency scan failed at insn: 0x002B: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 5: goto L_0x0021;
                        case 982: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetBlockInfoMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetAbilityHashMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField");
            }

            /*  JADX ERROR: Dependency scan failed at insn: 0x002B: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 5: goto L_0x0021;
                        case 982: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableBlockInfoMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableAbilityHashMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerLoginRspOuterClass.internal_static_PlayerLoginRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerLoginRspOuterClass.internal_static_PlayerLoginRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerLoginRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerLoginRsp.alwaysUseFieldBuilders) {
                    getFeatureBlockInfoListFieldBuilder();
                    getShortAbilityHashMapFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isAudit_ = false;
                this.unk3300IIHDKKNJPGD_ = false;
                this.clientMd5_ = "";
                this.playerDataVersion_ = 0;
                this.clientVersionSuffix_ = "";
                this.loginRand_ = 0;
                if (this.featureBlockInfoListBuilder_ == null) {
                    this.featureBlockInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.featureBlockInfoListBuilder_.clear();
                }
                this.isUseAbilityHash_ = false;
                this.isScOpen_ = false;
                this.playerData_ = ByteString.EMPTY;
                this.totalTickTime_ = 0.0d;
                internalGetMutableBlockInfoMap().clear();
                this.countryCode_ = "";
                if (this.resVersionConfigBuilder_ == null) {
                    this.resVersionConfig_ = null;
                } else {
                    this.resVersionConfig_ = null;
                    this.resVersionConfigBuilder_ = null;
                }
                this.clientSilenceDataVersion_ = 0;
                this.clientSilenceVersionSuffix_ = "";
                this.unk3300EJKCNNDFAAI_ = false;
                this.clientSilenceMd5_ = "";
                this.isDataNeedRelogin_ = false;
                if (this.shortAbilityHashMapBuilder_ == null) {
                    this.shortAbilityHashMap_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.shortAbilityHashMapBuilder_.clear();
                }
                this.targetUid_ = 0;
                this.gameBiz_ = "";
                this.isTransfer_ = false;
                this.retcode_ = 0;
                internalGetMutableAbilityHashMap().clear();
                this.unk3300IADLIIMGDMC_ = false;
                this.scInfo_ = ByteString.EMPTY;
                this.unk3300HGFNECIJDLN_ = false;
                this.clientDataVersion_ = 0;
                this.targetHomeOwnerUid_ = 0;
                this.registerCps_ = "";
                this.birthday_ = "";
                if (this.nextResVersionConfigBuilder_ == null) {
                    this.nextResVersionConfig_ = null;
                } else {
                    this.nextResVersionConfig_ = null;
                    this.nextResVersionConfigBuilder_ = null;
                }
                this.abilityHashCode_ = 0;
                this.nextResourceUrl_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerLoginRspOuterClass.internal_static_PlayerLoginRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerLoginRsp getDefaultInstanceForType() {
                return PlayerLoginRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerLoginRsp build() {
                PlayerLoginRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerLoginRsp buildPartial() {
                PlayerLoginRsp result = new PlayerLoginRsp(this);
                int i = this.bitField0_;
                result.isAudit_ = this.isAudit_;
                result.unk3300IIHDKKNJPGD_ = this.unk3300IIHDKKNJPGD_;
                result.clientMd5_ = this.clientMd5_;
                result.playerDataVersion_ = this.playerDataVersion_;
                result.clientVersionSuffix_ = this.clientVersionSuffix_;
                result.loginRand_ = this.loginRand_;
                if (this.featureBlockInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.featureBlockInfoList_ = Collections.unmodifiableList(this.featureBlockInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.featureBlockInfoList_ = this.featureBlockInfoList_;
                } else {
                    result.featureBlockInfoList_ = this.featureBlockInfoListBuilder_.build();
                }
                result.isUseAbilityHash_ = this.isUseAbilityHash_;
                result.isScOpen_ = this.isScOpen_;
                result.playerData_ = this.playerData_;
                result.totalTickTime_ = this.totalTickTime_;
                result.blockInfoMap_ = internalGetBlockInfoMap();
                result.blockInfoMap_.makeImmutable();
                result.countryCode_ = this.countryCode_;
                if (this.resVersionConfigBuilder_ == null) {
                    result.resVersionConfig_ = this.resVersionConfig_;
                } else {
                    result.resVersionConfig_ = this.resVersionConfigBuilder_.build();
                }
                result.clientSilenceDataVersion_ = this.clientSilenceDataVersion_;
                result.clientSilenceVersionSuffix_ = this.clientSilenceVersionSuffix_;
                result.unk3300EJKCNNDFAAI_ = this.unk3300EJKCNNDFAAI_;
                result.clientSilenceMd5_ = this.clientSilenceMd5_;
                result.isDataNeedRelogin_ = this.isDataNeedRelogin_;
                if (this.shortAbilityHashMapBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.shortAbilityHashMap_ = Collections.unmodifiableList(this.shortAbilityHashMap_);
                        this.bitField0_ &= -5;
                    }
                    result.shortAbilityHashMap_ = this.shortAbilityHashMap_;
                } else {
                    result.shortAbilityHashMap_ = this.shortAbilityHashMapBuilder_.build();
                }
                result.targetUid_ = this.targetUid_;
                result.gameBiz_ = this.gameBiz_;
                result.isTransfer_ = this.isTransfer_;
                result.retcode_ = this.retcode_;
                result.abilityHashMap_ = internalGetAbilityHashMap();
                result.abilityHashMap_.makeImmutable();
                result.unk3300IADLIIMGDMC_ = this.unk3300IADLIIMGDMC_;
                result.scInfo_ = this.scInfo_;
                result.unk3300HGFNECIJDLN_ = this.unk3300HGFNECIJDLN_;
                result.clientDataVersion_ = this.clientDataVersion_;
                result.targetHomeOwnerUid_ = this.targetHomeOwnerUid_;
                result.registerCps_ = this.registerCps_;
                result.birthday_ = this.birthday_;
                if (this.nextResVersionConfigBuilder_ == null) {
                    result.nextResVersionConfig_ = this.nextResVersionConfig_;
                } else {
                    result.nextResVersionConfig_ = this.nextResVersionConfigBuilder_.build();
                }
                result.abilityHashCode_ = this.abilityHashCode_;
                result.nextResourceUrl_ = this.nextResourceUrl_;
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
                if (other instanceof PlayerLoginRsp) {
                    return mergeFrom((PlayerLoginRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerLoginRsp other) {
                if (other == PlayerLoginRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsAudit()) {
                    setIsAudit(other.getIsAudit());
                }
                if (other.getUnk3300IIHDKKNJPGD()) {
                    setUnk3300IIHDKKNJPGD(other.getUnk3300IIHDKKNJPGD());
                }
                if (!other.getClientMd5().isEmpty()) {
                    this.clientMd5_ = other.clientMd5_;
                    onChanged();
                }
                if (other.getPlayerDataVersion() != 0) {
                    setPlayerDataVersion(other.getPlayerDataVersion());
                }
                if (!other.getClientVersionSuffix().isEmpty()) {
                    this.clientVersionSuffix_ = other.clientVersionSuffix_;
                    onChanged();
                }
                if (other.getLoginRand() != 0) {
                    setLoginRand(other.getLoginRand());
                }
                if (this.featureBlockInfoListBuilder_ == null) {
                    if (!other.featureBlockInfoList_.isEmpty()) {
                        if (this.featureBlockInfoList_.isEmpty()) {
                            this.featureBlockInfoList_ = other.featureBlockInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureFeatureBlockInfoListIsMutable();
                            this.featureBlockInfoList_.addAll(other.featureBlockInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.featureBlockInfoList_.isEmpty()) {
                    if (this.featureBlockInfoListBuilder_.isEmpty()) {
                        this.featureBlockInfoListBuilder_.dispose();
                        this.featureBlockInfoListBuilder_ = null;
                        this.featureBlockInfoList_ = other.featureBlockInfoList_;
                        this.bitField0_ &= -2;
                        this.featureBlockInfoListBuilder_ = PlayerLoginRsp.alwaysUseFieldBuilders ? getFeatureBlockInfoListFieldBuilder() : null;
                    } else {
                        this.featureBlockInfoListBuilder_.addAllMessages(other.featureBlockInfoList_);
                    }
                }
                if (other.getIsUseAbilityHash()) {
                    setIsUseAbilityHash(other.getIsUseAbilityHash());
                }
                if (other.getIsScOpen()) {
                    setIsScOpen(other.getIsScOpen());
                }
                if (other.getPlayerData() != ByteString.EMPTY) {
                    setPlayerData(other.getPlayerData());
                }
                if (other.getTotalTickTime() != 0.0d) {
                    setTotalTickTime(other.getTotalTickTime());
                }
                internalGetMutableBlockInfoMap().mergeFrom(other.internalGetBlockInfoMap());
                if (!other.getCountryCode().isEmpty()) {
                    this.countryCode_ = other.countryCode_;
                    onChanged();
                }
                if (other.hasResVersionConfig()) {
                    mergeResVersionConfig(other.getResVersionConfig());
                }
                if (other.getClientSilenceDataVersion() != 0) {
                    setClientSilenceDataVersion(other.getClientSilenceDataVersion());
                }
                if (!other.getClientSilenceVersionSuffix().isEmpty()) {
                    this.clientSilenceVersionSuffix_ = other.clientSilenceVersionSuffix_;
                    onChanged();
                }
                if (other.getUnk3300EJKCNNDFAAI()) {
                    setUnk3300EJKCNNDFAAI(other.getUnk3300EJKCNNDFAAI());
                }
                if (!other.getClientSilenceMd5().isEmpty()) {
                    this.clientSilenceMd5_ = other.clientSilenceMd5_;
                    onChanged();
                }
                if (other.getIsDataNeedRelogin()) {
                    setIsDataNeedRelogin(other.getIsDataNeedRelogin());
                }
                if (this.shortAbilityHashMapBuilder_ == null) {
                    if (!other.shortAbilityHashMap_.isEmpty()) {
                        if (this.shortAbilityHashMap_.isEmpty()) {
                            this.shortAbilityHashMap_ = other.shortAbilityHashMap_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureShortAbilityHashMapIsMutable();
                            this.shortAbilityHashMap_.addAll(other.shortAbilityHashMap_);
                        }
                        onChanged();
                    }
                } else if (!other.shortAbilityHashMap_.isEmpty()) {
                    if (this.shortAbilityHashMapBuilder_.isEmpty()) {
                        this.shortAbilityHashMapBuilder_.dispose();
                        this.shortAbilityHashMapBuilder_ = null;
                        this.shortAbilityHashMap_ = other.shortAbilityHashMap_;
                        this.bitField0_ &= -5;
                        this.shortAbilityHashMapBuilder_ = PlayerLoginRsp.alwaysUseFieldBuilders ? getShortAbilityHashMapFieldBuilder() : null;
                    } else {
                        this.shortAbilityHashMapBuilder_.addAllMessages(other.shortAbilityHashMap_);
                    }
                }
                if (other.getTargetUid() != 0) {
                    setTargetUid(other.getTargetUid());
                }
                if (!other.getGameBiz().isEmpty()) {
                    this.gameBiz_ = other.gameBiz_;
                    onChanged();
                }
                if (other.getIsTransfer()) {
                    setIsTransfer(other.getIsTransfer());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                internalGetMutableAbilityHashMap().mergeFrom(other.internalGetAbilityHashMap());
                if (other.getUnk3300IADLIIMGDMC()) {
                    setUnk3300IADLIIMGDMC(other.getUnk3300IADLIIMGDMC());
                }
                if (other.getScInfo() != ByteString.EMPTY) {
                    setScInfo(other.getScInfo());
                }
                if (other.getUnk3300HGFNECIJDLN()) {
                    setUnk3300HGFNECIJDLN(other.getUnk3300HGFNECIJDLN());
                }
                if (other.getClientDataVersion() != 0) {
                    setClientDataVersion(other.getClientDataVersion());
                }
                if (other.getTargetHomeOwnerUid() != 0) {
                    setTargetHomeOwnerUid(other.getTargetHomeOwnerUid());
                }
                if (!other.getRegisterCps().isEmpty()) {
                    this.registerCps_ = other.registerCps_;
                    onChanged();
                }
                if (!other.getBirthday().isEmpty()) {
                    this.birthday_ = other.birthday_;
                    onChanged();
                }
                if (other.hasNextResVersionConfig()) {
                    mergeNextResVersionConfig(other.getNextResVersionConfig());
                }
                if (other.getAbilityHashCode() != 0) {
                    setAbilityHashCode(other.getAbilityHashCode());
                }
                if (!other.getNextResourceUrl().isEmpty()) {
                    this.nextResourceUrl_ = other.nextResourceUrl_;
                    onChanged();
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
                PlayerLoginRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerLoginRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerLoginRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public boolean getIsAudit() {
                return this.isAudit_;
            }

            public Builder setIsAudit(boolean value) {
                this.isAudit_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAudit() {
                this.isAudit_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public boolean getUnk3300IIHDKKNJPGD() {
                return this.unk3300IIHDKKNJPGD_;
            }

            public Builder setUnk3300IIHDKKNJPGD(boolean value) {
                this.unk3300IIHDKKNJPGD_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300IIHDKKNJPGD() {
                this.unk3300IIHDKKNJPGD_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public String getClientMd5() {
                Object ref = this.clientMd5_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientMd5_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ByteString getClientMd5Bytes() {
                Object ref = this.clientMd5_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientMd5_ = b;
                return b;
            }

            public Builder setClientMd5(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientMd5_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientMd5() {
                this.clientMd5_ = PlayerLoginRsp.getDefaultInstance().getClientMd5();
                onChanged();
                return this;
            }

            public Builder setClientMd5Bytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginRsp.checkByteStringIsUtf8(value);
                this.clientMd5_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public int getPlayerDataVersion() {
                return this.playerDataVersion_;
            }

            public Builder setPlayerDataVersion(int value) {
                this.playerDataVersion_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerDataVersion() {
                this.playerDataVersion_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public String getClientVersionSuffix() {
                Object ref = this.clientVersionSuffix_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientVersionSuffix_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ByteString getClientVersionSuffixBytes() {
                Object ref = this.clientVersionSuffix_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientVersionSuffix_ = b;
                return b;
            }

            public Builder setClientVersionSuffix(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientVersionSuffix_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientVersionSuffix() {
                this.clientVersionSuffix_ = PlayerLoginRsp.getDefaultInstance().getClientVersionSuffix();
                onChanged();
                return this;
            }

            public Builder setClientVersionSuffixBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginRsp.checkByteStringIsUtf8(value);
                this.clientVersionSuffix_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public long getLoginRand() {
                return this.loginRand_;
            }

            public Builder setLoginRand(long value) {
                this.loginRand_ = value;
                onChanged();
                return this;
            }

            public Builder clearLoginRand() {
                this.loginRand_ = 0;
                onChanged();
                return this;
            }

            private void ensureFeatureBlockInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.featureBlockInfoList_ = new ArrayList(this.featureBlockInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public List<FeatureBlockInfoOuterClass.FeatureBlockInfo> getFeatureBlockInfoListList() {
                if (this.featureBlockInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.featureBlockInfoList_);
                }
                return this.featureBlockInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public int getFeatureBlockInfoListCount() {
                if (this.featureBlockInfoListBuilder_ == null) {
                    return this.featureBlockInfoList_.size();
                }
                return this.featureBlockInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public FeatureBlockInfoOuterClass.FeatureBlockInfo getFeatureBlockInfoList(int index) {
                if (this.featureBlockInfoListBuilder_ == null) {
                    return this.featureBlockInfoList_.get(index);
                }
                return this.featureBlockInfoListBuilder_.getMessage(index);
            }

            public Builder setFeatureBlockInfoList(int index, FeatureBlockInfoOuterClass.FeatureBlockInfo value) {
                if (this.featureBlockInfoListBuilder_ != null) {
                    this.featureBlockInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFeatureBlockInfoListIsMutable();
                    this.featureBlockInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFeatureBlockInfoList(int index, FeatureBlockInfoOuterClass.FeatureBlockInfo.Builder builderForValue) {
                if (this.featureBlockInfoListBuilder_ == null) {
                    ensureFeatureBlockInfoListIsMutable();
                    this.featureBlockInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.featureBlockInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFeatureBlockInfoList(FeatureBlockInfoOuterClass.FeatureBlockInfo value) {
                if (this.featureBlockInfoListBuilder_ != null) {
                    this.featureBlockInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFeatureBlockInfoListIsMutable();
                    this.featureBlockInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFeatureBlockInfoList(int index, FeatureBlockInfoOuterClass.FeatureBlockInfo value) {
                if (this.featureBlockInfoListBuilder_ != null) {
                    this.featureBlockInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFeatureBlockInfoListIsMutable();
                    this.featureBlockInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFeatureBlockInfoList(FeatureBlockInfoOuterClass.FeatureBlockInfo.Builder builderForValue) {
                if (this.featureBlockInfoListBuilder_ == null) {
                    ensureFeatureBlockInfoListIsMutable();
                    this.featureBlockInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.featureBlockInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFeatureBlockInfoList(int index, FeatureBlockInfoOuterClass.FeatureBlockInfo.Builder builderForValue) {
                if (this.featureBlockInfoListBuilder_ == null) {
                    ensureFeatureBlockInfoListIsMutable();
                    this.featureBlockInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.featureBlockInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFeatureBlockInfoList(Iterable<? extends FeatureBlockInfoOuterClass.FeatureBlockInfo> values) {
                if (this.featureBlockInfoListBuilder_ == null) {
                    ensureFeatureBlockInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.featureBlockInfoList_);
                    onChanged();
                } else {
                    this.featureBlockInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFeatureBlockInfoList() {
                if (this.featureBlockInfoListBuilder_ == null) {
                    this.featureBlockInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.featureBlockInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeFeatureBlockInfoList(int index) {
                if (this.featureBlockInfoListBuilder_ == null) {
                    ensureFeatureBlockInfoListIsMutable();
                    this.featureBlockInfoList_.remove(index);
                    onChanged();
                } else {
                    this.featureBlockInfoListBuilder_.remove(index);
                }
                return this;
            }

            public FeatureBlockInfoOuterClass.FeatureBlockInfo.Builder getFeatureBlockInfoListBuilder(int index) {
                return getFeatureBlockInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public FeatureBlockInfoOuterClass.FeatureBlockInfoOrBuilder getFeatureBlockInfoListOrBuilder(int index) {
                if (this.featureBlockInfoListBuilder_ == null) {
                    return this.featureBlockInfoList_.get(index);
                }
                return this.featureBlockInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public List<? extends FeatureBlockInfoOuterClass.FeatureBlockInfoOrBuilder> getFeatureBlockInfoListOrBuilderList() {
                if (this.featureBlockInfoListBuilder_ != null) {
                    return this.featureBlockInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.featureBlockInfoList_);
            }

            public FeatureBlockInfoOuterClass.FeatureBlockInfo.Builder addFeatureBlockInfoListBuilder() {
                return getFeatureBlockInfoListFieldBuilder().addBuilder(FeatureBlockInfoOuterClass.FeatureBlockInfo.getDefaultInstance());
            }

            public FeatureBlockInfoOuterClass.FeatureBlockInfo.Builder addFeatureBlockInfoListBuilder(int index) {
                return getFeatureBlockInfoListFieldBuilder().addBuilder(index, FeatureBlockInfoOuterClass.FeatureBlockInfo.getDefaultInstance());
            }

            public List<FeatureBlockInfoOuterClass.FeatureBlockInfo.Builder> getFeatureBlockInfoListBuilderList() {
                return getFeatureBlockInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FeatureBlockInfoOuterClass.FeatureBlockInfo, FeatureBlockInfoOuterClass.FeatureBlockInfo.Builder, FeatureBlockInfoOuterClass.FeatureBlockInfoOrBuilder> getFeatureBlockInfoListFieldBuilder() {
                if (this.featureBlockInfoListBuilder_ == null) {
                    this.featureBlockInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.featureBlockInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.featureBlockInfoList_ = null;
                }
                return this.featureBlockInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public boolean getIsUseAbilityHash() {
                return this.isUseAbilityHash_;
            }

            public Builder setIsUseAbilityHash(boolean value) {
                this.isUseAbilityHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsUseAbilityHash() {
                this.isUseAbilityHash_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public boolean getIsScOpen() {
                return this.isScOpen_;
            }

            public Builder setIsScOpen(boolean value) {
                this.isScOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsScOpen() {
                this.isScOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ByteString getPlayerData() {
                return this.playerData_;
            }

            public Builder setPlayerData(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.playerData_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerData() {
                this.playerData_ = PlayerLoginRsp.getDefaultInstance().getPlayerData();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public double getTotalTickTime() {
                return this.totalTickTime_;
            }

            public Builder setTotalTickTime(double value) {
                this.totalTickTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalTickTime() {
                this.totalTickTime_ = 0.0d;
                onChanged();
                return this;
            }

            private MapField<Integer, BlockInfoOuterClass.BlockInfo> internalGetBlockInfoMap() {
                if (this.blockInfoMap_ == null) {
                    return MapField.emptyMapField(BlockInfoMapDefaultEntryHolder.defaultEntry);
                }
                return this.blockInfoMap_;
            }

            private MapField<Integer, BlockInfoOuterClass.BlockInfo> internalGetMutableBlockInfoMap() {
                onChanged();
                if (this.blockInfoMap_ == null) {
                    this.blockInfoMap_ = MapField.newMapField(BlockInfoMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.blockInfoMap_.isMutable()) {
                    this.blockInfoMap_ = this.blockInfoMap_.copy();
                }
                return this.blockInfoMap_;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public int getBlockInfoMapCount() {
                return internalGetBlockInfoMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public boolean containsBlockInfoMap(int key) {
                return internalGetBlockInfoMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            @Deprecated
            public Map<Integer, BlockInfoOuterClass.BlockInfo> getBlockInfoMap() {
                return getBlockInfoMapMap();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public Map<Integer, BlockInfoOuterClass.BlockInfo> getBlockInfoMapMap() {
                return internalGetBlockInfoMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public BlockInfoOuterClass.BlockInfo getBlockInfoMapOrDefault(int key, BlockInfoOuterClass.BlockInfo defaultValue) {
                Map<Integer, BlockInfoOuterClass.BlockInfo> map = internalGetBlockInfoMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public BlockInfoOuterClass.BlockInfo getBlockInfoMapOrThrow(int key) {
                Map<Integer, BlockInfoOuterClass.BlockInfo> map = internalGetBlockInfoMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearBlockInfoMap() {
                internalGetMutableBlockInfoMap().getMutableMap().clear();
                return this;
            }

            public Builder removeBlockInfoMap(int key) {
                internalGetMutableBlockInfoMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, BlockInfoOuterClass.BlockInfo> getMutableBlockInfoMap() {
                return internalGetMutableBlockInfoMap().getMutableMap();
            }

            public Builder putBlockInfoMap(int key, BlockInfoOuterClass.BlockInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableBlockInfoMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllBlockInfoMap(Map<Integer, BlockInfoOuterClass.BlockInfo> values) {
                internalGetMutableBlockInfoMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public String getCountryCode() {
                Object ref = this.countryCode_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.countryCode_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ByteString getCountryCodeBytes() {
                Object ref = this.countryCode_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.countryCode_ = b;
                return b;
            }

            public Builder setCountryCode(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.countryCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearCountryCode() {
                this.countryCode_ = PlayerLoginRsp.getDefaultInstance().getCountryCode();
                onChanged();
                return this;
            }

            public Builder setCountryCodeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginRsp.checkByteStringIsUtf8(value);
                this.countryCode_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public boolean hasResVersionConfig() {
                return (this.resVersionConfigBuilder_ == null && this.resVersionConfig_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ResVersionConfigOuterClass.ResVersionConfig getResVersionConfig() {
                if (this.resVersionConfigBuilder_ == null) {
                    return this.resVersionConfig_ == null ? ResVersionConfigOuterClass.ResVersionConfig.getDefaultInstance() : this.resVersionConfig_;
                }
                return this.resVersionConfigBuilder_.getMessage();
            }

            public Builder setResVersionConfig(ResVersionConfigOuterClass.ResVersionConfig value) {
                if (this.resVersionConfigBuilder_ != null) {
                    this.resVersionConfigBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.resVersionConfig_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setResVersionConfig(ResVersionConfigOuterClass.ResVersionConfig.Builder builderForValue) {
                if (this.resVersionConfigBuilder_ == null) {
                    this.resVersionConfig_ = builderForValue.build();
                    onChanged();
                } else {
                    this.resVersionConfigBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeResVersionConfig(ResVersionConfigOuterClass.ResVersionConfig value) {
                if (this.resVersionConfigBuilder_ == null) {
                    if (this.resVersionConfig_ != null) {
                        this.resVersionConfig_ = ResVersionConfigOuterClass.ResVersionConfig.newBuilder(this.resVersionConfig_).mergeFrom(value).buildPartial();
                    } else {
                        this.resVersionConfig_ = value;
                    }
                    onChanged();
                } else {
                    this.resVersionConfigBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearResVersionConfig() {
                if (this.resVersionConfigBuilder_ == null) {
                    this.resVersionConfig_ = null;
                    onChanged();
                } else {
                    this.resVersionConfig_ = null;
                    this.resVersionConfigBuilder_ = null;
                }
                return this;
            }

            public ResVersionConfigOuterClass.ResVersionConfig.Builder getResVersionConfigBuilder() {
                onChanged();
                return getResVersionConfigFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ResVersionConfigOuterClass.ResVersionConfigOrBuilder getResVersionConfigOrBuilder() {
                if (this.resVersionConfigBuilder_ != null) {
                    return this.resVersionConfigBuilder_.getMessageOrBuilder();
                }
                return this.resVersionConfig_ == null ? ResVersionConfigOuterClass.ResVersionConfig.getDefaultInstance() : this.resVersionConfig_;
            }

            private SingleFieldBuilderV3<ResVersionConfigOuterClass.ResVersionConfig, ResVersionConfigOuterClass.ResVersionConfig.Builder, ResVersionConfigOuterClass.ResVersionConfigOrBuilder> getResVersionConfigFieldBuilder() {
                if (this.resVersionConfigBuilder_ == null) {
                    this.resVersionConfigBuilder_ = new SingleFieldBuilderV3<>(getResVersionConfig(), getParentForChildren(), isClean());
                    this.resVersionConfig_ = null;
                }
                return this.resVersionConfigBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public int getClientSilenceDataVersion() {
                return this.clientSilenceDataVersion_;
            }

            public Builder setClientSilenceDataVersion(int value) {
                this.clientSilenceDataVersion_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientSilenceDataVersion() {
                this.clientSilenceDataVersion_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public String getClientSilenceVersionSuffix() {
                Object ref = this.clientSilenceVersionSuffix_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientSilenceVersionSuffix_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ByteString getClientSilenceVersionSuffixBytes() {
                Object ref = this.clientSilenceVersionSuffix_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientSilenceVersionSuffix_ = b;
                return b;
            }

            public Builder setClientSilenceVersionSuffix(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientSilenceVersionSuffix_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientSilenceVersionSuffix() {
                this.clientSilenceVersionSuffix_ = PlayerLoginRsp.getDefaultInstance().getClientSilenceVersionSuffix();
                onChanged();
                return this;
            }

            public Builder setClientSilenceVersionSuffixBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginRsp.checkByteStringIsUtf8(value);
                this.clientSilenceVersionSuffix_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public boolean getUnk3300EJKCNNDFAAI() {
                return this.unk3300EJKCNNDFAAI_;
            }

            public Builder setUnk3300EJKCNNDFAAI(boolean value) {
                this.unk3300EJKCNNDFAAI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300EJKCNNDFAAI() {
                this.unk3300EJKCNNDFAAI_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public String getClientSilenceMd5() {
                Object ref = this.clientSilenceMd5_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientSilenceMd5_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ByteString getClientSilenceMd5Bytes() {
                Object ref = this.clientSilenceMd5_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientSilenceMd5_ = b;
                return b;
            }

            public Builder setClientSilenceMd5(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientSilenceMd5_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientSilenceMd5() {
                this.clientSilenceMd5_ = PlayerLoginRsp.getDefaultInstance().getClientSilenceMd5();
                onChanged();
                return this;
            }

            public Builder setClientSilenceMd5Bytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginRsp.checkByteStringIsUtf8(value);
                this.clientSilenceMd5_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public boolean getIsDataNeedRelogin() {
                return this.isDataNeedRelogin_;
            }

            public Builder setIsDataNeedRelogin(boolean value) {
                this.isDataNeedRelogin_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsDataNeedRelogin() {
                this.isDataNeedRelogin_ = false;
                onChanged();
                return this;
            }

            private void ensureShortAbilityHashMapIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.shortAbilityHashMap_ = new ArrayList(this.shortAbilityHashMap_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public List<ShortAbilityHashPairOuterClass.ShortAbilityHashPair> getShortAbilityHashMapList() {
                if (this.shortAbilityHashMapBuilder_ == null) {
                    return Collections.unmodifiableList(this.shortAbilityHashMap_);
                }
                return this.shortAbilityHashMapBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public int getShortAbilityHashMapCount() {
                if (this.shortAbilityHashMapBuilder_ == null) {
                    return this.shortAbilityHashMap_.size();
                }
                return this.shortAbilityHashMapBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ShortAbilityHashPairOuterClass.ShortAbilityHashPair getShortAbilityHashMap(int index) {
                if (this.shortAbilityHashMapBuilder_ == null) {
                    return this.shortAbilityHashMap_.get(index);
                }
                return this.shortAbilityHashMapBuilder_.getMessage(index);
            }

            public Builder setShortAbilityHashMap(int index, ShortAbilityHashPairOuterClass.ShortAbilityHashPair value) {
                if (this.shortAbilityHashMapBuilder_ != null) {
                    this.shortAbilityHashMapBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureShortAbilityHashMapIsMutable();
                    this.shortAbilityHashMap_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setShortAbilityHashMap(int index, ShortAbilityHashPairOuterClass.ShortAbilityHashPair.Builder builderForValue) {
                if (this.shortAbilityHashMapBuilder_ == null) {
                    ensureShortAbilityHashMapIsMutable();
                    this.shortAbilityHashMap_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.shortAbilityHashMapBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addShortAbilityHashMap(ShortAbilityHashPairOuterClass.ShortAbilityHashPair value) {
                if (this.shortAbilityHashMapBuilder_ != null) {
                    this.shortAbilityHashMapBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureShortAbilityHashMapIsMutable();
                    this.shortAbilityHashMap_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addShortAbilityHashMap(int index, ShortAbilityHashPairOuterClass.ShortAbilityHashPair value) {
                if (this.shortAbilityHashMapBuilder_ != null) {
                    this.shortAbilityHashMapBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureShortAbilityHashMapIsMutable();
                    this.shortAbilityHashMap_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addShortAbilityHashMap(ShortAbilityHashPairOuterClass.ShortAbilityHashPair.Builder builderForValue) {
                if (this.shortAbilityHashMapBuilder_ == null) {
                    ensureShortAbilityHashMapIsMutable();
                    this.shortAbilityHashMap_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.shortAbilityHashMapBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addShortAbilityHashMap(int index, ShortAbilityHashPairOuterClass.ShortAbilityHashPair.Builder builderForValue) {
                if (this.shortAbilityHashMapBuilder_ == null) {
                    ensureShortAbilityHashMapIsMutable();
                    this.shortAbilityHashMap_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.shortAbilityHashMapBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllShortAbilityHashMap(Iterable<? extends ShortAbilityHashPairOuterClass.ShortAbilityHashPair> values) {
                if (this.shortAbilityHashMapBuilder_ == null) {
                    ensureShortAbilityHashMapIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.shortAbilityHashMap_);
                    onChanged();
                } else {
                    this.shortAbilityHashMapBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearShortAbilityHashMap() {
                if (this.shortAbilityHashMapBuilder_ == null) {
                    this.shortAbilityHashMap_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.shortAbilityHashMapBuilder_.clear();
                }
                return this;
            }

            public Builder removeShortAbilityHashMap(int index) {
                if (this.shortAbilityHashMapBuilder_ == null) {
                    ensureShortAbilityHashMapIsMutable();
                    this.shortAbilityHashMap_.remove(index);
                    onChanged();
                } else {
                    this.shortAbilityHashMapBuilder_.remove(index);
                }
                return this;
            }

            public ShortAbilityHashPairOuterClass.ShortAbilityHashPair.Builder getShortAbilityHashMapBuilder(int index) {
                return getShortAbilityHashMapFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ShortAbilityHashPairOuterClass.ShortAbilityHashPairOrBuilder getShortAbilityHashMapOrBuilder(int index) {
                if (this.shortAbilityHashMapBuilder_ == null) {
                    return this.shortAbilityHashMap_.get(index);
                }
                return this.shortAbilityHashMapBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public List<? extends ShortAbilityHashPairOuterClass.ShortAbilityHashPairOrBuilder> getShortAbilityHashMapOrBuilderList() {
                if (this.shortAbilityHashMapBuilder_ != null) {
                    return this.shortAbilityHashMapBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.shortAbilityHashMap_);
            }

            public ShortAbilityHashPairOuterClass.ShortAbilityHashPair.Builder addShortAbilityHashMapBuilder() {
                return getShortAbilityHashMapFieldBuilder().addBuilder(ShortAbilityHashPairOuterClass.ShortAbilityHashPair.getDefaultInstance());
            }

            public ShortAbilityHashPairOuterClass.ShortAbilityHashPair.Builder addShortAbilityHashMapBuilder(int index) {
                return getShortAbilityHashMapFieldBuilder().addBuilder(index, ShortAbilityHashPairOuterClass.ShortAbilityHashPair.getDefaultInstance());
            }

            public List<ShortAbilityHashPairOuterClass.ShortAbilityHashPair.Builder> getShortAbilityHashMapBuilderList() {
                return getShortAbilityHashMapFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ShortAbilityHashPairOuterClass.ShortAbilityHashPair, ShortAbilityHashPairOuterClass.ShortAbilityHashPair.Builder, ShortAbilityHashPairOuterClass.ShortAbilityHashPairOrBuilder> getShortAbilityHashMapFieldBuilder() {
                if (this.shortAbilityHashMapBuilder_ == null) {
                    this.shortAbilityHashMapBuilder_ = new RepeatedFieldBuilderV3<>(this.shortAbilityHashMap_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.shortAbilityHashMap_ = null;
                }
                return this.shortAbilityHashMapBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public int getTargetUid() {
                return this.targetUid_;
            }

            public Builder setTargetUid(int value) {
                this.targetUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public String getGameBiz() {
                Object ref = this.gameBiz_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gameBiz_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ByteString getGameBizBytes() {
                Object ref = this.gameBiz_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gameBiz_ = b;
                return b;
            }

            public Builder setGameBiz(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gameBiz_ = value;
                onChanged();
                return this;
            }

            public Builder clearGameBiz() {
                this.gameBiz_ = PlayerLoginRsp.getDefaultInstance().getGameBiz();
                onChanged();
                return this;
            }

            public Builder setGameBizBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginRsp.checkByteStringIsUtf8(value);
                this.gameBiz_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public boolean getIsTransfer() {
                return this.isTransfer_;
            }

            public Builder setIsTransfer(boolean value) {
                this.isTransfer_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTransfer() {
                this.isTransfer_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            private MapField<String, Integer> internalGetAbilityHashMap() {
                if (this.abilityHashMap_ == null) {
                    return MapField.emptyMapField(AbilityHashMapDefaultEntryHolder.defaultEntry);
                }
                return this.abilityHashMap_;
            }

            private MapField<String, Integer> internalGetMutableAbilityHashMap() {
                onChanged();
                if (this.abilityHashMap_ == null) {
                    this.abilityHashMap_ = MapField.newMapField(AbilityHashMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.abilityHashMap_.isMutable()) {
                    this.abilityHashMap_ = this.abilityHashMap_.copy();
                }
                return this.abilityHashMap_;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public int getAbilityHashMapCount() {
                return internalGetAbilityHashMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public boolean containsAbilityHashMap(String key) {
                if (key != null) {
                    return internalGetAbilityHashMap().getMap().containsKey(key);
                }
                throw new NullPointerException();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            @Deprecated
            public Map<String, Integer> getAbilityHashMap() {
                return getAbilityHashMapMap();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public Map<String, Integer> getAbilityHashMapMap() {
                return internalGetAbilityHashMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public int getAbilityHashMapOrDefault(String key, int defaultValue) {
                if (key == null) {
                    throw new NullPointerException();
                }
                Map<String, Integer> map = internalGetAbilityHashMap().getMap();
                return map.containsKey(key) ? map.get(key).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public int getAbilityHashMapOrThrow(String key) {
                if (key == null) {
                    throw new NullPointerException();
                }
                Map<String, Integer> map = internalGetAbilityHashMap().getMap();
                if (map.containsKey(key)) {
                    return map.get(key).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearAbilityHashMap() {
                internalGetMutableAbilityHashMap().getMutableMap().clear();
                return this;
            }

            public Builder removeAbilityHashMap(String key) {
                if (key == null) {
                    throw new NullPointerException();
                }
                internalGetMutableAbilityHashMap().getMutableMap().remove(key);
                return this;
            }

            @Deprecated
            public Map<String, Integer> getMutableAbilityHashMap() {
                return internalGetMutableAbilityHashMap().getMutableMap();
            }

            public Builder putAbilityHashMap(String key, int value) {
                if (key == null) {
                    throw new NullPointerException();
                }
                internalGetMutableAbilityHashMap().getMutableMap().put(key, Integer.valueOf(value));
                return this;
            }

            public Builder putAllAbilityHashMap(Map<String, Integer> values) {
                internalGetMutableAbilityHashMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public boolean getUnk3300IADLIIMGDMC() {
                return this.unk3300IADLIIMGDMC_;
            }

            public Builder setUnk3300IADLIIMGDMC(boolean value) {
                this.unk3300IADLIIMGDMC_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300IADLIIMGDMC() {
                this.unk3300IADLIIMGDMC_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ByteString getScInfo() {
                return this.scInfo_;
            }

            public Builder setScInfo(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.scInfo_ = value;
                onChanged();
                return this;
            }

            public Builder clearScInfo() {
                this.scInfo_ = PlayerLoginRsp.getDefaultInstance().getScInfo();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public boolean getUnk3300HGFNECIJDLN() {
                return this.unk3300HGFNECIJDLN_;
            }

            public Builder setUnk3300HGFNECIJDLN(boolean value) {
                this.unk3300HGFNECIJDLN_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HGFNECIJDLN() {
                this.unk3300HGFNECIJDLN_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public int getClientDataVersion() {
                return this.clientDataVersion_;
            }

            public Builder setClientDataVersion(int value) {
                this.clientDataVersion_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientDataVersion() {
                this.clientDataVersion_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public int getTargetHomeOwnerUid() {
                return this.targetHomeOwnerUid_;
            }

            public Builder setTargetHomeOwnerUid(int value) {
                this.targetHomeOwnerUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetHomeOwnerUid() {
                this.targetHomeOwnerUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public String getRegisterCps() {
                Object ref = this.registerCps_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.registerCps_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ByteString getRegisterCpsBytes() {
                Object ref = this.registerCps_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.registerCps_ = b;
                return b;
            }

            public Builder setRegisterCps(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.registerCps_ = value;
                onChanged();
                return this;
            }

            public Builder clearRegisterCps() {
                this.registerCps_ = PlayerLoginRsp.getDefaultInstance().getRegisterCps();
                onChanged();
                return this;
            }

            public Builder setRegisterCpsBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginRsp.checkByteStringIsUtf8(value);
                this.registerCps_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public String getBirthday() {
                Object ref = this.birthday_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.birthday_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ByteString getBirthdayBytes() {
                Object ref = this.birthday_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.birthday_ = b;
                return b;
            }

            public Builder setBirthday(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.birthday_ = value;
                onChanged();
                return this;
            }

            public Builder clearBirthday() {
                this.birthday_ = PlayerLoginRsp.getDefaultInstance().getBirthday();
                onChanged();
                return this;
            }

            public Builder setBirthdayBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginRsp.checkByteStringIsUtf8(value);
                this.birthday_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public boolean hasNextResVersionConfig() {
                return (this.nextResVersionConfigBuilder_ == null && this.nextResVersionConfig_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ResVersionConfigOuterClass.ResVersionConfig getNextResVersionConfig() {
                if (this.nextResVersionConfigBuilder_ == null) {
                    return this.nextResVersionConfig_ == null ? ResVersionConfigOuterClass.ResVersionConfig.getDefaultInstance() : this.nextResVersionConfig_;
                }
                return this.nextResVersionConfigBuilder_.getMessage();
            }

            public Builder setNextResVersionConfig(ResVersionConfigOuterClass.ResVersionConfig value) {
                if (this.nextResVersionConfigBuilder_ != null) {
                    this.nextResVersionConfigBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.nextResVersionConfig_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setNextResVersionConfig(ResVersionConfigOuterClass.ResVersionConfig.Builder builderForValue) {
                if (this.nextResVersionConfigBuilder_ == null) {
                    this.nextResVersionConfig_ = builderForValue.build();
                    onChanged();
                } else {
                    this.nextResVersionConfigBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeNextResVersionConfig(ResVersionConfigOuterClass.ResVersionConfig value) {
                if (this.nextResVersionConfigBuilder_ == null) {
                    if (this.nextResVersionConfig_ != null) {
                        this.nextResVersionConfig_ = ResVersionConfigOuterClass.ResVersionConfig.newBuilder(this.nextResVersionConfig_).mergeFrom(value).buildPartial();
                    } else {
                        this.nextResVersionConfig_ = value;
                    }
                    onChanged();
                } else {
                    this.nextResVersionConfigBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearNextResVersionConfig() {
                if (this.nextResVersionConfigBuilder_ == null) {
                    this.nextResVersionConfig_ = null;
                    onChanged();
                } else {
                    this.nextResVersionConfig_ = null;
                    this.nextResVersionConfigBuilder_ = null;
                }
                return this;
            }

            public ResVersionConfigOuterClass.ResVersionConfig.Builder getNextResVersionConfigBuilder() {
                onChanged();
                return getNextResVersionConfigFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ResVersionConfigOuterClass.ResVersionConfigOrBuilder getNextResVersionConfigOrBuilder() {
                if (this.nextResVersionConfigBuilder_ != null) {
                    return this.nextResVersionConfigBuilder_.getMessageOrBuilder();
                }
                return this.nextResVersionConfig_ == null ? ResVersionConfigOuterClass.ResVersionConfig.getDefaultInstance() : this.nextResVersionConfig_;
            }

            private SingleFieldBuilderV3<ResVersionConfigOuterClass.ResVersionConfig, ResVersionConfigOuterClass.ResVersionConfig.Builder, ResVersionConfigOuterClass.ResVersionConfigOrBuilder> getNextResVersionConfigFieldBuilder() {
                if (this.nextResVersionConfigBuilder_ == null) {
                    this.nextResVersionConfigBuilder_ = new SingleFieldBuilderV3<>(getNextResVersionConfig(), getParentForChildren(), isClean());
                    this.nextResVersionConfig_ = null;
                }
                return this.nextResVersionConfigBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public int getAbilityHashCode() {
                return this.abilityHashCode_;
            }

            public Builder setAbilityHashCode(int value) {
                this.abilityHashCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearAbilityHashCode() {
                this.abilityHashCode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public String getNextResourceUrl() {
                Object ref = this.nextResourceUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.nextResourceUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginRspOuterClass.PlayerLoginRspOrBuilder
            public ByteString getNextResourceUrlBytes() {
                Object ref = this.nextResourceUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.nextResourceUrl_ = b;
                return b;
            }

            public Builder setNextResourceUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.nextResourceUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextResourceUrl() {
                this.nextResourceUrl_ = PlayerLoginRsp.getDefaultInstance().getNextResourceUrl();
                onChanged();
                return this;
            }

            public Builder setNextResourceUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginRsp.checkByteStringIsUtf8(value);
                this.nextResourceUrl_ = value;
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

        public static PlayerLoginRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerLoginRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerLoginRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerLoginRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ResVersionConfigOuterClass.getDescriptor();
        FeatureBlockInfoOuterClass.getDescriptor();
        BlockInfoOuterClass.getDescriptor();
        ShortAbilityHashPairOuterClass.getDescriptor();
    }
}
