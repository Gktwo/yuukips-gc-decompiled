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
import emu.grasscutter.net.proto.AvatarExcelInfoOuterClass;
import emu.grasscutter.net.proto.AvatarFetterInfoOuterClass;
import emu.grasscutter.net.proto.PropValueOuterClass;
import emu.grasscutter.net.proto.ShowEquipOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShowAvatarInfoOuterClass.class */
public final class ShowAvatarInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014ShowAvatarInfo.proto\u001a\u0015AvatarExcelInfo.proto\u001a\u0016AvatarFetterInfo.proto\u001a\u000fPropValue.proto\u001a\u000fShowEquip.proto\"ú\u0005\n\u000eShowAvatarInfo\u0012\u0011\n\tavatar_id\u0018\u0001 \u0001(\r\u0012.\n\bprop_map\u0018\u0002 \u0003(\u000b2\u001c.ShowAvatarInfo.PropMapEntry\u0012\u0016\n\u000etalent_id_list\u0018\u0003 \u0003(\r\u00129\n\u000efight_prop_map\u0018\u0004 \u0003(\u000b2!.ShowAvatarInfo.FightPropMapEntry\u0012\u0016\n\u000eskill_depot_id\u0018\u0005 \u0001(\r\u0012\u001e\n\u0016core_proud_skill_level\u0018\u0006 \u0001(\r\u0012!\n\u0019inherent_proud_skill_list\u0018\u0007 \u0003(\r\u0012;\n\u000fskill_level_map\u0018\b \u0003(\u000b2\".ShowAvatarInfo.SkillLevelMapEntry\u0012Q\n\u001bproud_skill_extra_level_map\u0018\t \u0003(\u000b2,.ShowAvatarInfo.ProudSkillExtraLevelMapEntry\u0012\u001e\n\nequip_list\u0018\n \u0003(\u000b2\n.ShowEquip\u0012&\n\u000bfetter_info\u0018\u000b \u0001(\u000b2\u0011.AvatarFetterInfo\u0012\u0012\n\ncostume_id\u0018\f \u0001(\r\u0012$\n\nexcel_info\u0018\r \u0001(\u000b2\u0010.AvatarExcelInfo\u001a:\n\fPropMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u0019\n\u0005value\u0018\u0002 \u0001(\u000b2\n.PropValue:\u00028\u0001\u001a3\n\u0011FightPropMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\u0002:\u00028\u0001\u001a4\n\u0012SkillLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a>\n\u001cProudSkillExtraLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AvatarExcelInfoOuterClass.getDescriptor(), AvatarFetterInfoOuterClass.getDescriptor(), PropValueOuterClass.getDescriptor(), ShowEquipOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ShowAvatarInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ShowAvatarInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ShowAvatarInfo_descriptor, new String[]{"AvatarId", "PropMap", "TalentIdList", "FightPropMap", "SkillDepotId", "CoreProudSkillLevel", "InherentProudSkillList", "SkillLevelMap", "ProudSkillExtraLevelMap", "EquipList", "FetterInfo", "CostumeId", "ExcelInfo"});
    private static final Descriptors.Descriptor internal_static_ShowAvatarInfo_PropMapEntry_descriptor = internal_static_ShowAvatarInfo_descriptor.getNestedTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ShowAvatarInfo_PropMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ShowAvatarInfo_PropMapEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_ShowAvatarInfo_FightPropMapEntry_descriptor = internal_static_ShowAvatarInfo_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_ShowAvatarInfo_FightPropMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f875xf60fa00f = new GeneratedMessageV3.FieldAccessorTable(internal_static_ShowAvatarInfo_FightPropMapEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_ShowAvatarInfo_SkillLevelMapEntry_descriptor = internal_static_ShowAvatarInfo_descriptor.getNestedTypes().get(2);

    /* renamed from: internal_static_ShowAvatarInfo_SkillLevelMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f876x58e1c4d7 = new GeneratedMessageV3.FieldAccessorTable(internal_static_ShowAvatarInfo_SkillLevelMapEntry_descriptor, new String[]{"Key", "Value"});

    /* renamed from: internal_static_ShowAvatarInfo_ProudSkillExtraLevelMapEntry_descriptor */
    private static final Descriptors.Descriptor f877xf30cd63 = internal_static_ShowAvatarInfo_descriptor.getNestedTypes().get(3);

    /* renamed from: internal_static_ShowAvatarInfo_ProudSkillExtraLevelMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f878x25f9e0e1 = new GeneratedMessageV3.FieldAccessorTable(f877xf30cd63, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShowAvatarInfoOuterClass$ShowAvatarInfoOrBuilder.class */
    public interface ShowAvatarInfoOrBuilder extends MessageOrBuilder {
        int getAvatarId();

        int getPropMapCount();

        boolean containsPropMap(int i);

        @Deprecated
        Map<Integer, PropValueOuterClass.PropValue> getPropMap();

        Map<Integer, PropValueOuterClass.PropValue> getPropMapMap();

        PropValueOuterClass.PropValue getPropMapOrDefault(int i, PropValueOuterClass.PropValue propValue);

        PropValueOuterClass.PropValue getPropMapOrThrow(int i);

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

        int getSkillDepotId();

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

        int getProudSkillExtraLevelMapCount();

        boolean containsProudSkillExtraLevelMap(int i);

        @Deprecated
        Map<Integer, Integer> getProudSkillExtraLevelMap();

        Map<Integer, Integer> getProudSkillExtraLevelMapMap();

        int getProudSkillExtraLevelMapOrDefault(int i, int i2);

        int getProudSkillExtraLevelMapOrThrow(int i);

        List<ShowEquipOuterClass.ShowEquip> getEquipListList();

        ShowEquipOuterClass.ShowEquip getEquipList(int i);

        int getEquipListCount();

        List<? extends ShowEquipOuterClass.ShowEquipOrBuilder> getEquipListOrBuilderList();

        ShowEquipOuterClass.ShowEquipOrBuilder getEquipListOrBuilder(int i);

        boolean hasFetterInfo();

        AvatarFetterInfoOuterClass.AvatarFetterInfo getFetterInfo();

        AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder getFetterInfoOrBuilder();

        int getCostumeId();

        boolean hasExcelInfo();

        AvatarExcelInfoOuterClass.AvatarExcelInfo getExcelInfo();

        AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder getExcelInfoOrBuilder();
    }

    private ShowAvatarInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShowAvatarInfoOuterClass$ShowAvatarInfo.class */
    public static final class ShowAvatarInfo extends GeneratedMessageV3 implements ShowAvatarInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATAR_ID_FIELD_NUMBER = 1;
        private int avatarId_;
        public static final int PROP_MAP_FIELD_NUMBER = 2;
        private MapField<Integer, PropValueOuterClass.PropValue> propMap_;
        public static final int TALENT_ID_LIST_FIELD_NUMBER = 3;
        private Internal.IntList talentIdList_;
        private int talentIdListMemoizedSerializedSize;
        public static final int FIGHT_PROP_MAP_FIELD_NUMBER = 4;
        private MapField<Integer, Float> fightPropMap_;
        public static final int SKILL_DEPOT_ID_FIELD_NUMBER = 5;
        private int skillDepotId_;
        public static final int CORE_PROUD_SKILL_LEVEL_FIELD_NUMBER = 6;
        private int coreProudSkillLevel_;
        public static final int INHERENT_PROUD_SKILL_LIST_FIELD_NUMBER = 7;
        private Internal.IntList inherentProudSkillList_;
        private int inherentProudSkillListMemoizedSerializedSize;
        public static final int SKILL_LEVEL_MAP_FIELD_NUMBER = 8;
        private MapField<Integer, Integer> skillLevelMap_;
        public static final int PROUD_SKILL_EXTRA_LEVEL_MAP_FIELD_NUMBER = 9;
        private MapField<Integer, Integer> proudSkillExtraLevelMap_;
        public static final int EQUIP_LIST_FIELD_NUMBER = 10;
        private List<ShowEquipOuterClass.ShowEquip> equipList_;
        public static final int FETTER_INFO_FIELD_NUMBER = 11;
        private AvatarFetterInfoOuterClass.AvatarFetterInfo fetterInfo_;
        public static final int COSTUME_ID_FIELD_NUMBER = 12;
        private int costumeId_;
        public static final int EXCEL_INFO_FIELD_NUMBER = 13;
        private AvatarExcelInfoOuterClass.AvatarExcelInfo excelInfo_;
        private byte memoizedIsInitialized;
        private static final ShowAvatarInfo DEFAULT_INSTANCE = new ShowAvatarInfo();
        private static final Parser<ShowAvatarInfo> PARSER = new AbstractParser<ShowAvatarInfo>() { // from class: emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfo.1
            @Override // com.google.protobuf.Parser
            public ShowAvatarInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShowAvatarInfo(input, extensionRegistry);
            }
        };

        /*  JADX ERROR: Dependency scan failed at insn: 0x0049: INVOKE_CUSTOM r0
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
        /*  JADX ERROR: Failed to decode insn: 0x0049: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 2: goto L_0x0030;
                    case 3: goto L_0x0044;
                    case 4: goto L_0x0035;
                    case 5: goto L_0x0044;
                    case 6: goto L_0x0044;
                    case 7: goto L_0x0044;
                    case 8: goto L_0x003a;
                    case 9: goto L_0x003f;
                    default: goto L_0x0044;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetPropMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetFightPropMap()
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
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private ShowAvatarInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.talentIdListMemoizedSerializedSize = -1;
            this.inherentProudSkillListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ShowAvatarInfo() {
            this.talentIdListMemoizedSerializedSize = -1;
            this.inherentProudSkillListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.talentIdList_ = emptyIntList();
            this.inherentProudSkillList_ = emptyIntList();
            this.equipList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ShowAvatarInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:133:0x0381 */
        private ShowAvatarInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.propMap_ = MapField.newMapField(PropMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, PropValueOuterClass.PropValue> propMap__ = (MapEntry) input.readMessage(PropMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.propMap_.getMutableMap().put(propMap__.getKey(), propMap__.getValue());
                                break;
                            case 24:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.talentIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.talentIdList_.addInt(input.readUInt32());
                                break;
                            case 26:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.talentIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.talentIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 34:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.fightPropMap_ = MapField.newMapField(FightPropMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Float> fightPropMap__ = (MapEntry) input.readMessage(FightPropMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.fightPropMap_.getMutableMap().put(fightPropMap__.getKey(), fightPropMap__.getValue());
                                break;
                            case 40:
                                this.skillDepotId_ = input.readUInt32();
                                break;
                            case 48:
                                this.coreProudSkillLevel_ = input.readUInt32();
                                break;
                            case 56:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.inherentProudSkillList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.inherentProudSkillList_.addInt(input.readUInt32());
                                break;
                            case 58:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.inherentProudSkillList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.inherentProudSkillList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 66:
                                if ((mutable_bitField0_ & 16) == 0) {
                                    this.skillLevelMap_ = MapField.newMapField(SkillLevelMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> skillLevelMap__ = (MapEntry) input.readMessage(SkillLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.skillLevelMap_.getMutableMap().put(skillLevelMap__.getKey(), skillLevelMap__.getValue());
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 32) == 0) {
                                    this.proudSkillExtraLevelMap_ = MapField.newMapField(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> proudSkillExtraLevelMap__ = (MapEntry) input.readMessage(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.proudSkillExtraLevelMap_.getMutableMap().put(proudSkillExtraLevelMap__.getKey(), proudSkillExtraLevelMap__.getValue());
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 64) == 0) {
                                    this.equipList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                }
                                this.equipList_.add((ShowEquipOuterClass.ShowEquip) input.readMessage(ShowEquipOuterClass.ShowEquip.parser(), extensionRegistry));
                                break;
                            case 90:
                                AvatarFetterInfoOuterClass.AvatarFetterInfo.Builder subBuilder = this.fetterInfo_ != null ? this.fetterInfo_.toBuilder() : null;
                                this.fetterInfo_ = (AvatarFetterInfoOuterClass.AvatarFetterInfo) input.readMessage(AvatarFetterInfoOuterClass.AvatarFetterInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.fetterInfo_);
                                    this.fetterInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 96:
                                this.costumeId_ = input.readUInt32();
                                break;
                            case 106:
                                AvatarExcelInfoOuterClass.AvatarExcelInfo.Builder subBuilder2 = this.excelInfo_ != null ? this.excelInfo_.toBuilder() : null;
                                this.excelInfo_ = (AvatarExcelInfoOuterClass.AvatarExcelInfo) input.readMessage(AvatarExcelInfoOuterClass.AvatarExcelInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.excelInfo_);
                                    this.excelInfo_ = subBuilder2.buildPartial();
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
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.talentIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.inherentProudSkillList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 64) != 0) {
                    this.equipList_ = Collections.unmodifiableList(this.equipList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ShowAvatarInfoOuterClass.internal_static_ShowAvatarInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShowAvatarInfoOuterClass.internal_static_ShowAvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ShowAvatarInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShowAvatarInfoOuterClass$ShowAvatarInfo$PropMapDefaultEntryHolder.class */
        public static final class PropMapDefaultEntryHolder {
            static final MapEntry<Integer, PropValueOuterClass.PropValue> defaultEntry = MapEntry.newDefaultInstance(ShowAvatarInfoOuterClass.internal_static_ShowAvatarInfo_PropMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, PropValueOuterClass.PropValue.getDefaultInstance());

            private PropMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, PropValueOuterClass.PropValue> internalGetPropMap() {
            if (this.propMap_ == null) {
                return MapField.emptyMapField(PropMapDefaultEntryHolder.defaultEntry);
            }
            return this.propMap_;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getPropMapCount() {
            return internalGetPropMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public boolean containsPropMap(int key) {
            return internalGetPropMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        @Deprecated
        public Map<Integer, PropValueOuterClass.PropValue> getPropMap() {
            return getPropMapMap();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public Map<Integer, PropValueOuterClass.PropValue> getPropMapMap() {
            return internalGetPropMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public PropValueOuterClass.PropValue getPropMapOrDefault(int key, PropValueOuterClass.PropValue defaultValue) {
            Map<Integer, PropValueOuterClass.PropValue> map = internalGetPropMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public PropValueOuterClass.PropValue getPropMapOrThrow(int key) {
            Map<Integer, PropValueOuterClass.PropValue> map = internalGetPropMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public List<Integer> getTalentIdListList() {
            return this.talentIdList_;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getTalentIdListCount() {
            return this.talentIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getTalentIdList(int index) {
            return this.talentIdList_.getInt(index);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShowAvatarInfoOuterClass$ShowAvatarInfo$FightPropMapDefaultEntryHolder.class */
        public static final class FightPropMapDefaultEntryHolder {
            static final MapEntry<Integer, Float> defaultEntry = MapEntry.newDefaultInstance(ShowAvatarInfoOuterClass.internal_static_ShowAvatarInfo_FightPropMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.FLOAT, Float.valueOf(0.0f));

            private FightPropMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Float> internalGetFightPropMap() {
            if (this.fightPropMap_ == null) {
                return MapField.emptyMapField(FightPropMapDefaultEntryHolder.defaultEntry);
            }
            return this.fightPropMap_;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getFightPropMapCount() {
            return internalGetFightPropMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public boolean containsFightPropMap(int key) {
            return internalGetFightPropMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        @Deprecated
        public Map<Integer, Float> getFightPropMap() {
            return getFightPropMapMap();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public Map<Integer, Float> getFightPropMapMap() {
            return internalGetFightPropMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public float getFightPropMapOrDefault(int key, float defaultValue) {
            Map<Integer, Float> map = internalGetFightPropMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).floatValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public float getFightPropMapOrThrow(int key) {
            Map<Integer, Float> map = internalGetFightPropMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).floatValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getSkillDepotId() {
            return this.skillDepotId_;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getCoreProudSkillLevel() {
            return this.coreProudSkillLevel_;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public List<Integer> getInherentProudSkillListList() {
            return this.inherentProudSkillList_;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getInherentProudSkillListCount() {
            return this.inherentProudSkillList_.size();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getInherentProudSkillList(int index) {
            return this.inherentProudSkillList_.getInt(index);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShowAvatarInfoOuterClass$ShowAvatarInfo$SkillLevelMapDefaultEntryHolder.class */
        public static final class SkillLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(ShowAvatarInfoOuterClass.internal_static_ShowAvatarInfo_SkillLevelMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private SkillLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetSkillLevelMap() {
            if (this.skillLevelMap_ == null) {
                return MapField.emptyMapField(SkillLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.skillLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getSkillLevelMapCount() {
            return internalGetSkillLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public boolean containsSkillLevelMap(int key) {
            return internalGetSkillLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getSkillLevelMap() {
            return getSkillLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public Map<Integer, Integer> getSkillLevelMapMap() {
            return internalGetSkillLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getSkillLevelMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetSkillLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getSkillLevelMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetSkillLevelMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShowAvatarInfoOuterClass$ShowAvatarInfo$ProudSkillExtraLevelMapDefaultEntryHolder.class */
        public static final class ProudSkillExtraLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(ShowAvatarInfoOuterClass.f877xf30cd63, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private ProudSkillExtraLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetProudSkillExtraLevelMap() {
            if (this.proudSkillExtraLevelMap_ == null) {
                return MapField.emptyMapField(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.proudSkillExtraLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getProudSkillExtraLevelMapCount() {
            return internalGetProudSkillExtraLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public boolean containsProudSkillExtraLevelMap(int key) {
            return internalGetProudSkillExtraLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getProudSkillExtraLevelMap() {
            return getProudSkillExtraLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public Map<Integer, Integer> getProudSkillExtraLevelMapMap() {
            return internalGetProudSkillExtraLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getProudSkillExtraLevelMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetProudSkillExtraLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getProudSkillExtraLevelMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetProudSkillExtraLevelMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public List<ShowEquipOuterClass.ShowEquip> getEquipListList() {
            return this.equipList_;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public List<? extends ShowEquipOuterClass.ShowEquipOrBuilder> getEquipListOrBuilderList() {
            return this.equipList_;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getEquipListCount() {
            return this.equipList_.size();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public ShowEquipOuterClass.ShowEquip getEquipList(int index) {
            return this.equipList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public ShowEquipOuterClass.ShowEquipOrBuilder getEquipListOrBuilder(int index) {
            return this.equipList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public boolean hasFetterInfo() {
            return this.fetterInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public AvatarFetterInfoOuterClass.AvatarFetterInfo getFetterInfo() {
            return this.fetterInfo_ == null ? AvatarFetterInfoOuterClass.AvatarFetterInfo.getDefaultInstance() : this.fetterInfo_;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder getFetterInfoOrBuilder() {
            return getFetterInfo();
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public int getCostumeId() {
            return this.costumeId_;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public boolean hasExcelInfo() {
            return this.excelInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public AvatarExcelInfoOuterClass.AvatarExcelInfo getExcelInfo() {
            return this.excelInfo_ == null ? AvatarExcelInfoOuterClass.AvatarExcelInfo.getDefaultInstance() : this.excelInfo_;
        }

        @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
        public AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder getExcelInfoOrBuilder() {
            return getExcelInfo();
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetPropMap(), PropMapDefaultEntryHolder.defaultEntry, 2);
            if (getTalentIdListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.talentIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.talentIdList_.size(); i++) {
                output.writeUInt32NoTag(this.talentIdList_.getInt(i));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetFightPropMap(), FightPropMapDefaultEntryHolder.defaultEntry, 4);
            if (this.skillDepotId_ != 0) {
                output.writeUInt32(5, this.skillDepotId_);
            }
            if (this.coreProudSkillLevel_ != 0) {
                output.writeUInt32(6, this.coreProudSkillLevel_);
            }
            if (getInherentProudSkillListList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.inherentProudSkillListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.inherentProudSkillList_.size(); i2++) {
                output.writeUInt32NoTag(this.inherentProudSkillList_.getInt(i2));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSkillLevelMap(), SkillLevelMapDefaultEntryHolder.defaultEntry, 8);
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetProudSkillExtraLevelMap(), ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry, 9);
            for (int i3 = 0; i3 < this.equipList_.size(); i3++) {
                output.writeMessage(10, this.equipList_.get(i3));
            }
            if (this.fetterInfo_ != null) {
                output.writeMessage(11, getFetterInfo());
            }
            if (this.costumeId_ != 0) {
                output.writeUInt32(12, this.costumeId_);
            }
            if (this.excelInfo_ != null) {
                output.writeMessage(13, getExcelInfo());
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
            for (Map.Entry<Integer, PropValueOuterClass.PropValue> entry : internalGetPropMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(2, PropMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            int dataSize = 0;
            for (int i = 0; i < this.talentIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.talentIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getTalentIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.talentIdListMemoizedSerializedSize = dataSize;
            for (Map.Entry<Integer, Float> entry2 : internalGetFightPropMap().getMap().entrySet()) {
                size3 += CodedOutputStream.computeMessageSize(4, FightPropMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (this.skillDepotId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(5, this.skillDepotId_);
            }
            if (this.coreProudSkillLevel_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(6, this.coreProudSkillLevel_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.inherentProudSkillList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.inherentProudSkillList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getInherentProudSkillListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.inherentProudSkillListMemoizedSerializedSize = dataSize2;
            for (Map.Entry<Integer, Integer> entry3 : internalGetSkillLevelMap().getMap().entrySet()) {
                size4 += CodedOutputStream.computeMessageSize(8, SkillLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry3.getKey()).setValue(entry3.getValue()).build());
            }
            for (Map.Entry<Integer, Integer> entry4 : internalGetProudSkillExtraLevelMap().getMap().entrySet()) {
                size4 += CodedOutputStream.computeMessageSize(9, ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry4.getKey()).setValue(entry4.getValue()).build());
            }
            for (int i3 = 0; i3 < this.equipList_.size(); i3++) {
                size4 += CodedOutputStream.computeMessageSize(10, this.equipList_.get(i3));
            }
            if (this.fetterInfo_ != null) {
                size4 += CodedOutputStream.computeMessageSize(11, getFetterInfo());
            }
            if (this.costumeId_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(12, this.costumeId_);
            }
            if (this.excelInfo_ != null) {
                size4 += CodedOutputStream.computeMessageSize(13, getExcelInfo());
            }
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShowAvatarInfo)) {
                return equals(obj);
            }
            ShowAvatarInfo other = (ShowAvatarInfo) obj;
            if (getAvatarId() != other.getAvatarId() || !internalGetPropMap().equals(other.internalGetPropMap()) || !getTalentIdListList().equals(other.getTalentIdListList()) || !internalGetFightPropMap().equals(other.internalGetFightPropMap()) || getSkillDepotId() != other.getSkillDepotId() || getCoreProudSkillLevel() != other.getCoreProudSkillLevel() || !getInherentProudSkillListList().equals(other.getInherentProudSkillListList()) || !internalGetSkillLevelMap().equals(other.internalGetSkillLevelMap()) || !internalGetProudSkillExtraLevelMap().equals(other.internalGetProudSkillExtraLevelMap()) || !getEquipListList().equals(other.getEquipListList()) || hasFetterInfo() != other.hasFetterInfo()) {
                return false;
            }
            if ((!hasFetterInfo() || getFetterInfo().equals(other.getFetterInfo())) && getCostumeId() == other.getCostumeId() && hasExcelInfo() == other.hasExcelInfo()) {
                return (!hasExcelInfo() || getExcelInfo().equals(other.getExcelInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getAvatarId();
            if (!internalGetPropMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 2)) + internalGetPropMap().hashCode();
            }
            if (getTalentIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getTalentIdListList().hashCode();
            }
            if (!internalGetFightPropMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 4)) + internalGetFightPropMap().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 5)) + getSkillDepotId())) + 6)) + getCoreProudSkillLevel();
            if (getInherentProudSkillListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 7)) + getInherentProudSkillListList().hashCode();
            }
            if (!internalGetSkillLevelMap().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 8)) + internalGetSkillLevelMap().hashCode();
            }
            if (!internalGetProudSkillExtraLevelMap().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 9)) + internalGetProudSkillExtraLevelMap().hashCode();
            }
            if (getEquipListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 10)) + getEquipListList().hashCode();
            }
            if (hasFetterInfo()) {
                hash2 = (53 * ((37 * hash2) + 11)) + getFetterInfo().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 12)) + getCostumeId();
            if (hasExcelInfo()) {
                hash3 = (53 * ((37 * hash3) + 13)) + getExcelInfo().hashCode();
            }
            int hash4 = (29 * hash3) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static ShowAvatarInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShowAvatarInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShowAvatarInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShowAvatarInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShowAvatarInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShowAvatarInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShowAvatarInfo parseFrom(InputStream input) throws IOException {
            return (ShowAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ShowAvatarInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShowAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ShowAvatarInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ShowAvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ShowAvatarInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShowAvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ShowAvatarInfo parseFrom(CodedInputStream input) throws IOException {
            return (ShowAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ShowAvatarInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShowAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ShowAvatarInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShowAvatarInfoOuterClass$ShowAvatarInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ShowAvatarInfoOrBuilder {
            private int bitField0_;
            private int avatarId_;
            private MapField<Integer, PropValueOuterClass.PropValue> propMap_;
            private MapField<Integer, Float> fightPropMap_;
            private int skillDepotId_;
            private int coreProudSkillLevel_;
            private MapField<Integer, Integer> skillLevelMap_;
            private MapField<Integer, Integer> proudSkillExtraLevelMap_;
            private RepeatedFieldBuilderV3<ShowEquipOuterClass.ShowEquip, ShowEquipOuterClass.ShowEquip.Builder, ShowEquipOuterClass.ShowEquipOrBuilder> equipListBuilder_;
            private AvatarFetterInfoOuterClass.AvatarFetterInfo fetterInfo_;
            private SingleFieldBuilderV3<AvatarFetterInfoOuterClass.AvatarFetterInfo, AvatarFetterInfoOuterClass.AvatarFetterInfo.Builder, AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder> fetterInfoBuilder_;
            private int costumeId_;
            private AvatarExcelInfoOuterClass.AvatarExcelInfo excelInfo_;
            private SingleFieldBuilderV3<AvatarExcelInfoOuterClass.AvatarExcelInfo, AvatarExcelInfoOuterClass.AvatarExcelInfo.Builder, AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder> excelInfoBuilder_;
            private Internal.IntList talentIdList_ = ShowAvatarInfo.emptyIntList();
            private Internal.IntList inherentProudSkillList_ = ShowAvatarInfo.emptyIntList();
            private List<ShowEquipOuterClass.ShowEquip> equipList_ = Collections.emptyList();

            /*  JADX ERROR: Dependency scan failed at insn: 0x0049: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x0049: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 2: goto L_0x0030;
                        case 3: goto L_0x0044;
                        case 4: goto L_0x0035;
                        case 5: goto L_0x0044;
                        case 6: goto L_0x0044;
                        case 7: goto L_0x0044;
                        case 8: goto L_0x003a;
                        case 9: goto L_0x003f;
                        default: goto L_0x0044;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetPropMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetFightPropMap()
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
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
            }

            /*  JADX ERROR: Dependency scan failed at insn: 0x0049: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x0049: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 2: goto L_0x0030;
                        case 3: goto L_0x0044;
                        case 4: goto L_0x0035;
                        case 5: goto L_0x0044;
                        case 6: goto L_0x0044;
                        case 7: goto L_0x0044;
                        case 8: goto L_0x003a;
                        case 9: goto L_0x003f;
                        default: goto L_0x0044;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutablePropMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableFightPropMap()
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
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ShowAvatarInfoOuterClass.internal_static_ShowAvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShowAvatarInfoOuterClass.internal_static_ShowAvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ShowAvatarInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ShowAvatarInfo.alwaysUseFieldBuilders) {
                    getEquipListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.avatarId_ = 0;
                internalGetMutablePropMap().clear();
                this.talentIdList_ = ShowAvatarInfo.emptyIntList();
                this.bitField0_ &= -3;
                internalGetMutableFightPropMap().clear();
                this.skillDepotId_ = 0;
                this.coreProudSkillLevel_ = 0;
                this.inherentProudSkillList_ = ShowAvatarInfo.emptyIntList();
                this.bitField0_ &= -9;
                internalGetMutableSkillLevelMap().clear();
                internalGetMutableProudSkillExtraLevelMap().clear();
                if (this.equipListBuilder_ == null) {
                    this.equipList_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                } else {
                    this.equipListBuilder_.clear();
                }
                if (this.fetterInfoBuilder_ == null) {
                    this.fetterInfo_ = null;
                } else {
                    this.fetterInfo_ = null;
                    this.fetterInfoBuilder_ = null;
                }
                this.costumeId_ = 0;
                if (this.excelInfoBuilder_ == null) {
                    this.excelInfo_ = null;
                } else {
                    this.excelInfo_ = null;
                    this.excelInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ShowAvatarInfoOuterClass.internal_static_ShowAvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ShowAvatarInfo getDefaultInstanceForType() {
                return ShowAvatarInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShowAvatarInfo build() {
                ShowAvatarInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShowAvatarInfo buildPartial() {
                ShowAvatarInfo result = new ShowAvatarInfo(this);
                int i = this.bitField0_;
                result.avatarId_ = this.avatarId_;
                result.propMap_ = internalGetPropMap();
                result.propMap_.makeImmutable();
                if ((this.bitField0_ & 2) != 0) {
                    this.talentIdList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.talentIdList_ = this.talentIdList_;
                result.fightPropMap_ = internalGetFightPropMap();
                result.fightPropMap_.makeImmutable();
                result.skillDepotId_ = this.skillDepotId_;
                result.coreProudSkillLevel_ = this.coreProudSkillLevel_;
                if ((this.bitField0_ & 8) != 0) {
                    this.inherentProudSkillList_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                result.inherentProudSkillList_ = this.inherentProudSkillList_;
                result.skillLevelMap_ = internalGetSkillLevelMap();
                result.skillLevelMap_.makeImmutable();
                result.proudSkillExtraLevelMap_ = internalGetProudSkillExtraLevelMap();
                result.proudSkillExtraLevelMap_.makeImmutable();
                if (this.equipListBuilder_ == null) {
                    if ((this.bitField0_ & 64) != 0) {
                        this.equipList_ = Collections.unmodifiableList(this.equipList_);
                        this.bitField0_ &= -65;
                    }
                    result.equipList_ = this.equipList_;
                } else {
                    result.equipList_ = this.equipListBuilder_.build();
                }
                if (this.fetterInfoBuilder_ == null) {
                    result.fetterInfo_ = this.fetterInfo_;
                } else {
                    result.fetterInfo_ = this.fetterInfoBuilder_.build();
                }
                result.costumeId_ = this.costumeId_;
                if (this.excelInfoBuilder_ == null) {
                    result.excelInfo_ = this.excelInfo_;
                } else {
                    result.excelInfo_ = this.excelInfoBuilder_.build();
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
                if (other instanceof ShowAvatarInfo) {
                    return mergeFrom((ShowAvatarInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShowAvatarInfo other) {
                if (other == ShowAvatarInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
                }
                internalGetMutablePropMap().mergeFrom(other.internalGetPropMap());
                if (!other.talentIdList_.isEmpty()) {
                    if (this.talentIdList_.isEmpty()) {
                        this.talentIdList_ = other.talentIdList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureTalentIdListIsMutable();
                        this.talentIdList_.addAll(other.talentIdList_);
                    }
                    onChanged();
                }
                internalGetMutableFightPropMap().mergeFrom(other.internalGetFightPropMap());
                if (other.getSkillDepotId() != 0) {
                    setSkillDepotId(other.getSkillDepotId());
                }
                if (other.getCoreProudSkillLevel() != 0) {
                    setCoreProudSkillLevel(other.getCoreProudSkillLevel());
                }
                if (!other.inherentProudSkillList_.isEmpty()) {
                    if (this.inherentProudSkillList_.isEmpty()) {
                        this.inherentProudSkillList_ = other.inherentProudSkillList_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureInherentProudSkillListIsMutable();
                        this.inherentProudSkillList_.addAll(other.inherentProudSkillList_);
                    }
                    onChanged();
                }
                internalGetMutableSkillLevelMap().mergeFrom(other.internalGetSkillLevelMap());
                internalGetMutableProudSkillExtraLevelMap().mergeFrom(other.internalGetProudSkillExtraLevelMap());
                if (this.equipListBuilder_ == null) {
                    if (!other.equipList_.isEmpty()) {
                        if (this.equipList_.isEmpty()) {
                            this.equipList_ = other.equipList_;
                            this.bitField0_ &= -65;
                        } else {
                            ensureEquipListIsMutable();
                            this.equipList_.addAll(other.equipList_);
                        }
                        onChanged();
                    }
                } else if (!other.equipList_.isEmpty()) {
                    if (this.equipListBuilder_.isEmpty()) {
                        this.equipListBuilder_.dispose();
                        this.equipListBuilder_ = null;
                        this.equipList_ = other.equipList_;
                        this.bitField0_ &= -65;
                        this.equipListBuilder_ = ShowAvatarInfo.alwaysUseFieldBuilders ? getEquipListFieldBuilder() : null;
                    } else {
                        this.equipListBuilder_.addAllMessages(other.equipList_);
                    }
                }
                if (other.hasFetterInfo()) {
                    mergeFetterInfo(other.getFetterInfo());
                }
                if (other.getCostumeId() != 0) {
                    setCostumeId(other.getCostumeId());
                }
                if (other.hasExcelInfo()) {
                    mergeExcelInfo(other.getExcelInfo());
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
                ShowAvatarInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ShowAvatarInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ShowAvatarInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public int getPropMapCount() {
                return internalGetPropMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public boolean containsPropMap(int key) {
                return internalGetPropMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            @Deprecated
            public Map<Integer, PropValueOuterClass.PropValue> getPropMap() {
                return getPropMapMap();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public Map<Integer, PropValueOuterClass.PropValue> getPropMapMap() {
                return internalGetPropMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public PropValueOuterClass.PropValue getPropMapOrDefault(int key, PropValueOuterClass.PropValue defaultValue) {
                Map<Integer, PropValueOuterClass.PropValue> map = internalGetPropMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
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

            private void ensureTalentIdListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.talentIdList_ = ShowAvatarInfo.mutableCopy(this.talentIdList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public List<Integer> getTalentIdListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.talentIdList_) : this.talentIdList_;
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public int getTalentIdListCount() {
                return this.talentIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
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
                this.talentIdList_ = ShowAvatarInfo.emptyIntList();
                this.bitField0_ &= -3;
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

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public int getFightPropMapCount() {
                return internalGetFightPropMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public boolean containsFightPropMap(int key) {
                return internalGetFightPropMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            @Deprecated
            public Map<Integer, Float> getFightPropMap() {
                return getFightPropMapMap();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public Map<Integer, Float> getFightPropMapMap() {
                return internalGetFightPropMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public float getFightPropMapOrDefault(int key, float defaultValue) {
                Map<Integer, Float> map = internalGetFightPropMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).floatValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
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
                if ((this.bitField0_ & 8) == 0) {
                    this.inherentProudSkillList_ = ShowAvatarInfo.mutableCopy(this.inherentProudSkillList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public List<Integer> getInherentProudSkillListList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.inherentProudSkillList_) : this.inherentProudSkillList_;
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public int getInherentProudSkillListCount() {
                return this.inherentProudSkillList_.size();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
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
                this.inherentProudSkillList_ = ShowAvatarInfo.emptyIntList();
                this.bitField0_ &= -9;
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

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public int getSkillLevelMapCount() {
                return internalGetSkillLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public boolean containsSkillLevelMap(int key) {
                return internalGetSkillLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getSkillLevelMap() {
                return getSkillLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public Map<Integer, Integer> getSkillLevelMapMap() {
                return internalGetSkillLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public int getSkillLevelMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetSkillLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public int getProudSkillExtraLevelMapCount() {
                return internalGetProudSkillExtraLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public boolean containsProudSkillExtraLevelMap(int key) {
                return internalGetProudSkillExtraLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getProudSkillExtraLevelMap() {
                return getProudSkillExtraLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public Map<Integer, Integer> getProudSkillExtraLevelMapMap() {
                return internalGetProudSkillExtraLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public int getProudSkillExtraLevelMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetProudSkillExtraLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
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

            private void ensureEquipListIsMutable() {
                if ((this.bitField0_ & 64) == 0) {
                    this.equipList_ = new ArrayList(this.equipList_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public List<ShowEquipOuterClass.ShowEquip> getEquipListList() {
                if (this.equipListBuilder_ == null) {
                    return Collections.unmodifiableList(this.equipList_);
                }
                return this.equipListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public int getEquipListCount() {
                if (this.equipListBuilder_ == null) {
                    return this.equipList_.size();
                }
                return this.equipListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public ShowEquipOuterClass.ShowEquip getEquipList(int index) {
                if (this.equipListBuilder_ == null) {
                    return this.equipList_.get(index);
                }
                return this.equipListBuilder_.getMessage(index);
            }

            public Builder setEquipList(int index, ShowEquipOuterClass.ShowEquip value) {
                if (this.equipListBuilder_ != null) {
                    this.equipListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEquipListIsMutable();
                    this.equipList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setEquipList(int index, ShowEquipOuterClass.ShowEquip.Builder builderForValue) {
                if (this.equipListBuilder_ == null) {
                    ensureEquipListIsMutable();
                    this.equipList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.equipListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addEquipList(ShowEquipOuterClass.ShowEquip value) {
                if (this.equipListBuilder_ != null) {
                    this.equipListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEquipListIsMutable();
                    this.equipList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addEquipList(int index, ShowEquipOuterClass.ShowEquip value) {
                if (this.equipListBuilder_ != null) {
                    this.equipListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEquipListIsMutable();
                    this.equipList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addEquipList(ShowEquipOuterClass.ShowEquip.Builder builderForValue) {
                if (this.equipListBuilder_ == null) {
                    ensureEquipListIsMutable();
                    this.equipList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.equipListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addEquipList(int index, ShowEquipOuterClass.ShowEquip.Builder builderForValue) {
                if (this.equipListBuilder_ == null) {
                    ensureEquipListIsMutable();
                    this.equipList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.equipListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllEquipList(Iterable<? extends ShowEquipOuterClass.ShowEquip> values) {
                if (this.equipListBuilder_ == null) {
                    ensureEquipListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.equipList_);
                    onChanged();
                } else {
                    this.equipListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearEquipList() {
                if (this.equipListBuilder_ == null) {
                    this.equipList_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                    onChanged();
                } else {
                    this.equipListBuilder_.clear();
                }
                return this;
            }

            public Builder removeEquipList(int index) {
                if (this.equipListBuilder_ == null) {
                    ensureEquipListIsMutable();
                    this.equipList_.remove(index);
                    onChanged();
                } else {
                    this.equipListBuilder_.remove(index);
                }
                return this;
            }

            public ShowEquipOuterClass.ShowEquip.Builder getEquipListBuilder(int index) {
                return getEquipListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public ShowEquipOuterClass.ShowEquipOrBuilder getEquipListOrBuilder(int index) {
                if (this.equipListBuilder_ == null) {
                    return this.equipList_.get(index);
                }
                return this.equipListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public List<? extends ShowEquipOuterClass.ShowEquipOrBuilder> getEquipListOrBuilderList() {
                if (this.equipListBuilder_ != null) {
                    return this.equipListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.equipList_);
            }

            public ShowEquipOuterClass.ShowEquip.Builder addEquipListBuilder() {
                return getEquipListFieldBuilder().addBuilder(ShowEquipOuterClass.ShowEquip.getDefaultInstance());
            }

            public ShowEquipOuterClass.ShowEquip.Builder addEquipListBuilder(int index) {
                return getEquipListFieldBuilder().addBuilder(index, ShowEquipOuterClass.ShowEquip.getDefaultInstance());
            }

            public List<ShowEquipOuterClass.ShowEquip.Builder> getEquipListBuilderList() {
                return getEquipListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ShowEquipOuterClass.ShowEquip, ShowEquipOuterClass.ShowEquip.Builder, ShowEquipOuterClass.ShowEquipOrBuilder> getEquipListFieldBuilder() {
                if (this.equipListBuilder_ == null) {
                    this.equipListBuilder_ = new RepeatedFieldBuilderV3<>(this.equipList_, (this.bitField0_ & 64) != 0, getParentForChildren(), isClean());
                    this.equipList_ = null;
                }
                return this.equipListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public boolean hasFetterInfo() {
                return (this.fetterInfoBuilder_ == null && this.fetterInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
            public boolean hasExcelInfo() {
                return (this.excelInfoBuilder_ == null && this.excelInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static ShowAvatarInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ShowAvatarInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ShowAvatarInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ShowAvatarInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AvatarExcelInfoOuterClass.getDescriptor();
        AvatarFetterInfoOuterClass.getDescriptor();
        PropValueOuterClass.getDescriptor();
        ShowEquipOuterClass.getDescriptor();
    }
}
