package emu.grasscutter.game.systems;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.excels.AvatarPromoteData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.data.excels.ProudSkillData;
import emu.grasscutter.data.excels.WeaponPromoteData;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.inventory.Inventory;
import emu.grasscutter.game.inventory.ItemType;
import emu.grasscutter.game.inventory.MaterialType;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction;
import emu.grasscutter.game.props.ItemUseAction.ItemUseAddExp;
import emu.grasscutter.game.props.ItemUseAction.ItemUseAddReliquaryExp;
import emu.grasscutter.game.props.ItemUseAction.ItemUseAddWeaponExp;
import emu.grasscutter.game.props.ItemUseAction.UseItemParams;
import emu.grasscutter.game.props.ItemUseOp;
import emu.grasscutter.game.props.ItemUseTarget;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.net.proto.MaterialInfoOuterClass;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.packet.send.PacketAvatarFetterDataNotify;
import emu.grasscutter.server.packet.send.PacketAvatarPromoteRsp;
import emu.grasscutter.server.packet.send.PacketAvatarPropNotify;
import emu.grasscutter.server.packet.send.PacketAvatarUpgradeRsp;
import emu.grasscutter.server.packet.send.PacketDestroyMaterialRsp;
import emu.grasscutter.server.packet.send.PacketProudSkillChangeNotify;
import emu.grasscutter.server.packet.send.PacketReliquaryUpgradeRsp;
import emu.grasscutter.server.packet.send.PacketSetEquipLockStateRsp;
import emu.grasscutter.server.packet.send.PacketStoreItemChangeNotify;
import emu.grasscutter.server.packet.send.PacketWeaponAwakenRsp;
import emu.grasscutter.server.packet.send.PacketWeaponPromoteRsp;
import emu.grasscutter.server.packet.send.PacketWeaponUpgradeRsp;
import emu.grasscutter.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.ints.Int2FloatArrayMap;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;
import p014it.unimi.dsi.fastutil.ints.Int2IntArrayMap;
import p014it.unimi.dsi.fastutil.ints.Int2IntMap;
import p014it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import p014it.unimi.dsi.fastutil.ints.Int2IntRBTreeMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* loaded from: grasscutter.jar:emu/grasscutter/game/systems/InventorySystem.class */
public class InventorySystem extends BaseGameSystem {
    private static final Int2IntMap weaponRefundMaterials = new Int2IntArrayMap();

    /*  JADX ERROR: Dependency scan failed at insn: 0x00F6: INVOKE_CUSTOM r-6, r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x00F6: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.systems.InventorySystem.useItemDirect(emu.grasscutter.data.excels.ItemData, emu.grasscutter.game.props.ItemUseAction.UseItemParams):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Error use Item:  | size ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Error use Item:  | size ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public synchronized boolean useItemDirect(emu.grasscutter.data.excels.ItemData r7, emu.grasscutter.game.props.ItemUseAction.UseItemParams r8) {
        /*
        // Method dump skipped, instructions count: 319
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.systems.InventorySystem.useItemDirect(emu.grasscutter.data.excels.ItemData, emu.grasscutter.game.props.ItemUseAction.UseItemParams):boolean");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x006F: INVOKE_CUSTOM r-3, r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x006F: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.systems.InventorySystem.checkPlayerAvatarConstellationLevel(emu.grasscutter.game.player.Player, int):int
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Attempted to check constellation level for UID's avatar  but avatar has no skillDepot!]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Attempted to check constellation level for UID's avatar  but avatar has no skillDepot!]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public static synchronized int checkPlayerAvatarConstellationLevel(emu.grasscutter.game.player.Player r4, int r5) {
        /*
            r0 = 0
            r6 = r0
            it.unimi.dsi.fastutil.ints.Int2ObjectMap r0 = emu.grasscutter.data.GameData.getAvatarDataMap()
            r1 = r5
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0013
            r0 = r5
            r6 = r0
            goto L_0x0040
            it.unimi.dsi.fastutil.ints.Int2ObjectMap r0 = emu.grasscutter.data.GameData.getItemDataMap()
            r1 = r5
            java.lang.Object r0 = r0.get(r1)
            emu.grasscutter.data.excels.ItemData r0 = (emu.grasscutter.data.excels.ItemData) r0
            java.util.Optional r0 = java.util.Optional.ofNullable(r0)
            int r1 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$checkPlayerAvatarConstellationLevel$17(v0);
            }
            java.util.Optional r0 = r0.map(r1)
            int r1 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$checkPlayerAvatarConstellationLevel$20(v0);
            }
            java.util.Optional r0 = r0.flatMap(r1)
            r1 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.orElse(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r6 = r0
            r0 = r6
            if (r0 != 0) goto L_0x0047
            r0 = -2
            return r0
            r0 = r4
            emu.grasscutter.game.avatar.AvatarStorage r0 = r0.getAvatars()
            r1 = r6
            emu.grasscutter.game.avatar.Avatar r0 = r0.getAvatarById(r1)
            r7 = r0
            r0 = r7
            if (r0 != 0) goto L_0x0056
            r0 = -1
            return r0
            r0 = r7
            int r0 = r0.getCoreProudSkillLevel()
            r8 = r0
            r0 = r7
            emu.grasscutter.data.excels.AvatarSkillDepotData r0 = r0.getSkillDepot()
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L_0x0079
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r4
            int r1 = r1.getUid()
            r2 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Attempted to check constellation level for UID's avatar  but avatar has no skillDepot!]}
            r0.error(r1)
            r0 = 0
            return r0
            r0 = r9
            int r0 = r0.getTalentCostItemId()
            r10 = r0
            r0 = r4
            emu.grasscutter.game.inventory.Inventory r0 = r0.getInventory()
            emu.grasscutter.game.inventory.ItemType r1 = emu.grasscutter.game.inventory.ItemType.ITEM_MATERIAL
            emu.grasscutter.game.inventory.InventoryTab r0 = r0.getInventoryTab(r1)
            r1 = r10
            emu.grasscutter.game.inventory.GameItem r0 = r0.getItemById(r1)
            r11 = r0
            r0 = r8
            r1 = r11
            java.util.Optional r1 = java.util.Optional.ofNullable(r1)
            int r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.getCount();
            }
            java.util.Optional r1 = r1.map(r2)
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r1 = r1.orElse(r2)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            int r0 = r0 + r1
            r8 = r0
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.systems.InventorySystem.checkPlayerAvatarConstellationLevel(emu.grasscutter.game.player.Player, int):int");
    }

    public InventorySystem(GameServer server) {
        super(server);
        Int2IntRBTreeMap temp = new Int2IntRBTreeMap(Collections.reverseOrder());
        GameData.getItemDataMap().forEach(id, data -> {
            List<C1378ItemUseAction> actions;
            if (!(data == null || data.getMaterialType() != MaterialType.MATERIAL_WEAPON_EXP_STONE || (actions = data.getItemUseActions()) == null)) {
                for (C1378ItemUseAction action : actions) {
                    if (action.getItemUseOp() == ItemUseOp.ITEM_USE_ADD_WEAPON_EXP) {
                        temp.putIfAbsent(((ItemUseAddWeaponExp) action).getExp(), id.intValue());
                        return;
                    }
                }
            }
        });
        temp.forEach(exp, id -> {
            weaponRefundMaterials.putIfAbsent(id.intValue(), exp.intValue());
        });
    }

    public void lockEquip(Player player, long targetEquipGuid, boolean isLocked) {
        GameItem equip = player.getInventory().getItemByGuid(targetEquipGuid);
        if (equip != null && equip.getItemData().isEquip()) {
            equip.setLocked(isLocked);
            equip.save();
            player.sendPacket(new PacketStoreItemChangeNotify(equip));
            player.sendPacket(new PacketSetEquipLockStateRsp(equip));
        }
    }

    public void upgradeRelic(Player player, long targetGuid, List<Long> foodRelicList, List<ItemParamOuterClass.ItemParam> list) {
        Avatar avatar;
        List<C1378ItemUseAction> actions;
        GameItem relic = player.getInventory().getItemByGuid(targetGuid);
        if (relic != null && relic.getItemType() == ItemType.ITEM_RELIQUARY) {
            int moraCost = 0;
            int expGain = 0;
            List<GameItem> foodRelics = new ArrayList<>();
            for (Long l : foodRelicList) {
                GameItem food = player.getInventory().getItemByGuid(l.longValue());
                if (food != null && food.isDestroyable()) {
                    int exp = food.getItemData().getBaseConvExp();
                    moraCost += exp;
                    expGain += exp;
                    if (food.getTotalExp() > 0) {
                        expGain += (food.getTotalExp() * 4) / 5;
                    }
                    foodRelics.add(food);
                }
            }
            List<ItemParamData> payList = new ArrayList<>();
            for (ItemParamOuterClass.ItemParam itemParam : list) {
                int amount = itemParam.getCount();
                int gain = 0;
                ItemData data = GameData.getItemDataMap().get(itemParam.getItemId());
                if (!(data == null || (actions = data.getItemUseActions()) == null)) {
                    for (C1378ItemUseAction action : actions) {
                        if (action.getItemUseOp() == ItemUseOp.ITEM_USE_ADD_RELIQUARY_EXP) {
                            gain += ((ItemUseAddReliquaryExp) action).getExp();
                        }
                    }
                }
                int gain2 = gain * amount;
                expGain += gain2;
                moraCost += gain2;
                payList.add(new ItemParamData(itemParam.getItemId(), itemParam.getCount()));
            }
            if (expGain > 0) {
                payList.add(new ItemParamData(202, moraCost));
                if (player.getInventory().payItems(payList)) {
                    player.getInventory().removeItems(foodRelics);
                    int rate = 1;
                    int boost = Utils.randomRange(1, 100);
                    if (boost == 100) {
                        rate = 5;
                    } else if (boost <= 9) {
                        rate = 2;
                    }
                    int expGain2 = expGain * rate;
                    int level = relic.getLevel();
                    int exp2 = relic.getExp();
                    int totalExp = relic.getTotalExp();
                    int reqExp = GameData.getRelicExpRequired(relic.getItemData().getRankLevel(), level);
                    int upgrades = 0;
                    List<Integer> oldAppendPropIdList = new ArrayList<>(relic.getAppendPropIdList());
                    while (expGain2 > 0 && reqExp > 0 && level < relic.getItemData().getMaxLevel()) {
                        int toGain = Math.min(expGain2, reqExp - exp2);
                        exp2 += toGain;
                        totalExp += toGain;
                        expGain2 -= toGain;
                        if (exp2 >= reqExp) {
                            exp2 = 0;
                            level++;
                            if (relic.getItemData().getAddPropLevelSet() != null && relic.getItemData().getAddPropLevelSet().contains(level)) {
                                upgrades++;
                            }
                            reqExp = GameData.getRelicExpRequired(relic.getItemData().getRankLevel(), level);
                        }
                    }
                    relic.addAppendProps(upgrades);
                    relic.setLevel(level);
                    relic.setExp(exp2);
                    relic.setTotalExp(totalExp);
                    relic.save();
                    if (level != level) {
                        if (relic.getEquipCharacter() > 0) {
                            avatar = player.getAvatars().getAvatarById(relic.getEquipCharacter());
                        } else {
                            avatar = null;
                        }
                        if (avatar != null) {
                            avatar.recalcStats();
                        }
                    }
                    player.sendPacket(new PacketStoreItemChangeNotify(relic));
                    player.sendPacket(new PacketReliquaryUpgradeRsp(relic, rate, level, oldAppendPropIdList));
                }
            }
        }
    }

    public List<ItemParamOuterClass.ItemParam> calcWeaponUpgradeReturnItems(Player player, long targetGuid, List<Long> foodWeaponGuidList, List<ItemParamOuterClass.ItemParam> itemParamList) {
        WeaponPromoteData promoteData;
        GameItem weapon = player.getInventory().getItemByGuid(targetGuid);
        if (weapon == null || weapon.getItemType() != ItemType.ITEM_WEAPON || (promoteData = GameData.getWeaponPromoteData(weapon.getItemData().getWeaponPromoteId(), weapon.getPromoteLevel())) == null) {
            return null;
        }
        Stream<Long> stream = foodWeaponGuidList.stream();
        Inventory inventory = player.getInventory();
        Objects.requireNonNull(inventory);
        int expGain = stream.map((v1) -> {
            return r1.getItemByGuid(v1);
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).mapToInt(food -> {
            return food.getItemData().getWeaponBaseExp() + ((food.getTotalExp() * 4) / 5);
        }).sum() + itemParamList.stream().mapToInt(param -> {
            return Stream.ofNullable(GameData.getItemDataMap().get(param.getItemId())).map((v0) -> {
                return v0.getItemUseActions();
            }).filter((v0) -> {
                return Objects.nonNull(v0);
            }).flatMap((v0) -> {
                return v0.stream();
            }).filter(action -> {
                return action.getItemUseOp() == ItemUseOp.ITEM_USE_ADD_WEAPON_EXP;
            }).mapToInt(action -> {
                return ((ItemUseAddWeaponExp) action).getExp();
            }).sum() * param.getCount();
        }).sum();
        int maxLevel = promoteData.getUnlockMaxLevel();
        int level = weapon.getLevel();
        int exp = weapon.getExp();
        int reqExp = GameData.getWeaponExpRequired(weapon.getItemData().getRankLevel(), level);
        while (expGain > 0 && reqExp > 0 && level < maxLevel) {
            int toGain = Math.min(expGain, reqExp - exp);
            exp += toGain;
            expGain -= toGain;
            if (exp >= reqExp) {
                exp = 0;
                level++;
                reqExp = GameData.getWeaponExpRequired(weapon.getItemData().getRankLevel(), level);
            }
        }
        return getLeftoverOres(expGain);
    }

    public void upgradeWeapon(Player player, long targetGuid, List<Long> foodWeaponGuidList, List<ItemParamOuterClass.ItemParam> itemParamList) {
        WeaponPromoteData promoteData;
        Avatar avatar;
        List<C1378ItemUseAction> actions;
        GameItem weapon = player.getInventory().getItemByGuid(targetGuid);
        if (!(weapon == null || weapon.getItemType() != ItemType.ITEM_WEAPON || (promoteData = GameData.getWeaponPromoteData(weapon.getItemData().getWeaponPromoteId(), weapon.getPromoteLevel())) == null)) {
            int expGain = 0;
            int expGainFree = 0;
            List<GameItem> foodWeapons = new ArrayList<>();
            for (Long l : foodWeaponGuidList) {
                GameItem food = player.getInventory().getItemByGuid(l.longValue());
                if (food != null && food.isDestroyable()) {
                    expGain += food.getItemData().getWeaponBaseExp();
                    if (food.getTotalExp() > 0) {
                        expGainFree += (food.getTotalExp() * 4) / 5;
                    }
                    foodWeapons.add(food);
                }
            }
            List<ItemParamData> payList = new ArrayList<>();
            for (ItemParamOuterClass.ItemParam param : itemParamList) {
                int amount = param.getCount();
                ItemData data = GameData.getItemDataMap().get(param.getItemId());
                if (!(data == null || (actions = data.getItemUseActions()) == null)) {
                    for (C1378ItemUseAction action : actions) {
                        if (action.getItemUseOp() == ItemUseOp.ITEM_USE_ADD_WEAPON_EXP) {
                            expGain += ((ItemUseAddWeaponExp) action).getExp() * amount;
                        }
                    }
                }
                payList.add(new ItemParamData(param.getItemId(), amount));
            }
            int moraCost = expGain / 10;
            int expGain2 = expGain + expGainFree;
            if (expGain2 > 0) {
                payList.add(new ItemParamData(202, moraCost));
                if (player.getInventory().payItems(payList)) {
                    player.getInventory().removeItems(foodWeapons);
                    int maxLevel = promoteData.getUnlockMaxLevel();
                    int level = weapon.getLevel();
                    int exp = weapon.getExp();
                    int totalExp = weapon.getTotalExp();
                    int reqExp = GameData.getWeaponExpRequired(weapon.getItemData().getRankLevel(), level);
                    while (expGain2 > 0 && reqExp > 0 && level < maxLevel) {
                        int toGain = Math.min(expGain2, reqExp - exp);
                        exp += toGain;
                        totalExp += toGain;
                        expGain2 -= toGain;
                        if (exp >= reqExp) {
                            exp = 0;
                            level++;
                            reqExp = GameData.getWeaponExpRequired(weapon.getItemData().getRankLevel(), level);
                        }
                    }
                    List<ItemParamOuterClass.ItemParam> leftovers = getLeftoverOres(expGain2);
                    player.getInventory().addItemParams(leftovers);
                    weapon.setLevel(level);
                    weapon.setExp(exp);
                    weapon.setTotalExp(totalExp);
                    weapon.save();
                    if (level != level) {
                        if (weapon.getEquipCharacter() > 0) {
                            avatar = player.getAvatars().getAvatarById(weapon.getEquipCharacter());
                        } else {
                            avatar = null;
                        }
                        if (avatar != null) {
                            avatar.recalcStats();
                        }
                    }
                    player.sendPacket(new PacketStoreItemChangeNotify(weapon));
                    player.sendPacket(new PacketWeaponUpgradeRsp(weapon, level, leftovers));
                }
            }
        }
    }

    private List<ItemParamOuterClass.ItemParam> getLeftoverOres(int leftover) {
        List<ItemParamOuterClass.ItemParam> leftoverOreList = new ArrayList<>(3);
        ObjectIterator<Int2IntMap.Entry> it = weaponRefundMaterials.int2IntEntrySet().iterator();
        while (it.hasNext()) {
            Int2IntMap.Entry e = it.next();
            int exp = e.getIntValue();
            int ores = leftover / exp;
            leftover %= exp;
            if (ores > 0) {
                leftoverOreList.add(ItemParamOuterClass.ItemParam.newBuilder().setItemId(e.getIntKey()).setCount(ores).build());
            }
        }
        return leftoverOreList;
    }

    public void refineWeapon(Player player, long targetGuid, long feedGuid) {
        Avatar avatar;
        GameItem weapon = player.getInventory().getItemByGuid(targetGuid);
        GameItem feed = player.getInventory().getItemByGuid(feedGuid);
        if (weapon != null && feed != null && feed.isDestroyable()) {
            if (weapon.getItemData().getAwakenMaterial() == 0) {
                if (!(weapon.getItemType() == ItemType.ITEM_WEAPON && weapon.getItemId() == feed.getItemId())) {
                    return;
                }
            } else if (!(weapon.getItemType() == ItemType.ITEM_WEAPON && weapon.getItemData().getAwakenMaterial() == feed.getItemId())) {
                return;
            }
            if (weapon.getRefinement() < 4 && weapon.getAffixes() != null && weapon.getAffixes().size() != 0) {
                int oldRefineLevel = weapon.getRefinement();
                int targetRefineLevel = Math.min(oldRefineLevel + feed.getRefinement() + 1, 4);
                try {
                    int moraCost = weapon.getItemData().getAwakenCosts()[weapon.getRefinement()];
                    if (player.getMora() >= moraCost) {
                        player.setMora(player.getMora() - moraCost);
                        player.getInventory().removeItem(feed, 1);
                        weapon.setRefinement(targetRefineLevel);
                        weapon.save();
                        if (weapon.getEquipCharacter() > 0) {
                            avatar = player.getAvatars().getAvatarById(weapon.getEquipCharacter());
                        } else {
                            avatar = null;
                        }
                        if (avatar != null) {
                            avatar.recalcStats();
                        }
                        player.sendPacket(new PacketStoreItemChangeNotify(weapon));
                        player.sendPacket(new PacketWeaponAwakenRsp(avatar, weapon, feed, oldRefineLevel));
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public void promoteWeapon(Player player, long targetGuid) {
        Avatar avatar;
        GameItem weapon = player.getInventory().getItemByGuid(targetGuid);
        if (weapon != null && weapon.getItemType() == ItemType.ITEM_WEAPON) {
            int nextPromoteLevel = weapon.getPromoteLevel() + 1;
            WeaponPromoteData currentPromoteData = GameData.getWeaponPromoteData(weapon.getItemData().getWeaponPromoteId(), weapon.getPromoteLevel());
            WeaponPromoteData nextPromoteData = GameData.getWeaponPromoteData(weapon.getItemData().getWeaponPromoteId(), nextPromoteLevel);
            if (currentPromoteData != null && nextPromoteData != null && weapon.getLevel() == currentPromoteData.getUnlockMaxLevel()) {
                ItemParamData[] costs = nextPromoteData.getCostItems();
                if (nextPromoteData.getCoinCost() > 0) {
                    costs = (ItemParamData[]) Arrays.copyOf(costs, costs.length + 1);
                    costs[costs.length - 1] = new ItemParamData(202, nextPromoteData.getCoinCost());
                }
                if (player.getInventory().payItems(costs)) {
                    int oldPromoteLevel = weapon.getPromoteLevel();
                    weapon.setPromoteLevel(nextPromoteLevel);
                    weapon.save();
                    if (weapon.getEquipCharacter() > 0) {
                        avatar = player.getAvatars().getAvatarById(weapon.getEquipCharacter());
                    } else {
                        avatar = null;
                    }
                    if (avatar != null) {
                        avatar.recalcStats();
                    }
                    player.sendPacket(new PacketStoreItemChangeNotify(weapon));
                    player.sendPacket(new PacketWeaponPromoteRsp(weapon, oldPromoteLevel));
                }
            }
        }
    }

    public void promoteAvatar(Player player, long guid) {
        Avatar avatar = player.getAvatars().getAvatarByGuid(guid);
        if (avatar != null) {
            int nextPromoteLevel = avatar.getPromoteLevel() + 1;
            AvatarPromoteData currentPromoteData = GameData.getAvatarPromoteData(avatar.getAvatarData().getAvatarPromoteId(), avatar.getPromoteLevel());
            AvatarPromoteData nextPromoteData = GameData.getAvatarPromoteData(avatar.getAvatarData().getAvatarPromoteId(), nextPromoteLevel);
            if (currentPromoteData != null && nextPromoteData != null && avatar.getLevel() == currentPromoteData.getUnlockMaxLevel()) {
                ItemParamData[] costs = nextPromoteData.getCostItems();
                if (nextPromoteData.getCoinCost() > 0) {
                    costs = (ItemParamData[]) Arrays.copyOf(costs, costs.length + 1);
                    costs[costs.length - 1] = new ItemParamData(202, nextPromoteData.getCoinCost());
                }
                if (player.getInventory().payItems(costs)) {
                    avatar.setPromoteLevel(nextPromoteLevel);
                    Optional.ofNullable(GameData.getAvatarSkillDepotDataMap().get(avatar.getSkillDepotId())).map((v0) -> {
                        return v0.getInherentProudSkillOpens();
                    }).ifPresent(d -> {
                        IntStream mapToInt = d.stream().filter(openData -> {
                            return openData.getProudSkillGroupId() > 0;
                        }).filter(openData -> {
                            return openData.getNeedAvatarPromoteLevel() == avatar.getPromoteLevel();
                        }).mapToInt(openData -> {
                            return (openData.getProudSkillGroupId() * 100) + 1;
                        });
                        Int2ObjectMap<ProudSkillData> proudSkillDataMap = GameData.getProudSkillDataMap();
                        Objects.requireNonNull(proudSkillDataMap);
                        mapToInt.filter(this::containsKey).forEach(proudSkillId -> {
                            avatar.getProudSkillList().add(Integer.valueOf(proudSkillId));
                            player.sendPacket(new PacketProudSkillChangeNotify(avatar));
                        });
                    });
                    player.sendPacket(new PacketAvatarPropNotify(avatar));
                    player.sendPacket(new PacketAvatarPromoteRsp(avatar));
                    avatar.recalcStats(true);
                    avatar.save();
                }
            }
        }
    }

    public void upgradeAvatar(Player player, long guid, int itemId, int count) {
        AvatarPromoteData promoteData;
        List<C1378ItemUseAction> actions;
        Avatar avatar = player.getAvatars().getAvatarByGuid(guid);
        if (!(avatar == null || (promoteData = GameData.getAvatarPromoteData(avatar.getAvatarData().getAvatarPromoteId(), avatar.getPromoteLevel())) == null)) {
            int expGain = 0;
            ItemData data = GameData.getItemDataMap().get(itemId);
            if (!(data == null || (actions = data.getItemUseActions()) == null)) {
                for (C1378ItemUseAction action : actions) {
                    if (action.getItemUseOp() == ItemUseOp.ITEM_USE_ADD_EXP) {
                        expGain += ((ItemUseAddExp) action).getExp() * count;
                    }
                }
            }
            if (expGain > 0 && player.getInventory().payItems(new ItemParamData[]{new ItemParamData(itemId, count), new ItemParamData(202, expGain / 5)})) {
                upgradeAvatar(player, avatar, promoteData, expGain);
            }
        }
    }

    public void upgradeAvatar(Player player, Avatar avatar, int expGain) {
        AvatarPromoteData promoteData = GameData.getAvatarPromoteData(avatar.getAvatarData().getAvatarPromoteId(), avatar.getPromoteLevel());
        if (promoteData != null) {
            upgradeAvatar(player, avatar, promoteData, expGain);
        }
    }

    public void upgradeAvatar(Player player, Avatar avatar, AvatarPromoteData promoteData, int expGain) {
        int maxLevel = promoteData.getUnlockMaxLevel();
        int level = avatar.getLevel();
        int exp = avatar.getExp();
        int reqExp = GameData.getAvatarLevelExpRequired(level);
        while (expGain > 0 && reqExp > 0 && level < maxLevel) {
            int toGain = Math.min(expGain, reqExp - exp);
            exp += toGain;
            expGain -= toGain;
            if (exp >= reqExp) {
                exp = 0;
                level++;
                reqExp = GameData.getAvatarLevelExpRequired(level);
            }
        }
        Map<Integer, Float> oldPropMap = avatar.getFightProperties();
        if (level != level) {
            oldPropMap = new Int2FloatArrayMap((Int2FloatMap) avatar.getFightProperties());
        }
        avatar.setLevel(level);
        avatar.setExp(exp);
        avatar.recalcStats();
        avatar.save();
        player.sendPacket(new PacketAvatarPropNotify(avatar));
        player.sendPacket(new PacketAvatarUpgradeRsp(avatar, level, oldPropMap));
    }

    public void upgradeAvatarFetterLevel(Player player, Avatar avatar, int expGain) {
        int level = avatar.getFetterLevel();
        int exp = avatar.getFetterExp();
        int reqExp = GameData.getAvatarFetterLevelExpRequired(level);
        while (expGain > 0 && reqExp > 0 && level < 10) {
            int toGain = Math.min(expGain, reqExp - exp);
            exp += toGain;
            expGain -= toGain;
            if (exp >= reqExp) {
                exp = 0;
                level++;
                reqExp = GameData.getAvatarFetterLevelExpRequired(level);
            }
        }
        avatar.setFetterLevel(level);
        avatar.setFetterExp(exp);
        avatar.save();
        player.sendPacket(new PacketAvatarPropNotify(avatar));
        player.sendPacket(new PacketAvatarFetterDataNotify(avatar));
    }

    @Deprecated(forRemoval = true)
    public void upgradeAvatarSkill(Player player, long guid, int skillId) {
        Avatar avatar = player.getAvatars().getAvatarByGuid(guid);
        if (avatar != null) {
            avatar.upgradeSkill(skillId);
        }
    }

    @Deprecated(forRemoval = true)
    public void unlockAvatarConstellation(Player player, long guid) {
        Avatar avatar = player.getAvatars().getAvatarByGuid(guid);
        if (avatar != null) {
            avatar.unlockConstellation();
        }
    }

    public void destroyMaterial(Player player, List<MaterialInfoOuterClass.MaterialInfo> list) {
        GameItem item;
        Int2IntOpenHashMap returnMaterialMap = new Int2IntOpenHashMap();
        Inventory inventory = player.getInventory();
        for (MaterialInfoOuterClass.MaterialInfo info : list) {
            if (info.getCount() > 0 && (item = inventory.getItemByGuid(info.getGuid())) != null && item.isDestroyable()) {
                inventory.removeItem(item, Math.min(info.getCount(), item.getCount()));
                ItemData data = item.getItemData();
                if (data.getDestroyReturnMaterial().length > 0) {
                    for (int i = 0; i < data.getDestroyReturnMaterial().length; i++) {
                        returnMaterialMap.addTo(data.getDestroyReturnMaterial()[i], data.getDestroyReturnMaterialCount()[i]);
                    }
                }
            }
        }
        if (returnMaterialMap.size() > 0) {
            returnMaterialMap.forEach(id, count -> {
                inventory.addItem(new GameItem(id.intValue(), count.intValue()));
            });
        }
        player.sendPacket(new PacketDestroyMaterialRsp(returnMaterialMap));
    }

    public synchronized GameItem useItem(Player player, long targetGuid, long itemGuid, int count, int optionId, boolean isEnterMpDungeonTeam) {
        ItemData itemData;
        Grasscutter.getLogger().debug("Attempting to use item from inventory");
        Avatar target = player.getAvatars().getAvatarByGuid(targetGuid);
        GameItem item = player.getInventory().getItemByGuid(itemGuid);
        if (item == null || item.getCount() < count || (itemData = item.getItemData()) == null) {
            return null;
        }
        UseItemParams params = new UseItemParams(player, itemData.getUseTarget(), target, count, optionId, isEnterMpDungeonTeam);
        params.usedItemId = item.getItemId();
        if (useItemDirect(itemData, params)) {
            player.getInventory().removeItem(item, count);
            List<C1378ItemUseAction> actions = itemData.getItemUseActions();
            if (actions != null) {
                actions.forEach(use -> {
                    use.postUseItem(params);
                });
            }
            Grasscutter.getLogger().debug("Item use succeeded!");
            return item;
        }
        Grasscutter.getLogger().debug("Item use failed!");
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: emu.grasscutter.game.systems.InventorySystem$1 */
    /* loaded from: grasscutter.jar:emu/grasscutter/game/systems/InventorySystem$1.class */
    public static /* synthetic */ class C13841 {
        static final /* synthetic */ int[] $SwitchMap$emu$grasscutter$game$props$ItemUseTarget = new int[ItemUseTarget.values().length];

        static {
            try {
                $SwitchMap$emu$grasscutter$game$props$ItemUseTarget[ItemUseTarget.ITEM_USE_TARGET_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$emu$grasscutter$game$props$ItemUseTarget[ItemUseTarget.ITEM_USE_TARGET_SPECIFY_AVATAR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$emu$grasscutter$game$props$ItemUseTarget[ItemUseTarget.ITEM_USE_TARGET_SPECIFY_ALIVE_AVATAR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$emu$grasscutter$game$props$ItemUseTarget[ItemUseTarget.ITEM_USE_TARGET_SPECIFY_DEAD_AVATAR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$emu$grasscutter$game$props$ItemUseTarget[ItemUseTarget.ITEM_USE_TARGET_CUR_AVATAR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$emu$grasscutter$game$props$ItemUseTarget[ItemUseTarget.ITEM_USE_TARGET_CUR_TEAM.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }
}
