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
import emu.grasscutter.net.proto.CurVehicleInfoOuterClass;
import emu.grasscutter.net.proto.SceneReliquaryInfoOuterClass;
import emu.grasscutter.net.proto.SceneWeaponInfoOuterClass;
import emu.grasscutter.net.proto.ServerBuffOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneAvatarInfoOuterClass.class */
public final class SceneAvatarInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015SceneAvatarInfo.proto\u001a\u0015SceneWeaponInfo.proto\u001a\u0014CurVehicleInfo.proto\u001a\u0015AvatarExcelInfo.proto\u001a\u0018SceneReliquaryInfo.proto\u001a\u0010ServerBuff.proto\"ü\u0005\n\u000fSceneAvatarInfo\u0012\u000b\n\u0003uid\u0018\u0001 \u0001(\r\u0012\u0010\n\bavatarId\u0018\u0002 \u0001(\r\u0012\f\n\u0004guid\u0018\u0003 \u0001(\u0004\u0012\u000e\n\u0006peerId\u0018\u0004 \u0001(\r\u0012\u0013\n\u000bequipIdList\u0018\u0005 \u0003(\r\u0012\u0014\n\fskillDepotId\u0018\u0006 \u0001(\r\u0012\u0014\n\ftalentIdList\u0018\u0007 \u0003(\r\u0012 \n\u0006weapon\u0018\b \u0001(\u000b2\u0010.SceneWeaponInfo\u0012*\n\rreliquaryList\u0018\t \u0003(\u000b2\u0013.SceneReliquaryInfo\u0012\u001b\n\u0013coreProudSkillLevel\u0018\u000b \u0001(\r\u0012\u001e\n\u0016inherentProudSkillList\u0018\f \u0003(\r\u0012:\n\rskillLevelMap\u0018\r \u0003(\u000b2#.SceneAvatarInfo.SkillLevelMapEntry\u0012N\n\u0017proudSkillExtraLevelMap\u0018\u000e \u0003(\u000b2-.SceneAvatarInfo.ProudSkillExtraLevelMapEntry\u0012#\n\u000eserverBuffList\u0018\u000f \u0003(\u000b2\u000b.ServerBuff\u0012\u0019\n\u0011teamResonanceList\u0018\u0010 \u0003(\r\u0012\u0019\n\u0011wearingFlycloakId\u0018\u0011 \u0001(\r\u0012\u0010\n\bbornTime\u0018\u0012 \u0001(\r\u0012\u0011\n\tcostumeId\u0018\u0013 \u0001(\r\u0012'\n\u000ecurVehicleInfo\u0018\u0014 \u0001(\u000b2\u000f.CurVehicleInfo\u0012#\n\texcelInfo\u0018\u0015 \u0001(\u000b2\u0010.AvatarExcelInfo\u0012\u0010\n\banimHash\u0018\u0016 \u0001(\r\u001a4\n\u0012SkillLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a>\n\u001cProudSkillExtraLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SceneWeaponInfoOuterClass.getDescriptor(), CurVehicleInfoOuterClass.getDescriptor(), AvatarExcelInfoOuterClass.getDescriptor(), SceneReliquaryInfoOuterClass.getDescriptor(), ServerBuffOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneAvatarInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneAvatarInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneAvatarInfo_descriptor, new String[]{"Uid", "AvatarId", "Guid", "PeerId", "EquipIdList", "SkillDepotId", "TalentIdList", "Weapon", "ReliquaryList", "CoreProudSkillLevel", "InherentProudSkillList", "SkillLevelMap", "ProudSkillExtraLevelMap", "ServerBuffList", "TeamResonanceList", "WearingFlycloakId", "BornTime", "CostumeId", "CurVehicleInfo", "ExcelInfo", "AnimHash"});
    private static final Descriptors.Descriptor internal_static_SceneAvatarInfo_SkillLevelMapEntry_descriptor = internal_static_SceneAvatarInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_SceneAvatarInfo_SkillLevelMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f833xcb560ca8 = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneAvatarInfo_SkillLevelMapEntry_descriptor, new String[]{"Key", "Value"});

    /* renamed from: internal_static_SceneAvatarInfo_ProudSkillExtraLevelMapEntry_descriptor */
    private static final Descriptors.Descriptor f834xb5b264f4 = internal_static_SceneAvatarInfo_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_SceneAvatarInfo_ProudSkillExtraLevelMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f835x13b75772 = new GeneratedMessageV3.FieldAccessorTable(f834xb5b264f4, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneAvatarInfoOuterClass$SceneAvatarInfoOrBuilder.class */
    public interface SceneAvatarInfoOrBuilder extends MessageOrBuilder {
        int getUid();

        int getAvatarId();

        long getGuid();

        int getPeerId();

        List<Integer> getEquipIdListList();

        int getEquipIdListCount();

        int getEquipIdList(int i);

        int getSkillDepotId();

        List<Integer> getTalentIdListList();

        int getTalentIdListCount();

        int getTalentIdList(int i);

        boolean hasWeapon();

        SceneWeaponInfoOuterClass.SceneWeaponInfo getWeapon();

        SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder getWeaponOrBuilder();

        List<SceneReliquaryInfoOuterClass.SceneReliquaryInfo> getReliquaryListList();

        SceneReliquaryInfoOuterClass.SceneReliquaryInfo getReliquaryList(int i);

        int getReliquaryListCount();

        List<? extends SceneReliquaryInfoOuterClass.SceneReliquaryInfoOrBuilder> getReliquaryListOrBuilderList();

        SceneReliquaryInfoOuterClass.SceneReliquaryInfoOrBuilder getReliquaryListOrBuilder(int i);

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

        List<ServerBuffOuterClass.ServerBuff> getServerBuffListList();

        ServerBuffOuterClass.ServerBuff getServerBuffList(int i);

        int getServerBuffListCount();

        List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList();

        ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int i);

        List<Integer> getTeamResonanceListList();

        int getTeamResonanceListCount();

        int getTeamResonanceList(int i);

        int getWearingFlycloakId();

        int getBornTime();

        int getCostumeId();

        boolean hasCurVehicleInfo();

        CurVehicleInfoOuterClass.CurVehicleInfo getCurVehicleInfo();

        CurVehicleInfoOuterClass.CurVehicleInfoOrBuilder getCurVehicleInfoOrBuilder();

        boolean hasExcelInfo();

        AvatarExcelInfoOuterClass.AvatarExcelInfo getExcelInfo();

        AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder getExcelInfoOrBuilder();

        int getAnimHash();
    }

    private SceneAvatarInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneAvatarInfoOuterClass$SceneAvatarInfo.class */
    public static final class SceneAvatarInfo extends GeneratedMessageV3 implements SceneAvatarInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UID_FIELD_NUMBER = 1;
        private int uid_;
        public static final int AVATARID_FIELD_NUMBER = 2;
        private int avatarId_;
        public static final int GUID_FIELD_NUMBER = 3;
        private long guid_;
        public static final int PEERID_FIELD_NUMBER = 4;
        private int peerId_;
        public static final int EQUIPIDLIST_FIELD_NUMBER = 5;
        private Internal.IntList equipIdList_;
        private int equipIdListMemoizedSerializedSize;
        public static final int SKILLDEPOTID_FIELD_NUMBER = 6;
        private int skillDepotId_;
        public static final int TALENTIDLIST_FIELD_NUMBER = 7;
        private Internal.IntList talentIdList_;
        private int talentIdListMemoizedSerializedSize;
        public static final int WEAPON_FIELD_NUMBER = 8;
        private SceneWeaponInfoOuterClass.SceneWeaponInfo weapon_;
        public static final int RELIQUARYLIST_FIELD_NUMBER = 9;
        private List<SceneReliquaryInfoOuterClass.SceneReliquaryInfo> reliquaryList_;
        public static final int COREPROUDSKILLLEVEL_FIELD_NUMBER = 11;
        private int coreProudSkillLevel_;
        public static final int INHERENTPROUDSKILLLIST_FIELD_NUMBER = 12;
        private Internal.IntList inherentProudSkillList_;
        private int inherentProudSkillListMemoizedSerializedSize;
        public static final int SKILLLEVELMAP_FIELD_NUMBER = 13;
        private MapField<Integer, Integer> skillLevelMap_;
        public static final int PROUDSKILLEXTRALEVELMAP_FIELD_NUMBER = 14;
        private MapField<Integer, Integer> proudSkillExtraLevelMap_;
        public static final int SERVERBUFFLIST_FIELD_NUMBER = 15;
        private List<ServerBuffOuterClass.ServerBuff> serverBuffList_;
        public static final int TEAMRESONANCELIST_FIELD_NUMBER = 16;
        private Internal.IntList teamResonanceList_;
        private int teamResonanceListMemoizedSerializedSize;
        public static final int WEARINGFLYCLOAKID_FIELD_NUMBER = 17;
        private int wearingFlycloakId_;
        public static final int BORNTIME_FIELD_NUMBER = 18;
        private int bornTime_;
        public static final int COSTUMEID_FIELD_NUMBER = 19;
        private int costumeId_;
        public static final int CURVEHICLEINFO_FIELD_NUMBER = 20;
        private CurVehicleInfoOuterClass.CurVehicleInfo curVehicleInfo_;
        public static final int EXCELINFO_FIELD_NUMBER = 21;
        private AvatarExcelInfoOuterClass.AvatarExcelInfo excelInfo_;
        public static final int ANIMHASH_FIELD_NUMBER = 22;
        private int animHash_;
        private byte memoizedIsInitialized;
        private static final SceneAvatarInfo DEFAULT_INSTANCE = new SceneAvatarInfo();
        private static final Parser<SceneAvatarInfo> PARSER = new AbstractParser<SceneAvatarInfo>() { // from class: emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfo.1
            @Override // com.google.protobuf.Parser
            public SceneAvatarInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneAvatarInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 13: goto L_0x001c;
                    case 14: goto L_0x0021;
                    default: goto L_0x0026;
                }
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
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private SceneAvatarInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.equipIdListMemoizedSerializedSize = -1;
            this.talentIdListMemoizedSerializedSize = -1;
            this.inherentProudSkillListMemoizedSerializedSize = -1;
            this.teamResonanceListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private SceneAvatarInfo() {
            this.equipIdListMemoizedSerializedSize = -1;
            this.talentIdListMemoizedSerializedSize = -1;
            this.inherentProudSkillListMemoizedSerializedSize = -1;
            this.teamResonanceListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.equipIdList_ = emptyIntList();
            this.talentIdList_ = emptyIntList();
            this.reliquaryList_ = Collections.emptyList();
            this.inherentProudSkillList_ = emptyIntList();
            this.serverBuffList_ = Collections.emptyList();
            this.teamResonanceList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneAvatarInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:196:0x04cb */
        private SceneAvatarInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.uid_ = input.readUInt32();
                                break;
                            case 16:
                                this.avatarId_ = input.readUInt32();
                                break;
                            case 24:
                                this.guid_ = input.readUInt64();
                                break;
                            case 32:
                                this.peerId_ = input.readUInt32();
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.equipIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.equipIdList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.equipIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.equipIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 48:
                                this.skillDepotId_ = input.readUInt32();
                                break;
                            case 56:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.talentIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.talentIdList_.addInt(input.readUInt32());
                                break;
                            case 58:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.talentIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.talentIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 66:
                                SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder subBuilder = this.weapon_ != null ? this.weapon_.toBuilder() : null;
                                this.weapon_ = (SceneWeaponInfoOuterClass.SceneWeaponInfo) input.readMessage(SceneWeaponInfoOuterClass.SceneWeaponInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.weapon_);
                                    this.weapon_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 74:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.reliquaryList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.reliquaryList_.add((SceneReliquaryInfoOuterClass.SceneReliquaryInfo) input.readMessage(SceneReliquaryInfoOuterClass.SceneReliquaryInfo.parser(), extensionRegistry));
                                break;
                            case 88:
                                this.coreProudSkillLevel_ = input.readUInt32();
                                break;
                            case 96:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.inherentProudSkillList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.inherentProudSkillList_.addInt(input.readUInt32());
                                break;
                            case 98:
                                int limit3 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.inherentProudSkillList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.inherentProudSkillList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit3);
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 16) == 0) {
                                    this.skillLevelMap_ = MapField.newMapField(SkillLevelMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> skillLevelMap__ = (MapEntry) input.readMessage(SkillLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.skillLevelMap_.getMutableMap().put(skillLevelMap__.getKey(), skillLevelMap__.getValue());
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 32) == 0) {
                                    this.proudSkillExtraLevelMap_ = MapField.newMapField(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> proudSkillExtraLevelMap__ = (MapEntry) input.readMessage(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.proudSkillExtraLevelMap_.getMutableMap().put(proudSkillExtraLevelMap__.getKey(), proudSkillExtraLevelMap__.getValue());
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 64) == 0) {
                                    this.serverBuffList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                }
                                this.serverBuffList_.add((ServerBuffOuterClass.ServerBuff) input.readMessage(ServerBuffOuterClass.ServerBuff.parser(), extensionRegistry));
                                break;
                            case 128:
                                if ((mutable_bitField0_ & 128) == 0) {
                                    this.teamResonanceList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 128) == 1 ? 1 : 0;
                                }
                                this.teamResonanceList_.addInt(input.readUInt32());
                                break;
                            case 130:
                                int limit4 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 128) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.teamResonanceList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 128) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.teamResonanceList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit4);
                                break;
                            case 136:
                                this.wearingFlycloakId_ = input.readUInt32();
                                break;
                            case 144:
                                this.bornTime_ = input.readUInt32();
                                break;
                            case 152:
                                this.costumeId_ = input.readUInt32();
                                break;
                            case 162:
                                CurVehicleInfoOuterClass.CurVehicleInfo.Builder subBuilder2 = this.curVehicleInfo_ != null ? this.curVehicleInfo_.toBuilder() : null;
                                this.curVehicleInfo_ = (CurVehicleInfoOuterClass.CurVehicleInfo) input.readMessage(CurVehicleInfoOuterClass.CurVehicleInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.curVehicleInfo_);
                                    this.curVehicleInfo_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 170:
                                AvatarExcelInfoOuterClass.AvatarExcelInfo.Builder subBuilder3 = this.excelInfo_ != null ? this.excelInfo_.toBuilder() : null;
                                this.excelInfo_ = (AvatarExcelInfoOuterClass.AvatarExcelInfo) input.readMessage(AvatarExcelInfoOuterClass.AvatarExcelInfo.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.excelInfo_);
                                    this.excelInfo_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 176:
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.equipIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.talentIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.reliquaryList_ = Collections.unmodifiableList(this.reliquaryList_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.inherentProudSkillList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 64) != 0) {
                    this.serverBuffList_ = Collections.unmodifiableList(this.serverBuffList_);
                }
                if ((mutable_bitField0_ & 128) != 0) {
                    this.teamResonanceList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SceneAvatarInfoOuterClass.internal_static_SceneAvatarInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneAvatarInfoOuterClass.internal_static_SceneAvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneAvatarInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public long getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getPeerId() {
            return this.peerId_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public List<Integer> getEquipIdListList() {
            return this.equipIdList_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getEquipIdListCount() {
            return this.equipIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getEquipIdList(int index) {
            return this.equipIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getSkillDepotId() {
            return this.skillDepotId_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public List<Integer> getTalentIdListList() {
            return this.talentIdList_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getTalentIdListCount() {
            return this.talentIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getTalentIdList(int index) {
            return this.talentIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public boolean hasWeapon() {
            return this.weapon_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public SceneWeaponInfoOuterClass.SceneWeaponInfo getWeapon() {
            return this.weapon_ == null ? SceneWeaponInfoOuterClass.SceneWeaponInfo.getDefaultInstance() : this.weapon_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder getWeaponOrBuilder() {
            return getWeapon();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public List<SceneReliquaryInfoOuterClass.SceneReliquaryInfo> getReliquaryListList() {
            return this.reliquaryList_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public List<? extends SceneReliquaryInfoOuterClass.SceneReliquaryInfoOrBuilder> getReliquaryListOrBuilderList() {
            return this.reliquaryList_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getReliquaryListCount() {
            return this.reliquaryList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public SceneReliquaryInfoOuterClass.SceneReliquaryInfo getReliquaryList(int index) {
            return this.reliquaryList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public SceneReliquaryInfoOuterClass.SceneReliquaryInfoOrBuilder getReliquaryListOrBuilder(int index) {
            return this.reliquaryList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getCoreProudSkillLevel() {
            return this.coreProudSkillLevel_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public List<Integer> getInherentProudSkillListList() {
            return this.inherentProudSkillList_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getInherentProudSkillListCount() {
            return this.inherentProudSkillList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getInherentProudSkillList(int index) {
            return this.inherentProudSkillList_.getInt(index);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneAvatarInfoOuterClass$SceneAvatarInfo$SkillLevelMapDefaultEntryHolder.class */
        public static final class SkillLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(SceneAvatarInfoOuterClass.internal_static_SceneAvatarInfo_SkillLevelMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private SkillLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetSkillLevelMap() {
            if (this.skillLevelMap_ == null) {
                return MapField.emptyMapField(SkillLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.skillLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getSkillLevelMapCount() {
            return internalGetSkillLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public boolean containsSkillLevelMap(int key) {
            return internalGetSkillLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getSkillLevelMap() {
            return getSkillLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public Map<Integer, Integer> getSkillLevelMapMap() {
            return internalGetSkillLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getSkillLevelMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetSkillLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getSkillLevelMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetSkillLevelMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneAvatarInfoOuterClass$SceneAvatarInfo$ProudSkillExtraLevelMapDefaultEntryHolder.class */
        public static final class ProudSkillExtraLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(SceneAvatarInfoOuterClass.f834xb5b264f4, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private ProudSkillExtraLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetProudSkillExtraLevelMap() {
            if (this.proudSkillExtraLevelMap_ == null) {
                return MapField.emptyMapField(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.proudSkillExtraLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getProudSkillExtraLevelMapCount() {
            return internalGetProudSkillExtraLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public boolean containsProudSkillExtraLevelMap(int key) {
            return internalGetProudSkillExtraLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getProudSkillExtraLevelMap() {
            return getProudSkillExtraLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public Map<Integer, Integer> getProudSkillExtraLevelMapMap() {
            return internalGetProudSkillExtraLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getProudSkillExtraLevelMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetProudSkillExtraLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getProudSkillExtraLevelMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetProudSkillExtraLevelMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public List<ServerBuffOuterClass.ServerBuff> getServerBuffListList() {
            return this.serverBuffList_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList() {
            return this.serverBuffList_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getServerBuffListCount() {
            return this.serverBuffList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public ServerBuffOuterClass.ServerBuff getServerBuffList(int index) {
            return this.serverBuffList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int index) {
            return this.serverBuffList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public List<Integer> getTeamResonanceListList() {
            return this.teamResonanceList_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getTeamResonanceListCount() {
            return this.teamResonanceList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getTeamResonanceList(int index) {
            return this.teamResonanceList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getWearingFlycloakId() {
            return this.wearingFlycloakId_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getBornTime() {
            return this.bornTime_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public int getCostumeId() {
            return this.costumeId_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public boolean hasCurVehicleInfo() {
            return this.curVehicleInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public CurVehicleInfoOuterClass.CurVehicleInfo getCurVehicleInfo() {
            return this.curVehicleInfo_ == null ? CurVehicleInfoOuterClass.CurVehicleInfo.getDefaultInstance() : this.curVehicleInfo_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public CurVehicleInfoOuterClass.CurVehicleInfoOrBuilder getCurVehicleInfoOrBuilder() {
            return getCurVehicleInfo();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public boolean hasExcelInfo() {
            return this.excelInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public AvatarExcelInfoOuterClass.AvatarExcelInfo getExcelInfo() {
            return this.excelInfo_ == null ? AvatarExcelInfoOuterClass.AvatarExcelInfo.getDefaultInstance() : this.excelInfo_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
        public AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder getExcelInfoOrBuilder() {
            return getExcelInfo();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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
            if (this.uid_ != 0) {
                output.writeUInt32(1, this.uid_);
            }
            if (this.avatarId_ != 0) {
                output.writeUInt32(2, this.avatarId_);
            }
            if (this.guid_ != 0) {
                output.writeUInt64(3, this.guid_);
            }
            if (this.peerId_ != 0) {
                output.writeUInt32(4, this.peerId_);
            }
            if (getEquipIdListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.equipIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.equipIdList_.size(); i++) {
                output.writeUInt32NoTag(this.equipIdList_.getInt(i));
            }
            if (this.skillDepotId_ != 0) {
                output.writeUInt32(6, this.skillDepotId_);
            }
            if (getTalentIdListList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.talentIdListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.talentIdList_.size(); i2++) {
                output.writeUInt32NoTag(this.talentIdList_.getInt(i2));
            }
            if (this.weapon_ != null) {
                output.writeMessage(8, getWeapon());
            }
            for (int i3 = 0; i3 < this.reliquaryList_.size(); i3++) {
                output.writeMessage(9, this.reliquaryList_.get(i3));
            }
            if (this.coreProudSkillLevel_ != 0) {
                output.writeUInt32(11, this.coreProudSkillLevel_);
            }
            if (getInherentProudSkillListList().size() > 0) {
                output.writeUInt32NoTag(98);
                output.writeUInt32NoTag(this.inherentProudSkillListMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.inherentProudSkillList_.size(); i4++) {
                output.writeUInt32NoTag(this.inherentProudSkillList_.getInt(i4));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSkillLevelMap(), SkillLevelMapDefaultEntryHolder.defaultEntry, 13);
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetProudSkillExtraLevelMap(), ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry, 14);
            for (int i5 = 0; i5 < this.serverBuffList_.size(); i5++) {
                output.writeMessage(15, this.serverBuffList_.get(i5));
            }
            if (getTeamResonanceListList().size() > 0) {
                output.writeUInt32NoTag(130);
                output.writeUInt32NoTag(this.teamResonanceListMemoizedSerializedSize);
            }
            for (int i6 = 0; i6 < this.teamResonanceList_.size(); i6++) {
                output.writeUInt32NoTag(this.teamResonanceList_.getInt(i6));
            }
            if (this.wearingFlycloakId_ != 0) {
                output.writeUInt32(17, this.wearingFlycloakId_);
            }
            if (this.bornTime_ != 0) {
                output.writeUInt32(18, this.bornTime_);
            }
            if (this.costumeId_ != 0) {
                output.writeUInt32(19, this.costumeId_);
            }
            if (this.curVehicleInfo_ != null) {
                output.writeMessage(20, getCurVehicleInfo());
            }
            if (this.excelInfo_ != null) {
                output.writeMessage(21, getExcelInfo());
            }
            if (this.animHash_ != 0) {
                output.writeUInt32(22, this.animHash_);
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
            if (this.uid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.uid_);
            }
            if (this.avatarId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.avatarId_);
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(3, this.guid_);
            }
            if (this.peerId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.peerId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.equipIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.equipIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getEquipIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.equipIdListMemoizedSerializedSize = dataSize;
            if (this.skillDepotId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(6, this.skillDepotId_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.talentIdList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.talentIdList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getTalentIdListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.talentIdListMemoizedSerializedSize = dataSize2;
            if (this.weapon_ != null) {
                size4 += CodedOutputStream.computeMessageSize(8, getWeapon());
            }
            for (int i3 = 0; i3 < this.reliquaryList_.size(); i3++) {
                size4 += CodedOutputStream.computeMessageSize(9, this.reliquaryList_.get(i3));
            }
            if (this.coreProudSkillLevel_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(11, this.coreProudSkillLevel_);
            }
            int dataSize3 = 0;
            for (int i4 = 0; i4 < this.inherentProudSkillList_.size(); i4++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.inherentProudSkillList_.getInt(i4));
            }
            int size5 = size4 + dataSize3;
            if (!getInherentProudSkillListList().isEmpty()) {
                size5 = size5 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.inherentProudSkillListMemoizedSerializedSize = dataSize3;
            for (Map.Entry<Integer, Integer> entry : internalGetSkillLevelMap().getMap().entrySet()) {
                size5 += CodedOutputStream.computeMessageSize(13, SkillLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            for (Map.Entry<Integer, Integer> entry2 : internalGetProudSkillExtraLevelMap().getMap().entrySet()) {
                size5 += CodedOutputStream.computeMessageSize(14, ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            for (int i5 = 0; i5 < this.serverBuffList_.size(); i5++) {
                size5 += CodedOutputStream.computeMessageSize(15, this.serverBuffList_.get(i5));
            }
            int dataSize4 = 0;
            for (int i6 = 0; i6 < this.teamResonanceList_.size(); i6++) {
                dataSize4 += CodedOutputStream.computeUInt32SizeNoTag(this.teamResonanceList_.getInt(i6));
            }
            int size6 = size5 + dataSize4;
            if (!getTeamResonanceListList().isEmpty()) {
                size6 = size6 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize4);
            }
            this.teamResonanceListMemoizedSerializedSize = dataSize4;
            if (this.wearingFlycloakId_ != 0) {
                size6 += CodedOutputStream.computeUInt32Size(17, this.wearingFlycloakId_);
            }
            if (this.bornTime_ != 0) {
                size6 += CodedOutputStream.computeUInt32Size(18, this.bornTime_);
            }
            if (this.costumeId_ != 0) {
                size6 += CodedOutputStream.computeUInt32Size(19, this.costumeId_);
            }
            if (this.curVehicleInfo_ != null) {
                size6 += CodedOutputStream.computeMessageSize(20, getCurVehicleInfo());
            }
            if (this.excelInfo_ != null) {
                size6 += CodedOutputStream.computeMessageSize(21, getExcelInfo());
            }
            if (this.animHash_ != 0) {
                size6 += CodedOutputStream.computeUInt32Size(22, this.animHash_);
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
            if (!(obj instanceof SceneAvatarInfo)) {
                return equals(obj);
            }
            SceneAvatarInfo other = (SceneAvatarInfo) obj;
            if (getUid() != other.getUid() || getAvatarId() != other.getAvatarId() || getGuid() != other.getGuid() || getPeerId() != other.getPeerId() || !getEquipIdListList().equals(other.getEquipIdListList()) || getSkillDepotId() != other.getSkillDepotId() || !getTalentIdListList().equals(other.getTalentIdListList()) || hasWeapon() != other.hasWeapon()) {
                return false;
            }
            if ((hasWeapon() && !getWeapon().equals(other.getWeapon())) || !getReliquaryListList().equals(other.getReliquaryListList()) || getCoreProudSkillLevel() != other.getCoreProudSkillLevel() || !getInherentProudSkillListList().equals(other.getInherentProudSkillListList()) || !internalGetSkillLevelMap().equals(other.internalGetSkillLevelMap()) || !internalGetProudSkillExtraLevelMap().equals(other.internalGetProudSkillExtraLevelMap()) || !getServerBuffListList().equals(other.getServerBuffListList()) || !getTeamResonanceListList().equals(other.getTeamResonanceListList()) || getWearingFlycloakId() != other.getWearingFlycloakId() || getBornTime() != other.getBornTime() || getCostumeId() != other.getCostumeId() || hasCurVehicleInfo() != other.hasCurVehicleInfo()) {
                return false;
            }
            if ((!hasCurVehicleInfo() || getCurVehicleInfo().equals(other.getCurVehicleInfo())) && hasExcelInfo() == other.hasExcelInfo()) {
                return (!hasExcelInfo() || getExcelInfo().equals(other.getExcelInfo())) && getAnimHash() == other.getAnimHash() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getUid())) + 2)) + getAvatarId())) + 3)) + Internal.hashLong(getGuid()))) + 4)) + getPeerId();
            if (getEquipIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getEquipIdListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 6)) + getSkillDepotId();
            if (getTalentIdListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 7)) + getTalentIdListList().hashCode();
            }
            if (hasWeapon()) {
                hash2 = (53 * ((37 * hash2) + 8)) + getWeapon().hashCode();
            }
            if (getReliquaryListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 9)) + getReliquaryListList().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 11)) + getCoreProudSkillLevel();
            if (getInherentProudSkillListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 12)) + getInherentProudSkillListList().hashCode();
            }
            if (!internalGetSkillLevelMap().getMap().isEmpty()) {
                hash3 = (53 * ((37 * hash3) + 13)) + internalGetSkillLevelMap().hashCode();
            }
            if (!internalGetProudSkillExtraLevelMap().getMap().isEmpty()) {
                hash3 = (53 * ((37 * hash3) + 14)) + internalGetProudSkillExtraLevelMap().hashCode();
            }
            if (getServerBuffListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 15)) + getServerBuffListList().hashCode();
            }
            if (getTeamResonanceListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 16)) + getTeamResonanceListList().hashCode();
            }
            int hash4 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash3) + 17)) + getWearingFlycloakId())) + 18)) + getBornTime())) + 19)) + getCostumeId();
            if (hasCurVehicleInfo()) {
                hash4 = (53 * ((37 * hash4) + 20)) + getCurVehicleInfo().hashCode();
            }
            if (hasExcelInfo()) {
                hash4 = (53 * ((37 * hash4) + 21)) + getExcelInfo().hashCode();
            }
            int hash5 = (29 * ((53 * ((37 * hash4) + 22)) + getAnimHash())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash5;
            return hash5;
        }

        public static SceneAvatarInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneAvatarInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneAvatarInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneAvatarInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneAvatarInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneAvatarInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneAvatarInfo parseFrom(InputStream input) throws IOException {
            return (SceneAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneAvatarInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneAvatarInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneAvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneAvatarInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneAvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneAvatarInfo parseFrom(CodedInputStream input) throws IOException {
            return (SceneAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneAvatarInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneAvatarInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneAvatarInfoOuterClass$SceneAvatarInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneAvatarInfoOrBuilder {
            private int bitField0_;
            private int uid_;
            private int avatarId_;
            private long guid_;
            private int peerId_;
            private int skillDepotId_;
            private SceneWeaponInfoOuterClass.SceneWeaponInfo weapon_;
            private SingleFieldBuilderV3<SceneWeaponInfoOuterClass.SceneWeaponInfo, SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder, SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder> weaponBuilder_;
            private RepeatedFieldBuilderV3<SceneReliquaryInfoOuterClass.SceneReliquaryInfo, SceneReliquaryInfoOuterClass.SceneReliquaryInfo.Builder, SceneReliquaryInfoOuterClass.SceneReliquaryInfoOrBuilder> reliquaryListBuilder_;
            private int coreProudSkillLevel_;
            private MapField<Integer, Integer> skillLevelMap_;
            private MapField<Integer, Integer> proudSkillExtraLevelMap_;
            private RepeatedFieldBuilderV3<ServerBuffOuterClass.ServerBuff, ServerBuffOuterClass.ServerBuff.Builder, ServerBuffOuterClass.ServerBuffOrBuilder> serverBuffListBuilder_;
            private int wearingFlycloakId_;
            private int bornTime_;
            private int costumeId_;
            private CurVehicleInfoOuterClass.CurVehicleInfo curVehicleInfo_;
            private SingleFieldBuilderV3<CurVehicleInfoOuterClass.CurVehicleInfo, CurVehicleInfoOuterClass.CurVehicleInfo.Builder, CurVehicleInfoOuterClass.CurVehicleInfoOrBuilder> curVehicleInfoBuilder_;
            private AvatarExcelInfoOuterClass.AvatarExcelInfo excelInfo_;
            private SingleFieldBuilderV3<AvatarExcelInfoOuterClass.AvatarExcelInfo, AvatarExcelInfoOuterClass.AvatarExcelInfo.Builder, AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder> excelInfoBuilder_;
            private int animHash_;
            private Internal.IntList equipIdList_ = SceneAvatarInfo.emptyIntList();
            private Internal.IntList talentIdList_ = SceneAvatarInfo.emptyIntList();
            private List<SceneReliquaryInfoOuterClass.SceneReliquaryInfo> reliquaryList_ = Collections.emptyList();
            private Internal.IntList inherentProudSkillList_ = SceneAvatarInfo.emptyIntList();
            private List<ServerBuffOuterClass.ServerBuff> serverBuffList_ = Collections.emptyList();
            private Internal.IntList teamResonanceList_ = SceneAvatarInfo.emptyIntList();

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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 13: goto L_0x001c;
                        case 14: goto L_0x0021;
                        default: goto L_0x0026;
                    }
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
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 13: goto L_0x001c;
                        case 14: goto L_0x0021;
                        default: goto L_0x0026;
                    }
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
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneAvatarInfoOuterClass.internal_static_SceneAvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneAvatarInfoOuterClass.internal_static_SceneAvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneAvatarInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneAvatarInfo.alwaysUseFieldBuilders) {
                    getReliquaryListFieldBuilder();
                    getServerBuffListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.uid_ = 0;
                this.avatarId_ = 0;
                this.guid_ = 0;
                this.peerId_ = 0;
                this.equipIdList_ = SceneAvatarInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.skillDepotId_ = 0;
                this.talentIdList_ = SceneAvatarInfo.emptyIntList();
                this.bitField0_ &= -3;
                if (this.weaponBuilder_ == null) {
                    this.weapon_ = null;
                } else {
                    this.weapon_ = null;
                    this.weaponBuilder_ = null;
                }
                if (this.reliquaryListBuilder_ == null) {
                    this.reliquaryList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.reliquaryListBuilder_.clear();
                }
                this.coreProudSkillLevel_ = 0;
                this.inherentProudSkillList_ = SceneAvatarInfo.emptyIntList();
                this.bitField0_ &= -9;
                internalGetMutableSkillLevelMap().clear();
                internalGetMutableProudSkillExtraLevelMap().clear();
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffList_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                } else {
                    this.serverBuffListBuilder_.clear();
                }
                this.teamResonanceList_ = SceneAvatarInfo.emptyIntList();
                this.bitField0_ &= -129;
                this.wearingFlycloakId_ = 0;
                this.bornTime_ = 0;
                this.costumeId_ = 0;
                if (this.curVehicleInfoBuilder_ == null) {
                    this.curVehicleInfo_ = null;
                } else {
                    this.curVehicleInfo_ = null;
                    this.curVehicleInfoBuilder_ = null;
                }
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
                return SceneAvatarInfoOuterClass.internal_static_SceneAvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneAvatarInfo getDefaultInstanceForType() {
                return SceneAvatarInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneAvatarInfo build() {
                SceneAvatarInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneAvatarInfo buildPartial() {
                SceneAvatarInfo result = new SceneAvatarInfo(this);
                int i = this.bitField0_;
                result.uid_ = this.uid_;
                result.avatarId_ = this.avatarId_;
                result.guid_ = this.guid_;
                result.peerId_ = this.peerId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.equipIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.equipIdList_ = this.equipIdList_;
                result.skillDepotId_ = this.skillDepotId_;
                if ((this.bitField0_ & 2) != 0) {
                    this.talentIdList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.talentIdList_ = this.talentIdList_;
                if (this.weaponBuilder_ == null) {
                    result.weapon_ = this.weapon_;
                } else {
                    result.weapon_ = this.weaponBuilder_.build();
                }
                if (this.reliquaryListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.reliquaryList_ = Collections.unmodifiableList(this.reliquaryList_);
                        this.bitField0_ &= -5;
                    }
                    result.reliquaryList_ = this.reliquaryList_;
                } else {
                    result.reliquaryList_ = this.reliquaryListBuilder_.build();
                }
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
                if (this.serverBuffListBuilder_ == null) {
                    if ((this.bitField0_ & 64) != 0) {
                        this.serverBuffList_ = Collections.unmodifiableList(this.serverBuffList_);
                        this.bitField0_ &= -65;
                    }
                    result.serverBuffList_ = this.serverBuffList_;
                } else {
                    result.serverBuffList_ = this.serverBuffListBuilder_.build();
                }
                if ((this.bitField0_ & 128) != 0) {
                    this.teamResonanceList_.makeImmutable();
                    this.bitField0_ &= -129;
                }
                result.teamResonanceList_ = this.teamResonanceList_;
                result.wearingFlycloakId_ = this.wearingFlycloakId_;
                result.bornTime_ = this.bornTime_;
                result.costumeId_ = this.costumeId_;
                if (this.curVehicleInfoBuilder_ == null) {
                    result.curVehicleInfo_ = this.curVehicleInfo_;
                } else {
                    result.curVehicleInfo_ = this.curVehicleInfoBuilder_.build();
                }
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
                if (other instanceof SceneAvatarInfo) {
                    return mergeFrom((SceneAvatarInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneAvatarInfo other) {
                if (other == SceneAvatarInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                if (other.getPeerId() != 0) {
                    setPeerId(other.getPeerId());
                }
                if (!other.equipIdList_.isEmpty()) {
                    if (this.equipIdList_.isEmpty()) {
                        this.equipIdList_ = other.equipIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureEquipIdListIsMutable();
                        this.equipIdList_.addAll(other.equipIdList_);
                    }
                    onChanged();
                }
                if (other.getSkillDepotId() != 0) {
                    setSkillDepotId(other.getSkillDepotId());
                }
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
                if (other.hasWeapon()) {
                    mergeWeapon(other.getWeapon());
                }
                if (this.reliquaryListBuilder_ == null) {
                    if (!other.reliquaryList_.isEmpty()) {
                        if (this.reliquaryList_.isEmpty()) {
                            this.reliquaryList_ = other.reliquaryList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureReliquaryListIsMutable();
                            this.reliquaryList_.addAll(other.reliquaryList_);
                        }
                        onChanged();
                    }
                } else if (!other.reliquaryList_.isEmpty()) {
                    if (this.reliquaryListBuilder_.isEmpty()) {
                        this.reliquaryListBuilder_.dispose();
                        this.reliquaryListBuilder_ = null;
                        this.reliquaryList_ = other.reliquaryList_;
                        this.bitField0_ &= -5;
                        this.reliquaryListBuilder_ = SceneAvatarInfo.alwaysUseFieldBuilders ? getReliquaryListFieldBuilder() : null;
                    } else {
                        this.reliquaryListBuilder_.addAllMessages(other.reliquaryList_);
                    }
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
                if (this.serverBuffListBuilder_ == null) {
                    if (!other.serverBuffList_.isEmpty()) {
                        if (this.serverBuffList_.isEmpty()) {
                            this.serverBuffList_ = other.serverBuffList_;
                            this.bitField0_ &= -65;
                        } else {
                            ensureServerBuffListIsMutable();
                            this.serverBuffList_.addAll(other.serverBuffList_);
                        }
                        onChanged();
                    }
                } else if (!other.serverBuffList_.isEmpty()) {
                    if (this.serverBuffListBuilder_.isEmpty()) {
                        this.serverBuffListBuilder_.dispose();
                        this.serverBuffListBuilder_ = null;
                        this.serverBuffList_ = other.serverBuffList_;
                        this.bitField0_ &= -65;
                        this.serverBuffListBuilder_ = SceneAvatarInfo.alwaysUseFieldBuilders ? getServerBuffListFieldBuilder() : null;
                    } else {
                        this.serverBuffListBuilder_.addAllMessages(other.serverBuffList_);
                    }
                }
                if (!other.teamResonanceList_.isEmpty()) {
                    if (this.teamResonanceList_.isEmpty()) {
                        this.teamResonanceList_ = other.teamResonanceList_;
                        this.bitField0_ &= -129;
                    } else {
                        ensureTeamResonanceListIsMutable();
                        this.teamResonanceList_.addAll(other.teamResonanceList_);
                    }
                    onChanged();
                }
                if (other.getWearingFlycloakId() != 0) {
                    setWearingFlycloakId(other.getWearingFlycloakId());
                }
                if (other.getBornTime() != 0) {
                    setBornTime(other.getBornTime());
                }
                if (other.getCostumeId() != 0) {
                    setCostumeId(other.getCostumeId());
                }
                if (other.hasCurVehicleInfo()) {
                    mergeCurVehicleInfo(other.getCurVehicleInfo());
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
                SceneAvatarInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneAvatarInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneAvatarInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public Builder setUid(int value) {
                this.uid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public int getPeerId() {
                return this.peerId_;
            }

            public Builder setPeerId(int value) {
                this.peerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPeerId() {
                this.peerId_ = 0;
                onChanged();
                return this;
            }

            private void ensureEquipIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.equipIdList_ = SceneAvatarInfo.mutableCopy(this.equipIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public List<Integer> getEquipIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.equipIdList_) : this.equipIdList_;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public int getEquipIdListCount() {
                return this.equipIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public int getEquipIdList(int index) {
                return this.equipIdList_.getInt(index);
            }

            public Builder setEquipIdList(int index, int value) {
                ensureEquipIdListIsMutable();
                this.equipIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addEquipIdList(int value) {
                ensureEquipIdListIsMutable();
                this.equipIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllEquipIdList(Iterable<? extends Integer> values) {
                ensureEquipIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.equipIdList_);
                onChanged();
                return this;
            }

            public Builder clearEquipIdList() {
                this.equipIdList_ = SceneAvatarInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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

            private void ensureTalentIdListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.talentIdList_ = SceneAvatarInfo.mutableCopy(this.talentIdList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public List<Integer> getTalentIdListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.talentIdList_) : this.talentIdList_;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public int getTalentIdListCount() {
                return this.talentIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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
                this.talentIdList_ = SceneAvatarInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public boolean hasWeapon() {
                return (this.weaponBuilder_ == null && this.weapon_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public SceneWeaponInfoOuterClass.SceneWeaponInfo getWeapon() {
                if (this.weaponBuilder_ == null) {
                    return this.weapon_ == null ? SceneWeaponInfoOuterClass.SceneWeaponInfo.getDefaultInstance() : this.weapon_;
                }
                return this.weaponBuilder_.getMessage();
            }

            public Builder setWeapon(SceneWeaponInfoOuterClass.SceneWeaponInfo value) {
                if (this.weaponBuilder_ != null) {
                    this.weaponBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.weapon_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setWeapon(SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder builderForValue) {
                if (this.weaponBuilder_ == null) {
                    this.weapon_ = builderForValue.build();
                    onChanged();
                } else {
                    this.weaponBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeWeapon(SceneWeaponInfoOuterClass.SceneWeaponInfo value) {
                if (this.weaponBuilder_ == null) {
                    if (this.weapon_ != null) {
                        this.weapon_ = SceneWeaponInfoOuterClass.SceneWeaponInfo.newBuilder(this.weapon_).mergeFrom(value).buildPartial();
                    } else {
                        this.weapon_ = value;
                    }
                    onChanged();
                } else {
                    this.weaponBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearWeapon() {
                if (this.weaponBuilder_ == null) {
                    this.weapon_ = null;
                    onChanged();
                } else {
                    this.weapon_ = null;
                    this.weaponBuilder_ = null;
                }
                return this;
            }

            public SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder getWeaponBuilder() {
                onChanged();
                return getWeaponFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder getWeaponOrBuilder() {
                if (this.weaponBuilder_ != null) {
                    return this.weaponBuilder_.getMessageOrBuilder();
                }
                return this.weapon_ == null ? SceneWeaponInfoOuterClass.SceneWeaponInfo.getDefaultInstance() : this.weapon_;
            }

            private SingleFieldBuilderV3<SceneWeaponInfoOuterClass.SceneWeaponInfo, SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder, SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder> getWeaponFieldBuilder() {
                if (this.weaponBuilder_ == null) {
                    this.weaponBuilder_ = new SingleFieldBuilderV3<>(getWeapon(), getParentForChildren(), isClean());
                    this.weapon_ = null;
                }
                return this.weaponBuilder_;
            }

            private void ensureReliquaryListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.reliquaryList_ = new ArrayList(this.reliquaryList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public List<SceneReliquaryInfoOuterClass.SceneReliquaryInfo> getReliquaryListList() {
                if (this.reliquaryListBuilder_ == null) {
                    return Collections.unmodifiableList(this.reliquaryList_);
                }
                return this.reliquaryListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public int getReliquaryListCount() {
                if (this.reliquaryListBuilder_ == null) {
                    return this.reliquaryList_.size();
                }
                return this.reliquaryListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public SceneReliquaryInfoOuterClass.SceneReliquaryInfo getReliquaryList(int index) {
                if (this.reliquaryListBuilder_ == null) {
                    return this.reliquaryList_.get(index);
                }
                return this.reliquaryListBuilder_.getMessage(index);
            }

            public Builder setReliquaryList(int index, SceneReliquaryInfoOuterClass.SceneReliquaryInfo value) {
                if (this.reliquaryListBuilder_ != null) {
                    this.reliquaryListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureReliquaryListIsMutable();
                    this.reliquaryList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setReliquaryList(int index, SceneReliquaryInfoOuterClass.SceneReliquaryInfo.Builder builderForValue) {
                if (this.reliquaryListBuilder_ == null) {
                    ensureReliquaryListIsMutable();
                    this.reliquaryList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.reliquaryListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addReliquaryList(SceneReliquaryInfoOuterClass.SceneReliquaryInfo value) {
                if (this.reliquaryListBuilder_ != null) {
                    this.reliquaryListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureReliquaryListIsMutable();
                    this.reliquaryList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addReliquaryList(int index, SceneReliquaryInfoOuterClass.SceneReliquaryInfo value) {
                if (this.reliquaryListBuilder_ != null) {
                    this.reliquaryListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureReliquaryListIsMutable();
                    this.reliquaryList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addReliquaryList(SceneReliquaryInfoOuterClass.SceneReliquaryInfo.Builder builderForValue) {
                if (this.reliquaryListBuilder_ == null) {
                    ensureReliquaryListIsMutable();
                    this.reliquaryList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.reliquaryListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addReliquaryList(int index, SceneReliquaryInfoOuterClass.SceneReliquaryInfo.Builder builderForValue) {
                if (this.reliquaryListBuilder_ == null) {
                    ensureReliquaryListIsMutable();
                    this.reliquaryList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.reliquaryListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllReliquaryList(Iterable<? extends SceneReliquaryInfoOuterClass.SceneReliquaryInfo> values) {
                if (this.reliquaryListBuilder_ == null) {
                    ensureReliquaryListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.reliquaryList_);
                    onChanged();
                } else {
                    this.reliquaryListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearReliquaryList() {
                if (this.reliquaryListBuilder_ == null) {
                    this.reliquaryList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.reliquaryListBuilder_.clear();
                }
                return this;
            }

            public Builder removeReliquaryList(int index) {
                if (this.reliquaryListBuilder_ == null) {
                    ensureReliquaryListIsMutable();
                    this.reliquaryList_.remove(index);
                    onChanged();
                } else {
                    this.reliquaryListBuilder_.remove(index);
                }
                return this;
            }

            public SceneReliquaryInfoOuterClass.SceneReliquaryInfo.Builder getReliquaryListBuilder(int index) {
                return getReliquaryListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public SceneReliquaryInfoOuterClass.SceneReliquaryInfoOrBuilder getReliquaryListOrBuilder(int index) {
                if (this.reliquaryListBuilder_ == null) {
                    return this.reliquaryList_.get(index);
                }
                return this.reliquaryListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public List<? extends SceneReliquaryInfoOuterClass.SceneReliquaryInfoOrBuilder> getReliquaryListOrBuilderList() {
                if (this.reliquaryListBuilder_ != null) {
                    return this.reliquaryListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.reliquaryList_);
            }

            public SceneReliquaryInfoOuterClass.SceneReliquaryInfo.Builder addReliquaryListBuilder() {
                return getReliquaryListFieldBuilder().addBuilder(SceneReliquaryInfoOuterClass.SceneReliquaryInfo.getDefaultInstance());
            }

            public SceneReliquaryInfoOuterClass.SceneReliquaryInfo.Builder addReliquaryListBuilder(int index) {
                return getReliquaryListFieldBuilder().addBuilder(index, SceneReliquaryInfoOuterClass.SceneReliquaryInfo.getDefaultInstance());
            }

            public List<SceneReliquaryInfoOuterClass.SceneReliquaryInfo.Builder> getReliquaryListBuilderList() {
                return getReliquaryListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SceneReliquaryInfoOuterClass.SceneReliquaryInfo, SceneReliquaryInfoOuterClass.SceneReliquaryInfo.Builder, SceneReliquaryInfoOuterClass.SceneReliquaryInfoOrBuilder> getReliquaryListFieldBuilder() {
                if (this.reliquaryListBuilder_ == null) {
                    this.reliquaryListBuilder_ = new RepeatedFieldBuilderV3<>(this.reliquaryList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.reliquaryList_ = null;
                }
                return this.reliquaryListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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
                    this.inherentProudSkillList_ = SceneAvatarInfo.mutableCopy(this.inherentProudSkillList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public List<Integer> getInherentProudSkillListList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.inherentProudSkillList_) : this.inherentProudSkillList_;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public int getInherentProudSkillListCount() {
                return this.inherentProudSkillList_.size();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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
                this.inherentProudSkillList_ = SceneAvatarInfo.emptyIntList();
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

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public int getSkillLevelMapCount() {
                return internalGetSkillLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public boolean containsSkillLevelMap(int key) {
                return internalGetSkillLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getSkillLevelMap() {
                return getSkillLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public Map<Integer, Integer> getSkillLevelMapMap() {
                return internalGetSkillLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public int getSkillLevelMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetSkillLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public int getProudSkillExtraLevelMapCount() {
                return internalGetProudSkillExtraLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public boolean containsProudSkillExtraLevelMap(int key) {
                return internalGetProudSkillExtraLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getProudSkillExtraLevelMap() {
                return getProudSkillExtraLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public Map<Integer, Integer> getProudSkillExtraLevelMapMap() {
                return internalGetProudSkillExtraLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public int getProudSkillExtraLevelMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetProudSkillExtraLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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

            private void ensureServerBuffListIsMutable() {
                if ((this.bitField0_ & 64) == 0) {
                    this.serverBuffList_ = new ArrayList(this.serverBuffList_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public List<ServerBuffOuterClass.ServerBuff> getServerBuffListList() {
                if (this.serverBuffListBuilder_ == null) {
                    return Collections.unmodifiableList(this.serverBuffList_);
                }
                return this.serverBuffListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public int getServerBuffListCount() {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.size();
                }
                return this.serverBuffListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public ServerBuffOuterClass.ServerBuff getServerBuffList(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.get(index);
                }
                return this.serverBuffListBuilder_.getMessage(index);
            }

            public Builder setServerBuffList(int index, ServerBuffOuterClass.ServerBuff value) {
                if (this.serverBuffListBuilder_ != null) {
                    this.serverBuffListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setServerBuffList(int index, ServerBuffOuterClass.ServerBuff.Builder builderForValue) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addServerBuffList(ServerBuffOuterClass.ServerBuff value) {
                if (this.serverBuffListBuilder_ != null) {
                    this.serverBuffListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addServerBuffList(int index, ServerBuffOuterClass.ServerBuff value) {
                if (this.serverBuffListBuilder_ != null) {
                    this.serverBuffListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addServerBuffList(ServerBuffOuterClass.ServerBuff.Builder builderForValue) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addServerBuffList(int index, ServerBuffOuterClass.ServerBuff.Builder builderForValue) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllServerBuffList(Iterable<? extends ServerBuffOuterClass.ServerBuff> values) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.serverBuffList_);
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearServerBuffList() {
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffList_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.clear();
                }
                return this;
            }

            public Builder removeServerBuffList(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.remove(index);
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.remove(index);
                }
                return this;
            }

            public ServerBuffOuterClass.ServerBuff.Builder getServerBuffListBuilder(int index) {
                return getServerBuffListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.get(index);
                }
                return this.serverBuffListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList() {
                if (this.serverBuffListBuilder_ != null) {
                    return this.serverBuffListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.serverBuffList_);
            }

            public ServerBuffOuterClass.ServerBuff.Builder addServerBuffListBuilder() {
                return getServerBuffListFieldBuilder().addBuilder(ServerBuffOuterClass.ServerBuff.getDefaultInstance());
            }

            public ServerBuffOuterClass.ServerBuff.Builder addServerBuffListBuilder(int index) {
                return getServerBuffListFieldBuilder().addBuilder(index, ServerBuffOuterClass.ServerBuff.getDefaultInstance());
            }

            public List<ServerBuffOuterClass.ServerBuff.Builder> getServerBuffListBuilderList() {
                return getServerBuffListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ServerBuffOuterClass.ServerBuff, ServerBuffOuterClass.ServerBuff.Builder, ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListFieldBuilder() {
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffListBuilder_ = new RepeatedFieldBuilderV3<>(this.serverBuffList_, (this.bitField0_ & 64) != 0, getParentForChildren(), isClean());
                    this.serverBuffList_ = null;
                }
                return this.serverBuffListBuilder_;
            }

            private void ensureTeamResonanceListIsMutable() {
                if ((this.bitField0_ & 128) == 0) {
                    this.teamResonanceList_ = SceneAvatarInfo.mutableCopy(this.teamResonanceList_);
                    this.bitField0_ |= 128;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public List<Integer> getTeamResonanceListList() {
                return (this.bitField0_ & 128) != 0 ? Collections.unmodifiableList(this.teamResonanceList_) : this.teamResonanceList_;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public int getTeamResonanceListCount() {
                return this.teamResonanceList_.size();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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
                this.teamResonanceList_ = SceneAvatarInfo.emptyIntList();
                this.bitField0_ &= -129;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public boolean hasCurVehicleInfo() {
                return (this.curVehicleInfoBuilder_ == null && this.curVehicleInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public CurVehicleInfoOuterClass.CurVehicleInfo getCurVehicleInfo() {
                if (this.curVehicleInfoBuilder_ == null) {
                    return this.curVehicleInfo_ == null ? CurVehicleInfoOuterClass.CurVehicleInfo.getDefaultInstance() : this.curVehicleInfo_;
                }
                return this.curVehicleInfoBuilder_.getMessage();
            }

            public Builder setCurVehicleInfo(CurVehicleInfoOuterClass.CurVehicleInfo value) {
                if (this.curVehicleInfoBuilder_ != null) {
                    this.curVehicleInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.curVehicleInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCurVehicleInfo(CurVehicleInfoOuterClass.CurVehicleInfo.Builder builderForValue) {
                if (this.curVehicleInfoBuilder_ == null) {
                    this.curVehicleInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.curVehicleInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCurVehicleInfo(CurVehicleInfoOuterClass.CurVehicleInfo value) {
                if (this.curVehicleInfoBuilder_ == null) {
                    if (this.curVehicleInfo_ != null) {
                        this.curVehicleInfo_ = CurVehicleInfoOuterClass.CurVehicleInfo.newBuilder(this.curVehicleInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.curVehicleInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.curVehicleInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCurVehicleInfo() {
                if (this.curVehicleInfoBuilder_ == null) {
                    this.curVehicleInfo_ = null;
                    onChanged();
                } else {
                    this.curVehicleInfo_ = null;
                    this.curVehicleInfoBuilder_ = null;
                }
                return this;
            }

            public CurVehicleInfoOuterClass.CurVehicleInfo.Builder getCurVehicleInfoBuilder() {
                onChanged();
                return getCurVehicleInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public CurVehicleInfoOuterClass.CurVehicleInfoOrBuilder getCurVehicleInfoOrBuilder() {
                if (this.curVehicleInfoBuilder_ != null) {
                    return this.curVehicleInfoBuilder_.getMessageOrBuilder();
                }
                return this.curVehicleInfo_ == null ? CurVehicleInfoOuterClass.CurVehicleInfo.getDefaultInstance() : this.curVehicleInfo_;
            }

            private SingleFieldBuilderV3<CurVehicleInfoOuterClass.CurVehicleInfo, CurVehicleInfoOuterClass.CurVehicleInfo.Builder, CurVehicleInfoOuterClass.CurVehicleInfoOrBuilder> getCurVehicleInfoFieldBuilder() {
                if (this.curVehicleInfoBuilder_ == null) {
                    this.curVehicleInfoBuilder_ = new SingleFieldBuilderV3<>(getCurVehicleInfo(), getParentForChildren(), isClean());
                    this.curVehicleInfo_ = null;
                }
                return this.curVehicleInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
            public boolean hasExcelInfo() {
                return (this.excelInfoBuilder_ == null && this.excelInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder
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

        public static SceneAvatarInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneAvatarInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneAvatarInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneAvatarInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SceneWeaponInfoOuterClass.getDescriptor();
        CurVehicleInfoOuterClass.getDescriptor();
        AvatarExcelInfoOuterClass.getDescriptor();
        SceneReliquaryInfoOuterClass.getDescriptor();
        ServerBuffOuterClass.getDescriptor();
    }
}
