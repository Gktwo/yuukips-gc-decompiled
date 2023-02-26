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
import emu.grasscutter.net.proto.AvatarEquipAffixInfoOuterClass;
import emu.grasscutter.net.proto.AvatarExcelInfoOuterClass;
import emu.grasscutter.net.proto.AvatarExpeditionStateOuterClass;
import emu.grasscutter.net.proto.AvatarFetterInfoOuterClass;
import emu.grasscutter.net.proto.AvatarSkillInfoOuterClass;
import emu.grasscutter.net.proto.PropValueOuterClass;
import emu.grasscutter.net.proto.TrialAvatarInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarInfoOuterClass.class */
public final class AvatarInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010AvatarInfo.proto\u001a\u001aAvatarEquipAffixInfo.proto\u001a\u0015AvatarExcelInfo.proto\u001a\u001bAvatarExpeditionState.proto\u001a\u0016AvatarFetterInfo.proto\u001a\u0015AvatarSkillInfo.proto\u001a\u000fPropValue.proto\u001a\u0015TrialAvatarInfo.proto\"\t\n\nAvatarInfo\u0012\u0010\n\bavatarId\u0018\u0001 \u0001(\r\u0012\f\n\u0004guid\u0018\u0002 \u0001(\u0004\u0012)\n\u0007propMap\u0018\u0003 \u0003(\u000b2\u0018.AvatarInfo.PropMapEntry\u0012\u0011\n\tlifeState\u0018\u0004 \u0001(\r\u0012\u0015\n\requipGuidList\u0018\u0005 \u0003(\u0004\u0012\u0014\n\ftalentIdList\u0018\u0006 \u0003(\r\u00123\n\ffightPropMap\u0018\u0007 \u0003(\u000b2\u001d.AvatarInfo.FightPropMapEntry\u0012)\n\u000ftrialAvatarInfo\u0018\t \u0001(\u000b2\u0010.TrialAvatarInfo\u0012+\n\bskillMap\u0018\n \u0003(\u000b2\u0019.AvatarInfo.SkillMapEntry\u0012\u0014\n\fskillDepotId\u0018\u000b \u0001(\r\u0012%\n\nfetterInfo\u0018\f \u0001(\u000b2\u0011.AvatarFetterInfo\u0012\u001b\n\u0013coreProudSkillLevel\u0018\r \u0001(\r\u0012\u001e\n\u0016inherentProudSkillList\u0018\u000e \u0003(\r\u00125\n\rskillLevelMap\u0018\u000f \u0003(\u000b2\u001e.AvatarInfo.SkillLevelMapEntry\u0012/\n\u000fexpeditionState\u0018\u0010 \u0001(\u000e2\u0016.AvatarExpeditionState\u0012I\n\u0017proudSkillExtraLevelMap\u0018\u0011 \u0003(\u000b2(.AvatarInfo.ProudSkillExtraLevelMapEntry\u0012\u000f\n\u0007isFocus\u0018\u0012 \u0001(\b\u0012\u0012\n\navatarType\u0018\u0013 \u0001(\r\u0012\u0019\n\u0011teamResonanceList\u0018\u0014 \u0003(\r\u0012\u0019\n\u0011wearingFlycloakId\u0018\u0015 \u0001(\r\u0012-\n\u000eequipAffixList\u0018\u0016 \u0003(\u000b2\u0015.AvatarEquipAffixInfo\u0012\u0010\n\bbornTime\u0018\u0017 \u0001(\r\u0012 \n\u0018pendingPromoteRewardList\u0018\u0018 \u0003(\r\u0012\u0011\n\tcostumeId\u0018\u0019 \u0001(\r\u0012#\n\texcelInfo\u0018\u001a \u0001(\u000b2\u0010.AvatarExcelInfo\u0012\u0010\n\banimHash\u0018\u001b \u0001(\r\u001a:\n\fPropMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u0019\n\u0005value\u0018\u0002 \u0001(\u000b2\n.PropValue:\u00028\u0001\u001a3\n\u0011FightPropMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\u0002:\u00028\u0001\u001aA\n\rSkillMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u001f\n\u0005value\u0018\u0002 \u0001(\u000b2\u0010.AvatarSkillInfo:\u00028\u0001\u001a4\n\u0012SkillLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a>\n\u001cProudSkillExtraLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AvatarEquipAffixInfoOuterClass.getDescriptor(), AvatarExcelInfoOuterClass.getDescriptor(), AvatarExpeditionStateOuterClass.getDescriptor(), AvatarFetterInfoOuterClass.getDescriptor(), AvatarSkillInfoOuterClass.getDescriptor(), PropValueOuterClass.getDescriptor(), TrialAvatarInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarInfo_descriptor, new String[]{"AvatarId", "Guid", "PropMap", "LifeState", "EquipGuidList", "TalentIdList", "FightPropMap", "TrialAvatarInfo", "SkillMap", "SkillDepotId", "FetterInfo", "CoreProudSkillLevel", "InherentProudSkillList", "SkillLevelMap", "ExpeditionState", "ProudSkillExtraLevelMap", "IsFocus", "AvatarType", "TeamResonanceList", "WearingFlycloakId", "EquipAffixList", "BornTime", "PendingPromoteRewardList", "CostumeId", "ExcelInfo", "AnimHash"});
    private static final Descriptors.Descriptor internal_static_AvatarInfo_PropMapEntry_descriptor = internal_static_AvatarInfo_descriptor.getNestedTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarInfo_PropMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarInfo_PropMapEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_AvatarInfo_FightPropMapEntry_descriptor = internal_static_AvatarInfo_descriptor.getNestedTypes().get(1);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarInfo_FightPropMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarInfo_FightPropMapEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_AvatarInfo_SkillMapEntry_descriptor = internal_static_AvatarInfo_descriptor.getNestedTypes().get(2);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarInfo_SkillMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarInfo_SkillMapEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_AvatarInfo_SkillLevelMapEntry_descriptor = internal_static_AvatarInfo_descriptor.getNestedTypes().get(3);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarInfo_SkillLevelMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarInfo_SkillLevelMapEntry_descriptor, new String[]{"Key", "Value"});

    /* renamed from: internal_static_AvatarInfo_ProudSkillExtraLevelMapEntry_descriptor */
    private static final Descriptors.Descriptor f642xd297af06 = internal_static_AvatarInfo_descriptor.getNestedTypes().get(4);

    /* renamed from: internal_static_AvatarInfo_ProudSkillExtraLevelMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f643xb0826f84 = new GeneratedMessageV3.FieldAccessorTable(f642xd297af06, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarInfoOuterClass$AvatarInfoOrBuilder.class */
    public interface AvatarInfoOrBuilder extends MessageOrBuilder {
        int getAvatarId();

        long getGuid();

        int getPropMapCount();

        boolean containsPropMap(int i);

        @Deprecated
        Map<Integer, PropValueOuterClass.PropValue> getPropMap();

        Map<Integer, PropValueOuterClass.PropValue> getPropMapMap();

        PropValueOuterClass.PropValue getPropMapOrDefault(int i, PropValueOuterClass.PropValue propValue);

        PropValueOuterClass.PropValue getPropMapOrThrow(int i);

        int getLifeState();

        List<Long> getEquipGuidListList();

        int getEquipGuidListCount();

        long getEquipGuidList(int i);

        List<Integer> getTalentIdListList();

        int getTalentIdListCount();

        int getTalentIdList(int i);

        int getFightPropMapCount();

        boolean containsFightPropMap(int i);

        @Deprecated
        Map<Integer, Float> getFightPropMap();

        Map<Integer, Float> getFightPropMapMap();

        float getFightPropMapOrDefault(int i, float f);

        float getFightPropMapOrThrow(int i);

        boolean hasTrialAvatarInfo();

        TrialAvatarInfoOuterClass.TrialAvatarInfo getTrialAvatarInfo();

        TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder getTrialAvatarInfoOrBuilder();

        int getSkillMapCount();

        boolean containsSkillMap(int i);

        @Deprecated
        Map<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> getSkillMap();

        Map<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> getSkillMapMap();

        AvatarSkillInfoOuterClass.AvatarSkillInfo getSkillMapOrDefault(int i, AvatarSkillInfoOuterClass.AvatarSkillInfo avatarSkillInfo);

        AvatarSkillInfoOuterClass.AvatarSkillInfo getSkillMapOrThrow(int i);

        int getSkillDepotId();

        boolean hasFetterInfo();

        AvatarFetterInfoOuterClass.AvatarFetterInfo getFetterInfo();

        AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder getFetterInfoOrBuilder();

        int getCoreProudSkillLevel();

        List<Integer> getInherentProudSkillListList();

        int getInherentProudSkillListCount();

        int getInherentProudSkillList(int i);

        int getSkillLevelMapCount();

        boolean containsSkillLevelMap(int i);

        @Deprecated
        Map<Integer, Integer> getSkillLevelMap();

        Map<Integer, Integer> getSkillLevelMapMap();

        int getSkillLevelMapOrDefault(int i, int i2);

        int getSkillLevelMapOrThrow(int i);

        int getExpeditionStateValue();

        AvatarExpeditionStateOuterClass.AvatarExpeditionState getExpeditionState();

        int getProudSkillExtraLevelMapCount();

        boolean containsProudSkillExtraLevelMap(int i);

        @Deprecated
        Map<Integer, Integer> getProudSkillExtraLevelMap();

        Map<Integer, Integer> getProudSkillExtraLevelMapMap();

        int getProudSkillExtraLevelMapOrDefault(int i, int i2);

        int getProudSkillExtraLevelMapOrThrow(int i);

        boolean getIsFocus();

        int getAvatarType();

        List<Integer> getTeamResonanceListList();

        int getTeamResonanceListCount();

        int getTeamResonanceList(int i);

        int getWearingFlycloakId();

        List<AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo> getEquipAffixListList();

        AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo getEquipAffixList(int i);

        int getEquipAffixListCount();

        List<? extends AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder> getEquipAffixListOrBuilderList();

        AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder getEquipAffixListOrBuilder(int i);

        int getBornTime();

        List<Integer> getPendingPromoteRewardListList();

        int getPendingPromoteRewardListCount();

        int getPendingPromoteRewardList(int i);

        int getCostumeId();

        boolean hasExcelInfo();

        AvatarExcelInfoOuterClass.AvatarExcelInfo getExcelInfo();

        AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder getExcelInfoOrBuilder();

        int getAnimHash();
    }

    private AvatarInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarInfoOuterClass$AvatarInfo.class */
    public static final class AvatarInfo extends GeneratedMessageV3 implements AvatarInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATARID_FIELD_NUMBER = 1;
        private int avatarId_;
        public static final int GUID_FIELD_NUMBER = 2;
        private long guid_;
        public static final int PROPMAP_FIELD_NUMBER = 3;
        private MapField<Integer, PropValueOuterClass.PropValue> propMap_;
        public static final int LIFESTATE_FIELD_NUMBER = 4;
        private int lifeState_;
        public static final int EQUIPGUIDLIST_FIELD_NUMBER = 5;
        private Internal.LongList equipGuidList_;
        private int equipGuidListMemoizedSerializedSize;
        public static final int TALENTIDLIST_FIELD_NUMBER = 6;
        private Internal.IntList talentIdList_;
        private int talentIdListMemoizedSerializedSize;
        public static final int FIGHTPROPMAP_FIELD_NUMBER = 7;
        private MapField<Integer, Float> fightPropMap_;
        public static final int TRIALAVATARINFO_FIELD_NUMBER = 9;
        private TrialAvatarInfoOuterClass.TrialAvatarInfo trialAvatarInfo_;
        public static final int SKILLMAP_FIELD_NUMBER = 10;
        private MapField<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> skillMap_;
        public static final int SKILLDEPOTID_FIELD_NUMBER = 11;
        private int skillDepotId_;
        public static final int FETTERINFO_FIELD_NUMBER = 12;
        private AvatarFetterInfoOuterClass.AvatarFetterInfo fetterInfo_;
        public static final int COREPROUDSKILLLEVEL_FIELD_NUMBER = 13;
        private int coreProudSkillLevel_;
        public static final int INHERENTPROUDSKILLLIST_FIELD_NUMBER = 14;
        private Internal.IntList inherentProudSkillList_;
        private int inherentProudSkillListMemoizedSerializedSize;
        public static final int SKILLLEVELMAP_FIELD_NUMBER = 15;
        private MapField<Integer, Integer> skillLevelMap_;
        public static final int EXPEDITIONSTATE_FIELD_NUMBER = 16;
        private int expeditionState_;
        public static final int PROUDSKILLEXTRALEVELMAP_FIELD_NUMBER = 17;
        private MapField<Integer, Integer> proudSkillExtraLevelMap_;
        public static final int ISFOCUS_FIELD_NUMBER = 18;
        private boolean isFocus_;
        public static final int AVATARTYPE_FIELD_NUMBER = 19;
        private int avatarType_;
        public static final int TEAMRESONANCELIST_FIELD_NUMBER = 20;
        private Internal.IntList teamResonanceList_;
        private int teamResonanceListMemoizedSerializedSize;
        public static final int WEARINGFLYCLOAKID_FIELD_NUMBER = 21;
        private int wearingFlycloakId_;
        public static final int EQUIPAFFIXLIST_FIELD_NUMBER = 22;
        private List<AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo> equipAffixList_;
        public static final int BORNTIME_FIELD_NUMBER = 23;
        private int bornTime_;
        public static final int PENDINGPROMOTEREWARDLIST_FIELD_NUMBER = 24;
        private Internal.IntList pendingPromoteRewardList_;
        private int pendingPromoteRewardListMemoizedSerializedSize;
        public static final int COSTUMEID_FIELD_NUMBER = 25;
        private int costumeId_;
        public static final int EXCELINFO_FIELD_NUMBER = 26;
        private AvatarExcelInfoOuterClass.AvatarExcelInfo excelInfo_;
        public static final int ANIMHASH_FIELD_NUMBER = 27;
        private int animHash_;
        private byte memoizedIsInitialized;
        private static final AvatarInfo DEFAULT_INSTANCE = new AvatarInfo();
        private static final Parser<AvatarInfo> PARSER = new AbstractParser<AvatarInfo>() { // from class: emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfo.1
            @Override // com.google.protobuf.Parser
            public AvatarInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarInfo(input, extensionRegistry);
            }
        };

        /*  JADX ERROR: Dependency scan failed at insn: 0x006A: INVOKE_CUSTOM r0
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
        /*  JADX ERROR: Failed to decode insn: 0x006A: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 3: goto L_0x004c;
                    case 4: goto L_0x0065;
                    case 5: goto L_0x0065;
                    case 6: goto L_0x0065;
                    case 7: goto L_0x0051;
                    case 8: goto L_0x0065;
                    case 9: goto L_0x0065;
                    case 10: goto L_0x0056;
                    case 11: goto L_0x0065;
                    case 12: goto L_0x0065;
                    case 13: goto L_0x0065;
                    case 14: goto L_0x0065;
                    case 15: goto L_0x005b;
                    case 16: goto L_0x0065;
                    case 17: goto L_0x0060;
                    default: goto L_0x0065;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetPropMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetFightPropMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSkillMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSkillLevelMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetProudSkillExtraLevelMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private AvatarInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.equipGuidListMemoizedSerializedSize = -1;
            this.talentIdListMemoizedSerializedSize = -1;
            this.inherentProudSkillListMemoizedSerializedSize = -1;
            this.teamResonanceListMemoizedSerializedSize = -1;
            this.pendingPromoteRewardListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AvatarInfo() {
            this.equipGuidListMemoizedSerializedSize = -1;
            this.talentIdListMemoizedSerializedSize = -1;
            this.inherentProudSkillListMemoizedSerializedSize = -1;
            this.teamResonanceListMemoizedSerializedSize = -1;
            this.pendingPromoteRewardListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.equipGuidList_ = emptyLongList();
            this.talentIdList_ = emptyIntList();
            this.inherentProudSkillList_ = emptyIntList();
            this.expeditionState_ = 0;
            this.teamResonanceList_ = emptyIntList();
            this.equipAffixList_ = Collections.emptyList();
            this.pendingPromoteRewardList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:225:0x062b */
        private AvatarInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.avatarId_ = input.readUInt32();
                                break;
                            case 16:
                                this.guid_ = input.readUInt64();
                                break;
                            case 26:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.propMap_ = MapField.newMapField(PropMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, PropValueOuterClass.PropValue> propMap__ = (MapEntry) input.readMessage(PropMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.propMap_.getMutableMap().put(propMap__.getKey(), propMap__.getValue());
                                break;
                            case 32:
                                this.lifeState_ = input.readUInt32();
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.equipGuidList_ = newLongList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.equipGuidList_.addLong(input.readUInt64());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.equipGuidList_ = newLongList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.equipGuidList_.addLong(input.readUInt64());
                                }
                                input.popLimit(limit);
                                break;
                            case 48:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.talentIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.talentIdList_.addInt(input.readUInt32());
                                break;
                            case 50:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.talentIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.talentIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.fightPropMap_ = MapField.newMapField(FightPropMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Float> fightPropMap__ = (MapEntry) input.readMessage(FightPropMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.fightPropMap_.getMutableMap().put(fightPropMap__.getKey(), fightPropMap__.getValue());
                                break;
                            case 74:
                                TrialAvatarInfoOuterClass.TrialAvatarInfo.Builder subBuilder = this.trialAvatarInfo_ != null ? this.trialAvatarInfo_.toBuilder() : null;
                                this.trialAvatarInfo_ = (TrialAvatarInfoOuterClass.TrialAvatarInfo) input.readMessage(TrialAvatarInfoOuterClass.TrialAvatarInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.trialAvatarInfo_);
                                    this.trialAvatarInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 82:
                                if ((mutable_bitField0_ & 16) == 0) {
                                    this.skillMap_ = MapField.newMapField(SkillMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> skillMap__ = (MapEntry) input.readMessage(SkillMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.skillMap_.getMutableMap().put(skillMap__.getKey(), skillMap__.getValue());
                                break;
                            case 88:
                                this.skillDepotId_ = input.readUInt32();
                                break;
                            case 98:
                                AvatarFetterInfoOuterClass.AvatarFetterInfo.Builder subBuilder2 = this.fetterInfo_ != null ? this.fetterInfo_.toBuilder() : null;
                                this.fetterInfo_ = (AvatarFetterInfoOuterClass.AvatarFetterInfo) input.readMessage(AvatarFetterInfoOuterClass.AvatarFetterInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.fetterInfo_);
                                    this.fetterInfo_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 104:
                                this.coreProudSkillLevel_ = input.readUInt32();
                                break;
                            case 112:
                                if ((mutable_bitField0_ & 32) == 0) {
                                    this.inherentProudSkillList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                }
                                this.inherentProudSkillList_.addInt(input.readUInt32());
                                break;
                            case 114:
                                int limit3 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 32) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.inherentProudSkillList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.inherentProudSkillList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit3);
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 64) == 0) {
                                    this.skillLevelMap_ = MapField.newMapField(SkillLevelMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> skillLevelMap__ = (MapEntry) input.readMessage(SkillLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.skillLevelMap_.getMutableMap().put(skillLevelMap__.getKey(), skillLevelMap__.getValue());
                                break;
                            case 128:
                                this.expeditionState_ = input.readEnum();
                                break;
                            case 138:
                                if ((mutable_bitField0_ & 128) == 0) {
                                    this.proudSkillExtraLevelMap_ = MapField.newMapField(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 128) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> proudSkillExtraLevelMap__ = (MapEntry) input.readMessage(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.proudSkillExtraLevelMap_.getMutableMap().put(proudSkillExtraLevelMap__.getKey(), proudSkillExtraLevelMap__.getValue());
                                break;
                            case 144:
                                this.isFocus_ = input.readBool();
                                break;
                            case 152:
                                this.avatarType_ = input.readUInt32();
                                break;
                            case 160:
                                if ((mutable_bitField0_ & 256) == 0) {
                                    this.teamResonanceList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 256) == 1 ? 1 : 0;
                                }
                                this.teamResonanceList_.addInt(input.readUInt32());
                                break;
                            case 162:
                                int limit4 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 256) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.teamResonanceList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 256) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.teamResonanceList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit4);
                                break;
                            case 168:
                                this.wearingFlycloakId_ = input.readUInt32();
                                break;
                            case 178:
                                if ((mutable_bitField0_ & 512) == 0) {
                                    this.equipAffixList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 512) == 1 ? 1 : 0;
                                }
                                this.equipAffixList_.add((AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo) input.readMessage(AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.parser(), extensionRegistry));
                                break;
                            case 184:
                                this.bornTime_ = input.readUInt32();
                                break;
                            case 192:
                                if ((mutable_bitField0_ & 1024) == 0) {
                                    this.pendingPromoteRewardList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1024) == 1 ? 1 : 0;
                                }
                                this.pendingPromoteRewardList_.addInt(input.readUInt32());
                                break;
                            case 194:
                                int limit5 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1024) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.pendingPromoteRewardList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1024) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.pendingPromoteRewardList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit5);
                                break;
                            case 200:
                                this.costumeId_ = input.readUInt32();
                                break;
                            case PacketOpcodes.ExecuteGadgetLuaReq:
                                AvatarExcelInfoOuterClass.AvatarExcelInfo.Builder subBuilder3 = this.excelInfo_ != null ? this.excelInfo_.toBuilder() : null;
                                this.excelInfo_ = (AvatarExcelInfoOuterClass.AvatarExcelInfo) input.readMessage(AvatarExcelInfoOuterClass.AvatarExcelInfo.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.excelInfo_);
                                    this.excelInfo_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 216:
                                this.animHash_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 2) != 0) {
                    this.equipGuidList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.talentIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 32) != 0) {
                    this.inherentProudSkillList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 256) != 0) {
                    this.teamResonanceList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 512) != 0) {
                    this.equipAffixList_ = Collections.unmodifiableList(this.equipAffixList_);
                }
                if ((mutable_bitField0_ & 1024) != 0) {
                    this.pendingPromoteRewardList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarInfoOuterClass.internal_static_AvatarInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarInfoOuterClass.internal_static_AvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public long getGuid() {
            return this.guid_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarInfoOuterClass$AvatarInfo$PropMapDefaultEntryHolder.class */
        public static final class PropMapDefaultEntryHolder {
            static final MapEntry<Integer, PropValueOuterClass.PropValue> defaultEntry = MapEntry.newDefaultInstance(AvatarInfoOuterClass.internal_static_AvatarInfo_PropMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, PropValueOuterClass.PropValue.getDefaultInstance());

            private PropMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, PropValueOuterClass.PropValue> internalGetPropMap() {
            if (this.propMap_ == null) {
                return MapField.emptyMapField(PropMapDefaultEntryHolder.defaultEntry);
            }
            return this.propMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getPropMapCount() {
            return internalGetPropMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public boolean containsPropMap(int key) {
            return internalGetPropMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        @Deprecated
        public Map<Integer, PropValueOuterClass.PropValue> getPropMap() {
            return getPropMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public Map<Integer, PropValueOuterClass.PropValue> getPropMapMap() {
            return internalGetPropMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public PropValueOuterClass.PropValue getPropMapOrDefault(int key, PropValueOuterClass.PropValue defaultValue) {
            Map<Integer, PropValueOuterClass.PropValue> map = internalGetPropMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public PropValueOuterClass.PropValue getPropMapOrThrow(int key) {
            Map<Integer, PropValueOuterClass.PropValue> map = internalGetPropMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getLifeState() {
            return this.lifeState_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public List<Long> getEquipGuidListList() {
            return this.equipGuidList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getEquipGuidListCount() {
            return this.equipGuidList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public long getEquipGuidList(int index) {
            return this.equipGuidList_.getLong(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public List<Integer> getTalentIdListList() {
            return this.talentIdList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getTalentIdListCount() {
            return this.talentIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getTalentIdList(int index) {
            return this.talentIdList_.getInt(index);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarInfoOuterClass$AvatarInfo$FightPropMapDefaultEntryHolder.class */
        public static final class FightPropMapDefaultEntryHolder {
            static final MapEntry<Integer, Float> defaultEntry = MapEntry.newDefaultInstance(AvatarInfoOuterClass.internal_static_AvatarInfo_FightPropMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.FLOAT, Float.valueOf(0.0f));

            private FightPropMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Float> internalGetFightPropMap() {
            if (this.fightPropMap_ == null) {
                return MapField.emptyMapField(FightPropMapDefaultEntryHolder.defaultEntry);
            }
            return this.fightPropMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getFightPropMapCount() {
            return internalGetFightPropMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public boolean containsFightPropMap(int key) {
            return internalGetFightPropMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        @Deprecated
        public Map<Integer, Float> getFightPropMap() {
            return getFightPropMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public Map<Integer, Float> getFightPropMapMap() {
            return internalGetFightPropMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public float getFightPropMapOrDefault(int key, float defaultValue) {
            Map<Integer, Float> map = internalGetFightPropMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).floatValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public float getFightPropMapOrThrow(int key) {
            Map<Integer, Float> map = internalGetFightPropMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).floatValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public boolean hasTrialAvatarInfo() {
            return this.trialAvatarInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public TrialAvatarInfoOuterClass.TrialAvatarInfo getTrialAvatarInfo() {
            return this.trialAvatarInfo_ == null ? TrialAvatarInfoOuterClass.TrialAvatarInfo.getDefaultInstance() : this.trialAvatarInfo_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder getTrialAvatarInfoOrBuilder() {
            return getTrialAvatarInfo();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarInfoOuterClass$AvatarInfo$SkillMapDefaultEntryHolder.class */
        public static final class SkillMapDefaultEntryHolder {
            static final MapEntry<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> defaultEntry = MapEntry.newDefaultInstance(AvatarInfoOuterClass.internal_static_AvatarInfo_SkillMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, AvatarSkillInfoOuterClass.AvatarSkillInfo.getDefaultInstance());

            private SkillMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> internalGetSkillMap() {
            if (this.skillMap_ == null) {
                return MapField.emptyMapField(SkillMapDefaultEntryHolder.defaultEntry);
            }
            return this.skillMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getSkillMapCount() {
            return internalGetSkillMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public boolean containsSkillMap(int key) {
            return internalGetSkillMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        @Deprecated
        public Map<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> getSkillMap() {
            return getSkillMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public Map<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> getSkillMapMap() {
            return internalGetSkillMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public AvatarSkillInfoOuterClass.AvatarSkillInfo getSkillMapOrDefault(int key, AvatarSkillInfoOuterClass.AvatarSkillInfo defaultValue) {
            Map<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> map = internalGetSkillMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public AvatarSkillInfoOuterClass.AvatarSkillInfo getSkillMapOrThrow(int key) {
            Map<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> map = internalGetSkillMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getSkillDepotId() {
            return this.skillDepotId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public boolean hasFetterInfo() {
            return this.fetterInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public AvatarFetterInfoOuterClass.AvatarFetterInfo getFetterInfo() {
            return this.fetterInfo_ == null ? AvatarFetterInfoOuterClass.AvatarFetterInfo.getDefaultInstance() : this.fetterInfo_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder getFetterInfoOrBuilder() {
            return getFetterInfo();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getCoreProudSkillLevel() {
            return this.coreProudSkillLevel_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public List<Integer> getInherentProudSkillListList() {
            return this.inherentProudSkillList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getInherentProudSkillListCount() {
            return this.inherentProudSkillList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getInherentProudSkillList(int index) {
            return this.inherentProudSkillList_.getInt(index);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarInfoOuterClass$AvatarInfo$SkillLevelMapDefaultEntryHolder.class */
        public static final class SkillLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(AvatarInfoOuterClass.internal_static_AvatarInfo_SkillLevelMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private SkillLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetSkillLevelMap() {
            if (this.skillLevelMap_ == null) {
                return MapField.emptyMapField(SkillLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.skillLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getSkillLevelMapCount() {
            return internalGetSkillLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public boolean containsSkillLevelMap(int key) {
            return internalGetSkillLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getSkillLevelMap() {
            return getSkillLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public Map<Integer, Integer> getSkillLevelMapMap() {
            return internalGetSkillLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getSkillLevelMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetSkillLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getSkillLevelMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetSkillLevelMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getExpeditionStateValue() {
            return this.expeditionState_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public AvatarExpeditionStateOuterClass.AvatarExpeditionState getExpeditionState() {
            AvatarExpeditionStateOuterClass.AvatarExpeditionState result = AvatarExpeditionStateOuterClass.AvatarExpeditionState.valueOf(this.expeditionState_);
            return result == null ? AvatarExpeditionStateOuterClass.AvatarExpeditionState.UNRECOGNIZED : result;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarInfoOuterClass$AvatarInfo$ProudSkillExtraLevelMapDefaultEntryHolder.class */
        public static final class ProudSkillExtraLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(AvatarInfoOuterClass.f642xd297af06, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private ProudSkillExtraLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetProudSkillExtraLevelMap() {
            if (this.proudSkillExtraLevelMap_ == null) {
                return MapField.emptyMapField(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.proudSkillExtraLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getProudSkillExtraLevelMapCount() {
            return internalGetProudSkillExtraLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public boolean containsProudSkillExtraLevelMap(int key) {
            return internalGetProudSkillExtraLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getProudSkillExtraLevelMap() {
            return getProudSkillExtraLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public Map<Integer, Integer> getProudSkillExtraLevelMapMap() {
            return internalGetProudSkillExtraLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getProudSkillExtraLevelMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetProudSkillExtraLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getProudSkillExtraLevelMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetProudSkillExtraLevelMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public boolean getIsFocus() {
            return this.isFocus_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getAvatarType() {
            return this.avatarType_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public List<Integer> getTeamResonanceListList() {
            return this.teamResonanceList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getTeamResonanceListCount() {
            return this.teamResonanceList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getTeamResonanceList(int index) {
            return this.teamResonanceList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getWearingFlycloakId() {
            return this.wearingFlycloakId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public List<AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo> getEquipAffixListList() {
            return this.equipAffixList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public List<? extends AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder> getEquipAffixListOrBuilderList() {
            return this.equipAffixList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getEquipAffixListCount() {
            return this.equipAffixList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo getEquipAffixList(int index) {
            return this.equipAffixList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder getEquipAffixListOrBuilder(int index) {
            return this.equipAffixList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getBornTime() {
            return this.bornTime_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public List<Integer> getPendingPromoteRewardListList() {
            return this.pendingPromoteRewardList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getPendingPromoteRewardListCount() {
            return this.pendingPromoteRewardList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getPendingPromoteRewardList(int index) {
            return this.pendingPromoteRewardList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getCostumeId() {
            return this.costumeId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public boolean hasExcelInfo() {
            return this.excelInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public AvatarExcelInfoOuterClass.AvatarExcelInfo getExcelInfo() {
            return this.excelInfo_ == null ? AvatarExcelInfoOuterClass.AvatarExcelInfo.getDefaultInstance() : this.excelInfo_;
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder getExcelInfoOrBuilder() {
            return getExcelInfo();
        }

        @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
        public int getAnimHash() {
            return this.animHash_;
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
            if (this.avatarId_ != 0) {
                output.writeUInt32(1, this.avatarId_);
            }
            if (this.guid_ != 0) {
                output.writeUInt64(2, this.guid_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetPropMap(), PropMapDefaultEntryHolder.defaultEntry, 3);
            if (this.lifeState_ != 0) {
                output.writeUInt32(4, this.lifeState_);
            }
            if (getEquipGuidListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.equipGuidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.equipGuidList_.size(); i++) {
                output.writeUInt64NoTag(this.equipGuidList_.getLong(i));
            }
            if (getTalentIdListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.talentIdListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.talentIdList_.size(); i2++) {
                output.writeUInt32NoTag(this.talentIdList_.getInt(i2));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetFightPropMap(), FightPropMapDefaultEntryHolder.defaultEntry, 7);
            if (this.trialAvatarInfo_ != null) {
                output.writeMessage(9, getTrialAvatarInfo());
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSkillMap(), SkillMapDefaultEntryHolder.defaultEntry, 10);
            if (this.skillDepotId_ != 0) {
                output.writeUInt32(11, this.skillDepotId_);
            }
            if (this.fetterInfo_ != null) {
                output.writeMessage(12, getFetterInfo());
            }
            if (this.coreProudSkillLevel_ != 0) {
                output.writeUInt32(13, this.coreProudSkillLevel_);
            }
            if (getInherentProudSkillListList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.inherentProudSkillListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.inherentProudSkillList_.size(); i3++) {
                output.writeUInt32NoTag(this.inherentProudSkillList_.getInt(i3));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSkillLevelMap(), SkillLevelMapDefaultEntryHolder.defaultEntry, 15);
            if (this.expeditionState_ != AvatarExpeditionStateOuterClass.AvatarExpeditionState.AVATAR_EXPEDITION_STATE_NONE.getNumber()) {
                output.writeEnum(16, this.expeditionState_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetProudSkillExtraLevelMap(), ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry, 17);
            if (this.isFocus_) {
                output.writeBool(18, this.isFocus_);
            }
            if (this.avatarType_ != 0) {
                output.writeUInt32(19, this.avatarType_);
            }
            if (getTeamResonanceListList().size() > 0) {
                output.writeUInt32NoTag(162);
                output.writeUInt32NoTag(this.teamResonanceListMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.teamResonanceList_.size(); i4++) {
                output.writeUInt32NoTag(this.teamResonanceList_.getInt(i4));
            }
            if (this.wearingFlycloakId_ != 0) {
                output.writeUInt32(21, this.wearingFlycloakId_);
            }
            for (int i5 = 0; i5 < this.equipAffixList_.size(); i5++) {
                output.writeMessage(22, this.equipAffixList_.get(i5));
            }
            if (this.bornTime_ != 0) {
                output.writeUInt32(23, this.bornTime_);
            }
            if (getPendingPromoteRewardListList().size() > 0) {
                output.writeUInt32NoTag(194);
                output.writeUInt32NoTag(this.pendingPromoteRewardListMemoizedSerializedSize);
            }
            for (int i6 = 0; i6 < this.pendingPromoteRewardList_.size(); i6++) {
                output.writeUInt32NoTag(this.pendingPromoteRewardList_.getInt(i6));
            }
            if (this.costumeId_ != 0) {
                output.writeUInt32(25, this.costumeId_);
            }
            if (this.excelInfo_ != null) {
                output.writeMessage(26, getExcelInfo());
            }
            if (this.animHash_ != 0) {
                output.writeUInt32(27, this.animHash_);
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
            if (this.avatarId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.avatarId_);
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(2, this.guid_);
            }
            for (Map.Entry<Integer, PropValueOuterClass.PropValue> entry : internalGetPropMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(3, PropMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.lifeState_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.lifeState_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.equipGuidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt64SizeNoTag(this.equipGuidList_.getLong(i));
            }
            int size3 = size2 + dataSize;
            if (!getEquipGuidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.equipGuidListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.talentIdList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.talentIdList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getTalentIdListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.talentIdListMemoizedSerializedSize = dataSize2;
            for (Map.Entry<Integer, Float> entry2 : internalGetFightPropMap().getMap().entrySet()) {
                size4 += CodedOutputStream.computeMessageSize(7, FightPropMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (this.trialAvatarInfo_ != null) {
                size4 += CodedOutputStream.computeMessageSize(9, getTrialAvatarInfo());
            }
            for (Map.Entry<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> entry3 : internalGetSkillMap().getMap().entrySet()) {
                size4 += CodedOutputStream.computeMessageSize(10, SkillMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry3.getKey()).setValue(entry3.getValue()).build());
            }
            if (this.skillDepotId_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(11, this.skillDepotId_);
            }
            if (this.fetterInfo_ != null) {
                size4 += CodedOutputStream.computeMessageSize(12, getFetterInfo());
            }
            if (this.coreProudSkillLevel_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(13, this.coreProudSkillLevel_);
            }
            int dataSize3 = 0;
            for (int i3 = 0; i3 < this.inherentProudSkillList_.size(); i3++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.inherentProudSkillList_.getInt(i3));
            }
            int size5 = size4 + dataSize3;
            if (!getInherentProudSkillListList().isEmpty()) {
                size5 = size5 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.inherentProudSkillListMemoizedSerializedSize = dataSize3;
            for (Map.Entry<Integer, Integer> entry4 : internalGetSkillLevelMap().getMap().entrySet()) {
                size5 += CodedOutputStream.computeMessageSize(15, SkillLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry4.getKey()).setValue(entry4.getValue()).build());
            }
            if (this.expeditionState_ != AvatarExpeditionStateOuterClass.AvatarExpeditionState.AVATAR_EXPEDITION_STATE_NONE.getNumber()) {
                size5 += CodedOutputStream.computeEnumSize(16, this.expeditionState_);
            }
            for (Map.Entry<Integer, Integer> entry5 : internalGetProudSkillExtraLevelMap().getMap().entrySet()) {
                size5 += CodedOutputStream.computeMessageSize(17, ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry5.getKey()).setValue(entry5.getValue()).build());
            }
            if (this.isFocus_) {
                size5 += CodedOutputStream.computeBoolSize(18, this.isFocus_);
            }
            if (this.avatarType_ != 0) {
                size5 += CodedOutputStream.computeUInt32Size(19, this.avatarType_);
            }
            int dataSize4 = 0;
            for (int i4 = 0; i4 < this.teamResonanceList_.size(); i4++) {
                dataSize4 += CodedOutputStream.computeUInt32SizeNoTag(this.teamResonanceList_.getInt(i4));
            }
            int size6 = size5 + dataSize4;
            if (!getTeamResonanceListList().isEmpty()) {
                size6 = size6 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize4);
            }
            this.teamResonanceListMemoizedSerializedSize = dataSize4;
            if (this.wearingFlycloakId_ != 0) {
                size6 += CodedOutputStream.computeUInt32Size(21, this.wearingFlycloakId_);
            }
            for (int i5 = 0; i5 < this.equipAffixList_.size(); i5++) {
                size6 += CodedOutputStream.computeMessageSize(22, this.equipAffixList_.get(i5));
            }
            if (this.bornTime_ != 0) {
                size6 += CodedOutputStream.computeUInt32Size(23, this.bornTime_);
            }
            int dataSize5 = 0;
            for (int i6 = 0; i6 < this.pendingPromoteRewardList_.size(); i6++) {
                dataSize5 += CodedOutputStream.computeUInt32SizeNoTag(this.pendingPromoteRewardList_.getInt(i6));
            }
            int size7 = size6 + dataSize5;
            if (!getPendingPromoteRewardListList().isEmpty()) {
                size7 = size7 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize5);
            }
            this.pendingPromoteRewardListMemoizedSerializedSize = dataSize5;
            if (this.costumeId_ != 0) {
                size7 += CodedOutputStream.computeUInt32Size(25, this.costumeId_);
            }
            if (this.excelInfo_ != null) {
                size7 += CodedOutputStream.computeMessageSize(26, getExcelInfo());
            }
            if (this.animHash_ != 0) {
                size7 += CodedOutputStream.computeUInt32Size(27, this.animHash_);
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
            if (!(obj instanceof AvatarInfo)) {
                return equals(obj);
            }
            AvatarInfo other = (AvatarInfo) obj;
            if (getAvatarId() != other.getAvatarId() || getGuid() != other.getGuid() || !internalGetPropMap().equals(other.internalGetPropMap()) || getLifeState() != other.getLifeState() || !getEquipGuidListList().equals(other.getEquipGuidListList()) || !getTalentIdListList().equals(other.getTalentIdListList()) || !internalGetFightPropMap().equals(other.internalGetFightPropMap()) || hasTrialAvatarInfo() != other.hasTrialAvatarInfo()) {
                return false;
            }
            if ((hasTrialAvatarInfo() && !getTrialAvatarInfo().equals(other.getTrialAvatarInfo())) || !internalGetSkillMap().equals(other.internalGetSkillMap()) || getSkillDepotId() != other.getSkillDepotId() || hasFetterInfo() != other.hasFetterInfo()) {
                return false;
            }
            if ((!hasFetterInfo() || getFetterInfo().equals(other.getFetterInfo())) && getCoreProudSkillLevel() == other.getCoreProudSkillLevel() && getInherentProudSkillListList().equals(other.getInherentProudSkillListList()) && internalGetSkillLevelMap().equals(other.internalGetSkillLevelMap()) && this.expeditionState_ == other.expeditionState_ && internalGetProudSkillExtraLevelMap().equals(other.internalGetProudSkillExtraLevelMap()) && getIsFocus() == other.getIsFocus() && getAvatarType() == other.getAvatarType() && getTeamResonanceListList().equals(other.getTeamResonanceListList()) && getWearingFlycloakId() == other.getWearingFlycloakId() && getEquipAffixListList().equals(other.getEquipAffixListList()) && getBornTime() == other.getBornTime() && getPendingPromoteRewardListList().equals(other.getPendingPromoteRewardListList()) && getCostumeId() == other.getCostumeId() && hasExcelInfo() == other.hasExcelInfo()) {
                return (!hasExcelInfo() || getExcelInfo().equals(other.getExcelInfo())) && getAnimHash() == other.getAnimHash() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getAvatarId())) + 2)) + Internal.hashLong(getGuid());
            if (!internalGetPropMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 3)) + internalGetPropMap().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 4)) + getLifeState();
            if (getEquipGuidListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 5)) + getEquipGuidListList().hashCode();
            }
            if (getTalentIdListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 6)) + getTalentIdListList().hashCode();
            }
            if (!internalGetFightPropMap().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 7)) + internalGetFightPropMap().hashCode();
            }
            if (hasTrialAvatarInfo()) {
                hash2 = (53 * ((37 * hash2) + 9)) + getTrialAvatarInfo().hashCode();
            }
            if (!internalGetSkillMap().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 10)) + internalGetSkillMap().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 11)) + getSkillDepotId();
            if (hasFetterInfo()) {
                hash3 = (53 * ((37 * hash3) + 12)) + getFetterInfo().hashCode();
            }
            int hash4 = (53 * ((37 * hash3) + 13)) + getCoreProudSkillLevel();
            if (getInherentProudSkillListCount() > 0) {
                hash4 = (53 * ((37 * hash4) + 14)) + getInherentProudSkillListList().hashCode();
            }
            if (!internalGetSkillLevelMap().getMap().isEmpty()) {
                hash4 = (53 * ((37 * hash4) + 15)) + internalGetSkillLevelMap().hashCode();
            }
            int hash5 = (53 * ((37 * hash4) + 16)) + this.expeditionState_;
            if (!internalGetProudSkillExtraLevelMap().getMap().isEmpty()) {
                hash5 = (53 * ((37 * hash5) + 17)) + internalGetProudSkillExtraLevelMap().hashCode();
            }
            int hash6 = (53 * ((37 * ((53 * ((37 * hash5) + 18)) + Internal.hashBoolean(getIsFocus()))) + 19)) + getAvatarType();
            if (getTeamResonanceListCount() > 0) {
                hash6 = (53 * ((37 * hash6) + 20)) + getTeamResonanceListList().hashCode();
            }
            int hash7 = (53 * ((37 * hash6) + 21)) + getWearingFlycloakId();
            if (getEquipAffixListCount() > 0) {
                hash7 = (53 * ((37 * hash7) + 22)) + getEquipAffixListList().hashCode();
            }
            int hash8 = (53 * ((37 * hash7) + 23)) + getBornTime();
            if (getPendingPromoteRewardListCount() > 0) {
                hash8 = (53 * ((37 * hash8) + 24)) + getPendingPromoteRewardListList().hashCode();
            }
            int hash9 = (53 * ((37 * hash8) + 25)) + getCostumeId();
            if (hasExcelInfo()) {
                hash9 = (53 * ((37 * hash9) + 26)) + getExcelInfo().hashCode();
            }
            int hash10 = (29 * ((53 * ((37 * hash9) + 27)) + getAnimHash())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash10;
            return hash10;
        }

        public static AvatarInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarInfo parseFrom(InputStream input) throws IOException {
            return (AvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarInfo parseFrom(CodedInputStream input) throws IOException {
            return (AvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarInfoOuterClass$AvatarInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarInfoOrBuilder {
            private int bitField0_;
            private int avatarId_;
            private long guid_;
            private MapField<Integer, PropValueOuterClass.PropValue> propMap_;
            private int lifeState_;
            private MapField<Integer, Float> fightPropMap_;
            private TrialAvatarInfoOuterClass.TrialAvatarInfo trialAvatarInfo_;
            private SingleFieldBuilderV3<TrialAvatarInfoOuterClass.TrialAvatarInfo, TrialAvatarInfoOuterClass.TrialAvatarInfo.Builder, TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder> trialAvatarInfoBuilder_;
            private MapField<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> skillMap_;
            private int skillDepotId_;
            private AvatarFetterInfoOuterClass.AvatarFetterInfo fetterInfo_;
            private SingleFieldBuilderV3<AvatarFetterInfoOuterClass.AvatarFetterInfo, AvatarFetterInfoOuterClass.AvatarFetterInfo.Builder, AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder> fetterInfoBuilder_;
            private int coreProudSkillLevel_;
            private MapField<Integer, Integer> skillLevelMap_;
            private MapField<Integer, Integer> proudSkillExtraLevelMap_;
            private boolean isFocus_;
            private int avatarType_;
            private int wearingFlycloakId_;
            private RepeatedFieldBuilderV3<AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo, AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.Builder, AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder> equipAffixListBuilder_;
            private int bornTime_;
            private int costumeId_;
            private AvatarExcelInfoOuterClass.AvatarExcelInfo excelInfo_;
            private SingleFieldBuilderV3<AvatarExcelInfoOuterClass.AvatarExcelInfo, AvatarExcelInfoOuterClass.AvatarExcelInfo.Builder, AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder> excelInfoBuilder_;
            private int animHash_;
            private Internal.LongList equipGuidList_ = AvatarInfo.emptyLongList();
            private Internal.IntList talentIdList_ = AvatarInfo.emptyIntList();
            private Internal.IntList inherentProudSkillList_ = AvatarInfo.emptyIntList();
            private int expeditionState_ = 0;
            private Internal.IntList teamResonanceList_ = AvatarInfo.emptyIntList();
            private List<AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo> equipAffixList_ = Collections.emptyList();
            private Internal.IntList pendingPromoteRewardList_ = AvatarInfo.emptyIntList();

            /*  JADX ERROR: Dependency scan failed at insn: 0x006A: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x006A: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 3: goto L_0x004c;
                        case 4: goto L_0x0065;
                        case 5: goto L_0x0065;
                        case 6: goto L_0x0065;
                        case 7: goto L_0x0051;
                        case 8: goto L_0x0065;
                        case 9: goto L_0x0065;
                        case 10: goto L_0x0056;
                        case 11: goto L_0x0065;
                        case 12: goto L_0x0065;
                        case 13: goto L_0x0065;
                        case 14: goto L_0x0065;
                        case 15: goto L_0x005b;
                        case 16: goto L_0x0065;
                        case 17: goto L_0x0060;
                        default: goto L_0x0065;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetPropMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetFightPropMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSkillMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSkillLevelMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetProudSkillExtraLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
            }

            /*  JADX ERROR: Dependency scan failed at insn: 0x006A: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x006A: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 3: goto L_0x004c;
                        case 4: goto L_0x0065;
                        case 5: goto L_0x0065;
                        case 6: goto L_0x0065;
                        case 7: goto L_0x0051;
                        case 8: goto L_0x0065;
                        case 9: goto L_0x0065;
                        case 10: goto L_0x0056;
                        case 11: goto L_0x0065;
                        case 12: goto L_0x0065;
                        case 13: goto L_0x0065;
                        case 14: goto L_0x0065;
                        case 15: goto L_0x005b;
                        case 16: goto L_0x0065;
                        case 17: goto L_0x0060;
                        default: goto L_0x0065;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutablePropMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableFightPropMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSkillMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSkillLevelMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableProudSkillExtraLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarInfoOuterClass.internal_static_AvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarInfoOuterClass.internal_static_AvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarInfo.alwaysUseFieldBuilders) {
                    getEquipAffixListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.avatarId_ = 0;
                this.guid_ = 0;
                internalGetMutablePropMap().clear();
                this.lifeState_ = 0;
                this.equipGuidList_ = AvatarInfo.emptyLongList();
                this.bitField0_ &= -3;
                this.talentIdList_ = AvatarInfo.emptyIntList();
                this.bitField0_ &= -5;
                internalGetMutableFightPropMap().clear();
                if (this.trialAvatarInfoBuilder_ == null) {
                    this.trialAvatarInfo_ = null;
                } else {
                    this.trialAvatarInfo_ = null;
                    this.trialAvatarInfoBuilder_ = null;
                }
                internalGetMutableSkillMap().clear();
                this.skillDepotId_ = 0;
                if (this.fetterInfoBuilder_ == null) {
                    this.fetterInfo_ = null;
                } else {
                    this.fetterInfo_ = null;
                    this.fetterInfoBuilder_ = null;
                }
                this.coreProudSkillLevel_ = 0;
                this.inherentProudSkillList_ = AvatarInfo.emptyIntList();
                this.bitField0_ &= -33;
                internalGetMutableSkillLevelMap().clear();
                this.expeditionState_ = 0;
                internalGetMutableProudSkillExtraLevelMap().clear();
                this.isFocus_ = false;
                this.avatarType_ = 0;
                this.teamResonanceList_ = AvatarInfo.emptyIntList();
                this.bitField0_ &= -257;
                this.wearingFlycloakId_ = 0;
                if (this.equipAffixListBuilder_ == null) {
                    this.equipAffixList_ = Collections.emptyList();
                    this.bitField0_ &= -513;
                } else {
                    this.equipAffixListBuilder_.clear();
                }
                this.bornTime_ = 0;
                this.pendingPromoteRewardList_ = AvatarInfo.emptyIntList();
                this.bitField0_ &= -1025;
                this.costumeId_ = 0;
                if (this.excelInfoBuilder_ == null) {
                    this.excelInfo_ = null;
                } else {
                    this.excelInfo_ = null;
                    this.excelInfoBuilder_ = null;
                }
                this.animHash_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarInfoOuterClass.internal_static_AvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarInfo getDefaultInstanceForType() {
                return AvatarInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarInfo build() {
                AvatarInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarInfo buildPartial() {
                AvatarInfo result = new AvatarInfo(this);
                int i = this.bitField0_;
                result.avatarId_ = this.avatarId_;
                result.guid_ = this.guid_;
                result.propMap_ = internalGetPropMap();
                result.propMap_.makeImmutable();
                result.lifeState_ = this.lifeState_;
                if ((this.bitField0_ & 2) != 0) {
                    this.equipGuidList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.equipGuidList_ = this.equipGuidList_;
                if ((this.bitField0_ & 4) != 0) {
                    this.talentIdList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.talentIdList_ = this.talentIdList_;
                result.fightPropMap_ = internalGetFightPropMap();
                result.fightPropMap_.makeImmutable();
                if (this.trialAvatarInfoBuilder_ == null) {
                    result.trialAvatarInfo_ = this.trialAvatarInfo_;
                } else {
                    result.trialAvatarInfo_ = this.trialAvatarInfoBuilder_.build();
                }
                result.skillMap_ = internalGetSkillMap();
                result.skillMap_.makeImmutable();
                result.skillDepotId_ = this.skillDepotId_;
                if (this.fetterInfoBuilder_ == null) {
                    result.fetterInfo_ = this.fetterInfo_;
                } else {
                    result.fetterInfo_ = this.fetterInfoBuilder_.build();
                }
                result.coreProudSkillLevel_ = this.coreProudSkillLevel_;
                if ((this.bitField0_ & 32) != 0) {
                    this.inherentProudSkillList_.makeImmutable();
                    this.bitField0_ &= -33;
                }
                result.inherentProudSkillList_ = this.inherentProudSkillList_;
                result.skillLevelMap_ = internalGetSkillLevelMap();
                result.skillLevelMap_.makeImmutable();
                result.expeditionState_ = this.expeditionState_;
                result.proudSkillExtraLevelMap_ = internalGetProudSkillExtraLevelMap();
                result.proudSkillExtraLevelMap_.makeImmutable();
                result.isFocus_ = this.isFocus_;
                result.avatarType_ = this.avatarType_;
                if ((this.bitField0_ & 256) != 0) {
                    this.teamResonanceList_.makeImmutable();
                    this.bitField0_ &= -257;
                }
                result.teamResonanceList_ = this.teamResonanceList_;
                result.wearingFlycloakId_ = this.wearingFlycloakId_;
                if (this.equipAffixListBuilder_ == null) {
                    if ((this.bitField0_ & 512) != 0) {
                        this.equipAffixList_ = Collections.unmodifiableList(this.equipAffixList_);
                        this.bitField0_ &= -513;
                    }
                    result.equipAffixList_ = this.equipAffixList_;
                } else {
                    result.equipAffixList_ = this.equipAffixListBuilder_.build();
                }
                result.bornTime_ = this.bornTime_;
                if ((this.bitField0_ & 1024) != 0) {
                    this.pendingPromoteRewardList_.makeImmutable();
                    this.bitField0_ &= -1025;
                }
                result.pendingPromoteRewardList_ = this.pendingPromoteRewardList_;
                result.costumeId_ = this.costumeId_;
                if (this.excelInfoBuilder_ == null) {
                    result.excelInfo_ = this.excelInfo_;
                } else {
                    result.excelInfo_ = this.excelInfoBuilder_.build();
                }
                result.animHash_ = this.animHash_;
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
                if (other instanceof AvatarInfo) {
                    return mergeFrom((AvatarInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarInfo other) {
                if (other == AvatarInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                internalGetMutablePropMap().mergeFrom(other.internalGetPropMap());
                if (other.getLifeState() != 0) {
                    setLifeState(other.getLifeState());
                }
                if (!other.equipGuidList_.isEmpty()) {
                    if (this.equipGuidList_.isEmpty()) {
                        this.equipGuidList_ = other.equipGuidList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureEquipGuidListIsMutable();
                        this.equipGuidList_.addAll(other.equipGuidList_);
                    }
                    onChanged();
                }
                if (!other.talentIdList_.isEmpty()) {
                    if (this.talentIdList_.isEmpty()) {
                        this.talentIdList_ = other.talentIdList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureTalentIdListIsMutable();
                        this.talentIdList_.addAll(other.talentIdList_);
                    }
                    onChanged();
                }
                internalGetMutableFightPropMap().mergeFrom(other.internalGetFightPropMap());
                if (other.hasTrialAvatarInfo()) {
                    mergeTrialAvatarInfo(other.getTrialAvatarInfo());
                }
                internalGetMutableSkillMap().mergeFrom(other.internalGetSkillMap());
                if (other.getSkillDepotId() != 0) {
                    setSkillDepotId(other.getSkillDepotId());
                }
                if (other.hasFetterInfo()) {
                    mergeFetterInfo(other.getFetterInfo());
                }
                if (other.getCoreProudSkillLevel() != 0) {
                    setCoreProudSkillLevel(other.getCoreProudSkillLevel());
                }
                if (!other.inherentProudSkillList_.isEmpty()) {
                    if (this.inherentProudSkillList_.isEmpty()) {
                        this.inherentProudSkillList_ = other.inherentProudSkillList_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureInherentProudSkillListIsMutable();
                        this.inherentProudSkillList_.addAll(other.inherentProudSkillList_);
                    }
                    onChanged();
                }
                internalGetMutableSkillLevelMap().mergeFrom(other.internalGetSkillLevelMap());
                if (other.expeditionState_ != 0) {
                    setExpeditionStateValue(other.getExpeditionStateValue());
                }
                internalGetMutableProudSkillExtraLevelMap().mergeFrom(other.internalGetProudSkillExtraLevelMap());
                if (other.getIsFocus()) {
                    setIsFocus(other.getIsFocus());
                }
                if (other.getAvatarType() != 0) {
                    setAvatarType(other.getAvatarType());
                }
                if (!other.teamResonanceList_.isEmpty()) {
                    if (this.teamResonanceList_.isEmpty()) {
                        this.teamResonanceList_ = other.teamResonanceList_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureTeamResonanceListIsMutable();
                        this.teamResonanceList_.addAll(other.teamResonanceList_);
                    }
                    onChanged();
                }
                if (other.getWearingFlycloakId() != 0) {
                    setWearingFlycloakId(other.getWearingFlycloakId());
                }
                if (this.equipAffixListBuilder_ == null) {
                    if (!other.equipAffixList_.isEmpty()) {
                        if (this.equipAffixList_.isEmpty()) {
                            this.equipAffixList_ = other.equipAffixList_;
                            this.bitField0_ &= -513;
                        } else {
                            ensureEquipAffixListIsMutable();
                            this.equipAffixList_.addAll(other.equipAffixList_);
                        }
                        onChanged();
                    }
                } else if (!other.equipAffixList_.isEmpty()) {
                    if (this.equipAffixListBuilder_.isEmpty()) {
                        this.equipAffixListBuilder_.dispose();
                        this.equipAffixListBuilder_ = null;
                        this.equipAffixList_ = other.equipAffixList_;
                        this.bitField0_ &= -513;
                        this.equipAffixListBuilder_ = AvatarInfo.alwaysUseFieldBuilders ? getEquipAffixListFieldBuilder() : null;
                    } else {
                        this.equipAffixListBuilder_.addAllMessages(other.equipAffixList_);
                    }
                }
                if (other.getBornTime() != 0) {
                    setBornTime(other.getBornTime());
                }
                if (!other.pendingPromoteRewardList_.isEmpty()) {
                    if (this.pendingPromoteRewardList_.isEmpty()) {
                        this.pendingPromoteRewardList_ = other.pendingPromoteRewardList_;
                        this.bitField0_ &= -1025;
                    } else {
                        ensurePendingPromoteRewardListIsMutable();
                        this.pendingPromoteRewardList_.addAll(other.pendingPromoteRewardList_);
                    }
                    onChanged();
                }
                if (other.getCostumeId() != 0) {
                    setCostumeId(other.getCostumeId());
                }
                if (other.hasExcelInfo()) {
                    mergeExcelInfo(other.getExcelInfo());
                }
                if (other.getAnimHash() != 0) {
                    setAnimHash(other.getAnimHash());
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
                AvatarInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getAvatarId() {
                return this.avatarId_;
            }

            public Builder setAvatarId(int value) {
                this.avatarId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarId() {
                this.avatarId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public long getGuid() {
                return this.guid_;
            }

            public Builder setGuid(long value) {
                this.guid_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuid() {
                this.guid_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, PropValueOuterClass.PropValue> internalGetPropMap() {
                if (this.propMap_ == null) {
                    return MapField.emptyMapField(PropMapDefaultEntryHolder.defaultEntry);
                }
                return this.propMap_;
            }

            private MapField<Integer, PropValueOuterClass.PropValue> internalGetMutablePropMap() {
                onChanged();
                if (this.propMap_ == null) {
                    this.propMap_ = MapField.newMapField(PropMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.propMap_.isMutable()) {
                    this.propMap_ = this.propMap_.copy();
                }
                return this.propMap_;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getPropMapCount() {
                return internalGetPropMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public boolean containsPropMap(int key) {
                return internalGetPropMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            @Deprecated
            public Map<Integer, PropValueOuterClass.PropValue> getPropMap() {
                return getPropMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public Map<Integer, PropValueOuterClass.PropValue> getPropMapMap() {
                return internalGetPropMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public PropValueOuterClass.PropValue getPropMapOrDefault(int key, PropValueOuterClass.PropValue defaultValue) {
                Map<Integer, PropValueOuterClass.PropValue> map = internalGetPropMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public PropValueOuterClass.PropValue getPropMapOrThrow(int key) {
                Map<Integer, PropValueOuterClass.PropValue> map = internalGetPropMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearPropMap() {
                internalGetMutablePropMap().getMutableMap().clear();
                return this;
            }

            public Builder removePropMap(int key) {
                internalGetMutablePropMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, PropValueOuterClass.PropValue> getMutablePropMap() {
                return internalGetMutablePropMap().getMutableMap();
            }

            public Builder putPropMap(int key, PropValueOuterClass.PropValue value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutablePropMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllPropMap(Map<Integer, PropValueOuterClass.PropValue> values) {
                internalGetMutablePropMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getLifeState() {
                return this.lifeState_;
            }

            public Builder setLifeState(int value) {
                this.lifeState_ = value;
                onChanged();
                return this;
            }

            public Builder clearLifeState() {
                this.lifeState_ = 0;
                onChanged();
                return this;
            }

            private void ensureEquipGuidListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.equipGuidList_ = AvatarInfo.mutableCopy(this.equipGuidList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public List<Long> getEquipGuidListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.equipGuidList_) : this.equipGuidList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getEquipGuidListCount() {
                return this.equipGuidList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public long getEquipGuidList(int index) {
                return this.equipGuidList_.getLong(index);
            }

            public Builder setEquipGuidList(int index, long value) {
                ensureEquipGuidListIsMutable();
                this.equipGuidList_.setLong(index, value);
                onChanged();
                return this;
            }

            public Builder addEquipGuidList(long value) {
                ensureEquipGuidListIsMutable();
                this.equipGuidList_.addLong(value);
                onChanged();
                return this;
            }

            public Builder addAllEquipGuidList(Iterable<? extends Long> values) {
                ensureEquipGuidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.equipGuidList_);
                onChanged();
                return this;
            }

            public Builder clearEquipGuidList() {
                this.equipGuidList_ = AvatarInfo.emptyLongList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureTalentIdListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.talentIdList_ = AvatarInfo.mutableCopy(this.talentIdList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public List<Integer> getTalentIdListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.talentIdList_) : this.talentIdList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getTalentIdListCount() {
                return this.talentIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getTalentIdList(int index) {
                return this.talentIdList_.getInt(index);
            }

            public Builder setTalentIdList(int index, int value) {
                ensureTalentIdListIsMutable();
                this.talentIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addTalentIdList(int value) {
                ensureTalentIdListIsMutable();
                this.talentIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllTalentIdList(Iterable<? extends Integer> values) {
                ensureTalentIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.talentIdList_);
                onChanged();
                return this;
            }

            public Builder clearTalentIdList() {
                this.talentIdList_ = AvatarInfo.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private MapField<Integer, Float> internalGetFightPropMap() {
                if (this.fightPropMap_ == null) {
                    return MapField.emptyMapField(FightPropMapDefaultEntryHolder.defaultEntry);
                }
                return this.fightPropMap_;
            }

            private MapField<Integer, Float> internalGetMutableFightPropMap() {
                onChanged();
                if (this.fightPropMap_ == null) {
                    this.fightPropMap_ = MapField.newMapField(FightPropMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.fightPropMap_.isMutable()) {
                    this.fightPropMap_ = this.fightPropMap_.copy();
                }
                return this.fightPropMap_;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getFightPropMapCount() {
                return internalGetFightPropMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public boolean containsFightPropMap(int key) {
                return internalGetFightPropMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            @Deprecated
            public Map<Integer, Float> getFightPropMap() {
                return getFightPropMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public Map<Integer, Float> getFightPropMapMap() {
                return internalGetFightPropMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public float getFightPropMapOrDefault(int key, float defaultValue) {
                Map<Integer, Float> map = internalGetFightPropMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).floatValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public float getFightPropMapOrThrow(int key) {
                Map<Integer, Float> map = internalGetFightPropMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).floatValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearFightPropMap() {
                internalGetMutableFightPropMap().getMutableMap().clear();
                return this;
            }

            public Builder removeFightPropMap(int key) {
                internalGetMutableFightPropMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Float> getMutableFightPropMap() {
                return internalGetMutableFightPropMap().getMutableMap();
            }

            public Builder putFightPropMap(int key, float value) {
                internalGetMutableFightPropMap().getMutableMap().put(Integer.valueOf(key), Float.valueOf(value));
                return this;
            }

            public Builder putAllFightPropMap(Map<Integer, Float> values) {
                internalGetMutableFightPropMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public boolean hasTrialAvatarInfo() {
                return (this.trialAvatarInfoBuilder_ == null && this.trialAvatarInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public TrialAvatarInfoOuterClass.TrialAvatarInfo getTrialAvatarInfo() {
                if (this.trialAvatarInfoBuilder_ == null) {
                    return this.trialAvatarInfo_ == null ? TrialAvatarInfoOuterClass.TrialAvatarInfo.getDefaultInstance() : this.trialAvatarInfo_;
                }
                return this.trialAvatarInfoBuilder_.getMessage();
            }

            public Builder setTrialAvatarInfo(TrialAvatarInfoOuterClass.TrialAvatarInfo value) {
                if (this.trialAvatarInfoBuilder_ != null) {
                    this.trialAvatarInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.trialAvatarInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setTrialAvatarInfo(TrialAvatarInfoOuterClass.TrialAvatarInfo.Builder builderForValue) {
                if (this.trialAvatarInfoBuilder_ == null) {
                    this.trialAvatarInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.trialAvatarInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeTrialAvatarInfo(TrialAvatarInfoOuterClass.TrialAvatarInfo value) {
                if (this.trialAvatarInfoBuilder_ == null) {
                    if (this.trialAvatarInfo_ != null) {
                        this.trialAvatarInfo_ = TrialAvatarInfoOuterClass.TrialAvatarInfo.newBuilder(this.trialAvatarInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.trialAvatarInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.trialAvatarInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearTrialAvatarInfo() {
                if (this.trialAvatarInfoBuilder_ == null) {
                    this.trialAvatarInfo_ = null;
                    onChanged();
                } else {
                    this.trialAvatarInfo_ = null;
                    this.trialAvatarInfoBuilder_ = null;
                }
                return this;
            }

            public TrialAvatarInfoOuterClass.TrialAvatarInfo.Builder getTrialAvatarInfoBuilder() {
                onChanged();
                return getTrialAvatarInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder getTrialAvatarInfoOrBuilder() {
                if (this.trialAvatarInfoBuilder_ != null) {
                    return this.trialAvatarInfoBuilder_.getMessageOrBuilder();
                }
                return this.trialAvatarInfo_ == null ? TrialAvatarInfoOuterClass.TrialAvatarInfo.getDefaultInstance() : this.trialAvatarInfo_;
            }

            private SingleFieldBuilderV3<TrialAvatarInfoOuterClass.TrialAvatarInfo, TrialAvatarInfoOuterClass.TrialAvatarInfo.Builder, TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder> getTrialAvatarInfoFieldBuilder() {
                if (this.trialAvatarInfoBuilder_ == null) {
                    this.trialAvatarInfoBuilder_ = new SingleFieldBuilderV3<>(getTrialAvatarInfo(), getParentForChildren(), isClean());
                    this.trialAvatarInfo_ = null;
                }
                return this.trialAvatarInfoBuilder_;
            }

            private MapField<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> internalGetSkillMap() {
                if (this.skillMap_ == null) {
                    return MapField.emptyMapField(SkillMapDefaultEntryHolder.defaultEntry);
                }
                return this.skillMap_;
            }

            private MapField<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> internalGetMutableSkillMap() {
                onChanged();
                if (this.skillMap_ == null) {
                    this.skillMap_ = MapField.newMapField(SkillMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.skillMap_.isMutable()) {
                    this.skillMap_ = this.skillMap_.copy();
                }
                return this.skillMap_;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getSkillMapCount() {
                return internalGetSkillMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public boolean containsSkillMap(int key) {
                return internalGetSkillMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            @Deprecated
            public Map<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> getSkillMap() {
                return getSkillMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public Map<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> getSkillMapMap() {
                return internalGetSkillMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public AvatarSkillInfoOuterClass.AvatarSkillInfo getSkillMapOrDefault(int key, AvatarSkillInfoOuterClass.AvatarSkillInfo defaultValue) {
                Map<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> map = internalGetSkillMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public AvatarSkillInfoOuterClass.AvatarSkillInfo getSkillMapOrThrow(int key) {
                Map<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> map = internalGetSkillMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSkillMap() {
                internalGetMutableSkillMap().getMutableMap().clear();
                return this;
            }

            public Builder removeSkillMap(int key) {
                internalGetMutableSkillMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> getMutableSkillMap() {
                return internalGetMutableSkillMap().getMutableMap();
            }

            public Builder putSkillMap(int key, AvatarSkillInfoOuterClass.AvatarSkillInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableSkillMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllSkillMap(Map<Integer, AvatarSkillInfoOuterClass.AvatarSkillInfo> values) {
                internalGetMutableSkillMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getSkillDepotId() {
                return this.skillDepotId_;
            }

            public Builder setSkillDepotId(int value) {
                this.skillDepotId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSkillDepotId() {
                this.skillDepotId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public boolean hasFetterInfo() {
                return (this.fetterInfoBuilder_ == null && this.fetterInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public AvatarFetterInfoOuterClass.AvatarFetterInfo getFetterInfo() {
                if (this.fetterInfoBuilder_ == null) {
                    return this.fetterInfo_ == null ? AvatarFetterInfoOuterClass.AvatarFetterInfo.getDefaultInstance() : this.fetterInfo_;
                }
                return this.fetterInfoBuilder_.getMessage();
            }

            public Builder setFetterInfo(AvatarFetterInfoOuterClass.AvatarFetterInfo value) {
                if (this.fetterInfoBuilder_ != null) {
                    this.fetterInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.fetterInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setFetterInfo(AvatarFetterInfoOuterClass.AvatarFetterInfo.Builder builderForValue) {
                if (this.fetterInfoBuilder_ == null) {
                    this.fetterInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.fetterInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeFetterInfo(AvatarFetterInfoOuterClass.AvatarFetterInfo value) {
                if (this.fetterInfoBuilder_ == null) {
                    if (this.fetterInfo_ != null) {
                        this.fetterInfo_ = AvatarFetterInfoOuterClass.AvatarFetterInfo.newBuilder(this.fetterInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.fetterInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.fetterInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearFetterInfo() {
                if (this.fetterInfoBuilder_ == null) {
                    this.fetterInfo_ = null;
                    onChanged();
                } else {
                    this.fetterInfo_ = null;
                    this.fetterInfoBuilder_ = null;
                }
                return this;
            }

            public AvatarFetterInfoOuterClass.AvatarFetterInfo.Builder getFetterInfoBuilder() {
                onChanged();
                return getFetterInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder getFetterInfoOrBuilder() {
                if (this.fetterInfoBuilder_ != null) {
                    return this.fetterInfoBuilder_.getMessageOrBuilder();
                }
                return this.fetterInfo_ == null ? AvatarFetterInfoOuterClass.AvatarFetterInfo.getDefaultInstance() : this.fetterInfo_;
            }

            private SingleFieldBuilderV3<AvatarFetterInfoOuterClass.AvatarFetterInfo, AvatarFetterInfoOuterClass.AvatarFetterInfo.Builder, AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder> getFetterInfoFieldBuilder() {
                if (this.fetterInfoBuilder_ == null) {
                    this.fetterInfoBuilder_ = new SingleFieldBuilderV3<>(getFetterInfo(), getParentForChildren(), isClean());
                    this.fetterInfo_ = null;
                }
                return this.fetterInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getCoreProudSkillLevel() {
                return this.coreProudSkillLevel_;
            }

            public Builder setCoreProudSkillLevel(int value) {
                this.coreProudSkillLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearCoreProudSkillLevel() {
                this.coreProudSkillLevel_ = 0;
                onChanged();
                return this;
            }

            private void ensureInherentProudSkillListIsMutable() {
                if ((this.bitField0_ & 32) == 0) {
                    this.inherentProudSkillList_ = AvatarInfo.mutableCopy(this.inherentProudSkillList_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public List<Integer> getInherentProudSkillListList() {
                return (this.bitField0_ & 32) != 0 ? Collections.unmodifiableList(this.inherentProudSkillList_) : this.inherentProudSkillList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getInherentProudSkillListCount() {
                return this.inherentProudSkillList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getInherentProudSkillList(int index) {
                return this.inherentProudSkillList_.getInt(index);
            }

            public Builder setInherentProudSkillList(int index, int value) {
                ensureInherentProudSkillListIsMutable();
                this.inherentProudSkillList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addInherentProudSkillList(int value) {
                ensureInherentProudSkillListIsMutable();
                this.inherentProudSkillList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllInherentProudSkillList(Iterable<? extends Integer> values) {
                ensureInherentProudSkillListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.inherentProudSkillList_);
                onChanged();
                return this;
            }

            public Builder clearInherentProudSkillList() {
                this.inherentProudSkillList_ = AvatarInfo.emptyIntList();
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetSkillLevelMap() {
                if (this.skillLevelMap_ == null) {
                    return MapField.emptyMapField(SkillLevelMapDefaultEntryHolder.defaultEntry);
                }
                return this.skillLevelMap_;
            }

            private MapField<Integer, Integer> internalGetMutableSkillLevelMap() {
                onChanged();
                if (this.skillLevelMap_ == null) {
                    this.skillLevelMap_ = MapField.newMapField(SkillLevelMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.skillLevelMap_.isMutable()) {
                    this.skillLevelMap_ = this.skillLevelMap_.copy();
                }
                return this.skillLevelMap_;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getSkillLevelMapCount() {
                return internalGetSkillLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public boolean containsSkillLevelMap(int key) {
                return internalGetSkillLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getSkillLevelMap() {
                return getSkillLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public Map<Integer, Integer> getSkillLevelMapMap() {
                return internalGetSkillLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getSkillLevelMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetSkillLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getSkillLevelMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetSkillLevelMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSkillLevelMap() {
                internalGetMutableSkillLevelMap().getMutableMap().clear();
                return this;
            }

            public Builder removeSkillLevelMap(int key) {
                internalGetMutableSkillLevelMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableSkillLevelMap() {
                return internalGetMutableSkillLevelMap().getMutableMap();
            }

            public Builder putSkillLevelMap(int key, int value) {
                internalGetMutableSkillLevelMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllSkillLevelMap(Map<Integer, Integer> values) {
                internalGetMutableSkillLevelMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getExpeditionStateValue() {
                return this.expeditionState_;
            }

            public Builder setExpeditionStateValue(int value) {
                this.expeditionState_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public AvatarExpeditionStateOuterClass.AvatarExpeditionState getExpeditionState() {
                AvatarExpeditionStateOuterClass.AvatarExpeditionState result = AvatarExpeditionStateOuterClass.AvatarExpeditionState.valueOf(this.expeditionState_);
                return result == null ? AvatarExpeditionStateOuterClass.AvatarExpeditionState.UNRECOGNIZED : result;
            }

            public Builder setExpeditionState(AvatarExpeditionStateOuterClass.AvatarExpeditionState value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.expeditionState_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearExpeditionState() {
                this.expeditionState_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetProudSkillExtraLevelMap() {
                if (this.proudSkillExtraLevelMap_ == null) {
                    return MapField.emptyMapField(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry);
                }
                return this.proudSkillExtraLevelMap_;
            }

            private MapField<Integer, Integer> internalGetMutableProudSkillExtraLevelMap() {
                onChanged();
                if (this.proudSkillExtraLevelMap_ == null) {
                    this.proudSkillExtraLevelMap_ = MapField.newMapField(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.proudSkillExtraLevelMap_.isMutable()) {
                    this.proudSkillExtraLevelMap_ = this.proudSkillExtraLevelMap_.copy();
                }
                return this.proudSkillExtraLevelMap_;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getProudSkillExtraLevelMapCount() {
                return internalGetProudSkillExtraLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public boolean containsProudSkillExtraLevelMap(int key) {
                return internalGetProudSkillExtraLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getProudSkillExtraLevelMap() {
                return getProudSkillExtraLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public Map<Integer, Integer> getProudSkillExtraLevelMapMap() {
                return internalGetProudSkillExtraLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getProudSkillExtraLevelMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetProudSkillExtraLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getProudSkillExtraLevelMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetProudSkillExtraLevelMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearProudSkillExtraLevelMap() {
                internalGetMutableProudSkillExtraLevelMap().getMutableMap().clear();
                return this;
            }

            public Builder removeProudSkillExtraLevelMap(int key) {
                internalGetMutableProudSkillExtraLevelMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableProudSkillExtraLevelMap() {
                return internalGetMutableProudSkillExtraLevelMap().getMutableMap();
            }

            public Builder putProudSkillExtraLevelMap(int key, int value) {
                internalGetMutableProudSkillExtraLevelMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllProudSkillExtraLevelMap(Map<Integer, Integer> values) {
                internalGetMutableProudSkillExtraLevelMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public boolean getIsFocus() {
                return this.isFocus_;
            }

            public Builder setIsFocus(boolean value) {
                this.isFocus_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFocus() {
                this.isFocus_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getAvatarType() {
                return this.avatarType_;
            }

            public Builder setAvatarType(int value) {
                this.avatarType_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarType() {
                this.avatarType_ = 0;
                onChanged();
                return this;
            }

            private void ensureTeamResonanceListIsMutable() {
                if ((this.bitField0_ & 256) == 0) {
                    this.teamResonanceList_ = AvatarInfo.mutableCopy(this.teamResonanceList_);
                    this.bitField0_ |= 256;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public List<Integer> getTeamResonanceListList() {
                return (this.bitField0_ & 256) != 0 ? Collections.unmodifiableList(this.teamResonanceList_) : this.teamResonanceList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getTeamResonanceListCount() {
                return this.teamResonanceList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getTeamResonanceList(int index) {
                return this.teamResonanceList_.getInt(index);
            }

            public Builder setTeamResonanceList(int index, int value) {
                ensureTeamResonanceListIsMutable();
                this.teamResonanceList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addTeamResonanceList(int value) {
                ensureTeamResonanceListIsMutable();
                this.teamResonanceList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllTeamResonanceList(Iterable<? extends Integer> values) {
                ensureTeamResonanceListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.teamResonanceList_);
                onChanged();
                return this;
            }

            public Builder clearTeamResonanceList() {
                this.teamResonanceList_ = AvatarInfo.emptyIntList();
                this.bitField0_ &= -257;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getWearingFlycloakId() {
                return this.wearingFlycloakId_;
            }

            public Builder setWearingFlycloakId(int value) {
                this.wearingFlycloakId_ = value;
                onChanged();
                return this;
            }

            public Builder clearWearingFlycloakId() {
                this.wearingFlycloakId_ = 0;
                onChanged();
                return this;
            }

            private void ensureEquipAffixListIsMutable() {
                if ((this.bitField0_ & 512) == 0) {
                    this.equipAffixList_ = new ArrayList(this.equipAffixList_);
                    this.bitField0_ |= 512;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public List<AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo> getEquipAffixListList() {
                if (this.equipAffixListBuilder_ == null) {
                    return Collections.unmodifiableList(this.equipAffixList_);
                }
                return this.equipAffixListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getEquipAffixListCount() {
                if (this.equipAffixListBuilder_ == null) {
                    return this.equipAffixList_.size();
                }
                return this.equipAffixListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo getEquipAffixList(int index) {
                if (this.equipAffixListBuilder_ == null) {
                    return this.equipAffixList_.get(index);
                }
                return this.equipAffixListBuilder_.getMessage(index);
            }

            public Builder setEquipAffixList(int index, AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo value) {
                if (this.equipAffixListBuilder_ != null) {
                    this.equipAffixListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEquipAffixListIsMutable();
                    this.equipAffixList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setEquipAffixList(int index, AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.Builder builderForValue) {
                if (this.equipAffixListBuilder_ == null) {
                    ensureEquipAffixListIsMutable();
                    this.equipAffixList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.equipAffixListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addEquipAffixList(AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo value) {
                if (this.equipAffixListBuilder_ != null) {
                    this.equipAffixListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEquipAffixListIsMutable();
                    this.equipAffixList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addEquipAffixList(int index, AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo value) {
                if (this.equipAffixListBuilder_ != null) {
                    this.equipAffixListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEquipAffixListIsMutable();
                    this.equipAffixList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addEquipAffixList(AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.Builder builderForValue) {
                if (this.equipAffixListBuilder_ == null) {
                    ensureEquipAffixListIsMutable();
                    this.equipAffixList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.equipAffixListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addEquipAffixList(int index, AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.Builder builderForValue) {
                if (this.equipAffixListBuilder_ == null) {
                    ensureEquipAffixListIsMutable();
                    this.equipAffixList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.equipAffixListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllEquipAffixList(Iterable<? extends AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo> values) {
                if (this.equipAffixListBuilder_ == null) {
                    ensureEquipAffixListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.equipAffixList_);
                    onChanged();
                } else {
                    this.equipAffixListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearEquipAffixList() {
                if (this.equipAffixListBuilder_ == null) {
                    this.equipAffixList_ = Collections.emptyList();
                    this.bitField0_ &= -513;
                    onChanged();
                } else {
                    this.equipAffixListBuilder_.clear();
                }
                return this;
            }

            public Builder removeEquipAffixList(int index) {
                if (this.equipAffixListBuilder_ == null) {
                    ensureEquipAffixListIsMutable();
                    this.equipAffixList_.remove(index);
                    onChanged();
                } else {
                    this.equipAffixListBuilder_.remove(index);
                }
                return this;
            }

            public AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.Builder getEquipAffixListBuilder(int index) {
                return getEquipAffixListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder getEquipAffixListOrBuilder(int index) {
                if (this.equipAffixListBuilder_ == null) {
                    return this.equipAffixList_.get(index);
                }
                return this.equipAffixListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public List<? extends AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder> getEquipAffixListOrBuilderList() {
                if (this.equipAffixListBuilder_ != null) {
                    return this.equipAffixListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.equipAffixList_);
            }

            public AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.Builder addEquipAffixListBuilder() {
                return getEquipAffixListFieldBuilder().addBuilder(AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.getDefaultInstance());
            }

            public AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.Builder addEquipAffixListBuilder(int index) {
                return getEquipAffixListFieldBuilder().addBuilder(index, AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.getDefaultInstance());
            }

            public List<AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.Builder> getEquipAffixListBuilderList() {
                return getEquipAffixListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo, AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.Builder, AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder> getEquipAffixListFieldBuilder() {
                if (this.equipAffixListBuilder_ == null) {
                    this.equipAffixListBuilder_ = new RepeatedFieldBuilderV3<>(this.equipAffixList_, (this.bitField0_ & 512) != 0, getParentForChildren(), isClean());
                    this.equipAffixList_ = null;
                }
                return this.equipAffixListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getBornTime() {
                return this.bornTime_;
            }

            public Builder setBornTime(int value) {
                this.bornTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBornTime() {
                this.bornTime_ = 0;
                onChanged();
                return this;
            }

            private void ensurePendingPromoteRewardListIsMutable() {
                if ((this.bitField0_ & 1024) == 0) {
                    this.pendingPromoteRewardList_ = AvatarInfo.mutableCopy(this.pendingPromoteRewardList_);
                    this.bitField0_ |= 1024;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public List<Integer> getPendingPromoteRewardListList() {
                return (this.bitField0_ & 1024) != 0 ? Collections.unmodifiableList(this.pendingPromoteRewardList_) : this.pendingPromoteRewardList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getPendingPromoteRewardListCount() {
                return this.pendingPromoteRewardList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getPendingPromoteRewardList(int index) {
                return this.pendingPromoteRewardList_.getInt(index);
            }

            public Builder setPendingPromoteRewardList(int index, int value) {
                ensurePendingPromoteRewardListIsMutable();
                this.pendingPromoteRewardList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addPendingPromoteRewardList(int value) {
                ensurePendingPromoteRewardListIsMutable();
                this.pendingPromoteRewardList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllPendingPromoteRewardList(Iterable<? extends Integer> values) {
                ensurePendingPromoteRewardListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.pendingPromoteRewardList_);
                onChanged();
                return this;
            }

            public Builder clearPendingPromoteRewardList() {
                this.pendingPromoteRewardList_ = AvatarInfo.emptyIntList();
                this.bitField0_ &= -1025;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getCostumeId() {
                return this.costumeId_;
            }

            public Builder setCostumeId(int value) {
                this.costumeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCostumeId() {
                this.costumeId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public boolean hasExcelInfo() {
                return (this.excelInfoBuilder_ == null && this.excelInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public AvatarExcelInfoOuterClass.AvatarExcelInfo getExcelInfo() {
                if (this.excelInfoBuilder_ == null) {
                    return this.excelInfo_ == null ? AvatarExcelInfoOuterClass.AvatarExcelInfo.getDefaultInstance() : this.excelInfo_;
                }
                return this.excelInfoBuilder_.getMessage();
            }

            public Builder setExcelInfo(AvatarExcelInfoOuterClass.AvatarExcelInfo value) {
                if (this.excelInfoBuilder_ != null) {
                    this.excelInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.excelInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setExcelInfo(AvatarExcelInfoOuterClass.AvatarExcelInfo.Builder builderForValue) {
                if (this.excelInfoBuilder_ == null) {
                    this.excelInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.excelInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeExcelInfo(AvatarExcelInfoOuterClass.AvatarExcelInfo value) {
                if (this.excelInfoBuilder_ == null) {
                    if (this.excelInfo_ != null) {
                        this.excelInfo_ = AvatarExcelInfoOuterClass.AvatarExcelInfo.newBuilder(this.excelInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.excelInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.excelInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearExcelInfo() {
                if (this.excelInfoBuilder_ == null) {
                    this.excelInfo_ = null;
                    onChanged();
                } else {
                    this.excelInfo_ = null;
                    this.excelInfoBuilder_ = null;
                }
                return this;
            }

            public AvatarExcelInfoOuterClass.AvatarExcelInfo.Builder getExcelInfoBuilder() {
                onChanged();
                return getExcelInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder getExcelInfoOrBuilder() {
                if (this.excelInfoBuilder_ != null) {
                    return this.excelInfoBuilder_.getMessageOrBuilder();
                }
                return this.excelInfo_ == null ? AvatarExcelInfoOuterClass.AvatarExcelInfo.getDefaultInstance() : this.excelInfo_;
            }

            private SingleFieldBuilderV3<AvatarExcelInfoOuterClass.AvatarExcelInfo, AvatarExcelInfoOuterClass.AvatarExcelInfo.Builder, AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder> getExcelInfoFieldBuilder() {
                if (this.excelInfoBuilder_ == null) {
                    this.excelInfoBuilder_ = new SingleFieldBuilderV3<>(getExcelInfo(), getParentForChildren(), isClean());
                    this.excelInfo_ = null;
                }
                return this.excelInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AvatarInfoOuterClass.AvatarInfoOrBuilder
            public int getAnimHash() {
                return this.animHash_;
            }

            public Builder setAnimHash(int value) {
                this.animHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearAnimHash() {
                this.animHash_ = 0;
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

        public static AvatarInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AvatarEquipAffixInfoOuterClass.getDescriptor();
        AvatarExcelInfoOuterClass.getDescriptor();
        AvatarExpeditionStateOuterClass.getDescriptor();
        AvatarFetterInfoOuterClass.getDescriptor();
        AvatarSkillInfoOuterClass.getDescriptor();
        PropValueOuterClass.getDescriptor();
        TrialAvatarInfoOuterClass.getDescriptor();
    }
}
