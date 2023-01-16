package emu.grasscutter.game.ability;

import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.FightProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/game/ability/HealAbilityManager.class */
public class HealAbilityManager {
    ArrayList<HealDataAvatar> healDataAvatarList = new ArrayList<>();
    private Player player;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0025: INVOKE_CUSTOM r-1, r0, r1
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
    /*  JADX ERROR: Failed to decode insn: 0x0025: INVOKE_CUSTOM r1, r2, r3, method: emu.grasscutter.game.ability.HealAbilityManager.healHandler(emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass$AbilityInvokeEntry):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/net/proto/AbilityInvokeArgumentOuterClass$AbilityInvokeArgument;, I, Ljava/lang/String;)Ljava/lang/String;}, Error:  (): ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/net/proto/AbilityInvokeArgumentOuterClass$AbilityInvokeArgument;, I, Ljava/lang/String;)Ljava/lang/String;}, Error:  (): ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void healHandler(emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntry r6) throws java.lang.Exception {
        /*
            r5 = this;
            r0 = r6
            if (r0 != 0) goto L_0x0005
            return
            r0 = 0
            r7 = r0
            r0 = r6
            com.google.protobuf.ByteString r0 = r0.getAbilityData()
            emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass$AbilityMetaModifierChange r0 = emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChange.parseFrom(r0)
            r7 = r0
            goto L_0x0032
            r8 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r6
            emu.grasscutter.net.proto.AbilityInvokeArgumentOuterClass$AbilityInvokeArgument r1 = r1.getArgumentType()
            r2 = r6
            int r2 = r2.getArgumentTypeValue()
            r3 = r6
            byte[] r3 = r3.toByteArray()
            java.lang.String r3 = emu.grasscutter.utils.Utils.bytesToHex(r3)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/net/proto/AbilityInvokeArgumentOuterClass$AbilityInvokeArgument;, I, Ljava/lang/String;)Ljava/lang/String;}, Error:  (): ]}
            r0.debug(r1)
            goto L_0x0032
            r9 = move-exception
            r0 = r7
            if (r0 != 0) goto L_0x0037
            return
            r0 = r5
            emu.grasscutter.game.player.Player r0 = r0.player
            if (r0 == 0) goto L_0x0048
            r0 = r5
            emu.grasscutter.game.player.Player r0 = r0.player
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            if (r0 != 0) goto L_0x0049
            return
            r0 = r5
            emu.grasscutter.game.player.Player r0 = r0.player
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            r1 = r7
            int r1 = r1.getApplyEntityId()
            emu.grasscutter.game.entity.GameEntity r0 = r0.getEntityById(r1)
            r8 = r0
            java.lang.String r0 = ""
            r9 = r0
            r0 = r7
            emu.grasscutter.net.proto.AbilityStringOuterClass$AbilityString r0 = r0.getParentAbilityName()
            if (r0 == 0) goto L_0x006c
            r0 = r7
            emu.grasscutter.net.proto.AbilityStringOuterClass$AbilityString r0 = r0.getParentAbilityName()
            java.lang.String r0 = r0.getStr()
            r9 = r0
            r0 = r8
            if (r0 == 0) goto L_0x0077
            r0 = r5
            r1 = r8
            r2 = r9
            r0.checkAndHeal(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.ability.HealAbilityManager.healHandler(emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass$AbilityInvokeEntry):void");
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:emu/grasscutter/game/ability/HealAbilityManager$HealData.class */
    public class HealData {
        public boolean isString;
        public String abilityType;
        public String sRatio;
        public String sBase;
        public float fRatio;
        public float fBase;
        public boolean healAll;

        public HealData(String _abilityType, String _sRatio, String _sBase, boolean _healAll) {
            this.isString = true;
            this.abilityType = "";
            this.sRatio = "";
            this.sBase = "";
            this.fRatio = 0.0f;
            this.fBase = 0.0f;
            this.healAll = false;
            this.abilityType = _abilityType;
            this.isString = true;
            this.sRatio = _sRatio;
            this.sBase = _sBase;
            this.healAll = _healAll;
        }

        public HealData(String _abilityType, String _sRatio, float _fRatio, float _fBase, boolean _healAll) {
            this.isString = true;
            this.abilityType = "";
            this.sRatio = "";
            this.sBase = "";
            this.fRatio = 0.0f;
            this.fBase = 0.0f;
            this.healAll = false;
            this.abilityType = _abilityType;
            this.isString = false;
            this.sRatio = _sRatio;
            this.fRatio = _fRatio;
            this.fBase = _fBase;
            this.healAll = _healAll;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/ability/HealAbilityManager$HealDataAvatar.class */
    private class HealDataAvatar {
        public int avatarId;
        public String avatarName;
        public int fightPropertyType;
        public ArrayList<HealData> healDataList = new ArrayList<>();

        public HealDataAvatar(int _avatarId, String _avatarName, int _fightPropertyType) {
            this.avatarId = 0;
            this.avatarName = "";
            this.fightPropertyType = 0;
            this.avatarId = _avatarId;
            this.avatarName = _avatarName;
            this.fightPropertyType = _fightPropertyType;
        }

        public HealDataAvatar addHealData(String abilityType, String sRatio, String sBase, boolean healAll) {
            this.healDataList.add(new HealData(abilityType, sRatio, sBase, healAll));
            return this;
        }

        public HealDataAvatar addHealData(String abilityType, String sRatio, float fRatio, float fBase, boolean healAll) {
            this.healDataList.add(new HealData(abilityType, sRatio, fRatio, fBase, healAll));
            return this;
        }
    }

    public HealAbilityManager(Player player) {
        this.player = player;
        this.healDataAvatarList.add(new HealDataAvatar(10000054, "Kokomi", 0).addHealData("E", "ElementalArt_Heal_MaxHP_Base_Percentage", "ElementalArt_Heal_Base_Amount", false).addHealData("Q", "Avatar_Kokomi_ElementalBurst_Heal", 0.0172f, 212.0f, false));
        this.healDataAvatarList.add(new HealDataAvatar(10000003, "Qin", 1).addHealData("Q", "Heal", "BurstHealConst", true));
        this.healDataAvatarList.add(new HealDataAvatar(10000034, "Noel", 2).addHealData("E", "OnAttack_HealthRate", 0.452f, 282.0f, true));
        this.healDataAvatarList.add(new HealDataAvatar(10000032, "Bennett", 0).addHealData("Q", "HealMaxHpRatio", "HealConst", false));
        this.healDataAvatarList.add(new HealDataAvatar(10000039, "Diona", 0).addHealData("Q", "HealHPRatio", "HealHP_Const", false));
        this.healDataAvatarList.add(new HealDataAvatar(10000053, "Sayu", 1).addHealData("Q", "Constellation_6_Damage", "Heal_BaseAmount", true).addHealData("Q", "Heal_AttackRatio", "Constellation_6_Heal", true));
        this.healDataAvatarList.add(new HealDataAvatar(10000014, "Barbara", 0).addHealData("E", "HealHPOnAdded", "HealHPOnAdded_Const", true).addHealData("E", "HealHP_OnHittingOthers", "HealHP_Const_OnHittingOthers", true).addHealData("Q", "Avatar_Barbara_IdolHeal", 0.374f, 4660.0f, true));
        this.healDataAvatarList.add(new HealDataAvatar(10000065, "Shinobu", 0).addHealData("E", "ElementalArt_Heal_MaxHP_Percentage", 0.064f, 795.0f, false));
        this.healDataAvatarList.add(new HealDataAvatar(10000035, "Qiqi", 1).addHealData("E", "HealHP_OnHittingOthers", "HealHP_Const_OnHittingOthers", true).addHealData("E", "ElementalArt_HealHp_Ratio", "ElementalArt_HealHp_Const", true).addHealData("Q", "Avatar_Qiqi_ElementalBurst_ApplyModifier", 0.0191f, 1588.0f, false));
        this.healDataAvatarList.add(new HealDataAvatar(10000046, "Hutao", 0).addHealData("Q", "Avatar_Hutao_VermilionBite_BakeMesh", 0.1166f, 0.0f, false));
    }

    public Player getPlayer() {
        return this.player;
    }

    public void checkAndHeal(GameEntity sourceEntity, String modifierString) {
        float healAmount = 0.0f;
        float ratio = 0.0f;
        float base = 0.0f;
        Map<String, Float> map = sourceEntity.getMetaOverrideMap();
        for (int i = 0; i < this.healDataAvatarList.size(); i++) {
            HealDataAvatar healDataAvatar = this.healDataAvatarList.get(i);
            if (modifierString.contains(healDataAvatar.avatarName)) {
                int fightPropertyType = healDataAvatar.fightPropertyType;
                ArrayList<HealData> healDataList = healDataAvatar.healDataList;
                for (int j = 0; j < healDataList.size(); j++) {
                    HealData healData = healDataList.get(j);
                    if (map.containsKey(healData.sRatio) || modifierString.equals(healData.sRatio)) {
                        if (healData.isString) {
                            ratio = map.get(healData.sRatio).floatValue();
                            base = map.get(healData.sBase).floatValue();
                        } else {
                            ratio = healData.fRatio;
                            base = healData.fBase;
                        }
                    }
                    List<EntityAvatar> activeTeam = this.player.getTeamManager().getActiveTeam();
                    List<EntityAvatar> needHealAvatars = new ArrayList<>();
                    EntityAvatar currentAvatar = activeTeam.get(this.player.getTeamManager().getCurrentCharacterIndex());
                    if (healData.healAll) {
                        needHealAvatars = activeTeam;
                    } else {
                        needHealAvatars.add(currentAvatar);
                    }
                    EntityAvatar healActionAvatar = null;
                    int k = 0;
                    while (true) {
                        if (k < activeTeam.size()) {
                            EntityAvatar avatar = activeTeam.get(k);
                            if (avatar.getAvatar().getAvatarId() == healDataAvatar.avatarId) {
                                healActionAvatar = avatar;
                            } else {
                                k++;
                            }
                        }
                    }
                    if (healActionAvatar != null) {
                        float maxHP = healActionAvatar.getFightProperty(FightProperty.FIGHT_PROP_MAX_HP);
                        float curHP = healActionAvatar.getFightProperty(FightProperty.FIGHT_PROP_CUR_HP);
                        float curAttack = healActionAvatar.getFightProperty(FightProperty.FIGHT_PROP_CUR_ATTACK);
                        float curDefense = healActionAvatar.getFightProperty(FightProperty.FIGHT_PROP_CUR_DEFENSE);
                        if (healDataAvatar.avatarName.equals("Hutao") && ((double) curHP) <= ((double) maxHP) * 0.5d && ratio != 0.0f) {
                            ratio = 0.1555f;
                        }
                        switch (fightPropertyType) {
                            case 0:
                                healAmount = (ratio * maxHP) + base;
                                break;
                            case 1:
                                healAmount = (ratio * curAttack) + base;
                                break;
                            case 2:
                                healAmount = (ratio * curDefense) + base;
                                break;
                        }
                    }
                    for (int k2 = 0; k2 < needHealAvatars.size(); k2++) {
                        needHealAvatars.get(k2).heal(healAmount);
                    }
                }
                return;
            }
        }
    }
}
