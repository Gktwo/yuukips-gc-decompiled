package emu.grasscutter.command.commands;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Command(label = "enka", permission = "player.enka", usage = {"/enka <uid>"}, aliases = {"copy"}, ratelimit = 300)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnkaCommand.class */
public class EnkaCommand implements CommandHandler {
    /*  JADX ERROR: Dependency scan failed at insn: 0x0037: INVOKE_CUSTOM r-7
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0043: INVOKE_CUSTOM r-6
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x05CD: INVOKE_CUSTOM r-101
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
    /*  JADX ERROR: Failed to decode insn: 0x0037: INVOKE_CUSTOM r0, method: emu.grasscutter.command.commands.EnkaCommand.execute(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, java.util.List<java.lang.String>):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, https://enka.shinshin.moe/u//__data.json]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, https://enka.shinshin.moe/u//__data.json]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0043: INVOKE_CUSTOM r1, method: emu.grasscutter.command.commands.EnkaCommand.execute(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, java.util.List<java.lang.String>):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Start Enka ()]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Start Enka ()]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x05CD: INVOKE_CUSTOM r1, method: emu.grasscutter.command.commands.EnkaCommand.execute(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, java.util.List<java.lang.String>):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Error Enka (): ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Error Enka (): ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(emu.grasscutter.game.player.Player r9, emu.grasscutter.game.player.Player r10, java.util.List<java.lang.String> r11) {
        /*
        // Method dump skipped, instructions count: 1496
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.command.commands.EnkaCommand.execute(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, java.util.List):void");
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnkaCommand$AvatarInfoListItem.class */
    public class AvatarInfoListItem {
        @SerializedName("costumeId")
        private Integer costumeId;
        @SerializedName("avatarId")
        private Integer avatarId;
        @SerializedName("equipList")
        private List<EquipListItem> equipList;
        @SerializedName("talentIdList")
        private List<Integer> talentIdList;
        @SerializedName("skillLevelMap")
        private HashMap<String, Integer> skillLevelMap;
        @SerializedName("fetterInfo")
        private FetterInfo fetterInfo;
        @SerializedName("skillDepotId")
        private Double skillDepotId;
        @SerializedName("inherentProudSkillList")
        private List<Double> inherentProudSkillList;

        public AvatarInfoListItem() {
        }

        public Integer getCostumeId() {
            return this.costumeId;
        }

        public int getAvatarId() {
            return this.avatarId.intValue();
        }

        public List<EquipListItem> getEquipList() {
            return this.equipList;
        }

        public List<Integer> getTalentIdList() {
            return this.talentIdList;
        }

        public HashMap<String, Integer> getSkillLevelMap() {
            return this.skillLevelMap;
        }

        public FetterInfo getFetterInfo() {
            return this.fetterInfo;
        }

        public Double getSkillDepotId() {
            return this.skillDepotId;
        }

        public List<Double> getInherentProudSkillList() {
            return this.inherentProudSkillList;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnkaCommand$EquipListItem.class */
    public class EquipListItem {
        @SerializedName("itemId")
        private Integer itemId;
        @SerializedName("weapon")
        private Weapon weapon;
        @SerializedName("flat")
        private Flat flat;
        @SerializedName("reliquary")
        private Reliquary reliquary;

        public EquipListItem() {
        }

        public int getItemId() {
            return this.itemId.intValue();
        }

        public Weapon getWeapon() {
            return this.weapon;
        }

        public Flat getFlat() {
            return this.flat;
        }

        public Reliquary getReliquary() {
            return this.reliquary;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnkaCommand$FetterInfo.class */
    public class FetterInfo {
        @SerializedName("expLevel")
        private Double expLevel;

        public FetterInfo() {
        }

        public Double getExpLevel() {
            return this.expLevel;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnkaCommand$Flat.class */
    public class Flat {
        @SerializedName("itemType")
        private String itemType;
        @SerializedName("nameTextMapHash")
        private String nameTextMapHash;
        @SerializedName("rankLevel")
        private Double rankLevel;
        @SerializedName("weaponStats")
        private List<WeaponStatsItem> weaponStats;
        @SerializedName("icon")
        private String icon;
        @SerializedName("reliquarySubstats")
        private List<ReliquarySubstatsItem> reliquarySubstats;
        @SerializedName("equipType")
        private String equipType;
        @SerializedName("setNameTextMapHash")
        private String setNameTextMapHash;
        @SerializedName("reliquaryMainstat")
        private ReliquaryMainstat reliquaryMainstat;

        public Flat() {
        }

        public String getItemType() {
            return this.itemType;
        }

        public String getNameTextMapHash() {
            return this.nameTextMapHash;
        }

        public Double getRankLevel() {
            return this.rankLevel;
        }

        public List<WeaponStatsItem> getWeaponStats() {
            return this.weaponStats;
        }

        public String getIcon() {
            return this.icon;
        }

        public List<ReliquarySubstatsItem> getReliquarySubstats() {
            return this.reliquarySubstats;
        }

        public String getEquipType() {
            return this.equipType;
        }

        public String getSetNameTextMapHash() {
            return this.setNameTextMapHash;
        }

        public ReliquaryMainstat getReliquaryMainstat() {
            return this.reliquaryMainstat;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnkaCommand$PlayerInfo.class */
    public class PlayerInfo {
        @SerializedName("profilePicture")
        private ProfilePicture profilePicture;
        @SerializedName("level")
        private Double level;
        @SerializedName("signature")
        private String signature;
        @SerializedName("nameCardId")
        private Double nameCardId;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("towerFloorIndex")
        private Double towerFloorIndex;
        @SerializedName("towerLevelIndex")
        private Double towerLevelIndex;
        @SerializedName("worldLevel")
        private Double worldLevel;
        @SerializedName("finishAchievementNum")
        private Double finishAchievementNum;
        @SerializedName("showAvatarInfoList")
        private List<ShowAvatarInfoListItem> showAvatarInfoList;

        public PlayerInfo() {
        }

        public ProfilePicture getProfilePicture() {
            return this.profilePicture;
        }

        public Double getLevel() {
            return this.level;
        }

        public String getSignature() {
            return this.signature;
        }

        public Double getNameCardId() {
            return this.nameCardId;
        }

        public String getNickname() {
            return this.nickname;
        }

        public Double getTowerFloorIndex() {
            return this.towerFloorIndex;
        }

        public Double getTowerLevelIndex() {
            return this.towerLevelIndex;
        }

        public Double getWorldLevel() {
            return this.worldLevel;
        }

        public Double getFinishAchievementNum() {
            return this.finishAchievementNum;
        }

        public List<ShowAvatarInfoListItem> getShowAvatarInfoList() {
            return this.showAvatarInfoList;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnkaCommand$ProfilePicture.class */
    public class ProfilePicture {
        @SerializedName("avatarId")
        private Double avatarId;

        public ProfilePicture() {
        }

        public Double getAvatarId() {
            return this.avatarId;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnkaCommand$Reliquary.class */
    public class Reliquary {
        @SerializedName("level")
        private Integer level;
        @SerializedName("mainPropId")
        private Integer mainPropId;
        @SerializedName("appendPropIdList")
        private List<Integer> appendPropIdList;

        public Reliquary() {
        }

        public int getLevel() {
            return this.level.intValue();
        }

        public int getMainPropId() {
            return this.mainPropId.intValue();
        }

        public Collection<? extends Integer> getAppendPropIdList() {
            return this.appendPropIdList;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnkaCommand$ReliquaryMainstat.class */
    public class ReliquaryMainstat {
        @SerializedName("statValue")
        private Double statValue;
        @SerializedName("mainPropId")
        private String mainPropId;

        public ReliquaryMainstat() {
        }

        public Double getStatValue() {
            return this.statValue;
        }

        public String getMainPropId() {
            return this.mainPropId;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnkaCommand$ReliquarySubstatsItem.class */
    public class ReliquarySubstatsItem {
        @SerializedName("statValue")
        private Double statValue;
        @SerializedName("appendPropId")
        private String appendPropId;

        public ReliquarySubstatsItem() {
        }

        public Double getStatValue() {
            return this.statValue;
        }

        public String getAppendPropId() {
            return this.appendPropId;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnkaCommand$Response.class */
    public class Response {
        @SerializedName("playerInfo")
        private PlayerInfo playerInfo;
        @SerializedName("avatarInfoList")
        private List<AvatarInfoListItem> avatarInfoList;
        @SerializedName("ttl")
        private Double ttl;

        public Response() {
        }

        public PlayerInfo getPlayerInfo() {
            return this.playerInfo;
        }

        public List<AvatarInfoListItem> getAvatarInfoList() {
            return this.avatarInfoList;
        }

        public Double getTtl() {
            return this.ttl;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnkaCommand$ShowAvatarInfoListItem.class */
    public class ShowAvatarInfoListItem {
        @SerializedName("costumeId")
        private Integer costumeId;
        @SerializedName("avatarId")
        private Integer avatarId;
        @SerializedName("level")
        private Integer level;

        public ShowAvatarInfoListItem() {
        }

        public Integer getCostumeId() {
            return this.costumeId;
        }

        public Integer getAvatarId() {
            return this.avatarId;
        }

        public Integer getLevel() {
            return this.level;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnkaCommand$Weapon.class */
    public class Weapon {
        @SerializedName("level")
        private Integer level;
        @SerializedName("affixMap")
        private HashMap<String, Integer> affixMap;
        @SerializedName("promoteLevel")
        private Integer promoteLevel;

        public Weapon() {
        }

        public int getLevel() {
            return this.level.intValue();
        }

        public HashMap<String, Integer> getAffixMap() {
            return this.affixMap;
        }

        public int getPromoteLevel() {
            if (this.promoteLevel == null) {
                this.promoteLevel = 1;
            }
            return this.promoteLevel.intValue();
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnkaCommand$WeaponStatsItem.class */
    public class WeaponStatsItem {
        @SerializedName("statValue")
        private Double statValue;
        @SerializedName("appendPropId")
        private String appendPropId;

        public WeaponStatsItem() {
        }

        public Double getStatValue() {
            return this.statValue;
        }

        public String getAppendPropId() {
            return this.appendPropId;
        }
    }
}
