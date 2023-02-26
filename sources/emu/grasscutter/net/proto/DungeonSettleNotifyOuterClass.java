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
import emu.grasscutter.net.proto.ChannellerSlabLoopDungeonResultInfoOuterClass;
import emu.grasscutter.net.proto.CrystalLinkSettleInfoOuterClass;
import emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass;
import emu.grasscutter.net.proto.EffigyChallengeDungeonResultInfoOuterClass;
import emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass;
import emu.grasscutter.net.proto.InstableSpraySettleInfoOuterClass;
import emu.grasscutter.net.proto.ParamListOuterClass;
import emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass;
import emu.grasscutter.net.proto.StrengthenPointDataOuterClass;
import emu.grasscutter.net.proto.SummerTimeV2DungeonSettleInfoOuterClass;
import emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass;
import emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass;
import emu.grasscutter.net.proto.TrialAvatarFirstPassDungeonNotifyOuterClass;
import emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSettleNotifyOuterClass.class */
public final class DungeonSettleNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019DungeonSettleNotify.proto\u001a\u0019TowerLevelEndNotify.proto\u001a'TrialAvatarFirstPassDungeonNotify.proto\u001a)ChannellerSlabLoopDungeonResultInfo.proto\u001a&EffigyChallengeDungeonResultInfo.proto\u001a RoguelikeDungeonSettleInfo.proto\u001a\u001bCrystalLinkSettleInfo.proto\u001a#SummerTimeV2DungeonSettleInfo.proto\u001a\u001dInstableSpraySettleInfo.proto\u001a WindFieldDungeonSettleInfo.proto\u001a!EffigyChallengeV2SettleInfo.proto\u001a\u0019TeamChainSettleInfo.proto\u001a!DungeonSettleExhibitionInfo.proto\u001a\u000fParamList.proto\u001a\u0019StrengthenPointData.proto\"\n\n\u0013DungeonSettleNotify\u00128\n\u0012exhibitionInfoList\u0018\f \u0003(\u000b2\u001c.DungeonSettleExhibitionInfo\u00128\n\nsettleShow\u0018\u000e \u0003(\u000b2$.DungeonSettleNotify.SettleShowEntry\u0012P\n\u0016strengthenPointDataMap\u0018\u0001 \u0003(\u000b20.DungeonSettleNotify.StrengthenPointDataMapEntry\u0012\u000e\n\u0006result\u0018\u000f \u0001(\r\u0012\u000f\n\u0007useTime\u0018\u0002 \u0001(\r\u0012\u0011\n\tdungeonId\u0018\u0007 \u0001(\r\u0012\u0014\n\ffailCondList\u0018\b \u0003(\r\u0012\u0017\n\u000fcreatePlayerUid\u0018\t \u0001(\r\u0012\u0011\n\tisSuccess\u0018\u0004 \u0001(\b\u0012\u0011\n\tcloseTime\u0018\u0006 \u0001(\r\u00127\n\u0016tower_level_end_notify\u0018\u0002 \u0001(\u000b2\u0014.TowerLevelEndNotifyH��\u0012U\n&trial_avatar_first_pass_dungeon_notify\u0018É\r \u0001(\u000b2\".TrialAvatarFirstPassDungeonNotifyH��\u0012Y\n(channeller_slab_loop_dungeon_result_info\u0018\b \u0001(\u000b2$.ChannellerSlabLoopDungeonResultInfoH��\u0012R\n$effigy_challenge_dungeon_result_info\u0018»\u0007 \u0001(\u000b2!.EffigyChallengeDungeonResultInfoH��\u0012E\n\u001droguelike_dungeon_settle_info\u0018\u0006 \u0001(\u000b2\u001b.RoguelikeDungeonSettleInfoH��\u0012;\n\u0018crystal_link_settle_info\u0018ô\u0004 \u0001(\u000b2\u0016.CrystalLinkSettleInfoH��\u0012K\n!summer_time_v2dungeon_settle_info\u0018` \u0001(\u000b2\u001e.SummerTimeV2DungeonSettleInfoH��\u0012?\n\u001ainstable_spray_settle_info\u0018\u000e \u0001(\u000b2\u0018.InstableSpraySettleInfoH��\u0012F\n\u001ewind_field_dungeon_settle_info\u0018ñ\u0007 \u0001(\u000b2\u001b.WindFieldDungeonSettleInfoH��\u0012G\n\u001eeffigy_challenge_v2settle_info\u0018¯\u000e \u0001(\u000b2\u001c.EffigyChallengeV2SettleInfoH��\u00127\n\u0016team_chain_settle_info\u0018¨\n \u0001(\u000b2\u0014.TeamChainSettleInfoH��\u001a=\n\u000fSettleShowEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u0019\n\u0005value\u0018\u0002 \u0001(\u000b2\n.ParamList:\u00028\u0001\u001aS\n\u001bStrengthenPointDataMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012#\n\u0005value\u0018\u0002 \u0001(\u000b2\u0014.StrengthenPointData:\u00028\u0001B\b\n\u0006detailB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TowerLevelEndNotifyOuterClass.getDescriptor(), TrialAvatarFirstPassDungeonNotifyOuterClass.getDescriptor(), ChannellerSlabLoopDungeonResultInfoOuterClass.getDescriptor(), EffigyChallengeDungeonResultInfoOuterClass.getDescriptor(), RoguelikeDungeonSettleInfoOuterClass.getDescriptor(), CrystalLinkSettleInfoOuterClass.getDescriptor(), SummerTimeV2DungeonSettleInfoOuterClass.getDescriptor(), InstableSpraySettleInfoOuterClass.getDescriptor(), WindFieldDungeonSettleInfoOuterClass.getDescriptor(), EffigyChallengeV2SettleInfoOuterClass.getDescriptor(), TeamChainSettleInfoOuterClass.getDescriptor(), DungeonSettleExhibitionInfoOuterClass.getDescriptor(), ParamListOuterClass.getDescriptor(), StrengthenPointDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DungeonSettleNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DungeonSettleNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DungeonSettleNotify_descriptor, new String[]{"ExhibitionInfoList", "SettleShow", "StrengthenPointDataMap", "Result", "UseTime", "DungeonId", "FailCondList", "CreatePlayerUid", "IsSuccess", "CloseTime", "TowerLevelEndNotify", "TrialAvatarFirstPassDungeonNotify", "ChannellerSlabLoopDungeonResultInfo", "EffigyChallengeDungeonResultInfo", "RoguelikeDungeonSettleInfo", "CrystalLinkSettleInfo", "SummerTimeV2DungeonSettleInfo", "InstableSpraySettleInfo", "WindFieldDungeonSettleInfo", "EffigyChallengeV2SettleInfo", "TeamChainSettleInfo", "Detail"});
    private static final Descriptors.Descriptor internal_static_DungeonSettleNotify_SettleShowEntry_descriptor = internal_static_DungeonSettleNotify_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_DungeonSettleNotify_SettleShowEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f686xd1daba2 = new GeneratedMessageV3.FieldAccessorTable(internal_static_DungeonSettleNotify_SettleShowEntry_descriptor, new String[]{"Key", "Value"});

    /* renamed from: internal_static_DungeonSettleNotify_StrengthenPointDataMapEntry_descriptor */
    private static final Descriptors.Descriptor f687xa24d79a8 = internal_static_DungeonSettleNotify_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_DungeonSettleNotify_StrengthenPointDataMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f688xce1c7826 = new GeneratedMessageV3.FieldAccessorTable(f687xa24d79a8, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSettleNotifyOuterClass$DungeonSettleNotifyOrBuilder.class */
    public interface DungeonSettleNotifyOrBuilder extends MessageOrBuilder {
        List<DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo> getExhibitionInfoListList();

        DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo getExhibitionInfoList(int i);

        int getExhibitionInfoListCount();

        List<? extends DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder> getExhibitionInfoListOrBuilderList();

        DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder getExhibitionInfoListOrBuilder(int i);

        int getSettleShowCount();

        boolean containsSettleShow(int i);

        @Deprecated
        Map<Integer, ParamListOuterClass.ParamList> getSettleShow();

        Map<Integer, ParamListOuterClass.ParamList> getSettleShowMap();

        ParamListOuterClass.ParamList getSettleShowOrDefault(int i, ParamListOuterClass.ParamList paramList);

        ParamListOuterClass.ParamList getSettleShowOrThrow(int i);

        int getStrengthenPointDataMapCount();

        boolean containsStrengthenPointDataMap(int i);

        @Deprecated
        Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> getStrengthenPointDataMap();

        Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> getStrengthenPointDataMapMap();

        StrengthenPointDataOuterClass.StrengthenPointData getStrengthenPointDataMapOrDefault(int i, StrengthenPointDataOuterClass.StrengthenPointData strengthenPointData);

        StrengthenPointDataOuterClass.StrengthenPointData getStrengthenPointDataMapOrThrow(int i);

        int getResult();

        int getUseTime();

        int getDungeonId();

        List<Integer> getFailCondListList();

        int getFailCondListCount();

        int getFailCondList(int i);

        int getCreatePlayerUid();

        boolean getIsSuccess();

        int getCloseTime();

        boolean hasTowerLevelEndNotify();

        TowerLevelEndNotifyOuterClass.TowerLevelEndNotify getTowerLevelEndNotify();

        TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder getTowerLevelEndNotifyOrBuilder();

        boolean hasTrialAvatarFirstPassDungeonNotify();

        TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify getTrialAvatarFirstPassDungeonNotify();

        TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotifyOrBuilder getTrialAvatarFirstPassDungeonNotifyOrBuilder();

        boolean hasChannellerSlabLoopDungeonResultInfo();

        ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo getChannellerSlabLoopDungeonResultInfo();

        ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder getChannellerSlabLoopDungeonResultInfoOrBuilder();

        boolean hasEffigyChallengeDungeonResultInfo();

        EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo getEffigyChallengeDungeonResultInfo();

        EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder getEffigyChallengeDungeonResultInfoOrBuilder();

        boolean hasRoguelikeDungeonSettleInfo();

        RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo getRoguelikeDungeonSettleInfo();

        RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder getRoguelikeDungeonSettleInfoOrBuilder();

        boolean hasCrystalLinkSettleInfo();

        CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo getCrystalLinkSettleInfo();

        CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder getCrystalLinkSettleInfoOrBuilder();

        boolean hasSummerTimeV2DungeonSettleInfo();

        SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo getSummerTimeV2DungeonSettleInfo();

        SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfoOrBuilder getSummerTimeV2DungeonSettleInfoOrBuilder();

        boolean hasInstableSpraySettleInfo();

        InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo getInstableSpraySettleInfo();

        InstableSpraySettleInfoOuterClass.InstableSpraySettleInfoOrBuilder getInstableSpraySettleInfoOrBuilder();

        boolean hasWindFieldDungeonSettleInfo();

        WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo getWindFieldDungeonSettleInfo();

        WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder getWindFieldDungeonSettleInfoOrBuilder();

        boolean hasEffigyChallengeV2SettleInfo();

        EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo getEffigyChallengeV2SettleInfo();

        EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder getEffigyChallengeV2SettleInfoOrBuilder();

        boolean hasTeamChainSettleInfo();

        TeamChainSettleInfoOuterClass.TeamChainSettleInfo getTeamChainSettleInfo();

        TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder getTeamChainSettleInfoOrBuilder();

        DungeonSettleNotify.DetailCase getDetailCase();
    }

    private DungeonSettleNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSettleNotifyOuterClass$DungeonSettleNotify.class */
    public static final class DungeonSettleNotify extends GeneratedMessageV3 implements DungeonSettleNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        private int detailCase_;
        private Object detail_;
        public static final int EXHIBITIONINFOLIST_FIELD_NUMBER = 12;
        private List<DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo> exhibitionInfoList_;
        public static final int SETTLESHOW_FIELD_NUMBER = 14;
        private MapField<Integer, ParamListOuterClass.ParamList> settleShow_;
        public static final int STRENGTHENPOINTDATAMAP_FIELD_NUMBER = 1;
        private MapField<Integer, StrengthenPointDataOuterClass.StrengthenPointData> strengthenPointDataMap_;
        public static final int RESULT_FIELD_NUMBER = 15;
        private int result_;
        public static final int USETIME_FIELD_NUMBER = 2;
        private int useTime_;
        public static final int DUNGEONID_FIELD_NUMBER = 7;
        private int dungeonId_;
        public static final int FAILCONDLIST_FIELD_NUMBER = 8;
        private Internal.IntList failCondList_;
        private int failCondListMemoizedSerializedSize;
        public static final int CREATEPLAYERUID_FIELD_NUMBER = 9;
        private int createPlayerUid_;
        public static final int ISSUCCESS_FIELD_NUMBER = 4;
        private boolean isSuccess_;
        public static final int CLOSETIME_FIELD_NUMBER = 6;
        private int closeTime_;
        public static final int TOWER_LEVEL_END_NOTIFY_FIELD_NUMBER = 281;
        public static final int TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY_FIELD_NUMBER = 1737;
        public static final int CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER = 1045;
        public static final int EFFIGY_CHALLENGE_DUNGEON_RESULT_INFO_FIELD_NUMBER = 955;
        public static final int ROGUELIKE_DUNGEON_SETTLE_INFO_FIELD_NUMBER = 799;
        public static final int CRYSTAL_LINK_SETTLE_INFO_FIELD_NUMBER = 628;
        public static final int SUMMER_TIME_V2DUNGEON_SETTLE_INFO_FIELD_NUMBER = 96;
        public static final int INSTABLE_SPRAY_SETTLE_INFO_FIELD_NUMBER = 1797;
        public static final int WIND_FIELD_DUNGEON_SETTLE_INFO_FIELD_NUMBER = 1009;
        public static final int EFFIGY_CHALLENGE_V2SETTLE_INFO_FIELD_NUMBER = 1839;
        public static final int TEAM_CHAIN_SETTLE_INFO_FIELD_NUMBER = 1320;
        private byte memoizedIsInitialized;
        private static final DungeonSettleNotify DEFAULT_INSTANCE = new DungeonSettleNotify();
        private static final Parser<DungeonSettleNotify> PARSER = new AbstractParser<DungeonSettleNotify>() { // from class: emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotify.1
            @Override // com.google.protobuf.Parser
            public DungeonSettleNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DungeonSettleNotify(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotify.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 1: goto L_0x0021;
                    case 14: goto L_0x001c;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSettleShow()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetStrengthenPointDataMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotify.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private DungeonSettleNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.detailCase_ = 0;
            this.failCondListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private DungeonSettleNotify() {
            this.detailCase_ = 0;
            this.failCondListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.exhibitionInfoList_ = Collections.emptyList();
            this.failCondList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DungeonSettleNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:178:0x058c */
        private DungeonSettleNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.strengthenPointDataMap_ = MapField.newMapField(StrengthenPointDataMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, StrengthenPointDataOuterClass.StrengthenPointData> strengthenPointDataMap__ = (MapEntry) input.readMessage(StrengthenPointDataMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.strengthenPointDataMap_.getMutableMap().put(strengthenPointDataMap__.getKey(), strengthenPointDataMap__.getValue());
                                break;
                            case 16:
                                this.useTime_ = input.readUInt32();
                                break;
                            case 32:
                                this.isSuccess_ = input.readBool();
                                break;
                            case 48:
                                this.closeTime_ = input.readUInt32();
                                break;
                            case 56:
                                this.dungeonId_ = input.readUInt32();
                                break;
                            case 64:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.failCondList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.failCondList_.addInt(input.readUInt32());
                                break;
                            case 66:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.failCondList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.failCondList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 72:
                                this.createPlayerUid_ = input.readUInt32();
                                break;
                            case 98:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.exhibitionInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.exhibitionInfoList_.add((DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo) input.readMessage(DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo.parser(), extensionRegistry));
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.settleShow_ = MapField.newMapField(SettleShowDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, ParamListOuterClass.ParamList> settleShow__ = (MapEntry) input.readMessage(SettleShowDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.settleShow_.getMutableMap().put(settleShow__.getKey(), settleShow__.getValue());
                                break;
                            case 120:
                                this.result_ = input.readUInt32();
                                break;
                            case PacketOpcodes.GetActivityShopSheetInfoRsp:
                                SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.Builder subBuilder = this.detailCase_ == 96 ? ((SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo) this.detail_);
                                    this.detail_ = subBuilder.buildPartial();
                                }
                                this.detailCase_ = 96;
                                break;
                            case 2250:
                                TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.Builder subBuilder2 = this.detailCase_ == 281 ? ((TowerLevelEndNotifyOuterClass.TowerLevelEndNotify) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((TowerLevelEndNotifyOuterClass.TowerLevelEndNotify) this.detail_);
                                    this.detail_ = subBuilder2.buildPartial();
                                }
                                this.detailCase_ = 281;
                                break;
                            case 5026:
                                CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.Builder subBuilder3 = this.detailCase_ == 628 ? ((CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.parser(), extensionRegistry);
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo) this.detail_);
                                    this.detail_ = subBuilder3.buildPartial();
                                }
                                this.detailCase_ = 628;
                                break;
                            case 6394:
                                RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.Builder subBuilder4 = this.detailCase_ == 799 ? ((RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.parser(), extensionRegistry);
                                if (subBuilder4 != null) {
                                    subBuilder4.mergeFrom((RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo) this.detail_);
                                    this.detail_ = subBuilder4.buildPartial();
                                }
                                this.detailCase_ = 799;
                                break;
                            case 7642:
                                EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.Builder subBuilder5 = this.detailCase_ == 955 ? ((EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.parser(), extensionRegistry);
                                if (subBuilder5 != null) {
                                    subBuilder5.mergeFrom((EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_);
                                    this.detail_ = subBuilder5.buildPartial();
                                }
                                this.detailCase_ = 955;
                                break;
                            case PacketOpcodes.WinterCampTakeBattleRewardReq:
                                WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.Builder subBuilder6 = this.detailCase_ == 1009 ? ((WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.parser(), extensionRegistry);
                                if (subBuilder6 != null) {
                                    subBuilder6.mergeFrom((WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo) this.detail_);
                                    this.detail_ = subBuilder6.buildPartial();
                                }
                                this.detailCase_ = 1009;
                                break;
                            case 8362:
                                ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.Builder subBuilder7 = this.detailCase_ == 1045 ? ((ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.parser(), extensionRegistry);
                                if (subBuilder7 != null) {
                                    subBuilder7.mergeFrom((ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_);
                                    this.detail_ = subBuilder7.buildPartial();
                                }
                                this.detailCase_ = CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER;
                                break;
                            case 10562:
                                TeamChainSettleInfoOuterClass.TeamChainSettleInfo.Builder subBuilder8 = this.detailCase_ == 1320 ? ((TeamChainSettleInfoOuterClass.TeamChainSettleInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(TeamChainSettleInfoOuterClass.TeamChainSettleInfo.parser(), extensionRegistry);
                                if (subBuilder8 != null) {
                                    subBuilder8.mergeFrom((TeamChainSettleInfoOuterClass.TeamChainSettleInfo) this.detail_);
                                    this.detail_ = subBuilder8.buildPartial();
                                }
                                this.detailCase_ = 1320;
                                break;
                            case 13898:
                                TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.Builder subBuilder9 = this.detailCase_ == 1737 ? ((TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.parser(), extensionRegistry);
                                if (subBuilder9 != null) {
                                    subBuilder9.mergeFrom((TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify) this.detail_);
                                    this.detail_ = subBuilder9.buildPartial();
                                }
                                this.detailCase_ = TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY_FIELD_NUMBER;
                                break;
                            case 14378:
                                InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo.Builder subBuilder10 = this.detailCase_ == 1797 ? ((InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo.parser(), extensionRegistry);
                                if (subBuilder10 != null) {
                                    subBuilder10.mergeFrom((InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo) this.detail_);
                                    this.detail_ = subBuilder10.buildPartial();
                                }
                                this.detailCase_ = 1797;
                                break;
                            case 14714:
                                EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.Builder subBuilder11 = this.detailCase_ == 1839 ? ((EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.parser(), extensionRegistry);
                                if (subBuilder11 != null) {
                                    subBuilder11.mergeFrom((EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo) this.detail_);
                                    this.detail_ = subBuilder11.buildPartial();
                                }
                                this.detailCase_ = EFFIGY_CHALLENGE_V2SETTLE_INFO_FIELD_NUMBER;
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
                    this.failCondList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.exhibitionInfoList_ = Collections.unmodifiableList(this.exhibitionInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DungeonSettleNotifyOuterClass.internal_static_DungeonSettleNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DungeonSettleNotifyOuterClass.internal_static_DungeonSettleNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonSettleNotify.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSettleNotifyOuterClass$DungeonSettleNotify$DetailCase.class */
        public enum DetailCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            TOWER_LEVEL_END_NOTIFY(281),
            TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY(DungeonSettleNotify.TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY_FIELD_NUMBER),
            CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO(DungeonSettleNotify.CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER),
            EFFIGY_CHALLENGE_DUNGEON_RESULT_INFO(955),
            ROGUELIKE_DUNGEON_SETTLE_INFO(799),
            CRYSTAL_LINK_SETTLE_INFO(628),
            SUMMER_TIME_V2DUNGEON_SETTLE_INFO(96),
            INSTABLE_SPRAY_SETTLE_INFO(1797),
            WIND_FIELD_DUNGEON_SETTLE_INFO(1009),
            EFFIGY_CHALLENGE_V2SETTLE_INFO(DungeonSettleNotify.EFFIGY_CHALLENGE_V2SETTLE_INFO_FIELD_NUMBER),
            TEAM_CHAIN_SETTLE_INFO(1320),
            DETAIL_NOT_SET(0);
            
            private final int value;

            DetailCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static DetailCase valueOf(int value) {
                return forNumber(value);
            }

            public static DetailCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return DETAIL_NOT_SET;
                    case 96:
                        return SUMMER_TIME_V2DUNGEON_SETTLE_INFO;
                    case 281:
                        return TOWER_LEVEL_END_NOTIFY;
                    case 628:
                        return CRYSTAL_LINK_SETTLE_INFO;
                    case 799:
                        return ROGUELIKE_DUNGEON_SETTLE_INFO;
                    case 955:
                        return EFFIGY_CHALLENGE_DUNGEON_RESULT_INFO;
                    case 1009:
                        return WIND_FIELD_DUNGEON_SETTLE_INFO;
                    case DungeonSettleNotify.CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER /* 1045 */:
                        return CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO;
                    case 1320:
                        return TEAM_CHAIN_SETTLE_INFO;
                    case DungeonSettleNotify.TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY_FIELD_NUMBER /* 1737 */:
                        return TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY;
                    case 1797:
                        return INSTABLE_SPRAY_SETTLE_INFO;
                    case DungeonSettleNotify.EFFIGY_CHALLENGE_V2SETTLE_INFO_FIELD_NUMBER /* 1839 */:
                        return EFFIGY_CHALLENGE_V2SETTLE_INFO;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public DetailCase getDetailCase() {
            return DetailCase.forNumber(this.detailCase_);
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public List<DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo> getExhibitionInfoListList() {
            return this.exhibitionInfoList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public List<? extends DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder> getExhibitionInfoListOrBuilderList() {
            return this.exhibitionInfoList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public int getExhibitionInfoListCount() {
            return this.exhibitionInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo getExhibitionInfoList(int index) {
            return this.exhibitionInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder getExhibitionInfoListOrBuilder(int index) {
            return this.exhibitionInfoList_.get(index);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSettleNotifyOuterClass$DungeonSettleNotify$SettleShowDefaultEntryHolder.class */
        public static final class SettleShowDefaultEntryHolder {
            static final MapEntry<Integer, ParamListOuterClass.ParamList> defaultEntry = MapEntry.newDefaultInstance(DungeonSettleNotifyOuterClass.internal_static_DungeonSettleNotify_SettleShowEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, ParamListOuterClass.ParamList.getDefaultInstance());

            private SettleShowDefaultEntryHolder() {
            }
        }

        private MapField<Integer, ParamListOuterClass.ParamList> internalGetSettleShow() {
            if (this.settleShow_ == null) {
                return MapField.emptyMapField(SettleShowDefaultEntryHolder.defaultEntry);
            }
            return this.settleShow_;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public int getSettleShowCount() {
            return internalGetSettleShow().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public boolean containsSettleShow(int key) {
            return internalGetSettleShow().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        @Deprecated
        public Map<Integer, ParamListOuterClass.ParamList> getSettleShow() {
            return getSettleShowMap();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public Map<Integer, ParamListOuterClass.ParamList> getSettleShowMap() {
            return internalGetSettleShow().getMap();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public ParamListOuterClass.ParamList getSettleShowOrDefault(int key, ParamListOuterClass.ParamList defaultValue) {
            Map<Integer, ParamListOuterClass.ParamList> map = internalGetSettleShow().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public ParamListOuterClass.ParamList getSettleShowOrThrow(int key) {
            Map<Integer, ParamListOuterClass.ParamList> map = internalGetSettleShow().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSettleNotifyOuterClass$DungeonSettleNotify$StrengthenPointDataMapDefaultEntryHolder.class */
        public static final class StrengthenPointDataMapDefaultEntryHolder {
            static final MapEntry<Integer, StrengthenPointDataOuterClass.StrengthenPointData> defaultEntry = MapEntry.newDefaultInstance(DungeonSettleNotifyOuterClass.f687xa24d79a8, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, StrengthenPointDataOuterClass.StrengthenPointData.getDefaultInstance());

            private StrengthenPointDataMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, StrengthenPointDataOuterClass.StrengthenPointData> internalGetStrengthenPointDataMap() {
            if (this.strengthenPointDataMap_ == null) {
                return MapField.emptyMapField(StrengthenPointDataMapDefaultEntryHolder.defaultEntry);
            }
            return this.strengthenPointDataMap_;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public int getStrengthenPointDataMapCount() {
            return internalGetStrengthenPointDataMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public boolean containsStrengthenPointDataMap(int key) {
            return internalGetStrengthenPointDataMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        @Deprecated
        public Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> getStrengthenPointDataMap() {
            return getStrengthenPointDataMapMap();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> getStrengthenPointDataMapMap() {
            return internalGetStrengthenPointDataMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public StrengthenPointDataOuterClass.StrengthenPointData getStrengthenPointDataMapOrDefault(int key, StrengthenPointDataOuterClass.StrengthenPointData defaultValue) {
            Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> map = internalGetStrengthenPointDataMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public StrengthenPointDataOuterClass.StrengthenPointData getStrengthenPointDataMapOrThrow(int key) {
            Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> map = internalGetStrengthenPointDataMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public int getResult() {
            return this.result_;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public int getUseTime() {
            return this.useTime_;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public int getDungeonId() {
            return this.dungeonId_;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public List<Integer> getFailCondListList() {
            return this.failCondList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public int getFailCondListCount() {
            return this.failCondList_.size();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public int getFailCondList(int index) {
            return this.failCondList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public int getCreatePlayerUid() {
            return this.createPlayerUid_;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public boolean getIsSuccess() {
            return this.isSuccess_;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public int getCloseTime() {
            return this.closeTime_;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public boolean hasTowerLevelEndNotify() {
            return this.detailCase_ == 281;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public TowerLevelEndNotifyOuterClass.TowerLevelEndNotify getTowerLevelEndNotify() {
            if (this.detailCase_ == 281) {
                return (TowerLevelEndNotifyOuterClass.TowerLevelEndNotify) this.detail_;
            }
            return TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder getTowerLevelEndNotifyOrBuilder() {
            if (this.detailCase_ == 281) {
                return (TowerLevelEndNotifyOuterClass.TowerLevelEndNotify) this.detail_;
            }
            return TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public boolean hasTrialAvatarFirstPassDungeonNotify() {
            return this.detailCase_ == 1737;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify getTrialAvatarFirstPassDungeonNotify() {
            if (this.detailCase_ == 1737) {
                return (TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify) this.detail_;
            }
            return TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotifyOrBuilder getTrialAvatarFirstPassDungeonNotifyOrBuilder() {
            if (this.detailCase_ == 1737) {
                return (TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify) this.detail_;
            }
            return TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public boolean hasChannellerSlabLoopDungeonResultInfo() {
            return this.detailCase_ == 1045;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo getChannellerSlabLoopDungeonResultInfo() {
            if (this.detailCase_ == 1045) {
                return (ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_;
            }
            return ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder getChannellerSlabLoopDungeonResultInfoOrBuilder() {
            if (this.detailCase_ == 1045) {
                return (ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_;
            }
            return ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public boolean hasEffigyChallengeDungeonResultInfo() {
            return this.detailCase_ == 955;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo getEffigyChallengeDungeonResultInfo() {
            if (this.detailCase_ == 955) {
                return (EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_;
            }
            return EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder getEffigyChallengeDungeonResultInfoOrBuilder() {
            if (this.detailCase_ == 955) {
                return (EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_;
            }
            return EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public boolean hasRoguelikeDungeonSettleInfo() {
            return this.detailCase_ == 799;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo getRoguelikeDungeonSettleInfo() {
            if (this.detailCase_ == 799) {
                return (RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo) this.detail_;
            }
            return RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder getRoguelikeDungeonSettleInfoOrBuilder() {
            if (this.detailCase_ == 799) {
                return (RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo) this.detail_;
            }
            return RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public boolean hasCrystalLinkSettleInfo() {
            return this.detailCase_ == 628;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo getCrystalLinkSettleInfo() {
            if (this.detailCase_ == 628) {
                return (CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo) this.detail_;
            }
            return CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder getCrystalLinkSettleInfoOrBuilder() {
            if (this.detailCase_ == 628) {
                return (CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo) this.detail_;
            }
            return CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public boolean hasSummerTimeV2DungeonSettleInfo() {
            return this.detailCase_ == 96;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo getSummerTimeV2DungeonSettleInfo() {
            if (this.detailCase_ == 96) {
                return (SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo) this.detail_;
            }
            return SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfoOrBuilder getSummerTimeV2DungeonSettleInfoOrBuilder() {
            if (this.detailCase_ == 96) {
                return (SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo) this.detail_;
            }
            return SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public boolean hasInstableSpraySettleInfo() {
            return this.detailCase_ == 1797;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo getInstableSpraySettleInfo() {
            if (this.detailCase_ == 1797) {
                return (InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo) this.detail_;
            }
            return InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public InstableSpraySettleInfoOuterClass.InstableSpraySettleInfoOrBuilder getInstableSpraySettleInfoOrBuilder() {
            if (this.detailCase_ == 1797) {
                return (InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo) this.detail_;
            }
            return InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public boolean hasWindFieldDungeonSettleInfo() {
            return this.detailCase_ == 1009;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo getWindFieldDungeonSettleInfo() {
            if (this.detailCase_ == 1009) {
                return (WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo) this.detail_;
            }
            return WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder getWindFieldDungeonSettleInfoOrBuilder() {
            if (this.detailCase_ == 1009) {
                return (WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo) this.detail_;
            }
            return WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public boolean hasEffigyChallengeV2SettleInfo() {
            return this.detailCase_ == 1839;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo getEffigyChallengeV2SettleInfo() {
            if (this.detailCase_ == 1839) {
                return (EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo) this.detail_;
            }
            return EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder getEffigyChallengeV2SettleInfoOrBuilder() {
            if (this.detailCase_ == 1839) {
                return (EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo) this.detail_;
            }
            return EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public boolean hasTeamChainSettleInfo() {
            return this.detailCase_ == 1320;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public TeamChainSettleInfoOuterClass.TeamChainSettleInfo getTeamChainSettleInfo() {
            if (this.detailCase_ == 1320) {
                return (TeamChainSettleInfoOuterClass.TeamChainSettleInfo) this.detail_;
            }
            return TeamChainSettleInfoOuterClass.TeamChainSettleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
        public TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder getTeamChainSettleInfoOrBuilder() {
            if (this.detailCase_ == 1320) {
                return (TeamChainSettleInfoOuterClass.TeamChainSettleInfo) this.detail_;
            }
            return TeamChainSettleInfoOuterClass.TeamChainSettleInfo.getDefaultInstance();
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetStrengthenPointDataMap(), StrengthenPointDataMapDefaultEntryHolder.defaultEntry, 1);
            if (this.useTime_ != 0) {
                output.writeUInt32(2, this.useTime_);
            }
            if (this.isSuccess_) {
                output.writeBool(4, this.isSuccess_);
            }
            if (this.closeTime_ != 0) {
                output.writeUInt32(6, this.closeTime_);
            }
            if (this.dungeonId_ != 0) {
                output.writeUInt32(7, this.dungeonId_);
            }
            if (getFailCondListList().size() > 0) {
                output.writeUInt32NoTag(66);
                output.writeUInt32NoTag(this.failCondListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.failCondList_.size(); i++) {
                output.writeUInt32NoTag(this.failCondList_.getInt(i));
            }
            if (this.createPlayerUid_ != 0) {
                output.writeUInt32(9, this.createPlayerUid_);
            }
            for (int i2 = 0; i2 < this.exhibitionInfoList_.size(); i2++) {
                output.writeMessage(12, this.exhibitionInfoList_.get(i2));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSettleShow(), SettleShowDefaultEntryHolder.defaultEntry, 14);
            if (this.result_ != 0) {
                output.writeUInt32(15, this.result_);
            }
            if (this.detailCase_ == 96) {
                output.writeMessage(96, (SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo) this.detail_);
            }
            if (this.detailCase_ == 281) {
                output.writeMessage(281, (TowerLevelEndNotifyOuterClass.TowerLevelEndNotify) this.detail_);
            }
            if (this.detailCase_ == 628) {
                output.writeMessage(628, (CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo) this.detail_);
            }
            if (this.detailCase_ == 799) {
                output.writeMessage(799, (RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo) this.detail_);
            }
            if (this.detailCase_ == 955) {
                output.writeMessage(955, (EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_);
            }
            if (this.detailCase_ == 1009) {
                output.writeMessage(1009, (WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo) this.detail_);
            }
            if (this.detailCase_ == 1045) {
                output.writeMessage(CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER, (ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_);
            }
            if (this.detailCase_ == 1320) {
                output.writeMessage(1320, (TeamChainSettleInfoOuterClass.TeamChainSettleInfo) this.detail_);
            }
            if (this.detailCase_ == 1737) {
                output.writeMessage(TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY_FIELD_NUMBER, (TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify) this.detail_);
            }
            if (this.detailCase_ == 1797) {
                output.writeMessage(1797, (InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo) this.detail_);
            }
            if (this.detailCase_ == 1839) {
                output.writeMessage(EFFIGY_CHALLENGE_V2SETTLE_INFO_FIELD_NUMBER, (EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo) this.detail_);
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
            for (Map.Entry<Integer, StrengthenPointDataOuterClass.StrengthenPointData> entry : internalGetStrengthenPointDataMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(1, StrengthenPointDataMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.useTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.useTime_);
            }
            if (this.isSuccess_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isSuccess_);
            }
            if (this.closeTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.closeTime_);
            }
            if (this.dungeonId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.dungeonId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.failCondList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.failCondList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getFailCondListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.failCondListMemoizedSerializedSize = dataSize;
            if (this.createPlayerUid_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(9, this.createPlayerUid_);
            }
            for (int i2 = 0; i2 < this.exhibitionInfoList_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(12, this.exhibitionInfoList_.get(i2));
            }
            for (Map.Entry<Integer, ParamListOuterClass.ParamList> entry2 : internalGetSettleShow().getMap().entrySet()) {
                size3 += CodedOutputStream.computeMessageSize(14, SettleShowDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (this.result_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(15, this.result_);
            }
            if (this.detailCase_ == 96) {
                size3 += CodedOutputStream.computeMessageSize(96, (SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo) this.detail_);
            }
            if (this.detailCase_ == 281) {
                size3 += CodedOutputStream.computeMessageSize(281, (TowerLevelEndNotifyOuterClass.TowerLevelEndNotify) this.detail_);
            }
            if (this.detailCase_ == 628) {
                size3 += CodedOutputStream.computeMessageSize(628, (CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo) this.detail_);
            }
            if (this.detailCase_ == 799) {
                size3 += CodedOutputStream.computeMessageSize(799, (RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo) this.detail_);
            }
            if (this.detailCase_ == 955) {
                size3 += CodedOutputStream.computeMessageSize(955, (EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_);
            }
            if (this.detailCase_ == 1009) {
                size3 += CodedOutputStream.computeMessageSize(1009, (WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo) this.detail_);
            }
            if (this.detailCase_ == 1045) {
                size3 += CodedOutputStream.computeMessageSize(CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER, (ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_);
            }
            if (this.detailCase_ == 1320) {
                size3 += CodedOutputStream.computeMessageSize(1320, (TeamChainSettleInfoOuterClass.TeamChainSettleInfo) this.detail_);
            }
            if (this.detailCase_ == 1737) {
                size3 += CodedOutputStream.computeMessageSize(TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY_FIELD_NUMBER, (TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify) this.detail_);
            }
            if (this.detailCase_ == 1797) {
                size3 += CodedOutputStream.computeMessageSize(1797, (InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo) this.detail_);
            }
            if (this.detailCase_ == 1839) {
                size3 += CodedOutputStream.computeMessageSize(EFFIGY_CHALLENGE_V2SETTLE_INFO_FIELD_NUMBER, (EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo) this.detail_);
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
            if (!(obj instanceof DungeonSettleNotify)) {
                return equals(obj);
            }
            DungeonSettleNotify other = (DungeonSettleNotify) obj;
            if (!getExhibitionInfoListList().equals(other.getExhibitionInfoListList()) || !internalGetSettleShow().equals(other.internalGetSettleShow()) || !internalGetStrengthenPointDataMap().equals(other.internalGetStrengthenPointDataMap()) || getResult() != other.getResult() || getUseTime() != other.getUseTime() || getDungeonId() != other.getDungeonId() || !getFailCondListList().equals(other.getFailCondListList()) || getCreatePlayerUid() != other.getCreatePlayerUid() || getIsSuccess() != other.getIsSuccess() || getCloseTime() != other.getCloseTime() || !getDetailCase().equals(other.getDetailCase())) {
                return false;
            }
            switch (this.detailCase_) {
                case 96:
                    if (!getSummerTimeV2DungeonSettleInfo().equals(other.getSummerTimeV2DungeonSettleInfo())) {
                        return false;
                    }
                    break;
                case 281:
                    if (!getTowerLevelEndNotify().equals(other.getTowerLevelEndNotify())) {
                        return false;
                    }
                    break;
                case 628:
                    if (!getCrystalLinkSettleInfo().equals(other.getCrystalLinkSettleInfo())) {
                        return false;
                    }
                    break;
                case 799:
                    if (!getRoguelikeDungeonSettleInfo().equals(other.getRoguelikeDungeonSettleInfo())) {
                        return false;
                    }
                    break;
                case 955:
                    if (!getEffigyChallengeDungeonResultInfo().equals(other.getEffigyChallengeDungeonResultInfo())) {
                        return false;
                    }
                    break;
                case 1009:
                    if (!getWindFieldDungeonSettleInfo().equals(other.getWindFieldDungeonSettleInfo())) {
                        return false;
                    }
                    break;
                case CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER /* 1045 */:
                    if (!getChannellerSlabLoopDungeonResultInfo().equals(other.getChannellerSlabLoopDungeonResultInfo())) {
                        return false;
                    }
                    break;
                case 1320:
                    if (!getTeamChainSettleInfo().equals(other.getTeamChainSettleInfo())) {
                        return false;
                    }
                    break;
                case TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY_FIELD_NUMBER /* 1737 */:
                    if (!getTrialAvatarFirstPassDungeonNotify().equals(other.getTrialAvatarFirstPassDungeonNotify())) {
                        return false;
                    }
                    break;
                case 1797:
                    if (!getInstableSpraySettleInfo().equals(other.getInstableSpraySettleInfo())) {
                        return false;
                    }
                    break;
                case EFFIGY_CHALLENGE_V2SETTLE_INFO_FIELD_NUMBER /* 1839 */:
                    if (!getEffigyChallengeV2SettleInfo().equals(other.getEffigyChallengeV2SettleInfo())) {
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
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getExhibitionInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getExhibitionInfoListList().hashCode();
            }
            if (!internalGetSettleShow().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 14)) + internalGetSettleShow().hashCode();
            }
            if (!internalGetStrengthenPointDataMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 1)) + internalGetStrengthenPointDataMap().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 15)) + getResult())) + 2)) + getUseTime())) + 7)) + getDungeonId();
            if (getFailCondListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 8)) + getFailCondListList().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 9)) + getCreatePlayerUid())) + 4)) + Internal.hashBoolean(getIsSuccess()))) + 6)) + getCloseTime();
            switch (this.detailCase_) {
                case 96:
                    hash3 = (53 * ((37 * hash3) + 96)) + getSummerTimeV2DungeonSettleInfo().hashCode();
                    break;
                case 281:
                    hash3 = (53 * ((37 * hash3) + 281)) + getTowerLevelEndNotify().hashCode();
                    break;
                case 628:
                    hash3 = (53 * ((37 * hash3) + 628)) + getCrystalLinkSettleInfo().hashCode();
                    break;
                case 799:
                    hash3 = (53 * ((37 * hash3) + 799)) + getRoguelikeDungeonSettleInfo().hashCode();
                    break;
                case 955:
                    hash3 = (53 * ((37 * hash3) + 955)) + getEffigyChallengeDungeonResultInfo().hashCode();
                    break;
                case 1009:
                    hash3 = (53 * ((37 * hash3) + 1009)) + getWindFieldDungeonSettleInfo().hashCode();
                    break;
                case CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER /* 1045 */:
                    hash3 = (53 * ((37 * hash3) + CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER)) + getChannellerSlabLoopDungeonResultInfo().hashCode();
                    break;
                case 1320:
                    hash3 = (53 * ((37 * hash3) + 1320)) + getTeamChainSettleInfo().hashCode();
                    break;
                case TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY_FIELD_NUMBER /* 1737 */:
                    hash3 = (53 * ((37 * hash3) + TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY_FIELD_NUMBER)) + getTrialAvatarFirstPassDungeonNotify().hashCode();
                    break;
                case 1797:
                    hash3 = (53 * ((37 * hash3) + 1797)) + getInstableSpraySettleInfo().hashCode();
                    break;
                case EFFIGY_CHALLENGE_V2SETTLE_INFO_FIELD_NUMBER /* 1839 */:
                    hash3 = (53 * ((37 * hash3) + EFFIGY_CHALLENGE_V2SETTLE_INFO_FIELD_NUMBER)) + getEffigyChallengeV2SettleInfo().hashCode();
                    break;
            }
            int hash4 = (29 * hash3) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static DungeonSettleNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonSettleNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonSettleNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonSettleNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonSettleNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonSettleNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonSettleNotify parseFrom(InputStream input) throws IOException {
            return (DungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonSettleNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonSettleNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (DungeonSettleNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DungeonSettleNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonSettleNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonSettleNotify parseFrom(CodedInputStream input) throws IOException {
            return (DungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonSettleNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DungeonSettleNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSettleNotifyOuterClass$DungeonSettleNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DungeonSettleNotifyOrBuilder {
            private Object detail_;
            private int bitField0_;
            private RepeatedFieldBuilderV3<DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo, DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo.Builder, DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder> exhibitionInfoListBuilder_;
            private MapField<Integer, ParamListOuterClass.ParamList> settleShow_;
            private MapField<Integer, StrengthenPointDataOuterClass.StrengthenPointData> strengthenPointDataMap_;
            private int result_;
            private int useTime_;
            private int dungeonId_;
            private int createPlayerUid_;
            private boolean isSuccess_;
            private int closeTime_;
            private SingleFieldBuilderV3<TowerLevelEndNotifyOuterClass.TowerLevelEndNotify, TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.Builder, TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder> towerLevelEndNotifyBuilder_;
            private SingleFieldBuilderV3<TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify, TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.Builder, TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotifyOrBuilder> trialAvatarFirstPassDungeonNotifyBuilder_;
            private SingleFieldBuilderV3<ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo, ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.Builder, ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder> channellerSlabLoopDungeonResultInfoBuilder_;
            private SingleFieldBuilderV3<EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo, EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.Builder, EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder> effigyChallengeDungeonResultInfoBuilder_;
            private SingleFieldBuilderV3<RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo, RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.Builder, RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder> roguelikeDungeonSettleInfoBuilder_;
            private SingleFieldBuilderV3<CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo, CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.Builder, CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder> crystalLinkSettleInfoBuilder_;
            private SingleFieldBuilderV3<SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo, SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.Builder, SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfoOrBuilder> summerTimeV2DungeonSettleInfoBuilder_;
            private SingleFieldBuilderV3<InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo, InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo.Builder, InstableSpraySettleInfoOuterClass.InstableSpraySettleInfoOrBuilder> instableSpraySettleInfoBuilder_;
            private SingleFieldBuilderV3<WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo, WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.Builder, WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder> windFieldDungeonSettleInfoBuilder_;
            private SingleFieldBuilderV3<EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo, EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.Builder, EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder> effigyChallengeV2SettleInfoBuilder_;
            private SingleFieldBuilderV3<TeamChainSettleInfoOuterClass.TeamChainSettleInfo, TeamChainSettleInfoOuterClass.TeamChainSettleInfo.Builder, TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder> teamChainSettleInfoBuilder_;
            private int detailCase_ = 0;
            private List<DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo> exhibitionInfoList_ = Collections.emptyList();
            private Internal.IntList failCondList_ = DungeonSettleNotify.emptyIntList();

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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 1: goto L_0x0021;
                        case 14: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSettleShow()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetStrengthenPointDataMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 1: goto L_0x0021;
                        case 14: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSettleShow()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableStrengthenPointDataMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return DungeonSettleNotifyOuterClass.internal_static_DungeonSettleNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DungeonSettleNotifyOuterClass.internal_static_DungeonSettleNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonSettleNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DungeonSettleNotify.alwaysUseFieldBuilders) {
                    getExhibitionInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.exhibitionInfoListBuilder_ == null) {
                    this.exhibitionInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.exhibitionInfoListBuilder_.clear();
                }
                internalGetMutableSettleShow().clear();
                internalGetMutableStrengthenPointDataMap().clear();
                this.result_ = 0;
                this.useTime_ = 0;
                this.dungeonId_ = 0;
                this.failCondList_ = DungeonSettleNotify.emptyIntList();
                this.bitField0_ &= -9;
                this.createPlayerUid_ = 0;
                this.isSuccess_ = false;
                this.closeTime_ = 0;
                this.detailCase_ = 0;
                this.detail_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DungeonSettleNotifyOuterClass.internal_static_DungeonSettleNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DungeonSettleNotify getDefaultInstanceForType() {
                return DungeonSettleNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonSettleNotify build() {
                DungeonSettleNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonSettleNotify buildPartial() {
                DungeonSettleNotify result = new DungeonSettleNotify(this);
                int i = this.bitField0_;
                if (this.exhibitionInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.exhibitionInfoList_ = Collections.unmodifiableList(this.exhibitionInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.exhibitionInfoList_ = this.exhibitionInfoList_;
                } else {
                    result.exhibitionInfoList_ = this.exhibitionInfoListBuilder_.build();
                }
                result.settleShow_ = internalGetSettleShow();
                result.settleShow_.makeImmutable();
                result.strengthenPointDataMap_ = internalGetStrengthenPointDataMap();
                result.strengthenPointDataMap_.makeImmutable();
                result.result_ = this.result_;
                result.useTime_ = this.useTime_;
                result.dungeonId_ = this.dungeonId_;
                if ((this.bitField0_ & 8) != 0) {
                    this.failCondList_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                result.failCondList_ = this.failCondList_;
                result.createPlayerUid_ = this.createPlayerUid_;
                result.isSuccess_ = this.isSuccess_;
                result.closeTime_ = this.closeTime_;
                if (this.detailCase_ == 281) {
                    if (this.towerLevelEndNotifyBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.towerLevelEndNotifyBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1737) {
                    if (this.trialAvatarFirstPassDungeonNotifyBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.trialAvatarFirstPassDungeonNotifyBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1045) {
                    if (this.channellerSlabLoopDungeonResultInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.channellerSlabLoopDungeonResultInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 955) {
                    if (this.effigyChallengeDungeonResultInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.effigyChallengeDungeonResultInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 799) {
                    if (this.roguelikeDungeonSettleInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.roguelikeDungeonSettleInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 628) {
                    if (this.crystalLinkSettleInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.crystalLinkSettleInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 96) {
                    if (this.summerTimeV2DungeonSettleInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.summerTimeV2DungeonSettleInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1797) {
                    if (this.instableSpraySettleInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.instableSpraySettleInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1009) {
                    if (this.windFieldDungeonSettleInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.windFieldDungeonSettleInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1839) {
                    if (this.effigyChallengeV2SettleInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.effigyChallengeV2SettleInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1320) {
                    if (this.teamChainSettleInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.teamChainSettleInfoBuilder_.build();
                    }
                }
                result.detailCase_ = this.detailCase_;
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
                if (other instanceof DungeonSettleNotify) {
                    return mergeFrom((DungeonSettleNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DungeonSettleNotify other) {
                if (other == DungeonSettleNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.exhibitionInfoListBuilder_ == null) {
                    if (!other.exhibitionInfoList_.isEmpty()) {
                        if (this.exhibitionInfoList_.isEmpty()) {
                            this.exhibitionInfoList_ = other.exhibitionInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureExhibitionInfoListIsMutable();
                            this.exhibitionInfoList_.addAll(other.exhibitionInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.exhibitionInfoList_.isEmpty()) {
                    if (this.exhibitionInfoListBuilder_.isEmpty()) {
                        this.exhibitionInfoListBuilder_.dispose();
                        this.exhibitionInfoListBuilder_ = null;
                        this.exhibitionInfoList_ = other.exhibitionInfoList_;
                        this.bitField0_ &= -2;
                        this.exhibitionInfoListBuilder_ = DungeonSettleNotify.alwaysUseFieldBuilders ? getExhibitionInfoListFieldBuilder() : null;
                    } else {
                        this.exhibitionInfoListBuilder_.addAllMessages(other.exhibitionInfoList_);
                    }
                }
                internalGetMutableSettleShow().mergeFrom(other.internalGetSettleShow());
                internalGetMutableStrengthenPointDataMap().mergeFrom(other.internalGetStrengthenPointDataMap());
                if (other.getResult() != 0) {
                    setResult(other.getResult());
                }
                if (other.getUseTime() != 0) {
                    setUseTime(other.getUseTime());
                }
                if (other.getDungeonId() != 0) {
                    setDungeonId(other.getDungeonId());
                }
                if (!other.failCondList_.isEmpty()) {
                    if (this.failCondList_.isEmpty()) {
                        this.failCondList_ = other.failCondList_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureFailCondListIsMutable();
                        this.failCondList_.addAll(other.failCondList_);
                    }
                    onChanged();
                }
                if (other.getCreatePlayerUid() != 0) {
                    setCreatePlayerUid(other.getCreatePlayerUid());
                }
                if (other.getIsSuccess()) {
                    setIsSuccess(other.getIsSuccess());
                }
                if (other.getCloseTime() != 0) {
                    setCloseTime(other.getCloseTime());
                }
                switch (other.getDetailCase()) {
                    case TOWER_LEVEL_END_NOTIFY:
                        mergeTowerLevelEndNotify(other.getTowerLevelEndNotify());
                        break;
                    case TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY:
                        mergeTrialAvatarFirstPassDungeonNotify(other.getTrialAvatarFirstPassDungeonNotify());
                        break;
                    case CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO:
                        mergeChannellerSlabLoopDungeonResultInfo(other.getChannellerSlabLoopDungeonResultInfo());
                        break;
                    case EFFIGY_CHALLENGE_DUNGEON_RESULT_INFO:
                        mergeEffigyChallengeDungeonResultInfo(other.getEffigyChallengeDungeonResultInfo());
                        break;
                    case ROGUELIKE_DUNGEON_SETTLE_INFO:
                        mergeRoguelikeDungeonSettleInfo(other.getRoguelikeDungeonSettleInfo());
                        break;
                    case CRYSTAL_LINK_SETTLE_INFO:
                        mergeCrystalLinkSettleInfo(other.getCrystalLinkSettleInfo());
                        break;
                    case SUMMER_TIME_V2DUNGEON_SETTLE_INFO:
                        mergeSummerTimeV2DungeonSettleInfo(other.getSummerTimeV2DungeonSettleInfo());
                        break;
                    case INSTABLE_SPRAY_SETTLE_INFO:
                        mergeInstableSpraySettleInfo(other.getInstableSpraySettleInfo());
                        break;
                    case WIND_FIELD_DUNGEON_SETTLE_INFO:
                        mergeWindFieldDungeonSettleInfo(other.getWindFieldDungeonSettleInfo());
                        break;
                    case EFFIGY_CHALLENGE_V2SETTLE_INFO:
                        mergeEffigyChallengeV2SettleInfo(other.getEffigyChallengeV2SettleInfo());
                        break;
                    case TEAM_CHAIN_SETTLE_INFO:
                        mergeTeamChainSettleInfo(other.getTeamChainSettleInfo());
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
                DungeonSettleNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = DungeonSettleNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DungeonSettleNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public DetailCase getDetailCase() {
                return DetailCase.forNumber(this.detailCase_);
            }

            public Builder clearDetail() {
                this.detailCase_ = 0;
                this.detail_ = null;
                onChanged();
                return this;
            }

            private void ensureExhibitionInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.exhibitionInfoList_ = new ArrayList(this.exhibitionInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public List<DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo> getExhibitionInfoListList() {
                if (this.exhibitionInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.exhibitionInfoList_);
                }
                return this.exhibitionInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public int getExhibitionInfoListCount() {
                if (this.exhibitionInfoListBuilder_ == null) {
                    return this.exhibitionInfoList_.size();
                }
                return this.exhibitionInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo getExhibitionInfoList(int index) {
                if (this.exhibitionInfoListBuilder_ == null) {
                    return this.exhibitionInfoList_.get(index);
                }
                return this.exhibitionInfoListBuilder_.getMessage(index);
            }

            public Builder setExhibitionInfoList(int index, DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo value) {
                if (this.exhibitionInfoListBuilder_ != null) {
                    this.exhibitionInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExhibitionInfoListIsMutable();
                    this.exhibitionInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setExhibitionInfoList(int index, DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo.Builder builderForValue) {
                if (this.exhibitionInfoListBuilder_ == null) {
                    ensureExhibitionInfoListIsMutable();
                    this.exhibitionInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.exhibitionInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addExhibitionInfoList(DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo value) {
                if (this.exhibitionInfoListBuilder_ != null) {
                    this.exhibitionInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExhibitionInfoListIsMutable();
                    this.exhibitionInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addExhibitionInfoList(int index, DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo value) {
                if (this.exhibitionInfoListBuilder_ != null) {
                    this.exhibitionInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExhibitionInfoListIsMutable();
                    this.exhibitionInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addExhibitionInfoList(DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo.Builder builderForValue) {
                if (this.exhibitionInfoListBuilder_ == null) {
                    ensureExhibitionInfoListIsMutable();
                    this.exhibitionInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.exhibitionInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addExhibitionInfoList(int index, DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo.Builder builderForValue) {
                if (this.exhibitionInfoListBuilder_ == null) {
                    ensureExhibitionInfoListIsMutable();
                    this.exhibitionInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.exhibitionInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllExhibitionInfoList(Iterable<? extends DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo> values) {
                if (this.exhibitionInfoListBuilder_ == null) {
                    ensureExhibitionInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.exhibitionInfoList_);
                    onChanged();
                } else {
                    this.exhibitionInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearExhibitionInfoList() {
                if (this.exhibitionInfoListBuilder_ == null) {
                    this.exhibitionInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.exhibitionInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeExhibitionInfoList(int index) {
                if (this.exhibitionInfoListBuilder_ == null) {
                    ensureExhibitionInfoListIsMutable();
                    this.exhibitionInfoList_.remove(index);
                    onChanged();
                } else {
                    this.exhibitionInfoListBuilder_.remove(index);
                }
                return this;
            }

            public DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo.Builder getExhibitionInfoListBuilder(int index) {
                return getExhibitionInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder getExhibitionInfoListOrBuilder(int index) {
                if (this.exhibitionInfoListBuilder_ == null) {
                    return this.exhibitionInfoList_.get(index);
                }
                return this.exhibitionInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public List<? extends DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder> getExhibitionInfoListOrBuilderList() {
                if (this.exhibitionInfoListBuilder_ != null) {
                    return this.exhibitionInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.exhibitionInfoList_);
            }

            public DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo.Builder addExhibitionInfoListBuilder() {
                return getExhibitionInfoListFieldBuilder().addBuilder(DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo.getDefaultInstance());
            }

            public DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo.Builder addExhibitionInfoListBuilder(int index) {
                return getExhibitionInfoListFieldBuilder().addBuilder(index, DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo.getDefaultInstance());
            }

            public List<DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo.Builder> getExhibitionInfoListBuilderList() {
                return getExhibitionInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo, DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo.Builder, DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder> getExhibitionInfoListFieldBuilder() {
                if (this.exhibitionInfoListBuilder_ == null) {
                    this.exhibitionInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.exhibitionInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.exhibitionInfoList_ = null;
                }
                return this.exhibitionInfoListBuilder_;
            }

            private MapField<Integer, ParamListOuterClass.ParamList> internalGetSettleShow() {
                if (this.settleShow_ == null) {
                    return MapField.emptyMapField(SettleShowDefaultEntryHolder.defaultEntry);
                }
                return this.settleShow_;
            }

            private MapField<Integer, ParamListOuterClass.ParamList> internalGetMutableSettleShow() {
                onChanged();
                if (this.settleShow_ == null) {
                    this.settleShow_ = MapField.newMapField(SettleShowDefaultEntryHolder.defaultEntry);
                }
                if (!this.settleShow_.isMutable()) {
                    this.settleShow_ = this.settleShow_.copy();
                }
                return this.settleShow_;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public int getSettleShowCount() {
                return internalGetSettleShow().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public boolean containsSettleShow(int key) {
                return internalGetSettleShow().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            @Deprecated
            public Map<Integer, ParamListOuterClass.ParamList> getSettleShow() {
                return getSettleShowMap();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public Map<Integer, ParamListOuterClass.ParamList> getSettleShowMap() {
                return internalGetSettleShow().getMap();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public ParamListOuterClass.ParamList getSettleShowOrDefault(int key, ParamListOuterClass.ParamList defaultValue) {
                Map<Integer, ParamListOuterClass.ParamList> map = internalGetSettleShow().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public ParamListOuterClass.ParamList getSettleShowOrThrow(int key) {
                Map<Integer, ParamListOuterClass.ParamList> map = internalGetSettleShow().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSettleShow() {
                internalGetMutableSettleShow().getMutableMap().clear();
                return this;
            }

            public Builder removeSettleShow(int key) {
                internalGetMutableSettleShow().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, ParamListOuterClass.ParamList> getMutableSettleShow() {
                return internalGetMutableSettleShow().getMutableMap();
            }

            public Builder putSettleShow(int key, ParamListOuterClass.ParamList value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableSettleShow().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllSettleShow(Map<Integer, ParamListOuterClass.ParamList> values) {
                internalGetMutableSettleShow().getMutableMap().putAll(values);
                return this;
            }

            private MapField<Integer, StrengthenPointDataOuterClass.StrengthenPointData> internalGetStrengthenPointDataMap() {
                if (this.strengthenPointDataMap_ == null) {
                    return MapField.emptyMapField(StrengthenPointDataMapDefaultEntryHolder.defaultEntry);
                }
                return this.strengthenPointDataMap_;
            }

            private MapField<Integer, StrengthenPointDataOuterClass.StrengthenPointData> internalGetMutableStrengthenPointDataMap() {
                onChanged();
                if (this.strengthenPointDataMap_ == null) {
                    this.strengthenPointDataMap_ = MapField.newMapField(StrengthenPointDataMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.strengthenPointDataMap_.isMutable()) {
                    this.strengthenPointDataMap_ = this.strengthenPointDataMap_.copy();
                }
                return this.strengthenPointDataMap_;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public int getStrengthenPointDataMapCount() {
                return internalGetStrengthenPointDataMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public boolean containsStrengthenPointDataMap(int key) {
                return internalGetStrengthenPointDataMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            @Deprecated
            public Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> getStrengthenPointDataMap() {
                return getStrengthenPointDataMapMap();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> getStrengthenPointDataMapMap() {
                return internalGetStrengthenPointDataMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public StrengthenPointDataOuterClass.StrengthenPointData getStrengthenPointDataMapOrDefault(int key, StrengthenPointDataOuterClass.StrengthenPointData defaultValue) {
                Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> map = internalGetStrengthenPointDataMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public StrengthenPointDataOuterClass.StrengthenPointData getStrengthenPointDataMapOrThrow(int key) {
                Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> map = internalGetStrengthenPointDataMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearStrengthenPointDataMap() {
                internalGetMutableStrengthenPointDataMap().getMutableMap().clear();
                return this;
            }

            public Builder removeStrengthenPointDataMap(int key) {
                internalGetMutableStrengthenPointDataMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> getMutableStrengthenPointDataMap() {
                return internalGetMutableStrengthenPointDataMap().getMutableMap();
            }

            public Builder putStrengthenPointDataMap(int key, StrengthenPointDataOuterClass.StrengthenPointData value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableStrengthenPointDataMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllStrengthenPointDataMap(Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> values) {
                internalGetMutableStrengthenPointDataMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public int getResult() {
                return this.result_;
            }

            public Builder setResult(int value) {
                this.result_ = value;
                onChanged();
                return this;
            }

            public Builder clearResult() {
                this.result_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public int getUseTime() {
                return this.useTime_;
            }

            public Builder setUseTime(int value) {
                this.useTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearUseTime() {
                this.useTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public int getDungeonId() {
                return this.dungeonId_;
            }

            public Builder setDungeonId(int value) {
                this.dungeonId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDungeonId() {
                this.dungeonId_ = 0;
                onChanged();
                return this;
            }

            private void ensureFailCondListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.failCondList_ = DungeonSettleNotify.mutableCopy(this.failCondList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public List<Integer> getFailCondListList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.failCondList_) : this.failCondList_;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public int getFailCondListCount() {
                return this.failCondList_.size();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public int getFailCondList(int index) {
                return this.failCondList_.getInt(index);
            }

            public Builder setFailCondList(int index, int value) {
                ensureFailCondListIsMutable();
                this.failCondList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFailCondList(int value) {
                ensureFailCondListIsMutable();
                this.failCondList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFailCondList(Iterable<? extends Integer> values) {
                ensureFailCondListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.failCondList_);
                onChanged();
                return this;
            }

            public Builder clearFailCondList() {
                this.failCondList_ = DungeonSettleNotify.emptyIntList();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public int getCreatePlayerUid() {
                return this.createPlayerUid_;
            }

            public Builder setCreatePlayerUid(int value) {
                this.createPlayerUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearCreatePlayerUid() {
                this.createPlayerUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public boolean getIsSuccess() {
                return this.isSuccess_;
            }

            public Builder setIsSuccess(boolean value) {
                this.isSuccess_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSuccess() {
                this.isSuccess_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public int getCloseTime() {
                return this.closeTime_;
            }

            public Builder setCloseTime(int value) {
                this.closeTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearCloseTime() {
                this.closeTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public boolean hasTowerLevelEndNotify() {
                return this.detailCase_ == 281;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public TowerLevelEndNotifyOuterClass.TowerLevelEndNotify getTowerLevelEndNotify() {
                if (this.towerLevelEndNotifyBuilder_ == null) {
                    if (this.detailCase_ == 281) {
                        return (TowerLevelEndNotifyOuterClass.TowerLevelEndNotify) this.detail_;
                    }
                    return TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.getDefaultInstance();
                } else if (this.detailCase_ == 281) {
                    return this.towerLevelEndNotifyBuilder_.getMessage();
                } else {
                    return TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.getDefaultInstance();
                }
            }

            public Builder setTowerLevelEndNotify(TowerLevelEndNotifyOuterClass.TowerLevelEndNotify value) {
                if (this.towerLevelEndNotifyBuilder_ != null) {
                    this.towerLevelEndNotifyBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 281;
                return this;
            }

            public Builder setTowerLevelEndNotify(TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.Builder builderForValue) {
                if (this.towerLevelEndNotifyBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.towerLevelEndNotifyBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 281;
                return this;
            }

            public Builder mergeTowerLevelEndNotify(TowerLevelEndNotifyOuterClass.TowerLevelEndNotify value) {
                if (this.towerLevelEndNotifyBuilder_ == null) {
                    if (this.detailCase_ != 281 || this.detail_ == TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.newBuilder((TowerLevelEndNotifyOuterClass.TowerLevelEndNotify) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 281) {
                        this.towerLevelEndNotifyBuilder_.mergeFrom(value);
                    }
                    this.towerLevelEndNotifyBuilder_.setMessage(value);
                }
                this.detailCase_ = 281;
                return this;
            }

            public Builder clearTowerLevelEndNotify() {
                if (this.towerLevelEndNotifyBuilder_ != null) {
                    if (this.detailCase_ == 281) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.towerLevelEndNotifyBuilder_.clear();
                } else if (this.detailCase_ == 281) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.Builder getTowerLevelEndNotifyBuilder() {
                return getTowerLevelEndNotifyFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder getTowerLevelEndNotifyOrBuilder() {
                if (this.detailCase_ == 281 && this.towerLevelEndNotifyBuilder_ != null) {
                    return this.towerLevelEndNotifyBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 281) {
                    return (TowerLevelEndNotifyOuterClass.TowerLevelEndNotify) this.detail_;
                }
                return TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.getDefaultInstance();
            }

            private SingleFieldBuilderV3<TowerLevelEndNotifyOuterClass.TowerLevelEndNotify, TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.Builder, TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder> getTowerLevelEndNotifyFieldBuilder() {
                if (this.towerLevelEndNotifyBuilder_ == null) {
                    if (this.detailCase_ != 281) {
                        this.detail_ = TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.getDefaultInstance();
                    }
                    this.towerLevelEndNotifyBuilder_ = new SingleFieldBuilderV3<>((TowerLevelEndNotifyOuterClass.TowerLevelEndNotify) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 281;
                onChanged();
                return this.towerLevelEndNotifyBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public boolean hasTrialAvatarFirstPassDungeonNotify() {
                return this.detailCase_ == 1737;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify getTrialAvatarFirstPassDungeonNotify() {
                if (this.trialAvatarFirstPassDungeonNotifyBuilder_ == null) {
                    if (this.detailCase_ == 1737) {
                        return (TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify) this.detail_;
                    }
                    return TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.getDefaultInstance();
                } else if (this.detailCase_ == 1737) {
                    return this.trialAvatarFirstPassDungeonNotifyBuilder_.getMessage();
                } else {
                    return TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.getDefaultInstance();
                }
            }

            public Builder setTrialAvatarFirstPassDungeonNotify(TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify value) {
                if (this.trialAvatarFirstPassDungeonNotifyBuilder_ != null) {
                    this.trialAvatarFirstPassDungeonNotifyBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = DungeonSettleNotify.TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY_FIELD_NUMBER;
                return this;
            }

            public Builder setTrialAvatarFirstPassDungeonNotify(TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.Builder builderForValue) {
                if (this.trialAvatarFirstPassDungeonNotifyBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.trialAvatarFirstPassDungeonNotifyBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = DungeonSettleNotify.TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY_FIELD_NUMBER;
                return this;
            }

            public Builder mergeTrialAvatarFirstPassDungeonNotify(TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify value) {
                if (this.trialAvatarFirstPassDungeonNotifyBuilder_ == null) {
                    if (this.detailCase_ != 1737 || this.detail_ == TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.newBuilder((TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1737) {
                        this.trialAvatarFirstPassDungeonNotifyBuilder_.mergeFrom(value);
                    }
                    this.trialAvatarFirstPassDungeonNotifyBuilder_.setMessage(value);
                }
                this.detailCase_ = DungeonSettleNotify.TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY_FIELD_NUMBER;
                return this;
            }

            public Builder clearTrialAvatarFirstPassDungeonNotify() {
                if (this.trialAvatarFirstPassDungeonNotifyBuilder_ != null) {
                    if (this.detailCase_ == 1737) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.trialAvatarFirstPassDungeonNotifyBuilder_.clear();
                } else if (this.detailCase_ == 1737) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.Builder getTrialAvatarFirstPassDungeonNotifyBuilder() {
                return getTrialAvatarFirstPassDungeonNotifyFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotifyOrBuilder getTrialAvatarFirstPassDungeonNotifyOrBuilder() {
                if (this.detailCase_ == 1737 && this.trialAvatarFirstPassDungeonNotifyBuilder_ != null) {
                    return this.trialAvatarFirstPassDungeonNotifyBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1737) {
                    return (TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify) this.detail_;
                }
                return TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.getDefaultInstance();
            }

            private SingleFieldBuilderV3<TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify, TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.Builder, TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotifyOrBuilder> getTrialAvatarFirstPassDungeonNotifyFieldBuilder() {
                if (this.trialAvatarFirstPassDungeonNotifyBuilder_ == null) {
                    if (this.detailCase_ != 1737) {
                        this.detail_ = TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.getDefaultInstance();
                    }
                    this.trialAvatarFirstPassDungeonNotifyBuilder_ = new SingleFieldBuilderV3<>((TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = DungeonSettleNotify.TRIAL_AVATAR_FIRST_PASS_DUNGEON_NOTIFY_FIELD_NUMBER;
                onChanged();
                return this.trialAvatarFirstPassDungeonNotifyBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public boolean hasChannellerSlabLoopDungeonResultInfo() {
                return this.detailCase_ == 1045;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo getChannellerSlabLoopDungeonResultInfo() {
                if (this.channellerSlabLoopDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ == 1045) {
                        return (ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_;
                    }
                    return ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1045) {
                    return this.channellerSlabLoopDungeonResultInfoBuilder_.getMessage();
                } else {
                    return ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.getDefaultInstance();
                }
            }

            public Builder setChannellerSlabLoopDungeonResultInfo(ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo value) {
                if (this.channellerSlabLoopDungeonResultInfoBuilder_ != null) {
                    this.channellerSlabLoopDungeonResultInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = DungeonSettleNotify.CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setChannellerSlabLoopDungeonResultInfo(ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.Builder builderForValue) {
                if (this.channellerSlabLoopDungeonResultInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.channellerSlabLoopDungeonResultInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = DungeonSettleNotify.CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeChannellerSlabLoopDungeonResultInfo(ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo value) {
                if (this.channellerSlabLoopDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ != 1045 || this.detail_ == ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.newBuilder((ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1045) {
                        this.channellerSlabLoopDungeonResultInfoBuilder_.mergeFrom(value);
                    }
                    this.channellerSlabLoopDungeonResultInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = DungeonSettleNotify.CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearChannellerSlabLoopDungeonResultInfo() {
                if (this.channellerSlabLoopDungeonResultInfoBuilder_ != null) {
                    if (this.detailCase_ == 1045) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.channellerSlabLoopDungeonResultInfoBuilder_.clear();
                } else if (this.detailCase_ == 1045) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.Builder getChannellerSlabLoopDungeonResultInfoBuilder() {
                return getChannellerSlabLoopDungeonResultInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder getChannellerSlabLoopDungeonResultInfoOrBuilder() {
                if (this.detailCase_ == 1045 && this.channellerSlabLoopDungeonResultInfoBuilder_ != null) {
                    return this.channellerSlabLoopDungeonResultInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1045) {
                    return (ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_;
                }
                return ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo, ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.Builder, ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder> getChannellerSlabLoopDungeonResultInfoFieldBuilder() {
                if (this.channellerSlabLoopDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ != 1045) {
                        this.detail_ = ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.getDefaultInstance();
                    }
                    this.channellerSlabLoopDungeonResultInfoBuilder_ = new SingleFieldBuilderV3<>((ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = DungeonSettleNotify.CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER;
                onChanged();
                return this.channellerSlabLoopDungeonResultInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public boolean hasEffigyChallengeDungeonResultInfo() {
                return this.detailCase_ == 955;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo getEffigyChallengeDungeonResultInfo() {
                if (this.effigyChallengeDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ == 955) {
                        return (EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_;
                    }
                    return EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.getDefaultInstance();
                } else if (this.detailCase_ == 955) {
                    return this.effigyChallengeDungeonResultInfoBuilder_.getMessage();
                } else {
                    return EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.getDefaultInstance();
                }
            }

            public Builder setEffigyChallengeDungeonResultInfo(EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo value) {
                if (this.effigyChallengeDungeonResultInfoBuilder_ != null) {
                    this.effigyChallengeDungeonResultInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 955;
                return this;
            }

            public Builder setEffigyChallengeDungeonResultInfo(EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.Builder builderForValue) {
                if (this.effigyChallengeDungeonResultInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.effigyChallengeDungeonResultInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 955;
                return this;
            }

            public Builder mergeEffigyChallengeDungeonResultInfo(EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo value) {
                if (this.effigyChallengeDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ != 955 || this.detail_ == EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.newBuilder((EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 955) {
                        this.effigyChallengeDungeonResultInfoBuilder_.mergeFrom(value);
                    }
                    this.effigyChallengeDungeonResultInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 955;
                return this;
            }

            public Builder clearEffigyChallengeDungeonResultInfo() {
                if (this.effigyChallengeDungeonResultInfoBuilder_ != null) {
                    if (this.detailCase_ == 955) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.effigyChallengeDungeonResultInfoBuilder_.clear();
                } else if (this.detailCase_ == 955) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.Builder getEffigyChallengeDungeonResultInfoBuilder() {
                return getEffigyChallengeDungeonResultInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder getEffigyChallengeDungeonResultInfoOrBuilder() {
                if (this.detailCase_ == 955 && this.effigyChallengeDungeonResultInfoBuilder_ != null) {
                    return this.effigyChallengeDungeonResultInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 955) {
                    return (EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_;
                }
                return EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo, EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.Builder, EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder> getEffigyChallengeDungeonResultInfoFieldBuilder() {
                if (this.effigyChallengeDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ != 955) {
                        this.detail_ = EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.getDefaultInstance();
                    }
                    this.effigyChallengeDungeonResultInfoBuilder_ = new SingleFieldBuilderV3<>((EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 955;
                onChanged();
                return this.effigyChallengeDungeonResultInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public boolean hasRoguelikeDungeonSettleInfo() {
                return this.detailCase_ == 799;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo getRoguelikeDungeonSettleInfo() {
                if (this.roguelikeDungeonSettleInfoBuilder_ == null) {
                    if (this.detailCase_ == 799) {
                        return (RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo) this.detail_;
                    }
                    return RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.getDefaultInstance();
                } else if (this.detailCase_ == 799) {
                    return this.roguelikeDungeonSettleInfoBuilder_.getMessage();
                } else {
                    return RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.getDefaultInstance();
                }
            }

            public Builder setRoguelikeDungeonSettleInfo(RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo value) {
                if (this.roguelikeDungeonSettleInfoBuilder_ != null) {
                    this.roguelikeDungeonSettleInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 799;
                return this;
            }

            public Builder setRoguelikeDungeonSettleInfo(RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.Builder builderForValue) {
                if (this.roguelikeDungeonSettleInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.roguelikeDungeonSettleInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 799;
                return this;
            }

            public Builder mergeRoguelikeDungeonSettleInfo(RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo value) {
                if (this.roguelikeDungeonSettleInfoBuilder_ == null) {
                    if (this.detailCase_ != 799 || this.detail_ == RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.newBuilder((RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 799) {
                        this.roguelikeDungeonSettleInfoBuilder_.mergeFrom(value);
                    }
                    this.roguelikeDungeonSettleInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 799;
                return this;
            }

            public Builder clearRoguelikeDungeonSettleInfo() {
                if (this.roguelikeDungeonSettleInfoBuilder_ != null) {
                    if (this.detailCase_ == 799) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.roguelikeDungeonSettleInfoBuilder_.clear();
                } else if (this.detailCase_ == 799) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.Builder getRoguelikeDungeonSettleInfoBuilder() {
                return getRoguelikeDungeonSettleInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder getRoguelikeDungeonSettleInfoOrBuilder() {
                if (this.detailCase_ == 799 && this.roguelikeDungeonSettleInfoBuilder_ != null) {
                    return this.roguelikeDungeonSettleInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 799) {
                    return (RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo) this.detail_;
                }
                return RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo, RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.Builder, RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder> getRoguelikeDungeonSettleInfoFieldBuilder() {
                if (this.roguelikeDungeonSettleInfoBuilder_ == null) {
                    if (this.detailCase_ != 799) {
                        this.detail_ = RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.getDefaultInstance();
                    }
                    this.roguelikeDungeonSettleInfoBuilder_ = new SingleFieldBuilderV3<>((RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 799;
                onChanged();
                return this.roguelikeDungeonSettleInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public boolean hasCrystalLinkSettleInfo() {
                return this.detailCase_ == 628;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo getCrystalLinkSettleInfo() {
                if (this.crystalLinkSettleInfoBuilder_ == null) {
                    if (this.detailCase_ == 628) {
                        return (CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo) this.detail_;
                    }
                    return CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.getDefaultInstance();
                } else if (this.detailCase_ == 628) {
                    return this.crystalLinkSettleInfoBuilder_.getMessage();
                } else {
                    return CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.getDefaultInstance();
                }
            }

            public Builder setCrystalLinkSettleInfo(CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo value) {
                if (this.crystalLinkSettleInfoBuilder_ != null) {
                    this.crystalLinkSettleInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 628;
                return this;
            }

            public Builder setCrystalLinkSettleInfo(CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.Builder builderForValue) {
                if (this.crystalLinkSettleInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.crystalLinkSettleInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 628;
                return this;
            }

            public Builder mergeCrystalLinkSettleInfo(CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo value) {
                if (this.crystalLinkSettleInfoBuilder_ == null) {
                    if (this.detailCase_ != 628 || this.detail_ == CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.newBuilder((CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 628) {
                        this.crystalLinkSettleInfoBuilder_.mergeFrom(value);
                    }
                    this.crystalLinkSettleInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 628;
                return this;
            }

            public Builder clearCrystalLinkSettleInfo() {
                if (this.crystalLinkSettleInfoBuilder_ != null) {
                    if (this.detailCase_ == 628) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.crystalLinkSettleInfoBuilder_.clear();
                } else if (this.detailCase_ == 628) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.Builder getCrystalLinkSettleInfoBuilder() {
                return getCrystalLinkSettleInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder getCrystalLinkSettleInfoOrBuilder() {
                if (this.detailCase_ == 628 && this.crystalLinkSettleInfoBuilder_ != null) {
                    return this.crystalLinkSettleInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 628) {
                    return (CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo) this.detail_;
                }
                return CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo, CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.Builder, CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder> getCrystalLinkSettleInfoFieldBuilder() {
                if (this.crystalLinkSettleInfoBuilder_ == null) {
                    if (this.detailCase_ != 628) {
                        this.detail_ = CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.getDefaultInstance();
                    }
                    this.crystalLinkSettleInfoBuilder_ = new SingleFieldBuilderV3<>((CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 628;
                onChanged();
                return this.crystalLinkSettleInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public boolean hasSummerTimeV2DungeonSettleInfo() {
                return this.detailCase_ == 96;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo getSummerTimeV2DungeonSettleInfo() {
                if (this.summerTimeV2DungeonSettleInfoBuilder_ == null) {
                    if (this.detailCase_ == 96) {
                        return (SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo) this.detail_;
                    }
                    return SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.getDefaultInstance();
                } else if (this.detailCase_ == 96) {
                    return this.summerTimeV2DungeonSettleInfoBuilder_.getMessage();
                } else {
                    return SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.getDefaultInstance();
                }
            }

            public Builder setSummerTimeV2DungeonSettleInfo(SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo value) {
                if (this.summerTimeV2DungeonSettleInfoBuilder_ != null) {
                    this.summerTimeV2DungeonSettleInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 96;
                return this;
            }

            public Builder setSummerTimeV2DungeonSettleInfo(SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.Builder builderForValue) {
                if (this.summerTimeV2DungeonSettleInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.summerTimeV2DungeonSettleInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 96;
                return this;
            }

            public Builder mergeSummerTimeV2DungeonSettleInfo(SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo value) {
                if (this.summerTimeV2DungeonSettleInfoBuilder_ == null) {
                    if (this.detailCase_ != 96 || this.detail_ == SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.newBuilder((SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 96) {
                        this.summerTimeV2DungeonSettleInfoBuilder_.mergeFrom(value);
                    }
                    this.summerTimeV2DungeonSettleInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 96;
                return this;
            }

            public Builder clearSummerTimeV2DungeonSettleInfo() {
                if (this.summerTimeV2DungeonSettleInfoBuilder_ != null) {
                    if (this.detailCase_ == 96) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.summerTimeV2DungeonSettleInfoBuilder_.clear();
                } else if (this.detailCase_ == 96) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.Builder getSummerTimeV2DungeonSettleInfoBuilder() {
                return getSummerTimeV2DungeonSettleInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfoOrBuilder getSummerTimeV2DungeonSettleInfoOrBuilder() {
                if (this.detailCase_ == 96 && this.summerTimeV2DungeonSettleInfoBuilder_ != null) {
                    return this.summerTimeV2DungeonSettleInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 96) {
                    return (SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo) this.detail_;
                }
                return SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo, SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.Builder, SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfoOrBuilder> getSummerTimeV2DungeonSettleInfoFieldBuilder() {
                if (this.summerTimeV2DungeonSettleInfoBuilder_ == null) {
                    if (this.detailCase_ != 96) {
                        this.detail_ = SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.getDefaultInstance();
                    }
                    this.summerTimeV2DungeonSettleInfoBuilder_ = new SingleFieldBuilderV3<>((SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 96;
                onChanged();
                return this.summerTimeV2DungeonSettleInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public boolean hasInstableSpraySettleInfo() {
                return this.detailCase_ == 1797;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo getInstableSpraySettleInfo() {
                if (this.instableSpraySettleInfoBuilder_ == null) {
                    if (this.detailCase_ == 1797) {
                        return (InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo) this.detail_;
                    }
                    return InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1797) {
                    return this.instableSpraySettleInfoBuilder_.getMessage();
                } else {
                    return InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo.getDefaultInstance();
                }
            }

            public Builder setInstableSpraySettleInfo(InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo value) {
                if (this.instableSpraySettleInfoBuilder_ != null) {
                    this.instableSpraySettleInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1797;
                return this;
            }

            public Builder setInstableSpraySettleInfo(InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo.Builder builderForValue) {
                if (this.instableSpraySettleInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.instableSpraySettleInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1797;
                return this;
            }

            public Builder mergeInstableSpraySettleInfo(InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo value) {
                if (this.instableSpraySettleInfoBuilder_ == null) {
                    if (this.detailCase_ != 1797 || this.detail_ == InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo.newBuilder((InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1797) {
                        this.instableSpraySettleInfoBuilder_.mergeFrom(value);
                    }
                    this.instableSpraySettleInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1797;
                return this;
            }

            public Builder clearInstableSpraySettleInfo() {
                if (this.instableSpraySettleInfoBuilder_ != null) {
                    if (this.detailCase_ == 1797) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.instableSpraySettleInfoBuilder_.clear();
                } else if (this.detailCase_ == 1797) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo.Builder getInstableSpraySettleInfoBuilder() {
                return getInstableSpraySettleInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public InstableSpraySettleInfoOuterClass.InstableSpraySettleInfoOrBuilder getInstableSpraySettleInfoOrBuilder() {
                if (this.detailCase_ == 1797 && this.instableSpraySettleInfoBuilder_ != null) {
                    return this.instableSpraySettleInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1797) {
                    return (InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo) this.detail_;
                }
                return InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo, InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo.Builder, InstableSpraySettleInfoOuterClass.InstableSpraySettleInfoOrBuilder> getInstableSpraySettleInfoFieldBuilder() {
                if (this.instableSpraySettleInfoBuilder_ == null) {
                    if (this.detailCase_ != 1797) {
                        this.detail_ = InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo.getDefaultInstance();
                    }
                    this.instableSpraySettleInfoBuilder_ = new SingleFieldBuilderV3<>((InstableSpraySettleInfoOuterClass.InstableSpraySettleInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1797;
                onChanged();
                return this.instableSpraySettleInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public boolean hasWindFieldDungeonSettleInfo() {
                return this.detailCase_ == 1009;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo getWindFieldDungeonSettleInfo() {
                if (this.windFieldDungeonSettleInfoBuilder_ == null) {
                    if (this.detailCase_ == 1009) {
                        return (WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo) this.detail_;
                    }
                    return WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1009) {
                    return this.windFieldDungeonSettleInfoBuilder_.getMessage();
                } else {
                    return WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.getDefaultInstance();
                }
            }

            public Builder setWindFieldDungeonSettleInfo(WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo value) {
                if (this.windFieldDungeonSettleInfoBuilder_ != null) {
                    this.windFieldDungeonSettleInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1009;
                return this;
            }

            public Builder setWindFieldDungeonSettleInfo(WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.Builder builderForValue) {
                if (this.windFieldDungeonSettleInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.windFieldDungeonSettleInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1009;
                return this;
            }

            public Builder mergeWindFieldDungeonSettleInfo(WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo value) {
                if (this.windFieldDungeonSettleInfoBuilder_ == null) {
                    if (this.detailCase_ != 1009 || this.detail_ == WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.newBuilder((WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1009) {
                        this.windFieldDungeonSettleInfoBuilder_.mergeFrom(value);
                    }
                    this.windFieldDungeonSettleInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1009;
                return this;
            }

            public Builder clearWindFieldDungeonSettleInfo() {
                if (this.windFieldDungeonSettleInfoBuilder_ != null) {
                    if (this.detailCase_ == 1009) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.windFieldDungeonSettleInfoBuilder_.clear();
                } else if (this.detailCase_ == 1009) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.Builder getWindFieldDungeonSettleInfoBuilder() {
                return getWindFieldDungeonSettleInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder getWindFieldDungeonSettleInfoOrBuilder() {
                if (this.detailCase_ == 1009 && this.windFieldDungeonSettleInfoBuilder_ != null) {
                    return this.windFieldDungeonSettleInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1009) {
                    return (WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo) this.detail_;
                }
                return WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo, WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.Builder, WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder> getWindFieldDungeonSettleInfoFieldBuilder() {
                if (this.windFieldDungeonSettleInfoBuilder_ == null) {
                    if (this.detailCase_ != 1009) {
                        this.detail_ = WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.getDefaultInstance();
                    }
                    this.windFieldDungeonSettleInfoBuilder_ = new SingleFieldBuilderV3<>((WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1009;
                onChanged();
                return this.windFieldDungeonSettleInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public boolean hasEffigyChallengeV2SettleInfo() {
                return this.detailCase_ == 1839;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo getEffigyChallengeV2SettleInfo() {
                if (this.effigyChallengeV2SettleInfoBuilder_ == null) {
                    if (this.detailCase_ == 1839) {
                        return (EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo) this.detail_;
                    }
                    return EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1839) {
                    return this.effigyChallengeV2SettleInfoBuilder_.getMessage();
                } else {
                    return EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.getDefaultInstance();
                }
            }

            public Builder setEffigyChallengeV2SettleInfo(EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo value) {
                if (this.effigyChallengeV2SettleInfoBuilder_ != null) {
                    this.effigyChallengeV2SettleInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = DungeonSettleNotify.EFFIGY_CHALLENGE_V2SETTLE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setEffigyChallengeV2SettleInfo(EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.Builder builderForValue) {
                if (this.effigyChallengeV2SettleInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.effigyChallengeV2SettleInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = DungeonSettleNotify.EFFIGY_CHALLENGE_V2SETTLE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeEffigyChallengeV2SettleInfo(EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo value) {
                if (this.effigyChallengeV2SettleInfoBuilder_ == null) {
                    if (this.detailCase_ != 1839 || this.detail_ == EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.newBuilder((EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1839) {
                        this.effigyChallengeV2SettleInfoBuilder_.mergeFrom(value);
                    }
                    this.effigyChallengeV2SettleInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = DungeonSettleNotify.EFFIGY_CHALLENGE_V2SETTLE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearEffigyChallengeV2SettleInfo() {
                if (this.effigyChallengeV2SettleInfoBuilder_ != null) {
                    if (this.detailCase_ == 1839) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.effigyChallengeV2SettleInfoBuilder_.clear();
                } else if (this.detailCase_ == 1839) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.Builder getEffigyChallengeV2SettleInfoBuilder() {
                return getEffigyChallengeV2SettleInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder getEffigyChallengeV2SettleInfoOrBuilder() {
                if (this.detailCase_ == 1839 && this.effigyChallengeV2SettleInfoBuilder_ != null) {
                    return this.effigyChallengeV2SettleInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1839) {
                    return (EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo) this.detail_;
                }
                return EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo, EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.Builder, EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder> getEffigyChallengeV2SettleInfoFieldBuilder() {
                if (this.effigyChallengeV2SettleInfoBuilder_ == null) {
                    if (this.detailCase_ != 1839) {
                        this.detail_ = EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.getDefaultInstance();
                    }
                    this.effigyChallengeV2SettleInfoBuilder_ = new SingleFieldBuilderV3<>((EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = DungeonSettleNotify.EFFIGY_CHALLENGE_V2SETTLE_INFO_FIELD_NUMBER;
                onChanged();
                return this.effigyChallengeV2SettleInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public boolean hasTeamChainSettleInfo() {
                return this.detailCase_ == 1320;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public TeamChainSettleInfoOuterClass.TeamChainSettleInfo getTeamChainSettleInfo() {
                if (this.teamChainSettleInfoBuilder_ == null) {
                    if (this.detailCase_ == 1320) {
                        return (TeamChainSettleInfoOuterClass.TeamChainSettleInfo) this.detail_;
                    }
                    return TeamChainSettleInfoOuterClass.TeamChainSettleInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1320) {
                    return this.teamChainSettleInfoBuilder_.getMessage();
                } else {
                    return TeamChainSettleInfoOuterClass.TeamChainSettleInfo.getDefaultInstance();
                }
            }

            public Builder setTeamChainSettleInfo(TeamChainSettleInfoOuterClass.TeamChainSettleInfo value) {
                if (this.teamChainSettleInfoBuilder_ != null) {
                    this.teamChainSettleInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1320;
                return this;
            }

            public Builder setTeamChainSettleInfo(TeamChainSettleInfoOuterClass.TeamChainSettleInfo.Builder builderForValue) {
                if (this.teamChainSettleInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.teamChainSettleInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1320;
                return this;
            }

            public Builder mergeTeamChainSettleInfo(TeamChainSettleInfoOuterClass.TeamChainSettleInfo value) {
                if (this.teamChainSettleInfoBuilder_ == null) {
                    if (this.detailCase_ != 1320 || this.detail_ == TeamChainSettleInfoOuterClass.TeamChainSettleInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = TeamChainSettleInfoOuterClass.TeamChainSettleInfo.newBuilder((TeamChainSettleInfoOuterClass.TeamChainSettleInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1320) {
                        this.teamChainSettleInfoBuilder_.mergeFrom(value);
                    }
                    this.teamChainSettleInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1320;
                return this;
            }

            public Builder clearTeamChainSettleInfo() {
                if (this.teamChainSettleInfoBuilder_ != null) {
                    if (this.detailCase_ == 1320) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.teamChainSettleInfoBuilder_.clear();
                } else if (this.detailCase_ == 1320) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public TeamChainSettleInfoOuterClass.TeamChainSettleInfo.Builder getTeamChainSettleInfoBuilder() {
                return getTeamChainSettleInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass.DungeonSettleNotifyOrBuilder
            public TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder getTeamChainSettleInfoOrBuilder() {
                if (this.detailCase_ == 1320 && this.teamChainSettleInfoBuilder_ != null) {
                    return this.teamChainSettleInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1320) {
                    return (TeamChainSettleInfoOuterClass.TeamChainSettleInfo) this.detail_;
                }
                return TeamChainSettleInfoOuterClass.TeamChainSettleInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<TeamChainSettleInfoOuterClass.TeamChainSettleInfo, TeamChainSettleInfoOuterClass.TeamChainSettleInfo.Builder, TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder> getTeamChainSettleInfoFieldBuilder() {
                if (this.teamChainSettleInfoBuilder_ == null) {
                    if (this.detailCase_ != 1320) {
                        this.detail_ = TeamChainSettleInfoOuterClass.TeamChainSettleInfo.getDefaultInstance();
                    }
                    this.teamChainSettleInfoBuilder_ = new SingleFieldBuilderV3<>((TeamChainSettleInfoOuterClass.TeamChainSettleInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1320;
                onChanged();
                return this.teamChainSettleInfoBuilder_;
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

        public static DungeonSettleNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DungeonSettleNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DungeonSettleNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DungeonSettleNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TowerLevelEndNotifyOuterClass.getDescriptor();
        TrialAvatarFirstPassDungeonNotifyOuterClass.getDescriptor();
        ChannellerSlabLoopDungeonResultInfoOuterClass.getDescriptor();
        EffigyChallengeDungeonResultInfoOuterClass.getDescriptor();
        RoguelikeDungeonSettleInfoOuterClass.getDescriptor();
        CrystalLinkSettleInfoOuterClass.getDescriptor();
        SummerTimeV2DungeonSettleInfoOuterClass.getDescriptor();
        InstableSpraySettleInfoOuterClass.getDescriptor();
        WindFieldDungeonSettleInfoOuterClass.getDescriptor();
        EffigyChallengeV2SettleInfoOuterClass.getDescriptor();
        TeamChainSettleInfoOuterClass.getDescriptor();
        DungeonSettleExhibitionInfoOuterClass.getDescriptor();
        ParamListOuterClass.getDescriptor();
        StrengthenPointDataOuterClass.getDescriptor();
    }
}
